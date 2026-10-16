package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbgi extends zzbef implements zzbgj {
    public zzbgi() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public static zzbgj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
        return iInterfaceQueryLocalInterface instanceof zzbgj ? (zzbgj) iInterfaceQueryLocalInterface : new zzbgh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzbgq zzbgoVar;
        switch (i3) {
            case 2:
                com.google.android.gms.ads.internal.client.zzbu zzbuVarZze = zze();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarZze);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (iInterfaceQueryLocalInterface instanceof zzbgn) {
                    }
                }
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzbgoVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    zzbgoVar = iInterfaceQueryLocalInterface2 instanceof zzbgq ? (zzbgq) iInterfaceQueryLocalInterface2 : new zzbgo(strongBinder2);
                }
                zzbeg.zzh(parcel);
                zzf(iObjectWrapperX3, zzbgoVar);
                parcel2.writeNoException();
                return true;
            case 5:
                com.google.android.gms.ads.internal.client.zzdx zzdxVarZzg = zzg();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzdxVarZzg);
                return true;
            case 6:
                boolean zZza = zzbeg.zza(parcel);
                zzbeg.zzh(parcel);
                zzh(zZza);
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarX3 = com.google.android.gms.ads.internal.client.zzdp.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzi(zzdqVarX3);
                parcel2.writeNoException();
                return true;
            case 8:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 9:
                long jZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeLong(jZzk);
                return true;
            case 10:
                long j3 = parcel.readLong();
                zzbeg.zzh(parcel);
                zzl(j3);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
