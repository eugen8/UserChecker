# Commands

```bash
curl -s http://localhost:8080/users | jq '.'
```




```bash
curl -v -X POST  http://localhost:8080/user \
 -H "Content-Type: application/json" \
  -d '{"firstName":"John"}'
```