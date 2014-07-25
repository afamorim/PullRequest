package br.com.vortice.pullrequest.web.filter;

import java.io.IOException;

import javax.ejb.EJB;
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

import br.com.vortice.pullRequest.business.UsuarioBean;
import br.com.vortice.pullRequest.entity.PerfilEntity;
import br.com.vortice.pullRequest.entity.UsuarioEntity;
import br.com.vortice.pullRequest.util.PullRequestConstantes;

@WebFilter(urlPatterns={"/*"})
public class PullRequestFilter implements Filter {

	@EJB
	private UsuarioBean		usuarioBean;
	
	private final String	LOGIN_PAGE = "/login.xhtml";
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException 
	{
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		HttpSession session = httpServletRequest.getSession();
		
		UsuarioEntity usuarioLogado = (UsuarioEntity)session.getAttribute(PullRequestConstantes.USUARIO_LOGADO);
		
		if (usuarioLogado != null){
			
			filterChain.doFilter(request, response);
		}else{
			
			if (request.getServletContext().getInitParameter(PullRequestConstantes.MODO_DESENVOLVIMENTO) != null 
					&& request.getServletContext().getInitParameter(PullRequestConstantes.MODO_DESENVOLVIMENTO).equals("TRUE")){
				usuarioLogado = new UsuarioEntity();
				usuarioLogado.setCodigo(1L);
				usuarioLogado.setLogin("admin");
				usuarioLogado.setPerfil(new PerfilEntity());
				usuarioLogado.getPerfil().setCodigo(1L);
				usuarioLogado.getPerfil().setNome("Administrador");
				session.setAttribute(PullRequestConstantes.USUARIO_LOGADO, usuarioLogado);
				filterChain.doFilter(request, response);
			}
			
			if (!httpServletRequest.getRequestURI().endsWith(LOGIN_PAGE) && !isUrlLiberada(new String[]{}, httpServletRequest)){
			
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
			}else{
				filterChain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	
	private boolean isUrlLiberada(String[] urls, HttpServletRequest httpServletRequest){
		String[] extencoes = new String[]{"css", "jpg", "jpeg", "gif", "png", "js"};
		
		for(String url : urls){
			if(httpServletRequest.getRequestURI().endsWith(url)){
				return true;
			}
		}
		for(String extencao : extencoes){
			if(httpServletRequest.getRequestURI().toUpperCase().endsWith(extencao.toUpperCase())){
				return true;
			}
		}
		return false;
	}
}