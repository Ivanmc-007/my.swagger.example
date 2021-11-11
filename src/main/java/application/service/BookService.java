package application.service;

import application.mapper.BookModelMapper;
import application.model.dto.BookSaveDTO;
import application.model.entity.Book;
import application.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookModelMapper modelMapper;

    @Transactional(rollbackFor = {Exception.class})
    public List<Book> saveAll(Long authorId, List<BookSaveDTO> bookSaveDTOs) {
        List<Book> books = modelMapper.mapAll(authorId, bookSaveDTOs);
        return bookRepository.saveAll(books);
    }

}
