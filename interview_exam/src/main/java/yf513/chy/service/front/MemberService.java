package yf513.chy.service.front;

import yf513.chy.domain.front.Member;

/**
 * @author CHY
 * @date 2020/12/5 9:49
 */
public interface MemberService {

    boolean register(Member member);

    Member login(String email, String password);

    /**
     * 根据id获取对应的昵称
     * @param id id值
     * @return nickName
     */
    String getLoginInfo(String id);

    Boolean logout(String id);
}
