package java9_10_11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author wanyu
 * @createTime 2022-03-01 1:55
 */
public class Java11 {
    @Test
    public void test1(){
        //新增了一系列字符串处理方法
        //判断字符串是否为空白
        " ".isBlank(); // true
        //去除首尾空白
        " Javastack ".strip(); // "Javastack"
        //去除尾部空格
        " Javastack ".stripTrailing(); // " Javastack"
        //去除首部空格
        " Javastack ".stripLeading(); // "Javastack "
        //复制字符串
        "Java".repeat(3);// "JavaJavaJava"
        //行数统计
        "A\nB\nC".lines().count(); // 3
    }

    @Test
    public void test2(){
        //Optional 加强
        //boolean isEmpty()
        //ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
        //Optional<T>or(Supplier<?
        //extends Optional<? extends T>> supplier)
        //Stream<T> stream()
        //T orElseThrow()
    }

    public void test3(){
        //局部变量类型推断升级
        //错误的形式: 必须要有类型, 可以加上var
        //Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        //正确的形式:
        //使用var的好处是在使用lambda表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

    public void test4() throws IOException, InterruptedException {
        //全新的HTTP 客户端API
        //同步
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, responseBodyHandler);
        String body = response.body();
        System.out.println(body);

        //异步
        HttpClient client2 = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler2 = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync =
                client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);

    }
}
