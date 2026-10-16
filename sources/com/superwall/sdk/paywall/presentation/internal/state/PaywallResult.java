package com.superwall.sdk.paywall.presentation.internal.state;

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
public abstract class PaywallResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Declined extends PaywallResult {
        public Declined() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Purchased extends PaywallResult {
        private final String productId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purchased(String productId) {
            super(null);
            Intrinsics.checkNotNullParameter(productId, "productId");
            this.productId = productId;
        }

        public static /* synthetic */ Purchased copy$default(Purchased purchased, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = purchased.productId;
            }
            return purchased.copy(str);
        }

        public final String component1() {
            return this.productId;
        }

        public final Purchased copy(String productId) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            return new Purchased(productId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Purchased) && Intrinsics.areEqual(this.productId, ((Purchased) obj).productId);
        }

        public final String getProductId() {
            return this.productId;
        }

        public int hashCode() {
            return this.productId.hashCode();
        }

        public String toString() {
            return "Purchased(productId=" + this.productId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Restored extends PaywallResult {
        public Restored() {
            super(null);
        }
    }

    public /* synthetic */ PaywallResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallResult() {
    }
}
