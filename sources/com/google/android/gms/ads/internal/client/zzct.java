package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzct extends zzbee implements zzcv {
    zzct(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final zzbvc getAdapterCreator() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(2, zza());
        zzbvc zzbvcVarZzf = zzbvb.zzf(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbvcVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final zzez getLiteSdkVersion() throws RemoteException {
        Parcel parcelZzcZ = zzcZ(1, zza());
        zzez zzezVar = (zzez) zzbeg.zzb(parcelZzcZ, zzez.CREATOR);
        parcelZzcZ.recycle();
        return zzezVar;
    }
}
