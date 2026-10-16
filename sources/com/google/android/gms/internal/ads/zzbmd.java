package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbmd extends zzbef implements zzbme {
    public zzbmd() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbme zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzbme ? (zzbme) iInterfaceQueryLocalInterface : new zzbmc(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 1:
                IObjectWrapper iObjectWrapperZzb = zzb();
                parcel2.writeNoException();
                zzbeg.zze(parcel2, iObjectWrapperZzb);
                return true;
            case 2:
                Uri uriZzc = zzc();
                parcel2.writeNoException();
                zzbeg.zzd(parcel2, uriZzc);
                return true;
            case 3:
                double dZzd = zzd();
                parcel2.writeNoException();
                parcel2.writeDouble(dZzd);
                return true;
            case 4:
                int iZze = zze();
                parcel2.writeNoException();
                parcel2.writeInt(iZze);
                return true;
            case 5:
                int iZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeInt(iZzf);
                return true;
            case 6:
                Map mapZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeMap(mapZzg);
                return true;
            default:
                return false;
        }
    }
}
