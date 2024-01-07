package com.example.order.service.recorder;


import com.example.order.dto.recorder.RecorderRequest;
import com.example.order.dto.recorder.RecorderResponse;
import com.example.order.exception.Custom;
import com.example.order.model.Order;
import com.example.order.model.Recorder;
import com.example.order.repository.OrderRepository;
import com.example.order.repository.RecorderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecorderService implements RecorderServiceInt{

    private final RecorderRepository recorderRepository;

    private final OrderRepository orderRepository;

    public RecorderService(RecorderRepository recorderRepository, OrderRepository orderRepository) {
        this.recorderRepository = recorderRepository;
        this.orderRepository = orderRepository;
    }

    public RecorderResponse addRecorder(RecorderRequest recorder, Integer idOrder){

        Order order =  orderRepository.findById(idOrder).orElseThrow(
                () -> new Custom("This order cannot be find"));
        Recorder recorder1 = new Recorder();
        recorder1.setDateExpected(recorder.getDateExpected());
        recorder1.setDateRecorded(recorder.getDateRecorded());
        recorder1.setOrder(order);
        recorderRepository.save(recorder1);

        RecorderResponse recorderResponse = new RecorderResponse();
        recorderResponse.setDateRecorded(recorder1.getDateRecorded());
        recorderResponse.setDateExpected(recorder1.getDateExpected());
        return recorderResponse;
    }
    public RecorderResponse editRecorder(RecorderRequest recorderRequest, Integer idRecorder){

        Recorder recorder1 =  recorderRepository.findById(idRecorder).orElseThrow(
                () -> new Custom("This recorder doesnt exist"));
        recorder1.setDateRecorded(recorderRequest.getDateRecorded());
        recorder1.setDateExpected(recorderRequest.getDateExpected());

        recorderRepository.save(recorder1);

        RecorderResponse recorderResponse = new RecorderResponse();
        recorderResponse.setDateExpected(recorder1.getDateExpected());
        recorderResponse.setDateRecorded(recorder1.getDateRecorded());
        return recorderResponse;
    }
    public String deleteRecorder(Integer idRecorder){
        Recorder recorder1 =  recorderRepository.findById(idRecorder).orElseThrow(
                () -> new Custom("This recorder doesnt exist"));
        recorderRepository.delete(recorder1);
        return "Successfully delete";
    }
    public List<Recorder> getAllRecorders(){
        return recorderRepository.findAll();
    }
}
