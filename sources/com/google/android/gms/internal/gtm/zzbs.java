package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbs extends zzbu {
    private final zzcm zza;

    public zzbs(zzbx zzbxVar, zzby zzbyVar) {
        super(zzbxVar);
        Preconditions.m(zzbyVar);
        this.zza = new zzcm(zzbxVar, zzbyVar);
    }

    public final long zza(zzbz zzbzVar) {
        zzV();
        Preconditions.m(zzbzVar);
        com.google.android.gms.analytics.zzr.h();
        long jZzb = this.zza.zzb(zzbzVar, true);
        if (jZzb != 0) {
            return jZzb;
        }
        this.zza.zzk(zzbzVar);
        return 0L;
    }

    public final void zzc() {
        zzV();
        Context contextZzo = zzo();
        if (!zzfk.zzb(contextZzo) || !zzfp.zzh(contextZzo)) {
            zze(null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsService"));
        contextZzo.startService(intent);
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.zza.zzW();
    }

    public final void zze(zzdb zzdbVar) {
        zzV();
        zzq().i(new zzbq(this, zzdbVar));
    }

    public final void zzf(String str, Runnable runnable) {
        Preconditions.h(str, "campaign param can't be empty");
        zzq().i(new zzbm(this, str, runnable));
    }

    public final void zzg() {
        zzV();
        zzw();
        zzq().i(new zzbp(this));
    }

    public final void zzh(zzez zzezVar) {
        Preconditions.m(zzezVar);
        zzV();
        zzF("Hit delivery requested", zzezVar);
        zzq().i(new zzbo(this, zzezVar));
    }

    final void zzi() {
        com.google.android.gms.analytics.zzr.h();
        this.zza.zzl();
    }

    final void zzj() {
        com.google.android.gms.analytics.zzr.h();
        this.zza.zzm();
    }

    public final void zzk() {
        zzV();
        com.google.android.gms.analytics.zzr.h();
        com.google.android.gms.analytics.zzr.h();
        zzcm zzcmVar = this.zza;
        zzcmVar.zzV();
        zzcmVar.zzN("Service disconnected");
    }

    public final void zzl(int i3) {
        zzV();
        zzF("setLocalDispatchPeriod (sec)", Integer.valueOf(i3));
        zzq().i(new zzbn(this, i3));
    }

    public final void zzm() {
        this.zza.zzZ();
    }

    public final boolean zzn() {
        zzV();
        try {
            zzq().g(new zzbr(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e3) {
            zzR("syncDispatchLocalHits interrupted", e3);
            return false;
        } catch (ExecutionException e4) {
            zzJ("syncDispatchLocalHits failed", e4);
            return false;
        } catch (TimeoutException e5) {
            zzR("syncDispatchLocalHits timed out", e5);
            return false;
        }
    }
}
