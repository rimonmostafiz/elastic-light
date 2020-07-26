#!/bin/sh

curl -H "Content-Type: application/json" -XPOST "localhost:9200/bank/_doc/_bulk?pretty&refresh" --data-binary "@src/test/resources/data/accounts.json"

curl "localhost:9200/_cat/indices?v"