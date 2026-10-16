package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zbu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GoogleSignInOptions f71235b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f71234a = Preconditions.g(str);
        this.f71235b = googleSignInOptions;
    }

    public final GoogleSignInOptions M() {
        return this.f71235b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f71234a.equals(signInConfiguration.f71234a)) {
            GoogleSignInOptions googleSignInOptions = this.f71235b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f71235b;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(googleSignInOptions2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().a(this.f71234a).a(this.f71235b).b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f71234a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.E(parcel, 5, this.f71235b, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
