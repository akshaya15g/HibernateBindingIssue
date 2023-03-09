# HibernateBindingIssue

run as spring boot application

Following output trace logs can be checked:

Hibernate: select i1_0.ref_no,i1_0.seq_no,i1_0.entityid,i1_0.lettr_guar_no,i1_0.party_under_obligor from rbi_trade.ot_gr_txn_details i1_0 where i1_0.lettr_guar_no=? and exists(select i2_0.party_code,i2_0.ref_no,i2_0.seq_no from rbi_trade.ot_txn_party i2_0 where i2_0.ref_no=i1_0.ref_no and i2_0.party_code='APP' and i2_0.party_id in(?))
2023-03-09T13:29:22.820+01:00 TRACE 12512 --- [   scheduling-1] org.hibernate.orm.jdbc.bind              : binding parameter [1] as [VARCHAR] - [GA3123-14831]
2023-03-09T13:29:22.821+01:00 TRACE 12512 --- [   scheduling-1] org.hibernate.orm.jdbc.bind              : binding parameter [2] as [VARCHAR] - [659086]
Hibernate: select i1_0.ref_no,i1_0.seq_no,i1_0.reg_by from rbi_trade.ot_workunit i1_0 where (i1_0.ref_no,i1_0.seq_no) in((?,?))
2023-03-09T13:29:22.857+01:00 TRACE 12512 --- [   scheduling-1] org.hibernate.orm.jdbc.bind              : binding parameter [1] as [VARCHAR] - [E313100005323221237]
2023-03-09T13:29:22.858+01:00 TRACE 12512 --- [   scheduling-1] org.hibernate.orm.jdbc.bind              : binding parameter [2] as [VARCHAR] - [001]
Hibernate: select p1_0.seq_no,p1_0.ref_no,p1_0.party_code,p1_0.party_id from rbi_trade.ot_txn_party p1_0 where (p1_0.seq_no,p1_0.ref_no) in((?,?))
2023-03-09T13:29:22.875+01:00 TRACE 12512 --- [   scheduling-1] org.hibernate.orm.jdbc.bind              : binding parameter [1] as [VARCHAR] - [E313100005323221237]
2023-03-09T13:29:22.875+01:00 TRACE 12512 --- [   scheduling-1] org.hibernate.orm.jdbc.bind              : binding parameter [2] as [VARCHAR] - [001]
