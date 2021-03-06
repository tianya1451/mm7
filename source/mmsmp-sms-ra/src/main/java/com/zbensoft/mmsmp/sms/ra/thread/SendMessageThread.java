package com.zbensoft.mmsmp.sms.ra.thread;

import com.zbensoft.mmsmp.common.ra.common.message.AbstractMessage;
import com.zbensoft.mmsmp.common.ra.common.message.MT_SMMessage;
import com.zbensoft.mmsmp.sms.ra.log.SMS_LOG;
import com.zbensoft.mmsmp.sms.ra.smsg.SmsSender;
import com.zbensoft.mmsmp.sms.ra.utils.SmsMessageQuene;
import org.apache.log4j.Logger;

public class SendMessageThread implements Runnable {
    private static final Logger logger = Logger.getLogger(SendMessageThread.class);
    private SmsSender smsSender = null;

    public SendMessageThread(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void run() {
        while(true) {
            if (this.smsSender == null) {
                SMS_LOG.INFO("doesn't connect sgip.......");

                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }
            } else {
                AbstractMessage message = SmsMessageQuene.getInstance().takeMTMessage();
                if (message != null && message instanceof MT_SMMessage) {
                    MT_SMMessage mtmsg = (MT_SMMessage)message;

                    try {
                        this.smsSender.sendSMS(mtmsg);
                        SMS_LOG.INFO("send mt sms message to smsg success");
                    } catch (Exception var5) {
                        SMS_LOG.ERROR("send mt sms message to smsg failed", var5);
                    }
                }

                SMS_LOG.INFO("this time send sms mtmessage to smsg over......");
            }
        }
    }
}

