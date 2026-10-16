package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class BarGraphKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(final cz.mobilesoft.coreblock.view.graph.GraphData r24, boolean r25, final kotlin.jvm.functions.Function1 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.graph.BarGraphKt.i(cz.mobilesoft.coreblock.view.graph.GraphData, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1) {
        function1.invoke(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, Integer num) {
        function1.invoke(num);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(GraphData graphData, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        i(graphData, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(androidx.compose.ui.Modifier r97, final cz.mobilesoft.coreblock.view.graph.GraphData r98, final cz.mobilesoft.coreblock.view.graph.GraphConfiguration r99, long r100, float r102, kotlin.jvm.functions.Function1 r103, androidx.compose.runtime.Composer r104, final int r105, final int r106) {
        /*
            Method dump skipped, instruction units count: 1179
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.graph.BarGraphKt.m(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.view.graph.GraphData, cz.mobilesoft.coreblock.view.graph.GraphConfiguration, long, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final float f3, int i3, final float f4, final GraphData graphData, float f5, final float f6, final Function1 function1, final float f7, final Map map, final Map map2, final long j3, final long j4, final long j5, final GraphConfiguration graphConfiguration, final float f8, final Map map3, final Color color, final TextLayoutResult textLayoutResult, final TextLayoutResult textLayoutResult2, final TextLayoutResult textLayoutResult3, final float f9, final long j6, final long j7, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i4) {
        int i5;
        Modifier modifier;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer2.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer2.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1062490541, i5, -1, "cz.mobilesoft.coreblock.view.graph.BarChartGraph.<anonymous> (BarGraph.kt:136)");
            }
            final float fL = ((Constraints.l(BoxWithConstraints.c()) - ((i3 - 1) * f3)) - f4) / i3;
            boolean Z = composer2.Z(graphData) | composer2.c(fL) | composer2.c(f3) | composer2.c(f5) | composer2.c(f6);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt.f();
                composer2.w(objG);
            }
            final SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
            Modifier modifierI = SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), f5);
            boolean z2 = function1 != null;
            boolean zI = composer2.I(graphData) | composer2.Z(function1) | composer2.Z(snapshotStateList);
            Object objG2 = composer2.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.view.graph.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BarGraphKt.o(graphData, function1, snapshotStateList, (Modifier) obj);
                    }
                };
                composer2.w(objG2);
            }
            Modifier modifierR = ComposableExtKt.r(modifierI, z2, (Function1) objG2);
            boolean Z2 = composer2.Z(snapshotStateList) | composer2.I(graphData) | composer2.c(f6) | composer2.c(fL) | composer2.c(f3) | composer2.c(f7) | composer2.I(map) | composer2.I(map2) | composer2.f(j3) | composer2.f(j4) | composer2.f(j5) | composer2.I(graphConfiguration) | composer2.c(f8) | composer2.c(f4) | composer2.I(map3) | composer2.Z(color) | composer2.I(textLayoutResult) | composer2.I(textLayoutResult2) | composer2.I(textLayoutResult3) | composer2.c(f9) | composer2.f(j6) | composer2.f(j7);
            Object objG3 = composer2.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                modifier = modifierR;
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.view.graph.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BarGraphKt.p(snapshotStateList, graphData, f6, fL, f3, f7, map, map2, j3, j4, j5, graphConfiguration, f8, f4, map3, j7, color, textLayoutResult, textLayoutResult2, textLayoutResult3, f9, j6, (DrawScope) obj);
                    }
                };
                composer2 = composer;
                composer2.w(objG3);
            } else {
                modifier = modifierR;
            }
            CanvasKt.b(modifier, (Function1) objG3, composer2, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier o(GraphData graphData, Function1 function1, SnapshotStateList snapshotStateList, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SuspendingPointerInputFilterKt.d(applyIf, graphData, new BarGraphKt$BarChartGraph$1$1$1$1(function1, snapshotStateList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final SnapshotStateList snapshotStateList, GraphData graphData, float f3, float f4, float f5, float f6, Map map, Map map2, long j3, long j4, long j5, GraphConfiguration graphConfiguration, float f7, float f8, Map map3, long j6, Color color, TextLayoutResult textLayoutResult, TextLayoutResult textLayoutResult2, TextLayoutResult textLayoutResult3, float f9, long j7, DrawScope Canvas) {
        DrawScope drawScope;
        float f10;
        TextLayoutResult textLayoutResult4;
        TextLayoutResult textLayoutResult5;
        TextLayoutResult textLayoutResult6;
        float f11;
        long j8;
        boolean z2;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        snapshotStateList.clear();
        t(Canvas, graphData, f3, f4, f5, f6, map, map2, j3, j4, j5, graphConfiguration, new Function1() { // from class: cz.mobilesoft.coreblock.view.graph.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BarGraphKt.q(snapshotStateList, (Rect) obj);
            }
        });
        if (graphConfiguration.o()) {
            GraphUtilsKt.d(Canvas, graphData.h(), f7, f8, j3, map3);
        }
        if (!graphConfiguration.j() || graphData.a() == null) {
            drawScope = Canvas;
        } else {
            float fFloatValue = graphData.a().floatValue();
            long jB = color != null ? color.B() : j3;
            float f12 = textLayoutResult != null ? f8 : f8 + f7;
            boolean zO = graphConfiguration.o();
            boolean z3 = color == null;
            GraphConfiguration.CustomAverageLabel customAverageLabelD = graphConfiguration.d();
            if (customAverageLabelD == null || !customAverageLabelD.a()) {
                f10 = f3;
                textLayoutResult4 = textLayoutResult;
                textLayoutResult5 = textLayoutResult2;
                textLayoutResult6 = textLayoutResult3;
                f11 = f9;
                j8 = j7;
                z2 = false;
                drawScope = Canvas;
            } else {
                textLayoutResult4 = textLayoutResult;
                textLayoutResult5 = textLayoutResult2;
                textLayoutResult6 = textLayoutResult3;
                f11 = f9;
                j8 = j7;
                drawScope = Canvas;
                z2 = true;
                f10 = f3;
            }
            GraphUtilsKt.b(drawScope, fFloatValue, f10, jB, textLayoutResult5, textLayoutResult6, f12, f11, j8, zO, z3, textLayoutResult4, z2);
        }
        GraphConfiguration.GraphOverlay graphOverlayI = graphConfiguration.i();
        if (graphOverlayI != null) {
            for (Pair pair : graphOverlayI.b()) {
                w(drawScope, ((Number) pair.e()).floatValue(), ((Number) pair.f()).floatValue(), graphOverlayI.a());
            }
        }
        if (graphConfiguration.q()) {
            v(drawScope, j6, false, 2, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(SnapshotStateList snapshotStateList, Rect it) {
        Intrinsics.checkNotNullParameter(it, "it");
        snapshotStateList.add(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Modifier modifier, GraphData graphData, GraphConfiguration graphConfiguration, long j3, float f3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        m(modifier, graphData, graphConfiguration, j3, f3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void s(DrawScope drawScope, GraphData.GraphValueData graphValueData, long j3, float f3, float f4, float f5, float f6, Boolean bool, Color color, Color color2, boolean z2) {
        long j4 = 4294967295L;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.b() & 4294967295L));
        float fB = 0.0f;
        float fE = f3 == 0.0f ? 0.0f : (graphValueData.e() / f3) * fIntBitsToFloat;
        float f7 = fIntBitsToFloat - fE;
        char c3 = ' ';
        if (color != null && color2 != null) {
            float fM1 = drawScope.M1(Dp.g(2));
            if (graphValueData.e() <= 0.0f) {
                fE = fM1;
            }
            x(drawScope, Offset.e((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(RangesKt.e(fIntBitsToFloat - fE, 0.0f))) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(fE)) & 4294967295L)), Color.f25715b.j(), CollectionsKt.listOf((Object[]) new Color[]{color2, color}), true, CornerRadius.b((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), CornerRadius.b((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)));
            return;
        }
        if (color != null) {
            Iterator it = graphValueData.f().iterator();
            while (it.hasNext()) {
                fB += ((GraphData.GraphValueData.GraphValueSection) it.next()).b();
            }
            y(drawScope, Offset.e((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f7)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(fB > 0.0f ? (fB / f3) * fIntBitsToFloat : -4.0f)) & 4294967295L)), fB > 0.0f ? color.B() : j3, z2 ? CollectionsKt.listOf((Object[]) new Color[]{Color.n(GraphConfiguration.f132742q.d()), color}) : null, false, CornerRadius.b((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), CornerRadius.b((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), 16, null);
            return;
        }
        int i3 = 0;
        for (Object obj : graphValueData.f()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GraphData.GraphValueData.GraphValueSection graphValueSection = (GraphData.GraphValueData.GraphValueSection) obj;
            float fB2 = (graphValueSection.b() / f3) * fIntBitsToFloat;
            boolean zAreEqual = Intrinsics.areEqual(bool, Boolean.FALSE);
            long jM1357getColor0d7_KjU = graphValueSection.a().m1357getColor0d7_KjU();
            if (zAreEqual) {
                jM1357getColor0d7_KjU = Color.r(jM1357getColor0d7_KjU, 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            long j5 = jM1357getColor0d7_KjU;
            float f8 = fB;
            long j6 = j4;
            long jE = Offset.e((((long) Float.floatToRawIntBits(f7)) & j6) | (((long) Float.floatToRawIntBits(f6)) << c3));
            long jD = Size.d((((long) Float.floatToRawIntBits(f4)) << c3) | (((long) Float.floatToRawIntBits(fB2)) & j6));
            float f9 = i3 == 0 ? f5 : f8;
            char c4 = c3;
            long jB = CornerRadius.b((((long) Float.floatToRawIntBits(f9)) & j6) | (((long) Float.floatToRawIntBits(f9)) << c4));
            float f10 = i3 == graphValueData.f().size() + (-1) ? f5 : f8;
            y(drawScope, jE, jD, j5, null, false, jB, CornerRadius.b((((long) Float.floatToRawIntBits(f10)) << c4) | (((long) Float.floatToRawIntBits(f10)) & j6)), 24, null);
            f7 += fB2;
            i3 = i4;
            fB = f8;
            j4 = j6;
            c3 = c4;
        }
    }

    private static final void t(DrawScope drawScope, GraphData graphData, float f3, float f4, float f5, float f6, Map map, Map map2, long j3, long j4, long j5, GraphConfiguration graphConfiguration, Function1 function1) {
        Boolean bool;
        long j6;
        int i3;
        TextLayoutResult textLayoutResult;
        Boolean bool2;
        long j7;
        long j8 = 4294967295L;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.b() & 4294967295L));
        Integer numE = graphData.e();
        boolean zK = graphConfiguration.k();
        boolean zN = graphConfiguration.n();
        Color colorF = graphConfiguration.f();
        Color colorH = graphConfiguration.h();
        boolean zM = graphConfiguration.m();
        boolean zL = graphConfiguration.l();
        int i4 = 0;
        for (Object obj : graphData.b()) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GraphData.GraphValueData graphValueData = (GraphData.GraphValueData) obj;
            Integer numF = graphData.f();
            Boolean boolValueOf = numF != null ? Boolean.valueOf(numF.intValue() == i4) : null;
            float f7 = i4 * (f4 + f5);
            long jE = Offset.e((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & j8));
            long jD = Size.d((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & j8));
            if (zK) {
                if (graphValueData.f().isEmpty() || Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
                    bool2 = boolValueOf;
                    j7 = j4;
                } else {
                    bool2 = boolValueOf;
                    j7 = j3;
                }
                long jB = CornerRadius.b((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & j8));
                bool = bool2;
                j6 = j8;
                i3 = i4;
                DrawScope.f2(drawScope, j7, jE, jD, jB, null, 0.0f, null, 0, 240, null);
            } else {
                bool = boolValueOf;
                j6 = j8;
                i3 = i4;
            }
            function1.invoke(RectKt.c(jE, jD));
            Color color = colorF;
            Color color2 = colorH;
            s(drawScope, graphValueData, j5, f3, f4, f6, f7, bool, color, color2, zM && numE != null && numE.intValue() == i3);
            if (zL && (graphData.b().size() < 10 || i3 % 6 == 0)) {
                float fM1 = graphConfiguration.q() ? drawScope.M1(Dp.g(10)) : 0.0f;
                TextLayoutResult textLayoutResult2 = (TextLayoutResult) map.get(graphValueData.d());
                if (textLayoutResult2 != null) {
                    float fM12 = fIntBitsToFloat + drawScope.M1(Dp.g(8)) + fM1;
                    float f8 = f7 + (f4 / 2);
                    TextPainterKt.b(drawScope, textLayoutResult2, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(f8 - (((int) (textLayoutResult2.B() >> 32)) / 2))) << 32) | (((long) Float.floatToRawIntBits(fM12)) & j6)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
                    if (zN && (textLayoutResult = (TextLayoutResult) map2.get(graphValueData.d())) != null) {
                        TextPainterKt.b(drawScope, textLayoutResult, (250 & 2) != 0 ? Color.f25715b.k() : 0L, (250 & 4) != 0 ? Offset.f25596b.c() : Offset.e((((long) Float.floatToRawIntBits(f8 - (((int) (textLayoutResult.B() >> 32)) / 2))) << 32) | (((long) Float.floatToRawIntBits(fM12 + ((int) (textLayoutResult2.B() & j6)) + drawScope.M1(Dp.g(4)))) & j6)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.a() : 0);
                    }
                }
            }
            colorF = color;
            colorH = color2;
            i4 = i5;
            j8 = j6;
        }
    }

    public static final void u(DrawScope drawCurrentTime, long j3, boolean z2) {
        Intrinsics.checkNotNullParameter(drawCurrentTime, "$this$drawCurrentTime");
        float f3 = ((TimeHelperExt.f128663a.f() - DateHelper.h().getTimeInMillis()) / TimeUnit.HOURS.toMillis(24L)) * Float.intBitsToFloat((int) (drawCurrentTime.b() >> 32));
        float fM1 = drawCurrentTime.M1(Dp.g(8));
        float fM12 = drawCurrentTime.M1(Dp.g(10));
        float fSqrt = (((float) Math.sqrt(3.0f)) / 2.0f) * fM12;
        Path pathA = AndroidPath_androidKt.a();
        if (z2) {
            float f4 = -fM1;
            pathA.a(f3, fSqrt + f4);
            float f5 = fM12 / 2;
            pathA.c(f3 - f5, f4);
            pathA.c(f3 + f5, f4);
        } else {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (drawCurrentTime.b() & 4294967295L)) + fM1;
            float f6 = fSqrt + fIntBitsToFloat;
            pathA.a(f3, fIntBitsToFloat);
            float f7 = fM12 / 2;
            pathA.c(f3 - f7, f6);
            pathA.c(f3 + f7, f6);
        }
        pathA.close();
        DrawScope.u0(drawCurrentTime, pathA, j3, 0.0f, null, null, 0, 60, null);
    }

    public static /* synthetic */ void v(DrawScope drawScope, long j3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        u(drawScope, j3, z2);
    }

    private static final void w(DrawScope drawScope, float f3, float f4, long j3) {
        float fM1 = drawScope.M1(Dp.g(5));
        float fM12 = drawScope.M1(Dp.g(2));
        float fM13 = drawScope.M1(Dp.g(6));
        long jB = CornerRadius.b((((long) Float.floatToRawIntBits(fM13)) << 32) | (((long) Float.floatToRawIntBits(fM13)) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) + fM1 + fM12;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.b() >> 32)) * (f4 - f3);
        Path pathA = AndroidPath_androidKt.a();
        Path.s(pathA, RoundRectKt.c(RectKt.c(Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.b() >> 32)) * f3)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L))), jB, jB, jB, jB), null, 2, null);
        DrawScope.u0(drawScope, pathA, Color.r(j3, 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, null, null, 0, 60, null);
        Path pathA2 = AndroidPath_androidKt.a();
        Path.s(pathA2, RoundRectKt.c(RectKt.c(Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.b() >> 32)) * f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - fM1)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fM1)) & 4294967295L))), jB, jB, jB, jB), null, 2, null);
        DrawScope.u0(drawScope, pathA2, j3, 0.0f, null, null, 0, 60, null);
    }

    private static final void x(DrawScope drawScope, long j3, long j4, long j5, List list, boolean z2, long j6, long j7) {
        long jE;
        Path pathA = AndroidPath_androidKt.a();
        Path.s(pathA, RoundRectKt.c(RectKt.c(j3, j4), j6, j6, j7, j7), null, 2, null);
        if (list == null) {
            DrawScope.u0(drawScope, pathA, j5, 0.0f, null, null, 0, 60, null);
            return;
        }
        Brush.Companion companion = Brush.Companion;
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        long jE2 = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i3))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4))) & 4294967295L));
        if (z2) {
            float fIntBitsToFloat = Float.intBitsToFloat(i3);
            jE = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j4 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        } else {
            float fIntBitsToFloat2 = Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j4 >> 32));
            jE = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j4 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32));
        }
        DrawScope.F1(drawScope, pathA, Brush.Companion.e(companion, list, jE2, jE, 0, 8, null), 0.0f, null, null, 0, 60, null);
    }

    static /* synthetic */ void y(DrawScope drawScope, long j3, long j4, long j5, List list, boolean z2, long j6, long j7, int i3, Object obj) {
        x(drawScope, (i3 & 1) != 0 ? Offset.f25596b.c() : j3, j4, j5, (i3 & 8) != 0 ? null : list, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? CornerRadius.f25589b.a() : j6, (i3 & 64) != 0 ? CornerRadius.f25589b.a() : j7);
    }
}
