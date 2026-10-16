package com.superwall.sdk.delegate;

import com.android.billingclient.api.Purchase;
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
public abstract class InternalPurchaseResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Cancelled extends InternalPurchaseResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Failed extends InternalPurchaseResult {
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                th = failed.error;
            }
            return failed.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final Failed copy(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failed(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.areEqual(this.error, ((Failed) obj).error);
        }

        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Pending extends InternalPurchaseResult {
        public static final Pending INSTANCE = new Pending();

        private Pending() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Purchased extends InternalPurchaseResult {
        private final Purchase purchase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purchased(Purchase purchase) {
            super(null);
            Intrinsics.checkNotNullParameter(purchase, "purchase");
            this.purchase = purchase;
        }

        public static /* synthetic */ Purchased copy$default(Purchased purchased, Purchase purchase, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                purchase = purchased.purchase;
            }
            return purchased.copy(purchase);
        }

        public final Purchase component1() {
            return this.purchase;
        }

        public final Purchased copy(Purchase purchase) {
            Intrinsics.checkNotNullParameter(purchase, "purchase");
            return new Purchased(purchase);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Purchased) && Intrinsics.areEqual(this.purchase, ((Purchased) obj).purchase);
        }

        public final Purchase getPurchase() {
            return this.purchase;
        }

        public int hashCode() {
            return this.purchase.hashCode();
        }

        public String toString() {
            return "Purchased(purchase=" + this.purchase + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Restored extends InternalPurchaseResult {
        public static final Restored INSTANCE = new Restored();

        private Restored() {
            super(null);
        }
    }

    public /* synthetic */ InternalPurchaseResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InternalPurchaseResult() {
    }
}
