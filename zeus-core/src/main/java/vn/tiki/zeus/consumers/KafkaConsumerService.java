package vn.tiki.zeus.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutionException;

public interface KafkaConsumerService {
    int BATCH_SIZE = 1000;

    void consume(String event, Integer partitionId, Long offset) throws JsonProcessingException, ExecutionException, InterruptedException;
}
