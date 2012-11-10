package mx.upiicsa.titulacion.web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.upiicsa.titulacion.util.WConstants;

@WebFilter(filterName = "securityFilter", dispatcherTypes = { DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.REQUEST }, servletNames = { "Faces Servlet" }, urlPatterns = "/secured/*")
public class SecurityFilter implements Filter {

	//final static Log logger = LogFactory.getLog(SecurityFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();

		if (session.getAttribute(WConstants.USUARIO_WEBOBJECT) == null) {
			if (request.getRequestURI().equals(WConstants.LOGIN_PAGE)) {
			} else if (request.getRequestURI().startsWith(WConstants.SECURED_PAGE)) {
				//logger.debug(String.format("S2-> Redireccionando a -> %s", WConstants.LOGIN_PAGE));
				HttpServletResponse response = (HttpServletResponse) servletResponse;
				response.sendRedirect(WConstants.LOGIN_PAGE);
				return;
			}

		}
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
