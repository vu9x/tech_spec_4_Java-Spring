package ru.gb;

import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gb.dto.BookDTO;
import ru.gb.dto.ReaderDTO;

import java.util.UUID;

@Slf4j
@Component
public class BookProvider {

    private final WebClient webClient;
//    private final EurekaClient eurekaClient;

    public BookProvider(EurekaClient eurekaClient,
                        ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction){
        this.webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
//        this.eurekaClient = eurekaClient;
    }

    public BookDTO getRandomBook(){
        BookDTO randomBookDTO = webClient.get()
//                .uri("http://localhost:8180/book/random")
//                .uri(getBookServiceIp() + "/book/random")
                .uri("http://book-service/book/random")
                .retrieve()
                .bodyToMono(BookDTO.class)
                .block();

        return randomBookDTO;
    }

    public ReaderDTO getRanDomReader(){
        ReaderDTO readerDTO = webClient.get()
                .uri("http://reader-service/reader/random")
                .retrieve()
                .bodyToMono(ReaderDTO.class)
                .block();

        return readerDTO;
    }

//    private String getBookServiceIp(){
//        Application application = eurekaClient.getApplication("BOOK-SERVICE");
//        List<InstanceInfo> instanceInfos = application.getInstances();
//
//        log.info("Микросервисы внутри Эврики: " + instanceInfos.toString());
//
//        Random random = new Random();
//        InstanceInfo randomInstance = instanceInfos.get(random.nextInt(instanceInfos.size()));
//        return "http://" + randomInstance.getIPAddr() + ":" + randomInstance.getPort();
//    }

}
