package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredentialParameters extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialParameters> CREATOR = new zzaq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PublicKeyCredentialType f72573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final COSEAlgorithmIdentifier f72574b;

    public PublicKeyCredentialParameters(String str, int i3) {
        Preconditions.m(str);
        try {
            this.f72573a = PublicKeyCredentialType.a(str);
            Preconditions.m(Integer.valueOf(i3));
            try {
                this.f72574b = COSEAlgorithmIdentifier.a(i3);
            } catch (COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException e3) {
                throw new IllegalArgumentException(e3);
            }
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public int M() {
        return this.f72574b.c();
    }

    public String N() {
        return this.f72573a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialParameters)) {
            return false;
        }
        PublicKeyCredentialParameters publicKeyCredentialParameters = (PublicKeyCredentialParameters) obj;
        return this.f72573a.equals(publicKeyCredentialParameters.f72573a) && this.f72574b.equals(publicKeyCredentialParameters.f72574b);
    }

    public int hashCode() {
        return Objects.c(this.f72573a, this.f72574b);
    }

    public final String toString() {
        COSEAlgorithmIdentifier cOSEAlgorithmIdentifier = this.f72574b;
        return "PublicKeyCredentialParameters{\n type=" + String.valueOf(this.f72573a) + ", \n algorithm=" + String.valueOf(cOSEAlgorithmIdentifier) + "\n }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, N(), false);
        SafeParcelWriter.x(parcel, 3, Integer.valueOf(M()), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
