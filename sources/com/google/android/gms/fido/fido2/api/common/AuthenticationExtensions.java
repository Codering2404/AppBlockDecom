package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticationExtensions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticationExtensions> CREATOR = new zzd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FidoAppIdExtension f72446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzs f72447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UserVerificationMethodExtension f72448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzz f72449d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzab f72450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzad f72451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzu f72452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzag f72453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final GoogleThirdPartyPaymentExtension f72454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzak f72455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzaw f72456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzai f72457m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FidoAppIdExtension f72458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UserVerificationMethodExtension f72459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private zzs f72460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private zzz f72461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private zzab f72462e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private zzad f72463f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private zzu f72464g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private zzag f72465h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private GoogleThirdPartyPaymentExtension f72466i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private zzak f72467j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private zzaw f72468k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private zzai f72469l;

        public AuthenticationExtensions a() {
            return new AuthenticationExtensions(this.f72458a, this.f72460c, this.f72459b, this.f72461d, this.f72462e, this.f72463f, this.f72464g, this.f72465h, this.f72466i, this.f72467j, this.f72468k, this.f72469l);
        }

        public Builder b(FidoAppIdExtension fidoAppIdExtension) {
            this.f72458a = fidoAppIdExtension;
            return this;
        }

        public Builder c(GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension) {
            this.f72466i = googleThirdPartyPaymentExtension;
            return this;
        }

        public Builder d(UserVerificationMethodExtension userVerificationMethodExtension) {
            this.f72459b = userVerificationMethodExtension;
            return this;
        }

        public final Builder e(zzs zzsVar) {
            this.f72460c = zzsVar;
            return this;
        }

        public final Builder f(zzu zzuVar) {
            this.f72464g = zzuVar;
            return this;
        }

        public final Builder g(zzz zzzVar) {
            this.f72461d = zzzVar;
            return this;
        }

        public final Builder h(zzab zzabVar) {
            this.f72462e = zzabVar;
            return this;
        }

        public final Builder i(zzad zzadVar) {
            this.f72463f = zzadVar;
            return this;
        }

        public final Builder j(zzag zzagVar) {
            this.f72465h = zzagVar;
            return this;
        }

        public final Builder k(zzak zzakVar) {
            this.f72467j = zzakVar;
            return this;
        }

        public final Builder l(zzaw zzawVar) {
            this.f72468k = zzawVar;
            return this;
        }
    }

    AuthenticationExtensions(FidoAppIdExtension fidoAppIdExtension, zzs zzsVar, UserVerificationMethodExtension userVerificationMethodExtension, zzz zzzVar, zzab zzabVar, zzad zzadVar, zzu zzuVar, zzag zzagVar, GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension, zzak zzakVar, zzaw zzawVar, zzai zzaiVar) {
        this.f72446a = fidoAppIdExtension;
        this.f72448c = userVerificationMethodExtension;
        this.f72447b = zzsVar;
        this.f72449d = zzzVar;
        this.f72450f = zzabVar;
        this.f72451g = zzadVar;
        this.f72452h = zzuVar;
        this.f72453i = zzagVar;
        this.f72454j = googleThirdPartyPaymentExtension;
        this.f72455k = zzakVar;
        this.f72456l = zzawVar;
        this.f72457m = zzaiVar;
    }

    public static AuthenticationExtensions O(JSONObject jSONObject) throws JSONException {
        Builder builder = new Builder();
        if (jSONObject.has("fidoAppIdExtension")) {
            builder.b(new FidoAppIdExtension(jSONObject.getJSONObject("fidoAppIdExtension").getString(AppsFlyerProperties.APP_ID)));
        }
        if (jSONObject.has(AppsFlyerProperties.APP_ID)) {
            builder.b(new FidoAppIdExtension(jSONObject.getString(AppsFlyerProperties.APP_ID)));
        }
        if (jSONObject.has("prf")) {
            if (jSONObject.has("prfAlreadyHashed")) {
                throw new JSONException("both prf and prfAlreadyHashed extensions found");
            }
            builder.k(zzak.M(jSONObject.getJSONObject("prf"), false));
        } else if (jSONObject.has("prfAlreadyHashed")) {
            builder.k(zzak.M(jSONObject.getJSONObject("prfAlreadyHashed"), true));
        }
        if (jSONObject.has("cableAuthenticationExtension")) {
            JSONArray jSONArray = jSONObject.getJSONArray("cableAuthenticationExtension");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                arrayList.add(new zzq(jSONObject2.getLong("version"), Base64.decode(jSONObject2.getString("clientEid"), 11), Base64.decode(jSONObject2.getString("authenticatorEid"), 11), Base64.decode(jSONObject2.getString("sessionPreKey"), 11)));
            }
            builder.e(new zzs(arrayList));
        }
        if (jSONObject.has("userVerificationMethodExtension")) {
            builder.d(new UserVerificationMethodExtension(jSONObject.getJSONObject("userVerificationMethodExtension").getBoolean("uvm")));
        }
        if (jSONObject.has("google_multiAssertionExtension")) {
            builder.g(new zzz(jSONObject.getJSONObject("google_multiAssertionExtension").getBoolean("requestForMultiAssertion")));
        }
        if (jSONObject.has("google_sessionIdExtension")) {
            builder.h(new zzab(jSONObject.getJSONObject("google_sessionIdExtension").getInt("sessionId")));
        }
        if (jSONObject.has("google_silentVerificationExtension")) {
            builder.i(new zzad(jSONObject.getJSONObject("google_silentVerificationExtension").getBoolean("silentVerification")));
        }
        if (jSONObject.has("devicePublicKeyExtension")) {
            builder.f(new zzu(jSONObject.getJSONObject("devicePublicKeyExtension").getBoolean("devicePublicKey")));
        }
        if (jSONObject.has("google_tunnelServerIdExtension")) {
            builder.j(new zzag(jSONObject.getJSONObject("google_tunnelServerIdExtension").getString("tunnelServerId")));
        }
        if (jSONObject.has("google_thirdPartyPaymentExtension")) {
            builder.c(new GoogleThirdPartyPaymentExtension(jSONObject.getJSONObject("google_thirdPartyPaymentExtension").getBoolean("thirdPartyPayment")));
        }
        if (jSONObject.has("txAuthSimple")) {
            builder.l(new zzaw(jSONObject.getString("txAuthSimple")));
        }
        return builder.a();
    }

    public FidoAppIdExtension M() {
        return this.f72446a;
    }

    public UserVerificationMethodExtension N() {
        return this.f72448c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensions)) {
            return false;
        }
        AuthenticationExtensions authenticationExtensions = (AuthenticationExtensions) obj;
        return Objects.b(this.f72446a, authenticationExtensions.f72446a) && Objects.b(this.f72447b, authenticationExtensions.f72447b) && Objects.b(this.f72448c, authenticationExtensions.f72448c) && Objects.b(this.f72449d, authenticationExtensions.f72449d) && Objects.b(this.f72450f, authenticationExtensions.f72450f) && Objects.b(this.f72451g, authenticationExtensions.f72451g) && Objects.b(this.f72452h, authenticationExtensions.f72452h) && Objects.b(this.f72453i, authenticationExtensions.f72453i) && Objects.b(this.f72454j, authenticationExtensions.f72454j) && Objects.b(this.f72455k, authenticationExtensions.f72455k) && Objects.b(this.f72456l, authenticationExtensions.f72456l) && Objects.b(this.f72457m, authenticationExtensions.f72457m);
    }

    public int hashCode() {
        return Objects.c(this.f72446a, this.f72447b, this.f72448c, this.f72449d, this.f72450f, this.f72451g, this.f72452h, this.f72453i, this.f72454j, this.f72455k, this.f72456l, this.f72457m);
    }

    public final String toString() {
        zzaw zzawVar = this.f72456l;
        zzak zzakVar = this.f72455k;
        GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension = this.f72454j;
        zzag zzagVar = this.f72453i;
        zzu zzuVar = this.f72452h;
        zzad zzadVar = this.f72451g;
        zzab zzabVar = this.f72450f;
        zzz zzzVar = this.f72449d;
        UserVerificationMethodExtension userVerificationMethodExtension = this.f72448c;
        zzs zzsVar = this.f72447b;
        return "AuthenticationExtensions{\n fidoAppIdExtension=" + String.valueOf(this.f72446a) + ", \n cableAuthenticationExtension=" + String.valueOf(zzsVar) + ", \n userVerificationMethodExtension=" + String.valueOf(userVerificationMethodExtension) + ", \n googleMultiAssertionExtension=" + String.valueOf(zzzVar) + ", \n googleSessionIdExtension=" + String.valueOf(zzabVar) + ", \n googleSilentVerificationExtension=" + String.valueOf(zzadVar) + ", \n devicePublicKeyExtension=" + String.valueOf(zzuVar) + ", \n googleTunnelServerIdExtension=" + String.valueOf(zzagVar) + ", \n googleThirdPartyPaymentExtension=" + String.valueOf(googleThirdPartyPaymentExtension) + ", \n prfExtension=" + String.valueOf(zzakVar) + ", \n simpleTransactionAuthorizationExtension=" + String.valueOf(zzawVar) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, M(), i3, false);
        SafeParcelWriter.E(parcel, 3, this.f72447b, i3, false);
        SafeParcelWriter.E(parcel, 4, N(), i3, false);
        SafeParcelWriter.E(parcel, 5, this.f72449d, i3, false);
        SafeParcelWriter.E(parcel, 6, this.f72450f, i3, false);
        SafeParcelWriter.E(parcel, 7, this.f72451g, i3, false);
        SafeParcelWriter.E(parcel, 8, this.f72452h, i3, false);
        SafeParcelWriter.E(parcel, 9, this.f72453i, i3, false);
        SafeParcelWriter.E(parcel, 10, this.f72454j, i3, false);
        SafeParcelWriter.E(parcel, 11, this.f72455k, i3, false);
        SafeParcelWriter.E(parcel, 12, this.f72456l, i3, false);
        SafeParcelWriter.E(parcel, 13, this.f72457m, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
