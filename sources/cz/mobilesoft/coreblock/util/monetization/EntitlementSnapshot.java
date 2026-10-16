package cz.mobilesoft.coreblock.util.monetization;

import java.util.List;
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
public final class EntitlementSnapshot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f128868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PremiumEntitlement f128869b;

    public EntitlementSnapshot(List activeEntitlements, PremiumEntitlement premiumEntitlement) {
        Intrinsics.checkNotNullParameter(activeEntitlements, "activeEntitlements");
        this.f128868a = activeEntitlements;
        this.f128869b = premiumEntitlement;
    }

    public final List a() {
        return this.f128868a;
    }

    public final PremiumEntitlement b() {
        return this.f128869b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntitlementSnapshot)) {
            return false;
        }
        EntitlementSnapshot entitlementSnapshot = (EntitlementSnapshot) obj;
        return Intrinsics.areEqual(this.f128868a, entitlementSnapshot.f128868a) && Intrinsics.areEqual(this.f128869b, entitlementSnapshot.f128869b);
    }

    public int hashCode() {
        int iHashCode = this.f128868a.hashCode() * 31;
        PremiumEntitlement premiumEntitlement = this.f128869b;
        return iHashCode + (premiumEntitlement == null ? 0 : premiumEntitlement.hashCode());
    }

    public String toString() {
        return "EntitlementSnapshot(activeEntitlements=" + this.f128868a + ", premiumEntitlement=" + this.f128869b + ")";
    }
}
