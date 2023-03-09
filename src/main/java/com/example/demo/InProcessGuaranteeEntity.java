package com.example.demo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "OT_GR_TXN_DETAILS", schema = "RBI_TRADE")
@IdClass(InProcessRefSeqNoId.class)
@EqualsAndHashCode
@ToString
public class InProcessGuaranteeEntity {

    private String refNo;
    private String seqNo;

    private Set<InProcessPartyEntity> parties;

    private String guaranteeNumber;

    private String entityId;

    private InProcessWorkUnitEntity workUnit;

    private String partyUnderObligor;

    @Id
    @Column(name = "REF_NO")
    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Id
    @Column(name = "SEQ_NO")
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @OneToMany(fetch = EAGER)
    @JoinColumns({
            @JoinColumn(name = "SEQ_NO", referencedColumnName = "SEQ_NO"),
            @JoinColumn(name = "REF_NO", referencedColumnName = "REF_NO")
    })
    public Set<InProcessPartyEntity> getParties() {
        return parties;
    }

    public void setParties(Set<InProcessPartyEntity> participants) {
        this.parties = participants;
    }

    @Basic
    @Column(name = "LETTR_GUAR_NO")
    public String getGuaranteeNumber() {
        return guaranteeNumber;
    }

    public void setGuaranteeNumber(String lettrGuarNo) {
        this.guaranteeNumber = lettrGuarNo;
    }

    @Basic
    @Column(name = "ENTITYID")
    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }


    @OneToOne(fetch = EAGER)
    @JoinColumns({
            @JoinColumn(name = "REF_NO", referencedColumnName = "REF_NO"),
            @JoinColumn(name = "SEQ_NO", referencedColumnName = "SEQ_NO")
    })
    public InProcessWorkUnitEntity getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(InProcessWorkUnitEntity workUnit) {
        this.workUnit = workUnit;
    }

    @Basic
    @Column(name="PARTY_UNDER_OBLIGOR")
    public String getPartyUnderObligor() {
        return partyUnderObligor;
    }

    public void setPartyUnderObligor(String partyUnderObligor) {
        this.partyUnderObligor = partyUnderObligor;
    }


}
