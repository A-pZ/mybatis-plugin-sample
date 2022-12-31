package com.github.apz.sample.config.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )
})
@Slf4j
public class SqlIdLoggingInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // @Signatureのtype属性に指定したクラスのarg属性（=ここではExecutorのメソッド引数になる）を取得。
        // MappedStatementはMyBatisがパラメータをバインドした結果のクエリを扱う
        MappedStatement statement = (MappedStatement)invocation.getArgs()[0];

        // MyBatisのマッピングID(実行するクエリのMyBatisのid)
        log.info("sql-id: {}", statement.getId());

        // クエリの実行
        Object result = invocation.proceed();

        // 実行後の制御をここに追記

        // インターセプトの終了
        return result;

    }
}
