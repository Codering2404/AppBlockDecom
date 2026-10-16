package cz.mobilesoft.coreblock.storage.room.premium;

import cz.mobilesoft.coreblock.storage.room.entity.core.ProductEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.SubscriptionOptionEntity;
import java.util.List;
import kotlin.Deprecated;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
public final class SubscriptionOptionWithProductAndPricingPhases {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubscriptionOptionEntity f126826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProductEntity f126827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f126828c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionOptionWithProductAndPricingPhases)) {
            return false;
        }
        SubscriptionOptionWithProductAndPricingPhases subscriptionOptionWithProductAndPricingPhases = (SubscriptionOptionWithProductAndPricingPhases) obj;
        return Intrinsics.areEqual(this.f126826a, subscriptionOptionWithProductAndPricingPhases.f126826a) && Intrinsics.areEqual(this.f126827b, subscriptionOptionWithProductAndPricingPhases.f126827b) && Intrinsics.areEqual(this.f126828c, subscriptionOptionWithProductAndPricingPhases.f126828c);
    }

    public int hashCode() {
        return (((this.f126826a.hashCode() * 31) + this.f126827b.hashCode()) * 31) + this.f126828c.hashCode();
    }

    public String toString() {
        return "SubscriptionOptionWithProductAndPricingPhases(subscriptionOptionEntity=" + this.f126826a + ", productEntity=" + this.f126827b + ", pricingPhases=" + this.f126828c + ")";
    }
}
