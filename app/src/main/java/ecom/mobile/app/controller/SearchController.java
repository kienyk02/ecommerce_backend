package ecom.mobile.app.controller;

import ecom.mobile.app.model.Search;
import ecom.mobile.app.service.serviceInterface.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/{userId}")
    private List<Search> fetchSearchByUserId(@PathVariable("userId") int id) {
        return searchService.fetchSearchByUserId(id);
    }

    @PostMapping("/search")
    private Search saveSearch(@RequestBody Search search) {
        return searchService.saveSearch(search);
    }

    @DeleteMapping("/search/{id}")
    private Optional<Search> deleteSearch(@PathVariable("id") int id) {
        searchService.deleteSearch(id);
        return searchService.getSearchById(id);
    }

}
