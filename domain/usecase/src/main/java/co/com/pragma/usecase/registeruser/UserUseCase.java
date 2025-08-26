package co.com.pragma.usecase.registeruser;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class UserUseCase {
  private final UserRepository userRepository;

  public Mono<User> saveUser(User user) {
    return userRepository.saveUser(user);
  }
}
