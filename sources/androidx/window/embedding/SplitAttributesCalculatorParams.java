package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SplitAttributesCalculatorParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowMetrics f54262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Configuration f54263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowLayoutInfo f54264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SplitAttributes f54265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f54266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f54267f;

    public String toString() {
        return SplitAttributesCalculatorParams.class.getSimpleName() + ":{windowMetrics=" + this.f54262a + ", configuration=" + this.f54263b + ", windowLayoutInfo=" + this.f54264c + ", defaultSplitAttributes=" + this.f54265d + ", areDefaultConstraintsSatisfied=" + this.f54266e + ", tag=" + this.f54267f + '}';
    }
}
