package com.superwall.sdk.store.transactions;

import com.superwall.sdk.store.abstractions.product.StoreProduct;
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
public abstract class TransactionError extends Throwable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Failure extends TransactionError {
        private final String message;
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String message, StoreProduct product) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(product, "product");
            this.message = message;
            this.product = product;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, String str, StoreProduct storeProduct, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = failure.message;
            }
            if ((i3 & 2) != 0) {
                storeProduct = failure.product;
            }
            return failure.copy(str, storeProduct);
        }

        public final String component1() {
            return this.message;
        }

        public final StoreProduct component2() {
            return this.product;
        }

        public final Failure copy(String message, StoreProduct product) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(product, "product");
            return new Failure(message, product);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) obj;
            return Intrinsics.areEqual(this.message, failure.message) && Intrinsics.areEqual(this.product, failure.product);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.product.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "Failure(message=" + this.message + ", product=" + this.product + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Pending extends TransactionError {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pending(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public static /* synthetic */ Pending copy$default(Pending pending, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pending.message;
            }
            return pending.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Pending copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Pending(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Pending) && Intrinsics.areEqual(this.message, ((Pending) obj).message);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "Pending(message=" + this.message + ")";
        }
    }

    public /* synthetic */ TransactionError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TransactionError() {
    }
}
