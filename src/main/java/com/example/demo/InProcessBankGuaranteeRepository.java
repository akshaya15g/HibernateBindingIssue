package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.springframework.util.CollectionUtils.isEmpty;

public interface InProcessBankGuaranteeRepository extends JpaRepository<InProcessGuaranteeEntity, InProcessRefSeqNoId> {

    default Optional<InProcessGuaranteeEntity> findMostRecentMatching(
                                                                          List<String> partyCifList,
                                                                          String guaranteeNumber) {



        return findMostRecentMatchingWithNonEmptyExcludedTcs( partyCifList, guaranteeNumber);
    }

    @Query("select t from InProcessGuaranteeEntity t " +
            "where t.guaranteeNumber = :guaranteeNumber " +
            "and exists (select l from InProcessPartyEntity l where l.refNo = t.refNo and l.partyCode = 'APP' and l.partyId in :partyCifList)" )
    Optional<InProcessGuaranteeEntity> findMostRecentMatchingWithNonEmptyExcludedTcs(
                                                                                         @Param("partyCifList") List<String> partyCifList,
                                                                                         @Param("guaranteeNumber") String guaranteeNumber);


}
