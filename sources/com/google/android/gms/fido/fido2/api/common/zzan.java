package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzan implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = null;
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = null;
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        Double dB = null;
        ArrayList arrayListU2 = null;
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = null;
        Integer numH = null;
        TokenBinding tokenBinding = null;
        String strQ = null;
        AuthenticationExtensions authenticationExtensions = null;
        String strQ2 = null;
        ResultReceiver resultReceiver = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) SafeParcelReader.p(parcel, iE, PublicKeyCredentialRpEntity.CREATOR);
                    break;
                case 3:
                    publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) SafeParcelReader.p(parcel, iE, PublicKeyCredentialUserEntity.CREATOR);
                    break;
                case 4:
                    bArrG = SafeParcelReader.g(parcel, iE);
                    break;
                case 5:
                    arrayListU = SafeParcelReader.u(parcel, iE, PublicKeyCredentialParameters.CREATOR);
                    break;
                case 6:
                    dB = SafeParcelReader.B(parcel, iE);
                    break;
                case 7:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, PublicKeyCredentialDescriptor.CREATOR);
                    break;
                case 8:
                    authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) SafeParcelReader.p(parcel, iE, AuthenticatorSelectionCriteria.CREATOR);
                    break;
                case 9:
                    numH = SafeParcelReader.H(parcel, iE);
                    break;
                case 10:
                    tokenBinding = (TokenBinding) SafeParcelReader.p(parcel, iE, TokenBinding.CREATOR);
                    break;
                case 11:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 12:
                    authenticationExtensions = (AuthenticationExtensions) SafeParcelReader.p(parcel, iE, AuthenticationExtensions.CREATOR);
                    break;
                case 13:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 14:
                    resultReceiver = (ResultReceiver) SafeParcelReader.p(parcel, iE, ResultReceiver.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArrG, arrayListU, dB, arrayListU2, authenticatorSelectionCriteria, numH, tokenBinding, strQ, authenticationExtensions, strQ2, resultReceiver);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new PublicKeyCredentialCreationOptions[i3];
    }
}
