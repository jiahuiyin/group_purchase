package cn.yinjiahui.group_purchase.handler;


import cn.yinjiahui.group_purchase.service.CIMSessionService;
import com.farsunset.cim.sdk.server.constant.CIMConstant;
import com.farsunset.cim.sdk.server.handler.CIMRequestHandler;
import com.farsunset.cim.sdk.server.model.CIMSession;
import com.farsunset.cim.sdk.server.model.SentBody;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;


/*
 * 断开连接，清除session
 *
 */

@Component
public class SessionClosedHandler implements CIMRequestHandler {

	@Resource
	private CIMSessionService cimSessionService;

	@Override
	public void process(CIMSession ios, SentBody message) {
		Object quietly = ios.getAttribute(CIMConstant.KEY_QUIETLY_CLOSE);
		if (Objects.equals(quietly, true)) {
			return;
		}

		Object account = ios.getAttribute(CIMConstant.KEY_ACCOUNT);
		if (account == null) {
			return;
		}

		cimSessionService.remove(account.toString());
	}

}
