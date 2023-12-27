## eureka.client.register-with-eureka=false
* By writing this line you are saying to your discovery service
app that,there is no need to register yourself in your discovery
server registry. 
* I know your port number and ip and i know how to connect with you.
* You are here to discover other microservice not yourself.

## eureka.client.fetch-registry=false
By writing this you are saying discovery service that no need fetch any registry from another discovery service.
you are the only one here.

Note:There are multiple zone inside a single region of AWS

### Example:
                                         Virginia, US
                                       us-east-1(region)
   
   Service A   Service B                 Service A     Service B             Service A    Service B
   Service A   Service B                 Service A                                        Service B
      us-east-1a(zone)                          us-east-1b(Zone)                 us-east-1c
   
Conclusion:There is multiple Zone inside a single region and inside the zone there is multiple service and For each Zone there is one discovery server.
and that discovery server is communicated with each other.

Note:All service are deployed inside a same region.If one service is deployed in one region
     and other service is deployed in other region then there is problem of latency. And it is not good practise
   

## DATABASE CALL And RestTemplate::block the code flow till the response received
  
## Open feign
## Feign client
    1.add openFeign dependency
## Load balancer  
    