package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        int iG = 0;
        String strQ = null;
        String strQ2 = null;
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
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GetSignInIntentRequest(strQ, strQ2, strQ3, strQ4, zX, iG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GetSignInIntentRequest[i3];
    }
}
