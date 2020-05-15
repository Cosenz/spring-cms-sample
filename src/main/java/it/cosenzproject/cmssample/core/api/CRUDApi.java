package it.cosenzproject.cmssample.core.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface CRUDApi<T> {

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<T> save(T t);

	@RequestMapping(method = RequestMethod.GET, value = "/")
	ResponseEntity<Page<T>> getAll(Pageable pageable);

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<T> getById(@PathVariable("id") Integer id);

	@RequestMapping(method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteProduct(@RequestParam("id") Integer id);

}
