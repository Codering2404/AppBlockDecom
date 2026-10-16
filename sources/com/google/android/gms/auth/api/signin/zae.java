package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zae implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        Account account = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU2 = null;
        String strQ3 = null;
        int iG = 0;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    arrayListU = SafeParcelReader.u(parcel, iE, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.p(parcel, iE, Account.CREATOR);
                    break;
                case 4:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 7:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GoogleSignInOptions(iG, arrayListU, account, zX, zX2, zX3, strQ, strQ2, arrayListU2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GoogleSignInOptions[i3];
    }
}
