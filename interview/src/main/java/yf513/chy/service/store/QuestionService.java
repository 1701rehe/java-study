package yf513.chy.service.store;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.store.Question;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/26 11:16
 */
public interface QuestionService {
    void update(Question question, boolean flag);

    /**
     * 添加
     *
     * @param question
     * @return 保存的图片名称
     */
    String save(Question question, boolean flag);

    /**
     * 删除
     *
     * @param question
     * @return
     */
    void delete(Question question);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    Question findById(String id);

    /**
     * 查询全部的数据
     *
     * @return 全部数据的列表对象
     */
    List<Question> findAll();

    /**
     * 分页查询数据
     *
     * @param page 页码
     * @param size 每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(int page, int size);

    /**
     * 获取包含了数据的流对象
     *
     * @return 包含了报表数据的流对象
     * @throws IOException 异常
     */
    ByteArrayOutputStream getReport() throws IOException;
}
