package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SignInPassword extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInPassword> CREATOR = new zbw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71153b;

    public SignInPassword(String str, String str2) {
        this.f71152a = Preconditions.h(((String) Preconditions.n(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f71153b = Preconditions.g(str2);
    }

    public String M() {
        return this.f71152a;
    }

    public String N() {
        return this.f71153b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        return Objects.b(this.f71152a, signInPassword.f71152a) && Objects.b(this.f71153b, signInPassword.f71153b);
    }

    public int hashCode() {
        return Objects.c(this.f71152a, this.f71153b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, M(), false);
        SafeParcelWriter.G(parcel, 2, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
