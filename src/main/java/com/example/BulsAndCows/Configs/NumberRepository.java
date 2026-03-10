package com.example.BulsAndCows.Configs;

import com.example.BulsAndCows.Entity.NumberInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NumberRepository extends JpaRepository<NumberInfo, Long> {

}
