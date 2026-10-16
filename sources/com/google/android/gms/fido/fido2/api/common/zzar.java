package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzar implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        byte[] bArrG = null;
        Double dB = null;
        String strQ = null;
        ArrayList arrayListU = null;
        Integer numH = null;
        TokenBinding tokenBinding = null;
        String strQ2 = null;
        AuthenticationExtensions authenticationExtensions = null;
        Long lK = null;
        String strQ3 = null;
        ResultReceiver resultReceiver = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    bArrG = SafeParcelReader.g(parcel, iE);
                    break;
                case 3:
                    dB = SafeParcelReader.B(parcel, iE);
                    break;
                case 4:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    arrayListU = SafeParcelReader.u(parcel, iE, PublicKeyCredentialDescriptor.CREATOR);
                    break;
                case 6:
                    numH = SafeParcelReader.H(parcel, iE);
                    break;
                case 7:
                    tokenBinding = (TokenBinding) SafeParcelReader.p(parcel, iE, TokenBinding.CREATOR);
                    break;
                case 8:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    authenticationExtensions = (AuthenticationExtensions) SafeParcelReader.p(parcel, iE, AuthenticationExtensions.CREATOR);
                    break;
                case 10:
                    lK = SafeParcelReader.K(parcel, iE);
                    break;
                case 11:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 12:
                    resultReceiver = (ResultReceiver) SafeParcelReader.p(parcel, iE, ResultReceiver.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PublicKeyCredentialRequestOptions(bArrG, dB, strQ, arrayListU, numH, tokenBinding, strQ2, authenticationExtensions, lK, strQ3, resultReceiver);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new PublicKeyCredentialRequestOptions[i3];
    }
}
