package androidx.privacysandbox.ads.adservices.common;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.time.Duration;
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
public final class KeyedFrequencyCap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f51205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f51206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Duration f51207c;

    public final android.adservices.common.KeyedFrequencyCap a() {
        t.a();
        android.adservices.common.KeyedFrequencyCap keyedFrequencyCapBuild = s.a(this.f51205a, this.f51206b, this.f51207c).build();
        Intrinsics.checkNotNullExpressionValue(keyedFrequencyCapBuild, "Builder(adCounterKey, ma…val)\n            .build()");
        return keyedFrequencyCapBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyedFrequencyCap)) {
            return false;
        }
        KeyedFrequencyCap keyedFrequencyCap = (KeyedFrequencyCap) obj;
        return this.f51205a == keyedFrequencyCap.f51205a && this.f51206b == keyedFrequencyCap.f51206b && Intrinsics.areEqual(this.f51207c, keyedFrequencyCap.f51207c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f51205a) * 31) + Integer.hashCode(this.f51206b)) * 31) + this.f51207c.hashCode();
    }

    public String toString() {
        return "KeyedFrequencyCap: adCounterKey=" + this.f51205a + ", maxCount=" + this.f51206b + ", interval=" + this.f51207c;
    }
}
