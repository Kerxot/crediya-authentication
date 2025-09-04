package co.com.pragma.r2dbc.user.adapter;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import co.com.pragma.r2dbc.user.entity.UserEntity;
import co.com.pragma.r2dbc.user.repository.UserReactiveRepository;
import reactor.core.publisher.Mono;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;

@Repository
public class UserReactiveRepositoryAdapter extends ReactiveAdapterOperations<
    User/* change for domain model */,
    UserEntity/* change for adapter model */,
    Long,
    UserReactiveRepository
> implements UserRepository {
    private final TransactionalOperator transactionalOperator;

    public UserReactiveRepositoryAdapter(UserReactiveRepository repository, ObjectMapper mapper, TransactionalOperator transactionalOperator) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class/* change for domain model */));
	this.transactionalOperator = transactionalOperator;
    }

    @Override
    public Mono<User> saveUser(User user) {
      return save(user)
	.as(transactionalOperator::transactional);
    }
}
