# Kotlin Mockk Bug Repro

Small repository to reproduce an issue with mockk and Kotlin 1.7.20+

To reproduce:

```
$ mvn clean verify -Dkotlin.version=1.7.21
```
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running de.stuebingerb.ProductRepositoryTest
Nov. 23, 2022 2:10:42 PM io.mockk.impl.log.JULLogger warn
WARNUNG: Failed to transform class de/stuebingerb/AbstractPersistence
java.lang.StackOverflowError
        at java.base/java.util.StringJoiner.<init>(StringJoiner.java:105)
        at java.base/java.lang.reflect.Modifier.toString(Modifier.java:229)
        at net.bytebuddy.description.method.MethodDescription$AbstractBase.toString(MethodDescription.java:998)
        at java.base/java.lang.String.valueOf(String.java:4213)
        at java.base/java.lang.StringBuilder.append(StringBuilder.java:173)
        at net.bytebuddy.description.TypeVariableSource$AbstractBase.findExpectedVariable(TypeVariableSource.java:174)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor$ForAttachment.onTypeVariable(TypeDescription.java:2062)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor$ForAttachment.onTypeVariable(TypeDescription.java:1973)
        at net.bytebuddy.description.type.TypeDescription$Generic$OfTypeVariable$Symbolic.accept(TypeDescription.java:5931)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor.onParameterizedType(TypeDescription.java:1908)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor$ForAttachment.onParameterizedType(TypeDescription.java:1973)
        at net.bytebuddy.description.type.TypeDescription$Generic$OfParameterizedType.accept(TypeDescription.java:5134)
        at net.bytebuddy.description.method.ParameterDescription$Latent.getType(ParameterDescription.java:805)
        at net.bytebuddy.description.method.ParameterList$AbstractBase.asTypeList(ParameterList.java:107)
        at net.bytebuddy.description.method.MethodDescription$AbstractBase.toString(MethodDescription.java:1006)
        at java.base/java.lang.String.valueOf(String.java:4213)
        at java.base/java.lang.StringBuilder.append(StringBuilder.java:173)

        ...
        
        at net.bytebuddy.description.TypeVariableSource$AbstractBase.findExpectedVariable(TypeVariableSource.java:174)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor$ForAttachment.onTypeVariable(TypeDescription.java:2062)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor$ForAttachment.onTypeVariable(TypeDescription.java:1973)
        at net.bytebuddy.description.type.TypeDescription$Generic$OfTypeVariable$Symbolic.accept(TypeDescription.java:5931)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor.onParameterizedType(TypeDescription.java:1908)
        at net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Substitutor$ForAttachment.onParameterizedType(TypeDescription.java:1973)
        at net.bytebuddy.description.type.TypeDescription$Generic$OfParameterizedType.accept(TypeDescription.java:5134)
        at net.bytebuddy.description.method.ParameterDescription$Latent.getType(ParameterDescription.java:805)
        at net.bytebuddy.description.method.ParameterList$AbstractBase.asTypeList(ParameterList.java:107)
        at net.bytebuddy.description.method.MethodDescription$AbstractBase.toString(MethodDescription.java:1006)
        at java.base/java.lang.String.valueOf(String.java:4213)
        at java.base/java.lang.StringBuilder.append(StringBuilder.java:173)
        at net.bytebuddy.description.TypeVariableSource$AbstractBase.findExpectedVariable(TypeVariableSource.java:174)

[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 2.89 s <<< FAILURE! - in de.stuebingerb.ProductRepositoryTest
[ERROR] test  Time elapsed: 2.839 s  <<< ERROR!
io.mockk.MockKException:
Failed matching mocking signature for

left matchers: [any()]
        at de.stuebingerb.ProductRepositoryTest.test(ProductRepositoryTest.kt:31)

[INFO]
[INFO] Results:
[INFO]
[ERROR] Errors:
[ERROR]   ProductRepositoryTest.test:31 » MockK Failed matching mocking signature for

l...
[INFO]
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
```

Works with Kotlin 1.7.10:
```
$ mvn clean verify -Dkotlin.version=1.7.10
```
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running de.stuebingerb.ProductRepositoryTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.63 s - in de.stuebingerb.ProductRepositoryTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
