package model.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * Opportunity bean.
 * @author skuarch
 */
@Entity
@Table(name = "opportunity")
@NamedQueries({
    @NamedQuery(name = "getOpportunities", query = "from Opportunity o where o.isSoftDeleted = 0 order by o.id desc")    
})
public class Opportunity implements Serializable {

    @Id
    @Column(name = "opportunity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    
    @Column(name = "opportunity_is_new", nullable = false)
    private boolean isNew;
    
    @Column(name = "opportunity_is_active", nullable = false)
    private boolean isActive;  
    
    @OneToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;
    
    @OneToOne
    @JoinColumn(name = "odd_id", nullable = false)
    private Odd odd;    
    
    @OneToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "opportunity_head_count",
            joinColumns = {
                @JoinColumn(name = "opportunity_id", unique = false, nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "head_count_id", unique = false, nullable = false, updatable = false)}
    )
    private List<HeadCount> headCounts;
    
    /*@OneToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "opportunity_comment",
            joinColumns = {
                @JoinColumn(name = "opportunity_id", unique = false, nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "comment_id", unique = false, nullable = false, updatable = false)}
    )
    private List<Comment> comments;*/
    
    @Column(name = "opportunity_is_soft_deleted", nullable = false, columnDefinition = "default 0")
    private byte isSoftDeleted = 0;
    
    //==========================================================================
    public Opportunity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Odd getOdd() {
        return odd;
    }

    public void setOdd(Odd odd) {
        this.odd = odd;
    }

    public List<HeadCount> getHeadCounts() {        
        return headCounts;
    }

    public void setHeadCounts(List<HeadCount> headCounts) {
        this.headCounts = headCounts;
    }

    /*public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/

    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }
        
}
