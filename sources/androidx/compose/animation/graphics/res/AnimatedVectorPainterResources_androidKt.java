package androidx.compose.animation.graphics.res;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.graphics.vector.AnimatedImageVector;
import androidx.compose.animation.graphics.vector.AnimatedVectorTarget;
import androidx.compose.animation.graphics.vector.StateVectorConfig;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

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
public final class AnimatedVectorPainterResources_androidKt {
    public static final Painter a(AnimatedImageVector animatedImageVector, boolean z2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1724527265, i3, -1, "androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter (AnimatedVectorPainterResources.android.kt:44)");
        }
        Painter painterB = b(animatedImageVector, z2, ComposableSingletons$AnimatedVectorPainterResources_androidKt.f4386a.a(), composer, (i3 & 112) | (i3 & 14) | 384);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return painterB;
    }

    public static final Painter b(final AnimatedImageVector animatedImageVector, final boolean z2, final Function4 function4, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(546888339, i3, -1, "androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter (AnimatedVectorPainterResources.android.kt:56)");
        }
        VectorPainter vectorPainterI = VectorPainterKt.i(animatedImageVector.a().f(), animatedImageVector.a().e(), animatedImageVector.a().m(), animatedImageVector.a().l(), animatedImageVector.a().h(), animatedImageVector.a().k(), animatedImageVector.a().j(), true, ComposableLambdaKt.e(10512245, true, new Function4<Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.animation.graphics.res.AnimatedVectorPainterResources_androidKt$rememberAnimatedVectorPainter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public final void c(float f3, float f4, Composer composer2, int i4) {
                if (!composer2.r((i4 & 129) != 128, i4 & 1)) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(10512245, i4, -1, "androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter.<anonymous> (AnimatedVectorPainterResources.android.kt:67)");
                }
                Transition transitionJ = TransitionKt.j(Boolean.valueOf(z2), animatedImageVector.a().h(), composer2, 0, 0);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                composer2.a0(244958144);
                List listB = animatedImageVector.b();
                AnimatedImageVector animatedImageVector2 = animatedImageVector;
                int size = listB.size();
                for (int i5 = 0; i5 < size; i5++) {
                    AnimatedVectorTarget animatedVectorTarget = (AnimatedVectorTarget) listB.get(i5);
                    StateVectorConfig stateVectorConfigC = animatedVectorTarget.a().c(transitionJ, animatedImageVector2.c(), composer2, 0);
                    StateVectorConfig stateVectorConfig = (StateVectorConfig) linkedHashMap.get(animatedVectorTarget.b());
                    if (stateVectorConfig != null) {
                        stateVectorConfig.b(stateVectorConfigC);
                    } else {
                        linkedHashMap.put(animatedVectorTarget.b(), stateVectorConfigC);
                    }
                }
                composer2.U();
                function4.invoke(animatedImageVector.a().i(), linkedHashMap, composer2, 0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c(((Number) obj).floatValue(), ((Number) obj2).floatValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }
        }, composer, 54), composer, 113246208, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return vectorPainterI;
    }
}
