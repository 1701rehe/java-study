package yf513.chy.dao.front;

import org.apache.ibatis.annotations.Param;
import yf513.chy.domain.front.Member;

/**
 * @author CHY
 * @date 2020/12/5 9:45
 */
public interface MemberDao {

    int save(Member member);

    Member findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
