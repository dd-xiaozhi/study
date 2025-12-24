# Study

Java 技术栈学习项目，涵盖微服务、网络编程、消息队列、AI 等多个领域的实践代码。

## 技术栈

- Java 21
- Maven
- Lombok / Guava / Commons-Lang3

## 项目模块

| 模块 | 说明 |
|------|------|
| `spring-cloud-study` | Spring Cloud 微服务全家桶学习，包含 Eureka、Consul、Feign、Hystrix、Gateway、Config、Stream、Nacos、Sentinel、Seata 等组件 |
| `spring-ai-study` | Spring AI 学习，集成 OpenAI、PgVector 向量数据库、Chat Memory 等 |
| `netty-study` | Netty 网络编程学习 |
| `rocketmq-study` | RocketMQ 消息队列学习 |
| `load-balancing-scheduling-algorithm` | 负载均衡调度算法实现 |

## Spring Cloud 模块详情

包含完整的微服务架构实践：

- 服务注册与发现：Eureka (7001-7003)、Zookeeper、Consul、Nacos
- 服务调用：OpenFeign
- 服务熔断：Hystrix、Sentinel
- 网关：Spring Cloud Gateway
- 配置中心：Spring Cloud Config、Nacos Config
- 消息驱动：Spring Cloud Stream + RabbitMQ
- 分布式事务：Seata

## 快速开始

```bash
# 克隆项目
git clone <repository-url>

# 编译
mvn clean install

# 运行指定模块
cd <module-name>
mvn spring-boot:run
```

## 环境要求

- JDK 21+
- Maven 3.6+
- 各模块可能需要额外中间件（MySQL、RabbitMQ、Nacos 等）
