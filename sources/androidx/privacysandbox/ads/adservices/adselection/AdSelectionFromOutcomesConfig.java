package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
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
/* JADX INFO: loaded from: classes3.dex */
@ExperimentalFeatures.Ext10OptIn
@Metadata
public final class AdSelectionFromOutcomesConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdTechIdentifier f51124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f51125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdSelectionSignals f51126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f51127d;

    public final android.adservices.adselection.AdSelectionFromOutcomesConfig a() {
        android.adservices.adselection.AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfigBuild = o.a().setSelectionSignals(this.f51126c.a()).setAdSelectionIds(this.f51125b).setSelectionLogicUri(this.f51127d).setSeller(this.f51124a.a()).build();
        Intrinsics.checkNotNullExpressionValue(adSelectionFromOutcomesConfigBuild, "Builder()\n            .s…s())\n            .build()");
        return adSelectionFromOutcomesConfigBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionFromOutcomesConfig)) {
            return false;
        }
        AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig = (AdSelectionFromOutcomesConfig) obj;
        return Intrinsics.areEqual(this.f51124a, adSelectionFromOutcomesConfig.f51124a) && Intrinsics.areEqual(this.f51125b, adSelectionFromOutcomesConfig.f51125b) && Intrinsics.areEqual(this.f51126c, adSelectionFromOutcomesConfig.f51126c) && Intrinsics.areEqual(this.f51127d, adSelectionFromOutcomesConfig.f51127d);
    }

    public int hashCode() {
        return (((((this.f51124a.hashCode() * 31) + this.f51125b.hashCode()) * 31) + this.f51126c.hashCode()) * 31) + this.f51127d.hashCode();
    }

    public String toString() {
        return "AdSelectionFromOutcomesConfig: seller=" + this.f51124a + ", adSelectionIds='" + this.f51125b + "', adSelectionSignals=" + this.f51126c + ", selectionLogicUri=" + this.f51127d;
    }
}
