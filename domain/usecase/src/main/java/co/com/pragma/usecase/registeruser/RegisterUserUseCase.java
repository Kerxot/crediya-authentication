package co.com.pragma.usecase.registeruser;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class RegisterUserUseCase {
  private final UserRepository userRepository;

  public void saveUser(User user) {
    userRepository.saveUser(user);
  }
}
