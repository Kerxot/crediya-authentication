package co.com.pragma.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.pragma.api.user.UserHandler;
import co.com.pragma.api.user.UserRouter;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class RouterRest {
    private final UserRouter userRouter;

    @Bean
    public RouterFunction<ServerResponse> apiV1Routes(UserHandler userHandler) {
        return RouterFunctions
            .nest(RequestPredicates.path("/api/v1"),
	      userRouter.userRoutes(userHandler)
	    );
        }
}
