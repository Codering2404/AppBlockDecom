package com.superwall.sdk.delegate;

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
public abstract class PurchaseResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Cancelled extends PurchaseResult {
        public Cancelled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Failed extends PurchaseResult {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String errorMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = failed.errorMessage;
            }
            return failed.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final Failed copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new Failed(errorMessage);
        }

        @Override // com.superwall.sdk.delegate.PurchaseResult
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.areEqual(this.errorMessage, ((Failed) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "Failed(errorMessage=" + this.errorMessage + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Pending extends PurchaseResult {
        public Pending() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Purchased extends PurchaseResult {
        public Purchased() {
            super(null);
        }
    }

    public /* synthetic */ PurchaseResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean equals(Object obj) {
        if ((this instanceof Cancelled) && (obj instanceof Cancelled)) {
            return true;
        }
        if ((this instanceof Purchased) && (obj instanceof Purchased)) {
            return true;
        }
        if ((this instanceof Pending) && (obj instanceof Pending)) {
            return true;
        }
        if ((this instanceof Failed) && (obj instanceof Failed)) {
            return Intrinsics.areEqual(((Failed) this).getErrorMessage(), ((Failed) obj).getErrorMessage());
        }
        return false;
    }

    private PurchaseResult() {
    }
}
