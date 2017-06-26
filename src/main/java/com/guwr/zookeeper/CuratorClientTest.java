package com.guwr.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Created by guwr
 * Project_name zookeeper-web
 * Path com.guwr.zookeeper.CuratorClientTest
 * Date 17/6/25
 * Time 下午8:29
 * Description
 */
public class CuratorClientTest {

    /**
     * Zookeeper info
     */
//    private static final String ZK_ADDRESS = "127.0.0.1:2181";
    private static final String ZK_ADDRESS = "192.168.1.115:2181";
    private static final String ZK_PATH = "/zktest";

    public static void main(String[] args) throws Exception {
        System.out.println("main");

        // 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));
        client.start();
        System.out.println("zk client start successfully!");

        // 2.Client API test
        // 2.1 Create node
//        String data1 = "hello";
//        String path = client.create().creatingParentsIfNeeded().forPath(ZK_PATH, data1.getBytes());
//        System.out.println("path = " + path);

        List<String> strings = client.getChildren().forPath("/");
        System.out.println("strings = " + strings);

        byte[] bytes = client.getData().forPath(ZK_PATH);

        System.out.println("String = " + new String(bytes));

        String helloWorld = "helloWorld";
        Stat stat = client.setData().forPath(ZK_PATH, helloWorld.getBytes());

        byte[] bytes1 = client.getData().forPath(ZK_PATH);

        System.out.println("String = " + new String(bytes1));

        client.delete().forPath(ZK_PATH);
        strings = client.getChildren().forPath("/");

        System.out.println("strings = " + strings);
    }
}
