package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
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
public final class DiscountState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f99946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f99947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CampaignSource f99948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RevenueCatOffering f99949d;

    public DiscountState(Long l3, long j3, CampaignSource campaignSource, RevenueCatOffering revenueCatOffering) {
        Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
        this.f99946a = l3;
        this.f99947b = j3;
        this.f99948c = campaignSource;
        this.f99949d = revenueCatOffering;
    }

    public static /* synthetic */ DiscountState b(DiscountState discountState, Long l3, long j3, CampaignSource campaignSource, RevenueCatOffering revenueCatOffering, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = discountState.f99946a;
        }
        if ((i3 & 2) != 0) {
            j3 = discountState.f99947b;
        }
        if ((i3 & 4) != 0) {
            campaignSource = discountState.f99948c;
        }
        if ((i3 & 8) != 0) {
            revenueCatOffering = discountState.f99949d;
        }
        return discountState.a(l3, j3, campaignSource, revenueCatOffering);
    }

    public final DiscountState a(Long l3, long j3, CampaignSource campaignSource, RevenueCatOffering revenueCatOffering) {
        Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
        return new DiscountState(l3, j3, campaignSource, revenueCatOffering);
    }

    public final long c() {
        return this.f99947b;
    }

    public final CampaignSource d() {
        return this.f99948c;
    }

    public final Long e() {
        return this.f99946a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiscountState)) {
            return false;
        }
        DiscountState discountState = (DiscountState) obj;
        return Intrinsics.areEqual(this.f99946a, discountState.f99946a) && this.f99947b == discountState.f99947b && this.f99948c == discountState.f99948c && this.f99949d == discountState.f99949d;
    }

    public int hashCode() {
        Long l3 = this.f99946a;
        int iHashCode = (((((l3 == null ? 0 : l3.hashCode()) * 31) + Long.hashCode(this.f99947b)) * 31) + this.f99948c.hashCode()) * 31;
        RevenueCatOffering revenueCatOffering = this.f99949d;
        return iHashCode + (revenueCatOffering != null ? revenueCatOffering.hashCode() : 0);
    }

    public String toString() {
        return "DiscountState(remainingTime=" + this.f99946a + ", campaignId=" + this.f99947b + ", campaignSource=" + this.f99948c + ", currentDiscountOffering=" + this.f99949d + ")";
    }

    public /* synthetic */ DiscountState(Long l3, long j3, CampaignSource campaignSource, RevenueCatOffering revenueCatOffering, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? -1L : j3, (i3 & 4) != 0 ? CampaignSource.None : campaignSource, (i3 & 8) != 0 ? null : revenueCatOffering);
    }
}
