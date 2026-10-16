package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgdm implements zzgdb {
    private ExecutorService zza;
    private Context zzb;
    private zzgdf zzc;

    private zzgdm() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final zzgdc zza() {
        zzinc.zzc(this.zza, ExecutorService.class);
        zzinc.zzc(this.zzb, Context.class);
        zzinc.zzc(this.zzc, zzgdf.class);
        return new zzgdl(new zzgjg(), new zzgji(), new zzgjk(), this.zza, this.zzb, this.zzc);
    }

    public final zzgdm zzb(ExecutorService executorService) {
        executorService.getClass();
        this.zza = executorService;
        return this;
    }

    public final zzgdm zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzgdm zzd(zzgdf zzgdfVar) {
        zzgdfVar.getClass();
        this.zzc = zzgdfVar;
        return this;
    }

    /* synthetic */ zzgdm(byte[] bArr) {
    }
}
