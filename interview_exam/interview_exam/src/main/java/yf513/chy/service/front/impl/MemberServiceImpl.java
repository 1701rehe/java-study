package yf513.chy.service.front.impl;

import org.apache.ibatis.session.SqlSession;
import redis.clients.jedis.Jedis;
import yf513.chy.dao.front.MemberDao;
import yf513.chy.domain.front.Member;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.front.MemberService;
import yf513.chy.utils.JedisUtils;
import yf513.chy.utils.MD5Util;
import yf513.chy.utils.TransactionUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/12/5 9:49
 */
public class MemberServiceImpl implements MemberService {
    @Override
    public boolean register(Member member) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            MemberDao memberDao = MapperFactory.getMapper(sqlSession, MemberDao.class);
            //id使用UUID的生成策略
            String id = UUID.randomUUID().toString();
            member.setId(id);
            member.setRegisterDate(new Date());
            member.setState("1");  //启用中
            //加密操作
            member.setPassword(MD5Util.md5(member.getPassword()));
            //调用Dao层操作
            int row = memberDao.save(member);
            //提交事务
            TransactionUtil.commit(sqlSession);
            return row > 0;  //返回操作成功与否
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Member login(String email, String password) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            MemberDao memberDao = MapperFactory.getMapper(sqlSession, MemberDao.class);
            //密码加密
            password = MD5Util.md5(password);
            Member member = memberDao.findByEmailAndPwd(email, password);
            //将登录人的信息存到redis中
            Jedis jedis = JedisUtils.getResource();
            jedis.auth("123456");
            jedis.setex(member.getId(), 3600, member.getNickName());
            jedis.close();

            return member;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            TransactionUtil.close(sqlSession);
        }
    }

    @Override
    public String getLoginInfo(String id) {
        Jedis jedis = JedisUtils.getResource();
        jedis.auth("123456");
        String nickName = jedis.get(id);
        jedis.close();
        return nickName;
    }

    @Override
    public Boolean logout(String id) {
        Jedis jedis = JedisUtils.getResource();
        jedis.auth("123456");
        Long row = jedis.del(id);
        jedis.close();
        return row > 0;
    }
}
