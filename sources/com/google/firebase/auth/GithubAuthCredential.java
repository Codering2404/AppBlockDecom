package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzaj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f87776a;

    GithubAuthCredential(String str) {
        this.f87776a = Preconditions.g(str);
    }

    public static zzajb g0(GithubAuthCredential githubAuthCredential, String str) {
        Preconditions.m(githubAuthCredential);
        return new zzajb(null, githubAuthCredential.f87776a, githubAuthCredential.M(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new GithubAuthCredential(this.f87776a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87776a, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
