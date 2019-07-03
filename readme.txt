1、@Subscribe  注解的订阅者方法必须是public的。
2、https://blog.csdn.net/xieluoxixi/article/details/78262765
    使用注解将EventBus封装抽取到基类
    getClass().isAnnotationPresent(BindEventBus.class)
    在基类里通过这个方法可以判断子类有没有被@BindEventBus注解，
    从而避免每个activity都必须注册EventBus。
3、@Subscribe(sticky = true)------获取订阅之前的黏性广播
    被以上修饰的方法在订阅时能获取到最近一条黏性广播
    注意事项：
    一、 继承baseActivity（就是注册eventbus）
    二、 postStickey才可以收到
    三、 @Subscribe(sticky = true)修饰
4、