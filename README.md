# QueryDsl & IntelliJ Idea issue

## 💡 Description

Minimal example showing an IntelliJ Idea issue in connection with QueryDsl (http://querydsl.com/) and Gradle.

## 🚄 Runtime environment

### OS

Windows 10:

```powershell
PS C:\Users\u197td> [Environment]::OSVersion

Platform ServicePack Version      VersionString
-------- ----------- -------      -------------
 Win32NT             10.0.19045.0 Microsoft Windows NT 10.0.19045.0
```

### JDK

Oracle JDK 17:

```bash
$ ./java -version
java version "17.0.7" 2023-04-18 LTS
Java(TM) SE Runtime Environment (build 17.0.7+8-LTS-224)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.7+8-LTS-224, mixed mode, sharing)
```

### Gradle

Gradle 8.10.1:

```bash
$ ./gradlew --version

------------------------------------------------------------
Gradle 8.10.1
------------------------------------------------------------

Build time:    2024-09-09 07:42:56 UTC
Revision:      8716158d3ec8c59e38f87a67f1f311f297b79576

Kotlin:        1.9.24
Groovy:        3.0.22
Ant:           Apache Ant(TM) version 1.10.14 compiled on August 16 2023
Launcher JVM:  17.0.7 (Oracle Corporation 17.0.7+8-LTS-224)
Daemon JVM:    C:\Java\jdk-17.0.7 (no JDK specified, using current Java home)
OS:            Windows 10 10.0 amd64
```


### IntelliJ Idea

IntelliJ Idea 2024.2.2 Community Edition, portable version (i.e., ZIP download from https://download.jetbrains.com/idea/ideaIC-2024.2.2.win.zip):

```properties
IntelliJ IDEA 2024.2.2 (Community Edition)
Build #IC-242.22855.74, built on September 18, 2024
Runtime version: 21.0.3+13-b509.15 amd64 (JCEF 122.1.9)
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Toolkit: sun.awt.windows.WToolkit
Windows 10.0
GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation
Memory: 4062M
Cores: 12
Registry:
ide.experimental.ui=true
i18n.locale=
Non-Bundled Plugins:
com.layoutmanager (1.4.0)
Key Promoter X (2024.2.0)
org.asciidoctor.intellij.asciidoc (0.42.2)
org.sonarlint.idea (10.8.1.79205)
Kotlin: 242.22855.74-IJ
```

## 💥 Reproduction of problem

1. Execute the Gradle task `compileJava`, which depends on the task `compileQuerydsl`.
1. QueryDsl Q models are generated in the top-level directory `generated-src`. This represents a _module_ named `querydsl` in IntelliJ Idea.
1. Issues:
   * Neither the `main` module depends on the `querydsl` module, nor vice-versa:
   ![querydsl module dependences][querydsl-dependencies]
   * The  `querydsl` module does not have any of the dependencies of the `main` module, not even its own QueryDsl jars are present.
   ![main module dependences][main-dependencies]
   * This leads to both compilation errors in the Q models in IntelliJ Idea:
   ![Q model compulation errors][q-models-compilation]
   as well as
   ![main compulation errors][main-compilation]

[querydsl-dependencies]: docs/querydsl-module-dependencies.png
[main-dependencies]: docs/main-module-dependencies.png
[q-models-compilation]: docs/q-model-compilation-error.png
[main-compilation]: docs/compilation-error.png
