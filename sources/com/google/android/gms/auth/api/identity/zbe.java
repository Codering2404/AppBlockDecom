package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbe implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        String strQ = null;
        Account account = null;
        String strQ2 = null;
        String strQ3 = null;
        Bundle bundleF = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    arrayListU = SafeParcelReader.u(parcel, iE, Scope.CREATOR);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 4:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    account = (Account) SafeParcelReader.p(parcel, iE, Account.CREATOR);
                    break;
                case 6:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new AuthorizationRequest(arrayListU, strQ, zX, zX2, account, strQ2, strQ3, zX3, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AuthorizationRequest[i3];
    }
}
