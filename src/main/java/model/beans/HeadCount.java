package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "head_count")
public class HeadCount implements Serializable {

    @Id
    @Column(name = "head_count_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "head_count_open_seat", nullable = false)
    private String openSeat;
    
    @OneToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;
    
    //==========================================================================
    public HeadCount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }    

    public String getOpenSeat() {
        return openSeat;
    }

    public void setOpenSeat(String openSeat) {
        this.openSeat = openSeat;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    
}
