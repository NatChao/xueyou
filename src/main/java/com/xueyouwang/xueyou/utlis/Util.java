package com.xueyouwang.xueyou.utlis;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.*;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * 常用工具类
 */
public class Util {

    private static final Logger log = Logger.getLogger(Util.class.getSimpleName());
    private static final long FILE_COPY_BUFFER_SIZE = 1024 * 1024 * 3;
    private static final String WORDS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String UA_Iphone = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A403 Safari/8536.25";
    private static final String UA_Firefox = "Firefox/18.0";
    private static final String UA_Chrome = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/51.0.2704.79 Chrome/51.0.2704.79 Safari/537.36";

    private static String P_Email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isNull(String val) {
        return val == null || "".equals(val.trim());
    }

    /**
     * @TODO 0?
     * @param val
     * @return
     */
    public static Integer getInteger(String val) {
        return isNull(val) ? 0 : Integer.valueOf(val.trim());
    }

    public static Long getLong(String val) {
        return isNull(val) ? 0 : Long.valueOf(val.trim());
    }

    public static Integer getInt(String val) {
        return isNull(val) ? 0 : Integer.parseInt(val.trim());
    }

    public static Double getDouble(String val) {
        return isNull(val) ? 0.0d : Double.valueOf(val.trim());
    }

    public static java.sql.Date getSQLDate(String val) {
        return isNull(val) ? null : java.sql.Date.valueOf(val.trim());
    }

