package co.com.pragma.api.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {
  public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler) {
    return RouterFunctions
      .nest(RequestPredicates.path("/users"),
	  RouterFunctions.route()
	  .POST("", userHandler::saveUser)
	  .build()
      );
  }
}
