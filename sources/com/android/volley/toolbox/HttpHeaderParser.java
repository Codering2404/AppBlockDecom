package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import com.facebook.appevents.AppEventsConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpHeaderParser {
    static List a(List list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((Header) it.next()).a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = entry.f57649h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header : entry.f57649h) {
                    if (!treeSet.contains(header.a())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!entry.f57648g.isEmpty()) {
            for (Map.Entry entry2 : entry.f57648g.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header((String) entry2.getKey(), (String) entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    static String b(long j3) {
        return d("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j3));
    }

    static Map c(Cache.Entry entry) {
        if (entry == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        String str = entry.f57643b;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j3 = entry.f57645d;
        if (j3 > 0) {
            map.put("If-Modified-Since", b(j3));
        }
        return map;
    }

    private static SimpleDateFormat d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static Cache.Entry e(NetworkResponse networkResponse) {
        long j3;
        boolean z2;
        long j4;
        long j5;
        long j6;
        long j7;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = networkResponse.f57678c;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jH = str != null ? h(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i3 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z2 = false;
            j4 = 0;
            j5 = 0;
            while (i3 < strArrSplit.length) {
                String strTrim = strArrSplit[i3].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j4 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j5 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z2 = true;
                }
                i3++;
            }
            j3 = 0;
            i3 = 1;
        } else {
            j3 = 0;
            z2 = false;
            j4 = 0;
            j5 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jH2 = str3 != null ? h(str3) : j3;
        String str4 = (String) map.get("Last-Modified");
        long jH3 = str4 != null ? h(str4) : j3;
        String str5 = (String) map.get("ETag");
        if (i3 != 0) {
            long j8 = jCurrentTimeMillis + (j4 * 1000);
            j7 = z2 ? j8 : (j5 * 1000) + j8;
            j6 = j8;
        } else {
            j6 = (jH <= j3 || jH2 < jH) ? j3 : jCurrentTimeMillis + (jH2 - jH);
            j7 = j6;
        }
        Cache.Entry entry = new Cache.Entry();
        entry.f57642a = networkResponse.f57677b;
        entry.f57643b = str5;
        entry.f57647f = j6;
        entry.f57646e = j7;
        entry.f57644c = jH;
        entry.f57645d = jH3;
        entry.f57648g = map;
        entry.f57649h = networkResponse.f57679d;
        return entry;
    }

    public static String f(Map map) {
        return g(map, "ISO-8859-1");
    }

    public static String g(Map map, String str) {
        String str2;
        if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i3 = 1; i3 < strArrSplit.length; i3++) {
                String[] strArrSplit2 = strArrSplit[i3].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long h(String str) {
        try {
            return d("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e3) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "-1".equals(str)) {
                VolleyLog.e("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            VolleyLog.d(e3, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static List i(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    static Map j(List list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            treeMap.put(header.a(), header.b());
        }
        return treeMap;
    }
}
