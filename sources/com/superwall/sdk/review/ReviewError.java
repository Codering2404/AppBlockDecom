package com.superwall.sdk.review;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class ReviewError extends Exception {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GenericError extends ReviewError {
        public /* synthetic */ GenericError(String str, Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GenericError(String message, Throwable th) {
            super(message, th, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchFlowError extends ReviewError {
        /* JADX WARN: Multi-variable type inference failed */
        public LaunchFlowError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ LaunchFlowError(Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : th);
        }

        public LaunchFlowError(Throwable th) {
            super("Failed to launch review flow", th, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlayServicesUnavailable extends ReviewError {
        public static final PlayServicesUnavailable INSTANCE = new PlayServicesUnavailable();

        /* JADX WARN: Multi-variable type inference failed */
        private PlayServicesUnavailable() {
            super("Google Play Services not available", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestFlowError extends ReviewError {
        private final int errorCode;

        public /* synthetic */ RequestFlowError(int i3, Throwable th, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i4 & 2) != 0 ? null : th);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public RequestFlowError(int i3, Throwable th) {
            super("Failed to request review flow with error code: " + i3, th, null);
            this.errorCode = i3;
        }
    }

    public /* synthetic */ ReviewError(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    public /* synthetic */ ReviewError(String str, Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : th, null);
    }

    private ReviewError(String str, Throwable th) {
        super(str, th);
    }
}
