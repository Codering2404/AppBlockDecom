package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzajb f88040d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f88041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f88042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f88043h;

    zze(String str, String str2, String str3, zzajb zzajbVar, String str4, String str5, String str6) {
        this.f88037a = com.google.android.gms.internal.p002firebaseauthapi.zzac.zzb(str);
        this.f88038b = str2;
        this.f88039c = str3;
        this.f88040d = zzajbVar;
        this.f88041f = str4;
        this.f88042g = str5;
        this.f88043h = str6;
    }

    public static zze J2(String str, String str2, String str3, String str4, String str5) {
        Preconditions.h(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zze(str, str2, str3, null, str4, str5, null);
    }

    public static zze h1(zzajb zzajbVar) {
        Preconditions.n(zzajbVar, "Must specify a non-null webSignInCredential");
        return new zze(null, null, null, zzajbVar, null, null, null);
    }

    public static zzajb z0(zze zzeVar, String str) {
        Preconditions.m(zzeVar);
        zzajb zzajbVar = zzeVar.f88040d;
        return zzajbVar != null ? zzajbVar : new zzajb(zzeVar.j0(), zzeVar.g0(), zzeVar.M(), null, zzeVar.w0(), null, str, zzeVar.f88041f, zzeVar.f88043h);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String M() {
        return this.f88037a;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String N() {
        return this.f88037a;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new zze(this.f88037a, this.f88038b, this.f88039c, this.f88040d, this.f88041f, this.f88042g, this.f88043h);
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String g0() {
        return this.f88039c;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String j0() {
        return this.f88038b;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String w0() {
        return this.f88042g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, M(), false);
        SafeParcelWriter.G(parcel, 2, j0(), false);
        SafeParcelWriter.G(parcel, 3, g0(), false);
        SafeParcelWriter.E(parcel, 4, this.f88040d, i3, false);
        SafeParcelWriter.G(parcel, 5, this.f88041f, false);
        SafeParcelWriter.G(parcel, 6, w0(), false);
        SafeParcelWriter.G(parcel, 7, this.f88043h, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
