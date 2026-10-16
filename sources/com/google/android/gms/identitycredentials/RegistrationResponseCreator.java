package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class RegistrationResponseCreator implements Parcelable.Creator<RegistrationResponse> {
    static void c(RegistrationResponse registrationResponse, Parcel parcel, int i3) {
        SafeParcelWriter.b(parcel, SafeParcelWriter.a(parcel));
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegistrationResponse createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            SafeParcelReader.w(iE);
            SafeParcelReader.N(parcel, iE);
        }
        SafeParcelReader.v(parcel, iO);
        return new RegistrationResponse();
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RegistrationResponse[] newArray(int i3) {
        return new RegistrationResponse[i3];
    }
}
