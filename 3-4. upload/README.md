# Object upload and DoS protection

## Lab 3. Object upload

Compile UploadManager:
```
javac UploadManager.java
```

Compile and execute SerialGenerator to generate planet data:
```
javac SerialGenerator.java
java SerialGenerator
```

Feed the serialized planets to UploadManager:
```
echo <data> | java UploadManager
...
```

You can just pipe all data from SerialGenerator to UploadManager:
```
java SerialGenerator | java UploadManager
```

Uncomment bad stuff in SerialGenerator, recompile and pipe the new data to UploadManager:
```
java SerialGenerator | java UploadManager
```

The above command never exits. In a different shell, see what's consuming 100% CPU:
```
top
```
(press 'c' to make _top_ display the process' command line)

More DoS payloads:
- https://www.owasp.org/index.php/Deserialization_of_untrusted_data
- https://topolik-at-work.blogspot.com/2016/04/java-deserialization-dos-payloads.html

Try a few:
```
java UploadManager < topolik/...
```

## Lab 4. Malicious upload protection

Take a look at SafeObjectInputStream.java

Replace oIn in UploadManager.java:
```
    SafeObjectInputStream oIn = new SafeObjectInputStream(bIn);
```

Recompile UploadManager and try it again:
```
javac UploadManager.java
java SerialGenerator | java UploadManager
```

It should now exit with an error instead of hanging.
