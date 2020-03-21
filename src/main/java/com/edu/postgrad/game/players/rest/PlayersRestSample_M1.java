//package com.edu.postgrad.game.players;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping(path = "/tournaments", produces = "application/json")
//public class PlayersRestSample {
//
//    @Autowired
//    DiscoveryClient discoveryClient;
//
//    @GetMapping("hello")
//    public ResponseEntity<String> hello(){
//        RestTemplate restTemplate = new RestTemplate();
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("teams-service");
//        System.err.println(serviceInstances.size());
//        System.out.println(serviceInstances.size());
//        String serviceURI = String.format("%s/teams",
//                serviceInstances.get(0).getUri().toString());
//        /*String serviceURI = String.format("%s/hello",
//                serviceInstances.get(0).getUri().toString());*/
//        System.err.println(serviceURI);
//        System.out.println(serviceURI);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(serviceURI, HttpMethod.GET, null,
//                String.class);
//
//        return responseEntity;
//    }
//}
