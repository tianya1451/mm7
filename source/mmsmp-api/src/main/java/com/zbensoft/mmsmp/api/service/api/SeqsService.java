package com.zbensoft.mmsmp.api.service.api;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.Seqs;
import com.zbensoft.mmsmp.db.domain.SysLog;

public interface SeqsService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seqs
     *
     * @mbg.generated Sat Feb 24 14:05:14 CST 2018
     */
    int deleteByPrimaryKey(String seqsCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seqs
     *
     * @mbg.generated Sat Feb 24 14:05:14 CST 2018
     */
    int insert(Seqs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seqs
     *
     * @mbg.generated Sat Feb 24 14:05:14 CST 2018
     */
    int insertSelective(Seqs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seqs
     *
     * @mbg.generated Sat Feb 24 14:05:14 CST 2018
     */
    Seqs selectByPrimaryKey(String seqsCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seqs
     *
     * @mbg.generated Sat Feb 24 14:05:14 CST 2018
     */
    int updateByPrimaryKeySelective(Seqs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seqs
     *
     * @mbg.generated Sat Feb 24 14:05:14 CST 2018
     */
    int updateByPrimaryKey(Seqs record);
    
    
    List<Seqs> selectPage(Seqs record);

	int count(Seqs record);

	int updateBySeqNumber(Seqs updateBean);
    
}