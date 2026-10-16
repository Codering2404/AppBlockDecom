package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
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
public final class BorderKt {
    public static final Modifier e(Modifier modifier, BorderStroke borderStroke, Shape shape) {
        return h(modifier, borderStroke.b(), borderStroke.a(), shape);
    }

    public static final Modifier f(Modifier modifier, float f3, long j3, Shape shape) {
        return h(modifier, f3, new SolidColor(j3, null), shape);
    }

    public static /* synthetic */ Modifier g(Modifier modifier, float f3, long j3, Shape shape, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            shape = RectangleShapeKt.a();
        }
        return f(modifier, f3, j3, shape);
    }

    public static final Modifier h(Modifier modifier, float f3, Brush brush, Shape shape) {
        return modifier.then(new BorderModifierNodeElement(f3, brush, shape, null));
    }

    private static final RoundRect i(float f3, RoundRect roundRect) {
        return new RoundRect(f3, f3, roundRect.j() - f3, roundRect.d() - f3, m(roundRect.h(), f3), m(roundRect.i(), f3), m(roundRect.c(), f3), m(roundRect.b(), f3), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path j(Path path, RoundRect roundRect, float f3, boolean z2) {
        path.reset();
        Path.s(path, roundRect, null, 2, null);
        if (!z2) {
            Path pathA = AndroidPath_androidKt.a();
            Path.s(pathA, i(f3, roundRect), null, 2, null);
            path.v(path, pathA, PathOperation.f25845b.a());
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult k(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.i2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult l(CacheDrawScope cacheDrawScope, final Brush brush, long j3, long j4, boolean z2, float f3) {
        final long jC = z2 ? Offset.f25596b.c() : j3;
        final long jB = z2 ? cacheDrawScope.b() : j4;
        final DrawStyle stroke = z2 ? Fill.f26098a : new Stroke(f3, 0.0f, 0, 0, null, 30, null);
        return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRectBorder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.i2();
                DrawScope.k1(contentDrawScope, brush, jC, jB, 0.0f, stroke, null, 0, 104, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j3, float f3) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j3 >> 32)) - f3);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j3 & 4294967295L)) - f3);
        return CornerRadius.b((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L));
    }
}
