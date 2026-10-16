package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class GraphUtilsKt {
    public static final float a(int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(1010181862, i4, -1, "cz.mobilesoft.coreblock.view.graph.calculateSpaceBetweenBars (GraphUtils.kt:26)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(Dp.g(i3 < 10 ? 16 : 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final void b(DrawScope drawAverageLine, float f3, float f4, long j3, TextLayoutResult textLayoutResult, TextLayoutResult textLayoutResult2, float f5, float f6, long j4, boolean z2, boolean z3, TextLayoutResult textLayoutResult3, boolean z4) {
        Intrinsics.checkNotNullParameter(drawAverageLine, "$this$drawAverageLine");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawAverageLine.b() & 4294967295L));
        float f7 = 3;
        float fM1 = drawAverageLine.M1(Dp.g(f7));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawAverageLine.b() >> 32)) - f5;
        float f8 = fIntBitsToFloat - ((f3 / f4) * fIntBitsToFloat);
        DrawScope.L0(drawAverageLine, j3, Offset.e((((long) Float.floatToRawIntBits((!z2 || textLayoutResult == null) ? 0.0f : ((int) (textLayoutResult.B() >> 32)) + f6)) << 32) | (((long) Float.floatToRawIntBits(f8)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(f8)) & 4294967295L)), fM1, 0, z3 ? PathEffect.f25832a.a(new float[]{30.0f, 15.0f}, 15.0f) : null, 0.0f, null, 0, 464, null);
        if (textLayoutResult3 != null) {
            int iB = (int) (textLayoutResult3.B() >> 32);
            TextPainterKt.b(drawAverageLine, textLayoutResult3, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits((f8 - ((int) (textLayoutResult3.B() & 4294967295L))) - f6)) & 4294967295L) | (((long) Float.floatToRawIntBits(z4 ? (fIntBitsToFloat2 - iB) - f6 : 0.0f)) << 32)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
        }
        if (z2) {
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (drawAverageLine.b() >> 32));
            if (textLayoutResult != null) {
                TextPainterKt.b(drawAverageLine, textLayoutResult, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(f8 - (((int) (textLayoutResult.B() & 4294967295L)) / 2))) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
            }
            if (textLayoutResult2 != null) {
                int iB2 = (int) (textLayoutResult2.B() >> 32);
                int iB3 = (int) (textLayoutResult2.B() & 4294967295L);
                Path pathA = AndroidPath_androidKt.a();
                float f9 = iB2;
                float f10 = (fIntBitsToFloat3 - f6) - f9;
                float f11 = iB3 / 2;
                float f12 = f8 - f11;
                float f13 = f12 - f6;
                pathA.a(f10, f13);
                pathA.c(fIntBitsToFloat3, f13);
                float f14 = f11 + f8 + f6;
                pathA.c(fIntBitsToFloat3, f14);
                pathA.c(f10, f14);
                pathA.c((fIntBitsToFloat3 - (f7 * f6)) - f9, f8);
                pathA.close();
                DrawScope.u0(drawAverageLine, pathA, j4, 0.0f, null, null, 0, 60, null);
                TextPainterKt.b(drawAverageLine, textLayoutResult2, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(f10)) << 32) | (((long) Float.floatToRawIntBits(f12)) & 4294967295L)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
            }
        }
    }

    public static final void d(DrawScope drawScope, List axisData, float f3, float f4, long j3, Map map) {
        DrawScope drawAxis = drawScope;
        Map verticalLabelsLayoutResultsMap = map;
        Intrinsics.checkNotNullParameter(drawAxis, "$this$drawAxis");
        Intrinsics.checkNotNullParameter(axisData, "axisData");
        Intrinsics.checkNotNullParameter(verticalLabelsLayoutResultsMap, "verticalLabelsLayoutResultsMap");
        long jB = drawAxis.b();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jB & 4294967295L));
        Iterator it = axisData.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            GraphData.AxisData axisData2 = (GraphData.AxisData) it.next();
            float f5 = (fIntBitsToFloat - f4) + f3;
            Map map2 = verticalLabelsLayoutResultsMap;
            DrawScope.L0(drawAxis, j3, Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(size)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(size)) & 4294967295L)), drawAxis.M1(Dp.g(1)), 0, null, 0.0f, null, 0, 496, null);
            TextLayoutResult textLayoutResult = (TextLayoutResult) map2.get(axisData2.a());
            if (textLayoutResult != null) {
                TextPainterKt.b(drawScope, textLayoutResult, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(size - (((int) (textLayoutResult.B() & 4294967295L)) / 2))) & 4294967295L)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
            }
            size += fIntBitsToFloat2 / (axisData.size() - 1);
            drawAxis = drawScope;
            verticalLabelsLayoutResultsMap = map2;
        }
    }

    public static final long e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(865483433, i3, -1, "cz.mobilesoft.coreblock.view.graph.<get-avgTextBackground> (GraphUtils.kt:50)");
        }
        long jG = ComposeColorsKt.j(composer, 0).G();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jG;
    }

    public static final float f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(525034210, i3, -1, "cz.mobilesoft.coreblock.view.graph.<get-avgTextPadding> (GraphUtils.kt:46)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(Dp.g(4));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final float g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1543513944, i3, -1, "cz.mobilesoft.coreblock.view.graph.<get-axisPadding> (GraphUtils.kt:38)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(Dp.g(4));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final float h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(662696780, i3, -1, "cz.mobilesoft.coreblock.view.graph.<get-barCornerRadiusPx> (GraphUtils.kt:42)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(Dp.g(8));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final float i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(869339330, i3, -1, "cz.mobilesoft.coreblock.view.graph.<get-spaceForAxisLabels> (GraphUtils.kt:31)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(Dp.g(44));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final float j(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(955940034, i3, -1, "cz.mobilesoft.coreblock.view.graph.<get-tinySpaceForAxisLabels> (GraphUtils.kt:34)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(Dp.g(40));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final TextLayoutResult k(TextMeasurer textMeasurer, long j3, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        if (ComposerKt.M()) {
            ComposerKt.U(1990346241, i3, -1, "cz.mobilesoft.coreblock.view.graph.measureAvgLabel (GraphUtils.kt:185)");
        }
        String strB = StringResources_androidKt.b(R.string.w2, composer, 0);
        boolean z2 = (((i3 & 112) ^ 48) > 32 && composer.f(j3)) || (i3 & 48) == 32;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            Object textStyle = new TextStyle(j3, TextUnitKt.i(11), FontWeight.f29233b.h(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null);
            composer.w(textStyle);
            objG = textStyle;
        }
        TextStyle textStyle2 = (TextStyle) objG;
        boolean Z = composer.Z(strB) | composer.Z(textStyle2);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = TextMeasurer.d(textMeasurer, new AnnotatedString(strB, null, 2, null), textStyle2, 0, false, 0, null, 0L, null, null, null, false, 2044, null);
            composer.w(objG2);
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textLayoutResult;
    }

    public static final TextLayoutResult l(TextMeasurer textMeasurer, float f3, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        if (ComposerKt.M()) {
            ComposerKt.U(-1115150555, i3, -1, "cz.mobilesoft.coreblock.view.graph.measureAvgValue (GraphUtils.kt:205)");
        }
        String strF = DateHelperExtKt.f((long) (60 * f3), false, false, false, 14, null);
        long jN = ComposeColorsKt.j(composer, 0).n();
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            Object textStyle = new TextStyle(jN, TextUnitKt.i(10), FontWeight.f29233b.h(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null);
            composer.w(textStyle);
            objG = textStyle;
        }
        TextStyle textStyle2 = (TextStyle) objG;
        boolean Z = composer.Z(strF);
        Object objG2 = composer.G();
        if (Z || objG2 == companion.a()) {
            objG2 = TextMeasurer.d(textMeasurer, new AnnotatedString(strF, null, 2, null), textStyle2, 0, false, 0, null, 0L, null, null, null, false, 2044, null);
            composer.w(objG2);
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textLayoutResult;
    }

    public static final Map m(TextMeasurer textMeasurer, TextStyle labelStyle, GraphData graphData, Composer composer, int i3) {
        TextMeasurer textMeasurer2 = textMeasurer;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        Intrinsics.checkNotNullParameter(labelStyle, "labelStyle");
        Intrinsics.checkNotNullParameter(graphData, "graphData");
        if (ComposerKt.M()) {
            ComposerKt.U(-2129543265, i3, -1, "cz.mobilesoft.coreblock.view.graph.measureHorizontalLabels (GraphUtils.kt:227)");
        }
        List listB = graphData.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((GraphData.GraphValueData) it.next()).d());
        }
        int i4 = 0;
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer2.Z(textMeasurer2)) || (i3 & 6) == 4) | composer2.Z(arrayList);
        Object objG = composer2.G();
        if (Z || objG == Composer.f23746a.a()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            int size = arrayList.size();
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                int i5 = i4 + 1;
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                linkedHashMap2.put(obj, TextMeasurer.d(textMeasurer2, new AnnotatedString((String) obj, null, 2, null), labelStyle, 0, false, 0, null, 0L, null, null, null, false, 2044, null));
                textMeasurer2 = textMeasurer;
                linkedHashMap = linkedHashMap2;
                i4 = i5;
                size = size;
                arrayList = arrayList;
                composer2 = composer;
            }
            Composer composer3 = composer2;
            LinkedHashMap linkedHashMap3 = linkedHashMap;
            composer3.w(linkedHashMap3);
            objG = linkedHashMap3;
        }
        Map map = (Map) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return map;
    }

    public static final Map n(TextMeasurer textMeasurer, TextStyle labelStyle, GraphData graphData, Composer composer, int i3) {
        TextMeasurer textMeasurer2 = textMeasurer;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        Intrinsics.checkNotNullParameter(labelStyle, "labelStyle");
        Intrinsics.checkNotNullParameter(graphData, "graphData");
        if (ComposerKt.M()) {
            ComposerKt.U(-868001082, i3, -1, "cz.mobilesoft.coreblock.view.graph.measureHorizontalScreenTimeLabels (GraphUtils.kt:245)");
        }
        List listB = graphData.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((GraphData.GraphValueData) it.next()).d());
        }
        List listB2 = graphData.b();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB2, 10));
        Iterator it2 = listB2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((GraphData.GraphValueData) it2.next()).a());
        }
        int i4 = 0;
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer2.Z(textMeasurer2)) || (i3 & 6) == 4) | composer2.Z(arrayList);
        Object objG = composer2.G();
        if (Z || objG == Composer.f23746a.a()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            int size = arrayList.size();
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                int i5 = i4 + 1;
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                linkedHashMap2.put(obj, TextMeasurer.d(textMeasurer2, new AnnotatedString((String) arrayList2.get(arrayList.indexOf((String) obj)), null, 2, null), labelStyle, 0, false, 0, null, 0L, null, null, null, false, 2044, null));
                textMeasurer2 = textMeasurer;
                linkedHashMap = linkedHashMap2;
                i4 = i5;
                arrayList = arrayList;
                size = size;
                arrayList2 = arrayList2;
                composer2 = composer;
            }
            Composer composer3 = composer2;
            LinkedHashMap linkedHashMap3 = linkedHashMap;
            composer3.w(linkedHashMap3);
            objG = linkedHashMap3;
        }
        Map map = (Map) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return map;
    }

    public static final Map o(TextMeasurer textMeasurer, TextStyle labelStyle, GraphData graphData, Composer composer, int i3) {
        TextMeasurer textMeasurer2 = textMeasurer;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        Intrinsics.checkNotNullParameter(labelStyle, "labelStyle");
        Intrinsics.checkNotNullParameter(graphData, "graphData");
        if (ComposerKt.M()) {
            ComposerKt.U(-687017075, i3, -1, "cz.mobilesoft.coreblock.view.graph.measureVerticalLabels (GraphUtils.kt:265)");
        }
        List listH = graphData.h();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listH, 10));
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(((GraphData.AxisData) it.next()).a());
        }
        int i4 = 0;
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer2.Z(textMeasurer2)) || (i3 & 6) == 4) | composer2.Z(arrayList);
        Object objG = composer2.G();
        if (Z || objG == Composer.f23746a.a()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            int size = arrayList.size();
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                int i5 = i4 + 1;
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                linkedHashMap2.put(obj, TextMeasurer.d(textMeasurer2, new AnnotatedString((String) obj, null, 2, null), labelStyle, 0, false, 0, null, 0L, null, null, null, false, 2044, null));
                textMeasurer2 = textMeasurer;
                linkedHashMap = linkedHashMap2;
                i4 = i5;
                size = size;
                arrayList = arrayList;
                composer2 = composer;
            }
            Composer composer3 = composer2;
            LinkedHashMap linkedHashMap3 = linkedHashMap;
            composer3.w(linkedHashMap3);
            objG = linkedHashMap3;
        }
        Map map = (Map) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return map;
    }
}
