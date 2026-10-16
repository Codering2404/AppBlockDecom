package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredentialRpEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialRpEntity> CREATOR = new zzas();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72597c;

    public PublicKeyCredentialRpEntity(String str, String str2, String str3) {
        this.f72595a = (String) Preconditions.m(str);
        this.f72596b = (String) Preconditions.m(str2);
        this.f72597c = str3;
    }

    public String M() {
        return this.f72597c;
    }

    public String N() {
        return this.f72595a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialRpEntity)) {
            return false;
        }
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) obj;
        return Objects.b(this.f72595a, publicKeyCredentialRpEntity.f72595a) && Objects.b(this.f72596b, publicKeyCredentialRpEntity.f72596b) && Objects.b(this.f72597c, publicKeyCredentialRpEntity.f72597c);
    }

    public String getName() {
        return this.f72596b;
    }

    public int hashCode() {
        return Objects.c(this.f72595a, this.f72596b, this.f72597c);
    }

    public final String toString() {
        return "PublicKeyCredentialRpEntity{\n id='" + this.f72595a + "', \n name='" + this.f72596b + "', \n icon='" + this.f72597c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, N(), false);
        SafeParcelWriter.G(parcel, 3, getName(), false);
        SafeParcelWriter.G(parcel, 4, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
