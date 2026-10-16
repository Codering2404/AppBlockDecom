package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GetCredentialRequestCreator implements Parcelable.Creator<GetCredentialRequest> {
    static void c(GetCredentialRequest getCredentialRequest, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, getCredentialRequest.M(), false);
        SafeParcelWriter.j(parcel, 2, getCredentialRequest.N(), false);
        SafeParcelWriter.G(parcel, 3, getCredentialRequest.O(), false);
        SafeParcelWriter.E(parcel, 4, getCredentialRequest.g0(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetCredentialRequest createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        Bundle bundleF = null;
        String strQ = null;
        ResultReceiver resultReceiver = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                arrayListU = SafeParcelReader.u(parcel, iE, CredentialOption.CREATOR);
            } else if (iW == 2) {
                bundleF = SafeParcelReader.f(parcel, iE);
            } else if (iW == 3) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                resultReceiver = (ResultReceiver) SafeParcelReader.p(parcel, iE, ResultReceiver.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GetCredentialRequest(arrayListU, bundleF, strQ, resultReceiver);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public GetCredentialRequest[] newArray(int i3) {
        return new GetCredentialRequest[i3];
    }
}
