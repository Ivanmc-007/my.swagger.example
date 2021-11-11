package application.mapper;

import application.model.dto.AuthorSaveDTO;
import application.model.entity.Author;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorModelMapper {

    private final ModelMapper modelMapper;

    public Author map(AuthorSaveDTO authorSaveDTO) {
        return modelMapper.map(authorSaveDTO, Author.class);
    }

}
