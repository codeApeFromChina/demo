package cn.tj.fnzi.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class App2 {
    
    private ZkClient zkClient;
    
    public ZkClient getZkClient() {
        return zkClient;
    }

    public void setZkClient(ZkClient zkClient) {
        this.zkClient = zkClient;
    }

    /**
     * 初始化zookeeper
     */
    public void initialize() {
        
        String connectionString="172.16.30.7:2181";
        int connectionTimeout=500000;
        
        zkClient=new ZkClient(connectionString, connectionTimeout);
        
        new Thread(new Runnable() {
            
            public void run() {
            
                zkClient.subscribeDataChanges("/root1", new IZkDataListener() {
                    
                    public void handleDataDeleted(String dataPath) throws Exception {
                        System.out.println("the node 'dataPath'===>");    
                    }
                    
                    public void handleDataChange(String dataPath, Object data) throws Exception {
                        System.out.println("the node 'dataPath'===>"+dataPath+", data has changed.it's data is "+String.valueOf(data));
                        
                    }
                });
                
            }
            
        }).start();
    }
    
    /**
     * 函数入口
     * @param args
     */
    public static void main( String[] args ) {
       
        App bootStrap=new App();
        bootStrap.initialize();
        
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            
    }
}