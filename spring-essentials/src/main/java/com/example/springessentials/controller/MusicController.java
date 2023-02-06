package com.example.springessentials.controller;

import com.example.springessentials.domain.Music;
import com.example.springessentials.service.MusicService;
import com.example.springessentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("musics")
@Log4j2
@RequiredArgsConstructor
public class MusicController {
    private final DateUtil dateUtil;
    private final MusicService musicService;

    @GetMapping
    public ResponseEntity<List<Music>> list() {
        log.info(dateUtil.formatLocalDateTimeToDbStyle(LocalDateTime.now()));
        return ResponseEntity.ok(musicService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Music> findById(@PathVariable long id) {
        //log.info(dateUtil.formatLocalDateTimeToDbStyle(LocalDateTime.now()));
        return ResponseEntity.ok(musicService.findById(id));
    }
}
