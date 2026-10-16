package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import kotlin.Metadata;
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
public final class CustomerCenterOptions {
    public static final int $stable = 8;
    private final CustomerCenterListener listener;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        public static final int $stable = 8;
        private CustomerCenterListener listener;

        public final CustomerCenterOptions build() {
            return new CustomerCenterOptions(this);
        }

        public final CustomerCenterListener getListener$revenuecatui_defaultsBc8Release() {
            return this.listener;
        }

        public final Builder setListener(CustomerCenterListener customerCenterListener) {
            this.listener = customerCenterListener;
            return this;
        }

        public final void setListener$revenuecatui_defaultsBc8Release(CustomerCenterListener customerCenterListener) {
            this.listener = customerCenterListener;
        }
    }

    public CustomerCenterOptions(CustomerCenterListener customerCenterListener) {
        this.listener = customerCenterListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(CustomerCenterOptions.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterOptions");
        return Intrinsics.areEqual(this.listener, ((CustomerCenterOptions) obj).listener);
    }

    public final CustomerCenterListener getListener$revenuecatui_defaultsBc8Release() {
        return this.listener;
    }

    public int hashCode() {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            return customerCenterListener.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CustomerCenterOptions(listener=" + this.listener + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterOptions(Builder builder) {
        this(builder.getListener$revenuecatui_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }
}
