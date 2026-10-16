package com.google.android.gms.common.util;

import com.google.android.gms.internal.common.zzp;
import com.google.android.gms.internal.common.zzw;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f72278a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f72279b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f72280c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static Map a(URI uri, String str) {
        Map map = Collections.EMPTY_MAP;
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            map = new HashMap();
            zzw zzwVarZza = zzw.zza(zzp.zzb('='));
            Iterator it = zzw.zza(zzp.zzb('&')).zzb().zzc(rawQuery).iterator();
            while (it.hasNext()) {
                List listZzd = zzwVarZza.zzd((String) it.next());
                if (listZzd.isEmpty() || listZzd.size() > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                map.put(b((String) listZzd.get(0), str), listZzd.size() == 2 ? b((String) listZzd.get(1), str) : null);
            }
        }
        return map;
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
