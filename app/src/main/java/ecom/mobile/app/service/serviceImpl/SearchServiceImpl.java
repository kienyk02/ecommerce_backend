package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Search;
import ecom.mobile.app.repository.SearchRepository;
import ecom.mobile.app.service.serviceInterface.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<Search> fetchSearchByUserId(int id) {
        return searchRepository.findAllByUserId(id);
    }

    @Override
    public Search saveSearch(Search search) {
        return searchRepository.save(search);
    }

    @Override
    public void deleteSearch(int id) {
        searchRepository.deleteById(id);
    }

    @Override
    public Optional<Search> getSearchById(int id) {
        return searchRepository.findById(id);
    }

}
