package spring.tutorial.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.tutorial.model.AbstractDao;
import spring.tutorial.model.PersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogin>
		implements PersistentTokenRepository {

	static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

	@Override
	public void createNewToken(PersistentRememberMeToken token) {

		logger.info("Creating token for user: {}", token.getUsername());

		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		persistentLogin.setSeries(token.getSeries());
		persist(persistentLogin);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		logger.info("Fetch Token if any for seriesId : {}", seriesId);
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("series", seriesId));
	}



	@Override
	public void removeUserTokens(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateToken(String arg0, String arg1, Date arg2) {
		// TODO Auto-generated method stub

	}
	
	

}
