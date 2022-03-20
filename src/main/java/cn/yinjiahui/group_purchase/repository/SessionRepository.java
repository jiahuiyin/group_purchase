package cn.yinjiahui.group_purchase.repository;

import com.farsunset.cim.sdk.server.model.CIMSession;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class SessionRepository {

    private ConcurrentHashMap<String, CIMSession> map = new ConcurrentHashMap<>();


    public void save(CIMSession session) {
        map.put(session.getAccount(), session);
    }

    public CIMSession get(String account) {
        return map.get(account);
    }

    public void remove(String account) {
        map.remove(account);
    }

    public List<CIMSession> findAll() {
        return new LinkedList<>(map.values());
    }

    public boolean contains(Integer id) {
        return map.containsKey(id.toString());
    }
}
