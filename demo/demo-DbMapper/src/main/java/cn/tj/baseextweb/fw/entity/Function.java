package cn.tj.baseextweb.fw.entity;

// Generated 2014-9-10 22:31:18 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Function generated by hbm2java
 */
@Entity
@Table(name = "tab_function")
public class Function implements java.io.Serializable {

    private Long fid;
    private Function function;
    private String fname;
    private Integer forder;
    private String furl;
    private String level;
    private Set<RefRoleFunction> refRoleFunctions = new HashSet<RefRoleFunction>(0);
    private Set<Function> functions = new HashSet<Function>(0);

    public Function() {
    }

    public Function(Function function, String fname, Integer forder, String furl, String level, Set<RefRoleFunction> refRoleFunctions, Set<Function> functions) {
        this.function = function;
        this.fname = fname;
        this.forder = forder;
        this.furl = furl;
        this.level = level;
        this.refRoleFunctions = refRoleFunctions;
        this.functions = functions;
    }

    @Id
    @GeneratedValue
    @Column(name = "fid", unique = true, nullable = false)
    public Long getFid() {
        return this.fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    public Function getFunction() {
        return this.function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    @Column(name = "fname")
    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Column(name = "forder")
    public Integer getForder() {
        return this.forder;
    }

    public void setForder(Integer forder) {
        this.forder = forder;
    }

    @Column(name = "furl")
    public String getFurl() {
        return this.furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    @Column(name = "level")
    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "function")
    public Set<RefRoleFunction> getRefRoleFunctions() {
        return this.refRoleFunctions;
    }

    public void setRefRoleFunctions(Set<RefRoleFunction> refRoleFunctions) {
        this.refRoleFunctions = refRoleFunctions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "function")
    public Set<Function> getFunctions() {
        return this.functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }

}
