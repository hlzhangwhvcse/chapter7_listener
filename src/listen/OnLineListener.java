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
    public void attributeAdded(ServletContextAttributeEvent arg0)// �����û�ʱ�����û������û����б�  
    { 
         // TODO Auto-generated method stub
    	
    	ArrayList online = (ArrayList) application.getAttribute("online");//ȡ���û����б�  	
    	online.add((String)arg0.getValue());//����ǰ�û�����ӵ��б��� 	
    	this.application.setAttribute("online", online);//����Ӻ���б��������õ�application������
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
		
		ArrayList online = (ArrayList) application.getAttribute("online");//ȡ���û����б�
		String username = (String) arg0.getSession().getAttribute("username");//ȡ�õ�ǰ�û���	
		online.remove(username);//�����û������б���ɾ��	
		this.application.setAttribute("online", online);//��ɾ������б��������õ�application������
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
    public void contextInitialized(ServletContextEvent sce) //WebӦ������ʱ����ʼ�������û������б�
    { 
         // TODO Auto-generated method stub
    	this.application = sce.getServletContext();	//��ʼ��һ��application����	
    	this.application.setAttribute("online", new ArrayList());//����һ��ArrayList�������ڱ��������û���
    }
	
}
