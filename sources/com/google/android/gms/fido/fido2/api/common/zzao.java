package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzao implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        byte[] bArrG = null;
        AuthenticatorAttestationResponse authenticatorAttestationResponse = null;
        AuthenticatorAssertionResponse authenticatorAssertionResponse = null;
        AuthenticatorErrorResponse authenticatorErrorResponse = null;
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = null;
        String strQ3 = null;
        String strQ4 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 2:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    bArrG = SafeParcelReader.g(parcel, iE);
                    break;
                case 4:
                    authenticatorAttestationResponse = (AuthenticatorAttestationResponse) SafeParcelReader.p(parcel, iE, AuthenticatorAttestationResponse.CREATOR);
                    break;
                case 5:
                    authenticatorAssertionResponse = (AuthenticatorAssertionResponse) SafeParcelReader.p(parcel, iE, AuthenticatorAssertionResponse.CREATOR);
                    break;
                case 6:
                    authenticatorErrorResponse = (AuthenticatorErrorResponse) SafeParcelReader.p(parcel, iE, AuthenticatorErrorResponse.CREATOR);
                    break;
                case 7:
                    authenticationExtensionsClientOutputs = (AuthenticationExtensionsClientOutputs) SafeParcelReader.p(parcel, iE, AuthenticationExtensionsClientOutputs.CREATOR);
                    break;
                case 8:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PublicKeyCredential(strQ, strQ2, bArrG, authenticatorAttestationResponse, authenticatorAssertionResponse, authenticatorErrorResponse, authenticationExtensionsClientOutputs, strQ3, strQ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new PublicKeyCredential[i3];
    }
}
