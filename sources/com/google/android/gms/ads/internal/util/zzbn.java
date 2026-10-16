package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbn extends zzbef implements zzbo {
    public zzbn() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            String string = parcel.readString();
            String string2 = parcel.readString();
            zzbeg.zzh(parcel);
            boolean zZze = zze(iObjectWrapperX3, string, string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZze ? 1 : 0);
        } else if (i3 == 2) {
            IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            zzbeg.zzh(parcel);
            zzf(iObjectWrapperX32);
            parcel2.writeNoException();
        } else {
            if (i3 != 3) {
                return false;
            }
            IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            com.google.android.gms.ads.internal.offline.buffering.zza zzaVar = (com.google.android.gms.ads.internal.offline.buffering.zza) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.offline.buffering.zza.CREATOR);
            zzbeg.zzh(parcel);
            boolean zZzg = zzg(iObjectWrapperX33, zzaVar);
            parcel2.writeNoException();
            parcel2.writeInt(zZzg ? 1 : 0);
        }
        return true;
    }
}
