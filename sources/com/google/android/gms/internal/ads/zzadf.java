package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzadf extends HandlerThread implements Handler.Callback {
    private zzdv zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzadg zze;

    public zzadf() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zzdv zzdvVar;
        int i3 = message.what;
        try {
            if (i3 == 1) {
                try {
                    try {
                        int i4 = message.arg1;
                        zzdv zzdvVar2 = this.zza;
                        if (zzdvVar2 == null) {
                            throw null;
                        }
                        zzdvVar2.zza(i4);
                        this.zze = new zzadg(this, this.zza.zzc(), i4 != 0, null);
                        synchronized (this) {
                            notify();
                        }
                    } catch (zzdw e3) {
                        zzeg.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                        this.zzd = new IllegalStateException(e3);
                        synchronized (this) {
                            notify();
                        }
                    }
                } catch (Error e4) {
                    zzeg.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                    this.zzc = e4;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e5) {
                    zzeg.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e5);
                    this.zzd = e5;
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i3 == 2) {
                try {
                    zzdvVar = this.zza;
                } finally {
                    try {
                    } finally {
                    }
                }
                if (zzdvVar == null) {
                    throw null;
                }
                zzdvVar.zzb();
                return true;
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }

    public final zzadg zza(int i3) {
        boolean z2;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzdv(this.zzb, null);
        synchronized (this) {
            z2 = false;
            this.zzb.obtainMessage(1, i3, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzc;
        if (error != null) {
            throw error;
        }
        zzadg zzadgVar = this.zze;
        zzadgVar.getClass();
        return zzadgVar;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
