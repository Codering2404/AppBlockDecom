package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdp implements zzfck {
    private final Executor zza;
    private final String zzb;

    public zzfdp(zzcev zzcevVar, Executor executor, String str, PackageInfo packageInfo, int i3) {
        this.zza = executor;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza = zzhbw.zza(this.zzb);
        zzfdo zzfdoVar = zzfdo.zza;
        Executor executor = this.zza;
        return zzhbw.zzh(zzhbw.zzk(listenableFutureZza, zzfdoVar, executor), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfdn
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 41;
    }

    final /* synthetic */ ListenableFuture zzc(Throwable th) {
        return zzhbw.zza(new zzfdq(this.zzb));
    }
}
