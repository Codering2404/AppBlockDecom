package androidx.compose.animation;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class SingleValueAnimationKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SpringSpec f3713a = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);

    public static final State a(long j3, AnimationSpec animationSpec, String str, Function1 function1, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = f3713a;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i4 & 4) != 0) {
            str = "ColorAnimation";
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.M()) {
            ComposerKt.U(-451899108, i3, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:60)");
        }
        boolean Z = composer.Z(Color.w(j3));
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = (TwoWayConverter) ColorVectorConverterKt.a(Color.f25715b).invoke(Color.w(j3));
            composer.w(objG);
        }
        int i5 = i3 << 6;
        State stateE = AnimateAsStateKt.e(Color.n(j3), (TwoWayConverter) objG, animationSpec2, null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i5) | (i5 & 458752), 8);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateE;
    }
}
