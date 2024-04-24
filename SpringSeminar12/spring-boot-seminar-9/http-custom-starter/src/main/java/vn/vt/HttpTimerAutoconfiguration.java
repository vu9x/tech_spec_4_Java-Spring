package vn.vt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpTimerAutoconfiguration {

    @Bean
    TimerFilter timerFilter(){
        return new TimerFilter();
    }

    @Bean
    TimerAspect timerAspect(){
        return new TimerAspect();
    }

}
