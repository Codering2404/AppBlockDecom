package com.superwall.sdk.billing;

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
public abstract class BillingError extends Exception {
    private final int code;
    private final String description;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BillingNotAvailable extends BillingError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BillingNotAvailable(String description) {
            super(2, description, null);
            Intrinsics.checkNotNullParameter(description, "description");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IllegalStateException extends BillingError {
        public static final IllegalStateException INSTANCE = new IllegalStateException();

        private IllegalStateException() {
            super(1, "IllegalStateException when connecting to billing client", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UnknownError extends BillingError {
        public static final UnknownError INSTANCE = new UnknownError();

        private UnknownError() {
            super(0, "Unknown error.", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WithCode extends BillingError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithCode(int i3, String description) {
            super(i3, "Google Billing error: " + i3 + " - " + description, null);
            Intrinsics.checkNotNullParameter(description, "description");
        }
    }

    public /* synthetic */ BillingError(int i3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    private BillingError(int i3, String str) {
        super(str);
        this.code = i3;
        this.description = str;
    }
}
