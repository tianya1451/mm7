 package com.zbensoft.mmsmp.corebiz.cache;
 
 import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbensoft.mmsmp.common.ra.common.db.entity.CpInfo;
import com.zbensoft.mmsmp.common.ra.common.db.entity.ProductService;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.SysParameters;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.UserBlackWhiteList;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.UserOrder;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.Vas;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.Vasp;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.VaspReserveInfo;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.Vasservice;
 import com.zbensoft.mmsmp.common.ra.common.db.entity.VasserviceReserveInfo;
 import com.zbensoft.mmsmp.corebiz.dao.DaoUtil;
 import com.zbensoft.mmsmp.corebiz.dao.SmsDAO;
 import com.zbensoft.mmsmp.common.ra.vas.sjb.data.DemandDto;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Map;
import java.util.Random;
import java.util.Set;
 import java.util.concurrent.ConcurrentHashMap;
 import org.apache.log4j.Logger;
import com.zbensoft.mmsmp.corebiz.util.HttpRequestHelper;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
 
 
 
 
 
 
 
 
 
 
 public class DataCache
 {
   private static final Logger log = Logger.getLogger(DataCache.class);
//   private DaoUtil daoUtil;
   
//   public void setDaoUtil(DaoUtil daoUtil)
//   {
//     this.daoUtil = daoUtil;
//   }
   
 
   private Map<String, Vasp> spInfoBySpid = new ConcurrentHashMap();
   
   private Map<String, Vas> vasInfoById = new ConcurrentHashMap();
   
   private Map<String, Vasservice> productInfoById = new ConcurrentHashMap();
   
   private Map<String, String> sysParams = new ConcurrentHashMap();
   
   private Map<String, UserBlackWhiteList> whiteUser = new ConcurrentHashMap();
   
   private Map<String, CpInfo> cpInfoUser = new ConcurrentHashMap();
   
   private Map<String, Vasservice> productInfoByOrderText = new ConcurrentHashMap();
   private Map<String, Vasservice> productInfoByCancelText = new ConcurrentHashMap();
   private Map<String, Vasservice> productInfoByDemandText = new ConcurrentHashMap();
   
   private Map<String, Vasservice> productInfoByDemandNumber = new ConcurrentHashMap();
   
   private Map<String, Vasservice> productInfoByMoOrder = new ConcurrentHashMap();
   private Map<String, Vasservice> productInfoByMoCancel = new ConcurrentHashMap();
   private Map<String, Vasservice> productInfoByMoDemand = new ConcurrentHashMap();
   
 
   private Map<String, Vasp> ownerSpInfoBySpid = new ConcurrentHashMap();
   
 
   private Map<String, String> ownerSpReportURL = new ConcurrentHashMap();
   
 
   private Map<String, String> VasidsByOwner = new ConcurrentHashMap();
   
 
   Map<String, String> ownerOrderRelations = new ConcurrentHashMap();
   
 
 
 
   Map<String, com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto> SmsSenderDtoMap = new ConcurrentHashMap();
   
   public com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto getSmsSenderDtoMap(String vasid) { return (com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto)this.SmsSenderDtoMap.get(vasid); }
   
 
   public void setSmsSenderDtoMap(Map<String, com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto> smsSenderDtoMap) { this.SmsSenderDtoMap = smsSenderDtoMap; }
   
   public void refreshCPSpVasservice() {
//     List<com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto> SmsSenderDtoList = this.daoUtil.getSmsDAO().getCPSpVasserviceInfo();
//     for (int i = 0; i < SmsSenderDtoList.size(); i++) {
//       this.SmsSenderDtoMap.put(((com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto)SmsSenderDtoList.get(i)).getVasid(), (com.zbensoft.mmsmp.corebiz.handle.impl.sms.SmsSenderDto)SmsSenderDtoList.get(i));
//     }
   }
   
 
 
   private Set<String> thirdOrder = new HashSet(300000);
   
   public synchronized boolean isThridOrderExist(String cellPhoneNumber, String productId) {
     boolean r = false;
     
     if (this.thirdOrder.size() == 0) {
       refreshThirdOrder();
     }
     r = this.thirdOrder.contains(cellPhoneNumber + "|" + productId);
     
     return r;
   }
   
   public void refreshThirdOrder() {
//     long begin = System.currentTimeMillis();
//     this.thirdOrder = new HashSet(300000);
//     this.thirdOrder.addAll(this.daoUtil.getSmsDAO().getThirdOrder());
//     log.info("@load@ thirdOrder in :" + (System.currentTimeMillis() - begin) + " millisecond");
   }
   
   public int getThridOrderCacheSize() {
     return this.thirdOrder.size();
   }
   
   public synchronized void cleanThridOrder() {
     this.thirdOrder = new HashSet(300000);
   }
   
   public String getVasidsByOwner(String vasId)
   {
     if (!this.VasidsByOwner.containsKey(vasId))
     {
 
    	 
    	 //String vaspid = "vaspid001"+vasId; this.daoUtil.getSmsDAO().getSpIdByVasId(spNumber);
    	 String vaspid = HttpRequestHelper.getSpIdByVasId(vasId);
       
       if (this.ownerSpInfoBySpid.get(vaspid) != null)
       {
    	   //完成修改
           this.VasidsByOwner.put(vasId, vasId);
       }
     }
     
     return (String)this.VasidsByOwner.get(vasId);//get(spNumber);
   }
   
   public boolean isExistOrderRelation(String charge, String uniqueid)
   {
     if (!this.ownerOrderRelations.containsKey(charge))
     {
//       UserOrder userOrder = this.daoUtil.getSmsDAO().getUserOrder(charge, uniqueid);
    	 UserOrder userOrder = HttpRequestHelper.getUserOrder(charge ,uniqueid);
       if (userOrder != null) {
         this.ownerOrderRelations.put(charge, uniqueid);
         return true;
       }
       return false;
     }
     return true;
   }
   
 
 
   List<String> orderTextList = new ArrayList();
   List<String> cancelTextList = new ArrayList();
   List<String> demandTextList = new ArrayList();
   
 
   private Map<String, String> demandTextMap = new ConcurrentHashMap();
   private Map<String, String> orderTextMap = new ConcurrentHashMap();
   private Map<String, String> cancelTextMap = new ConcurrentHashMap();
   
   Map<String, String> spurlByVASPID = new HashMap();
   
   public String getSpurlByVaspid(String vaspid)
   {
     String value = null;
     String key = vaspid;
     
     if (!this.spurlByVASPID.containsKey(key))
     {
//       value = this.daoUtil.getSmsDAO().getSpurlByVaspid(key);
    	 value = HttpRequestHelper.getSpurlByVaspid(vaspid);
       if ((value != null) && (!value.equals(""))) {
         this.spurlByVASPID.put(key, value);
       }
     }
     
     return (String)this.spurlByVASPID.get(key);
   }
   
 
 
 
   Map<String, String> spurlByProductid = new ConcurrentHashMap();
   
   public String getSpurlByProductid(String spProductid)
   {
     String value = null;
     String key = spProductid;
     
     if (!this.spurlByProductid.containsKey(key))
     {
//       value = this.daoUtil.getMm7dao().getSpReportUrlByServiceCode(spProductid);
    	 value = HttpRequestHelper.getSpReportUrlByServiceCode(spProductid);
       if ((value != null) && (!value.equals(""))) {
         this.spurlByProductid.put(key, value);
       }
     }
     
     return (String)this.spurlByProductid.get(key);
   }
   
   Map<String, ProductService> requestAccId = new ConcurrentHashMap();
   
   public ProductService requestacc(String onDemandAccess)
   {
     String value = null;
     String key = onDemandAccess;
     
     if (!this.requestAccId.containsKey(key))
     {
//       value = this.daoUtil.getMm7dao().getSpReportUrlByServiceCode(spProductid);
    	 ProductService productService = HttpRequestHelper.requestacc(onDemandAccess);
       if ((productService != null) && (!productService.equals(""))) {
         this.requestAccId.put(key, productService);
       }
     }
     
     return this.requestAccId.get(key);
   }
   
 
   Map<String, String> uniqueidByProductids = new ConcurrentHashMap();
   
   public String getUniqueidByProductid(String spProductid)
   {
     String value = null;
     String key = spProductid;
     
     if (!this.uniqueidByProductids.containsKey(key))
     {
//       value = this.daoUtil.getMm7dao().getServuniqueIdbySpproductid(spProductid);
    	 value = HttpRequestHelper.getServuniqueIdbySpproductid(spProductid);
       if ((value != null) &&(!value.equals(""))) {
         this.uniqueidByProductids.put(key, value);
       }
     }
     
     return (String)this.uniqueidByProductids.get(key);
   }
   
 
 
 
 
 
   Map<String, String> serviceIdByProductids = new ConcurrentHashMap();
   
   public String getServiceIdByProductid(String spProductid)
   {
     String value = null;
     String key = spProductid;
     
     if (!this.serviceIdByProductids.containsKey(key))
     {
//       value = this.daoUtil.getMm7dao().getServiceIDbyProductid(key);
       value = HttpRequestHelper.getServiceIDbyProductid(key);
       if ((value != null) &&(!value.equals(""))) {
           this.serviceIdByProductids.put(key, value);
         }
     }
     return (String)this.serviceIdByProductids.get(key);
   }
   
 
 
 
 
   Map<String, String> mmsmtLimitByServiceids = new ConcurrentHashMap();
   
   public String getMmsmtLimitByServiceid(String serviceid)
   {
//     String value = null;
//     String key = serviceid;
//     
//     if (!this.mmsmtLimitByServiceids.containsKey(key))
//     {
//    	//TODO 数据库调用，待修改;Already processed;is ok
//       value = "1000";
//       value=this.daoUtil.getMm7dao().getMTLimitNumber(key);
//       if ((value != null) && (!value.equals(""))) {
//         this.mmsmtLimitByServiceids.put(key, value);
//       }
//     }
//     
//     return (String)this.mmsmtLimitByServiceids.get(key);
	   
	   //业务能力改为放到system_config中进行存储。
	   return getSysParams("CAPACITY_ID");
   }
   
 
 
 
 
   Map<String, DemandDto> demandDtoBySendtos = new ConcurrentHashMap();
   
   public DemandDto getDemandDtoBySendto(String sendto)
   {
	return null;
//     DemandDto dto = null;
//     String key = sendto;
//     
//     if (!this.demandDtoBySendtos.containsKey(key))
//     {
//       dto = this.daoUtil.getDemandDao().getDemandDto(key);
//       if (dto != null) {
//         this.demandDtoBySendtos.put(key, dto);
//       }
//     }
//     
//     return (DemandDto)this.demandDtoBySendtos.get(key);
   }
   
 
 
 
 
   Map<String, com.zbensoft.mmsmp.common.ra.send.sgipsms.SmsSenderDto> dianBoByNumbers = new ConcurrentHashMap();
   String errorMsgTemplate;
   
   public com.zbensoft.mmsmp.common.ra.send.sgipsms.SmsSenderDto getDianBoByNumber(String sendto) {
	return null;
//	   com.zbensoft.mmsmp.common.ra.send.sgipsms.SmsSenderDto dto = null;
//     String key = sendto;
//     
//     if (!this.dianBoByNumbers.containsKey(key))
//     {
//       dto = this.daoUtil.getDemandDao().getDianBoByNumber(key);
//       if (dto != null) {
//         this.dianBoByNumbers.put(key, dto);
//       }
//     }
//     
//     return (com.zbensoft.mmsmp.common.ra.send.sgipsms.SmsSenderDto)this.dianBoByNumbers.get(key);
	   
   }
   
 
 
 
 
 
   public String queryErrorMsgTemplate()
   {
	return errorMsgTemplate;
//     if (this.errorMsgTemplate == null)
//     {
//       this.errorMsgTemplate = this.daoUtil.getDemandDao().queryErrorMsgTemplate();
//     }
//     return this.errorMsgTemplate;
   }
   
 
 
 
 
 
   public String queryUpOndemandMessage()
   {
	return errorMsgTemplate;
//     if (this.upOndemandMessage == null)
//     {
//       this.upOndemandMessage = this.daoUtil.getDemandDao().queryUpOndemandMessage();
//     }
//     return this.upOndemandMessage;
   }
   
 
 
 
 
 
   public String queryOndemandMessage()
   {
	return errorMsgTemplate;
//     if (this.ondemandMessage == null)
//     {
//       this.ondemandMessage = this.daoUtil.getDemandDao().queryOndemandMessage();
//     }
//     return this.ondemandMessage;
   }
   
 
 
 
 
 
   public void refreshAll()
   {
     refreshSpInfo();
     refreshVasInfo();
     refreshProductInfo();
     refreshSysParmas();
     refreshWhiteList();
     refreshOwnSpInfo();
     refreshBlackList();
     refreshCPSpVasservice();
     refreshThirdOrder();
     
 
     this.ondemandMessage = null;
     this.upOndemandMessage = null;
     this.errorMsgTemplate = null;
     try {
       this.dianBoByNumbers.clear(); } catch (Exception localException) {}
     try { this.demandDtoBySendtos.clear(); } catch (Exception localException1) {}
     try { this.mmsmtLimitByServiceids.clear(); } catch (Exception localException2) {}
     try { this.serviceIdByProductids.clear(); } catch (Exception localException3) {}
     try { this.uniqueidByProductids.clear(); } catch (Exception localException4) {}
     try { this.spurlByProductid.clear(); } catch (Exception localException5) {}
     try { this.VasidsByOwner.clear(); } catch (Exception localException6) {}
     try { this.ownerOrderRelations.clear();
     }
     catch (Exception localException7) {}
   }
   
 
   

 
   public void refreshSpInfo()
   {
     List<Vasp> spList = HttpRequestHelper.getSpInfo();
 
     Vasp spInfo = null;
     Map<String, Vasp> spInfoBySpid = new HashMap();
     for (int i = 0; i < spList.size(); i++) {
       spInfo = (Vasp)spList.get(i);
       spInfoBySpid.put(spInfo.getVaspid(), spInfo);
     }
     this.spInfoBySpid = spInfoBySpid;
   }
   
 
 
   public void refreshOwnSpInfo()
   {
//     List<Vasp> ownSpList = this.daoUtil.getSmsDAO().findOwnSpInfo();
//     Vasp ownSpInfo = null;
//     
//     Map<String, Vasp> ownSpInfoBySpId = new HashMap();
//     
//     Map<String, String> ownSpReportUrl = new HashMap();
//     
//     for (int i = 0; i < ownSpList.size(); i++)
//     {
//       ownSpInfo = (Vasp)ownSpList.get(i);
//       ownSpInfoBySpId.put(ownSpInfo.getVaspid(), ownSpInfo);
//       
//       String reportUrl = ownSpInfo.getVaspReserveInfo().getReportmessageurl();
//       ownSpReportUrl.put(reportUrl, reportUrl);
//     }
//     
// 
//     this.ownerSpInfoBySpid = ownSpInfoBySpId;
//     this.ownerSpReportURL = ownSpReportUrl;
   }
   
 
 
 
 
   public void refreshVasInfo()
   {
//     List<Vas> vasList = this.daoUtil.getBusinessManageDAO().findVasInfo();
//     Vas vas = null;
//     Map<String, Vas> vasInfoById = new HashMap();
//     for (int i = 0; i < vasList.size(); i++) {
//       vas = (Vas)vasList.get(i);
//       vasInfoById.put(vas.getServiceId(), vas);
//     }
//     this.vasInfoById = vasInfoById;
   }
   
 
 
 
   public void refreshProductInfo()
   {
     List<Vasservice> servList = HttpRequestHelper.getNormalStatus();
     Vasservice productInfo = null;
     Map<String, Vasservice> productInfoById = new HashMap();
     
     Map<String, Vasservice> productInfoByOrderText = new HashMap();
     Map<String, Vasservice> productInfoByCancelText = new HashMap();
     Map<String, Vasservice> productInfoByDemandText = new HashMap();
     
     Map<String, Vasservice> productInfoByDemandNumber = new HashMap();
     
     Map<String, Vasservice> productInfoByMoOrder = new HashMap();
     Map<String, Vasservice> productInfoByMoCancel = new HashMap();
     Map<String, Vasservice> productInfoByMoDemand = new HashMap();
     
     List<String> orderTextList = new ArrayList();
     List<String> cancelTextList = new ArrayList();
     List<String> demandTextList = new ArrayList();
     
 
     Map<String, String> demandTextMap = new HashMap();
     Map<String, String> orderTextMap = new HashMap();
     Map<String, String> cancelTextMap = new HashMap();
     
 
     for (int i = 0; i < servList.size(); i++) {
       productInfo = (Vasservice)servList.get(i);
       productInfoById.put(productInfo.getVasserviceReserveInfo().getSpProductid(), productInfo);
       productInfoByDemandNumber.put(productInfo.getVasid(), productInfo);
       productInfoByDemandNumber.put(productInfo.getVasserviceReserveInfo().getRequestacc(), productInfo);
       if ((productInfo.getOrdercode() != null) && (!"".equals(productInfo.getOrdercode().trim())))
       {
         productInfoByOrderText.put(productInfo.getOrdercode() + productInfo.getVasid(), productInfo);
         
         productInfoByCancelText.put(productInfo.getCancelordercode(), productInfo);
         
         productInfoByMoOrder.put(productInfo.getOrdercode() + productInfo.getVasid(), productInfo);
         
         productInfoByMoCancel.put(productInfo.getCancelordercode() + productInfo.getVasid(), productInfo);
         
         productInfoByMoOrder.put(productInfo.getOrdercode() + productInfo.getVasserviceReserveInfo().getOrderacc(), productInfo);
         
         productInfoByMoCancel.put(productInfo.getCancelordercode() + productInfo.getVasserviceReserveInfo().getCancelacc(), productInfo);
         
         try {
			if ((productInfo.getOrdercode().contains("#")) || (productInfo.getOrdercode().contains("*")))
			 {
			   orderTextList.add(productInfo.getOrdercode());
			   orderTextMap.put(productInfo.getVasid(), productInfo.getOrdercode());
 
			 }
			 else if ((productInfo.getCancelordercode().contains("#")) || (productInfo.getCancelordercode().contains("*")))
			 {
			   cancelTextList.add(productInfo.getCancelordercode());
			   cancelTextMap.put(productInfo.getVasid(), productInfo.getCancelordercode());
			 }
         } catch (Exception e) {
         }
       }
       else
       {
         productInfoByDemandText.put(productInfo.getOndemandcode(), productInfo);
         
         productInfoByMoDemand.put(productInfo.getOndemandcode() + productInfo.getVasserviceReserveInfo().getRequestacc(), productInfo);
         
         productInfoByMoDemand.put(productInfo.getOndemandcode() + productInfo.getVasid(), productInfo);
         if ((productInfo.getOndemandcode().contains("#")) || (productInfo.getOndemandcode().contains("*"))) {
           demandTextList.add(productInfo.getOndemandcode());
           demandTextMap.put(productInfo.getVasid(), productInfo.getOndemandcode());
         }
       }
     }
     
 
     this.productInfoById = productInfoById;
     this.productInfoByOrderText = productInfoByOrderText;
     this.productInfoByCancelText = productInfoByCancelText;
     this.productInfoByDemandText = productInfoByDemandText;
     this.productInfoByMoOrder = productInfoByMoOrder;
     this.productInfoByMoCancel = productInfoByMoCancel;
     this.productInfoByMoDemand = productInfoByMoDemand;
     
     this.orderTextList = orderTextList;
     this.cancelTextList = cancelTextList;
     this.demandTextList = demandTextList;
     this.demandTextMap = demandTextMap;
     this.orderTextMap = orderTextMap;
     this.cancelTextMap = cancelTextMap;
   }
   
 
 
   public void refreshSysParmas()
   {
     Map<String, String> sysParams = new HashMap();
//     List<SysParameters> sysParamsList = this.daoUtil.getBusinessManageDAO().findAllSysParams();
     List<SysParameters> sysParamsList = HttpRequestHelper.getSysConfig();
     for (SysParameters sysParameters : sysParamsList) {
		System.out.println(sysParameters.getValue());
	}
     SysParameters sysParam = null;
     log.info("refresh system parameters\n");
     for (int i = 0; i < sysParamsList.size(); i++) {
       sysParam = (SysParameters)sysParamsList.get(i);
       sysParams.put(sysParam.getName(), sysParam.getValue());
       log.info("[" + sysParam.getName() + ":" + sysParam.getValue() + "]");
     }
     this.sysParams = sysParams;
   }
   
 
 
   public void refreshWhiteList()
   {
     List<UserBlackWhiteList> userList = HttpRequestHelper.getWhiteList();
     UserBlackWhiteList user = null;
     Map<String, UserBlackWhiteList> whiteUser = new HashMap();
     for (int i = 0; i < userList.size(); i++) {
       user = (UserBlackWhiteList)userList.get(i);
       whiteUser.put(user.getProductId() + user.getCellphoneNumber(), user);
     }
     this.whiteUser = whiteUser;
   }
   
   
   
   public void refreshCpInfo()
   {
     List<CpInfo> cpInfoList = HttpRequestHelper.getCpInfo();
     CpInfo cpInfo = null;
     Map<String, CpInfo> cpInfoUser = new HashMap();
     for (int i = 0; i < cpInfoList.size(); i++) {
    	 cpInfo = (CpInfo)cpInfoList.get(i);
    	 cpInfoUser.put("" + cpInfo.getCpid(), cpInfo);
     }
     this.cpInfoUser = cpInfoUser;
   }
   
   public CpInfo getCpInfoByCpid(String cpid){
	   return this.cpInfoUser.get(cpid);
   }
   
   public void refreshBlackList()
   {
	   List<UserBlackWhiteList> userList = HttpRequestHelper.getBlackList();
	   for (UserBlackWhiteList userBlackWhiteList : userList) {
		   System.out.println(userBlackWhiteList.getCellphoneNumber());
	   }
	   UserBlackWhiteList user = null;
	   Map<String, UserBlackWhiteList> whiteUser = new HashMap();
	   for (int i = 0; i < userList.size(); i++) {
		   user = (UserBlackWhiteList)userList.get(i);
		   whiteUser.put(user.getProductId() + user.getCellphoneNumber(), user);
	   }
	   this.whiteUser = whiteUser;
   }
   
 
   public Vasp getSpInfoBySpid(String spid)
   {
     return (Vasp)this.spInfoBySpid.get(spid);
   }
   
 
 
 
 
   public Vas getVasInfoById(String vasid)
   {
     return (Vas)this.vasInfoById.get(vasid);
   }
   
 
 
 
   public Vasservice getProductInfoById(String id)
   {
     return (Vasservice)this.productInfoById.get(id);
   }
   
 
 
 
 
 
   public String getSysParams(String name)
   {
     return (String)this.sysParams.get(name);
   }
   
   public String getSysParams(String name, String defaultValue)
   {
     String value = (String)this.sysParams.get(name);
     return value == null ? defaultValue : value;
   }
   
 
 
   String upOndemandMessage;
   
   String ondemandMessage;
   
   public boolean isWhiteUser(String productId, String phoneNumber)
   {
     UserBlackWhiteList user = (UserBlackWhiteList)this.whiteUser.get(productId + phoneNumber);
     if (user == null) {
       return false;
     }
     return true;
   }
   
 
   Map[] whiteMap = { new ConcurrentHashMap(), new ConcurrentHashMap(), new ConcurrentHashMap(), new ConcurrentHashMap() };
   
   public boolean isWhiteUser(String phoneNumber, String productId, String spNumber)
   {
     String phone = phoneNumber == null ? "" : phoneNumber.trim();
     String pid = productId == null ? "" : productId.trim();
     String num = spNumber == null ? "" : spNumber.trim();
     
     if ((!pid.equals("")) && (pid.equals("001")))
     {
       return true;
     }
     
 
     if ((!num.equals("")) && (this.whiteMap[2].containsKey(num)))
     {
       return true;
     }
     
 
 
     if ((!pid.equals("")) && (this.whiteMap[1].containsKey(pid)))
     {
       return true;
     }
     
 
     if ((!pid.equals("")) && (!phone.equals("")) && (this.whiteMap[0].containsKey(pid + phone)))
     {
       return true;
     }
     
     return false;
   }
   
 
 
 
 
   public int isWhiteUserMMS_MT(String phoneNumber, String productId, String spNumber)
   {
     String phone = phoneNumber == null ? "" : phoneNumber.trim();
     String pid = productId == null ? "" : productId.trim();
     String num = spNumber == null ? "" : spNumber.trim();
     
     if ((!pid.equals("")) && (pid.equals("001")))
     {
       return 1;
     }
     
 
     if ((!num.equals("")) && (this.whiteMap[2].containsKey(num)))
     {
       return 2;
     }
     
 
 
     if ((!pid.equals("")) && (this.whiteMap[1].containsKey(pid)))
     {
       return 1;
     }
     
 
     if ((!pid.equals("")) && (!phone.equals("")) && (this.whiteMap[0].containsKey(pid + phone)))
     {
       return 0;
     }
     
 
     if ((!pid.equals("")) && (this.whiteMap[3].containsKey(pid)))
     {
       String mms_switch = (String)this.whiteMap[3].get(pid);
       
       mms_switch = mms_switch == null ? "0" : mms_switch;
       
       if (mms_switch.equals("0"))
       {
         return 30;
       }
       
 
       return 31;
     }
     
 
 
 
     return -1;
   }
   
 
 
 
 
   public Vasservice getProductByText(String moText)
   {
     Vasservice vasService = null;
     return vasService;
   }
   
 
 
 
   public Vasservice getProductByNumber(String accessNumber)
   {
     Vasservice vasService = null;
     return vasService;
   }
   
 
 
 
 
   public Vasservice getOrderProduct(String moText, String accessNumber)
   {
     Vasservice vasService = null;
     if ((moText != null) && (accessNumber == null)) {
       vasService = (Vasservice)this.productInfoByOrderText.get(moText);
       if (vasService != null) {
         return vasService;
       }
       for (int i = 0; i < this.orderTextList.size(); i++) {
         String ordertext = (String)this.orderTextList.get(i);
         if (moText.startsWith(ordertext.substring(0, ordertext.length() - 1)))
         {// 模糊匹配，例如实际文本为order001, 如果用户输入order001232319389283 也可以匹配上
 
           String jieruhao = "";
           try {
             jieruhao = moText.substring(moText.indexOf("10655565"));//不理解
           } catch (Exception e) {
             log.error("convert err : " + e.getMessage());
           }
           return (Vasservice)this.productInfoByOrderText.get(ordertext + jieruhao);
         }
       }
     }
     
     if ((moText != null) && (accessNumber != null)) {
       vasService = (Vasservice)this.productInfoByMoOrder.get(moText + accessNumber);
       if (vasService != null) {
         return vasService;
       }
       for (int i = 0; i < this.orderTextList.size(); i++) {
         String ordertext = (String)this.orderTextList.get(i);
         if (moText.startsWith(ordertext.substring(0, ordertext.length() - 1))) {
           return (Vasservice)this.productInfoByMoOrder.get(ordertext + accessNumber);
         }
       }
     }
     
     return vasService;
   }
   
 
 
 
 
   public Vasservice getDemandProduct(String moText, String accessNumber)
   {
     Vasservice vasService = null;
     if ((moText != null) && (accessNumber == null)) {
       vasService = (Vasservice)this.productInfoByDemandText.get(moText);
       if (vasService != null) {
         return vasService;
       }
       for (int i = 0; i < this.demandTextList.size(); i++) {
         String demandtext = (String)this.demandTextList.get(i);
         if (moText.startsWith(demandtext.substring(0, demandtext.length() - 1))) {
           return (Vasservice)this.productInfoByDemandText.get(demandtext);
         }
       }
     }
     
     if ((moText != null) && (accessNumber != null)) {
       vasService = (Vasservice)this.productInfoByMoDemand.get(moText + accessNumber);
       
 
 
 
 
       log.info("vasService:" + vasService);
       if (vasService != null) {
         return vasService;
       }
       
       String demandtext = (String)this.demandTextMap.get(accessNumber);
       log.info("moText:" + moText + "accessNumber:" + accessNumber + "demandtext:" + demandtext);
       if ((demandtext != null) && (!"".equals(demandtext)) && (moText.startsWith(demandtext.replaceAll("#", ""))))
       {
         return (Vasservice)this.productInfoByMoDemand.get(demandtext + accessNumber);
       }
     }
     
 
 
 
 
 
 
 
 
 
     return vasService;
   }
   
 
 
 
 
   public Vasservice getCancelProduct(String moText, String accessNumber)
   {
     Vasservice vasService = null;
     if ((moText != null) && (accessNumber == null)) {
       vasService = (Vasservice)this.productInfoByCancelText.get(moText);
       if (vasService != null) {
         return vasService;
       }
       for (int i = 0; i < this.cancelTextList.size(); i++) {
         String canceltext = (String)this.cancelTextList.get(i);
         if (moText.startsWith(canceltext.substring(0, canceltext.length() - 1))) {
           return (Vasservice)this.productInfoByCancelText.get(canceltext);
         }
       }
     }
     
     if ((moText != null) && (accessNumber != null)) {
       vasService = (Vasservice)this.productInfoByMoCancel.get(moText + accessNumber);
       if (vasService != null) {
         return vasService;
       }
       for (int i = 0; i < this.cancelTextList.size(); i++) {
         String canceltext = (String)this.cancelTextList.get(i);
         if (moText.startsWith(canceltext.substring(0, canceltext.length() - 1))) {
           return (Vasservice)this.productInfoByMoCancel.get(canceltext + accessNumber);
         }
       }
     }
     
     return vasService;
   }
   
 
 
 
	   public void init() {//点播:dianbo001;订购(中途需要回复Y):order001;退订:0000
		   Vasservice vasservice = new Vasservice();
		   vasservice.setUniqueid((int)(Math.random()*100));
		   VasserviceReserveInfo vasserviceReserveInfo=new VasserviceReserveInfo();
		   vasserviceReserveInfo.setSpProductid("vaspid0013010012345");
		   vasservice.setVasserviceReserveInfo(vasserviceReserveInfo);
		   vasservice.setServicedesc("201230123");
		   vasservice.setVasid("3010012345");
		   vasservice.setServicename("test");
		   vasservice.setVaspid("vaspid0013010012345");
		   vasservice.setOndemandfee(129.23);
		   vasservice.setOrderfee(129.23);
		   /**点播业务**/
		   this.productInfoByMoDemand=new ConcurrentHashMap<>();
		   this.productInfoByMoDemand.put("dianbo0013010012345", vasservice);
		   /**点播业务***/
		   
		   /**订购业务***/
		   this.productInfoByMoOrder=new ConcurrentHashMap<>();
		   this.productInfoByMoOrder.put("order0013010012345", vasservice);
		   this.productInfoByOrderText.put("order0013010012345", vasservice);
		   /**订购业务***/
		   
		   /**OwnerBiz**/
		   Vasp vasp=new Vasp();
		   vasp.setUniqueid((int)(Math.random()*100));
		   vasp.setVaspid("vaspid0013010012345666");
		   this.ownerSpInfoBySpid=new ConcurrentHashMap<>();
		   this.ownerSpInfoBySpid.put("vaspid0013010012345666", vasp);
		   /**OwnerBiz**/
		   
		   this.VasidsByOwner.put("3010012345", "3010012345");
		   this.spurlByProductid.put("pro10001", "http://192.168.1.116/mmsmpspsimulator/SPServerServlet");//sp地址指向
		   this.spurlByVASPID.put("vaspid0013010012345","http://192.168.1.116/mmsmpspsimulator/services/SyncNotifySP");//订购时发送ws请求
		   this.uniqueidByProductids.put("pro10001", (int)(Math.random()*100)+"");
		   this.serviceIdByProductids.put("pro10001",vasservice.getVasid()+"#"+vasservice.getVaspid());
		   this.sysParams.put("MT_ORDER_QUOTA", "5");
		   this.sysParams.put("MT_ONDEMAND_QUOTA", "5");
		   this.sysParams.put("ACC_NUMBER", "3010012345");//接入号
		   this.sysParams.put("TAKE_ACC_NUMBER", "3010012345666");//take number 指定接入号，必须以接入号开头
		   this.sysParams.put("UNIONVASPID", "vaspid0013010012345666");//给ownerBize 对应的SP接入号
		   this.sysParams.put("COREBIZ_SEND_SECONDCONFIRM_MESSAGE", "订购产品ID:{0},价格:{1},订购产品名称:{2},商家联系电话：{3}");//发给用户的确认信息
		   this.sysParams.put("CAPACITY_ID", "1000");//业务能力
		   this.sysParams.put("UP_ONDEMAND_TIP", "{0}make{1}test{2}in{3}line");//点播提示信息
		   this.sysParams.put("COREBIZ_SEND_ORDER_MESSAGE", "111{0}222{1}");//发送订购信息
		   
	   }
 
 
 
 
 
   public Vasservice getOwnerProduct(String moText, String accessNumber)
   {
     Vasservice vasservice = null;
     
 
     vasservice = (Vasservice)this.productInfoByMoDemand.get(moText + accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("1");
       return vasservice;
     }
     
 
     vasservice = (Vasservice)this.productInfoByMoOrder.get(moText + accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("2");
       return vasservice;
     }
     
     vasservice = (Vasservice)this.productInfoByMoCancel.get(moText + accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("3");
       return vasservice;
     }
     
     String demandtext = (String)this.demandTextMap.get(accessNumber);
     if ((demandtext != null) && (moText.startsWith(demandtext.substring(0, demandtext.length() - 1))))
     {
       vasservice = (Vasservice)this.productInfoByMoDemand.get(demandtext + accessNumber);
       if (vasservice != null) {
         vasservice.setVassmsid("1");
         return vasservice;
       }
     }
     
     String ordertext = (String)this.orderTextMap.get(accessNumber);
     if ((ordertext != null) && (moText.startsWith(ordertext.substring(0, ordertext.length() - 1))))
     {
       vasservice = (Vasservice)this.productInfoByMoOrder.get(ordertext + accessNumber);
       if (vasservice != null) {
         vasservice.setVassmsid("2");
         return vasservice;
       }
     }
     
     String canceltext = (String)this.cancelTextMap.get(accessNumber);
     if ((canceltext != null) && (moText.startsWith(canceltext.substring(0, canceltext.length() - 1))))
     {
       vasservice = (Vasservice)this.productInfoByMoCancel.get(canceltext + accessNumber);
       if (vasservice != null) {
         vasservice.setVassmsid("3");
         return vasservice;
       }
     }
     return vasservice;
   }
   
 
 
 
 
 
 
 
 
   public Vasservice getSpProduct(String moText, String accessNumber)
   {
     Vasservice vasservice = null;
     
 
     vasservice = (Vasservice)this.productInfoByMoDemand.get(moText + accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("1");
       return vasservice;
     }
     
 
     vasservice = (Vasservice)this.productInfoByMoOrder.get(moText + accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("2");
       return vasservice;
     }
     
     vasservice = (Vasservice)this.productInfoByMoCancel.get(moText + accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("3");
       return vasservice;
     }
     
 
     String demandtext = (String)this.demandTextMap.get(accessNumber);
     if ((demandtext != null) && (moText.startsWith(demandtext.substring(0, demandtext.length() - 1))))
     {
       vasservice = (Vasservice)this.productInfoByMoDemand.get(demandtext + accessNumber);
       if (vasservice != null) {
         vasservice.setVassmsid("1");
         return vasservice;
       }
     }
     
     String ordertext = (String)this.orderTextMap.get(accessNumber);
     if ((ordertext != null) && (moText.startsWith(ordertext.substring(0, ordertext.length() - 1))))
     {
       vasservice = (Vasservice)this.productInfoByMoOrder.get(ordertext + accessNumber);
       if (vasservice != null) {
         vasservice.setVassmsid("2");
         return vasservice;
       }
     }
     
     String canceltext = (String)this.cancelTextMap.get(accessNumber);
     if ((canceltext != null) && (moText.startsWith(canceltext.substring(0, canceltext.length() - 1))))
     {
       vasservice = (Vasservice)this.productInfoByMoCancel.get(canceltext + accessNumber);
       if (vasservice != null) {
         vasservice.setVassmsid("3");
         return vasservice;
       }
     }
     return vasservice;
   }
   
 
 
 
 
 
 
 
 
   public Vasservice getProduct(String moText, String accessNumber)
   {
     Vasservice vasservice = null;
     
     vasservice = getDemandProduct(moText, accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("1");
       return vasservice;
     }
     
     vasservice = getOrderProduct(moText, accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("2");
       return vasservice;
     }
     
     vasservice = getCancelProduct(moText, accessNumber);
     if (vasservice != null) {
       vasservice.setVassmsid("3");
       return vasservice;
     }
     return vasservice;
   }
   
   public Map<String, Vasp> getSpInfoBySpid()
   {
     return this.spInfoBySpid;
   }
   
   public Map<String, Vas> getVasInfoById() {
     return this.vasInfoById;
   }
   
   public Map<String, Vasservice> getProductInfoById() {
     return this.productInfoById;
   }
   
   public Map<String, String> getSysParams() {
     return this.sysParams;
   }
   
   public Map<String, UserBlackWhiteList> getWhiteUser() {
     return this.whiteUser;
   }
   
 
 
   public Vasp getOwnSpInfoBySpId(String spId)
   {
     return (Vasp)this.ownerSpInfoBySpid.get(spId);
   }
   
   public String getOwnSpReportUrl(String reportUrl)
   {
     return (String)this.ownerSpReportURL.get(reportUrl);
   }
   
   public Map<String, Vasp> getOwnerSpInfoBySpid()
   {
     return this.ownerSpInfoBySpid;
   }
   
 
   public Map<String, String> getOwnerSpReportURL()
   {
     return this.ownerSpReportURL;
   }
 }





