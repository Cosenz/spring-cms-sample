package it.cosenzproject.cmssample.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cosenzproject.cmssample.core.entity.BaseEntity;

public interface CRUDRepository<T extends BaseEntity> extends JpaRepository<T, Serializable> {

}
