package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzat();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f87809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f87810b;

    TwitterAuthCredential(String str, String str2) {
        this.f87809a = Preconditions.g(str);
        this.f87810b = Preconditions.g(str2);
    }

    public static zzajb g0(TwitterAuthCredential twitterAuthCredential, String str) {
        Preconditions.m(twitterAuthCredential);
        return new zzajb(null, twitterAuthCredential.f87809a, twitterAuthCredential.M(), null, twitterAuthCredential.f87810b, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new TwitterAuthCredential(this.f87809a, this.f87810b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87809a, false);
        SafeParcelWriter.G(parcel, 2, this.f87810b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
