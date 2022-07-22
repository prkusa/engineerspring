package com.db.engineer.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.engineer.model.EngineerModel;

@Repository
public interface EngineerRepo extends JpaRepository<EngineerModel,Long> {

}
