# multi-module-spring-boot
multi-module-spring-boot

## spring-boot-version

spring boot **2.0.0.RC2** 实现版本控制

通过自定义ApiVersion,CustomRequestMappingHandlerMapping,ApiVesrsionCondition实现.

**优点:** 直接扩展spring mvc,实现版本最优匹配,方便

**缺点:** 导致所有版本访问都要进行正则表达式匹配(spring mvc自带默认匹配)

**建议:** 放弃使用自定义ApiVersion注解,control类注解@RequestMapping上固定配置url版本如:'/v1/...',重写RequestMappingHandlerMapping中
匹配url的方法lookupHandlerMethod,实现自定义匹配,从而实现部分'固定url'访问不用遍历整个urlMap进行正则匹配,提高性能速度;
