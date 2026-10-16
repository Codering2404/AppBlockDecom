package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class GoogleAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzak();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87778b;

    GoogleAuthCredential(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.f87777a = str;
        this.f87778b = str2;
    }

    public static zzajb g0(GoogleAuthCredential googleAuthCredential, String str) {
        Preconditions.m(googleAuthCredential);
        return new zzajb(googleAuthCredential.f87777a, googleAuthCredential.f87778b, googleAuthCredential.M(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new GoogleAuthCredential(this.f87777a, this.f87778b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87777a, false);
        SafeParcelWriter.G(parcel, 2, this.f87778b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
