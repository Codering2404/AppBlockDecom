package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.time.Instant;
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
/* JADX INFO: loaded from: classes3.dex */
@ExperimentalFeatures.Ext10OptIn
@Metadata
public final class FetchAndJoinCustomAudienceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f51221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Instant f51223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Instant f51224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AdSelectionSignals f51225e;

    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest a() {
        g0.a();
        FetchAndJoinCustomAudienceRequest.Builder expirationTime = f0.a(this.f51221a).setName(this.f51222b).setActivationTime(this.f51223c).setExpirationTime(this.f51224d);
        AdSelectionSignals adSelectionSignals = this.f51225e;
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequestBuild = expirationTime.setUserBiddingSignals(adSelectionSignals != null ? adSelectionSignals.a() : null).build();
        Intrinsics.checkNotNullExpressionValue(fetchAndJoinCustomAudienceRequestBuild, "Builder(fetchUri)\n      …s())\n            .build()");
        return fetchAndJoinCustomAudienceRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) obj;
        return Intrinsics.areEqual(this.f51221a, fetchAndJoinCustomAudienceRequest.f51221a) && Intrinsics.areEqual(this.f51222b, fetchAndJoinCustomAudienceRequest.f51222b) && Intrinsics.areEqual(this.f51223c, fetchAndJoinCustomAudienceRequest.f51223c) && Intrinsics.areEqual(this.f51224d, fetchAndJoinCustomAudienceRequest.f51224d) && Intrinsics.areEqual(this.f51225e, fetchAndJoinCustomAudienceRequest.f51225e);
    }

    public int hashCode() {
        int iHashCode = this.f51221a.hashCode() * 31;
        String str = this.f51222b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Instant instant = this.f51223c;
        int iHashCode3 = (iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.f51224d;
        int iHashCode4 = (iHashCode3 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        AdSelectionSignals adSelectionSignals = this.f51225e;
        return iHashCode4 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0);
    }

    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.f51221a + ", name=" + this.f51222b + ", activationTime=" + this.f51223c + ", expirationTime=" + this.f51224d + ", userBiddingSignals=" + this.f51225e;
    }
}
