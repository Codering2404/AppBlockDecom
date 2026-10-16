package cz.mobilesoft.coreblock.view.graph;

import android.graphics.PointF;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public final class TrendGraphKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0182  */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(androidx.compose.ui.Modifier r52, final cz.mobilesoft.coreblock.view.graph.GraphData r53, cz.mobilesoft.coreblock.enums.AppDistractionType r54, long r55, float r57, androidx.compose.runtime.Composer r58, final int r59, final int r60) {
        /*
            Method dump skipped, instruction units count: 845
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.graph.TrendGraphKt.c(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.view.graph.GraphData, cz.mobilesoft.coreblock.enums.AppDistractionType, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(GraphData graphData, float f3, float f4, long j3, Map map, long j4, Map map2, TextLayoutResult textLayoutResult, TextLayoutResult textLayoutResult2, float f5, long j5, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fD = graphData.d();
        GraphUtilsKt.d(Canvas, graphData.h(), f3, f4, j3, map);
        g(Canvas, graphData, fD, f3, f4, j4);
        h(Canvas, graphData, map2);
        if (graphData.a() != null) {
            GraphUtilsKt.b(Canvas, graphData.a().floatValue(), graphData.d(), j3, textLayoutResult, textLayoutResult2, f4 + f3, f5, j5, (3840 & Function.MAX_NARGS) != 0, (3840 & 512) != 0, (3840 & 1024) != 0 ? null : null, (3840 & 2048) != 0 ? false : false);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Modifier modifier, GraphData graphData, AppDistractionType appDistractionType, long j3, float f3, int i3, int i4, Composer composer, int i5) {
        c(modifier, graphData, appDistractionType, j3, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void f(GraphData graphData, Path path, Path path2, float f3, float f4, float f5) {
        Path path3 = path;
        if (graphData.b().size() < 2) {
            return;
        }
        List listB = graphData.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator it = listB.iterator();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            float fE = 0.0f;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GraphData.GraphValueData graphValueData = (GraphData.GraphValueData) next;
            if (f5 != 0.0f) {
                fE = (graphValueData.e() / f5) * f4;
            }
            arrayList.add(new PointF((i4 * f3) / (graphData.b().size() - 1), f4 - fE));
            i4 = i5;
        }
        if (arrayList.size() < 2) {
            if (arrayList.isEmpty()) {
                return;
            }
            path3.a(((PointF) CollectionsKt.first((List) arrayList)).x, ((PointF) CollectionsKt.first((List) arrayList)).y);
            path2.a(((PointF) CollectionsKt.first((List) arrayList)).x, ((PointF) CollectionsKt.first((List) arrayList)).y);
            if (arrayList.size() > 1) {
                path3.c(((PointF) CollectionsKt.last((List) arrayList)).x, ((PointF) CollectionsKt.last((List) arrayList)).y);
                path2.c(((PointF) CollectionsKt.last((List) arrayList)).x, ((PointF) CollectionsKt.last((List) arrayList)).y);
                return;
            }
            return;
        }
        path3.a(((PointF) CollectionsKt.first((List) arrayList)).x, ((PointF) CollectionsKt.first((List) arrayList)).y);
        path2.a(((PointF) CollectionsKt.first((List) arrayList)).x, ((PointF) CollectionsKt.first((List) arrayList)).y);
        int size = arrayList.size() - 1;
        while (i3 < size) {
            int i6 = i3 - 1;
            PointF pointF = (PointF) ((i6 < 0 || i6 >= arrayList.size()) ? (PointF) arrayList.get(i3) : arrayList.get(i6));
            PointF pointF2 = (PointF) arrayList.get(i3);
            int i7 = i3 + 1;
            PointF pointF3 = (PointF) arrayList.get(i7);
            int i8 = i3 + 2;
            PointF pointF4 = (PointF) ((i8 < 0 || i8 >= arrayList.size()) ? (PointF) arrayList.get(i7) : arrayList.get(i8));
            float f6 = pointF2.x;
            float f7 = pointF3.x;
            float f8 = ((f7 - pointF.x) / 6.0f) + f6;
            float f9 = pointF2.y;
            float f10 = pointF3.y;
            float f11 = ((f10 - pointF.y) / 6.0f) + f9;
            float f12 = f7 - ((pointF4.x - f6) / 6.0f);
            float f13 = f10 - ((pointF4.y - f9) / 6.0f);
            path3.b(f8, f11, f12, f13, f7, f10);
            path2.b(f8, f11, f12, f13, pointF3.x, pointF3.y);
            i3 = i7;
            path3 = path;
        }
        path2.c(f3, f4);
        path2.c(0.0f, f4);
        path2.close();
    }

    private static final void g(DrawScope drawScope, GraphData graphData, float f3, float f4, float f5, long j3) {
        long jB = drawScope.b();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jB & 4294967295L));
        Path pathA = AndroidPath_androidKt.a();
        Path pathA2 = AndroidPath_androidKt.a();
        f(graphData, pathA, pathA2, (fIntBitsToFloat - f4) - f5, fIntBitsToFloat2, f3);
        DrawScope.F1(drawScope, pathA2, Brush.Companion.c(CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.r(j3, 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(Color.f25715b.j())}), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), TileMode.f25948b.a()), 0.0f, Fill.f26098a, null, 0, 52, null);
        DrawScope.u0(drawScope, pathA, j3, 0.0f, new Stroke(6.0f, 0.0f, StrokeCap.f25935b.b(), StrokeJoin.f25940b.c(), null, 18, null), null, 0, 52, null);
    }

    private static final void h(DrawScope drawScope, GraphData graphData, Map map) {
        long jB = drawScope.b();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jB & 4294967295L));
        List listB = graphData.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((GraphData.GraphValueData) it.next()).d());
        }
        float size = fIntBitsToFloat / r1.size();
        int i3 = 0;
        for (Object obj : CollectionsKt.distinct(arrayList)) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            float f3 = i3 * size;
            TextLayoutResult textLayoutResult = (TextLayoutResult) map.get((String) obj);
            if (textLayoutResult != null) {
                TextPainterKt.b(drawScope, textLayoutResult, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(8)) + fIntBitsToFloat2)) & 4294967295L) | (Float.floatToRawIntBits((f3 + (size / 2)) - (((int) (textLayoutResult.B() >> 32)) / 2)) << 32)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
            }
            i3 = i4;
        }
    }
}
