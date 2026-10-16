package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfjs implements zzets {
    private final Context zza;
    private final Executor zzb;
    private final zzcnj zzc;
    private final zzfjj zzd;
    private final zzfhw zze;
    private final zzfkr zzf;
    private final zzfqj zzg;
    private final zzfkx zzh;
    private ListenableFuture zzi;

    public zzfjs(Context context, Executor executor, zzcnj zzcnjVar, zzfhw zzfhwVar, zzfjj zzfjjVar, zzfkx zzfkxVar, zzfkr zzfkrVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcnjVar;
        this.zze = zzfhwVar;
        this.zzd = zzfjjVar;
        this.zzh = zzfkxVar;
        this.zzf = zzfkrVar;
        this.zzg = zzcnjVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzdvq zze(zzfhu zzfhuVar) {
        zzdvq zzdvqVarZzp = this.zzc.zzp();
        zzdca zzdcaVar = new zzdca();
        zzdcaVar.zza(this.zza);
        zzdcaVar.zzb(((zzfjr) zzfhuVar).zza);
        zzdcaVar.zzf(this.zzf);
        zzdvqVarZzp.zzd(zzdcaVar.zze());
        zzdvqVarZzp.zze(new zzdiq().zzn());
        return zzdvqVarZzp;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    @Override // com.google.android.gms.internal.ads.zzets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm r11, java.lang.String r12, com.google.android.gms.internal.ads.zzetq r13, com.google.android.gms.internal.ads.zzetr r14) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfjs.zza(com.google.android.gms.ads.internal.client.zzm, java.lang.String, com.google.android.gms.internal.ads.zzetq, com.google.android.gms.internal.ads.zzetr):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        throw null;
    }

    final /* synthetic */ void zzc() {
        this.zzd.zzdJ(zzfma.zzd(6, null, null));
    }

    final /* synthetic */ Executor zzf() {
        return this.zzb;
    }

    final /* synthetic */ zzfjj zzg() {
        return this.zzd;
    }

    final /* synthetic */ zzfhw zzh() {
        return this.zze;
    }

    final /* synthetic */ zzfqj zzi() {
        return this.zzg;
    }

    final void zzj(int i3) {
        this.zzh.zzj().zza(i3);
    }
}
