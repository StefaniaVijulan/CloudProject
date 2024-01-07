package com.example.order.repository;

import com.example.order.model.Recorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecorderRepository extends JpaRepository<Recorder, Integer> {

}
