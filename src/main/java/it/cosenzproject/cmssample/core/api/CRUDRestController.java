package it.cosenzproject.cmssample.core.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.cosenzproject.cmssample.core.entity.BaseEntity;
import it.cosenzproject.cmssample.core.service.CRUDService;

public class CRUDRestController<T extends BaseEntity> implements CRUDApi<T> {

	@Autowired
	private CRUDService<T> service;

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<T> save(@Valid @RequestBody T t) {
		return ResponseEntity.ok(this.service.saveOrUpdate(t));
	}

	@Override
	public ResponseEntity<Page<T>> getAll(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults(
	    { @SortDefault(sort = "name", direction = Sort.Direction.DESC) }
	) Pageable pageable) {
		return ResponseEntity.ok(this.service.getAll(pageable));
	}

	@Override
	public ResponseEntity<T> getById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(this.service.getById(id));
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> deleteProduct(@RequestParam("id") Integer id) {
		this.service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
