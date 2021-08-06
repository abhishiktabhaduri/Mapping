package com.mapping.service.impl;

import com.mapping.entity.Library;
import com.mapping.repository.LibraryRepository;
import com.mapping.service.LibraryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library addLibrary(Library library) {
        Library addLibrary=Library.builder()
                .id(library.getId())
                .libraryName(library.getLibraryName())
                .micromarket(library.getMicromarket())
                .city(library.getCity())
                .country(library.getCountry())
                .build();
        return libraryRepository.save(addLibrary);
    }

    @Override
    public Library getLibraryById(int id) {
        if(libraryRepository.findById(id).isPresent())
            return libraryRepository.findById(id).get();
        else
            return null;
    }

    @Override
    public List<Library> getAllLibraries() {
        List<Library> libraries=libraryRepository.findAll();
        return libraries;
    }
}

