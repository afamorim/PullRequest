package br.com.vortice.treinamento.dao;

import com.vortice.core.abstracao.Entidade;
import com.vortice.core.persistencia.GenericJPADAO;

public class GenericDAO<E extends Entidade, ID> extends GenericJPADAO<E, ID> {

}
