package com.mapping.controller;

import com.mapping.entity.Library;
import com.mapping.service.LibraryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @ApiOperation(value = "Post Library")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),
                    @ApiResponse(code = 403, message = "Forbidden"),
                    @ApiResponse(code = 409, message = "Conflict"),
                    @ApiResponse(code = 500, message = "Internal server error"),
            })
    @PostMapping
    public ResponseEntity<Library> create(@Valid @RequestBody Library library) {
        return new ResponseEntity<>(libraryService.addLibrary(library), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Library", notes = "Get Library By Id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Ok"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),
                    @ApiResponse(code = 403, message = "Forbidden"),
                    @ApiResponse(code = 404, message = "Not found"),
                    @ApiResponse(code = 500, message = "Internal server error"),
                    @ApiResponse(code=204,message = "No Content")
            })
    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable Integer id){
            if(libraryService.getLibraryById(id) != null)
                return ResponseEntity.ok(libraryService.getLibraryById(id));
            else
                return ResponseEntity.noContent().build();

    }

    @ApiOperation(value = "Get Library", notes = "Get All Libraries ")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Ok"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),
                    @ApiResponse(code = 403, message = "Forbidden"),
                    @ApiResponse(code = 404, message = "Not found"),
                    @ApiResponse(code = 500, message = "Internal server error"),
                    @ApiResponse(code=204,message = "No Content")
            })
    @GetMapping("/all")
    public ResponseEntity<List<Library>> getById(){
        return ResponseEntity.ok(libraryService.getAllLibraries());
    }
}