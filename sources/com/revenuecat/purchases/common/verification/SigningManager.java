package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.Result;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class SigningManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int NONCE_BYTES_SIZE = 12;

    @Deprecated
    public static final String POST_PARAMS_ALGORITHM = "sha256";

    @Deprecated
    public static final byte POST_PARAMS_SEPARATOR = 0;
    private final String apiKey;
    private final AppConfig appConfig;
    private final SignatureVerificationMode signatureVerificationMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Parameters {
        private final String apiKey;
        private final String body;
        private final String eTag;
        private final String nonce;
        private final String postParamsHashHeader;
        private final String requestTime;
        private final byte[] salt;
        private final String urlPath;

        public Parameters(byte[] salt, String apiKey, String str, String urlPath, String str2, String requestTime, String str3, String str4) {
            Intrinsics.checkNotNullParameter(salt, "salt");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(requestTime, "requestTime");
            this.salt = salt;
            this.apiKey = apiKey;
            this.nonce = str;
            this.urlPath = urlPath;
            this.postParamsHashHeader = str2;
            this.requestTime = requestTime;
            this.eTag = str3;
            this.body = str4;
        }

        public static /* synthetic */ Parameters copy$default(Parameters parameters, byte[] bArr, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bArr = parameters.salt;
            }
            if ((i3 & 2) != 0) {
                str = parameters.apiKey;
            }
            if ((i3 & 4) != 0) {
                str2 = parameters.nonce;
            }
            if ((i3 & 8) != 0) {
                str3 = parameters.urlPath;
            }
            if ((i3 & 16) != 0) {
                str4 = parameters.postParamsHashHeader;
            }
            if ((i3 & 32) != 0) {
                str5 = parameters.requestTime;
            }
            if ((i3 & 64) != 0) {
                str6 = parameters.eTag;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                str7 = parameters.body;
            }
            String str8 = str6;
            String str9 = str7;
            String str10 = str4;
            String str11 = str5;
            return parameters.copy(bArr, str, str2, str3, str10, str11, str8, str9);
        }

        public final byte[] component1() {
            return this.salt;
        }

        public final String component2() {
            return this.apiKey;
        }

        public final String component3() {
            return this.nonce;
        }

        public final String component4() {
            return this.urlPath;
        }

        public final String component5() {
            return this.postParamsHashHeader;
        }

        public final String component6() {
            return this.requestTime;
        }

        public final String component7() {
            return this.eTag;
        }

        public final String component8() {
            return this.body;
        }

        public final Parameters copy(byte[] salt, String apiKey, String str, String urlPath, String str2, String requestTime, String str3, String str4) {
            Intrinsics.checkNotNullParameter(salt, "salt");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(requestTime, "requestTime");
            return new Parameters(salt, apiKey, str, urlPath, str2, requestTime, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(Parameters.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.verification.SigningManager.Parameters");
            Parameters parameters = (Parameters) obj;
            return Arrays.equals(this.salt, parameters.salt) && Intrinsics.areEqual(this.apiKey, parameters.apiKey) && Intrinsics.areEqual(this.nonce, parameters.nonce) && Intrinsics.areEqual(this.urlPath, parameters.urlPath) && Intrinsics.areEqual(this.postParamsHashHeader, parameters.postParamsHashHeader) && Intrinsics.areEqual(this.requestTime, parameters.requestTime) && Intrinsics.areEqual(this.eTag, parameters.eTag) && Intrinsics.areEqual(this.body, parameters.body);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getBody() {
            return this.body;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getPostParamsHashHeader() {
            return this.postParamsHashHeader;
        }

        public final String getRequestTime() {
            return this.requestTime;
        }

        public final byte[] getSalt() {
            return this.salt;
        }

        public final String getUrlPath() {
            return this.urlPath;
        }

        public int hashCode() {
            int iHashCode = ((Arrays.hashCode(this.salt) * 31) + this.apiKey.hashCode()) * 31;
            String str = this.nonce;
            int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.urlPath.hashCode()) * 31;
            String str2 = this.postParamsHashHeader;
            int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.requestTime.hashCode()) * 31;
            String str3 = this.eTag;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.body;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final byte[] toSignatureToVerify() {
            /*
                r5 = this;
                byte[] r0 = r5.salt
                java.lang.String r1 = r5.apiKey
                java.nio.charset.Charset r2 = kotlin.text.Charsets.f140510b
                byte[] r1 = r1.getBytes(r2)
                java.lang.String r3 = "getBytes(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.nonce
                r4 = 0
                if (r1 == 0) goto L1d
                byte[] r1 = android.util.Base64.decode(r1, r4)
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L22
                byte[] r1 = new byte[r4]
            L22:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.urlPath
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.postParamsHashHeader
                if (r1 == 0) goto L40
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                if (r1 != 0) goto L42
            L40:
                byte[] r1 = new byte[r4]
            L42:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.requestTime
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.eTag
                if (r1 == 0) goto L60
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                if (r1 != 0) goto L62
            L60:
                byte[] r1 = new byte[r4]
            L62:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                java.lang.String r1 = r5.body
                if (r1 == 0) goto L73
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                if (r1 != 0) goto L75
            L73:
                byte[] r1 = new byte[r4]
            L75:
                byte[] r0 = kotlin.collections.ArraysKt.plus(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.verification.SigningManager.Parameters.toSignatureToVerify():byte[]");
        }

        public String toString() {
            return "Parameters(salt=" + Arrays.toString(this.salt) + ", apiKey=" + this.apiKey + ", nonce=" + this.nonce + ", urlPath=" + this.urlPath + ", postParamsHashHeader=" + this.postParamsHashHeader + ", requestTime=" + this.requestTime + ", eTag=" + this.eTag + ", body=" + this.body + ')';
        }
    }

    public SigningManager(SignatureVerificationMode signatureVerificationMode, AppConfig appConfig, String apiKey) {
        Intrinsics.checkNotNullParameter(signatureVerificationMode, "signatureVerificationMode");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.signatureVerificationMode = signatureVerificationMode;
        this.appConfig = appConfig;
        this.apiKey = apiKey;
    }

    public final String createRandomNonce() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        byte[] bArrEncode = Base64.encode(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(bytes, Base64.DEFAULT)");
        return StringsKt.t1(new String(bArrEncode, Charsets.f140510b)).toString();
    }

    public final String getPostParamsForSigningHeaderIfNeeded(Endpoint endpoint, List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        List<Pair<String, String>> list2 = list;
        if (list2 == null || list2.isEmpty() || !shouldVerifyEndpoint(endpoint)) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        List<Pair<String, String>> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        int i3 = 0;
        for (Object obj : list3) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            if (i3 > 0) {
                messageDigest.update((byte) 0);
            }
            byte[] bytes = ((String) pair.f()).getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            arrayList.add(Unit.f139807a);
            i3 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "sha256Digest.digest()");
        String string = "";
        for (byte b3 : bArrDigest) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            sb.append(str);
            string = sb.toString();
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.joinToString$default(list3, ",", null, null, 0, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.revenuecat.purchases.common.verification.SigningManager$getPostParamsForSigningHeaderIfNeeded$header$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Pair<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (CharSequence) it.e();
            }
        }, 30, null), POST_PARAMS_ALGORITHM, string}), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    public final SignatureVerificationMode getSignatureVerificationMode() {
        return this.signatureVerificationMode;
    }

    public final boolean shouldVerifyEndpoint(Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        return endpoint.getSupportsSignatureVerification() && this.signatureVerificationMode.getShouldVerify();
    }

    public final VerificationResult verifyResponse(String urlPath, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(urlPath, "urlPath");
        if (this.appConfig.getForceSigningErrors()) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Forcing signing error for request with path: " + urlPath);
            }
            return VerificationResult.FAILED;
        }
        IntermediateSignatureHelper intermediateSignatureHelper = this.signatureVerificationMode.getIntermediateSignatureHelper();
        if (intermediateSignatureHelper == null) {
            return VerificationResult.NOT_REQUESTED;
        }
        if (str == null) {
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            String str7 = String.format(NetworkStrings.VERIFICATION_MISSING_SIGNATURE, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            currentLogHandler2.e("[Purchases] - ERROR", str7, null);
            return VerificationResult.FAILED;
        }
        if (str4 == null) {
            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
            String str8 = String.format(NetworkStrings.VERIFICATION_MISSING_REQUEST_TIME, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
            currentLogHandler3.e("[Purchases] - ERROR", str8, null);
            return VerificationResult.FAILED;
        }
        if (str3 == null && str5 == null) {
            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
            String str9 = String.format(NetworkStrings.VERIFICATION_MISSING_BODY_OR_ETAG, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
            currentLogHandler4.e("[Purchases] - ERROR", str9, null);
            return VerificationResult.FAILED;
        }
        try {
            Signature signatureFromString$purchases_defaultsBc8Release = Signature.Companion.fromString$purchases_defaultsBc8Release(str);
            Result<SignatureVerifier, PurchasesError> resultCreateIntermediateKeyVerifierIfVerified = intermediateSignatureHelper.createIntermediateKeyVerifierIfVerified(signatureFromString$purchases_defaultsBc8Release);
            if (resultCreateIntermediateKeyVerifierIfVerified instanceof Result.Error) {
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                String str10 = String.format(NetworkStrings.VERIFICATION_INTERMEDIATE_KEY_FAILED, Arrays.copyOf(new Object[]{urlPath, ((PurchasesError) ((Result.Error) resultCreateIntermediateKeyVerifierIfVerified).getValue()).getUnderlyingErrorMessage()}, 2));
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                currentLogHandler5.e("[Purchases] - ERROR", str10, null);
                return VerificationResult.FAILED;
            }
            if (!(resultCreateIntermediateKeyVerifierIfVerified instanceof Result.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!((SignatureVerifier) ((Result.Success) resultCreateIntermediateKeyVerifierIfVerified).getValue()).verify(signatureFromString$purchases_defaultsBc8Release.getPayload(), new Parameters(signatureFromString$purchases_defaultsBc8Release.getSalt(), this.apiKey, str2, urlPath, str6, str4, str5, str3).toSignatureToVerify())) {
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                String str11 = String.format(NetworkStrings.VERIFICATION_ERROR, Arrays.copyOf(new Object[]{urlPath}, 1));
                Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                currentLogHandler6.e("[Purchases] - ERROR", str11, null);
                return VerificationResult.FAILED;
            }
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                String str12 = "[Purchases] - " + logLevel2.name();
                String str13 = String.format(NetworkStrings.VERIFICATION_SUCCESS, Arrays.copyOf(new Object[]{urlPath}, 1));
                Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                currentLogHandler7.v(str12, str13);
            }
            return VerificationResult.VERIFIED;
        } catch (InvalidSignatureSizeException e3) {
            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
            String str14 = String.format(NetworkStrings.VERIFICATION_INVALID_SIZE, Arrays.copyOf(new Object[]{urlPath, e3.getMessage()}, 2));
            Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
            currentLogHandler8.e("[Purchases] - ERROR", str14, null);
            return VerificationResult.FAILED;
        }
    }
}
