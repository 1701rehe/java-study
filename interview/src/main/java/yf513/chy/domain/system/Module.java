package yf513.chy.domain.system;

/**
 * @author CHY
 * @date 2020/12/2 15:02
 */
public class Module {
    private String id;
    private String parentId;
    private String name;
    private Long ctype; // 表明是一级菜单还是二级菜单
    private Integer state;
    private String curl;
    private String remark;

    private Module module;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCtype() {
        return ctype;
    }

    public void setCtype(Long ctype) {
        this.ctype = ctype;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
