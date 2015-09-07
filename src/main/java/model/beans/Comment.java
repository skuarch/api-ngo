package model.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "comment_text", nullable = false, columnDefinition = "LONGVARCHAR")
    private String text;
    
    @Column(name = "comment_creation_date", nullable = false)
    private String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    
    @Column(name = "comment_is_soft_deleted", nullable = false)
    private byte isSoftDeleted = 0;
    
    //==========================================================================
    public Comment() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(text.length() > 1000){
            throw new IllegalArgumentException("text of comment is larger than 1000");
        }
        this.text = text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }
    
}
