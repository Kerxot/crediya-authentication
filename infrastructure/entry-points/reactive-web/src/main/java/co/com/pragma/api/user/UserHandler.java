package co.com.pragma.api.user;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.pragma.model.user.User;
import co.com.pragma.usecase.registeruser.UserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandler {
  private final UserUseCase userUseCase;

  public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
    return serverRequest.bodyToMono(User.class)
			.doOnNext(user -> log.debug("Request body parsed: {}", user))
			.flatMap(userUseCase::saveUser)
			.doOnSuccess(savedUser -> log.info("User saved via API: {}", savedUser))
			.flatMap(savedUser -> ServerResponse.ok().bodyValue(savedUser))
			.doOnError(error -> log.error("Error in saveUser handler", error));
  }
}
