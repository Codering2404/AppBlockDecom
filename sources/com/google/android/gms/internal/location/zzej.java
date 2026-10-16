package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzej implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        zzeg zzegVar = null;
        IBinder iBinderF = null;
        IBinder iBinderF2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderF3 = null;
        String strQ = null;
        int iG = 1;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    zzegVar = (zzeg) SafeParcelReader.p(parcel, iE, zzeg.CREATOR);
                    break;
                case 3:
                    iBinderF = SafeParcelReader.F(parcel, iE);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.p(parcel, iE, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderF2 = SafeParcelReader.F(parcel, iE);
                    break;
                case 6:
                    iBinderF3 = SafeParcelReader.F(parcel, iE);
                    break;
                case 7:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 8:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzei(iG, zzegVar, iBinderF, iBinderF2, pendingIntent, iBinderF3, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzei[i3];
    }
}
