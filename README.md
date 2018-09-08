# multi-module-spring-boot
multi-module-spring-boot

## spring-boot-version

spring boot **2.0.0.RC2** 实现版本控制

通过自定义ApiVersion,CustomRequestMappingHandlerMapping,ApiVesrsionCondition实现.

**优点:** 直接扩展spring mvc,实现版本最优匹配,方便

**缺点:** 导致所有版本访问都要进行正则表达式匹配(spring mvc自带默认匹配)

**建议:** 放弃使用自定义ApiVersion注解,control类注解@RequestMapping上固定配置url版本如:'/v1/...',重写RequestMappingHandlerMapping中
匹配url的方法lookupHandlerMethod,实现自定义匹配,从而实现部分'固定url'访问不用遍历整个urlMap进行正则匹配,提高性能速度;


# 注意事项
1.契约测试,feign调用的producer服务名和producer的maven.artifactId一致(stub是否有修改服务名方法?);

2.本地hostname应该和测试环境,生产环境统一,方便配置;

3.spring cloud contracts 契约配置文件可以单独一个项目,方便个开发组写契约,在stub中引用契约项目,就可以对应生成项目的stub到maven仓库;
