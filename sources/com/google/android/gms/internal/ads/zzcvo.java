package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcvo extends zzcvl {
    private final Context zzc;
    private final View zzd;
    private final zzcku zze;
    private final zzfkg zzf;
    private final zzcxr zzg;
    private final zzdqd zzh;
    private final zzdla zzi;
    private final zzimo zzj;
    private final Executor zzk;
    private com.google.android.gms.ads.internal.client.zzr zzl;

    zzcvo(zzcxs zzcxsVar, Context context, zzfkg zzfkgVar, View view, zzcku zzckuVar, zzcxr zzcxrVar, zzdqd zzdqdVar, zzdla zzdlaVar, zzimo zzimoVar, Executor executor) {
        super(zzcxsVar);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzckuVar;
        this.zzf = zzfkgVar;
        this.zzg = zzcxrVar;
        this.zzh = zzdqdVar;
        this.zzi = zzdlaVar;
        this.zzj = zzimoVar;
        this.zzk = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final View zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final void zzb(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzcku zzckuVar;
        if (viewGroup == null || (zzckuVar = this.zze) == null) {
            return;
        }
        zzckuVar.zzaf(zzcne.zza(zzrVar));
        viewGroup.setMinimumHeight(zzrVar.f70006c);
        viewGroup.setMinimumWidth(zzrVar.f70009g);
        this.zzl = zzrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final com.google.android.gms.ads.internal.client.zzea zzc() {
        try {
            return this.zzg.zza();
        } catch (zzflf unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final zzfkg zze() {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.zzl;
        if (zzrVar != null) {
            return zzfle.zzb(zzrVar);
        }
        zzfkf zzfkfVar = this.zzb;
        if (zzfkfVar.zzac) {
            for (String str : zzfkfVar.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfkg(view.getWidth(), view.getHeight(), false);
        }
        return (zzfkg) zzfkfVar.zzr.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final zzfkg zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final int zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziZ)).booleanValue() && this.zzb.zzag) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzja)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final int zzh() {
        return this.zza.zzb.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl
    public final void zzi() {
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final void zzj() {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcvn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzk();
            }
        });
        super.zzj();
    }

    final /* synthetic */ void zzk() {
        zzbnm zzbnmVarZzd = this.zzh.zzd();
        if (zzbnmVarZzd == null) {
            return;
        }
        try {
            zzbnmVarZzd.zze((com.google.android.gms.ads.internal.client.zzbu) this.zzj.zzb(), ObjectWrapper.i5(this.zzc));
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("RemoteException when notifyAdLoad is called", e3);
        }
    }
}
