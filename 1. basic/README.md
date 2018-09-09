# Lab 1. Serializable class

Compile and execute BasicSerialize:
```
javac BasicSerialize.java
java BasicSerialize
```

Take a look at the created file in hex and notice the pattern "ac ed 00 05":
```
xxd -g 1 earth.ser
```

See the file in Base64 and notice the pattern "rO0AB":
```
base64 earth.ser
```

Another tool to analyze Java serialized data:
```
java -jar ../jdeserialize-1.2.jar earth.ser
```
