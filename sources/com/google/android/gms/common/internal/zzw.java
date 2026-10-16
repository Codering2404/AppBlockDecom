package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzw extends com.google.android.gms.internal.common.zzb implements zzx {
    public zzw() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzx x3(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof zzx ? (zzx) iInterfaceQueryLocalInterface : new zzv(iBinder);
    }

    @Override // com.google.android.gms.internal.common.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            IObjectWrapper iObjectWrapperZzd = zzd();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzc.zze(parcel2, iObjectWrapperZzd);
        } else {
            if (i3 != 2) {
                return false;
            }
            int iZze = zze();
            parcel2.writeNoException();
            parcel2.writeInt(iZze);
        }
        return true;
    }
}
