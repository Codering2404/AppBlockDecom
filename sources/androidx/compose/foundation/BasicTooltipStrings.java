package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
public final class BasicTooltipStrings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BasicTooltipStrings f4724a = new BasicTooltipStrings();

    private BasicTooltipStrings() {
    }

    public final String a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1416633714, i3, -1, "androidx.compose.foundation.BasicTooltipStrings.description (BasicTooltip.android.kt:26)");
        }
        String strB = StringResources_androidKt.b(R.string.f5119a, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strB;
    }

    public final String b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(187295226, i3, -1, "androidx.compose.foundation.BasicTooltipStrings.label (BasicTooltip.android.kt:24)");
        }
        String strB = StringResources_androidKt.b(R.string.f5120b, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strB;
    }
}
