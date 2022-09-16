package a1.service.impl;

import a1.dto.JayodaDto;
import a1.entity.Jayoda;
import a1.repo.Jayodarepo;
import a1.service.JayodaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class JayodaServiceimpl implements JayodaService {

    @Autowired
    private Jayodarepo repo;

    @Autowired
    private ModelMapper mapper;



    @Override
    public void saveJLottory(JayodaDto dto) {
        if (!repo.existsById(dto.getJlid())) {
            repo.save(mapper.map(dto, Jayoda.class));
        } else {
            throw new RuntimeException("Driver Already Exist...!");
        }
    }

    @Override
    public JayodaDto searchJlottory(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(),JayodaDto.class);
        } else {
            throw new RuntimeException("No Driver For" + id + "...!");
        }
    }

    @Override
    public List<JayodaDto> getAllJLottory() {
        return mapper.map(repo.findAll(), new TypeToken<List<JayodaDto>>(){

        }.getType());
    }
}
