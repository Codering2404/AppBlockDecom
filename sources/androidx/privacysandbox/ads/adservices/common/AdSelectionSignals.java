package androidx.privacysandbox.ads.adservices.common;

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
public final class AdSelectionSignals {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f51198a;

    public AdSelectionSignals(String signals) {
        Intrinsics.checkNotNullParameter(signals, "signals");
        this.f51198a = signals;
    }

    public final android.adservices.common.AdSelectionSignals a() {
        android.adservices.common.AdSelectionSignals adSelectionSignalsFromString = android.adservices.common.AdSelectionSignals.fromString(this.f51198a);
        Intrinsics.checkNotNullExpressionValue(adSelectionSignalsFromString, "fromString(signals)");
        return adSelectionSignalsFromString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSelectionSignals) {
            return Intrinsics.areEqual(this.f51198a, ((AdSelectionSignals) obj).f51198a);
        }
        return false;
    }

    public int hashCode() {
        return this.f51198a.hashCode();
    }

    public String toString() {
        return "AdSelectionSignals: " + this.f51198a;
    }
}
