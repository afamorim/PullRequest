package br.com.vortice.pullrequest.web.faces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TesteFaces implements Serializable{

	public TesteFaces(){
		System.out.println("CONSTRUTOR");
	}
	
	public void teste(){
		System.out.println("TESTE");
	}
}
