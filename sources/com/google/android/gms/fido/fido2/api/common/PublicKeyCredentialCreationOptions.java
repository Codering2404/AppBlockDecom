package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.internal.fido.zzbl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredentialCreationOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzan();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PublicKeyCredentialRpEntity f72545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PublicKeyCredentialUserEntity f72546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f72547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f72548d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Double f72549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f72550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AuthenticatorSelectionCriteria f72551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Integer f72552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TokenBinding f72553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AttestationConveyancePreference f72554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AuthenticationExtensions f72555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f72556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ResultReceiver f72557n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PublicKeyCredentialRpEntity f72558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PublicKeyCredentialUserEntity f72559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f72560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List f72561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Double f72562e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f72563f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private AuthenticatorSelectionCriteria f72564g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Integer f72565h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private TokenBinding f72566i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private AttestationConveyancePreference f72567j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private AuthenticationExtensions f72568k;

        public PublicKeyCredentialCreationOptions a() {
            PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = this.f72558a;
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.f72559b;
            byte[] bArr = this.f72560c;
            List list = this.f72561d;
            Double d3 = this.f72562e;
            List list2 = this.f72563f;
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.f72564g;
            Integer num = this.f72565h;
            TokenBinding tokenBinding = this.f72566i;
            AttestationConveyancePreference attestationConveyancePreference = this.f72567j;
            return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArr, list, d3, list2, authenticatorSelectionCriteria, num, tokenBinding, attestationConveyancePreference == null ? null : attestationConveyancePreference.toString(), this.f72568k, null, null);
        }

        public Builder b(AttestationConveyancePreference attestationConveyancePreference) {
            this.f72567j = attestationConveyancePreference;
            return this;
        }

        public Builder c(AuthenticationExtensions authenticationExtensions) {
            this.f72568k = authenticationExtensions;
            return this;
        }

        public Builder d(AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
            this.f72564g = authenticatorSelectionCriteria;
            return this;
        }

        public Builder e(byte[] bArr) {
            this.f72560c = (byte[]) Preconditions.m(bArr);
            return this;
        }

        public Builder f(List list) {
            this.f72563f = list;
            return this;
        }

        public Builder g(List list) {
            this.f72561d = (List) Preconditions.m(list);
            return this;
        }

        public Builder h(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity) {
            this.f72558a = (PublicKeyCredentialRpEntity) Preconditions.m(publicKeyCredentialRpEntity);
            return this;
        }

        public Builder i(Double d3) {
            this.f72562e = d3;
            return this;
        }

        public Builder j(PublicKeyCredentialUserEntity publicKeyCredentialUserEntity) {
            this.f72559b = (PublicKeyCredentialUserEntity) Preconditions.m(publicKeyCredentialUserEntity);
            return this;
        }
    }

    PublicKeyCredentialCreationOptions(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, byte[] bArr, List list, Double d3, List list2, AuthenticatorSelectionCriteria authenticatorSelectionCriteria, Integer num, TokenBinding tokenBinding, String str, AuthenticationExtensions authenticationExtensions, String str2, ResultReceiver resultReceiver) {
        this.f72557n = resultReceiver;
        if (str2 != null) {
            try {
                PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptionsN2 = N2(new JSONObject(str2));
                this.f72545a = publicKeyCredentialCreationOptionsN2.f72545a;
                this.f72546b = publicKeyCredentialCreationOptionsN2.f72546b;
                this.f72547c = publicKeyCredentialCreationOptionsN2.f72547c;
                this.f72548d = publicKeyCredentialCreationOptionsN2.f72548d;
                this.f72549f = publicKeyCredentialCreationOptionsN2.f72549f;
                this.f72550g = publicKeyCredentialCreationOptionsN2.f72550g;
                this.f72551h = publicKeyCredentialCreationOptionsN2.f72551h;
                this.f72552i = publicKeyCredentialCreationOptionsN2.f72552i;
                this.f72553j = publicKeyCredentialCreationOptionsN2.f72553j;
                this.f72554k = publicKeyCredentialCreationOptionsN2.f72554k;
                this.f72555l = publicKeyCredentialCreationOptionsN2.f72555l;
                this.f72556m = str2;
                return;
            } catch (JSONException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        this.f72545a = (PublicKeyCredentialRpEntity) Preconditions.m(publicKeyCredentialRpEntity);
        this.f72546b = (PublicKeyCredentialUserEntity) Preconditions.m(publicKeyCredentialUserEntity);
        this.f72547c = (byte[]) Preconditions.m(bArr);
        this.f72548d = (List) Preconditions.m(list);
        this.f72549f = d3;
        this.f72550g = list2;
        this.f72551h = authenticatorSelectionCriteria;
        this.f72552i = num;
        this.f72553j = tokenBinding;
        if (str != null) {
            try {
                this.f72554k = AttestationConveyancePreference.a(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e4) {
                throw new IllegalArgumentException(e4);
            }
        } else {
            this.f72554k = null;
        }
        this.f72555l = authenticationExtensions;
        this.f72556m = null;
    }

    public static PublicKeyCredentialCreationOptions N2(JSONObject jSONObject) throws JSONException {
        zzbl zzblVarZzc;
        Builder builder = new Builder();
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        Parcelable.Creator<PublicKeyCredentialRpEntity> creator = PublicKeyCredentialRpEntity.CREATOR;
        builder.h(new PublicKeyCredentialRpEntity(jSONObject2.getString("id"), jSONObject2.getString("name"), jSONObject2.has("icon") ? jSONObject2.optString("icon") : null));
        JSONObject jSONObject3 = jSONObject.getJSONObject("user");
        Parcelable.Creator<PublicKeyCredentialUserEntity> creator2 = PublicKeyCredentialUserEntity.CREATOR;
        builder.j(new PublicKeyCredentialUserEntity(Base64Utils.b(jSONObject3.getString("id")), jSONObject3.getString("name"), jSONObject3.has("icon") ? jSONObject3.optString("icon") : null, jSONObject3.optString("displayName")));
        builder.e(Base64Utils.b(jSONObject.getString("challenge")));
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
            try {
                zzblVarZzc = zzbl.zzd(new PublicKeyCredentialParameters(jSONObject4.getString("type"), jSONObject4.getInt("alg")));
            } catch (IllegalArgumentException unused) {
                zzblVarZzc = zzbl.zzc();
            }
            if (zzblVarZzc.zzb()) {
                arrayList.add(zzblVarZzc.zza());
            }
        }
        builder.g(arrayList);
        if (jSONObject.has("timeout")) {
            builder.i(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
        }
        if (jSONObject.has("excludeCredentials")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("excludeCredentials");
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                arrayList2.add(PublicKeyCredentialDescriptor.g0(jSONArray2.getJSONObject(i4)));
            }
            builder.f(arrayList2);
        }
        if (jSONObject.has("authenticatorSelection")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("authenticatorSelection");
            Parcelable.Creator<AuthenticatorSelectionCriteria> creator3 = AuthenticatorSelectionCriteria.CREATOR;
            builder.d(new AuthenticatorSelectionCriteria(jSONObject5.has("authenticatorAttachment") ? jSONObject5.optString("authenticatorAttachment") : null, jSONObject5.has("requireResidentKey") ? Boolean.valueOf(jSONObject5.optBoolean("requireResidentKey")) : null, jSONObject5.has("userVerification") ? jSONObject5.optString("userVerification") : null, jSONObject5.has("residentKey") ? jSONObject5.optString("residentKey") : null));
        }
        if (jSONObject.has("extensions")) {
            builder.c(AuthenticationExtensions.O(jSONObject.getJSONObject("extensions")));
        }
        if (jSONObject.has("attestation")) {
            try {
                builder.b(AttestationConveyancePreference.a(jSONObject.getString("attestation")));
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e3) {
                Log.w("PKCCreationOptions", "Invalid AttestationConveyancePreference", e3);
                builder.b(AttestationConveyancePreference.NONE);
            }
        }
        return builder.a();
    }

    public PublicKeyCredentialRpEntity J2() {
        return this.f72545a;
    }

    public Double K2() {
        return this.f72549f;
    }

    public TokenBinding L2() {
        return this.f72553j;
    }

    public String M() {
        AttestationConveyancePreference attestationConveyancePreference = this.f72554k;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    public PublicKeyCredentialUserEntity M2() {
        return this.f72546b;
    }

    public AuthenticationExtensions N() {
        return this.f72555l;
    }

    public AuthenticatorSelectionCriteria O() {
        return this.f72551h;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        return Objects.b(this.f72545a, publicKeyCredentialCreationOptions.f72545a) && Objects.b(this.f72546b, publicKeyCredentialCreationOptions.f72546b) && Arrays.equals(this.f72547c, publicKeyCredentialCreationOptions.f72547c) && Objects.b(this.f72549f, publicKeyCredentialCreationOptions.f72549f) && this.f72548d.containsAll(publicKeyCredentialCreationOptions.f72548d) && publicKeyCredentialCreationOptions.f72548d.containsAll(this.f72548d) && (((list = this.f72550g) == null && publicKeyCredentialCreationOptions.f72550g == null) || (list != null && (list2 = publicKeyCredentialCreationOptions.f72550g) != null && list.containsAll(list2) && publicKeyCredentialCreationOptions.f72550g.containsAll(this.f72550g))) && Objects.b(this.f72551h, publicKeyCredentialCreationOptions.f72551h) && Objects.b(this.f72552i, publicKeyCredentialCreationOptions.f72552i) && Objects.b(this.f72553j, publicKeyCredentialCreationOptions.f72553j) && Objects.b(this.f72554k, publicKeyCredentialCreationOptions.f72554k) && Objects.b(this.f72555l, publicKeyCredentialCreationOptions.f72555l) && Objects.b(this.f72556m, publicKeyCredentialCreationOptions.f72556m);
    }

    public byte[] g0() {
        return this.f72547c;
    }

    public Integer h1() {
        return this.f72552i;
    }

    public int hashCode() {
        return Objects.c(this.f72545a, this.f72546b, Integer.valueOf(Arrays.hashCode(this.f72547c)), this.f72548d, this.f72549f, this.f72550g, this.f72551h, this.f72552i, this.f72553j, this.f72554k, this.f72555l, this.f72556m);
    }

    public List j0() {
        return this.f72550g;
    }

    public final String toString() {
        AuthenticationExtensions authenticationExtensions = this.f72555l;
        AttestationConveyancePreference attestationConveyancePreference = this.f72554k;
        TokenBinding tokenBinding = this.f72553j;
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.f72551h;
        List list = this.f72550g;
        List list2 = this.f72548d;
        byte[] bArr = this.f72547c;
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.f72546b;
        return "PublicKeyCredentialCreationOptions{\n rp=" + String.valueOf(this.f72545a) + ", \n user=" + String.valueOf(publicKeyCredentialUserEntity) + ", \n challenge=" + Base64Utils.e(bArr) + ", \n parameters=" + String.valueOf(list2) + ", \n timeoutSeconds=" + this.f72549f + ", \n excludeList=" + String.valueOf(list) + ", \n authenticatorSelection=" + String.valueOf(authenticatorSelectionCriteria) + ", \n requestId=" + this.f72552i + ", \n tokenBinding=" + String.valueOf(tokenBinding) + ", \n attestationConveyancePreference=" + String.valueOf(attestationConveyancePreference) + ", \n authenticationExtensions=" + String.valueOf(authenticationExtensions) + "}";
    }

    public String w0() {
        return this.f72556m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, J2(), i3, false);
        SafeParcelWriter.E(parcel, 3, M2(), i3, false);
        SafeParcelWriter.l(parcel, 4, g0(), false);
        SafeParcelWriter.K(parcel, 5, z0(), false);
        SafeParcelWriter.p(parcel, 6, K2(), false);
        SafeParcelWriter.K(parcel, 7, j0(), false);
        SafeParcelWriter.E(parcel, 8, O(), i3, false);
        SafeParcelWriter.x(parcel, 9, h1(), false);
        SafeParcelWriter.E(parcel, 10, L2(), i3, false);
        SafeParcelWriter.G(parcel, 11, M(), false);
        SafeParcelWriter.E(parcel, 12, N(), i3, false);
        SafeParcelWriter.G(parcel, 13, w0(), false);
        SafeParcelWriter.E(parcel, 14, this.f72557n, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public List z0() {
        return this.f72548d;
    }

    public PublicKeyCredentialCreationOptions(String str) {
        try {
            PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptionsN2 = N2(new JSONObject(str));
            this.f72545a = publicKeyCredentialCreationOptionsN2.f72545a;
            this.f72546b = publicKeyCredentialCreationOptionsN2.f72546b;
            this.f72547c = publicKeyCredentialCreationOptionsN2.f72547c;
            this.f72548d = publicKeyCredentialCreationOptionsN2.f72548d;
            this.f72549f = publicKeyCredentialCreationOptionsN2.f72549f;
            this.f72550g = publicKeyCredentialCreationOptionsN2.f72550g;
            this.f72551h = publicKeyCredentialCreationOptionsN2.f72551h;
            this.f72552i = publicKeyCredentialCreationOptionsN2.f72552i;
            this.f72553j = publicKeyCredentialCreationOptionsN2.f72553j;
            this.f72554k = publicKeyCredentialCreationOptionsN2.f72554k;
            this.f72555l = publicKeyCredentialCreationOptionsN2.f72555l;
            this.f72556m = str;
        } catch (JSONException e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
