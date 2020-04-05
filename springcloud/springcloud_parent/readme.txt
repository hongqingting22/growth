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

注册中心集群
    节点间相互注册
    注册在一个节点的客户端，会同步到其他的节点
    但是一个节点宕机后，注册在该节点的客户端将不会出现在其他节点的注册列表中
    因此，客户端会注册在每个eureka节点上，以保证一个宕机不影响其他整个服务。

服务的高可用
    服务提供者，名称一致，启动多个实例

