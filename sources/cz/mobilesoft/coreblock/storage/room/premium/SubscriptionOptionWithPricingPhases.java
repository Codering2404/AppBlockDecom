package cz.mobilesoft.coreblock.storage.room.premium;

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
public final class SubscriptionOptionWithPricingPhases {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubscriptionOptionEntity f126824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f126825b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionOptionWithPricingPhases)) {
            return false;
        }
        SubscriptionOptionWithPricingPhases subscriptionOptionWithPricingPhases = (SubscriptionOptionWithPricingPhases) obj;
        return Intrinsics.areEqual(this.f126824a, subscriptionOptionWithPricingPhases.f126824a) && Intrinsics.areEqual(this.f126825b, subscriptionOptionWithPricingPhases.f126825b);
    }

    public int hashCode() {
        return (this.f126824a.hashCode() * 31) + this.f126825b.hashCode();
    }

    public String toString() {
        return "SubscriptionOptionWithPricingPhases(subscriptionOptionEntity=" + this.f126824a + ", pricingPhases=" + this.f126825b + ")";
    }
}
