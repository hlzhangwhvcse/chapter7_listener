package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class NameFilter
 */
//@WebFilter("/NameFilter/show.jsp")
public class NameFilter implements Filter 
{

    /**
     * Default constructor. 
     */
    public NameFilter() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain

		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String name = httpServletRequest.getParameter("uname") != null ? httpServletRequest.getParameter("uname") : "";
		String message = httpServletRequest.getParameter("msg") != null ? httpServletRequest.getParameter("msg") : "";
		
		if (name.indexOf("��") != -1 || message.indexOf("��") != -1)//�û������������к���������������ܾ����û�����
		{
			System.out.println("��NameFilter����һ���Ƿ��û�");
			httpServletResponse.sendRedirect("error.jsp");
		} 
		else//�û���ͨ����֤ 
		{
			httpServletRequest.setAttribute("uname", name);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException 
	{
		// TODO Auto-generated method stub
	}

}
