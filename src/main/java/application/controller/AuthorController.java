package application.controller;

import application.model.dto.AuthorSaveDTO;
import application.model.entity.Author;
import application.service.AuthorService;
import application.util.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @Operation(description = "Save author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = ResponseCode.OK,
                    description = "Saved author",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Author.class))
                    })
    })
    @PostMapping
    public Author save(@RequestBody AuthorSaveDTO authorSaveDTOs) {
        return authorService.save(authorSaveDTOs);
    }

    @Operation(description = "Get author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = ResponseCode.OK,
                    description = "Found the author",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Author.class))
                    })
    })
    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

}
