package it.cosenzproject.cmssample.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CRUDService<T> {

	T saveOrUpdate(T t);

	Page<T> getAll(Pageable pageable);

	T getById(Integer id);

	void delete(Integer id);

}
