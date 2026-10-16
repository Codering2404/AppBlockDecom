package com.superwall.sdk.store;

import com.superwall.sdk.store.abstractions.product.StoreProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

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
public abstract class ProductState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends ProductState {
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                th = error.error;
            }
            return error.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final Error copy(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loaded extends ProductState {
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loaded(StoreProduct product) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            this.product = product;
        }

        public static /* synthetic */ Loaded copy$default(Loaded loaded, StoreProduct storeProduct, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeProduct = loaded.product;
            }
            return loaded.copy(storeProduct);
        }

        public final StoreProduct component1() {
            return this.product;
        }

        public final Loaded copy(StoreProduct product) {
            Intrinsics.checkNotNullParameter(product, "product");
            return new Loaded(product);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loaded) && Intrinsics.areEqual(this.product, ((Loaded) obj).product);
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        public int hashCode() {
            return this.product.hashCode();
        }

        public String toString() {
            return "Loaded(product=" + this.product + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends ProductState {
        private final CompletableDeferred<StoreProduct> deferred;

        /* JADX WARN: Multi-variable type inference failed */
        public Loading() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final CompletableDeferred<StoreProduct> getDeferred() {
            return this.deferred;
        }

        public /* synthetic */ Loading(CompletableDeferred completableDeferred, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? CompletableDeferredKt.b(null, 1, null) : completableDeferred);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loading(CompletableDeferred<StoreProduct> deferred) {
            super(null);
            Intrinsics.checkNotNullParameter(deferred, "deferred");
            this.deferred = deferred;
        }
    }

    public /* synthetic */ ProductState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProductState() {
    }
}
