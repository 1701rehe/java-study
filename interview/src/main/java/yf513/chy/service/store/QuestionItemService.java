package yf513.chy.service.store;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.store.QuestionItem;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/27 14:37
 */
public interface QuestionItemService {
    /**
     * 添加
     *
     * @param questionItem 问题选项对象
     */
    void save(QuestionItem questionItem);

    /**
     * 删除
     *
     * @param questionItem 问题选项对象
     */
    void delete(QuestionItem questionItem);

    /**
     * 修改
     *
     * @param questionItem 问题选项对象
     */
    void update(QuestionItem questionItem);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    QuestionItem findById(String id);

    /**
     * 分页查询数据
     *
     * @param questionId 题目id
     * @param page       页码
     * @param size       每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(String questionId, int page, int size);

}
