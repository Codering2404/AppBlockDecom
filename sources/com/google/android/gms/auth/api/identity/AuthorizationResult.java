package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AuthorizationResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthorizationResult> CREATOR = new zbf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f71064d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GoogleSignInAccount f71065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PendingIntent f71066g;

    public AuthorizationResult(String str, String str2, String str3, List list, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f71061a = str;
        this.f71062b = str2;
        this.f71063c = str3;
        this.f71064d = (List) Preconditions.m(list);
        this.f71066g = pendingIntent;
        this.f71065f = googleSignInAccount;
    }

    public String M() {
        return this.f71062b;
    }

    public List N() {
        return this.f71064d;
    }

    public PendingIntent O() {
        return this.f71066g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationResult)) {
            return false;
        }
        AuthorizationResult authorizationResult = (AuthorizationResult) obj;
        return Objects.b(this.f71061a, authorizationResult.f71061a) && Objects.b(this.f71062b, authorizationResult.f71062b) && Objects.b(this.f71063c, authorizationResult.f71063c) && Objects.b(this.f71064d, authorizationResult.f71064d) && Objects.b(this.f71066g, authorizationResult.f71066g) && Objects.b(this.f71065f, authorizationResult.f71065f);
    }

    public String g0() {
        return this.f71061a;
    }

    public int hashCode() {
        return Objects.c(this.f71061a, this.f71062b, this.f71063c, this.f71064d, this.f71066g, this.f71065f);
    }

    public GoogleSignInAccount j0() {
        return this.f71065f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, g0(), false);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.G(parcel, 3, this.f71063c, false);
        SafeParcelWriter.I(parcel, 4, N(), false);
        SafeParcelWriter.E(parcel, 5, j0(), i3, false);
        SafeParcelWriter.E(parcel, 6, O(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
