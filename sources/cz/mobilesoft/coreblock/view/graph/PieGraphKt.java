package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainterKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PieGraphKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Modifier modifier, Map map, float f3, float f4, int i3, int i4, Composer composer, int i5) {
        d(modifier, map, f3, f4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(float f3, long j3, float f4, Map map, int i3, TextLayoutResult textLayoutResult, float f5, VectorPainter vectorPainter, float f6, long j4, ColorFilter colorFilter, TextLayoutResult textLayoutResult2, VectorPainter vectorPainter2, long j5, ColorFilter colorFilter2, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.b() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.b() & 4294967295L));
        float fMin = Math.min(fIntBitsToFloat, fIntBitsToFloat2) * f3;
        float f7 = fMin / 2.0f;
        float f8 = 2;
        float f9 = fIntBitsToFloat / f8;
        float f10 = fIntBitsToFloat2 / f8;
        float f11 = f9 - f7;
        long jE = Offset.e((((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f10 - f7)) & 4294967295L));
        long jD = Size.d((((long) Float.floatToRawIntBits(fMin)) & 4294967295L) | (Float.floatToRawIntBits(fMin) << 32));
        float f12 = -90.0f;
        DrawScope.F0(Canvas, j3, -90.0f, 360.0f, false, jE, jD, 0.0f, new Stroke(f4, 0.0f, 0, 0, null, 30, null), null, 0, 832, null);
        for (Map.Entry entry : map.entrySet()) {
            float fDoubleValue = (((float) ((Number) entry.getValue()).doubleValue()) / i3) * 360.0f;
            DrawScope.F0(Canvas, ((AppDistractionType) entry.getKey()).m1357getColor0d7_KjU(), f12, fDoubleValue, false, jE, jD, 0.0f, new Stroke(f4, 0.0f, 0, 0, null, 30, null), null, 0, 832, null);
            f12 += fDoubleValue;
        }
        int iB = (int) (textLayoutResult.B() & 4294967295L);
        float f13 = f4 / f8;
        h(Canvas, vectorPainter, f11 + f4, f10 + Math.max(f5, iB) + f13, f5, f6, textLayoutResult, j4, iB, colorFilter);
        int iB2 = (int) (textLayoutResult2.B() & 4294967295L);
        h(Canvas, vectorPainter2, ((((f9 + f7) - f4) - ((int) (textLayoutResult2.B() >> 32))) - f5) - f6, (f10 - Math.max(f5, iB2)) - f13, f5, 0.0f, textLayoutResult2, j5, iB2, colorFilter2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, Map map, float f3, float f4, int i3, int i4, Composer composer, int i5) {
        d(modifier, map, f3, f4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void h(DrawScope drawScope, VectorPainter vectorPainter, float f3, float f4, float f5, float f6, TextLayoutResult textLayoutResult, long j3, int i3, ColorFilter colorFilter) {
        float f7 = f4 - (f5 / 2);
        drawScope.Q1().e().e(f3, f7);
        try {
            Painter.k(vectorPainter, drawScope, vectorPainter.l(), 0.0f, colorFilter, 2, null);
            drawScope.Q1().e().e(-f3, -f7);
            TextPainterKt.b(drawScope, textLayoutResult, (250 & 2) != 0 ? Color.f25715b.k() : j3, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(f3 + (f5 + f6))) << 32) | (((long) Float.floatToRawIntBits(f4 - (i3 / 2))) & 4294967295L)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
        } catch (Throwable th) {
            drawScope.Q1().e().e(-f3, -f7);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(androidx.compose.ui.Modifier r42, final java.util.Map r43, float r44, float r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.graph.PieGraphKt.d(androidx.compose.ui.Modifier, java.util.Map, float, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
