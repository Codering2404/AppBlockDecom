package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zbc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f71227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f71228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f71229c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f71228b = googleSignInAccount;
        this.f71227a = Preconditions.h(str, "8.3 and 8.4 SDKs require non-null email");
        this.f71229c = Preconditions.h(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount M() {
        return this.f71228b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f71227a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 4, str, false);
        SafeParcelWriter.E(parcel, 7, this.f71228b, i3, false);
        SafeParcelWriter.G(parcel, 8, this.f71229c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
