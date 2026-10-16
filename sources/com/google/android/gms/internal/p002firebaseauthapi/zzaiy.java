package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaiy implements Parcelable.Creator<zzaiz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiz createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            SafeParcelReader.w(iE);
            SafeParcelReader.N(parcel, iE);
        }
        SafeParcelReader.v(parcel, iO);
        return new zzaiz();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiz[] newArray(int i3) {
        return new zzaiz[i3];
    }
}
