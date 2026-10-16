package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new zzau();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgx f72601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f72604d;

    public PublicKeyCredentialUserEntity(zzgx zzgxVar, String str, String str2, String str3) {
        this.f72601a = (zzgx) Preconditions.m(zzgxVar);
        this.f72602b = (String) Preconditions.m(str);
        this.f72603c = str2;
        this.f72604d = (String) Preconditions.m(str3);
    }

    public String M() {
        return this.f72604d;
    }

    public String N() {
        return this.f72603c;
    }

    public byte[] O() {
        return this.f72601a.zzm();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        return Objects.b(this.f72601a, publicKeyCredentialUserEntity.f72601a) && Objects.b(this.f72602b, publicKeyCredentialUserEntity.f72602b) && Objects.b(this.f72603c, publicKeyCredentialUserEntity.f72603c) && Objects.b(this.f72604d, publicKeyCredentialUserEntity.f72604d);
    }

    public String getName() {
        return this.f72602b;
    }

    public int hashCode() {
        return Objects.c(this.f72601a, this.f72602b, this.f72603c, this.f72604d);
    }

    public final String toString() {
        return "PublicKeyCredentialUserEntity{\n id=" + Base64Utils.e(this.f72601a.zzm()) + ", \n name='" + this.f72602b + "', \n icon='" + this.f72603c + "', \n displayName='" + this.f72604d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, O(), false);
        SafeParcelWriter.G(parcel, 3, getName(), false);
        SafeParcelWriter.G(parcel, 4, N(), false);
        SafeParcelWriter.G(parcel, 5, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PublicKeyCredentialUserEntity(byte[] bArr, String str, String str2, String str3) {
        byte[] bArr2 = (byte[]) Preconditions.m(bArr);
        zzgx zzgxVar = zzgx.zzb;
        this(zzgx.zzl(bArr2, 0, bArr2.length), str, str2, str3);
    }
}
