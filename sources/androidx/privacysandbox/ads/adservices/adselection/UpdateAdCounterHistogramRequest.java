package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
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
@Metadata
@ExperimentalFeatures.Ext8OptIn
public final class UpdateAdCounterHistogramRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f51177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdTechIdentifier f51178c;

    public final android.adservices.adselection.UpdateAdCounterHistogramRequest a() {
        w0.a();
        android.adservices.adselection.UpdateAdCounterHistogramRequest updateAdCounterHistogramRequestBuild = v0.a(this.f51176a, this.f51177b, this.f51178c.a()).build();
        Intrinsics.checkNotNullExpressionValue(updateAdCounterHistogramRequestBuild, "Builder(\n               …   )\n            .build()");
        return updateAdCounterHistogramRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAdCounterHistogramRequest)) {
            return false;
        }
        UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest = (UpdateAdCounterHistogramRequest) obj;
        return this.f51176a == updateAdCounterHistogramRequest.f51176a && this.f51177b == updateAdCounterHistogramRequest.f51177b && Intrinsics.areEqual(this.f51178c, updateAdCounterHistogramRequest.f51178c);
    }

    public int hashCode() {
        return (((Long.hashCode(this.f51176a) * 31) + Integer.hashCode(this.f51177b)) * 31) + this.f51178c.hashCode();
    }

    public String toString() {
        int i3 = this.f51177b;
        return "UpdateAdCounterHistogramRequest: adSelectionId=" + this.f51176a + ", adEventType=" + (i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? "Invalid ad event type" : "AD_EVENT_TYPE_CLICK" : "AD_EVENT_TYPE_VIEW" : "AD_EVENT_TYPE_IMPRESSION" : "AD_EVENT_TYPE_WIN") + ", callerAdTech=" + this.f51178c;
    }
}
