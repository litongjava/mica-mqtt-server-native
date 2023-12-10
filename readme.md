# Mica MQTT Server Native

Mica MQTT Server Native is a high-performance messaging server based on Mica MQTT Server, supporting TCP, HTTP, and WebSocket protocols. It also supports building into binary files using GraalVM.

## Build Process

### Install GraalVM

1. Download and extract GraalVM:

   ```shell
   wget https://download.oracle.com/graalvm/21/latest/graalvm-jdk-21_linux-x64_bin.tar.gz
   mkdir -p ~/program/
   tar -xf graalvm-jdk-21_linux-x64_bin.tar.gz -C ~/program/
   ```

2. Set environment variables:

   ```shell
   export JAVA_HOME=~/program/graalvm-jdk-21.0.1+12.1
   export GRAALVM_HOME=~/program/graalvm-jdk-21.0.1+12.1
   export PATH=$JAVA_HOME/bin:$PATH
   ```

### Install Maven

1. Download and extract Maven:

   ```shell
   wget https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.zip
   unzip apache-maven-3.8.8-bin.zip -d ~/program/
   ```

2. Set environment variables:

   ```shell
   export MVN_HOME=~/program/apache-maven-3.8.8/
   export PATH=$MVN_HOME/bin:$PATH
   ```

### Download Code

```shell
git clone https://github.com/litongjava/mica-mqtt-server-native.git
cd mica-mqtt-server-native/
```

### Build Java Jar (Optional)

```shell
mvn package
java -jar target/mica-mqtt-server-native.jar
```

### Build Binary Image

```shell
mvn clean package -DskipTests -Pmqtt-server-graal
```

Successfully tested on GraalVM JDK 21 and GraalVM JDK 17.0.9+11.1.

