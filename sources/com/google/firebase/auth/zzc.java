package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzc implements Parcelable.Creator<PhoneAuthProvider.ForceResendingToken> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            SafeParcelReader.w(iE);
            SafeParcelReader.N(parcel, iE);
        }
        SafeParcelReader.v(parcel, iO);
        return new PhoneAuthProvider.ForceResendingToken();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken[] newArray(int i3) {
        return new PhoneAuthProvider.ForceResendingToken[i3];
    }
}
