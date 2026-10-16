package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PullToRefreshKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f22224a = Dp.g((float) 2.5d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f22225b = Dp.g((float) 5.5d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22226c = Dp.g(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22227d = Dp.g(40);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f22228e = Dp.g(10);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f22229f = Dp.g(5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TweenSpec f22230g = AnimationSpecKt.n(300, 0, EasingKt.e(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues a(float f3) {
        float fMax = (Math.max(Math.min(1.0f, f3) - 0.4f, 0.0f) * 5) / 3;
        float fO = RangesKt.o(Math.abs(f3) - 1.0f, 0.0f, 2.0f);
        float fPow = (((0.4f * fMax) - 0.25f) + (fO - (((float) Math.pow(fO, 2)) / 4))) * 0.5f;
        float f4 = 360;
        return new ArrowValues(fPow, fPow * f4, ((0.8f * fMax) + fPow) * f4, Math.min(1.0f, fMax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final Function0 function0, final long j3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-569718810);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-569718810, i4, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:561)");
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
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt.e(new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(((Number) function0.invoke()).floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                composerK.w(objG2);
            }
            final State stateD = AnimateAsStateKt.d(c((State) objG2), f22230g, 0.0f, null, null, composerK, 48, 28);
            Modifier.Companion companion2 = Modifier.b8;
            int i5 = i4 & 14;
            boolean z2 = i5 == 4;
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((SemanticsPropertyReceiver) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.q0(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function0.invoke()).floatValue(), RangesKt.b(0.0f, 1.0f), 0));
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierV = SizeKt.v(SemanticsModifierKt.e(companion2, true, (Function1) objG3), f22226c);
            boolean Z = (i5 == 4) | composerK.Z(stateD) | ((i4 & 112) == 32) | composerK.I(path);
            Object objG4 = composerK.G();
            if (Z || objG4 == companion.a()) {
                Function1<DrawScope, Unit> function1 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DrawScope) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        ArrowValues arrowValuesA = PullToRefreshKt.a(((Number) function0.invoke()).floatValue());
                        float fFloatValue = ((Number) stateD.getValue()).floatValue();
                        float fB = arrowValuesA.b();
                        long j4 = j3;
                        Path path2 = path;
                        long jV1 = drawScope.V1();
                        DrawContext drawContextQ1 = drawScope.Q1();
                        long jB = drawContextQ1.b();
                        drawContextQ1.g().t();
                        try {
                            drawContextQ1.e().j(fB, jV1);
                            Rect rectB = RectKt.b(androidx.compose.ui.geometry.SizeKt.b(drawScope.b()), drawScope.M1(PullToRefreshKt.f22225b) + (drawScope.M1(PullToRefreshKt.f22224a) / 2.0f));
                            PullToRefreshKt.l(drawScope, j4, fFloatValue, arrowValuesA, rectB, PullToRefreshKt.f22224a);
                            PullToRefreshKt.k(drawScope, path2, rectB, j4, fFloatValue, arrowValuesA, PullToRefreshKt.f22224a);
                        } finally {
                            drawContextQ1.g().k();
                            drawContextQ1.h(jB);
                        }
                    }
                };
                composerK.w(function1);
                objG4 = function1;
            }
            CanvasKt.b(modifierV, (Function1) objG4, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    PullToRefreshKt.b(function0, j3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final float c(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final boolean r16, final kotlin.jvm.functions.Function0 r17, androidx.compose.ui.Modifier r18, androidx.compose.material3.pulltorefresh.PullToRefreshState r19, androidx.compose.ui.Alignment r20, kotlin.jvm.functions.Function3 r21, final kotlin.jvm.functions.Function3 r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.d(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DrawScope drawScope, Path path, Rect rect, long j3, float f3, ArrowValues arrowValues, float f4) {
        path.reset();
        path.a(0.0f, 0.0f);
        float f5 = f22228e;
        path.c((drawScope.M1(f5) * arrowValues.c()) / 2, drawScope.M1(f22229f) * arrowValues.c());
        path.c(drawScope.M1(f5) * arrowValues.c(), 0.0f);
        path.p(OffsetKt.a(((Math.min(rect.v(), rect.n()) / 2.0f) + Offset.m(rect.m())) - ((drawScope.M1(f5) * arrowValues.c()) / 2.0f), Offset.n(rect.m()) - drawScope.M1(f4)));
        float fA = arrowValues.a() - drawScope.M1(f4);
        long jV1 = drawScope.V1();
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().j(fA, jV1);
            DrawScope.u0(drawScope, path, j3, f3, new Stroke(drawScope.M1(f4), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        } finally {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DrawScope drawScope, long j3, float f3, ArrowValues arrowValues, Rect rect, float f4) {
        DrawScope.F0(drawScope, j3, arrowValues.d(), arrowValues.a() - arrowValues.d(), false, rect.t(), rect.q(), f3, new Stroke(drawScope.M1(f4), 0.0f, StrokeCap.f25935b.a(), 0, null, 26, null), null, 0, 768, null);
    }

    public static final float m() {
        return f22226c;
    }

    public static final Modifier n(Modifier modifier, boolean z2, PullToRefreshState pullToRefreshState, boolean z3, float f3, Function0 function0) {
        return modifier.then(new PullToRefreshElement(z2, function0, z3, pullToRefreshState, f3, null));
    }

    public static /* synthetic */ Modifier o(Modifier modifier, boolean z2, PullToRefreshState pullToRefreshState, boolean z3, float f3, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = true;
        }
        boolean z4 = z3;
        if ((i3 & 8) != 0) {
            f3 = PullToRefreshDefaults.f22203a.e();
        }
        return n(modifier, z2, pullToRefreshState, z4, f3, function0);
    }

    public static final Modifier p(Modifier modifier, final PullToRefreshState pullToRefreshState, final boolean z2, final float f3, final Shape shape, long j3, final float f4) {
        return BackgroundKt.c(GraphicsLayerModifierKt.a(DrawModifierKt.d(SizeKt.v(modifier, f22227d), new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                int iB = ClipOp.f25711b.b();
                DrawContext drawContextQ1 = contentDrawScope.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    drawContextQ1.e().c(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iB);
                    contentDrawScope.i2();
                } finally {
                    drawContextQ1.g().k();
                    drawContextQ1.h(jB);
                }
            }
        }), new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$2
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
                boolean z3 = pullToRefreshState.a() > 0.0f || z2;
                graphicsLayerScope.d((pullToRefreshState.a() * graphicsLayerScope.z0(f3)) - Size.g(graphicsLayerScope.b()));
                graphicsLayerScope.E(z3 ? graphicsLayerScope.M1(f4) : 0.0f);
                graphicsLayerScope.I1(shape);
                graphicsLayerScope.B(true);
            }
        }), j3, shape);
    }

    public static /* synthetic */ Modifier q(Modifier modifier, PullToRefreshState pullToRefreshState, boolean z2, float f3, Shape shape, long j3, float f4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f3 = PullToRefreshDefaults.f22203a.e();
        }
        float f5 = f3;
        if ((i3 & 8) != 0) {
            shape = PullToRefreshDefaults.f22203a.f();
        }
        Shape shape2 = shape;
        if ((i3 & 16) != 0) {
            j3 = Color.f25715b.k();
        }
        return p(modifier, pullToRefreshState, z2, f5, shape2, j3, (i3 & 32) != 0 ? PullToRefreshDefaults.f22203a.c() : f4);
    }

    public static final PullToRefreshState r(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(318623070, i3, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:512)");
        }
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.e(new Object[0], PullToRefreshStateImpl.f22289b.a(), null, new Function0<PullToRefreshStateImpl>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final PullToRefreshStateImpl invoke() {
                return new PullToRefreshStateImpl();
            }
        }, composer, 3072, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return pullToRefreshStateImpl;
    }
}
