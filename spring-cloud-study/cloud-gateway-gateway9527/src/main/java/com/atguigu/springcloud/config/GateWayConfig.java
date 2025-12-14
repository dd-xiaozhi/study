package com.atguigu.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author xiaozhi
 */
@Slf4j
@Configuration
public class GateWayConfig {

    @Order(0)
    @Bean
    public GlobalFilter myCustomGlobalFilter() {
        return (exchange, chain) -> {
            log.info("time：" + new Date() + "\t执行了自定义全局过滤器");
            String username = exchange.getRequest().getQueryParams().getFirst("username");
            if (username == null) {
                log.info("用户名不正确，无法登陆");
                exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        };
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_toutiao",
                r -> r.path("/complain").uri("https://www.toutiao.com")).build();
        routes.route("path_route_toutiao2",
                r -> r.path("/about").uri("https://www.toutiao.com")).build();
        return routes.build();
    }

    // @Bean
    // public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
    //     RouteLocatorBuilder.Builder routes = builder.routes();
    //     routes.route("path_route_toutiao2",
    //             r -> r.path("/about/").uri("https://www.toutiao.com")).build();
    //     return routes.build();
    // }
}
