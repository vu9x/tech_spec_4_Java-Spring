package ru.gb.springbootseminar3.grafanametrics;

import io.micrometer.core.instrument.Counter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.MeterRegistry;

@Component
@Data
public class CustomMetrics {

    private final Counter issuedBooks;
    private final Counter failedToIssueBooks;


    @Autowired
    public CustomMetrics(MeterRegistry meterRegistry) {
        this.issuedBooks = meterRegistry.counter("custom_issued_books");
        this.failedToIssueBooks = meterRegistry.counter("custom_failed_to_issue");
//        this.issuedBooks = Counter.builder("custom_issued_books").description("Количество выданных книг")
//                .register(meterRegistry);
//
//        this.failedToIssueBooks = Counter.builder("custom_failed_to_issue").description("Количество ошибок при выдаче книг")
//                .register(meterRegistry);
    }
}
