package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class BlurKt {
    public static final Modifier a(Modifier modifier, final float f3, final float f4, final Shape shape) {
        int iB;
        final boolean z2;
        if (shape != null) {
            iB = TileMode.f25948b.a();
            z2 = true;
        } else {
            iB = TileMode.f25948b.b();
            z2 = false;
        }
        final int i3 = iB;
        float f5 = 0;
        return ((Dp.f(f3, Dp.g(f5)) <= 0 || Dp.f(f4, Dp.g(f5)) <= 0) && !z2) ? modifier : GraphicsLayerModifierKt.a(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                float fM1 = graphicsLayerScope.M1(f3);
                float fM12 = graphicsLayerScope.M1(f4);
                graphicsLayerScope.f((fM1 <= 0.0f || fM12 <= 0.0f) ? null : RenderEffectKt.a(fM1, fM12, i3));
                Shape shapeA = shape;
                if (shapeA == null) {
                    shapeA = RectangleShapeKt.a();
                }
                graphicsLayerScope.I1(shapeA);
                graphicsLayerScope.B(z2);
            }
        });
    }

    public static final Modifier b(Modifier modifier, float f3, Shape shape) {
        return a(modifier, f3, f3, shape);
    }

    public static /* synthetic */ Modifier c(Modifier modifier, float f3, BlurredEdgeTreatment blurredEdgeTreatment, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.c(BlurredEdgeTreatment.f25380b.a());
        }
        return b(modifier, f3, blurredEdgeTreatment.h());
    }
}
