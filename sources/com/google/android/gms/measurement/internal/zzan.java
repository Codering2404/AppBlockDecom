package com.google.android.gms.measurement.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumMap f73414a;

    zzan() {
        this.f73414a = new EnumMap(zzjk.class);
    }

    public static zzan d(String str) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        if (str.length() >= zzjk.values().length) {
            int i3 = 0;
            if (str.charAt(0) == '1') {
                zzjk[] zzjkVarArrValues = zzjk.values();
                int length = zzjkVarArrValues.length;
                int i4 = 1;
                while (i3 < length) {
                    enumMap.put(zzjkVarArrValues[i3], zzam.a(str.charAt(i4)));
                    i3++;
                    i4++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final zzam a(zzjk zzjkVar) {
        zzam zzamVar = (zzam) this.f73414a.get(zzjkVar);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.google.android.gms.measurement.internal.zzjk r3, int r4) {
        /*
            r2 = this;
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.INITIALIZATION
            goto L20
        L18:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.MANIFEST
            goto L20
        L1b:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.API
            goto L20
        L1e:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.TCF
        L20:
            java.util.EnumMap r4 = r2.f73414a
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.b(com.google.android.gms.measurement.internal.zzjk, int):void");
    }

    public final void c(zzjk zzjkVar, zzam zzamVar) {
        this.f73414a.put(zzjkVar, zzamVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (zzjk zzjkVar : zzjk.values()) {
            zzam zzamVar = (zzam) this.f73414a.get(zzjkVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            sb.append(zzamVar.b());
        }
        return sb.toString();
    }

    private zzan(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.f73414a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
