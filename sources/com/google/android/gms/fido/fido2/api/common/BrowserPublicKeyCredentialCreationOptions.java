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
public class BrowserPublicKeyCredentialCreationOptions extends BrowserRequestOptions {
    public static final Parcelable.Creator<BrowserPublicKeyCredentialCreationOptions> CREATOR = new zzn();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PublicKeyCredentialCreationOptions f72495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f72496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f72497c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    BrowserPublicKeyCredentialCreationOptions(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, Uri uri, byte[] bArr) {
        this.f72495a = (PublicKeyCredentialCreationOptions) Preconditions.m(publicKeyCredentialCreationOptions);
        g0(uri);
        this.f72496b = uri;
        j0(bArr);
        this.f72497c = bArr;
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
        return this.f72497c;
    }

    public Uri N() {
        return this.f72496b;
    }

    public PublicKeyCredentialCreationOptions O() {
        return this.f72495a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BrowserPublicKeyCredentialCreationOptions)) {
            return false;
        }
        BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions = (BrowserPublicKeyCredentialCreationOptions) obj;
        return Objects.b(this.f72495a, browserPublicKeyCredentialCreationOptions.f72495a) && Objects.b(this.f72496b, browserPublicKeyCredentialCreationOptions.f72496b);
    }

    public int hashCode() {
        return Objects.c(this.f72495a, this.f72496b);
    }

    public final String toString() {
        byte[] bArr = this.f72497c;
        Uri uri = this.f72496b;
        return "BrowserPublicKeyCredentialCreationOptions{\n publicKeyCredentialCreationOptions=" + String.valueOf(this.f72495a) + ", \n origin=" + String.valueOf(uri) + ", \n clientDataHash=" + Base64Utils.e(bArr) + "}";
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
