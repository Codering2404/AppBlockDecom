package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class PullRefreshIndicatorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f15250a = Dp.g(40);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RoundedCornerShape f15251b = RoundedCornerShapeKt.g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f15252c = Dp.g((float) 7.5d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f15253d = Dp.g((float) 2.5d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f15254e = Dp.g(10);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f15255f = Dp.g(5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f15256g = Dp.g(6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TweenSpec f15257h = AnimationSpecKt.n(300, 0, EasingKt.e(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues a(float f3) {
        float fMax = (Math.max(Math.min(1.0f, f3) - 0.4f, 0.0f) * 5) / 3;
        float fAbs = Math.abs(f3) - 1.0f;
        float f4 = fAbs >= 0.0f ? fAbs : 0.0f;
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        float fPow = (((0.4f * fMax) - 0.25f) + (f4 - (((float) Math.pow(f4, 2)) / 4))) * 0.5f;
        float f5 = 360;
        return new ArrowValues(fPow, fPow * f5, ((0.8f * fMax) + fPow) * f5, Math.min(1.0f, fMax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final PullRefreshState pullRefreshState, final long j3, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-486016981);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(pullRefreshState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-486016981, i4, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:134)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            Object obj = objG;
            if (objG == companion.a()) {
                Path pathA = AndroidPath_androidKt.a();
                pathA.k(PathFillType.f25834b.a());
                composerK.w(pathA);
                obj = pathA;
            }
            final Path path = (Path) obj;
            boolean Z = composerK.Z(pullRefreshState);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = SnapshotStateKt.e(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(pullRefreshState.j() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                composerK.w(objG2);
            }
            final State stateD = AnimateAsStateKt.d(c((State) objG2), f15257h, 0.0f, null, null, composerK, 48, 28);
            Modifier modifierF = SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((SemanticsPropertyReceiver) obj2);
                    return Unit.f139807a;
                }
            }, 1, null);
            boolean zI = composerK.I(pullRefreshState) | composerK.Z(stateD) | ((i4 & 112) == 32) | composerK.I(path);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                Function1<DrawScope, Unit> function1 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) throws Throwable {
                        invoke((DrawScope) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(DrawScope drawScope) throws Throwable {
                        DrawContext drawContext;
                        long j4;
                        ArrowValues arrowValuesA = PullRefreshIndicatorKt.a(pullRefreshState.j());
                        float fFloatValue = ((Number) stateD.getValue()).floatValue();
                        float fB = arrowValuesA.b();
                        long j5 = j3;
                        Path path2 = path;
                        long jV1 = drawScope.V1();
                        DrawContext drawContextQ1 = drawScope.Q1();
                        long jB = drawContextQ1.b();
                        drawContextQ1.g().t();
                        try {
                            drawContextQ1.e().j(fB, jV1);
                            float fM1 = drawScope.M1(PullRefreshIndicatorKt.f15252c) + (drawScope.M1(PullRefreshIndicatorKt.f15253d) / 2.0f);
                            Rect rect = new Rect(Offset.m(SizeKt.b(drawScope.b())) - fM1, Offset.n(SizeKt.b(drawScope.b())) - fM1, Offset.m(SizeKt.b(drawScope.b())) + fM1, Offset.n(SizeKt.b(drawScope.b())) + fM1);
                            try {
                                try {
                                    DrawScope.F0(drawScope, j5, arrowValuesA.d(), arrowValuesA.a() - arrowValuesA.d(), false, rect.t(), rect.q(), fFloatValue, new Stroke(drawScope.M1(PullRefreshIndicatorKt.f15253d), 0.0f, StrokeCap.f25935b.c(), 0, null, 26, null), null, 0, 768, null);
                                    PullRefreshIndicatorKt.k(drawScope, path2, rect, j5, fFloatValue, arrowValuesA);
                                    drawContextQ1.g().k();
                                    drawContextQ1.h(jB);
                                } catch (Throwable th) {
                                    th = th;
                                    drawContext = drawContextQ1;
                                    j4 = jB;
                                    drawContext.g().k();
                                    drawContext.h(j4);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                j4 = jB;
                                drawContext = drawContextQ1;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            drawContext = drawContextQ1;
                            j4 = jB;
                        }
                    }
                };
                composerK.w(function1);
                objG3 = function1;
            }
            CanvasKt.b(modifierF, (Function1) objG3, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    PullRefreshIndicatorKt.b(pullRefreshState, j3, modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final float c(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final boolean r32, final androidx.compose.material.pullrefresh.PullRefreshState r33, androidx.compose.ui.Modifier r34, long r35, long r37, boolean r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.d(boolean, androidx.compose.material.pullrefresh.PullRefreshState, androidx.compose.ui.Modifier, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean e(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DrawScope drawScope, Path path, Rect rect, long j3, float f3, ArrowValues arrowValues) {
        path.reset();
        path.a(0.0f, 0.0f);
        float f4 = f15254e;
        path.c(drawScope.M1(f4) * arrowValues.c(), 0.0f);
        path.c((drawScope.M1(f4) * arrowValues.c()) / 2, drawScope.M1(f15255f) * arrowValues.c());
        path.p(OffsetKt.a(((Math.min(rect.v(), rect.n()) / 2.0f) + Offset.m(rect.m())) - ((drawScope.M1(f4) * arrowValues.c()) / 2.0f), Offset.n(rect.m()) + (drawScope.M1(f15253d) / 2.0f)));
        path.close();
        float fA = arrowValues.a();
        long jV1 = drawScope.V1();
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().j(fA, jV1);
            DrawScope.u0(drawScope, path, j3, f3, null, null, 0, 56, null);
        } finally {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        }
    }
}
