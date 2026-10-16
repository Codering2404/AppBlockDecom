package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zab implements Parcelable.Creator {
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
        ArrayList arrayListU = null;
        String strQ7 = null;
        String strQ8 = null;
        long J = 0;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.p(parcel, iE, Uri.CREATOR);
                    break;
                case 7:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 9:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 10:
                    arrayListU = SafeParcelReader.u(parcel, iE, Scope.CREATOR);
                    break;
                case 11:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 12:
                    strQ8 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GoogleSignInAccount(iG, strQ, strQ2, strQ3, strQ4, uri, strQ5, J, strQ6, arrayListU, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GoogleSignInAccount[i3];
    }
}
