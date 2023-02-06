package com.example.springessentials.repository;

import com.example.springessentials.domain.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> listAll();
}
