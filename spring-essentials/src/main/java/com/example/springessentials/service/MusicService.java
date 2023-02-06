package com.example.springessentials.service;

import com.example.springessentials.domain.Music;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MusicService {

    private List<Music> songs = List.of(new Music(1L,"Your Song"), new Music(2L, "Tiny Dancer"));
    public List<Music> listAll() {
        return songs;
    }

    public Music findById(long id) {
        return songs
                .stream()
                .filter(song -> song.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Song not found!"));
    }
}
