package com.example.order.service.recorder;


import com.example.order.dto.recorder.RecorderRequest;
import com.example.order.dto.recorder.RecorderResponse;
import com.example.order.model.Recorder;

import java.util.List;

public interface RecorderServiceInt {

    public RecorderResponse addRecorder(RecorderRequest recorder, Integer idOrder);
    public RecorderResponse editRecorder(RecorderRequest recorderRequest, Integer idRecorder);
    public String deleteRecorder(Integer idRecorder);
    public List<Recorder> getAllRecorders();
}
