package co.com.pragma.r2dbc.user.repository;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.pragma.r2dbc.user.entity.UserEntity;

// TODO: This file is just an example, you should delete or modify it
  public interface UserReactiveRepository extends ReactiveCrudRepository<UserEntity, Long>, ReactiveQueryByExampleExecutor<UserEntity> {

}
