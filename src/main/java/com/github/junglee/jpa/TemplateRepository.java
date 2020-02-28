package com.github.junglee.jpa;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.junglee.domain.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Long>, JpaSpecificationExecutor<Template>
{

}
