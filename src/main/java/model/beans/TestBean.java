package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Table(name = "test_bean")
@Entity
public class TestBean implements Serializable {

    @Id
    @Column(name = "test_bean_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "test_bean_name")
    private String name;

    //==========================================================================
    public TestBean() {
    }

    //==========================================================================
    public long getId() {
        return id;
    }

    //==========================================================================
    public void setId(long id) {

        if (id > 1000) {
            throw new IllegalArgumentException("id is biggest than 1000");
        }

        if (id < 1) {
            throw new IllegalArgumentException("id is less than 1");
        }

        this.id = id;
    }

    //==========================================================================
    public String getName() {
        return name;
    }

    //==========================================================================
    public void setName(String name) {

        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("name is null or empty");
        }

        this.name = name;
    }

}
