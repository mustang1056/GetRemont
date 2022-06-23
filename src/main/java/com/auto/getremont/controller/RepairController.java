package com.auto.getremont.controller;


import com.auto.getremont.entity.RepairEntity;
import com.auto.getremont.model.Repair;
import com.auto.getremont.service.RepairtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
public class RepairController {

    @Autowired
    RepairtServiceImpl remontService;

    // Получить все записи
    @GetMapping("/remont")
    public Page<Repair> search(@RequestParam(name = "page") int pageNumber) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        Page<Repair> remonts = remontService.getRemonts(pageable);

        return remonts;
    }


    // Получить запись по id
    @GetMapping("/remont/{id}")
    public Optional<RepairEntity> findByIds(@PathVariable(value = "id") Long remontId) {
        return (Optional<RepairEntity>) remontService.getById(remontId);
    }

    // Создать запись
    @PostMapping("/remont")
    public RepairEntity createNote(@Valid @RequestBody Repair blog) {
        return (RepairEntity) remontService.addRemont(blog);
    }



}
