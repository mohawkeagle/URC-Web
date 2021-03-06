package br.com.gmp.urcweb.data.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * Interface padrão para os DAO's
 *
 * @author kaciano
 * @param <T> Classe da Entidade
 */
public interface DAO<T> {

    /**
     * Constroi a entidade
     *
     * @param rs {@code ResultSet} Resultado da busca
     * @return Entidade construida
     * @throws java.lang.Exception
     */
    T build(ResultSet rs) throws Exception;

    /**
     * Deleta a entidade
     *
     * @param entity {@code T} Entidade
     * @throws java.lang.Exception
     */
    void delete(T entity) throws Exception;

    /**
     * Deleta todos os objetos da lista
     *
     * @param entities {@code List(T)} Lista a ser deletada
     * @throws java.lang.Exception
     */
    void deleteAll(List<T> entities) throws Exception;

    /**
     * Deleta todos os objetos do banco
     *
     * @throws java.lang.Exception
     */
    void deleteAll() throws Exception;

    /**
     * Busca todos os dados da entidade
     *
     * @return {@code List(T)} Entidade
     * @throws java.lang.Exception
     */
    List<T> getList() throws Exception;

    /**
     * Busca todos os dados da entidade
     *
     * @return {@code T[]} Entidade
     * @throws java.lang.Exception
     */
    Object[] getArray() throws Exception;

    /**
     * Insere a entidade no banco de dados
     *
     * @param entity {@code T} Entidade
     * @throws java.lang.Exception
     */
    void insert(T entity) throws Exception;

    /**
     * Insere as entidades no banco de dados
     *
     * @param entities {@code List(T)} Entidades
     * @throws java.lang.Exception
     */
    void insertAll(List<T> entities) throws Exception;

    /**
     * Retorna a entidade a partir do ID
     *
     * @param id {@code Long} ID
     * @return {@code T} Entidade
     * @throws java.lang.Exception
     */
    T queryByID(Long id) throws Exception;

    /**
     * Deleta todos os registros anteriores e insere os registros da lista
     *
     * @param entities {@code List(T)} Lista dos novos registros
     * @throws java.lang.Exception
     */
    void replaceAll(List<T> entities) throws Exception;

    /**
     * Atualiza a entidade
     *
     * @param entity {@code T} Entidade
     * @throws java.lang.IllegalAccessException Acesso ilegal
     */
    void update(T entity) throws IllegalArgumentException, IllegalAccessException;
}
