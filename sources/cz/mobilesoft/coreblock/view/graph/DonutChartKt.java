package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class DonutChartKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f132739a = Dp.g(4);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection r18, androidx.compose.ui.Modifier r19, float r20, float r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.graph.DonutChartKt.c(cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection, androidx.compose.ui.Modifier, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(List list, DonutChartDataCollection donutChartDataCollection, float f3, float f4, DrawScope drawScope) {
        DrawScope Canvas = drawScope;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fM1 = Canvas.M1(f132739a);
        list.clear();
        float f5 = 0.0f;
        int i3 = 0;
        for (Object obj : donutChartDataCollection.a()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            float fH = h(donutChartDataCollection, i3, f3);
            list.add(new DrawingAngles(f5, fH));
            long jB = ((DonutChartData) obj).b();
            float f6 = fM1 / 2;
            long jE = Offset.e((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L));
            Stroke stroke = new Stroke(fM1, 0.0f, StrokeCap.f25935b.a(), 0, null, 26, null);
            float f7 = fM1;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.b() >> 32)) - f7;
            long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) - f7)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
            float f8 = f5;
            DrawScope.F0(Canvas, jB, f8, fH, false, jE, jD, 0.0f, stroke, null, 0, 832, null);
            f5 = f8 + fH + f4;
            Canvas = drawScope;
            i3 = i4;
            fM1 = f7;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(DonutChartDataCollection donutChartDataCollection, Modifier modifier, float f3, float f4, int i3, int i4, Composer composer, int i5) {
        c(donutChartDataCollection, modifier, f3, f4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final float f(DonutChartDataCollection donutChartDataCollection, float f3) {
        if (donutChartDataCollection.a().isEmpty()) {
            return 0.0f;
        }
        return (donutChartDataCollection.b() / donutChartDataCollection.a().size()) * f3;
    }

    private static final float g(DonutChartDataCollection donutChartDataCollection, float f3) {
        return (f(donutChartDataCollection, f3) / i(donutChartDataCollection, f3)) * 360.0f;
    }

    private static final float h(DonutChartDataCollection donutChartDataCollection, int i3, float f3) {
        float fA = ((DonutChartData) donutChartDataCollection.a().get(i3)).a();
        float f4 = f(donutChartDataCollection, f3);
        return (((fA + f4) / i(donutChartDataCollection, f3)) * 360.0f) - g(donutChartDataCollection, f3);
    }

    private static final float i(DonutChartDataCollection donutChartDataCollection, float f3) {
        return donutChartDataCollection.b() + (donutChartDataCollection.a().size() * f(donutChartDataCollection, f3));
    }
}
