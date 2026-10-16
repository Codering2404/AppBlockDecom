package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbh implements Parcelable.Creator {
    static void a(zzbg zzbgVar, Parcel parcel, int i3) {
        String str = zzbgVar.f73484a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.E(parcel, 3, zzbgVar.f73485b, i3, false);
        SafeParcelWriter.G(parcel, 4, zzbgVar.f73486c, false);
        SafeParcelWriter.z(parcel, 5, zzbgVar.f73487d);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        long J = 0;
        String strQ = null;
        zzbe zzbeVar = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                zzbeVar = (zzbe) SafeParcelReader.p(parcel, iE, zzbe.CREATOR);
            } else if (iW == 4) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                J = SafeParcelReader.J(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzbg(strQ, zzbeVar, strQ2, J);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzbg[i3];
    }
}
