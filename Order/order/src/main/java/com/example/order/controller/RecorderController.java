package com.example.order.controller;

import com.example.order.dto.recorder.RecorderRequest;
import com.example.order.dto.recorder.RecorderResponse;
import com.example.order.model.Recorder;
import com.example.order.service.recorder.RecorderServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recorder")
public class RecorderController {

    private final RecorderServiceInt recorderServiceInt;

    public RecorderController(RecorderServiceInt recorderServiceInt) {
        this.recorderServiceInt = recorderServiceInt;
    }

    @PostMapping
    public RecorderResponse addRecorder(@RequestBody RecorderRequest recorder, @RequestParam Integer idOrder){
        return recorderServiceInt.addRecorder(recorder, idOrder);
    }

    @PutMapping
    public RecorderResponse editRecorder(@RequestBody RecorderRequest recorder, @RequestParam Integer idRecorder){
        return  recorderServiceInt.editRecorder(recorder, idRecorder);
    }

    @DeleteMapping
    public String deleteRecorder(@RequestParam Integer idRecorder){

        return recorderServiceInt.deleteRecorder(idRecorder);
    }

    @GetMapping
    public List<Recorder> getAllRecorder(){
        return recorderServiceInt.getAllRecorders();
    }

}
