### Cloud-contract-sample-producer service
A dummy producer service to try Spring's cloud contract, details at [link](https://cloud.spring.io/spring-cloud-contract/2.0.x/multi/multi__spring_cloud_contract_verifier_introduction.html).

## How to generate the contracts, build & run?
```shell script
mvn clean install
mvn spring-boot:run
```

## Where are the API contracts?
By convention the contracts stored on the producer side, but also used by the [consumer side](https://github.com/kovaku/cloud-contract-sample-consumer).
