package com.example.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.logging.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
  
}
