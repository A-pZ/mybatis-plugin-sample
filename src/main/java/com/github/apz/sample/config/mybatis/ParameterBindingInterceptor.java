package com.github.apz.sample.config.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.PreparedStatement;

@Intercepts({
        @Signature(
                type = ParameterHandler.class,
                method = "setParameters",
                args = {PreparedStatement.class}
        )
})
@Slf4j
public class ParameterBindingInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        PreparedStatement preparedStatement = (PreparedStatement)invocation.getArgs()[0];

        // バインド前
        log.info("before: {}", preparedStatement.toString());

        // MyBatisはパラメータをバインド
        Object result = invocation.proceed();

        // バインド後
        log.info("after : {}", preparedStatement.toString());

        return result;
    }
}
