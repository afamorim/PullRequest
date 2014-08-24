package br.com.vortice.pullrequest.web.faces.util;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vortice.pullRequest.business.ClienteBean;
import br.com.vortice.pullRequest.entity.ClienteEntity;

public class LoadImageServlet extends HttpServlet{

	private static final long serialVersionUID = -4421337799287110785L;
	
	@EJB
	private ClienteBean clienteBean;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)  
            throws ServletException, IOException {  
		
		String codigo = req.getParameter("codigo");
		String tipo = req.getParameter("tipo");
          
		res.setContentType("image/jpeg");  
		ServletOutputStream output = res.getOutputStream();  
		try {    
			if(tipo.equals("cliente")){
				ClienteEntity cliente = new ClienteEntity();
				cliente.setCodigo(Long.parseLong(codigo));
				cliente = clienteBean.findByPrimaryKey(cliente);
				output.write(cliente.getFoto());
			}

			output.flush();  
		} finally {   
			output.close();  
		}  
	  
	}  

}
