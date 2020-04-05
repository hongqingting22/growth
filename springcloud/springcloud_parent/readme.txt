HTTP VS RPC
Dubbo        高性能RPC框架    基于tcp协议
Spring Cloud   基于http协议  传输效率低于tcp协议
        http + RestFul方式

服务调用方式：
    1.RestTemplate对象 + ribbon
    2.feign

  实现：
    1.RestTemplate template =  new RestTemplate();
        String ret = template.getForObject(url, String.class);

    2.负载均衡
       1)使用负载均衡客户端LoadBalancerClient
        @Autowired
        LoadBalancerClient loadBalancerClient;

        String host = loadBalancerClient.getHost();
        String port = loadBalancerClient.getPort();
        return template.getForObject("http://" + host + ":" + port + "/xxx",String.class);

       2)使用@LoadBalance注解，调用服务名自动完成负载均衡
        @Bean
        @LoadBalanced
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }

        restTemplate.getForObject("http://" + 服务名 + "/XX",String.class);

     2.Feign
        声明式伪http客户端
        基于接口的注解：使用feign，只需要创建一个接口并注解。
        默认集成ribbon，默认实现负载均衡的效果。

        注解：@EnableFeignClients  服务启动类
        接口  @FeignClient("调用服务名")
            接口参数传递：@RequestParam("参数名")




注册中心集群
    节点间相互注册
    注册在一个节点的客户端，会同步到其他的节点
    但是一个节点宕机后，注册在该节点的客户端将不会出现在其他节点的注册列表中
    因此，客户端会注册在每个eureka节点上，以保证一个宕机不影响其他整个服务。

Ribbon负载均衡
    服务的高可用
    服务提供者，名称一致，启动多个实例
    基于Ribbon的负载均衡
        默认：轮询
        RandomRule  随机
        RoundRobinRule  轮询
        RetryRule 重试策略  一段时间内选择的server不成功，则一直尝试选择一个可用的server
        BestAvailableRule  最低并发策略  逐个考察Server,选择其中并发连接最低的server
        AvailabilityFilteringRule 可用过滤策略 过滤掉一直连接失败的，过滤掉并发连接高的
        ResponseTimeWeightedRule 响应时间加权策略 根据响应时间分配加权重，响应时间越长，权重越低。
        ZoneAvoidanceRule  区域权衡

        自定义算法：
            继承AbstractLoadBalanceRule ，实现choose方法

断路器Hystrix
    服务不可用，fallback直接返回一个固定值，避免出现服务器“雪崩”

    两种服务调用方式使用断路器的区别：
    template + ribbon
        1.开启 @EnableHystrix
        2.调用方法上使用@Hystrix  实现fallback返回默认值
    feign
        1.开启 @EnableHystrix
        2.实现接口，返回默认值


统一配置中心
    git中保存配置信息，启动时会将配置信息加载到配置中心，同时写入本地文件
    git远程拉取不到时，可以从本地文件读取配置信息

    为什么使用？
    1.统一维护
    2.隔离配置文件

    @EnableConfigServer
    yml文件中指定git服务器地址
        spring:
            cloud:
                config:server:git:url: xxx.git
                basedir:存到本地的位置
    配置文件格式：
    name-profiles  名称-环境
    label  分支

    客户端使用配置中心
    名字不能使用application.yml
    使用bootstrap.yml
    spring:cloud:config:discovery:enabled:true
                                  service-id:CONFIG(配置中心服务应用名称)
                        name:
                        profile:
                        label: master

zuul 网关
    访问不同服务器时，统一入口
    路由转发和过滤器
    默认与robbin实现负载均衡


