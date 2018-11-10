package listen;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 * Application Lifecycle Listener implementation class OnLineListener
 *
 */
@WebListener
public class OnLineListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener
{
	private ServletContext application = null;
    /**
     * Default constructor. 
     */
    public OnLineListener() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0)// 有新用户时，将用户加入用户名列表  
    { 
         // TODO Auto-generated method stub
    	
    	ArrayList online = (ArrayList) application.getAttribute("online");//取得用户名列表  	
    	online.add((String)arg0.getValue());//将当前用户名添加到列表中 	
    	this.application.setAttribute("online", online);//将添加后的列表重新设置到application属性中
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  
    { 
         // TODO Auto-generated method stub
		
		ArrayList online = (ArrayList) application.getAttribute("online");//取得用户名列表
		String username = (String) arg0.getSession().getAttribute("username");//取得当前用户名	
		online.remove(username);//将此用户名从列表中删除	
		this.application.setAttribute("online", online);//将删除后的列表重新设置到application属性中
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) 
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0) 
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) //Web应用启动时，初始化保存用户名的列表
    { 
         // TODO Auto-generated method stub
    	this.application = sce.getServletContext();	//初始化一个application对象	
    	this.application.setAttribute("online", new ArrayList());//创建一个ArrayList对象，用于保存在线用户名
    }
	
}
