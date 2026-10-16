package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdz extends zzbef implements zzea {
    public zzdz() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzea zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        zzed zzebVar;
        switch (i3) {
            case 1:
                zze();
                parcel2.writeNoException();
                return true;
            case 2:
                zzf();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZza = zzbeg.zza(parcel);
                zzbeg.zzh(parcel);
                zzg(zZza);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zZzh = zzh();
                parcel2.writeNoException();
                int i5 = zzbeg.zza;
                parcel2.writeInt(zZzh ? 1 : 0);
                return true;
            case 5:
                int iZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeInt(iZzi);
                return true;
            case 6:
                float fZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzj);
                return true;
            case 7:
                float fZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzk);
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzebVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzebVar = iInterfaceQueryLocalInterface instanceof zzed ? (zzed) iInterfaceQueryLocalInterface : new zzeb(strongBinder);
                }
                zzbeg.zzh(parcel);
                zzl(zzebVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float fZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzm);
                return true;
            case 10:
                boolean zZzn = zzn();
                parcel2.writeNoException();
                int i6 = zzbeg.zza;
                parcel2.writeInt(zZzn ? 1 : 0);
                return true;
            case 11:
                zzed zzedVarZzo = zzo();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzedVarZzo);
                return true;
            case 12:
                boolean zZzp = zzp();
                parcel2.writeNoException();
                int i7 = zzbeg.zza;
                parcel2.writeInt(zZzp ? 1 : 0);
                return true;
            case 13:
                zzq();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
