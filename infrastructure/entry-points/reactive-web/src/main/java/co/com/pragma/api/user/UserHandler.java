package co.com.pragma.api.user;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.pragma.model.user.User;
import co.com.pragma.usecase.registeruser.UserUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {
  private final UserUseCase userUseCase;

  public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
    return serverRequest.bodyToMono(User.class)
			.flatMap(userUseCase::saveUser)
			.flatMap(savedUser -> ServerResponse.ok().bodyValue(savedUser));
  }
}
