package com.zbensoft.mmsmp.common.ra.common.message.messagehandler;

public abstract class AbstractMessageHandler
{
  public abstract boolean handleable(Object paramObject);

  public abstract void handleMessage(Object paramObject);
}

/* Location:           E:\项目\2018-MMSMP-中国联调彩信\彩信管理平台MMSMP_20180802\开发参考文档\抓包\home\mmsmp\agent\vac_agent\WEB-INF\lib\mmsms_common.jar
 * Qualified Name:     com.aceway.common.queue.messagehandler.AbstractMessageHandler
 * JD-Core Version:    0.6.0
 */