package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        Intent intent = null;
        IBinder iBinderF = null;
        Bundle bundleF = null;
        boolean zX = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    intent = (Intent) SafeParcelReader.p(parcel, iE, Intent.CREATOR);
                    break;
                case 10:
                    iBinderF = SafeParcelReader.F(parcel, iE);
                    break;
                case 11:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 12:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzc(strQ, strQ2, strQ3, strQ4, strQ5, strQ6, strQ7, intent, iBinderF, zX, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzc[i3];
    }
}
