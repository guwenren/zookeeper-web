package com.guwr.zookeeper.chaper1;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by   guwr
 * Project_name zookeeper-web
 * Path         com.guwr.zookeeper.chaper1.Main
 * Date         2017/5/19
 * Time         11:13
 * Description
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String connectString = "192.168.1.115:2181";
        int sessionTimeout = 20000;
        Watcher watcher = null;
        ZooKeeper zk = null;

        zk = new ZooKeeper(connectString, sessionTimeout, watcher);

        Stat stat = new Stat();
        byte[] data = zk.getData("/", false, stat);

        String sData = new String(data);

        System.out.println("sData = " + sData);
    }
}
