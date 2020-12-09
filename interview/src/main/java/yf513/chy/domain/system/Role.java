package yf513.chy.domain.system;

import java.util.Date;

/**
 * @author CHY
 * @date 2020/11/30 16:50
 */
public class Role {
    private String id;
    private String name;
    private String remark;
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreationTime(Date createTime) {
        this.createTime = createTime;
    }
}
