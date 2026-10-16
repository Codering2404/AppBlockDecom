package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdwz {
    private final Map zza = new HashMap();

    zzdwz() {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final synchronized void zza(java.lang.String r6, @javax.annotation.Nullable com.google.android.gms.internal.ads.zzflw r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch: java.lang.Throwable -> L17
            boolean r0 = r0.containsKey(r6)     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto Lb
            monitor-exit(r5)
            return
        Lb:
            com.google.android.gms.internal.ads.zzdwy r0 = new com.google.android.gms.internal.ads.zzdwy     // Catch: java.lang.Throwable -> L17
            r1 = 0
            if (r7 != 0) goto L12
        L10:
            r2 = r1
            goto L19
        L12:
            com.google.android.gms.internal.ads.zzbxq r2 = r7.zzB()     // Catch: com.google.android.gms.internal.ads.zzflf -> L10 java.lang.Throwable -> L17
            goto L19
        L17:
            r6 = move-exception
            goto L46
        L19:
            if (r7 != 0) goto L1c
            goto L20
        L1c:
            com.google.android.gms.internal.ads.zzbxq r1 = r7.zzC()     // Catch: java.lang.Throwable -> L17 com.google.android.gms.internal.ads.zzflf -> L20
        L20:
            com.google.android.gms.internal.ads.zzbih r3 = com.google.android.gms.internal.ads.zzbiq.zzkL     // Catch: java.lang.Throwable -> L17
            com.google.android.gms.internal.ads.zzbio r4 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L17
            java.lang.Object r3 = r4.zzd(r3)     // Catch: java.lang.Throwable -> L17
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L17
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L17
            r4 = 1
            if (r3 != 0) goto L34
            goto L3c
        L34:
            r3 = 0
            if (r7 != 0) goto L39
        L37:
            r4 = r3
            goto L3c
        L39:
            r7.zzn()     // Catch: java.lang.Throwable -> L17 com.google.android.gms.internal.ads.zzflf -> L37
        L3c:
            r0.<init>(r6, r2, r1, r4)     // Catch: java.lang.Throwable -> L17
            java.util.Map r7 = r5.zza     // Catch: java.lang.Throwable -> L17
            r7.put(r6, r0)     // Catch: java.lang.Throwable -> L17
            monitor-exit(r5)
            return
        L46:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L17
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwz.zza(java.lang.String, com.google.android.gms.internal.ads.zzflw):void");
    }

    final synchronized void zzb(String str, zzbxb zzbxbVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdwy(str, zzbxbVar.zzf(), zzbxbVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final synchronized zzdwy zzc(String str) {
        return (zzdwy) this.zza.get(str);
    }

    public final String zzd(String str) {
        zzbxq zzbxqVar;
        zzdwy zzdwyVarZzc = zzc(str);
        return (zzdwyVarZzc == null || (zzbxqVar = zzdwyVarZzc.zzb) == null) ? "" : zzbxqVar.toString();
    }
}
