package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
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
public final class ModalBottomSheetDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ModalBottomSheetDefaults f13149a = new ModalBottomSheetDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f13150b = Dp.g(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AnimationSpec f13151c = AnimationSpecKt.n(300, 0, EasingKt.d(), 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13152d = 8;

    private ModalBottomSheetDefaults() {
    }

    public final AnimationSpec a() {
        return f13151c;
    }

    public final float b() {
        return f13150b;
    }

    public final long c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-112572414, i3, -1, "androidx.compose.material.ModalBottomSheetDefaults.<get-scrimColor> (ModalBottomSheet.kt:539)");
        }
        long jR = Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jR;
    }
}
