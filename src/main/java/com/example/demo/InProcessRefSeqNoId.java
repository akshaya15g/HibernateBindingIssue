package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
public class InProcessRefSeqNoId implements Serializable {

    private String refNo;
    private String seqNo;

    @Column(name = "REF_NO")
    @Id
    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Column(name = "SEQ_NO")
    @Id
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}
