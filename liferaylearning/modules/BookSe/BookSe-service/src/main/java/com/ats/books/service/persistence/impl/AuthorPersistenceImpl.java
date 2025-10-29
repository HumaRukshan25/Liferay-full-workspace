/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.books.service.persistence.impl;

import com.ats.books.exception.NoSuchAuthorException;
import com.ats.books.model.Author;
import com.ats.books.model.AuthorTable;
import com.ats.books.model.impl.AuthorImpl;
import com.ats.books.model.impl.AuthorModelImpl;
import com.ats.books.service.persistence.AuthorPersistence;
import com.ats.books.service.persistence.AuthorUtil;
import com.ats.books.service.persistence.impl.constants.BOOKKKPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuthorPersistence.class)
public class AuthorPersistenceImpl
	extends BasePersistenceImpl<Author> implements AuthorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuthorUtil</code> to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuthorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLiferayUserId;
	private FinderPath _finderPathCountByLiferayUserId;

	/**
	 * Returns the author where liferayUserId = &#63; or throws a <code>NoSuchAuthorException</code> if it could not be found.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByLiferayUserId(long liferayUserId)
		throws NoSuchAuthorException {

		Author author = fetchByLiferayUserId(liferayUserId);

		if (author == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("liferayUserId=");
			sb.append(liferayUserId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAuthorException(sb.toString());
		}

		return author;
	}

	/**
	 * Returns the author where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByLiferayUserId(long liferayUserId) {
		return fetchByLiferayUserId(liferayUserId, true);
	}

	/**
	 * Returns the author where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByLiferayUserId(
		long liferayUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {liferayUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLiferayUserId, finderArgs, this);
		}

		if (result instanceof Author) {
			Author author = (Author)result;

			if (liferayUserId != author.getLiferayUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			sb.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(liferayUserId);

				List<Author> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLiferayUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {liferayUserId};
							}

							_log.warn(
								"AuthorPersistenceImpl.fetchByLiferayUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Author author = list.get(0);

					result = author;

					cacheResult(author);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Author)result;
		}
	}

	/**
	 * Removes the author where liferayUserId = &#63; from the database.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the author that was removed
	 */
	@Override
	public Author removeByLiferayUserId(long liferayUserId)
		throws NoSuchAuthorException {

		Author author = findByLiferayUserId(liferayUserId);

		return remove(author);
	}

	/**
	 * Returns the number of authors where liferayUserId = &#63;.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the number of matching authors
	 */
	@Override
	public int countByLiferayUserId(long liferayUserId) {
		FinderPath finderPath = _finderPathCountByLiferayUserId;

		Object[] finderArgs = new Object[] {liferayUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			sb.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(liferayUserId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_2 =
		"author.liferayUserId = ?";

	public AuthorPersistenceImpl() {
		setModelClass(Author.class);

		setModelImplClass(AuthorImpl.class);
		setModelPKClass(long.class);

		setTable(AuthorTable.INSTANCE);
	}

	/**
	 * Caches the author in the entity cache if it is enabled.
	 *
	 * @param author the author
	 */
	@Override
	public void cacheResult(Author author) {
		entityCache.putResult(AuthorImpl.class, author.getPrimaryKey(), author);

		finderCache.putResult(
			_finderPathFetchByLiferayUserId,
			new Object[] {author.getLiferayUserId()}, author);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the authors in the entity cache if it is enabled.
	 *
	 * @param authors the authors
	 */
	@Override
	public void cacheResult(List<Author> authors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (authors.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Author author : authors) {
			if (entityCache.getResult(
					AuthorImpl.class, author.getPrimaryKey()) == null) {

				cacheResult(author);
			}
		}
	}

	/**
	 * Clears the cache for all authors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuthorImpl.class);

		finderCache.clearCache(AuthorImpl.class);
	}

	/**
	 * Clears the cache for the author.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Author author) {
		entityCache.removeResult(AuthorImpl.class, author);
	}

	@Override
	public void clearCache(List<Author> authors) {
		for (Author author : authors) {
			entityCache.removeResult(AuthorImpl.class, author);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AuthorImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuthorImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AuthorModelImpl authorModelImpl) {
		Object[] args = new Object[] {authorModelImpl.getLiferayUserId()};

		finderCache.putResult(
			_finderPathCountByLiferayUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLiferayUserId, args, authorModelImpl);
	}

	/**
	 * Creates a new author with the primary key. Does not add the author to the database.
	 *
	 * @param authorId the primary key for the new author
	 * @return the new author
	 */
	@Override
	public Author create(long authorId) {
		Author author = new AuthorImpl();

		author.setNew(true);
		author.setPrimaryKey(authorId);

		return author;
	}

	/**
	 * Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorId the primary key of the author
	 * @return the author that was removed
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author remove(long authorId) throws NoSuchAuthorException {
		return remove((Serializable)authorId);
	}

	/**
	 * Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author that was removed
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author remove(Serializable primaryKey) throws NoSuchAuthorException {
		Session session = null;

		try {
			session = openSession();

			Author author = (Author)session.get(AuthorImpl.class, primaryKey);

			if (author == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(author);
		}
		catch (NoSuchAuthorException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Author removeImpl(Author author) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(author)) {
				author = (Author)session.get(
					AuthorImpl.class, author.getPrimaryKeyObj());
			}

			if (author != null) {
				session.delete(author);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (author != null) {
			clearCache(author);
		}

		return author;
	}

	@Override
	public Author updateImpl(Author author) {
		boolean isNew = author.isNew();

		if (!(author instanceof AuthorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(author.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(author);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in author proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Author implementation " +
					author.getClass());
		}

		AuthorModelImpl authorModelImpl = (AuthorModelImpl)author;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(author);
			}
			else {
				author = (Author)session.merge(author);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AuthorImpl.class, authorModelImpl, false, true);

		cacheUniqueFindersCache(authorModelImpl);

		if (isNew) {
			author.setNew(false);
		}

		author.resetOriginalValues();

		return author;
	}

	/**
	 * Returns the author with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthorException {

		Author author = fetchByPrimaryKey(primaryKey);

		if (author == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return author;
	}

	/**
	 * Returns the author with the primary key or throws a <code>NoSuchAuthorException</code> if it could not be found.
	 *
	 * @param authorId the primary key of the author
	 * @return the author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author findByPrimaryKey(long authorId) throws NoSuchAuthorException {
		return findByPrimaryKey((Serializable)authorId);
	}

	/**
	 * Returns the author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorId the primary key of the author
	 * @return the author, or <code>null</code> if a author with the primary key could not be found
	 */
	@Override
	public Author fetchByPrimaryKey(long authorId) {
		return fetchByPrimaryKey((Serializable)authorId);
	}

	/**
	 * Returns all the authors.
	 *
	 * @return the authors
	 */
	@Override
	public List<Author> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of authors
	 */
	@Override
	public List<Author> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of authors
	 */
	@Override
	public List<Author> findAll(
		int start, int end, OrderByComparator<Author> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of authors
	 */
	@Override
	public List<Author> findAll(
		int start, int end, OrderByComparator<Author> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUTHOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHOR;

				sql = sql.concat(AuthorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the authors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Author author : findAll()) {
			remove(author);
		}
	}

	/**
	 * Returns the number of authors.
	 *
	 * @return the number of authors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUTHOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "authorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUTHOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuthorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the author persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByLiferayUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLiferayUserId",
			new String[] {Long.class.getName()}, new String[] {"liferayUserId"},
			true);

		_finderPathCountByLiferayUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLiferayUserId",
			new String[] {Long.class.getName()}, new String[] {"liferayUserId"},
			false);

		AuthorUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AuthorUtil.setPersistence(null);

		entityCache.removeCache(AuthorImpl.class.getName());
	}

	@Override
	@Reference(
		target = BOOKKKPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BOOKKKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BOOKKKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AUTHOR =
		"SELECT author FROM Author author";

	private static final String _SQL_SELECT_AUTHOR_WHERE =
		"SELECT author FROM Author author WHERE ";

	private static final String _SQL_COUNT_AUTHOR =
		"SELECT COUNT(author) FROM Author author";

	private static final String _SQL_COUNT_AUTHOR_WHERE =
		"SELECT COUNT(author) FROM Author author WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "author.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Author exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Author exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuthorPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}