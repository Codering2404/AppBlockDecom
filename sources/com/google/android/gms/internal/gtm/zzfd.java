package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfd extends zzbu {
    private static zzfd zza;

    public zzfd(zzbx zzbxVar) {
        super(zzbxVar);
    }

    public static zzfd zza() {
        return zza;
    }

    protected static final String zzf(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? obj.toString() : obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
        Long l3 = (Long) obj;
        if (Math.abs(l3.longValue()) < 100) {
            return obj.toString();
        }
        char cCharAt = obj.toString().charAt(0);
        String strValueOf = String.valueOf(Math.abs(l3.longValue()));
        StringBuilder sb = new StringBuilder();
        String str = cCharAt != '-' ? "" : "-";
        sb.append(str);
        sb.append(Math.round(Math.pow(10.0d, strValueOf.length() - 1)));
        sb.append("...");
        sb.append(str);
        sb.append(Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d));
        return sb.toString();
    }

    public final void zzb(zzez zzezVar, String str) {
        zzR("Discarding hit. ".concat(str), zzezVar != null ? zzezVar.toString() : "no hit data");
    }

    public final void zzc(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append((String) entry.getKey());
            sb.append('=');
            sb.append((String) entry.getValue());
        }
        zzR("Discarding hit. ".concat(str), sb.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        synchronized (zzfd.class) {
            zza = this;
        }
    }

    public final synchronized void zze(int i3, String str, Object obj, Object obj2, Object obj3) {
        char c3;
        try {
            Preconditions.m(str);
            if (zzw().zzb()) {
                zzw();
                c3 = 'C';
            } else {
                zzw();
                c3 = 'c';
            }
            String strSubstring = "3" + "01VDIWEA?".charAt(i3) + c3 + zzbv.zza + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + zzbt.zzD(str, zzf(obj), zzf(obj2), zzf(obj3));
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(0, 1024);
            }
            zzfj zzfjVarZzp = zzt().zzp();
            if (zzfjVarZzp != null) {
                zzfjVarZzp.zze().zzc(strSubstring);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
