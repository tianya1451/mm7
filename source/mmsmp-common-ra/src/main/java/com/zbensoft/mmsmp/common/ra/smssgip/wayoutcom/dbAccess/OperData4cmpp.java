package com.zbensoft.mmsmp.common.ra.smssgip.wayoutcom.dbAccess;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperData4cmpp {
    public OperData4cmpp() {
    }

    public void insertSubmitResend(List list) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("insert into cmpp_submitresend(postCommand, preCommand, seq, premsgID) values (?, ?, ?, ?) ");
            System.err.println("**************在insertSubmitUnresp的list里面有包：" + list.size());

            for(int i = 0; i < list.size(); ++i) {
                Object[] obj = (Object[])list.get(i);
                ByteBuffer postBuf = (ByteBuffer)obj[0];
                ByteBuffer preBuf = (ByteBuffer)obj[1];
                Integer Seq = (Integer)obj[2];
                long msgID = (Long)obj[3];
                byte[] postcomm = postBuf.array();
                byte[] precomm = preBuf.array();
                int seq = Seq;
                pstm.setBytes(1, postcomm);
                pstm.setBytes(2, precomm);
                pstm.setInt(3, seq);
                pstm.setLong(4, msgID);
                pstm.addBatch();
            }

            pstm.executeBatch();
        } catch (Exception var17) {
            var17.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

    }

    public void insertSubmitUnresp(List list) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("insert into cmpp_submittimeout(Command, seq) values (?, ?) ");
            System.err.println("**************在insertSubmitUnresp的list里面有包：" + list.size());

            for(int i = 0; i < list.size(); ++i) {
                Object[] obj = (Object[])list.get(i);
                ByteBuffer buf = (ByteBuffer)obj[0];
                Integer Seq = (Integer)obj[1];
                byte[] comm = buf.array();
                int seq = Seq;
                pstm.setBytes(1, comm);
                pstm.setInt(2, seq);
                pstm.addBatch();
            }

            pstm.executeBatch();
        } catch (Exception var13) {
            var13.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

    }

    public void insertDeliverUnresp(List list) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("insert into cmpp_delivertimeout(Command, seq) values (?, ?) ");
            System.err.println("**************在insertDeliverunresp的list里面有包：" + list.size());

            for(int i = 0; i < list.size(); ++i) {
                Object[] obj = (Object[])list.get(i);
                ByteBuffer buf = (ByteBuffer)obj[0];
                Integer Seq = (Integer)obj[1];
                byte[] comm = buf.array();
                int seq = Seq;
                pstm.setBytes(1, comm);
                pstm.setInt(2, seq);
                pstm.addBatch();
            }

            pstm.executeBatch();
        } catch (Exception var13) {
            var13.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

    }

    public void submitResp(Object[] list) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("update cmpp_submitresend set resp = 'Y' where postmsgID=?");

            for(int i = 0; i < list.length; ++i) {
                long msgID = (Long)list[i];
                pstm.setLong(1, msgID);
                pstm.addBatch();
            }

            pstm.executeBatch();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

    }

    public void submitTimeoutResp(Object[] obj) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("update cmpp_submitresend set postmsgID = ? where seq=?");
            Integer Seq = (Integer)obj[0];
            long msgID = (Long)obj[1];
            pstm.setLong(1, msgID);
            pstm.setInt(2, Seq);
            pstm.addBatch();
            pstm.executeBatch();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

    }

    public void deliverResp(Object[] deliver) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("update cmpp_delivertimeout set resp = 'Y' where seq=? ");

            for(int i = 0; i < deliver.length; ++i) {
                Integer Seq = (Integer)deliver[i];
                int seq = Seq;
                pstm.setInt(1, seq);
                pstm.addBatch();
            }

            pstm.executeBatch();
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

    }

    public List submitResend() {
        List list = new ArrayList();
        Connection conn = null;
        Statement stm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList seq = new ArrayList();

        ArrayList var10;
        try {
            conn = DbAccess.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select postCommand, seq from cmpp_submitresend where resp = 'N' and ((TIMESTAMPDIFF(minute,convertTime, now())>=(select value from cmpp_parameter where name = 'submit_resend') and retries = 0) or (TIMESTAMPDIFF(minute,convertTime, now())>=(select value from cmpp_parameter where name = 'submit_interval') and retries != 0))");

            while(rs.next()) {
                list.add(rs.getBytes(1));
                seq.add(new Integer(rs.getInt(2)));
            }

            rs.close();
            stm.close();
            if (list.size() != 0) {
                pstm = conn.prepareStatement("update cmpp_submitresend set retries = retries+1 where seq = ?");

                for(int i = 0; i < seq.size(); ++i) {
                    Integer Seq = (Integer)seq.get(i);
                    pstm.setInt(1, Seq);
                    pstm.addBatch();
                }

                pstm.executeBatch();
                return list;
            }

            var10 = (ArrayList) list;
        } catch (Exception var13) {
            var13.printStackTrace();
            return list;
        } finally {
            DbAccess.Close(conn, pstm);
        }

        return var10;
    }

    public List deliverResend() {
        List list = new ArrayList();
        Connection conn = null;
        Statement stm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList seq = new ArrayList();

        ArrayList var10;
        try {
            conn = DbAccess.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select Command, seq from cmpp_delivertimeout where resp = 'N' and ((TIMESTAMPDIFF(minute,recvTime, now())>=(select value from cmpp_parameter where name = 'deliver_resend') and retries = 0) or (TIMESTAMPDIFF(minute,recvTime, now())>=(select value from cmpp_parameter where name = 'deliver_interval') and retries != 0))");

            int i;
            while(rs.next()) {
                list.add(rs.getBytes(1));
                i = rs.getInt(2);
                seq.add(new Integer(i));
            }

            rs.close();
            stm.close();
            if (list.size() != 0) {
                pstm = conn.prepareStatement("update cmpp_delivertimeout set retries = retries+1 where seq = ?");

                for(i = 0; i < seq.size(); ++i) {
                    Integer Seq = (Integer)seq.get(i);
                    pstm.setInt(1, Seq);
                    pstm.addBatch();
                }

                pstm.executeBatch();
                return list;
            }

            var10 = (ArrayList) list;
        } catch (Exception var13) {
            var13.printStackTrace();
            return list;
        } finally {
            DbAccess.Close(conn, pstm);
        }

        return var10;
    }

    public void moveData() {
        Connection conn = null;
        CallableStatement cstm = null;

        try {
            conn = DbAccess.getConnection();
            cstm = conn.prepareCall("{call cmpp_deliver_move()}");
            cstm.execute();
            cstm.close();
            cstm = conn.prepareCall("{call cmpp_submitresend_move()}");
            cstm.execute();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            DbAccess.Close(conn, cstm);
        }

    }

    public boolean IPCheck(String IP) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select * from cmpp_app where clientip=? ");
            pstm.setString(1, IP);
            rs = pstm.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm);
        }

        return flag;
    }

    public void loadAppInfo(HashMap report, HashMap deliver, String IP) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        synchronized(report) {
            if (report == null) {
                return;
            }
        }

        synchronized(deliver) {
            if (deliver == null) {
                return;
            }
        }

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select id, serverip, serverport from cmpp_app where clientip=? ");
            pstm.setString(1, IP);
            rs = pstm.executeQuery();

            while(rs.next()) {
                Integer id = new Integer(rs.getInt(1));
                String ip = rs.getString(2);
                int port = rs.getInt(3);
                InetSocketAddress address = new InetSocketAddress(ip, port);
                synchronized(report) {
                    report.put(id, address);
                }
            }

            rs.close();
            rs = null;
            pstm.close();
            pstm = null;
            pstm = conn.prepareStatement("select serverip, serverport, code from cmpp_app, cmpp_application where cmpp_app.id=cmpp_application.APPID and clientip=? ");
            pstm.setString(1, IP);
            rs = pstm.executeQuery();

            while(rs.next()) {
                String ip = rs.getString(1);
                int port = rs.getInt(2);
                InetSocketAddress address = new InetSocketAddress(ip, port);
                synchronized(deliver) {
                    deliver.put(rs.getString(3), address);
                }
            }
        } catch (Exception var21) {
            var21.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm, rs);
        }

    }

    public void loadAppInfo(Map submit, Map report, Map deliver) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select id, serverip, serverport, clientIP from cmpp_app");
            rs = pstm.executeQuery();
            HashMap reportTmp = new HashMap();
            HashMap submitTmp = new HashMap();
            HashMap deliverTmp = new HashMap();

            while(rs.next()) {
                Integer id = new Integer(rs.getInt(1));
                String ip = rs.getString(2);
                int port = rs.getInt(3);
                String Cip = rs.getString(4);
                InetSocketAddress address = new InetSocketAddress(ip, port);
                reportTmp.put(id, address);
                submitTmp.put(Cip, id);
            }

            rs.close();
            rs = null;
            pstm.close();
            pstm = null;
            synchronized(submit) {
                submit.clear();
                submit.putAll(submitTmp);
                submitTmp = null;
            }

            synchronized(report) {
                report.clear();
                report.putAll(reportTmp);
                reportTmp = null;
            }

            pstm = conn.prepareStatement("select serverip, serverport, access_num from cmpp_app, cmpp_application where cmpp_app.id=cmpp_application.APPID");
            rs = pstm.executeQuery();

            while(rs.next()) {
                String ip = rs.getString(1);
                int port = rs.getInt(2);
                InetSocketAddress address = new InetSocketAddress(ip, port);
                deliverTmp.put(rs.getString(3), address);
            }

            synchronized(deliver) {
                deliver.clear();
                deliver.putAll(deliverTmp);
                deliverTmp = null;
            }
        } catch (Exception var24) {
            var24.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm, rs);
        }

    }

    public HashMap loadConfigInfo() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        HashMap info = new HashMap();

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select configName, ip, port from cmpp_config");
            rs = pstm.executeQuery();

            while(rs.next()) {
                String name = rs.getString(1);
                String ip = rs.getString(2);
                int port = rs.getInt(3);
                InetSocketAddress address = new InetSocketAddress(ip, port);
                info.put(name, address);
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm, rs);
        }

        return info;
    }

    public HashMap loadParameter() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        HashMap info = new HashMap();

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select name, value from cmpp_parameter");
            rs = pstm.executeQuery();

            while(rs.next()) {
                String name = rs.getString(1);
                int value = rs.getInt(2);
                info.put(name, new Integer(value));
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm, rs);
        }

        return info;
    }

    public HashMap loadLogin() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        HashMap info = new HashMap();

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select name, value from cmpp_login");
            rs = pstm.executeQuery();

            while(rs.next()) {
                String name = rs.getString(1);
                String value = rs.getString(2);
                info.put(name, value);
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm, rs);
        }

        return info;
    }

    public long getMsgID(long msgID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        long premsgID = 0L;

        try {
            conn = DbAccess.getConnection();
            pstm = conn.prepareStatement("select premsgID from cmpp_submitresend where postmsgID=? ");
            pstm.setLong(1, msgID);

            for(rs = pstm.executeQuery(); rs.next(); premsgID = rs.getLong(1)) {
                ;
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        } finally {
            DbAccess.Close(conn, pstm, rs);
        }

        return premsgID;
    }

    public static void main(String[] args) {
        OperData4cmpp cmpp = new OperData4cmpp();
        OperData4cmpp.test t = cmpp.new test();
        t.loadAppInfo((Map)null, new HashMap(), new HashMap());
    }

    public class test extends OperData4cmpp {
        public test() {
        }

        public void loadAppInfo(Map submit, Map report, Map deliver) {
            synchronized(submit){}
        }
    }
}

