package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaj implements Parcelable.Creator<GithubAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GithubAuthCredential createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            if (SafeParcelReader.w(iE) != 1) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GithubAuthCredential(strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GithubAuthCredential[] newArray(int i3) {
        return new GithubAuthCredential[i3];
    }
}
