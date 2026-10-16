package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbgx {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbgt(this);
    private final Object zzc = new Object();
    private zzbha zzd;
    private Context zze;
    private zzbhd zzf;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final void zzf() {
        synchronized (this.zzc) {
            try {
                if (this.zze != null && this.zzd == null) {
                    zzbha zzbhaVarZze = zze(new zzbgv(this), new zzbgw(this));
                    this.zzd = zzbhaVarZze;
                    zzbhaVarZze.checkAvailabilityAndConnect();
                }
            } finally {
            }
        }
    }

    public final void zza(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            try {
                if (this.zze != null) {
                    return;
                }
                this.zze = context.getApplicationContext();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfg)).booleanValue()) {
                    zzf();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzff)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.k().zzb(new zzbgu(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfh)).booleanValue()) {
            synchronized (this.zzc) {
                try {
                    zzf();
                    ScheduledFuture scheduledFuture = this.zza;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zza = zzcfr.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfi)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final zzbgy zzc(zzbhb zzbhbVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbgy();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzf(zzbhbVar);
                }
                return this.zzf.zze(zzbhbVar);
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to call into cache service.", e3);
                return new zzbgy();
            }
        }
    }

    public final long zzd(zzbhb zzbhbVar) {
        synchronized (this.zzc) {
            try {
                if (this.zzf == null) {
                    return -2L;
                }
                if (this.zzd.zzp()) {
                    try {
                        return this.zzf.zzg(zzbhbVar);
                    } catch (RemoteException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Unable to call into cache service.", e3);
                    }
                }
                return -2L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final synchronized zzbha zze(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbha(this.zze, com.google.android.gms.ads.internal.zzt.w().a(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    final /* synthetic */ void zzg() {
        synchronized (this.zzc) {
            try {
                zzbha zzbhaVar = this.zzd;
                if (zzbhaVar == null) {
                    return;
                }
                if (zzbhaVar.isConnected() || this.zzd.isConnecting()) {
                    this.zzd.disconnect();
                }
                this.zzd = null;
                this.zzf = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ Object zzh() {
        return this.zzc;
    }

    final /* synthetic */ zzbha zzi() {
        return this.zzd;
    }

    final /* synthetic */ void zzj(zzbha zzbhaVar) {
        this.zzd = null;
    }

    final /* synthetic */ void zzk(zzbhd zzbhdVar) {
        this.zzf = zzbhdVar;
    }
}
