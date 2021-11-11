package application.controller;

import application.model.dto.BookSaveDTO;
import application.model.entity.Book;
import application.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(description = "Save book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved books",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Book.class)))
                    }),
            @ApiResponse(
                    responseCode = "409",
                    description = "Could not execute statement",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = String.class))
                    })
    })
    @PostMapping
    public List<Book> saveAll(@RequestParam Long authorId, @RequestBody List<BookSaveDTO> bookSaveDTOs) {
        return bookService.saveAll(authorId, bookSaveDTOs);
    }

}
