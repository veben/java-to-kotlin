# Java to Kotlin

> Allow to test migration of a Microservice named Order, from Java to Kotlin

> Created and maintained by veben

## 📜 Table of Contents

1. [Tools Setup](#tools-setup)
2. [Java Order in depth](java-order/README.md)
3. [Kotlin Order in depth](kotlin-order/README.md)
4. [Troubleshooting](#troubleshooting)

## 1. ⚙ Tools Setup

#### 🐳 Docker Desktop for Windows

- [Download](https://download.docker.com/win/stable/Docker%20Desktop%20Installer.exe)
- Install
  > Check your current version:

```sh
 docker --version
```

- Docker settings
  - Shared drives **C**
  - Expose daemon on **tcp://localhost:2375**
- Intellij settings (Optional) `Build, Execution, Deployment" > "Docker`
  - Change configuration:
    - Name: Docker
    - TCP socket: checked
    - Engine API URL: `tcp/localhost:2375`

## 4. 🛠 Troubleshooting

Since you two services uses the same ports, they cannot ba launched at the same time.
The following ports have to not be in use:

- **8091**: for Order MS
- **5434**: for Developer PostgreSQL database