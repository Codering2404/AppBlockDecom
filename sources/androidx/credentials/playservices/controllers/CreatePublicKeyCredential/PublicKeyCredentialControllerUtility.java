package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.DomError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.AuthenticationToken;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension;
import com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PublicKeyCredentialControllerUtility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f35030a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f35031b = "clientDataJSON";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f35032c = "attestationObject";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f35033d = "authenticatorData";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f35034e = AuthenticationToken.SIGNATURE_KEY;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f35035f = "userHandle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f35036g = "response";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f35037h = "id";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f35038i = "rawId";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f35039j = "type";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f35040k = "rpId";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f35041l = "challenge";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f35042m = AppsFlyerProperties.APP_ID;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f35043n = "thirdPartyPayment";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f35044o = "authenticatorSelection";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f35045p = "requireResidentKey";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f35046q = "residentKey";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f35047r = "authenticatorAttachment";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f35048s = "timeout";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f35049t = "excludeCredentials";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f35050u = "transports";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f35051v = "rp";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f35052w = "name";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f35053x = "icon";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f35054y = "alg";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f35055z = "user";
    private static final String A = "displayName";
    private static final String B = "userVerificationMethod";
    private static final String C = "keyProtectionType";
    private static final String D = "matcherProtectionType";
    private static final String E = "extensions";
    private static final String F = "attestation";
    private static final String G = "pubKeyCredParams";
    private static final String H = "clientExtensionResults";
    private static final String I = "rk";
    private static final String J = "credProps";
    private static final LinkedHashMap K = MapsKt.linkedMapOf(TuplesKt.a(ErrorCode.UNKNOWN_ERR, new UnknownError()), TuplesKt.a(ErrorCode.ABORT_ERR, new AbortError()), TuplesKt.a(ErrorCode.ATTESTATION_NOT_PRIVATE_ERR, new NotReadableError()), TuplesKt.a(ErrorCode.CONSTRAINT_ERR, new ConstraintError()), TuplesKt.a(ErrorCode.DATA_ERR, new DataError()), TuplesKt.a(ErrorCode.INVALID_STATE_ERR, new InvalidStateError()), TuplesKt.a(ErrorCode.ENCODING_ERR, new EncodingError()), TuplesKt.a(ErrorCode.NETWORK_ERR, new NetworkError()), TuplesKt.a(ErrorCode.NOT_ALLOWED_ERR, new NotAllowedError()), TuplesKt.a(ErrorCode.NOT_SUPPORTED_ERR, new NotSupportedError()), TuplesKt.a(ErrorCode.SECURITY_ERR, new SecurityError()), TuplesKt.a(ErrorCode.TIMEOUT_ERR, new TimeoutError()));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean F(Context context, long j3) throws PackageManager.NameNotFoundException {
            if (GoogleApiAvailability.q().i(context) != 0) {
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
            return GetGMSVersion.a(packageInfo) > j3;
        }

        private final byte[] h(JSONObject jSONObject) throws JSONException {
            String strOptString = jSONObject.optString(n(), "");
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() != 0) {
                return a(strOptString);
            }
            throw new JSONException("Challenge not found in request or is unexpectedly empty");
        }

        public final String A() {
            return PublicKeyCredentialControllerUtility.f35048s;
        }

        public final String B() {
            return PublicKeyCredentialControllerUtility.f35050u;
        }

        public final String C() {
            return PublicKeyCredentialControllerUtility.f35039j;
        }

        public final String D() {
            return PublicKeyCredentialControllerUtility.f35055z;
        }

        public final LinkedHashMap E() {
            return PublicKeyCredentialControllerUtility.K;
        }

        public final void G(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (json.has(m())) {
                JSONObject jSONObject = json.getJSONObject(m());
                AuthenticatorSelectionCriteria.Builder builder2 = new AuthenticatorSelectionCriteria.Builder();
                boolean zOptBoolean = jSONObject.optBoolean(v(), false);
                String strOptString = jSONObject.optString(w(), "");
                Intrinsics.checkNotNull(strOptString);
                builder2.c(Boolean.valueOf(zOptBoolean)).d(strOptString.length() > 0 ? ResidentKeyRequirement.a(strOptString) : null);
                String strOptString2 = jSONObject.optString(l(), "");
                Intrinsics.checkNotNull(strOptString2);
                if (strOptString2.length() > 0) {
                    builder2.b(Attachment.a(strOptString2));
                }
                builder.d(builder2.a());
            }
        }

        public final void H(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (json.has(q())) {
                JSONObject jSONObject = json.getJSONObject(q());
                AuthenticationExtensions.Builder builder2 = new AuthenticationExtensions.Builder();
                String strOptString = jSONObject.optString(j(), "");
                Intrinsics.checkNotNull(strOptString);
                if (strOptString.length() > 0) {
                    builder2.b(new FidoAppIdExtension(strOptString));
                }
                if (jSONObject.optBoolean(z(), false)) {
                    builder2.c(new GoogleThirdPartyPaymentExtension(true));
                }
                if (jSONObject.optBoolean("uvm", false)) {
                    builder2.d(new UserVerificationMethodExtension(true));
                }
                builder.c(builder2.a());
            }
        }

        public final void I(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (json.has(A())) {
                builder.i(Double.valueOf(json.getLong(A()) / ((double) 1000)));
            }
        }

        public final void J(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) throws JSONException, CreatePublicKeyCredentialDomException {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(builder, "builder");
            ArrayList arrayList2 = new ArrayList();
            if (json.has(p())) {
                JSONArray jSONArray = json.getJSONArray(p());
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String string = jSONObject.getString(s());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    byte[] bArrA = a(string);
                    String string2 = jSONObject.getString(C());
                    Intrinsics.checkNotNull(string2);
                    if (string2.length() == 0) {
                        throw new JSONException("PublicKeyCredentialDescriptor type value is not found or unexpectedly empty");
                    }
                    if (bArrA.length == 0) {
                        throw new JSONException("PublicKeyCredentialDescriptor id value is not found or unexpectedly empty");
                    }
                    if (jSONObject.has(B())) {
                        arrayList = new ArrayList();
                        JSONArray jSONArray2 = jSONObject.getJSONArray(B());
                        int length2 = jSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            try {
                                Transport transportA = Transport.a(jSONArray2.getString(i4));
                                Intrinsics.checkNotNullExpressionValue(transportA, "fromString(...)");
                                arrayList.add(transportA);
                            } catch (Transport.UnsupportedTransportException e3) {
                                throw new CreatePublicKeyCredentialDomException(new EncodingError(), e3.getMessage());
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    arrayList2.add(new PublicKeyCredentialDescriptor(string2, bArrA, arrayList));
                }
            }
            builder.f(arrayList2);
            String strK = k();
            String str = IntegrityManager.INTEGRITY_TYPE_NONE;
            String strOptString = json.optString(strK, IntegrityManager.INTEGRITY_TYPE_NONE);
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() != 0) {
                str = strOptString;
            }
            builder.b(AttestationConveyancePreference.a(str));
        }

        public final void K(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(builder, "builder");
            builder.e(h(json));
            JSONObject jSONObject = json.getJSONObject(D());
            String string = jSONObject.getString(s());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            byte[] bArrA = a(string);
            String string2 = jSONObject.getString(t());
            String string3 = jSONObject.getString(o());
            String strOptString = jSONObject.optString(r(), "");
            Intrinsics.checkNotNull(string3);
            if (string3.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing displayName or they are unexpectedly empty");
            }
            if (bArrA.length == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing user id or they are unexpectedly empty");
            }
            Intrinsics.checkNotNull(string2);
            if (string2.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing user name or they are unexpectedly empty");
            }
            builder.j(new PublicKeyCredentialUserEntity(bArrA, string2, strOptString, string3));
        }

        public final void L(JSONObject json, PublicKeyCredentialCreationOptions.Builder builder) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(builder, "builder");
            JSONObject jSONObject = json.getJSONObject(x());
            String string = jSONObject.getString(s());
            String strOptString = jSONObject.optString(t(), "");
            String strOptString2 = jSONObject.optString(r(), "");
            Intrinsics.checkNotNull(strOptString2);
            if (strOptString2.length() == 0) {
                strOptString2 = null;
            }
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions rp name is missing or unexpectedly empty");
            }
            Intrinsics.checkNotNull(string);
            if (string.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions rp ID is missing or unexpectedly empty");
            }
            builder.h(new PublicKeyCredentialRpEntity(string, strOptString, strOptString2));
            JSONArray jSONArray = json.getJSONArray(u());
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                int i4 = (int) jSONObject2.getLong(i());
                String strOptString3 = jSONObject2.optString(C(), "");
                Intrinsics.checkNotNull(strOptString3);
                if (strOptString3.length() == 0) {
                    throw new JSONException("PublicKeyCredentialCreationOptions PublicKeyCredentialParameter type missing or unexpectedly empty");
                }
                if (c(i4)) {
                    arrayList.add(new PublicKeyCredentialParameters(strOptString3, i4));
                }
            }
            builder.g(arrayList);
        }

        public final CreateCredentialException M(PublicKeyCredential cred) {
            Intrinsics.checkNotNullParameter(cred, "cred");
            AuthenticatorResponse authenticatorResponseW0 = cred.w0();
            Intrinsics.checkNotNullExpressionValue(authenticatorResponseW0, "getResponse(...)");
            if (!(authenticatorResponseW0 instanceof AuthenticatorErrorResponse)) {
                return null;
            }
            AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) authenticatorResponseW0;
            ErrorCode errorCodeM = authenticatorErrorResponse.M();
            Intrinsics.checkNotNullExpressionValue(errorCodeM, "getErrorCode(...)");
            DomError domError = (DomError) E().get(errorCodeM);
            String strO = authenticatorErrorResponse.O();
            if (domError != null) {
                return (errorCodeM == ErrorCode.NOT_ALLOWED_ERR && strO != null && StringsKt.a0(strO, "Unable to get sync account", false, 2, null)) ? new CreateCredentialCancellationException("Passkey registration was cancelled by the user.") : new CreatePublicKeyCredentialDomException(domError, strO);
            }
            return new CreatePublicKeyCredentialDomException(new UnknownError(), "unknown fido gms exception - " + strO);
        }

        public final String N(SignInCredential cred) throws GetCredentialException {
            Intrinsics.checkNotNullParameter(cred, "cred");
            JSONObject jSONObject = new JSONObject();
            PublicKeyCredential publicKeyCredentialJ2 = cred.J2();
            AuthenticatorResponse authenticatorResponseW0 = publicKeyCredentialJ2 != null ? publicKeyCredentialJ2.w0() : null;
            Intrinsics.checkNotNull(authenticatorResponseW0);
            if (authenticatorResponseW0 instanceof AuthenticatorErrorResponse) {
                AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) authenticatorResponseW0;
                ErrorCode errorCodeM = authenticatorErrorResponse.M();
                Intrinsics.checkNotNullExpressionValue(errorCodeM, "getErrorCode(...)");
                throw b(errorCodeM, authenticatorErrorResponse.O());
            }
            if (!(authenticatorResponseW0 instanceof AuthenticatorAssertionResponse)) {
                Log.e("PublicKeyUtility", "AuthenticatorResponse expected assertion response but got: " + authenticatorResponseW0.getClass().getName());
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
            try {
                String strH1 = publicKeyCredentialJ2.h1();
                Intrinsics.checkNotNullExpressionValue(strH1, "toJson(...)");
                return strH1;
            } catch (Throwable th) {
                throw new GetCredentialUnknownException("The PublicKeyCredential response json had an unexpected exception when parsing: " + th.getMessage());
            }
        }

        public final byte[] a(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            byte[] bArrDecode = Base64.decode(str, 11);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            return bArrDecode;
        }

        public final GetCredentialException b(ErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            DomError domError = (DomError) E().get(code);
            if (domError != null) {
                return (code == ErrorCode.NOT_ALLOWED_ERR && str != null && StringsKt.a0(str, "Unable to get sync account", false, 2, null)) ? new GetCredentialCancellationException("Passkey retrieval was cancelled by the user.") : new GetPublicKeyCredentialDomException(domError, str);
            }
            return new GetPublicKeyCredentialDomException(new UnknownError(), "unknown fido gms exception - " + str);
        }

        public final boolean c(int i3) {
            try {
                COSEAlgorithmIdentifier.a(i3);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public final PublicKeyCredentialCreationOptions d(CreatePublicKeyCredentialRequest request, Context context) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(context, "context");
            return F(context, 241217000L) ? new PublicKeyCredentialCreationOptions(request.c()) : e(new JSONObject(request.c()));
        }

        public final PublicKeyCredentialCreationOptions e(JSONObject json) throws JSONException, CreatePublicKeyCredentialDomException {
            Intrinsics.checkNotNullParameter(json, "json");
            PublicKeyCredentialCreationOptions.Builder builder = new PublicKeyCredentialCreationOptions.Builder();
            K(json, builder);
            L(json, builder);
            J(json, builder);
            I(json, builder);
            G(json, builder);
            H(json, builder);
            PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptionsA = builder.a();
            Intrinsics.checkNotNullExpressionValue(publicKeyCredentialCreationOptionsA, "build(...)");
            return publicKeyCredentialCreationOptionsA;
        }

        public final BeginSignInRequest.PasskeysRequestOptions g(GetPublicKeyCredentialOption option) throws JSONException {
            Intrinsics.checkNotNullParameter(option, "option");
            JSONObject jSONObject = new JSONObject(option.g());
            String strOptString = jSONObject.optString(y(), "");
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() == 0) {
                throw new JSONException("GetPublicKeyCredentialOption - rpId not specified in the request or is unexpectedly empty");
            }
            BeginSignInRequest.PasskeysRequestOptions passkeysRequestOptionsA = new BeginSignInRequest.PasskeysRequestOptions.Builder().d(true).c(strOptString).b(h(jSONObject)).a();
            Intrinsics.checkNotNullExpressionValue(passkeysRequestOptionsA, "build(...)");
            return passkeysRequestOptionsA;
        }

        public final String i() {
            return PublicKeyCredentialControllerUtility.f35054y;
        }

        public final String j() {
            return PublicKeyCredentialControllerUtility.f35042m;
        }

        public final String k() {
            return PublicKeyCredentialControllerUtility.F;
        }

        public final String l() {
            return PublicKeyCredentialControllerUtility.f35047r;
        }

        public final String m() {
            return PublicKeyCredentialControllerUtility.f35044o;
        }

        public final String n() {
            return PublicKeyCredentialControllerUtility.f35041l;
        }

        public final String o() {
            return PublicKeyCredentialControllerUtility.A;
        }

        public final String p() {
            return PublicKeyCredentialControllerUtility.f35049t;
        }

        public final String q() {
            return PublicKeyCredentialControllerUtility.E;
        }

        public final String r() {
            return PublicKeyCredentialControllerUtility.f35053x;
        }

        public final String s() {
            return PublicKeyCredentialControllerUtility.f35037h;
        }

        public final String t() {
            return PublicKeyCredentialControllerUtility.f35052w;
        }

        public final String u() {
            return PublicKeyCredentialControllerUtility.G;
        }

        public final String v() {
            return PublicKeyCredentialControllerUtility.f35045p;
        }

        public final String w() {
            return PublicKeyCredentialControllerUtility.f35046q;
        }

        public final String x() {
            return PublicKeyCredentialControllerUtility.f35051v;
        }

        public final String y() {
            return PublicKeyCredentialControllerUtility.f35040k;
        }

        public final String z() {
            return PublicKeyCredentialControllerUtility.f35043n;
        }

        private Companion() {
        }

        public final BeginSignInRequest.PasskeyJsonRequestOptions f(GetPublicKeyCredentialOption getPublicKeyCredentialOption) {
            Intrinsics.checkNotNullParameter(getPublicKeyCredentialOption, sKeKFMqmvNzY.FeeVPUsPkZlSML);
            BeginSignInRequest.PasskeyJsonRequestOptions passkeyJsonRequestOptionsA = new BeginSignInRequest.PasskeyJsonRequestOptions.Builder().c(true).b(getPublicKeyCredentialOption.g()).a();
            Intrinsics.checkNotNullExpressionValue(passkeyJsonRequestOptionsA, "build(...)");
            return passkeyJsonRequestOptionsA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class GetGMSVersion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GetGMSVersion f35056a = new GetGMSVersion();

        private GetGMSVersion() {
        }

        public static final long a(PackageInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return info.getLongVersionCode();
        }
    }
}
