package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Density;
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
public final class TextFieldCoreModifierKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f10448a = Dp.g(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect d(Density density, Rect rect, boolean z2, int i3) {
        return Rect.h(rect, z2 ? i3 - rect.p() : rect.o(), 0.0f, (z2 ? i3 - rect.p() : rect.o()) + density.z0(f10448a), 0.0f, 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(Brush brush) {
        return ((brush instanceof SolidColor) && ((SolidColor) brush).a() == 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(float f3) {
        if (Float.isNaN(f3) || Float.isInfinite(f3)) {
            return f3;
        }
        return (float) (f3 > 0.0f ? Math.ceil(f3) : Math.floor(f3));
    }
}
