package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfe extends zzex {
    private static final Object zza = new Object();
    private static zzfe zzb;
    private Context zzc;
    private zzcc zzd;
    private zzfa zzh;
    private zzdj zzi;
    private volatile zzcb zzk;
    private boolean zze = true;
    private boolean zzf = false;
    private boolean zzg = true;
    private final zzey zzl = new zzey(this);
    private boolean zzj = false;

    private zzfe() {
    }

    public static zzfe zzg() {
        if (zzb == null) {
            zzb = new zzfe();
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzm() {
        return this.zzj || !this.zzg;
    }

    @Override // com.google.android.gms.tagmanager.zzex
    public final synchronized void zza() {
        if (this.zzf) {
            this.zzk.zze(new zzez(this));
        } else {
            zzdg.zzb.zzd("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zze = true;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzex
    public final synchronized void zzb() {
        if (zzm()) {
            return;
        }
        this.zzh.zzb();
    }

    @Override // com.google.android.gms.tagmanager.zzex
    public final synchronized void zzc(boolean z2) {
        zzi(this.zzj, z2);
    }

    final synchronized zzcc zzf() {
        try {
            if (this.zzd == null) {
                if (this.zzc == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
                this.zzd = new zzdv(this.zzl, this.zzc);
            }
            if (this.zzh == null) {
                zzfd zzfdVar = new zzfd(this, null);
                this.zzh = zzfdVar;
                zzfdVar.zzc(1800000L);
            }
            this.zzf = true;
            if (this.zze) {
                zza();
                this.zze = false;
            }
            if (this.zzi == null) {
                zzdj zzdjVar = new zzdj(this);
                this.zzi = zzdjVar;
                Context context = this.zzc;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(zzdjVar, intentFilter);
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
                intentFilter2.addCategory(context.getPackageName());
                context.registerReceiver(zzdjVar, intentFilter2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzd;
    }

    final synchronized void zzi(boolean z2, boolean z3) {
        boolean zZzm = zzm();
        this.zzj = z2;
        this.zzg = z3;
        if (zzm() != zZzm) {
            if (zzm()) {
                this.zzh.zza();
                zzdg.zzb.zzd("PowerSaveMode initiated.");
            } else {
                this.zzh.zzc(1800000L);
                zzdg.zzb.zzd("PowerSaveMode terminated.");
            }
        }
    }

    final synchronized void zzl(Context context, zzcb zzcbVar) {
        if (this.zzc != null) {
            return;
        }
        this.zzc = context.getApplicationContext();
        if (this.zzk == null) {
            this.zzk = zzcbVar;
        }
    }
}
