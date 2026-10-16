package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.FacebookSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87740a;

    FacebookAuthCredential(String str) {
        this.f87740a = Preconditions.g(str);
    }

    public static zzajb g0(FacebookAuthCredential facebookAuthCredential, String str) {
        Preconditions.m(facebookAuthCredential);
        return new zzajb(null, facebookAuthCredential.f87740a, facebookAuthCredential.M(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return FacebookSdk.FACEBOOK_COM;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return FacebookSdk.FACEBOOK_COM;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new FacebookAuthCredential(this.f87740a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87740a, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
