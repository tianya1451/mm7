package com.zbensoft.mmsmp.common.ra.smssgip.proxy.sgip;

import com.zbensoft.mmsmp.common.ra.smssgip.proxy.util.Resource;

public class SGIPConstant {
    public static boolean debug;
    public static String LOGINING;
    public static String LOGIN_ERROR;
    public static String SEND_ERROR;
    public static String CONNECT_TIMEOUT;
    public static String STRUCTURE_ERROR;
    public static String NONLICETSP_LOGNAME;
    public static String NONLICETSP_ID;
    public static String SP_ERROR;
    public static String VERSION_ERROR;
    public static String OTHER_ERROR;
    public static String HEARTBEAT_ABNORMITY;
    public static String SUBMIT_INPUT_ERROR;
    public static String CONNECT_INPUT_ERROR;
    public static String CANCEL_INPUT_ERROR;
    public static String QUERY_INPUT_ERROR;
    public static String DELIVER_REPINPUT_ERROR;
    public static String REPORT_REPINPUT_ERROR;
    public static String USERREPORT_REPINPUT_ERROR;
    public static String ACTIVE_REPINPUT_ERROR;
    public static String SMC_MESSAGE_ERROR;
    public static String INT_SCOPE_ERROR;
    public static String STRING_LENGTH_GREAT;
    public static String STRING_NULL;
    public static String VALUE_ERROR;
    public static String FEE_USERTYPE_ERROR;
    public static String REGISTERED_DELIVERY_ERROR;
    public static final int Bind_Command_Id = 1;
    public static final int Bind_Rep_Command_Id = -2147483647;
    public static final int Unbind_Command_Id = 2;
    public static final int Unbind_Rep_Command_Id = -2147483646;
    public static final int Submit_Command_Id = 3;
    public static final int Submit_Rep_Command_Id = -2147483645;
    public static final int Deliver_Command_Id = 4;
    public static final int Deliver_Rep_Command_Id = -2147483644;
    public static final int Report_Command_Id = 5;
    public static final int Report_Rep_Command_Id = -2147483643;
    public static final int UserReport_Command_Id = 17;
    public static final int UserReport_Rep_Command_Id = -2147483631;

    public SGIPConstant() {
    }

    public static void initConstant(Resource resource) {
        if (LOGINING == null) {
            LOGINING = resource.get("smproxy/logining");
            LOGIN_ERROR = resource.get("smproxy/login-error");
            SEND_ERROR = resource.get("smproxy/send-error");
            CONNECT_TIMEOUT = resource.get("smproxy/connect-timeout");
            STRUCTURE_ERROR = resource.get("smproxy/structure-error");
            NONLICETSP_LOGNAME = resource.get("smproxy/nonlicetsp-logname");
            NONLICETSP_ID = resource.get("smproxy/nonlicetsp-id");
            SP_ERROR = resource.get("smproxy/sp-error");
            VERSION_ERROR = resource.get("smproxy/version-error");
            OTHER_ERROR = resource.get("smproxy/other-error");
            HEARTBEAT_ABNORMITY = resource.get("smproxy/heartbeat-abnormity");
            SUBMIT_INPUT_ERROR = resource.get("smproxy/submit-input-error");
            CONNECT_INPUT_ERROR = resource.get("smproxy/connect-input-error");
            CANCEL_INPUT_ERROR = resource.get("smproxy/cancel-input-error");
            QUERY_INPUT_ERROR = resource.get("smproxy/query-input-error");
            DELIVER_REPINPUT_ERROR = resource.get("smproxy/deliver-repinput-error");
            REPORT_REPINPUT_ERROR = resource.get("smproxy/report-repinput-error");
            USERREPORT_REPINPUT_ERROR = resource.get("smproxy/userreport-repinput-error");
            ACTIVE_REPINPUT_ERROR = resource.get("smproxy/active-repinput-error");
            SMC_MESSAGE_ERROR = resource.get("smproxy/smc-message-error");
            INT_SCOPE_ERROR = resource.get("smproxy/int-scope-error");
            STRING_LENGTH_GREAT = resource.get("smproxy/string-length-great");
            STRING_NULL = resource.get("smproxy/string-null");
            VALUE_ERROR = resource.get("smproxy/value-error");
            FEE_USERTYPE_ERROR = resource.get("smproxy/fee-usertype-error");
            REGISTERED_DELIVERY_ERROR = resource.get("smproxy/registered-delivery-error");
        }

    }
}
