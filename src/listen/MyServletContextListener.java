package listen;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import javax.servlet.ServletContext;
import java.io.FileWriter;
import java.util.Date;
/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
//@WebListener
public class MyServletContextListener implements ServletContextListener 
{

	ServletContext application = null;
	String msg = "";
    /**
     * Default constructor. 
     */
    public MyServletContextListener() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  //web应用启动，即ServletContext的对象application创建时被调用
    { 
         // TODO Auto-generated method stub
    	//从事件中获取该Web应用的ServletContext对象
    	application = sce.getServletContext();
    	msg = "=============ServletContext 启动===============\r\n";
    	msg += "当前Web应用的物理路径为：" + application.getRealPath("/");
    	// 将上述信息写出到磁盘文件中
    	logout(msg);
    }
    
 
 	private void logout(String msg)//logout方法用于写出信息到文件中 
 	{
 		FileWriter out = null;
 		try
 		{	
 			out = new FileWriter("D:/weblog.txt", true);//参数true表以追加模式向文件写出信息
 			out.write((new Date()).toString() + " : ");
 			out.write(msg + "\r\n\r\n");
 			out.close();
 		} 
 		catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
 	}
	
}
