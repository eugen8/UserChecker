# Commands

```bash
curl -s http://localhost:8080/users | jq '.'
```




Valid request
```shell
curl -X POST  http://localhost:8080/user \
 -H "Content-Type: application/json" \
  -d '{"firstName":"John", "phoneNumber":"14152007986", "email":"eugen@gmail.com"}' | jq '.'
```

Invalid user
```shell
curl -s -X POST  http://localhost:8080/user \
 -H "Content-Type: application/json" \
  -d '{"firstName":"John", "phoneNumber":"1234", "email":"eugen@gmail.com"}' \
 | jq '.'
```

Underlying service throws an exception example
```shell
curl -v -s http://localhost:8080/user \
 -H "Content-Type: application/json" \
  -d '{"firstName":"John", "phoneNumber":"000", "email":"eugen@gmail.com"}' \
| jq -r

# RESPONSE:
#*   Trying 127.0.0.1:8080...
#* Connected to localhost (127.0.0.1) port 8080 (#0)
#> POST /user HTTP/1.1
#> Host: localhost:8080
#> User-Agent: curl/7.88.1
#> Accept: */*
#> Content-Type: application/json
#> Content-Length: 68
#> 
#} [68 bytes data]
#< HTTP/1.1 500 
#< Content-Type: text/plain;charset=UTF-8
#< Content-Length: 33
#< Date: Fri, 09 Feb 2024 04:32:21 GMT
#< Connection: close
#< 
#{ [33 bytes data]
#* Closing connection 0
#{
#  "error": "Internal Server Error"
#}

```

