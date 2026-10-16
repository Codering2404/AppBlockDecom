package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f87735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f87736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f87737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f87738d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f87739f;

    EmailAuthCredential(String str, String str2, String str3, String str4, boolean z2) {
        this.f87735a = Preconditions.g(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f87736b = str2;
        this.f87737c = str3;
        this.f87738d = str4;
        this.f87739f = z2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return !TextUtils.isEmpty(this.f87736b) ? "password" : "emailLink";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return new EmailAuthCredential(this.f87735a, this.f87736b, this.f87737c, this.f87738d, this.f87739f);
    }

    public final EmailAuthCredential g0(FirebaseUser firebaseUser) {
        this.f87738d = firebaseUser.zze();
        this.f87739f = true;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87735a, false);
        SafeParcelWriter.G(parcel, 2, this.f87736b, false);
        SafeParcelWriter.G(parcel, 3, this.f87737c, false);
        SafeParcelWriter.G(parcel, 4, this.f87738d, false);
        SafeParcelWriter.g(parcel, 5, this.f87739f);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String zzb() {
        return this.f87738d;
    }

    public final String zzc() {
        return this.f87735a;
    }

    public final String zzd() {
        return this.f87736b;
    }

    public final String zze() {
        return this.f87737c;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.f87737c);
    }

    public final boolean zzg() {
        return this.f87739f;
    }
}
