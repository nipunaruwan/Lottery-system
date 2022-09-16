package a1.service;

import a1.dto.GovisethaDto;

import java.util.List;

public interface GovisethaService {
    void saveGlottory(GovisethaDto dto);

    GovisethaDto searchGlottory(String id);

    List<GovisethaDto> getAllGlottory();

}

