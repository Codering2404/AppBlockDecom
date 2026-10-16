package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Account f72070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GoogleSignInAccount f72072d;

    zat(int i3, Account account, int i4, GoogleSignInAccount googleSignInAccount) {
        this.f72069a = i3;
        this.f72070b = account;
        this.f72071c = i4;
        this.f72072d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72069a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.E(parcel, 2, this.f72070b, i3, false);
        SafeParcelWriter.u(parcel, 3, this.f72071c);
        SafeParcelWriter.E(parcel, 4, this.f72072d, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zat(Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i3, googleSignInAccount);
    }
}
