package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzar();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87801a;

    PlayGamesAuthCredential(String str) {
        this.f87801a = Preconditions.g(str);
    }

    public static zzajb g0(PlayGamesAuthCredential playGamesAuthCredential, String str) {
        Preconditions.m(playGamesAuthCredential);
        return new zzajb(null, null, playGamesAuthCredential.M(), null, null, playGamesAuthCredential.f87801a, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new PlayGamesAuthCredential(this.f87801a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87801a, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
