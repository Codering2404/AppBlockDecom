package com.revenuecat.purchases.ui.revenuecatui.activity;

import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallActivityNonSerializableArgs {
    public static final int $stable = 0;
    private final PaywallListener listener;
    private final PaywallPurchaseLogic purchaseLogic;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallActivityNonSerializableArgs() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PaywallActivityNonSerializableArgs copy$default(PaywallActivityNonSerializableArgs paywallActivityNonSerializableArgs, PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            paywallPurchaseLogic = paywallActivityNonSerializableArgs.purchaseLogic;
        }
        if ((i3 & 2) != 0) {
            paywallListener = paywallActivityNonSerializableArgs.listener;
        }
        return paywallActivityNonSerializableArgs.copy(paywallPurchaseLogic, paywallListener);
    }

    public final PaywallPurchaseLogic component1() {
        return this.purchaseLogic;
    }

    public final PaywallListener component2() {
        return this.listener;
    }

    public final PaywallActivityNonSerializableArgs copy(PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener) {
        return new PaywallActivityNonSerializableArgs(paywallPurchaseLogic, paywallListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallActivityNonSerializableArgs)) {
            return false;
        }
        PaywallActivityNonSerializableArgs paywallActivityNonSerializableArgs = (PaywallActivityNonSerializableArgs) obj;
        return Intrinsics.areEqual(this.purchaseLogic, paywallActivityNonSerializableArgs.purchaseLogic) && Intrinsics.areEqual(this.listener, paywallActivityNonSerializableArgs.listener);
    }

    public final PaywallListener getListener() {
        return this.listener;
    }

    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    public int hashCode() {
        PaywallPurchaseLogic paywallPurchaseLogic = this.purchaseLogic;
        int iHashCode = (paywallPurchaseLogic == null ? 0 : paywallPurchaseLogic.hashCode()) * 31;
        PaywallListener paywallListener = this.listener;
        return iHashCode + (paywallListener != null ? paywallListener.hashCode() : 0);
    }

    public String toString() {
        return "PaywallActivityNonSerializableArgs(purchaseLogic=" + this.purchaseLogic + ", listener=" + this.listener + ')';
    }

    public PaywallActivityNonSerializableArgs(PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener) {
        this.purchaseLogic = paywallPurchaseLogic;
        this.listener = paywallListener;
    }

    public /* synthetic */ PaywallActivityNonSerializableArgs(PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : paywallPurchaseLogic, (i3 & 2) != 0 ? null : paywallListener);
    }
}
