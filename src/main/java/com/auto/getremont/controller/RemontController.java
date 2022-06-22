package com.auto.getremont.controller;


import com.auto.getremont.entity.RemontEntity;
import com.auto.getremont.model.Remont;
import com.auto.getremont.service.RemontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
public class RemontController {

    @Autowired
    RemontServiceImpl remontService;

    // Получить все записи
    @GetMapping("/remont")
    public Page<Remont> search(@RequestParam(name = "page") int pageNumber) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        Page<Remont> remonts = remontService.getRemonts(pageable);

        return remonts;
    }


    // Получить запись по id
    @GetMapping("/remont/{id}")
    public Optional<RemontEntity> findByIds(@PathVariable(value = "id") Long remontId) {
        return (Optional<RemontEntity>) remontService.getById(remontId);
    }

    // Создать запись
    @PostMapping("/remont")
    public RemontEntity createNote(@Valid @RequestBody Remont blog) {
        return (RemontEntity) remontService.addRemont(blog);
    }



}
