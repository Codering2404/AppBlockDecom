package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaui implements zzatz {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzaui(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
