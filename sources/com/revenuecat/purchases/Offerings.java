package com.revenuecat.purchases;

import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import java.util.Map;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Offerings {
    private final Map<String, Offering> all;
    private final Offering current;
    private final boolean loadedFromDiskCache;
    private final HTTPResponseOriginalSource originalSource;
    private final Placements placements;
    private final Targeting targeting;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Placements {
        private final String fallbackOfferingId;
        private final Map<String, String> offeringIdsByPlacement;

        public Placements(String str, Map<String, String> offeringIdsByPlacement) {
            Intrinsics.checkNotNullParameter(offeringIdsByPlacement, "offeringIdsByPlacement");
            this.fallbackOfferingId = str;
            this.offeringIdsByPlacement = offeringIdsByPlacement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Placements copy$default(Placements placements, String str, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = placements.fallbackOfferingId;
            }
            if ((i3 & 2) != 0) {
                map = placements.offeringIdsByPlacement;
            }
            return placements.copy(str, map);
        }

        public final String component1() {
            return this.fallbackOfferingId;
        }

        public final Map<String, String> component2() {
            return this.offeringIdsByPlacement;
        }

        public final Placements copy(String str, Map<String, String> offeringIdsByPlacement) {
            Intrinsics.checkNotNullParameter(offeringIdsByPlacement, "offeringIdsByPlacement");
            return new Placements(str, offeringIdsByPlacement);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Placements)) {
                return false;
            }
            Placements placements = (Placements) obj;
            return Intrinsics.areEqual(this.fallbackOfferingId, placements.fallbackOfferingId) && Intrinsics.areEqual(this.offeringIdsByPlacement, placements.offeringIdsByPlacement);
        }

        public final String getFallbackOfferingId() {
            return this.fallbackOfferingId;
        }

        public final Map<String, String> getOfferingIdsByPlacement() {
            return this.offeringIdsByPlacement;
        }

        public int hashCode() {
            String str = this.fallbackOfferingId;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.offeringIdsByPlacement.hashCode();
        }

        public String toString() {
            return "Placements(fallbackOfferingId=" + this.fallbackOfferingId + ", offeringIdsByPlacement=" + this.offeringIdsByPlacement + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Targeting {
        private final int revision;
        private final String ruleId;

        public Targeting(int i3, String ruleId) {
            Intrinsics.checkNotNullParameter(ruleId, "ruleId");
            this.revision = i3;
            this.ruleId = ruleId;
        }

        public static /* synthetic */ Targeting copy$default(Targeting targeting, int i3, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = targeting.revision;
            }
            if ((i4 & 2) != 0) {
                str = targeting.ruleId;
            }
            return targeting.copy(i3, str);
        }

        public final int component1() {
            return this.revision;
        }

        public final String component2() {
            return this.ruleId;
        }

        public final Targeting copy(int i3, String ruleId) {
            Intrinsics.checkNotNullParameter(ruleId, "ruleId");
            return new Targeting(i3, ruleId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Targeting)) {
                return false;
            }
            Targeting targeting = (Targeting) obj;
            return this.revision == targeting.revision && Intrinsics.areEqual(this.ruleId, targeting.ruleId);
        }

        public final int getRevision() {
            return this.revision;
        }

        public final String getRuleId() {
            return this.ruleId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.revision) * 31) + this.ruleId.hashCode();
        }

        public String toString() {
            return "Targeting(revision=" + this.revision + ", ruleId=" + this.ruleId + ')';
        }
    }

    public Offerings(Offering offering, Map<String, Offering> all, Placements placements, Targeting targeting, HTTPResponseOriginalSource originalSource, boolean z2) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        this.current = offering;
        this.all = all;
        this.placements = placements;
        this.targeting = targeting;
        this.originalSource = originalSource;
        this.loadedFromDiskCache = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Offerings copy$purchases_defaultsBc8Release$default(Offerings offerings, Offering offering, Map map, Placements placements, Targeting targeting, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offering = offerings.current;
        }
        if ((i3 & 2) != 0) {
            map = offerings.all;
        }
        if ((i3 & 4) != 0) {
            placements = offerings.placements;
        }
        if ((i3 & 8) != 0) {
            targeting = offerings.targeting;
        }
        if ((i3 & 16) != 0) {
            hTTPResponseOriginalSource = offerings.originalSource;
        }
        if ((i3 & 32) != 0) {
            z2 = offerings.loadedFromDiskCache;
        }
        HTTPResponseOriginalSource hTTPResponseOriginalSource2 = hTTPResponseOriginalSource;
        boolean z3 = z2;
        return offerings.copy$purchases_defaultsBc8Release(offering, map, placements, targeting, hTTPResponseOriginalSource2, z3);
    }

    public final Offerings copy$purchases_defaultsBc8Release(Offering offering, Map<String, Offering> all, Placements placements, Targeting targeting, HTTPResponseOriginalSource originalSource, boolean z2) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        return new Offerings(offering, all, placements, targeting, originalSource, z2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Offerings) && Intrinsics.areEqual(new OfferingsComparableData(this), new OfferingsComparableData((Offerings) obj));
    }

    public final Offering get(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return getOffering(identifier);
    }

    public final Map<String, Offering> getAll() {
        return this.all;
    }

    public final Offering getCurrent() {
        return this.current;
    }

    public final Offering getCurrentOfferingForPlacement(String placementId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Placements placements = this.placements;
        if (placements == null) {
            return null;
        }
        String str = placements.getOfferingIdsByPlacement().get(placementId);
        Offering offering = str != null ? getOffering(str) : null;
        String fallbackOfferingId = placements.getFallbackOfferingId();
        Offering offering2 = fallbackOfferingId != null ? getOffering(fallbackOfferingId) : null;
        boolean zContainsKey = placements.getOfferingIdsByPlacement().containsKey(placementId);
        if (offering == null) {
            offering = zContainsKey ? null : offering2;
        }
        if (offering != null) {
            return OfferingsKt.withPresentedContext(offering, placementId, this.targeting);
        }
        return null;
    }

    public final boolean getLoadedFromDiskCache$purchases_defaultsBc8Release() {
        return this.loadedFromDiskCache;
    }

    public final Offering getOffering(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return this.all.get(identifier);
    }

    public final HTTPResponseOriginalSource getOriginalSource$purchases_defaultsBc8Release() {
        return this.originalSource;
    }

    public final Placements getPlacements$purchases_defaultsBc8Release() {
        return this.placements;
    }

    public final Targeting getTargeting$purchases_defaultsBc8Release() {
        return this.targeting;
    }

    public int hashCode() {
        return new OfferingsComparableData(this).hashCode();
    }

    public String toString() {
        return "<Offerings\n current: " + this.current + "\nall:  " + this.all + ",\nplacements: " + this.placements + ",\ntargeting: " + this.targeting + "\n>";
    }

    public /* synthetic */ Offerings(Offering offering, Map map, Placements placements, Targeting targeting, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(offering, map, (i3 & 4) != 0 ? null : placements, (i3 & 8) != 0 ? null : targeting, (i3 & 16) != 0 ? HTTPResponseOriginalSource.MAIN : hTTPResponseOriginalSource, (i3 & 32) != 0 ? false : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offerings(Offering offering, Map<String, Offering> all) {
        this(offering, all, null, null, null, false, 48, null);
        Intrinsics.checkNotNullParameter(all, "all");
    }
}
