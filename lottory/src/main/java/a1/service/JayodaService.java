package a1.service;

import a1.dto.JayodaDto;

import java.util.List;

public interface JayodaService {
    void saveJLottory(JayodaDto dto);

    JayodaDto searchJlottory(String id);

    List<JayodaDto> getAllJLottory();
}