    // is Number
    public static boolean isNumber(String inputData) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(inputData, pos);
        return inputData.length() == pos.getIndex();
    }

    public static boolean isInteger(String s) {
        Scanner sc = new Scanner(s);
        return sc.hasNextInt();
    }

    public static boolean isNumeric(String str) {
        if (str == null)
            return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    /**
     * data time <br />
     * yyyy-MM-dd HH:mm:ss <br />
     */
    public static String now() {
        String fmt = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(fmt);
        return (df.format(new Date()));
    }

    /** yyyy-MM-dd HH:mm:ss */
    public static String getNowTime() {
        return getNowTime("yyyy-MM-dd HH:mm:ss");
    }

    /** yyyyMMddHHmmss */
    public static Long getNowTimeNumber() {
        return new Long(getNowTime("yyyyMMddHHmmss"));
    }

    /** yyyyMMddHHmmss */
    public static String getNowTimeLong() {
        return getNowTime("yyyyMMddHHmmss");
    }

    /** yyyyMMddHHmmss */
    public static String getNowTimeFile() {
        return getNowTime("yyyyMMddHHmmss");
    }

    public static String getNowTime(String fmt) {
        SimpleDateFormat sf = new SimpleDateFormat(fmt);
        String dt = sf.format(new Date());
        return dt;
    }

    /** yyyyMMddHHmmss */
    public static Long roll2Date(long epoch, long roll2) {
        return roll2Date(epoch, roll2, "yyyyMMddHHmmss");
    }

    public static Long roll2Date(long epoch, long roll2, String fmt) {
        SimpleDateFormat sf = new SimpleDateFormat(fmt);
        String dt = sf.format(new Date(epoch + roll2));
        return new Long(dt);
    }

    /** milliseconds "yyyyMMddHHmmss" */
    public static Long epoch2dateLong(long epoch) {
        return new Long(epoch2date(epoch, "yyyyMMddHHmmss"));
    }

    /** milliseconds "yyyy-MM-dd HH:mm:ss" */
    public static String epoch2date(long epoch) {
        return epoch2date(epoch, "yyyy-MM-dd HH:mm:ss");
    }

    /** yyyy-MM-dd HH:mm:ss */
    public static String epoch2date(long epoch, String fmt) {
        SimpleDateFormat sf = new SimpleDateFormat(fmt);
        String dt = sf.format(new Date(epoch));
        return dt;
    }

    public static long getEpoch() {
        return new Date().getTime() / 1000;
    }

    /** 20160719181054 -> 2016-07-19 18:10:54 */
    public static String showTime(long time) {
        String l = String.valueOf(time);
        return l.substring(0, 4) + "-" + l.substring(4, 6) + "-" + l.substring(6, 8) + " " //
                + l.substring(8, 10) + ":" + l.substring(10, 12) + ":" + l.substring(12, 14);

    }

    public static String showTimeMinute(long time) {
        return showTime(time).substring(0, 16);
    }

    // ip country
    public static long ip2num(String start_ip) {
        String[] octets_start = start_ip.split("\\.");
        long _start = 0;
        for (String octet_s : octets_start) {
            int octet_i = Integer.parseInt(octet_s);
            _start <<= 8;
            _start |= octet_i;
        }
        return _start;
    }

    public static String num2ip(long ip_number) {
        String[] octets = new String[4];
        for (int i = 3; i >= 0; i--) {
            octets[i] = String.valueOf(ip_number & 0xFF);
            ip_number >>= 8;
        }
        return join(Arrays.asList(octets), ".");
    }

    // binary search
    public static int firstLeft(Long[] array, long k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int c = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else { // [mid] < k
                start = mid + 1;
            }
            // System.out.println("firstLeft(): " + c++ + " " + start);
        }
        if (array[start] > k) {
            return start - 1;
        } else {
            return start;
        }
    }

    /* string */
    public static boolean valid(String obj) {
        return obj != null && !"".equals(obj);
    }

    public static boolean validEmail(String e) {
        if (e == null)
            return false;
        Pattern regex = Pattern.compile(P_Email);
        Matcher matcher = regex.matcher(e);
        return matcher.matches();
    }

    public static String slurp(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    public static List<String> split(String line, int len) {
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < line.length(); i += len) {
            l.add(line.substring(i, i + len));
        }
        // return l.toArray(new String[l.size()]);
        return l;
    }

    /** SPACE -> "" */
    public static String[] split(String line, String delimiter) {
        List<String> nodeValues = new ArrayList<String>();

        int offset = 0;
        int pos = line.indexOf(delimiter, offset);

        while (pos != -1) {
            nodeValues.add(offset == pos ? "" : line.substring(offset, pos));

            offset = pos + delimiter.length();
            pos = line.indexOf(delimiter, offset);
        }

        if (offset <= line.length()) {
            nodeValues.add(offset == line.length() ? "" : line.substring(offset));
        }
        return nodeValues.toArray(new String[nodeValues.size()]);
    }

    public static String join(Collection<?> ls, String delimiter) {
        String dl = delimiter == null ? "" : delimiter;
        StringBuilder builder = new StringBuilder();
        for (Object o : ls) {
            builder.append(o).append(dl);
        }
        return builder.substring(0, builder.length() - dl.length());
    }

    public static String join(Object[] ls, String delimiter) {
        String dl = delimiter == null ? "" : delimiter;
        StringBuilder builder = new StringBuilder();
        for (Object o : ls) {
            builder.append(o).append(dl);
        }
        return builder.substring(0, builder.length() - dl.length());
    }

    public static String join(long[] ls, String delimiter) {
        String dl = delimiter == null ? "" : delimiter;
        StringBuilder builder = new StringBuilder();
        for (long o : ls) {
            builder.append(o).append(dl);
        }
        return builder.substring(0, builder.length() - dl.length());
    }

    public static String resetParameter(String url, String param, String value) {
        String rrl = eraseParameter(url, param);
        if (rrl.indexOf('?') != -1) {
            return rrl += "&" + param + "=" + value;
        }
        return rrl += "?" + param + "=" + value;
    }

    public static String eraseParameter(String url, String param) {
        int si = url.indexOf(param + "=");
        if (si != -1) {
            int ei = url.indexOf('&', si);
            if (url.charAt(si - 1) == '&') { // no start
                si -= 1;
            } else if (url.charAt(si - 1) == '?') { // first
                ei += 1;
            }
            return url.substring(0, si) + (ei < 1 ? "" : url.substring(ei));
        }
        return url;
    }

    public static String getParameter(String url, String param) {
        int si = url.indexOf(param + "=");
        if (si != -1) {
            int ei = url.indexOf('&', si);
            if (ei == -1) { // end of url
                ei = url.length();
            }
            return url.substring(si + param.length() + 1, ei);
        }
        return "";
    }

    /** 100000 -> 123456 */
    public static int randomNumber(int base) {
        int r = RANDOM.nextInt(base * 10);
        return r < base ? base + r : r;
    }

    public static String random() {
        return random(32);
    }

    public static String random(int len) {
        StringBuilder sb = new StringBuilder(len);
        int size = WORDS.length();
        for (int i = 0; i < len; i++)
            sb.append(WORDS.charAt(RANDOM.nextInt(size)));
        return sb.toString();
    }

    public static String zeroPrefix(int val, int len) {
        return zeroPrefix(String.valueOf(val), len);
    }

    public static String zeroPrefix(String val, int len) {
        return ("00000000000000000000".substring(0, len) + val).substring(val.length());
    }

    // crc32
    public static long getCRC32(List<String> ls) {
        String[] a = new String[ls.size()];
        return getCRC32(ls.toArray(a));
    }

    public static long getCRC32(String str) {
        return str.hashCode();
    }

    public static long getCRC32(String[] strs) {
        long crc = 0;
        for (String str : strs) {
            if (str == null)
                continue;
            crc ^= str.hashCode();
        }
        return crc;
    }

    /* file and stream */
    public static String getMD5(byte[] bs) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(bs);
            byte[] md5sum = digest.digest();
            String md5 = "";
            for (int i = md5sum.length - 1; i >= 0; i--) {
                String hex = Integer.toHexString(md5sum[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                md5 = hex + md5;
            }
            return md5;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMD5(String s) {
        return s == null ? null : getMD5(s.getBytes());
    }

    public static String getMD5(File f) throws Exception {
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        int read = 0;
        MessageDigest digest = MessageDigest.getInstance("MD5");
        while ((read = is.read(buffer)) > 0) {
            digest.update(buffer, 0, read);
        }
        is.close();
        byte[] md5sum = digest.digest();

        String md5 = "";
        for (int i = md5sum.length - 1; i >= 0; i--) {
            String hex = Integer.toHexString(md5sum[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            md5 = hex + md5;
        }
        return md5;
    }

    public static byte[] hex2byte(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static Map<String, String> readConfig(String conf) {
        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());

        try {
            // reload conf file
            Properties config = new Properties();
            InputStream ins = new Util().getClass().getResourceAsStream(conf);
            config.load(ins);

            for (Iterator it = config.keySet().iterator(); it.hasNext();) {
                String nam = (String) it.next();
                String val = new String(config.getProperty(nam).getBytes("ISO8859-1"), "UTF-8");
                map.put(nam, val.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static byte[] utf2gbk(byte[] bs) {
        return byteConvert(bs, "UTF-8", "GBK");
    }

    public static byte[] byte2UTF8(byte[] bs, String orgcs) {
        return byteConvert(bs, orgcs, "UTF-8");
    }

    public static byte[] byteConvert(byte[] bs, String orgcs, String dstcs) {
        try {
            Charset org = Charset.forName(orgcs);
            Charset dst = Charset.forName(dstcs);

            ByteBuffer inb = ByteBuffer.wrap(bs);
            CharBuffer data = org.decode(inb);

            ByteBuffer outputBuffer = dst.encode(data);
            byte[] oub = outputBuffer.array();
            return oub;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void checkNnewDir(String fn) {
        try {
            File f = new File(fn);
            File d = f.getParentFile();
            if (!d.exists()) {
                d.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLine(String ctn, int seq) {
        int si = 0;
        int ni = -1;
        do {
            si = ni + 1;
            ni = ctn.indexOf('\n', Math.max(0, si));
            // System.out.println(seq + " " + si + " " + ni);
        } while (--seq > 0 && ni != -1);
        ni = ni == -1 && si < ctn.length() ? ctn.length() : ni;
        return ni != -1 ? ctn.substring(si, ni) : null;
    }

    public static String getNextLine(String ctn, int offset) {
        int ei = ctn.indexOf('\n', offset);
        return ei != -1 && ei > offset ? ctn.substring(offset, ei) : null;
    }

    public static byte[] streamReader(InputStream ins) throws IOException {
        return streamReader(ins, 0, -1);
    }

    public static byte[] streamReader(InputStream ins, long skip, long size) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(ins);
        bis.skip(skip); // 0 or +

        boolean hasSize = size != -1; // -1 full
        long readed = 0;

        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        long bsize = hasSize ? Math.min(1024, size) : 1024;
        byte[] b = new byte[(int) bsize];
        int len = 0;
        while ((len = bis.read(b)) != -1) {
            ba.write(b, 0, len);

            if (hasSize) {
                readed += len;
                if (size - readed < 1024) {
                    b = new byte[(int) (size - readed)];
                }
                if (readed == size) {
                    break;
                }
            }
        }
        return ba.toByteArray();
    }

    public static byte[] stream2array(InputStream ins) {
        return stream2array(ins, 20480);
    }

    public static byte[] stream2array(InputStream ins, int bsize) {
        ByteArrayOutputStream out = new ByteArrayOutputStream(bsize);
        try {
            byte[] buf = new byte[bsize];
            int len;
            while ((len = ins.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            ins.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    // file to byte[]
    public static byte[] getBytesFromFile(File file) {
        try {
            InputStream is = new FileInputStream(file);

            // Get the size of the file
            long length = file.length();

            // You cannot create an array using a long type.
            // It needs to be an int type.
            // Before converting to an int type, check
            // to ensure that file is not larger than Integer.MAX_VALUE.
            if (length > Integer.MAX_VALUE) {
                // File is too large
            }

            // Create the byte array to hold the data
            byte[] bytes = new byte[(int) length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            // Ensure all the bytes have been read in
            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }

            // Close the input stream and return bytes
            is.close();
            return bytes;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static byte[] getBytesFromUrl(String url) throws IOException {
        return getBytesFromUrl(url, 0);
    }

    public static byte[] getBytesFromUrl(String url, int size) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024 * 20);
        BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());

        byte[] b = new byte[1024];
        int sz = 0;
        int siz_ = 0;
        while ((sz = in.read(b)) != -1) {
            out.write(b, 0, sz);
            siz_ += sz;
            if (size > 0 && siz_ >= size) {
                break;
            }
        }
        in.close();
        return out.toByteArray();
    }

    public static byte[] getBytesOfUrl(String u) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024 * 20);
        URL url = new URL(u);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        HttpURLConnection.setFollowRedirects(true);
        con.setConnectTimeout(1000 * 5);
        con.setRequestProperty("User-Agent", UA_Chrome);
        con.setRequestMethod("GET");

        // Map<String, List<String>> responseMap = con.getHeaderFields();
        // for (Iterator<String> iterator = responseMap.keySet().iterator(); iterator.hasNext();) {
        // String key = (String) iterator.next();
        // List<String> values = responseMap.get(key);
        // for (int i = 0; i < values.size(); i++) {
        // Object o = values.get(i);
        // System.out.println(key + ": " + o);
        // }
        // }

        InputStream is = con.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = bis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        bis.close();
        return out.toByteArray();
    }

    public static byte[] deGZip(byte[] gz) throws IOException {
        return deGZip(gz, 1024 * 1024 * 1);
    }

    public static byte[] deGZip(byte[] gz, int bsize) throws IOException {
        GZIPInputStream gs = new GZIPInputStream(new ByteArrayInputStream(gz));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] buf = new byte[bsize];
        while ((len = gs.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        return baos.toByteArray();
    }

    /* exception */
    public static byte[] getExceptionTrace(Exception e) {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        PrintStream w = new PrintStream(ba);
        e.printStackTrace(w);
        w.flush();
        return ba.toByteArray();
    }

    /* sql */
    public static String getCountSql(String sql) {
        StringBuilder sb = new StringBuilder();
        int fi = sql.indexOf(" from ");
        sb.append("select count(1)");
        sb.append(sql.substring(fi));
        return sb.toString();
    }

    public static String getPagingSqlMySQL(String sql, int start, int stop) {
        return sql + " limit " + (start >= 1 ? start - 1 : start) + ", " + (stop > start ? (stop - start) + 1 : 1);
    }

    public static String getPagingSql(String sql, int start, int stop) {
        StringBuilder sb = new StringBuilder();
        int wi = sql.lastIndexOf(" where ");
        boolean hw = (wi != -1 && sql.substring(wi).indexOf(')') == -1);
        String wr = hw ? " and" : " where";
        sb.append("select * from (select rownum as num, ");
        sb.append(sql.substring(7));
        sb.append(wr);
        sb.append(" rownum <= ");
        sb.append(stop);
        sb.append(") t where t.num >= ");
        sb.append(start);
        return sb.toString();
    }

    /** seq_acct_id -> ACCT */
    public static String getSequencePref(String seq) {
        int si = seq.indexOf('_') + 1;
        int ei = seq.indexOf('_', si);
        return seq.substring(si, ei).toUpperCase();
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                // log.info("auto commit(" + conn.getAutoCommit() + ")");
                if (!conn.getAutoCommit()) {
                    conn.setAutoCommit(true);
                }
                conn.close();
            }
            conn = null;
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void rollbackConnection(Connection conn) {
        try {
            if (conn != null) {
                log.info("rollbackConnection(" + conn.getAutoCommit() + ")");
                conn.rollback();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void closeRS(ResultSet rs, Statement stmt) {
        closeResultSet(rs);
        closeStatement(stmt);
    }

    public static void closeRSC(ResultSet rs, Statement stmt, Connection conn) {
        closeResultSet(rs);
        closeStatement(stmt);
        closeConnection(conn);
    }

    public static void ShowResultSetMeta(ResultSetMetaData md) {
        try {
            int cc = md.getColumnCount();
            for (int i = 1; i <= cc; i++) {
                String name = md.getColumnName(i);
                String type = md.getColumnTypeName(i);
                log.info("ShowResultSetMeta(): " + name + ", " + type);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static boolean validConnection(Connection conn) {
        boolean valid = false;
        try {
            valid = conn != null && !conn.isClosed() && conn.isValid(3);
        } catch (SQLException se) {
            valid = false;
        } finally {
            if (!valid) {
                closeConnection(conn);
            }
        }
        return valid;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    /** http */
    public static String httpPost(String url, String data) {
        return httpPost(url, data, 0);
    }

    public static String httpPost(String url, String data, int timeout) {
        String charset = "UTF-8";
        OutputStream output = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoOutput(true); // Triggers POST.
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // POST method
            conn.setRequestProperty("Accept-Charset", charset);
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            conn.setUseCaches(false);
            conn.setConnectTimeout(timeout == 0 ? 5000 : timeout);

            output = conn.getOutputStream();
            output.write(data.getBytes());

            int status = conn.getResponseCode();
            InputStream response = conn.getInputStream();
            String rs = new String(Util.streamReader(response));
            return rs != null ? rs.trim() : null;
        } catch (IOException ie) {
            ie.printStackTrace();
            return "-1";
        } finally {
            if (output != null)
                try {
                    output.close();
                } catch (IOException logOrIgnore) {
                }
        }
    }

    /** security */
    public static final String encrypt(String data, BigInteger confuse) {
        if (data == null || data.length() == 0)
            return null;

        BigInteger bi_passwd = new BigInteger(data.getBytes());
        BigInteger bi_r1 = confuse.xor(bi_passwd);
        return bi_r1.toString(Character.MAX_RADIX);
    }

    public static final String decrypt(String encrypted, BigInteger confuse) {
        if (encrypted == null || encrypted.length() == 0)
            return null;

        try {
            BigInteger bi_r1 = new BigInteger(encrypted, Character.MAX_RADIX);
            BigInteger bi_r0 = bi_r1.xor(confuse);
            return new String(bi_r0.toByteArray());
        } catch (Exception e) {
            return null;
        }
    }

    public static final String rot13(String s) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'm')
                c += 13;
            else if (c >= 'A' && c <= 'M')
                c += 13;
            else if (c >= 'n' && c <= 'z')
                c -= 13;
            else if (c >= 'N' && c <= 'Z')
                c -= 13;
            b.append(c);
        }
        return b.toString();
    }

    public static int byte2int(byte[] b) {
        if (b.length == 4)
            return b[0] << 24 | (b[1] & 0xff) << 16 | (b[2] & 0xff) << 8 | (b[3] & 0xff);
        if (b.length == 3)
            return 0x00 << 24 | (b[0] & 0xff) << 16 | (b[1] & 0xff) << 8 | (b[2] & 0xff);
        else if (b.length == 2)
            return 0x00 << 24 | 0x00 << 16 | (b[0] & 0xff) << 8 | (b[1] & 0xff);
        else if (b.length == 2)
            return 0x00 << 24 | 0x00 << 16 | 0x00 << 8 | (b[0] & 0xff);
        return 0;
    }

    public static byte[] int2byte(int value) {
        byte[] array = new byte[4];
        int offset = 0;
        array[offset] = (byte) (0xff & (value >> 24));
        array[offset + 1] = (byte) (0xff & (value >> 16));
        array[offset + 2] = (byte) (0xff & (value >> 8));
        array[offset + 3] = (byte) (0xff & value);
        return array;
    }

    public static boolean fileTouch(String f) {
        File file = new File(f);
        try {
            file.createNewFile();
            if (file.exists()) {
                return file.setLastModified(System.currentTimeMillis());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean fileDelete(String f) {
        File file = new File(f);
        try {
            return file.delete();
        } catch (Exception ignored) {
            return false;
        }
    }

    public static boolean fileCopy(String f_src, String f_dest) throws IOException {
        File srcFile = new File(f_src);
        File destFile = new File(f_dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel input = null;
        FileChannel output = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            input = fis.getChannel();
            output = fos.getChannel();
            long size = input.size();
            long pos = 0;
            long count = 0;
            while (pos < size) {
                count = size - pos > FILE_COPY_BUFFER_SIZE ? FILE_COPY_BUFFER_SIZE : size - pos;
                pos += output.transferFrom(input, pos, count);
            }
        } finally {
            output.close();
            fos.close();
            input.close();
            fis.close();
        }

        if (srcFile.length() != destFile.length()) {
            return false;
        }
        return true;
    }

    public static void fileSave(String f, byte[] ctn) {
        OutputStream out;
        try {
            out = new FileOutputStream(f);
            out.write(ctn);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getJavaPID() {
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        int ati = pid.indexOf('@');
        if (ati != -1)
            pid = pid.substring(0, ati);
        return pid;
    }

    public static long getIntegerOfArray(byte[] array, int offset) {
        return ((0xff & array[offset + 0]) << 0) | ((0xff & array[offset + 1]) << 8) | ((0xff & array[offset + 2]) << 16) | ((0xff & array[offset + 3]) << 24);
    }

    // Note: Value needs to be long to avoid sign extension
    public static void setIntegerToArray(byte[] array, int offset, long value) {
        array[offset + 0] = (byte) ((value >> 0) & 0xff);
        array[offset + 1] = (byte) ((value >> 8) & 0xff);
        array[offset + 2] = (byte) ((value >> 16) & 0xff);
        array[offset + 3] = (byte) ((value >> 24) & 0xff);
    }

    public static byte[] mergeArray(byte[] a1, byte[] a2) {
        byte[] a = new byte[a1.length + a2.length];
        System.arraycopy(a1, 0, a, 0, a1.length);
        System.arraycopy(a2, 0, a, a1.length, a2.length);
        return a;
    }

    public static int[] mergeArray(int[] a1, int[] a2) {
        int[] a = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, a, 0, a1.length);
        System.arraycopy(a2, 0, a, a1.length, a2.length);
        return a;
    }

    /**
     * String t = "asd asdf fa ab|\"ce asdf\"|eifw234 \"asdf adsf sadf\""; <br />
     */
    public static String[] getTerms(String t) {
        if (t == null)
            return null;
        t = t.trim().replaceAll("\\s+", " ");

        List<String> ts = new ArrayList<String>();
        int t0 = 0;
        boolean g0 = false;
        boolean g1 = false;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == ' ' && (!g0 || (g0 && g1))) {
                ts.add(t.substring(t0, i).replaceAll("\"", ""));
                t0 = i + 1;
                if (g0 && g1) {
                    g0 = false;
                    g1 = false;
                }
            }
            if (t.charAt(i) == '"') {
                if (g0)
                    g1 = true;
                else
                    g0 = true;

                if (g0 && g1 && t.length() > i + 1 && t.charAt(i + 1) == '|') {
                    g0 = false;
                    g1 = false;
                }
            }
        }
        ts.add(t.substring(t0).replaceAll("\"", ""));
        String[] terms = new String[ts.size()];
        ts.toArray(terms);
        return terms;
    }

}
