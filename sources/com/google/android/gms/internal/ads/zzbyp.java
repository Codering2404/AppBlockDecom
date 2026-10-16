package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyp implements NativeCustomFormatAd {
    private final zzbmv zza;
    private NativeCustomFormatAd.DisplayOpenMeasurement zzb;

    public zzbyp(zzbmv zzbmvVar) {
        this.zza = zzbmvVar;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final String getCustomFormatId() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzb == null) {
                zzbmv zzbmvVar = this.zza;
                if (zzbmvVar.zzo()) {
                    this.zzb = new zzbyj(zzbmvVar);
                }
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        return this.zzb;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzbme zzbmeVarZzf = this.zza.zzf(str);
            if (zzbmeVarZzf != null) {
                return new zzbyk(zzbmeVarZzf);
            }
            return null;
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final MediaContent getMediaContent() {
        try {
            zzbmv zzbmvVar = this.zza;
            if (zzbmvVar.zzs() != null) {
                return new com.google.android.gms.ads.internal.client.zzfb(zzbmvVar.zzs(), zzbmvVar);
            }
            return null;
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zze(str);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zza.zzi(str);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }
}
