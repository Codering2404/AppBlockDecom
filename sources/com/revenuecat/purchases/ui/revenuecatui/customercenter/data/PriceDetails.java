package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

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
public abstract class PriceDetails {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Free extends PriceDetails {
        public static final int $stable = 0;
        public static final Free INSTANCE = new Free();

        private Free() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Paid extends PriceDetails {
        public static final int $stable = 0;
        private final String price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paid(String price) {
            super(null);
            Intrinsics.checkNotNullParameter(price, "price");
            this.price = price;
        }

        public static /* synthetic */ Paid copy$default(Paid paid, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paid.price;
            }
            return paid.copy(str);
        }

        public final String component1() {
            return this.price;
        }

        public final Paid copy(String price) {
            Intrinsics.checkNotNullParameter(price, "price");
            return new Paid(price);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paid) && Intrinsics.areEqual(this.price, ((Paid) obj).price);
        }

        public final String getPrice() {
            return this.price;
        }

        public int hashCode() {
            return this.price.hashCode();
        }

        public String toString() {
            return "Paid(price=" + this.price + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Unknown extends PriceDetails {
        public static final int $stable = 0;
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    public /* synthetic */ PriceDetails(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PriceDetails() {
    }
}
