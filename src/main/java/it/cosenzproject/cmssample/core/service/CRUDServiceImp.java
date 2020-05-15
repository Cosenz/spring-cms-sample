package it.cosenzproject.cmssample.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.cosenzproject.cmssample.common.util.Assert;
import it.cosenzproject.cmssample.core.entity.BaseEntity;
import it.cosenzproject.cmssample.core.repository.CRUDRepository;

public class CRUDServiceImp<T extends BaseEntity> implements CRUDService<T> {

	@Autowired
	private CRUDRepository<T> repository;

	@Override
	public T saveOrUpdate(T t) {
		return repository.save(t);
	}

	@Override
	public Page<T> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public T getById(Integer id) {
		Optional<T> item = this.repository.findById(id);
		return Assert.checkOptional(item, "Elemento non presente");
	}

	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}

}
