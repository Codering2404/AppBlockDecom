package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListS = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 7:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new BeginSignInRequest.GoogleIdTokenRequestOptions(zX, strQ, strQ2, zX2, strQ3, arrayListS, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new BeginSignInRequest.GoogleIdTokenRequestOptions[i3];
    }
}
