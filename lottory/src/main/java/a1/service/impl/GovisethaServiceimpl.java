package a1.service.impl;

import a1.dto.GovisethaDto;
import a1.entity.Govisetha;
import a1.repo.Govisetharepo;
import a1.service.GovisethaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class GovisethaServiceimpl implements GovisethaService {

    @Autowired
    private Govisetharepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveGlottory(GovisethaDto dto) {
        if (!repo.existsById(dto.getGlid())) {
            repo.save(mapper.map(dto, Govisetha.class));
        } else {
            throw new RuntimeException("Driver Already Exist...!");
        }
    }

    @Override
    public GovisethaDto searchGlottory(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), GovisethaDto.class);
        } else {
            throw new RuntimeException("No Driver For" + id + "...!");
        }
    }

    @Override
    public List<GovisethaDto> getAllGlottory() {
        return mapper.map(repo.findAll(), new TypeToken<List<GovisethaDto>>() {

        }.getType());
    }
}

