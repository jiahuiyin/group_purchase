package cn.yinjiahui.group_purchase.service.impl;


import cn.yinjiahui.group_purchase.repository.SessionRepository;
import cn.yinjiahui.group_purchase.service.CIMSessionService;
import com.farsunset.cim.sdk.server.handler.CIMNioSocketAcceptor;
import com.farsunset.cim.sdk.server.model.CIMSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CIMSessionServiceImpl implements CIMSessionService {

	@Resource
	private CIMNioSocketAcceptor nioSocketAcceptor;

	@Resource
	private SessionRepository sessionRepository;

	@Override
	public void save(CIMSession session) {
		sessionRepository.save(session);
	}

	/*
	 *
	 * @param account 用户id
	 * @return
	 */
	@Override
	public CIMSession get(String account) {

		CIMSession session = sessionRepository.get(account);

		if (session != null) {
			session.setSession(nioSocketAcceptor.getManagedSession(session.getNid()));
		}

		return session;
	}

	@Override
	public void remove(String account) {
		sessionRepository.remove(account);
	}

	@Override
	public List<CIMSession> list() {
		return sessionRepository.findAll();
	}

}
