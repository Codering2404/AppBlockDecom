package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AdSelectionConfig {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f51115h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AdSelectionConfig f51116i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdTechIdentifier f51117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f51118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f51119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdSelectionSignals f51120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AdSelectionSignals f51121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f51122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Uri f51123g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdSelectionConfig a() {
            return AdSelectionConfig.f51116i;
        }

        private Companion() {
        }
    }

    static {
        AdTechIdentifier adTechIdentifier = new AdTechIdentifier("");
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        List listEmptyList = CollectionsKt.emptyList();
        AdSelectionSignals adSelectionSignals = new AdSelectionSignals("");
        AdSelectionSignals adSelectionSignals2 = new AdSelectionSignals("");
        Map mapEmptyMap = MapsKt.emptyMap();
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        f51116i = new AdSelectionConfig(adTechIdentifier, EMPTY, listEmptyList, adSelectionSignals, adSelectionSignals2, mapEmptyMap, EMPTY);
    }

    public AdSelectionConfig(AdTechIdentifier seller, Uri decisionLogicUri, List customAudienceBuyers, AdSelectionSignals adSelectionSignals, AdSelectionSignals sellerSignals, Map perBuyerSignals, Uri trustedScoringSignalsUri) {
        Intrinsics.checkNotNullParameter(seller, "seller");
        Intrinsics.checkNotNullParameter(decisionLogicUri, "decisionLogicUri");
        Intrinsics.checkNotNullParameter(customAudienceBuyers, "customAudienceBuyers");
        Intrinsics.checkNotNullParameter(adSelectionSignals, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(sellerSignals, "sellerSignals");
        Intrinsics.checkNotNullParameter(perBuyerSignals, "perBuyerSignals");
        Intrinsics.checkNotNullParameter(trustedScoringSignalsUri, "trustedScoringSignalsUri");
        this.f51117a = seller;
        this.f51118b = decisionLogicUri;
        this.f51119c = customAudienceBuyers;
        this.f51120d = adSelectionSignals;
        this.f51121e = sellerSignals;
        this.f51122f = perBuyerSignals;
        this.f51123g = trustedScoringSignalsUri;
    }

    private final List b(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AdTechIdentifier) it.next()).a());
        }
        return arrayList;
    }

    private final Map c(Map map) {
        HashMap map2 = new HashMap();
        for (AdTechIdentifier adTechIdentifier : map.keySet()) {
            android.adservices.common.AdTechIdentifier adTechIdentifierA = adTechIdentifier.a();
            AdSelectionSignals adSelectionSignals = (AdSelectionSignals) map.get(adTechIdentifier);
            map2.put(adTechIdentifierA, adSelectionSignals != null ? adSelectionSignals.a() : null);
        }
        return map2;
    }

    public final android.adservices.adselection.AdSelectionConfig d() {
        android.adservices.adselection.AdSelectionConfig adSelectionConfigBuild = i.a().setAdSelectionSignals(this.f51120d.a()).setCustomAudienceBuyers(b(this.f51119c)).setDecisionLogicUri(this.f51118b).setSeller(this.f51117a.a()).setPerBuyerSignals(c(this.f51122f)).setSellerSignals(this.f51121e.a()).setTrustedScoringSignalsUri(this.f51123g).build();
        Intrinsics.checkNotNullExpressionValue(adSelectionConfigBuild, "Builder()\n            .s…Uri)\n            .build()");
        return adSelectionConfigBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        return Intrinsics.areEqual(this.f51117a, adSelectionConfig.f51117a) && Intrinsics.areEqual(this.f51118b, adSelectionConfig.f51118b) && Intrinsics.areEqual(this.f51119c, adSelectionConfig.f51119c) && Intrinsics.areEqual(this.f51120d, adSelectionConfig.f51120d) && Intrinsics.areEqual(this.f51121e, adSelectionConfig.f51121e) && Intrinsics.areEqual(this.f51122f, adSelectionConfig.f51122f) && Intrinsics.areEqual(this.f51123g, adSelectionConfig.f51123g);
    }

    public int hashCode() {
        return (((((((((((this.f51117a.hashCode() * 31) + this.f51118b.hashCode()) * 31) + this.f51119c.hashCode()) * 31) + this.f51120d.hashCode()) * 31) + this.f51121e.hashCode()) * 31) + this.f51122f.hashCode()) * 31) + this.f51123g.hashCode();
    }

    public String toString() {
        return "AdSelectionConfig: seller=" + this.f51117a + ", decisionLogicUri='" + this.f51118b + "', customAudienceBuyers=" + this.f51119c + ", adSelectionSignals=" + this.f51120d + ", sellerSignals=" + this.f51121e + ", perBuyerSignals=" + this.f51122f + ", trustedScoringSignalsUri=" + this.f51123g;
    }
}
