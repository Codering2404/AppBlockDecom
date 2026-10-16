package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbmc extends zzbee implements zzbme {
    zzbmc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final IObjectWrapper zzb() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(1, zza());
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperX3;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final Uri zzc() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(2, zza());
        Uri uri = (Uri) zzbeg.zzb(parcelZzcZ, Uri.CREATOR);
        parcelZzcZ.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final double zzd() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(3, zza());
        double d3 = parcelZzcZ.readDouble();
        parcelZzcZ.recycle();
        return d3;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final int zze() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(4, zza());
        int i3 = parcelZzcZ.readInt();
        parcelZzcZ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final int zzf() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(5, zza());
        int i3 = parcelZzcZ.readInt();
        parcelZzcZ.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final Map zzg() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(6, zza());
        HashMap mapZzg = zzbeg.zzg(parcelZzcZ);
        parcelZzcZ.recycle();
        return mapZzg;
    }
}
