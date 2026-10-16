package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbm extends zzbef implements zzbn {
    public zzbm() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i3 == 1) {
            zzm zzmVar = (zzm) zzbeg.zzb(parcel, zzm.CREATOR);
            zzbeg.zzh(parcel);
            zze(zzmVar);
            parcel2.writeNoException();
        } else if (i3 == 2) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
        } else if (i3 == 3) {
            boolean zZzg = zzg();
            parcel2.writeNoException();
            int i5 = zzbeg.zza;
            parcel2.writeInt(zZzg ? 1 : 0);
        } else if (i3 == 4) {
            String strZzh = zzh();
            parcel2.writeNoException();
            parcel2.writeString(strZzh);
        } else {
            if (i3 != 5) {
                return false;
            }
            zzm zzmVar2 = (zzm) zzbeg.zzb(parcel, zzm.CREATOR);
            int i6 = parcel.readInt();
            zzbeg.zzh(parcel);
            zzi(zzmVar2, i6);
            parcel2.writeNoException();
        }
        return true;
    }
}
