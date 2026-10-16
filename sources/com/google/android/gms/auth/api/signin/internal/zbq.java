package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zbq extends com.google.android.gms.internal.p000authapi.zbb implements zbr {
    public zbq() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    protected final boolean zba(int i3, Parcel parcel, Parcel parcel2, int i4) {
        switch (i3) {
            case 101:
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) com.google.android.gms.internal.p000authapi.zbc.zba(parcel, GoogleSignInAccount.CREATOR);
                Status status = (Status) com.google.android.gms.internal.p000authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p000authapi.zbc.zbb(parcel);
                Y0(googleSignInAccount, status);
                break;
            case 102:
                Status status2 = (Status) com.google.android.gms.internal.p000authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p000authapi.zbc.zbb(parcel);
                V3(status2);
                break;
            case 103:
                Status status3 = (Status) com.google.android.gms.internal.p000authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p000authapi.zbc.zbb(parcel);
                z3(status3);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
