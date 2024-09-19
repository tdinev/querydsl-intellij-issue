# QueryDsl & IntelliJ Idea issue

## 💡 Description

This Spring Boot 3 application handles **payment initiation, payment consultation, and payment relaunch** requests in the context of PID.
To that end, it relays the final execution of those requests to _paiement-exec_, which presides Luxhub.

## 🚄 Runtime environment

### OS

```powershell
PS C:\Users\u197td> [Environment]::OSVersion

Platform ServicePack Version      VersionString
-------- ----------- -------      -------------
 Win32NT             10.0.19045.0 Microsoft Windows NT 10.0.19045.0
```

### JDK

```bash
$ ./java -version
java version "17.0.7" 2023-04-18 LTS
Java(TM) SE Runtime Environment (build 17.0.7+8-LTS-224)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.7+8-LTS-224, mixed mode, sharing)
```

### Gradle

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

## 💥 Reproduce error

Execute the Gradle task `compileJava`, which depends on the task `compileQuerydsl`.