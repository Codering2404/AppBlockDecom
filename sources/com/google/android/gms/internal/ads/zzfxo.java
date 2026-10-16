package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfxo implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfyi zza;
    private final String zzb;
    private final String zzc;
    private final zzbds zzd;
    private final LinkedBlockingQueue zze;
    private final HandlerThread zzf;
    private final zzfxg zzg;
    private final long zzh;

    public zzfxo(Context context, int i3, zzbds zzbdsVar, String str, String str2, String str3, zzfxg zzfxgVar) {
        this.zzb = str;
        this.zzd = zzbdsVar;
        this.zzc = str2;
        this.zzg = zzfxgVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzf = handlerThread;
        handlerThread.start();
        this.zzh = System.currentTimeMillis();
        zzfyi zzfyiVar = new zzfyi(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfyiVar;
        this.zze = new LinkedBlockingQueue();
        zzfyiVar.checkAvailabilityAndConnect();
    }

    private final void zzd(int i3, long j3, Exception exc) {
        zzfxg zzfxgVar = this.zzg;
        if (zzfxgVar != null) {
            zzfxgVar.zzc(i3, System.currentTimeMillis() - j3, exc);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfyn zzfynVarZzc = zzc();
        if (zzfynVarZzc != null) {
            try {
                zzfyu zzfyuVarZzg = zzfynVarZzc.zzg(new zzfys(1, this.zzd, this.zzb, this.zzc));
                zzd(5011, this.zzh, null);
                this.zze.put(zzfyuVarZzg);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzd(4012, this.zzh, null);
            this.zze.put(new zzfyu(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        try {
            zzd(4011, this.zzh, null);
            this.zze.put(new zzfyu(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final zzfyu zza(int i3) {
        zzfyu zzfyuVar;
        try {
            zzfyuVar = (zzfyu) this.zze.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            zzd(AdError.INTERSTITIAL_AD_TIMEOUT, this.zzh, e3);
            zzfyuVar = null;
        }
        zzd(3004, this.zzh, null);
        if (zzfyuVar != null) {
            if (zzfyuVar.zzc == 7) {
                zzfxg.zzg(3);
            } else {
                zzfxg.zzg(2);
            }
        }
        return zzfyuVar == null ? new zzfyu(null, 1) : zzfyuVar;
    }

    public final void zzb() {
        zzfyi zzfyiVar = this.zza;
        if (zzfyiVar != null) {
            if (zzfyiVar.isConnected() || zzfyiVar.isConnecting()) {
                zzfyiVar.disconnect();
            }
        }
    }

    protected final zzfyn zzc() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
