# Mica MQTT Server Native

Mica MQTT Server Native 是一个基于 Mica MQTT Server 的高性能消息服务器，支持 TCP、HTTP 和 WebSocket 协议。此外，它还支持使用 GraalVM 构建成二进制文件。

## 构建过程

### 安装 GraalVM

1. 下载并解压 GraalVM:

   ```shell
   wget https://download.oracle.com/graalvm/21/latest/graalvm-jdk-21_linux-x64_bin.tar.gz
   mkdir -p ~/program/
   tar -xf graalvm-jdk-21_linux-x64_bin.tar.gz -C ~/program/
   ```

2. 配置环境变量:

   ```shell
   export JAVA_HOME=~/program/graalvm-jdk-21.0.1+12.1
   export GRAALVM_HOME=~/program/graalvm-jdk-21.0.1+12.1
   export PATH=$JAVA_HOME/bin:$PATH
   ```

### 安装 Maven

1. 下载并解压 Maven:

   ```shell
   wget https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.zip
   unzip apache-maven-3.8.8-bin.zip -d ~/program/
   ```

2. 配置环境变量:

   ```shell
   export MVN_HOME=~/program/apache-maven-3.8.8/
   export PATH=$MVN_HOME/bin:$PATH
   ```

### 获取代码

```shell
git clone https://github.com/litongjava/mica-mqtt-server-native.git
cd mica-mqtt-server-native/
```

### 构建 Java Jar (可选)

```shell
mvn package
java -jar target/mica-mqtt-server-native.jar
```

### 构建二进制镜像

```shell
mvn clean package -DskipTests -Pmqtt-server-graal
```

该项目在 GraalVM JDK 21 和 GraalVM JDK 17.0.9+11.1 上测试成功。