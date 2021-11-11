package application.mapper;

import application.model.dto.BookSaveDTO;
import application.model.entity.Author;
import application.model.entity.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookModelMapper {

    private final ModelMapper modelMapper;

    public List<Book> mapAll(Long authorId, List<BookSaveDTO> bookSaveDTOs) {
        return bookSaveDTOs.stream()
                .map(bookSaveDTO -> modelMapper.map(bookSaveDTO, Book.class))
                .peek(book -> book.setAuthor(Author.builder().id(authorId).build()))
                .collect(Collectors.toList());
    }
}
