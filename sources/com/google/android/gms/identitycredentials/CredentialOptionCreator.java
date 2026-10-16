package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CredentialOptionCreator implements Parcelable.Creator<CredentialOption> {
    static void c(CredentialOption credentialOption, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, credentialOption.w0(), false);
        SafeParcelWriter.j(parcel, 2, credentialOption.N(), false);
        SafeParcelWriter.j(parcel, 3, credentialOption.M(), false);
        SafeParcelWriter.G(parcel, 4, credentialOption.g0(), false);
        SafeParcelWriter.G(parcel, 5, credentialOption.j0(), false);
        SafeParcelWriter.G(parcel, 6, credentialOption.O(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CredentialOption createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = "";
        String strQ2 = strQ;
        String strQ3 = strQ2;
        Bundle bundleF = null;
        Bundle bundleF2 = null;
        String strQ4 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 2:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 3:
                    bundleF2 = SafeParcelReader.f(parcel, iE);
                    break;
                case 4:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new CredentialOption(strQ, bundleF, bundleF2, strQ4, strQ2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CredentialOption[] newArray(int i3) {
        return new CredentialOption[i3];
    }
}
