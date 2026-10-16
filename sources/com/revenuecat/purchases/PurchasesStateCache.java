package com.revenuecat.purchases;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PurchasesStateCache implements PurchasesStateProvider {
    private PurchasesState purchasesState;

    public PurchasesStateCache(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "purchasesState");
        this.purchasesState = purchasesState;
    }

    public static /* synthetic */ PurchasesStateCache copy$default(PurchasesStateCache purchasesStateCache, PurchasesState purchasesState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            purchasesState = purchasesStateCache.purchasesState;
        }
        return purchasesStateCache.copy(purchasesState);
    }

    public final PurchasesState component1() {
        return this.purchasesState;
    }

    public final PurchasesStateCache copy(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "purchasesState");
        return new PurchasesStateCache(purchasesState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchasesStateCache) && Intrinsics.areEqual(this.purchasesState, ((PurchasesStateCache) obj).purchasesState);
    }

    @Override // com.revenuecat.purchases.PurchasesStateProvider
    public synchronized PurchasesState getPurchasesState() {
        return this.purchasesState;
    }

    public int hashCode() {
        return this.purchasesState.hashCode();
    }

    public synchronized void setPurchasesState(PurchasesState purchasesState) {
        Intrinsics.checkNotNullParameter(purchasesState, "<set-?>");
        this.purchasesState = purchasesState;
    }

    public String toString() {
        return "PurchasesStateCache(purchasesState=" + this.purchasesState + ')';
    }
}
