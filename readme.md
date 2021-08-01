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

#### 3、urule使用注意事项
3.1、规则中的“优先级”属性表示“满足条件的规则中动作的执行顺序”，而不是规则执行的优先级；如果要实现“规则执行的优先级”，可以通过配置“互斥组”的方式来实现；
参考官方文档：http://www.bstek.com/resources/doc/4gui-ze-ji.html
3.2、当使用“分布式计算模式”时需要注意一个应用有多个实例且每次实例重新部署后ip发生了变化，服务端如何动态的感知客户端ip的变化（规则修改后，服务端主动推送规则到客户端会用到）；
官方的解决方案参考：http://www.bstek.com/resources/doc/16ke-hu-duan-fu-wu-qi-pei-zhi.html中的“客户端动态配置”
（官方给出的例子，看不出来如何服务端如何动态的感知客户端ip的变化的）
当然如果服务端动态的感知客户端ip的变化不好实现，可以让客户端主动拉取规则，而不是服务端主动推送；
-->把客户端中的“urule.knowledgeUpdateCycle”参数配置成10000（表示每隔10000毫秒检查一次知识包是否有更新）
参考官方文档：http://www.bstek.com/resources/doc/2an-zhuang-yu-pei-zhi.html

#### 4、urule官方文档
http://www.bstek.com/products/urule

http://www.bstek.com/resources/doc/
