package androidx.glance;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.color.ColorProviders;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GlanceTheme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlanceTheme f37608a = new GlanceTheme();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37609b = 0;

    private GlanceTheme() {
    }

    public final ColorProviders a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2066266949, i3, -1, "androidx.glance.GlanceTheme.<get-colors> (GlanceTheme.kt:30)");
        }
        ColorProviders colorProviders = (ColorProviders) composer.q(CompositionLocalsKt.a());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return colorProviders;
    }
}
