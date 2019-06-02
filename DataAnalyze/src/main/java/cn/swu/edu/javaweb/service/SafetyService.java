package cn.swu.edu.javaweb.service;

import cn.swu.edu.javaweb.user.User;

public interface SafetyService {
    public User save(User safety) throws Exception;

    public void delete(Long id,Long uid);

    public User load(Long uid, String username, String mobile);
}
