package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzao();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f87779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f87780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f87781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f87782d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f87783f;

    PhoneAuthCredential(String str, String str2, String str3, boolean z2, String str4) {
        Preconditions.b(((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.f87779a = str;
        this.f87780b = str2;
        this.f87781c = str3;
        this.f87782d = z2;
        this.f87783f = str4;
    }

    public static PhoneAuthCredential j0(String str, String str2) {
        return new PhoneAuthCredential(str, str2, null, true, null);
    }

    public static PhoneAuthCredential z0(String str, String str2) {
        return new PhoneAuthCredential(null, null, str, true, str2);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String M() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String N() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential O() {
        return (PhoneAuthCredential) clone();
    }

    public /* synthetic */ Object clone() {
        return new PhoneAuthCredential(this.f87779a, g0(), this.f87781c, this.f87782d, this.f87783f);
    }

    public String g0() {
        return this.f87780b;
    }

    public final PhoneAuthCredential w0(boolean z2) {
        this.f87782d = false;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87779a, false);
        SafeParcelWriter.G(parcel, 2, g0(), false);
        SafeParcelWriter.G(parcel, 4, this.f87781c, false);
        SafeParcelWriter.g(parcel, 5, this.f87782d);
        SafeParcelWriter.G(parcel, 6, this.f87783f, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String zzb() {
        return this.f87781c;
    }

    public final String zzc() {
        return this.f87779a;
    }

    public final String zzd() {
        return this.f87783f;
    }

    public final boolean zze() {
        return this.f87782d;
    }
}
