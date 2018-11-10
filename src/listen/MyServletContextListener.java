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
    public void contextInitialized(ServletContextEvent sce)  //webӦ����������ServletContext�Ķ���application����ʱ������
    { 
         // TODO Auto-generated method stub
    	//���¼��л�ȡ��WebӦ�õ�ServletContext����
    	application = sce.getServletContext();
    	msg = "=============ServletContext ����===============\r\n";
    	msg += "��ǰWebӦ�õ�����·��Ϊ��" + application.getRealPath("/");
    	// ��������Ϣд���������ļ���
    	logout(msg);
    }
    
 
 	private void logout(String msg)//logout��������д����Ϣ���ļ��� 
 	{
 		FileWriter out = null;
 		try
 		{	
 			out = new FileWriter("D:/weblog.txt", true);//����true����׷��ģʽ���ļ�д����Ϣ
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
