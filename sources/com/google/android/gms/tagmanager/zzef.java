package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzsh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzef implements Runnable {
    private final Context zza;
    private final zzsh zzb;
    private final String zzc;
    private final String zzd;
    private zzdf zze;
    private volatile zzao zzf;
    private volatile String zzg;
    private volatile String zzh;

    public zzef(Context context, String str, zzao zzaoVar) {
        zzsh zzshVar = new zzsh();
        this.zza = context;
        this.zzb = zzshVar;
        this.zzc = str;
        this.zzf = zzaoVar;
        String strConcat = "/r?id=".concat(String.valueOf(str));
        this.zzd = strConcat;
        this.zzg = strConcat;
        this.zzh = null;
    }

    final void zza(String str) {
        if (str == null) {
            str = this.zzd;
        } else {
            zzdg.zzb.zza("Setting CTFE URL path: ".concat(str));
        }
        this.zzg = str;
    }

    final void zzb(zzdf zzdfVar) {
        this.zze = zzdfVar;
    }

    final void zzc(String str) {
        zzdg.zzb.zza("Setting previous container version: ".concat(String.valueOf(str)));
        this.zzh = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01c0 A[Catch: all -> 0x0169, TryCatch #4 {all -> 0x0169, blocks: (B:38:0x0137, B:40:0x013d, B:42:0x014c, B:43:0x0167, B:47:0x016b, B:48:0x0187, B:50:0x01c0, B:51:0x01c7), top: B:71:0x0137 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzef.run():void");
    }
}
