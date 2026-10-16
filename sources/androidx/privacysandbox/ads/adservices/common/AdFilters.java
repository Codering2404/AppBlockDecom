package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdFilters;
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
public final class AdFilters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrequencyCapFilters f51197a;

    public final android.adservices.common.AdFilters a() {
        AdFilters.Builder builderA = h.a();
        FrequencyCapFilters frequencyCapFilters = this.f51197a;
        android.adservices.common.AdFilters adFiltersBuild = builderA.setFrequencyCapFilters(frequencyCapFilters != null ? frequencyCapFilters.b() : null).build();
        Intrinsics.checkNotNullExpressionValue(adFiltersBuild, "Builder()\n            .s…s())\n            .build()");
        return adFiltersBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdFilters) {
            return Intrinsics.areEqual(this.f51197a, ((AdFilters) obj).f51197a);
        }
        return false;
    }

    public int hashCode() {
        FrequencyCapFilters frequencyCapFilters = this.f51197a;
        if (frequencyCapFilters != null) {
            return frequencyCapFilters.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdFilters: frequencyCapFilters=" + this.f51197a;
    }
}
