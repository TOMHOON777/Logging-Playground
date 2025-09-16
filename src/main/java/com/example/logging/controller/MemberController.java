package com.example.logging.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.logging.entity.MemberEntity;
import com.example.logging.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class MemberController {

  private static final Logger log = LoggerFactory.getLogger(MemberController.class);
  
  private final MemberRepository memberRepository;

  @GetMapping("/test")
  public String getMethodName(@RequestParam String param) {

    MemberEntity e = new MemberEntity(1L, "name");
    memberRepository.save(e);

    log.info("info 레벨 로그");
    log.warn("warn 레벨 로그");
    log.error("error 레벨 로그");
    log.debug("debug 레벨 로그");
    log.trace("trace 레벨 로그");
    
    memberRepository.findAll();

    return new String();
  }
  

}
