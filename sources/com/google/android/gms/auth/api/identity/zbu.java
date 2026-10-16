package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        Uri uri = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        PublicKeyCredential publicKeyCredential = null;
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
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    uri = (Uri) SafeParcelReader.p(parcel, iE, Uri.CREATOR);
                    break;
                case 6:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    publicKeyCredential = (PublicKeyCredential) SafeParcelReader.p(parcel, iE, PublicKeyCredential.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new SignInCredential(strQ, strQ2, strQ3, strQ4, uri, strQ5, strQ6, strQ7, publicKeyCredential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new SignInCredential[i3];
    }
}
