package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zbu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f71146d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f71147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f71148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f71149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f71150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PublicKeyCredential f71151j;

    SignInCredential(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, PublicKeyCredential publicKeyCredential) {
        this.f71143a = (String) Preconditions.m(str);
        this.f71144b = str2;
        this.f71145c = str3;
        this.f71146d = str4;
        this.f71147f = uri;
        this.f71148g = str5;
        this.f71149h = str6;
        this.f71150i = str7;
        this.f71151j = publicKeyCredential;
    }

    public PublicKeyCredential J2() {
        return this.f71151j;
    }

    public String M() {
        return this.f71144b;
    }

    public String N() {
        return this.f71146d;
    }

    public String O() {
        return this.f71145c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        return Objects.b(this.f71143a, signInCredential.f71143a) && Objects.b(this.f71144b, signInCredential.f71144b) && Objects.b(this.f71145c, signInCredential.f71145c) && Objects.b(this.f71146d, signInCredential.f71146d) && Objects.b(this.f71147f, signInCredential.f71147f) && Objects.b(this.f71148g, signInCredential.f71148g) && Objects.b(this.f71149h, signInCredential.f71149h) && Objects.b(this.f71150i, signInCredential.f71150i) && Objects.b(this.f71151j, signInCredential.f71151j);
    }

    public String g0() {
        return this.f71149h;
    }

    public Uri h1() {
        return this.f71147f;
    }

    public int hashCode() {
        return Objects.c(this.f71143a, this.f71144b, this.f71145c, this.f71146d, this.f71147f, this.f71148g, this.f71149h, this.f71150i, this.f71151j);
    }

    public String j0() {
        return this.f71143a;
    }

    public String w0() {
        return this.f71148g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, j0(), false);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.G(parcel, 3, O(), false);
        SafeParcelWriter.G(parcel, 4, N(), false);
        SafeParcelWriter.E(parcel, 5, h1(), i3, false);
        SafeParcelWriter.G(parcel, 6, w0(), false);
        SafeParcelWriter.G(parcel, 7, g0(), false);
        SafeParcelWriter.G(parcel, 8, z0(), false);
        SafeParcelWriter.E(parcel, 9, J2(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public String z0() {
        return this.f71150i;
    }
}
