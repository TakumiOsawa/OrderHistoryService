package com.ftgo.OrderHistoryService.config;

import com.ftgo.OrderHistoryService.OrderHistoryService;
import com.ftgo.OrderHistoryService.event.ViewEventConsumer;
import io.eventuate.tram.consumer.common.DuplicateMessageDetector;
import io.eventuate.tram.consumer.common.NoopDuplicateMessageDetector;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.messaging.producer.MessageProducer;
import io.eventuate.tram.sagas.orchestration.SagaInstanceFactory;
import io.eventuate.tram.sagas.spring.orchestration.SagaOrchestratorConfiguration;
import io.eventuate.tram.sagas.spring.participant.SagaParticipantConfiguration;
import io.eventuate.tram.spring.consumer.kafka.EventuateTramKafkaMessageConsumerConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import({TramEventsPublisherConfiguration.class,
        TramMessageProducerJdbcConfiguration.class,
        EventuateTramKafkaMessageConsumerConfiguration.class,
        TramEventSubscriberConfiguration.class})
public class OrderHistoryConfiguration {
    @Bean
    public OrderHistoryService orderHistoryService(RestTemplate restTemplate,
                                                   DomainEventPublisher eventPublisher,
                                                   MessageProducer messageProducer) {
        return new OrderHistoryService(restTemplate, eventPublisher, messageProducer);
    }

    @Bean
    public DuplicateMessageDetector duplicateMessageDetector() {
        return new NoopDuplicateMessageDetector();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ViewEventConsumer orderHistoryEventHandlers(OrderHistoryService orderHistoryService) {
        return new ViewEventConsumer(orderHistoryService);
    }

    @Bean
    public DomainEventDispatcher orderHistoryDomainEventDispatcher(
            ViewEventConsumer viewEventConsumer,
            DomainEventDispatcherFactory domainEventDispatcherFactory) {
        return domainEventDispatcherFactory.make("viewDomainEventDispatcher",
                viewEventConsumer.orderEventHandlers());
    }
}
