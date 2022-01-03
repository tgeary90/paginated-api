
# Use
```
tomg @ UK3169095W1 /mnt/c/src/HMRC/breathing_space/forks/breathing-space-if-acceptance-tests (bs-529-coding-out-acceptance-tests)
└─ $ ▶ curl -XPOST -H "Content-Type: application/json" --data '[{"taxYear":"2001","amount":38383.22,"source":"UK PAYE"},{"taxYear":"2021","amount":3433.1,"source":"UK SA"}]' http://localhost:9000/underpayments/AS00000A1/fc2576a8-66f6-11ec-83c6-60f262c313dc/bulk
{"message":"Saving Underpayments: List(Underpayment(2001,38383.22,UK PAYE), Underpayment(2021,3433.1,UK SA))"}tomg @ UK3169095W1 /mnt/c/src/HMRC/breathing_space/forks/breathing-space-if-acceptance-tests (bs-529-coding-out-acceptance-tests)
└─ $ ▶ curl -XGET http://localhost:9000/underpayments/AS00000A1/fc2576a8-66f6-11ec-83c6-60f262c313d
c
[{"taxYear":"2001","amount":38383.22,"source":"UK PAYE"},{"taxYear":"2021","amount":3433.1,"source":"UK SA"}]tomg @ UK3169095W1 /mnt/c/src/HMRC/breathing_space/forks/breathing-space-if-acceptance-tests (bs-529-coding-out-acceptance-tests)
└─ $ ▶ curl -XPOST -H "Content-Type: application/json" --data '{"taxYear":"2016","amount":8383.30,"source":"UK SA"}' http://localhost:9000/underpayments/AS00000A2/fc2576a8-66f6-11ec-83c6-60f262c313d
c
{"message":"Saving Underpayment: Underpayment(2016,8383.3,UK SA)"}tomg @ UK3169095W1 /mnt/c/src/HMRC/breathing_space/forks/breathing-space-if-acceptance-tests (bs-529-coding-out-acceptance-tests)
└─ $ ▶ curl -XGET http://localhost:9000/underpayments/AS00000A2/fc2576a8-66f6-11ec-83c6-60f262c313d
c
[{"taxYear":"2016","amount":8383.3,"source":"UK SA"}]tomg @ UK3169095W1 /mnt/c/src/HMRC/breathing_space/forks/breathing-space-if-acceptance-tests (bs-529-coding-out-acceptance-tests)
└─ $ ▶ curl -XGET http://localhost:9000/underpayments/AS00000A2/fc2576a8-66f6-11ec-83c6-60f262c313dc
```
