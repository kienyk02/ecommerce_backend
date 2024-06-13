package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Search;

import java.util.List;
import java.util.Optional;

public interface SearchService {

    List<Search> fetchSearchByUserId(int id);

    Search saveSearch(Search search);

    void deleteSearch(int id);

    Optional<Search> getSearchById(int id);

}
