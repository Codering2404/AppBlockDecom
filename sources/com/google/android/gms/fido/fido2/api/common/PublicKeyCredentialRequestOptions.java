package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredentialRequestOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new zzar();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f72575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f72576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f72578d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f72579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TokenBinding f72580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final UserVerificationRequirement f72581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AuthenticationExtensions f72582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Long f72583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ResultReceiver f72584k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f72585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Double f72586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f72587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List f72588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f72589e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TokenBinding f72590f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private UserVerificationRequirement f72591g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private AuthenticationExtensions f72592h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Long f72593i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ResultReceiver f72594j;

        public PublicKeyCredentialRequestOptions a() {
            byte[] bArr = this.f72585a;
            Double d3 = this.f72586b;
            String str = this.f72587c;
            List list = this.f72588d;
            Integer num = this.f72589e;
            TokenBinding tokenBinding = this.f72590f;
            UserVerificationRequirement userVerificationRequirement = this.f72591g;
            return new PublicKeyCredentialRequestOptions(bArr, d3, str, list, num, tokenBinding, userVerificationRequirement == null ? null : userVerificationRequirement.toString(), this.f72592h, this.f72593i, null, this.f72594j);
        }

        public Builder b(List list) {
            this.f72588d = list;
            return this;
        }

        public Builder c(AuthenticationExtensions authenticationExtensions) {
            this.f72592h = authenticationExtensions;
            return this;
        }

        public Builder d(byte[] bArr) {
            this.f72585a = (byte[]) Preconditions.m(bArr);
            return this;
        }

        public Builder e(Integer num) {
            this.f72589e = num;
            return this;
        }

        public Builder f(String str) {
            this.f72587c = (String) Preconditions.m(str);
            return this;
        }

        public Builder g(Double d3) {
            this.f72586b = d3;
            return this;
        }

        public Builder h(TokenBinding tokenBinding) {
            this.f72590f = tokenBinding;
            return this;
        }

        public final Builder i(Long l3) {
            this.f72593i = l3;
            return this;
        }

        public final Builder j(UserVerificationRequirement userVerificationRequirement) {
            this.f72591g = userVerificationRequirement;
            return this;
        }
    }

    PublicKeyCredentialRequestOptions(byte[] bArr, Double d3, String str, List list, Integer num, TokenBinding tokenBinding, String str2, AuthenticationExtensions authenticationExtensions, Long l3, String str3, ResultReceiver resultReceiver) {
        this.f72584k = resultReceiver;
        if (str3 == null || !zzia.zzc()) {
            this.f72575a = (byte[]) Preconditions.m(bArr);
            this.f72576b = d3;
            this.f72577c = (String) Preconditions.m(str);
            this.f72578d = list;
            this.f72579f = num;
            this.f72580g = tokenBinding;
            this.f72583j = l3;
            if (str2 != null) {
                try {
                    this.f72581h = UserVerificationRequirement.a(str2);
                } catch (zzbc e3) {
                    throw new IllegalArgumentException(e3);
                }
            } else {
                this.f72581h = null;
            }
            this.f72582i = authenticationExtensions;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            Builder builder = new Builder();
            builder.d(Base64Utils.b(jSONObject.getString("challenge")));
            if (jSONObject.has("timeout")) {
                builder.g(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
            } else if (jSONObject.has("timeoutSeconds")) {
                builder.g(Double.valueOf(jSONObject.getDouble("timeoutSeconds")));
            }
            builder.f(jSONObject.getString("rpId"));
            JSONArray jSONArray = jSONObject.has("allowList") ? jSONObject.getJSONArray("allowList") : jSONObject.has("allowCredentials") ? jSONObject.getJSONArray("allowCredentials") : null;
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(PublicKeyCredentialDescriptor.g0(jSONArray.getJSONObject(i3)));
                }
                builder.b(arrayList);
            }
            if (jSONObject.has("requestId")) {
                builder.e(Integer.valueOf(jSONObject.getInt("requestId")));
            }
            if (jSONObject.has("tokenBinding")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("tokenBinding");
                builder.h(new TokenBinding(jSONObject2.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS), jSONObject2.has("id") ? jSONObject2.getString("id") : null));
            }
            if (jSONObject.has("userVerification")) {
                builder.j(UserVerificationRequirement.a(jSONObject.getString("userVerification")));
            }
            if (jSONObject.has("authenticationExtensions")) {
                builder.c(AuthenticationExtensions.O(jSONObject.getJSONObject("authenticationExtensions")));
            } else if (jSONObject.has("extensions")) {
                builder.c(AuthenticationExtensions.O(jSONObject.getJSONObject("extensions")));
            }
            if (jSONObject.has("longRequestId")) {
                builder.i(Long.valueOf(jSONObject.getLong("longRequestId")));
            }
            PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptionsA = builder.a();
            this.f72575a = publicKeyCredentialRequestOptionsA.f72575a;
            this.f72576b = publicKeyCredentialRequestOptionsA.f72576b;
            this.f72577c = publicKeyCredentialRequestOptionsA.f72577c;
            this.f72578d = publicKeyCredentialRequestOptionsA.f72578d;
            this.f72579f = publicKeyCredentialRequestOptionsA.f72579f;
            this.f72580g = publicKeyCredentialRequestOptionsA.f72580g;
            this.f72581h = publicKeyCredentialRequestOptionsA.f72581h;
            this.f72582i = publicKeyCredentialRequestOptionsA.f72582i;
            this.f72583j = publicKeyCredentialRequestOptionsA.f72583j;
        } catch (zzbc e4) {
            e = e4;
            throw new IllegalArgumentException(e);
        } catch (JSONException e5) {
            e = e5;
            throw new IllegalArgumentException(e);
        }
    }

    public List M() {
        return this.f72578d;
    }

    public AuthenticationExtensions N() {
        return this.f72582i;
    }

    public byte[] O() {
        return this.f72575a;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialRequestOptions)) {
            return false;
        }
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
        return Arrays.equals(this.f72575a, publicKeyCredentialRequestOptions.f72575a) && Objects.b(this.f72576b, publicKeyCredentialRequestOptions.f72576b) && Objects.b(this.f72577c, publicKeyCredentialRequestOptions.f72577c) && (((list = this.f72578d) == null && publicKeyCredentialRequestOptions.f72578d == null) || (list != null && (list2 = publicKeyCredentialRequestOptions.f72578d) != null && list.containsAll(list2) && publicKeyCredentialRequestOptions.f72578d.containsAll(this.f72578d))) && Objects.b(this.f72579f, publicKeyCredentialRequestOptions.f72579f) && Objects.b(this.f72580g, publicKeyCredentialRequestOptions.f72580g) && Objects.b(this.f72581h, publicKeyCredentialRequestOptions.f72581h) && Objects.b(this.f72582i, publicKeyCredentialRequestOptions.f72582i) && Objects.b(this.f72583j, publicKeyCredentialRequestOptions.f72583j);
    }

    public Integer g0() {
        return this.f72579f;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(Arrays.hashCode(this.f72575a)), this.f72576b, this.f72577c, this.f72578d, this.f72579f, this.f72580g, this.f72581h, this.f72582i, this.f72583j);
    }

    public String j0() {
        return this.f72577c;
    }

    public final String toString() {
        AuthenticationExtensions authenticationExtensions = this.f72582i;
        UserVerificationRequirement userVerificationRequirement = this.f72581h;
        TokenBinding tokenBinding = this.f72580g;
        List list = this.f72578d;
        return "PublicKeyCredentialRequestOptions{\n challenge=" + Base64Utils.e(this.f72575a) + ", \n timeoutSeconds=" + this.f72576b + ", \n rpId='" + this.f72577c + "', \n allowList=" + String.valueOf(list) + ", \n requestId=" + this.f72579f + ", \n tokenBinding=" + String.valueOf(tokenBinding) + ", \n userVerification=" + String.valueOf(userVerificationRequirement) + ", \n authenticationExtensions=" + String.valueOf(authenticationExtensions) + ", \n longRequestId=" + this.f72583j + "}";
    }

    public Double w0() {
        return this.f72576b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, O(), false);
        SafeParcelWriter.p(parcel, 3, w0(), false);
        SafeParcelWriter.G(parcel, 4, j0(), false);
        SafeParcelWriter.K(parcel, 5, M(), false);
        SafeParcelWriter.x(parcel, 6, g0(), false);
        SafeParcelWriter.E(parcel, 7, z0(), i3, false);
        UserVerificationRequirement userVerificationRequirement = this.f72581h;
        SafeParcelWriter.G(parcel, 8, userVerificationRequirement == null ? null : userVerificationRequirement.toString(), false);
        SafeParcelWriter.E(parcel, 9, N(), i3, false);
        SafeParcelWriter.B(parcel, 10, this.f72583j, false);
        SafeParcelWriter.G(parcel, 11, null, false);
        SafeParcelWriter.E(parcel, 12, this.f72584k, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public TokenBinding z0() {
        return this.f72580g;
    }
}
