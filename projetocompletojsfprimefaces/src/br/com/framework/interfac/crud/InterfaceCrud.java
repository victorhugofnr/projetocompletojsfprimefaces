package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {
	
	//Salva os dados
	void save(T object)throws Exception;
	
	void persist(T object)throws Exception;
	
	//salva ou atualiza
	void saveOrUpdate(T object) throws Exception;
	
	//Realiza a atualição dos dados
	void update(T object) throws Exception;
	
	//REaliza a remoção de dados
	void delete(T object) throws Exception;
	
	//Salva ou atualiza e retorna o objeto em estado persistente
	T merge(T object) throws Exception;
	
	//Carrega a lista de dados de uma determinada classe
	List<T> findList(Class<T> objs) throws Exception;
	
	Object findById(Class<T> entidade, Long id) throws Exception;
	
	T findByPorId(Class<T> entidade, Long id) throws Exception;
	
	List<T> findListByQueryDinamica (String s) throws Exception;
	
	//Executar o update HQL do Hibernate
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	//Executar o update com o SQL
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	//|Limpa a sessão do hibernate
	void clearSession() throws Exception;
	
	//retira um objeto da sessão do hibernate
	void evict (Object objs) throws Exception;
	
	Session getSession() throws Exception;
	
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	//Jdbc do Spring Framework
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
}
