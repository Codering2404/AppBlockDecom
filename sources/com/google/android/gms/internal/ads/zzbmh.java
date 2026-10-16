package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbmh extends zzbef implements zzbmi {
    public zzbmh() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbmi zzdG(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return iInterfaceQueryLocalInterface instanceof zzbmi ? (zzbmi) iInterfaceQueryLocalInterface : new zzbmg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzbmb zzblzVar;
        switch (i3) {
            case 1:
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzb(string, iObjectWrapperX3);
                parcel2.writeNoException();
                return true;
            case 2:
                String string2 = parcel.readString();
                zzbeg.zzh(parcel);
                IObjectWrapper iObjectWrapperZzc = zzc(string2);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzc);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzd(iObjectWrapperX32);
                parcel2.writeNoException();
                return true;
            case 4:
                zze();
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                parcel.readInt();
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzdB(iObjectWrapperX33);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzdD(iObjectWrapperX34);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzblzVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    zzblzVar = iInterfaceQueryLocalInterface instanceof zzbmb ? (zzbmb) iInterfaceQueryLocalInterface : new zzblz(strongBinder);
                }
                zzbeg.zzh(parcel);
                zzdE(zzblzVar);
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperX35 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzdC(iObjectWrapperX35);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
