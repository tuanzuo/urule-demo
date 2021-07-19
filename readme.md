#### 1、urule服务端与springboot集成和分流规则配置
1.1、在mysql中创建一个数据库，例如名称为：uruledemo；修改urule-server模块下config-local.properties
中的数据库配置

1.2、启动urule-server这个模块的应用

1.3、urule-server模块启动后访问urule的地址：http://127.0.0.1/urule/frame

1.4、将docs/ky-urule-repo-20210718204805.bak导入到项目中

#### 2、urule客户端的配置和使用分流规则的知识包
2.1、修改urule-client模块下configure.properties中urule.resporityServerUrl这个配置项的值为urule-server
这个模块启动后的访问地址，例如：http://127.0.0.1:80

2.2、启动urule-client这个模块的应用

2.3、代码中调用分流规则的方式：http://127.0.0.1:8081/urule/test?userTag=A

2.4、使用Restful的方式调用分流规则：http://127.0.0.1:8081/urule/test/rest?userTag=A

#### 3、urule官方文档
http://www.bstek.com/products/urule

http://www.bstek.com/resources/doc/
