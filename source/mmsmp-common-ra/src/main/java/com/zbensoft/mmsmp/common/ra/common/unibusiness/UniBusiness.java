package com.zbensoft.mmsmp.common.ra.common.unibusiness;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name="UniBusiness", targetNamespace="http://unibusiness.sjb.vas.aceway.com")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface UniBusiness
{
  @WebMethod(operationName="serviceCapabilityManage", action="")
  @WebResult(name="serviceCapabilityManageReturn", targetNamespace="http://unibusiness.sjb.vas.aceway.com")
  public abstract Response serviceCapabilityManage(@WebParam(name="request", targetNamespace="http://unibusiness.sjb.vas.aceway.com") ServiceCapabilityManageRequest paramServiceCapabilityManageRequest);

  @WebMethod(operationName="orderRelationManage", action="")
  @WebResult(name="orderRelationManageReturn", targetNamespace="http://unibusiness.sjb.vas.aceway.com")
  public abstract Response orderRelationManage(@WebParam(name="request3", targetNamespace="http://unibusiness.sjb.vas.aceway.com") OrderRelationRequest paramOrderRelationRequest);

  @WebMethod(operationName="produceManage", action="")
  @WebResult(name="produceManageReturn", targetNamespace="http://unibusiness.sjb.vas.aceway.com")
  public abstract Response produceManage(@WebParam(name="request2", targetNamespace="http://unibusiness.sjb.vas.aceway.com") ProductManageRequest paramProductManageRequest);

  @WebMethod(operationName="serviceManage", action="")
  @WebResult(name="serviceManageReturn", targetNamespace="http://unibusiness.sjb.vas.aceway.com")
  public abstract Response serviceManage(@WebParam(name="request1", targetNamespace="http://unibusiness.sjb.vas.aceway.com") ServiceManageRequest paramServiceManageRequest);

  @WebMethod(operationName="reverseUnsubscribeManage", action="")
  @WebResult(name="reverseUnsubscribeManageReturn", targetNamespace="http://unibusiness.sjb.vas.aceway.com")
  public abstract Response reverseUnsubscribeManage(@WebParam(name="request4", targetNamespace="http://unibusiness.sjb.vas.aceway.com") ReverseUnsubscribeManageRequest paramReverseUnsubscribeManageRequest);
}

/* Location:           E:\项目\2018-MMSMP-中国联调彩信\彩信管理平台MMSMP_20180802\开发参考文档\抓包\home\mmsmp\agent\vac_agent\WEB-INF\lib\mmsms_common.jar
 * Qualified Name:     com.aceway.common.unibusiness.UniBusiness
 * JD-Core Version:    0.6.0
 */