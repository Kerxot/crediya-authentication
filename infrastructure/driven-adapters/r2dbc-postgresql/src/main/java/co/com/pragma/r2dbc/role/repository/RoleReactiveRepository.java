package co.com.pragma.r2dbc.role.repository;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.pragma.r2dbc.role.entity.RoleEntity;

// TODO: This file is just an example, you should delete or modify it
  public interface RoleReactiveRepository extends ReactiveCrudRepository<RoleEntity, Long>, ReactiveQueryByExampleExecutor<RoleEntity> {

}
