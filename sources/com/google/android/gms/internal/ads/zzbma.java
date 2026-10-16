package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbma extends zzbef implements zzbmb {
    public zzbma() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzbnj zzbnjVar;
        switch (i3) {
            case 2:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzf(iObjectWrapperX3);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperZzg = zzg();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzg);
                return true;
            case 5:
                float fZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzh);
                return true;
            case 6:
                float fZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzi);
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzj = zzj();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzeaVarZzj);
                return true;
            case 8:
                boolean zZzk = zzk();
                parcel2.writeNoException();
                int i5 = zzbeg.zza;
                parcel2.writeInt(zZzk ? 1 : 0);
                return true;
            case 9:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbnjVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    zzbnjVar = iInterfaceQueryLocalInterface instanceof zzbnj ? (zzbnj) iInterfaceQueryLocalInterface : new zzbnj(strongBinder);
                }
                zzbeg.zzh(parcel);
                zzm(zzbnjVar);
                parcel2.writeNoException();
                return true;
            case 10:
                boolean zZzl = zzl();
                parcel2.writeNoException();
                int i6 = zzbeg.zza;
                parcel2.writeInt(zZzl ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
