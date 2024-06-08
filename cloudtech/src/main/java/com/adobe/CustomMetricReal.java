package com.adobe;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.List.of;


@RestController
public class CustomMetricReal
{
    @Autowired
    MeterRegistry meterRegistry;

    @Bean
    public Map<String, String> map1() {
        return Map.of(
                "va6", "US",
                "va7", "VA7",
                "irl1", "EU",
                "jpn3", "AP"
        );
    }

//    @Autowired
    Map<String, String> mp = map1();


    @Bean
    public Map<String, DockerClient> map2_creation(Map<String, String> map1)
    {
        Map<String, DockerClient> map2 = map1.entrySet().stream() //streamlined the map entries
                .collect(Collectors.toMap(Map.Entry::getKey, //collects the stream of entries into a new map
                        entry -> DockerClientBuilder.getInstance(entry.getValue()).build()));

        return map2;
        //      [!] try without entrySet and stream methods
    }

    @Bean
    public Map<String, Double> map3_creation(Map<String, DockerClient> map2)
    {
        Map<String, Double> map3 = map2.entrySet().stream() //streamlined the map entries
                .collect(Collectors.toMap(Map.Entry::getKey, //collects the stream of entries into a new map
                        entry -> numberOfRunningContainersInARegion(entry.getValue())));

        return map3;
        //      [!] try without entrySet and stream methods
    }

    @Bean
    private Double numberOfRunningContainersInARegion(DockerClient client_obj){
        try{
            List<Container> containerList = client_obj.listContainersCmd().withStatusFilter(of("running").toString()).exec();
            return (double) containerList.size();
        }
        catch (DockerException e){
            return (Double) (double) -1;
        }
    }
 
    @Bean
    public double average(Map<String, Double> map3)
    {
        double sz = map3.size();
        double sum=0;

        for(Map.Entry<String, Double> entry : map3.entrySet())
        {
            double num = entry.getValue();
            sum+=num;
        }

        return sum/sz;
    }

//    @GetMapping("/runningcustom")
//    public Gauge avg_runningContainerGauge(Map<String, Double> map3){
//        return Gauge.builder("docker.avg.running.containers", () -> average(map3)) //check which func to be called
//                .description("Number of average running docker containers")
//                .register(meterRegistry);
//    }

    @GetMapping("/runningcustom")
    public String avg_runningContainerGauge(Map<String, Double> map3)
    {
        meterRegistry.gauge("avg_running_containers", average(map3));
        return "you made it";
    }


}