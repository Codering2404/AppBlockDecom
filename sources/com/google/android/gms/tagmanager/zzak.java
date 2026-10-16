package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.gtm.zzrn;
import com.google.android.gms.internal.gtm.zzro;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzak extends BasePendingResult {
    private final Clock zza;
    private final zzah zzb;
    private final Looper zzc;
    private final zzeb zzd;
    private final Context zzf;
    private final TagManager zzg;
    private final String zzh;
    private final zzal zzi;
    private zzaj zzj;
    private volatile zzz zzl;
    private volatile boolean zzm;
    private com.google.android.gms.internal.gtm.zzak zzn;
    private long zzo;
    private String zzp;
    private zzai zzq;
    private zzab zzr;

    static /* bridge */ /* synthetic */ boolean zzp(zzak zzakVar) {
        boolean z2 = zzakVar.zzm;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzr(long j3) {
        zzai zzaiVar = this.zzq;
        if (zzaiVar == null) {
            Log.w("GoogleTagManager", "Refresh requested, but no network load scheduler.");
        } else {
            zzaiVar.zza(j3, this.zzn.zzh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzt(com.google.android.gms.internal.gtm.zzak zzakVar) {
        if (this.zzj != null) {
            zzrn zzrnVarZze = zzro.zze();
            zzrnVarZze.zzc(0L);
            zzrnVarZze.zza(com.google.android.gms.internal.gtm.zzac.zzk());
            zzrnVarZze.zzc(this.zzo);
            zzrnVarZze.zza(com.google.android.gms.internal.gtm.zzac.zzk());
            zzrnVarZze.zzb(zzakVar);
            this.zzj.zzc((zzro) zzrnVarZze.zzD());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzu(com.google.android.gms.internal.gtm.zzak zzakVar, long j3, boolean z2) {
        if (isReady() && this.zzl == null) {
            return;
        }
        this.zzn = zzakVar;
        this.zzo = j3;
        long jZza = this.zzi.zza();
        zzr(Math.max(0L, Math.min(jZza, (this.zzo + jZza) - this.zza.currentTimeMillis())));
        Context context = this.zzf;
        TagManager tagManager = this.zzg;
        Container container = new Container(context, tagManager.getDataLayer(), this.zzh, j3, zzakVar);
        if (this.zzl == null) {
            this.zzl = new zzz(this.zzg, this.zzc, container, this.zzb);
        } else {
            this.zzl.zzc(container);
        }
        if (isReady() || !this.zzr.zza(container)) {
            return;
        }
        setResult(this.zzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzv() {
        zzdz zzdzVarZza = zzdz.zza();
        return (zzdzVarZza.zze() == 2 || zzdzVarZza.zze() == 3) && this.zzh.equals(zzdzVarZza.zzc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final ContainerHolder createFailedResult(Status status) {
        if (this.zzl != null) {
            return this.zzl;
        }
        if (status == Status.f71540j) {
            Log.e("GoogleTagManager", "timer expired: setting result to failure");
        }
        return new zzz(status);
    }

    final synchronized String zzh() {
        return this.zzp;
    }

    final synchronized void zzo(String str) {
        this.zzp = str;
        zzai zzaiVar = this.zzq;
        if (zzaiVar != null) {
            zzaiVar.zzb(str);
        }
    }
}
