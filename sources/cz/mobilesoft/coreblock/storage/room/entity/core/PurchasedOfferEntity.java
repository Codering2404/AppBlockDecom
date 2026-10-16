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
public final class PurchasedOfferEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f126600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f126601e;

    public final String a() {
        return this.f126599c;
    }

    public final String b() {
        return this.f126598b;
    }

    public final String c() {
        return this.f126600d;
    }

    public final String d() {
        return this.f126597a;
    }

    public final boolean e() {
        return this.f126601e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchasedOfferEntity)) {
            return false;
        }
        PurchasedOfferEntity purchasedOfferEntity = (PurchasedOfferEntity) obj;
        return Intrinsics.areEqual(this.f126597a, purchasedOfferEntity.f126597a) && Intrinsics.areEqual(this.f126598b, purchasedOfferEntity.f126598b) && Intrinsics.areEqual(this.f126599c, purchasedOfferEntity.f126599c) && Intrinsics.areEqual(this.f126600d, purchasedOfferEntity.f126600d) && this.f126601e == purchasedOfferEntity.f126601e;
    }

    public final void f(boolean z2) {
        this.f126601e = z2;
    }

    public int hashCode() {
        return (((((((this.f126597a.hashCode() * 31) + this.f126598b.hashCode()) * 31) + this.f126599c.hashCode()) * 31) + this.f126600d.hashCode()) * 31) + Boolean.hashCode(this.f126601e);
    }

    public String toString() {
        return "PurchasedOfferEntity(purchaseToken=" + this.f126597a + ", productId=" + this.f126598b + ", offerTags=" + this.f126599c + ", purchaseTime=" + this.f126600d + ", isSynchronized=" + this.f126601e + ")";
    }
}
