package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class NetworkStrings {
    public static final String API_REQUEST_COMPLETED = "API request completed with status: %s %s %s";
    public static final String API_REQUEST_STARTED = "API request started: %s %s";
    public static final String ETAG_CALL_ALREADY_RETRIED = "We can't find the cached response, but call has already been retried. Returning result from backend: %s";
    public static final String ETAG_RETRYING_CALL = "We were expecting to be able to return a cached response, but we can't find it. Retrying call with a new ETag";
    public static final String HTTP_RESPONSE_PAYLOAD_NULL = "HTTP Response payload is null";
    public static final NetworkStrings INSTANCE = new NetworkStrings();
    public static final String PROBLEM_CONNECTING = "Unable to start a network connection due to a network configuration issue: %s";
    public static final String RETRYING_CALL_WITH_FALLBACK_URL = "Retrying request %s using fallback URL %s";
    public static final String SAME_CALL_ALREADY_IN_PROGRESS = "Same call already in progress, adding to callbacks map with key: %s";
    public static final String SAME_CALL_SCHEDULED_WITHOUT_JITTER = "Request already scheduled without jitter delay, adding callbacks to unjittered request with key: %s";
    public static final String SAME_CALL_SCHEDULED_WITH_JITTER = "Request already scheduled with jitter delay, adding existing callbacks to unjittered request with key: %s";
    public static final String VERIFICATION_ERROR = "Verification: Request to '%s' failed verification.";
    public static final String VERIFICATION_INTERMEDIATE_KEY_FAILED = "Verification: Request to '%s' provided an intermediate key that did not verify correctly. Reason %s";
    public static final String VERIFICATION_INVALID_SIZE = "Verification: Request to '%s' has signature with wrong size. '%s'";
    public static final String VERIFICATION_MISSING_BODY_OR_ETAG = "Verification: Request to '%s' requires a body or etag but none provided.";
    public static final String VERIFICATION_MISSING_REQUEST_TIME = "Verification: Request to '%s' requires a request time but none provided.";
    public static final String VERIFICATION_MISSING_SIGNATURE = "Verification: Request to '%s' requires a signature but none provided.";
    public static final String VERIFICATION_SUCCESS = "Verification: Request to '%s' verified successfully.";

    private NetworkStrings() {
    }
}
