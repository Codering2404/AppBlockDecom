package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BrowserPublicKeyCredentialRequestOptions extends BrowserRequestOptions {
    public static final Parcelable.Creator<BrowserPublicKeyCredentialRequestOptions> CREATOR = new zzo();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PublicKeyCredentialRequestOptions f72498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f72499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f72500c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    BrowserPublicKeyCredentialRequestOptions(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, Uri uri, byte[] bArr) {
        this.f72498a = (PublicKeyCredentialRequestOptions) Preconditions.m(publicKeyCredentialRequestOptions);
        g0(uri);
        this.f72499b = uri;
        j0(bArr);
        this.f72500c = bArr;
    }

    private static Uri g0(Uri uri) {
        Preconditions.m(uri);
        Preconditions.b(uri.getScheme() != null, "origin scheme must be non-empty");
        Preconditions.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    private static byte[] j0(byte[] bArr) {
        boolean z2 = true;
        if (bArr != null && bArr.length != 32) {
            z2 = false;
        }
        Preconditions.b(z2, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public byte[] M() {
        return this.f72500c;
    }

    public Uri N() {
        return this.f72499b;
    }

    public PublicKeyCredentialRequestOptions O() {
        return this.f72498a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BrowserPublicKeyCredentialRequestOptions)) {
            return false;
        }
        BrowserPublicKeyCredentialRequestOptions browserPublicKeyCredentialRequestOptions = (BrowserPublicKeyCredentialRequestOptions) obj;
        return Objects.b(this.f72498a, browserPublicKeyCredentialRequestOptions.f72498a) && Objects.b(this.f72499b, browserPublicKeyCredentialRequestOptions.f72499b);
    }

    public int hashCode() {
        return Objects.c(this.f72498a, this.f72499b);
    }

    public final String toString() {
        byte[] bArr = this.f72500c;
        Uri uri = this.f72499b;
        return "BrowserPublicKeyCredentialRequestOptions{\n publicKeyCredentialRequestOptions=" + String.valueOf(this.f72498a) + ", \n origin=" + String.valueOf(uri) + ", \n clientDataHash=" + Base64Utils.e(bArr) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, O(), i3, false);
        SafeParcelWriter.E(parcel, 3, N(), i3, false);
        SafeParcelWriter.l(parcel, 4, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
