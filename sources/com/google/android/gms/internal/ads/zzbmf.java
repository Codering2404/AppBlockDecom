package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbmf extends NativeAd.Image {
    private final zzbme zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzbmf(zzbme zzbmeVar) {
        double dZzd;
        int iZze;
        IObjectWrapper iObjectWrapperZzb;
        this.zza = zzbmeVar;
        Uri uriZzc = null;
        try {
            iObjectWrapperZzb = zzbmeVar.zzb();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        Drawable drawable = iObjectWrapperZzb != null ? (Drawable) ObjectWrapper.h5(iObjectWrapperZzb) : null;
        this.zzb = drawable;
        try {
            uriZzc = this.zza.zzc();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
        this.zzc = uriZzc;
        try {
            dZzd = this.zza.zzd();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
            dZzd = 1.0d;
        }
        this.zzd = dZzd;
        int iZzf = -1;
        try {
            iZze = this.zza.zze();
        } catch (RemoteException e6) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e6);
            iZze = -1;
        }
        this.zze = iZze;
        try {
            iZzf = this.zza.zzf();
        } catch (RemoteException e7) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e7);
        }
        this.zzf = iZzf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int zzb() {
        return this.zzf;
    }
}
