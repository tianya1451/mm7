package com.zbensoft.mmsmp.db.mapper;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.ProductInfo;

public interface ProductInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbg.generated Mon Sep 03 09:13:58 CST 2018
     */
    int deleteByPrimaryKey(String productInfoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbg.generated Mon Sep 03 09:13:58 CST 2018
     */
    int insert(ProductInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbg.generated Mon Sep 03 09:13:58 CST 2018
     */
    int insertSelective(ProductInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbg.generated Mon Sep 03 09:13:58 CST 2018
     */
    ProductInfo selectByPrimaryKey(String productInfoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbg.generated Mon Sep 03 09:13:58 CST 2018
     */
    int updateByPrimaryKeySelective(ProductInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbg.generated Mon Sep 03 09:13:58 CST 2018
     */
    int updateByPrimaryKey(ProductInfo record);
    
    List<ProductInfo> selectPage(ProductInfo record);
    
    int count(ProductInfo record);
    
    ProductInfo getVasSpCpInfo(ProductInfo record);
    
    List<ProductInfo> getAllVasServiceRelation();
    
}