package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyk extends NativeAd.Image {
    private final zzbme zzb;
    private final Drawable zzc;
    private final Uri zzd;
    private final double zze;
    private final int zzf;
    private final int zzg;

    public zzbyk(zzbme zzbmeVar) {
        Uri uriZzc;
        double dZzd;
        int iZze;
        IObjectWrapper iObjectWrapperZzb;
        this.zzb = zzbmeVar;
        Map mapZzg = null;
        try {
            iObjectWrapperZzb = zzbmeVar.zzb();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        Drawable drawable = iObjectWrapperZzb != null ? (Drawable) ObjectWrapper.h5(iObjectWrapperZzb) : null;
        this.zzc = drawable;
        try {
            uriZzc = this.zzb.zzc();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
            uriZzc = null;
        }
        this.zzd = uriZzc;
        try {
            dZzd = this.zzb.zzd();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
            dZzd = 1.0d;
        }
        this.zze = dZzd;
        int iZzf = -1;
        try {
            iZze = this.zzb.zze();
        } catch (RemoteException e6) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e6);
            iZze = -1;
        }
        this.zzf = iZze;
        try {
            iZzf = this.zzb.zzf();
        } catch (RemoteException e7) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e7);
        }
        this.zzg = iZzf;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeP)).booleanValue()) {
            try {
                mapZzg = this.zzb.zzg();
            } catch (RemoteException unused) {
            }
        }
        this.zza = mapZzg;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Uri getUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zzb() {
        return this.zzg;
    }
}
