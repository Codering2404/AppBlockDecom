package com.revenuecat.purchases;

import com.revenuecat.purchases.Offerings;
import java.util.Map;
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
final class OfferingsComparableData {
    private final Map<String, Offering> all;
    private final Offering current;
    private final Offerings.Placements placements;
    private final Offerings.Targeting targeting;

    public OfferingsComparableData(Offering offering, Map<String, Offering> all, Offerings.Placements placements, Offerings.Targeting targeting) {
        Intrinsics.checkNotNullParameter(all, "all");
        this.current = offering;
        this.all = all;
        this.placements = placements;
        this.targeting = targeting;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferingsComparableData copy$default(OfferingsComparableData offeringsComparableData, Offering offering, Map map, Offerings.Placements placements, Offerings.Targeting targeting, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offering = offeringsComparableData.current;
        }
        if ((i3 & 2) != 0) {
            map = offeringsComparableData.all;
        }
        if ((i3 & 4) != 0) {
            placements = offeringsComparableData.placements;
        }
        if ((i3 & 8) != 0) {
            targeting = offeringsComparableData.targeting;
        }
        return offeringsComparableData.copy(offering, map, placements, targeting);
    }

    public final Offering component1() {
        return this.current;
    }

    public final Map<String, Offering> component2() {
        return this.all;
    }

    public final Offerings.Placements component3() {
        return this.placements;
    }

    public final Offerings.Targeting component4() {
        return this.targeting;
    }

    public final OfferingsComparableData copy(Offering offering, Map<String, Offering> all, Offerings.Placements placements, Offerings.Targeting targeting) {
        Intrinsics.checkNotNullParameter(all, "all");
        return new OfferingsComparableData(offering, all, placements, targeting);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferingsComparableData)) {
            return false;
        }
        OfferingsComparableData offeringsComparableData = (OfferingsComparableData) obj;
        return Intrinsics.areEqual(this.current, offeringsComparableData.current) && Intrinsics.areEqual(this.all, offeringsComparableData.all) && Intrinsics.areEqual(this.placements, offeringsComparableData.placements) && Intrinsics.areEqual(this.targeting, offeringsComparableData.targeting);
    }

    public final Map<String, Offering> getAll() {
        return this.all;
    }

    public final Offering getCurrent() {
        return this.current;
    }

    public final Offerings.Placements getPlacements() {
        return this.placements;
    }

    public final Offerings.Targeting getTargeting() {
        return this.targeting;
    }

    public int hashCode() {
        Offering offering = this.current;
        int iHashCode = (((offering == null ? 0 : offering.hashCode()) * 31) + this.all.hashCode()) * 31;
        Offerings.Placements placements = this.placements;
        int iHashCode2 = (iHashCode + (placements == null ? 0 : placements.hashCode())) * 31;
        Offerings.Targeting targeting = this.targeting;
        return iHashCode2 + (targeting != null ? targeting.hashCode() : 0);
    }

    public String toString() {
        return "OfferingsComparableData(current=" + this.current + ", all=" + this.all + ", placements=" + this.placements + ", targeting=" + this.targeting + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferingsComparableData(Offerings offerings) {
        this(offerings.getCurrent(), offerings.getAll(), offerings.getPlacements$purchases_defaultsBc8Release(), offerings.getTargeting$purchases_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(offerings, "offerings");
    }
}
