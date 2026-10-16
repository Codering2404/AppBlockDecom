package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
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
public final class BasicMarqueeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec b(int i3, float f3, int i4, int i5, float f4, Density density) {
        TweenSpec tweenSpecC = c(Math.abs(density.M1(f4)), f3, i5);
        long jC = StartOffset.c((-i5) + i4, 0, 2, null);
        return i3 == Integer.MAX_VALUE ? AnimationSpecKt.e(tweenSpecC, null, jC, 2, null) : AnimationSpecKt.h(i3, tweenSpecC, null, jC, 4, null);
    }

    private static final TweenSpec c(float f3, float f4, int i3) {
        return AnimationSpecKt.m((int) Math.ceil(f4 / (f3 / 1000.0f)), i3, EasingKt.e());
    }
}
