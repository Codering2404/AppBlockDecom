package com.google.android.gms.fido.fido2.api.common;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzy implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        String strQ = null;
        String strQ2 = null;
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        Account account = null;
        long J = 0;
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
                    bArrG2 = SafeParcelReader.g(parcel, iE);
                    break;
                case 5:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 7:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.p(parcel, iE, Account.CREATOR);
                    break;
                case 9:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new FidoCredentialDetails(strQ, strQ2, bArrG, bArrG2, zX, zX2, J, account, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new FidoCredentialDetails[i3];
    }
}
