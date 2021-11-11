package application.service;

import application.mapper.AuthorModelMapper;
import application.model.dto.AuthorSaveDTO;
import application.model.entity.Author;
import application.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorModelMapper modelMapper;

    @Transactional(rollbackFor = {Exception.class})
    public Author save(AuthorSaveDTO authorDTO) {
        Author author = modelMapper.map(authorDTO);
        return authorRepository.save(author);
    }

    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
