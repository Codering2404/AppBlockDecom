package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.Preconditions;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzez {
    private final Map zza;
    private final List zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;
    private final boolean zzf;
    private final String zzg;

    public zzez(zzbt zzbtVar, Map map, long j3, boolean z2) {
        this(zzbtVar, map, j3, z2, 0L, 0, null);
    }

    public static zzez zze(zzbt zzbtVar, zzez zzezVar, Map map) {
        return new zzez(zzbtVar, map, zzezVar.zzd, zzezVar.zzf, zzezVar.zzc, zzezVar.zze, zzezVar.zzb);
    }

    private final String zzi(String str, String str2) {
        Preconditions.g(str);
        Preconditions.b(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.zza.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String zzj(zzbt zzbtVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        if (string.startsWith("&")) {
            string = string.substring(1);
        }
        int length = string.length();
        if (length > 256) {
            string = string.substring(0, Function.MAX_NARGS);
            zzbtVar.zzS("Hit param name is too long and will be trimmed", Integer.valueOf(length), string);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    private static String zzk(zzbt zzbtVar, Object obj) {
        String string = obj == null ? "" : obj.toString();
        int length = string.length();
        if (length <= 8192) {
            return string;
        }
        String strSubstring = string.substring(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        zzbtVar.zzS("Hit param value is too long and will be trimmed", Integer.valueOf(length), strSubstring);
        return strSubstring;
    }

    private static boolean zzl(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.zzd);
        if (this.zzc != 0) {
            sb.append(", dbId=");
            sb.append(this.zzc);
        }
        if (this.zze != 0) {
            sb.append(", appUID=");
            sb.append(this.zze);
        }
        ArrayList arrayList = new ArrayList(this.zza.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = (String) arrayList.get(i3);
            sb.append(", ");
            sb.append(str);
            sb.append("=");
            sb.append((String) this.zza.get(str));
        }
        return sb.toString();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return zzfu.zza(zzi("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public final long zzd() {
        return this.zzd;
    }

    public final String zzf() {
        return zzi("_m", "");
    }

    public final Map zzg() {
        return this.zza;
    }

    public final boolean zzh() {
        return this.zzf;
    }

    public zzez(zzbt zzbtVar, Map map, long j3, boolean z2, long j4, int i3, List list) {
        String strZzb;
        String strZzj;
        String strZzj2;
        Preconditions.m(zzbtVar);
        Preconditions.m(map);
        this.zzd = j3;
        this.zzf = z2;
        this.zzc = j4;
        this.zze = i3;
        this.zzb = list != null ? list : Collections.EMPTY_LIST;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzcr zzcrVar = (zzcr) it.next();
                if ("appendVersion".equals(zzcrVar.zza())) {
                    strZzb = zzcrVar.zzb();
                    break;
                }
            }
            strZzb = null;
        } else {
            strZzb = null;
        }
        this.zzg = true != TextUtils.isEmpty(strZzb) ? strZzb : null;
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (zzl(entry.getKey()) && (strZzj2 = zzj(zzbtVar, entry.getKey())) != null) {
                map2.put(strZzj2, zzk(zzbtVar, entry.getValue()));
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (!zzl(entry2.getKey()) && (strZzj = zzj(zzbtVar, entry2.getKey())) != null) {
                map2.put(strZzj, zzk(zzbtVar, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.zzg)) {
            zzfu.zzg(map2, "_v", this.zzg);
            if (this.zzg.equals("ma4.0.0") || this.zzg.equals("ma4.0.1")) {
                map2.remove("adid");
            }
        }
        this.zza = Collections.unmodifiableMap(map2);
    }
}
