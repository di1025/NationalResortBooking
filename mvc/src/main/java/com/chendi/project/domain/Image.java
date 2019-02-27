package com.chendi.project.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.net.URL;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy =SEQUENCE,generator = "images_id_seq")
    @SequenceGenerator(name="images_id_seq",sequenceName="images_id_seq",allocationSize=1)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;

    @Column
    private URL url;

    @Column
    private String extension;

    @Column(name="s3_key")
    private String s3Key;

    @Column
    private String uuid=UUID.randomUUID().toString();

    @Column
    private String bucket;

    public Long getId() {
        return id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }

    public String getUuid() {
        return uuid;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
//url,s3key(uuid+extension),uuid,bucket,extension,userid

}
