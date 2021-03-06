package example.soa;

import java.lang.reflect.Method;

/**
 * Created by juemingzi on 16/5/31.
 */
public class ServerInvoker<T> implements Invoker<T> {
    private Class<T> clazz;

    public ServerInvoker(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<T> getInterface() {
        return clazz;
    }

    @Override
    public Result invoke(Invocation invocation) throws Exception {
//        System.out.println("methodName is: " + invocation.getMethodName());
        Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
        Object instance = clazz.newInstance();
        Object result = method.invoke(instance, invocation.getArguments());

        return new Result(result);
    }

}
