package com.example.demo.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static Jedis jedis;
    public static void main(String[] args) {
        // 连接本地的 Redis 服务
         //jedis = new Jedis("47.104.71.197", 6379);
        jedis = new Jedis("47.104.71.197");
        //使用字符串string存值
        //jedis.set("city", "nanjing");

        //jedis.append("city", " is a city!");
        //System.out.println("delete:" + jedis.get("city"));
        //jedis.del("city");
        //System.out.println("delete2:" + jedis.get("city"));

        //jedis.mset("name", "cici", "age", "8", "email", "cc@outlook.com");
        //jedis.incr("age");

        testSort();

    }

    public static void testSort(){
        jedis.del("number");//先删除数据，再进行测试
        jedis.rpush("number","4");//将一个或多个值插入到列表的尾部(最右边)
        jedis.rpush("number","5");
        jedis.rpush("number","3");

        jedis.lpush("number","9");//将一个或多个值插入到列表头部
        jedis.lpush("number","1");
        jedis.lpush("number","2");
        System.out.println(jedis.lrange("number",0,jedis.llen("number")));
        System.out.println("排序:"+jedis.sort("number"));
        System.out.println(jedis.lrange("number",0,-1));//不改变原来的排序
        //jedis.del("number");//测试完删除数据
    }

    public static void testSet(){

        jedis.del("user");
        //添加
        jedis.sadd("user","alex");
        jedis.sadd("user","hu");
        jedis.sadd("user","chen");
        jedis.sadd("user","xiyu");
        jedis.sadd("user","chx");
        jedis.sadd("user","are");
        //移除user集合中的元素are
        jedis.srem("user","are");
        System.out.println("user中的value:"+jedis.smembers("user"));//获取所有加入user的value
        System.out.println("chx是否是user中的元素:"+jedis.sismember("user","chx"));//判断chx是否是user集合中的元素
        System.out.println("集合中的一个随机元素:"+jedis.srandmember("user"));//返回集合中的一个随机元素
        System.out.println("user中元素的个数:"+jedis.scard("user"));
    }

    public static void testList(){
        //移除javaFramwork所所有内容
        jedis.del("javaFramwork");
        //存放数据
        jedis.lpush("javaFramework","spring");
        jedis.lpush("javaFramework","springMVC");
        jedis.lpush("javaFramework","mybatis");
        //取出所有数据,jedis.lrange是按范围取出
        //第一个是key，第二个是起始位置，第三个是结束位置
        System.out.println("长度:"+jedis.llen("javaFramework"));
        //jedis.llen获取长度，-1表示取得所有
        System.out.println("javaFramework:"+jedis.lrange("javaFramework",1,-1));

        jedis.del("javaFramework");
        System.out.println("删除后长度:"+jedis.llen("javaFramework"));
        System.out.println(jedis.lrange("javaFramework",0,-1));
    }

    public static void map(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "cici1");
        map.put("age", "8a");
        map.put("email", "cci1@outlook.com");
        jedis.hmset("user", map);
        List<String> list = jedis.hmget("user", "name", "age", "email");
        jedis.hdel("user", "age");
        System.out.println(list);
        System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));
        System.out.println("user的键中存放的值的个数:" + jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println("是否存在key为user的记录:" + jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println("user对象中的所有key:" + jedis.hkeys("user"));//返回user对象中的所有key
        System.out.println("user对象中的所有value:" + jedis.hvals("user"));//返回map对象中的所有value
    }
}
