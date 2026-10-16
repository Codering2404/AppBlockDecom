package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzro;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzel implements zzaj {
    private final Context zza;
    private final String zzb;
    private final ExecutorService zzc;
    private zzdf zzd;

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        this.zzc.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzaj
    public final void zzc(zzro zzroVar) {
        this.zzc.execute(new zzek(this, zzroVar));
    }

    final File zze() {
        return new File(this.zza.getDir("google_tagmanager", 0), "resource_".concat(String.valueOf(this.zzb)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzf() {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzel.zzf():void");
    }
}
