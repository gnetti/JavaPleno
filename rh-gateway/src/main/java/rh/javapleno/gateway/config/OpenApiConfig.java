package rh.javapleno.gateway.config;

import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OpenApiConfig {

    List<String> excludeRotas = List.of("rh-gateway", "rh-oauth", "rh-email");

    public OpenApiConfig(SwaggerUiConfigParameters config,
                         RouteLocator locator) {
        List<Route> routes = locator.getRoutes();
        Collection<Route> rotasDistintas = routes.stream()
                .collect(Collectors.toMap(Route::getLocation, p -> p, (p, q) -> p)).values();

        rotasDistintas.stream().filter(r -> r.getLocation().matches("rh-.+")).forEach(r -> {
            String nomeServico = r.getLocation();

            if (!excludeRotas.contains(nomeServico)) {
                config.addGroup(nomeServico);
            }
        });
    }
}

