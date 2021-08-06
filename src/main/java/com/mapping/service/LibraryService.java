package com.mapping.service;
import com.mapping.entity.Library;

import java.util.List;

public interface LibraryService {
    Library addLibrary(Library library);
    Library getLibraryById(int id);
    List<Library> getAllLibraries();
}
