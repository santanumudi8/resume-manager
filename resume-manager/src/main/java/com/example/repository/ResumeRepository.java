package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long>{

}
