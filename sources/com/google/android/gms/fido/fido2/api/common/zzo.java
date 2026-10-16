package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzo implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = null;
        Uri uri = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) SafeParcelReader.p(parcel, iE, PublicKeyCredentialRequestOptions.CREATOR);
            } else if (iW == 3) {
                uri = (Uri) SafeParcelReader.p(parcel, iE, Uri.CREATOR);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                bArrG = SafeParcelReader.g(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new BrowserPublicKeyCredentialRequestOptions(publicKeyCredentialRequestOptions, uri, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new BrowserPublicKeyCredentialRequestOptions[i3];
    }
}
