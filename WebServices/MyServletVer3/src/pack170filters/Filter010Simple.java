package pack170filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter010Simple implements Filter {


	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("I am in filter init.");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("I am in filter1.");
		
		arg2.doFilter(arg0, arg1);
		System.out.println("I am in filter2.");
	}

	public void destroy() {
		System.out.println("I am in filter destroy.");
	}
}
