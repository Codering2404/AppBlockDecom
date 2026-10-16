package androidx.compose.foundation;

import android.view.ViewConfiguration;
import androidx.compose.ui.unit.Density;
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
public final class EdgeEffectCompat_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f4902a = ViewConfiguration.getScrollFriction();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final double f4903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final double f4904c;

    static {
        double dLog = Math.log(0.78d) / Math.log(0.9d);
        f4903b = dLog;
        f4904c = dLog - 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(Density density, float f3) {
        double density2 = density.getDensity() * 386.0878f * 160.0f * 0.84f;
        double dAbs = Math.abs(f3) * 0.35f;
        float f4 = f4902a;
        return (float) (((double) f4) * density2 * Math.exp((f4903b / f4904c) * Math.log(dAbs / (((double) f4) * density2))));
    }
}
