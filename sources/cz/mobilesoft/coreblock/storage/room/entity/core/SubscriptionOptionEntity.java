package cz.mobilesoft.coreblock.storage.room.entity.core;

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
@Metadata
public final class SubscriptionOptionEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f126613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f126614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f126615f;

    public final long a() {
        return this.f126610a;
    }

    public final String b() {
        return this.f126613d;
    }

    public final String c() {
        return this.f126614e;
    }

    public final String d() {
        return this.f126615f;
    }

    public final String e() {
        return this.f126612c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionOptionEntity)) {
            return false;
        }
        SubscriptionOptionEntity subscriptionOptionEntity = (SubscriptionOptionEntity) obj;
        return this.f126610a == subscriptionOptionEntity.f126610a && Intrinsics.areEqual(this.f126611b, subscriptionOptionEntity.f126611b) && Intrinsics.areEqual(this.f126612c, subscriptionOptionEntity.f126612c) && Intrinsics.areEqual(this.f126613d, subscriptionOptionEntity.f126613d) && Intrinsics.areEqual(this.f126614e, subscriptionOptionEntity.f126614e) && Intrinsics.areEqual(this.f126615f, subscriptionOptionEntity.f126615f);
    }

    public final String f() {
        return this.f126611b;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.f126610a) * 31) + this.f126611b.hashCode()) * 31) + this.f126612c.hashCode()) * 31) + this.f126613d.hashCode()) * 31) + this.f126614e.hashCode()) * 31;
        String str = this.f126615f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SubscriptionOptionEntity(id=" + this.f126610a + ", productId=" + this.f126611b + ", optionId=" + this.f126612c + ", offerId=" + this.f126613d + ", offerTags=" + this.f126614e + ", offerToken=" + this.f126615f + ")";
    }
}
