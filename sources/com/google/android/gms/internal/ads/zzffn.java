package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzffn implements zzets {
    protected final zzcnj zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzfge zzd;
    private final zzfhw zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    private final zzfqj zzh;
    private final zzfkx zzi;

    @Nullable
    private ListenableFuture zzj;

    protected zzffn(Context context, Executor executor, zzcnj zzcnjVar, zzfhw zzfhwVar, zzfge zzfgeVar, zzfkx zzfkxVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcnjVar;
        this.zze = zzfhwVar;
        this.zzd = zzfgeVar;
        this.zzi = zzfkxVar;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcnjVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized zzdby zzg(zzfhu zzfhuVar) {
        zzffk zzffkVar = (zzffk) zzfhuVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjv)).booleanValue()) {
            zzcvi zzcviVar = new zzcvi(this.zzg);
            zzdca zzdcaVar = new zzdca();
            zzdcaVar.zza(this.zzb);
            zzdcaVar.zzb(zzffkVar.zza);
            zzdcb zzdcbVarZze = zzdcaVar.zze();
            zzdiq zzdiqVar = new zzdiq();
            zzfge zzfgeVar = this.zzd;
            Executor executor = this.zzc;
            zzdiqVar.zzd(zzfgeVar, executor);
            zzdiqVar.zzg(zzfgeVar, executor);
            return zzc(zzcviVar, zzdcbVarZze, zzdiqVar.zzn());
        }
        zzfge zzfgeVarZzn = zzfge.zzn(this.zzd);
        zzdiq zzdiqVar2 = new zzdiq();
        Executor executor2 = this.zzc;
        zzdiqVar2.zzc(zzfgeVarZzn, executor2);
        zzdiqVar2.zzi(zzfgeVarZzn, executor2);
        zzdiqVar2.zzj(zzfgeVarZzn, executor2);
        zzdiqVar2.zzk(zzfgeVarZzn, executor2);
        zzdiqVar2.zzd(zzfgeVarZzn, executor2);
        zzdiqVar2.zzg(zzfgeVarZzn, executor2);
        zzdiqVar2.zzl(zzfgeVarZzn);
        zzcvi zzcviVar2 = new zzcvi(this.zzg);
        zzdca zzdcaVar2 = new zzdca();
        zzdcaVar2.zza(this.zzb);
        zzdcaVar2.zzb(zzffkVar.zza);
        return zzc(zzcviVar2, zzdcaVar2.zze(), zzdiqVar2.zzn());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    @Override // com.google.android.gms.internal.ads.zzets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean zza(com.google.android.gms.ads.internal.client.zzm r10, java.lang.String r11, com.google.android.gms.internal.ads.zzetq r12, com.google.android.gms.internal.ads.zzetr r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffn.zza(com.google.android.gms.ads.internal.client.zzm, java.lang.String, com.google.android.gms.internal.ads.zzetq, com.google.android.gms.internal.ads.zzetr):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzets
    public final boolean zzb() {
        ListenableFuture listenableFuture = this.zzj;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    protected abstract zzdby zzc(zzcvi zzcviVar, zzdcb zzdcbVar, zzdir zzdirVar);

    public final void zzd(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi.zzp(zzxVar);
    }

    final /* synthetic */ void zze() {
        this.zzd.zzdJ(zzfma.zzd(6, null, null));
    }

    final /* synthetic */ Executor zzh() {
        return this.zzc;
    }

    final /* synthetic */ zzfge zzi() {
        return this.zzd;
    }

    final /* synthetic */ zzfhw zzj() {
        return this.zze;
    }

    final /* synthetic */ zzfqj zzk() {
        return this.zzh;
    }

    final /* synthetic */ void zzl(ListenableFuture listenableFuture) {
        this.zzj = null;
    }
}
