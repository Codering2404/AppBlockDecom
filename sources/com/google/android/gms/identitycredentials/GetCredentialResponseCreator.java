package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GetCredentialResponseCreator implements Parcelable.Creator<GetCredentialResponse> {
    static void c(GetCredentialResponse getCredentialResponse, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, getCredentialResponse.M(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetCredentialResponse createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            if (SafeParcelReader.w(iE) != 1) {
                SafeParcelReader.N(parcel, iE);
            } else {
                credential = (Credential) SafeParcelReader.p(parcel, iE, Credential.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GetCredentialResponse(credential);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public GetCredentialResponse[] newArray(int i3) {
        return new GetCredentialResponse[i3];
    }
}
