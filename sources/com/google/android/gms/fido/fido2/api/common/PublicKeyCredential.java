package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzia;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new zzao();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgx f72538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AuthenticatorAttestationResponse f72539d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AuthenticatorAssertionResponse f72540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AuthenticatorErrorResponse f72541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AuthenticationExtensionsClientOutputs f72542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f72543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f72544j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    private PublicKeyCredential(String str, String str2, zzgx zzgxVar, AuthenticatorAttestationResponse authenticatorAttestationResponse, AuthenticatorAssertionResponse authenticatorAssertionResponse, AuthenticatorErrorResponse authenticatorErrorResponse, AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, String str3, String str4) {
        boolean z2 = false;
        Preconditions.b((authenticatorAttestationResponse != null && authenticatorAssertionResponse == null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse != null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse == null && authenticatorErrorResponse != null), "Must provide a response object.");
        if (authenticatorErrorResponse != null || (str != null && zzgxVar != null)) {
            z2 = true;
        }
        Preconditions.b(z2, "Must provide id and rawId if not an error response.");
        this.f72536a = str;
        this.f72537b = str2;
        this.f72538c = zzgxVar;
        this.f72539d = authenticatorAttestationResponse;
        this.f72540f = authenticatorAssertionResponse;
        this.f72541g = authenticatorErrorResponse;
        this.f72542h = authenticationExtensionsClientOutputs;
        this.f72543i = str3;
        this.f72544j = null;
    }

    public static PublicKeyCredential M(byte[] bArr) {
        return (PublicKeyCredential) SafeParcelableSerializer.a(bArr, CREATOR);
    }

    public final JSONObject J2() {
        JSONObject jSONObjectG0;
        try {
            JSONObject jSONObject = new JSONObject();
            zzgx zzgxVar = this.f72538c;
            if (zzgxVar != null && zzgxVar.zzm().length > 0) {
                jSONObject.put("rawId", Base64Utils.e(this.f72538c.zzm()));
            }
            String str = this.f72543i;
            if (str != null) {
                jSONObject.put("authenticatorAttachment", str);
            }
            String str2 = this.f72537b;
            if (str2 != null && this.f72541g == null) {
                jSONObject.put("type", str2);
            }
            String str3 = this.f72536a;
            if (str3 != null) {
                jSONObject.put("id", str3);
            }
            String str4 = "response";
            AuthenticatorAssertionResponse authenticatorAssertionResponse = this.f72540f;
            boolean z2 = true;
            if (authenticatorAssertionResponse != null) {
                jSONObjectG0 = authenticatorAssertionResponse.w0();
            } else {
                AuthenticatorAttestationResponse authenticatorAttestationResponse = this.f72539d;
                if (authenticatorAttestationResponse != null) {
                    jSONObjectG0 = authenticatorAttestationResponse.j0();
                } else {
                    AuthenticatorErrorResponse authenticatorErrorResponse = this.f72541g;
                    z2 = false;
                    if (authenticatorErrorResponse != null) {
                        jSONObjectG0 = authenticatorErrorResponse.g0();
                        str4 = "error";
                    } else {
                        jSONObjectG0 = null;
                    }
                }
            }
            if (jSONObjectG0 != null) {
                jSONObject.put(str4, jSONObjectG0);
            }
            AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = this.f72542h;
            if (authenticationExtensionsClientOutputs != null) {
                jSONObject.put("clientExtensionResults", authenticationExtensionsClientOutputs.O());
                return jSONObject;
            }
            if (z2) {
                jSONObject.put("clientExtensionResults", new JSONObject());
            }
            return jSONObject;
        } catch (JSONException e3) {
            throw new RuntimeException("Error encoding PublicKeyCredential to JSON object", e3);
        }
    }

    public String N() {
        return this.f72543i;
    }

    public AuthenticationExtensionsClientOutputs O() {
        return this.f72542h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredential)) {
            return false;
        }
        PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
        return Objects.b(this.f72536a, publicKeyCredential.f72536a) && Objects.b(this.f72537b, publicKeyCredential.f72537b) && Objects.b(this.f72538c, publicKeyCredential.f72538c) && Objects.b(this.f72539d, publicKeyCredential.f72539d) && Objects.b(this.f72540f, publicKeyCredential.f72540f) && Objects.b(this.f72541g, publicKeyCredential.f72541g) && Objects.b(this.f72542h, publicKeyCredential.f72542h) && Objects.b(this.f72543i, publicKeyCredential.f72543i);
    }

    public String g0() {
        return this.f72536a;
    }

    public String h1() {
        return J2().toString();
    }

    public int hashCode() {
        return Objects.c(this.f72536a, this.f72537b, this.f72538c, this.f72540f, this.f72539d, this.f72541g, this.f72542h, this.f72543i);
    }

    public byte[] j0() {
        zzgx zzgxVar = this.f72538c;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final String toString() {
        zzgx zzgxVar = this.f72538c;
        byte[] bArrZzm = zzgxVar == null ? null : zzgxVar.zzm();
        String str = this.f72537b;
        String str2 = this.f72536a;
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.f72539d;
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.f72540f;
        AuthenticatorErrorResponse authenticatorErrorResponse = this.f72541g;
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = this.f72542h;
        String str3 = this.f72543i;
        return "PublicKeyCredential{\n id='" + str2 + "', \n type='" + str + "', \n rawId=" + Base64Utils.e(bArrZzm) + ", \n registerResponse=" + String.valueOf(authenticatorAttestationResponse) + ", \n signResponse=" + String.valueOf(authenticatorAssertionResponse) + ", \n errorResponse=" + String.valueOf(authenticatorErrorResponse) + ", \n extensionsClientOutputs=" + String.valueOf(authenticationExtensionsClientOutputs) + ", \n authenticatorAttachment='" + str3 + "'}";
    }

    public AuthenticatorResponse w0() {
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.f72539d;
        if (authenticatorAttestationResponse != null) {
            return authenticatorAttestationResponse;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.f72540f;
        if (authenticatorAssertionResponse != null) {
            return authenticatorAssertionResponse;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = this.f72541g;
        if (authenticatorErrorResponse != null) {
            return authenticatorErrorResponse;
        }
        throw new IllegalStateException("No response set.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (zzia.zzc()) {
            this.f72544j = J2().toString();
        }
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, g0(), false);
        SafeParcelWriter.G(parcel, 2, z0(), false);
        SafeParcelWriter.l(parcel, 3, j0(), false);
        SafeParcelWriter.E(parcel, 4, this.f72539d, i3, false);
        SafeParcelWriter.E(parcel, 5, this.f72540f, i3, false);
        SafeParcelWriter.E(parcel, 6, this.f72541g, i3, false);
        SafeParcelWriter.E(parcel, 7, O(), i3, false);
        SafeParcelWriter.G(parcel, 8, N(), false);
        SafeParcelWriter.G(parcel, 9, this.f72544j, false);
        SafeParcelWriter.b(parcel, iA);
        this.f72544j = null;
    }

    public String z0() {
        return this.f72537b;
    }

    PublicKeyCredential(String str, String str2, byte[] bArr, AuthenticatorAttestationResponse authenticatorAttestationResponse, AuthenticatorAssertionResponse authenticatorAssertionResponse, AuthenticatorErrorResponse authenticatorErrorResponse, AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, String str3, String str4) {
        this(str, str2, bArr == null ? null : zzgx.zzl(bArr, 0, bArr.length), authenticatorAttestationResponse, authenticatorAssertionResponse, authenticatorErrorResponse, authenticationExtensionsClientOutputs, str3, str4);
    }
}
