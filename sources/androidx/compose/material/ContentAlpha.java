package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
public final class ContentAlpha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContentAlpha f12529a = new ContentAlpha();

    private ContentAlpha() {
    }

    private final float a(float f3, float f4, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1528360391, i3, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:76)");
        }
        long jB = ((Color) composer.q(ContentColorKt.a())).B();
        if (!MaterialTheme.f13091a.a(composer, 6).o() ? ColorKt.j(jB) >= 0.5d : ColorKt.j(jB) <= 0.5d) {
            f3 = f4;
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return f3;
    }

    public final float b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(621183615, i3, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:57)");
        }
        float fA = a(0.38f, 0.38f, composer, ((i3 << 6) & 896) | 54);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fA;
    }

    public final float c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(629162431, i3, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:35)");
        }
        float fA = a(1.0f, 0.87f, composer, ((i3 << 6) & 896) | 54);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fA;
    }

    public final float d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1999054879, i3, -1, "androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:46)");
        }
        float fA = a(0.74f, 0.6f, composer, ((i3 << 6) & 896) | 54);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fA;
    }
}
