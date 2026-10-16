package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class RegistrationRequestCreator implements Parcelable.Creator<RegistrationRequest> {
    static void c(RegistrationRequest registrationRequest, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, registrationRequest.M(), false);
        SafeParcelWriter.l(parcel, 2, registrationRequest.N(), false);
        SafeParcelWriter.G(parcel, 3, registrationRequest.j0(), false);
        SafeParcelWriter.G(parcel, 4, registrationRequest.g0(), false);
        SafeParcelWriter.I(parcel, 5, registrationRequest.O(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegistrationRequest createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        List listS = Collections.EMPTY_LIST;
        String strQ = "";
        String strQ2 = strQ;
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                bArrG = SafeParcelReader.g(parcel, iE);
            } else if (iW == 2) {
                bArrG2 = SafeParcelReader.g(parcel, iE);
            } else if (iW == 3) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                listS = SafeParcelReader.s(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new RegistrationRequest(bArrG, bArrG2, strQ, strQ2, listS);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RegistrationRequest[] newArray(int i3) {
        return new RegistrationRequest[i3];
    }
}
