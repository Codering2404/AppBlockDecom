package com.google.android.gms.fido.fido2.api.common;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FidoCredentialDetails extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new zzy();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgx f72528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzgx f72529d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f72530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f72531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f72532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Account f72533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f72534j;

    FidoCredentialDetails(String str, String str2, byte[] bArr, byte[] bArr2, boolean z2, boolean z3, long j3, Account account, boolean z4) {
        zzgx zzgxVarZzl = bArr == null ? null : zzgx.zzl(bArr, 0, bArr.length);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr2, 0, bArr2.length);
        this.f72526a = str;
        this.f72527b = str2;
        this.f72528c = zzgxVarZzl;
        this.f72529d = zzgxVarZzl2;
        this.f72530f = z2;
        this.f72531g = z3;
        this.f72532h = j3;
        this.f72533i = account;
        this.f72534j = z4;
    }

    public byte[] M() {
        return this.f72529d.zzm();
    }

    public boolean N() {
        return this.f72530f;
    }

    public boolean O() {
        return this.f72531g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        return Objects.b(this.f72526a, fidoCredentialDetails.f72526a) && Objects.b(this.f72527b, fidoCredentialDetails.f72527b) && Objects.b(this.f72528c, fidoCredentialDetails.f72528c) && Objects.b(this.f72529d, fidoCredentialDetails.f72529d) && this.f72530f == fidoCredentialDetails.f72530f && this.f72531g == fidoCredentialDetails.f72531g && this.f72534j == fidoCredentialDetails.f72534j && this.f72532h == fidoCredentialDetails.f72532h && Objects.b(this.f72533i, fidoCredentialDetails.f72533i);
    }

    public long g0() {
        return this.f72532h;
    }

    public int hashCode() {
        return Objects.c(this.f72526a, this.f72527b, this.f72528c, this.f72529d, Boolean.valueOf(this.f72530f), Boolean.valueOf(this.f72531g), Boolean.valueOf(this.f72534j), Long.valueOf(this.f72532h), this.f72533i);
    }

    public String j0() {
        return this.f72527b;
    }

    public byte[] w0() {
        zzgx zzgxVar = this.f72528c;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, z0(), false);
        SafeParcelWriter.G(parcel, 2, j0(), false);
        SafeParcelWriter.l(parcel, 3, w0(), false);
        SafeParcelWriter.l(parcel, 4, M(), false);
        SafeParcelWriter.g(parcel, 5, N());
        SafeParcelWriter.g(parcel, 6, O());
        SafeParcelWriter.z(parcel, 7, g0());
        SafeParcelWriter.E(parcel, 8, this.f72533i, i3, false);
        SafeParcelWriter.g(parcel, 9, this.f72534j);
        SafeParcelWriter.b(parcel, iA);
    }

    public String z0() {
        return this.f72526a;
    }
}
