package cz.mobilesoft.coreblock.scene.strictmode3.component;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.xmlpull.v1.XmlPullParserException;

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
public final class StrictModeBallKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(long j3, Function0 function0, MutableLongState mutableLongState, MutableIntState mutableIntState) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - y(mutableLongState) <= j3) {
            x(mutableIntState, w(mutableIntState) + 1);
        } else {
            x(mutableIntState, 1);
        }
        z(mutableLongState, jCurrentTimeMillis);
        if (w(mutableIntState) >= 5) {
            function0.invoke();
            x(mutableIntState, 0);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(StrictModeState strictModeState, Modifier modifier, Dp dp, Function0 function0, int i3, int i4, Composer composer, int i5) {
        u(strictModeState, modifier, dp, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(StrictModeGlowColor strictModeGlowColor, int i3, Color color, float f3, Composer composer, int i4) throws XmlPullParserException, IOException {
        long jB;
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2108952812, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBall.<anonymous> (StrictModeBall.kt:190)");
            }
            if (strictModeGlowColor != StrictModeGlowColor.FabPurple) {
                composer.a0(-1031519093);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, i3, composer, 6);
                ColorFilter.Companion companion = ColorFilter.f25730b;
                if (color == null) {
                    composer.a0(520921624);
                    jB = ComposeColorsKt.j(composer, 0).L();
                    composer.U();
                } else {
                    composer.a0(520921035);
                    composer.U();
                    jB = color.B();
                }
                ImageKt.b(imageVectorB, null, SizeKt.v(Modifier.b8, f3), null, null, 0.0f, ColorFilter.Companion.c(companion, jB, 0, 2, null), composer, 48, 56);
            } else {
                composer.a0(-1037971154);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Modifier modifier, StrictModeGlowColor strictModeGlowColor, int i3, float f3, Color color, boolean z2, Dp dp, int i4, int i5, Composer composer, int i6) {
        q(modifier, strictModeGlowColor, i3, f3, color, z2, dp, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(StrictModeState strictModeState, Modifier modifier, Dp dp, float f3, boolean z2, int i3, int i4, Composer composer, int i5) {
        r(strictModeState, modifier, dp, f3, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(StrictModeGlowColor strictModeGlowColor, Modifier modifier, Dp dp, float f3, boolean z2, int i3, int i4, Composer composer, int i5) {
        s(strictModeGlowColor, modifier, dp, f3, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final float G(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    private static final float I(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier J(Dp dp, Modifier applyIfElse) {
        Intrinsics.checkNotNullParameter(applyIfElse, "$this$applyIfElse");
        Intrinsics.checkNotNull(dp);
        return SizeKt.v(applyIfElse, dp.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier K(Modifier applyIfElse) {
        Intrinsics.checkNotNullParameter(applyIfElse, "$this$applyIfElse");
        return SizeKt.e(applyIfElse, 0.6f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Modifier modifier, StrictModeGlowColor strictModeGlowColor, boolean z2, Dp dp, Function2 function2, int i3, int i4, Composer composer, int i5) {
        t(modifier, strictModeGlowColor, z2, dp, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(androidx.compose.ui.Modifier r28, long r29, long r31, final boolean r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt.m(androidx.compose.ui.Modifier, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float n(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, float f3, long j3, long j4, State state, DrawScope Canvas) throws Throwable {
        long j5;
        DrawContext drawContext;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fH = Size.h(Canvas.b()) * (z2 ? 0.15f : 0.08f);
        float fH2 = Size.h(Canvas.b()) * f3;
        float f4 = 2 * fH2;
        long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() >> 32)) - f4)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) - f4)) & 4294967295L));
        long jE = Offset.e((((long) Float.floatToRawIntBits(fH2)) << 32) | (((long) Float.floatToRawIntBits(fH2)) & 4294967295L));
        long jE2 = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jE & 4294967295L)) + (Float.intBitsToFloat((int) (jD & 4294967295L)) / 2.0f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jE >> 32)) + (Float.intBitsToFloat((int) (jD >> 32)) / 2.0f))) << 32));
        Brush brushJ = Brush.Companion.j(new Pair[]{TuplesKt.a(Float.valueOf(0.0f), Color.n(j3)), TuplesKt.a(Float.valueOf(RangesKt.o(0.2777778f, 0.0f, 1.0f)), Color.n(j4)), TuplesKt.a(Float.valueOf(1.0f), Color.n(j3))}, jE2);
        float fN = n(state) + 133.77f;
        DrawContext drawContextQ1 = Canvas.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().j(fN, jE2);
            try {
            } catch (Throwable th) {
                th = th;
                drawContext = drawContextQ1;
            }
        } catch (Throwable th2) {
            th = th2;
            j5 = jB;
            drawContext = drawContextQ1;
        }
        try {
            DrawScope.y1(Canvas, brushJ, 0.0f, 100.0f, false, jE, jD, 0.0f, new Stroke(fH, 0.0f, StrokeCap.f25935b.b(), 0, null, 26, null), null, 0, 832, null);
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            return Unit.f139807a;
        } catch (Throwable th3) {
            th = th3;
            drawContext = drawContextQ1;
            j5 = jB;
            drawContext.g().k();
            drawContext.h(j5);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, long j3, long j4, boolean z2, int i3, int i4, Composer composer, int i5) {
        m(modifier, j3, j4, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(androidx.compose.ui.Modifier r17, final cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor r18, final int r19, final float r20, androidx.compose.ui.graphics.Color r21, boolean r22, androidx.compose.ui.unit.Dp r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt.q(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor, int, float, androidx.compose.ui.graphics.Color, boolean, androidx.compose.ui.unit.Dp, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(final cz.mobilesoft.coreblock.enums.StrictModeState r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.unit.Dp r20, float r21, boolean r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt.r(cz.mobilesoft.coreblock.enums.StrictModeState, androidx.compose.ui.Modifier, androidx.compose.ui.unit.Dp, float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(final cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.unit.Dp r20, float r21, boolean r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt.s(cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor, androidx.compose.ui.Modifier, androidx.compose.ui.unit.Dp, float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(androidx.compose.ui.Modifier r22, final cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor r23, boolean r24, androidx.compose.ui.unit.Dp r25, kotlin.jvm.functions.Function2 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt.t(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor, boolean, androidx.compose.ui.unit.Dp, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u(final cz.mobilesoft.coreblock.enums.StrictModeState r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.unit.Dp r26, final kotlin.jvm.functions.Function0 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt.u(cz.mobilesoft.coreblock.enums.StrictModeState, androidx.compose.ui.Modifier, androidx.compose.ui.unit.Dp, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(StrictModeState strictModeState, Modifier modifier, Dp dp, Function0 function0, int i3, int i4, Composer composer, int i5) {
        u(strictModeState, modifier, dp, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final int w(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    private static final void x(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    private static final long y(MutableLongState mutableLongState) {
        return mutableLongState.d();
    }

    private static final void z(MutableLongState mutableLongState, long j3) {
        mutableLongState.t(j3);
    }
}
