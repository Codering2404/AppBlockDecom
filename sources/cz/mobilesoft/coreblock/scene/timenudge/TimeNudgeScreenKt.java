package cz.mobilesoft.coreblock.scene.timenudge;

import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.AppIconsWithCountKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class TimeNudgeScreenKt {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f122852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f122853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f122854e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f122858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f122859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f122860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f122861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f122862m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f122863n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f122864o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f122865p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final RoundedCornerShape f122866q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f122850a = Dp.g(3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f122851b = Dp.g((float) 0.5d);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f122855f = Dp.g(192);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f122856g = Dp.g(11);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f122857h = Dp.g(20);

    static {
        float f3 = 4;
        f122852c = Dp.g(f3);
        f122853d = Dp.g(f3);
        float f4 = (float) 1.5d;
        f122854e = Dp.g(f4);
        f122858i = Dp.g(f4);
        Color.Companion companion = Color.f25715b;
        f122859j = Color.r(companion.a(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
        f122860k = Color.r(companion.l(), 0.34f, 0.0f, 0.0f, 0.0f, 14, null);
        f122861l = Color.r(companion.l(), 0.14f, 0.0f, 0.0f, 0.0f, 14, null);
        f122862m = Color.r(companion.l(), 0.55f, 0.0f, 0.0f, 0.0f, 14, null);
        f122863n = Color.r(companion.l(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
        f122864o = Dp.g(12);
        f122865p = Dp.g(8);
        f122866q = RoundedCornerShapeKt.a(50);
    }

    public static final void j(final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(1867536289);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCloseClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1867536289, i4, -1, "cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeScreen (TimeNudgeScreen.kt:125)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(TimeNudgeViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            final TimeNudgeViewState timeNudgeViewState = (TimeNudgeViewState) FlowExtKt.m((TimeNudgeViewModel) viewModelA, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Unit unit = Unit.f139807a;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new TimeNudgeScreenKt$TimeNudgeScreen$1$1(null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            boolean z2 = (i4 & 14) == 4;
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.timenudge.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeNudgeScreenKt.k(mutableState, onCloseClicked);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-99337809, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.timenudge.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimeNudgeScreenKt.l(mutableState, onCloseClicked, timeNudgeViewState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.timenudge.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeScreenKt.n(onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(MutableState mutableState, Function0 function0) {
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final MutableState mutableState, Function0 function0, TimeNudgeViewState timeNudgeViewState, BoxScope GradientBox, Composer composer, int i3) throws Exception {
        Modifier.Companion companion;
        Modifier.Companion companion2;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-99337809, i3, -1, "cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeScreen.<anonymous> (TimeNudgeScreen.kt:149)");
            }
            Modifier.Companion companion3 = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.f(companion3, 0.0f, 1, null), Dp.g(f3));
            Alignment.Companion companion4 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion4.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            Modifier modifierG = ScrollKt.g(SizeKt.h(ColumnScope.b(ColumnScopeInstance.f6666a, companion3, 1.0f, false, 2, null), 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion4.g(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierG);
            Function0 function0A2 = companion5.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA2, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            SpacerKt.a(SizeKt.i(companion3, Dp.g(32)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.mD, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jL = ComposeColorsKt.j(composer, 0).L();
            TextAlign.Companion companion6 = TextAlign.f29616b;
            TextKt.c(strB, null, jL, 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion3, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.UC, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion3, Dp.g(72)), composer2, 6);
            if (timeNudgeViewState.e()) {
                composer2.a0(-651061529);
                ProgressIndicatorKt.b(null, ComposeColorsKt.j(composer2, 0).b(), 0.0f, 0L, 0, composer2, 0, 29);
                composer2.U();
                companion = companion3;
            } else {
                composer2.a0(-650943233);
                o(timeNudgeViewState, composer2, 0);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(20)), composer2, 6);
                TextKt.c(DateHelperExtKt.f(timeNudgeViewState.c(), false, false, false, 14, null), null, ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).f(), composer, 0, 0, 65530);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(12)), composer, 6);
                companion = companion3;
                TextKt.c(StringResources_androidKt.c(R.string.nD, new Object[]{DateHelperExtKt.f(timeNudgeViewState.d(), false, false, false, 14, null)}, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65018);
                composer2 = composer;
                composer2.U();
            }
            composer2.y();
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer2.a0(-905697920);
                Modifier.Companion companion7 = companion;
                TextKt.c(StringResources_androidKt.b(R.string.lD, composer2, 0), SizeKt.h(companion7, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 48, 0, 65016);
                composer2 = composer;
                companion2 = companion7;
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer2, 6);
            } else {
                companion2 = companion;
                composer2.a0(-915240247);
            }
            composer2.U();
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            String strB2 = StringResources_androidKt.b(R.string.N7, composer2, 0);
            Object objG = composer2.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.timenudge.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeNudgeScreenKt.m(mutableState);
                    }
                };
                composer2.w(objG);
            }
            FlatButtonsKt.A(modifierH, 0.0f, null, null, 0L, strB2, null, null, null, 10000L, 0L, (Function0) objG, function0, composer, 805306374, 48, 1502);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0, int i3, Composer composer, int i4) {
        j(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o(final TimeNudgeViewState timeNudgeViewState, Composer composer, final int i3) throws Exception {
        int i4;
        float f3;
        long j3;
        long j4;
        long j5;
        Composer composerK = composer.k(1990509303);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(timeNudgeViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1990509303, i4, -1, "cz.mobilesoft.coreblock.scene.timenudge.TodaySharePie (TimeNudgeScreen.kt:228)");
            }
            long jG = RangesKt.g(timeNudgeViewState.d(), 0L);
            final long jR = RangesKt.r(timeNudgeViewState.c(), 0L, jG);
            final long j6 = jG - jR;
            float f4 = jG > 0 ? jR / jG : 0.0f;
            if (jR <= 0) {
                f3 = 0.0f;
            } else {
                f3 = 360.0f;
                if (j6 > 0) {
                    f3 = 360.0f * f4;
                }
            }
            final long jB = ComposeColorsKt.j(composerK, 0).b();
            final long jU = ComposeColorsKt.j(composerK, 0).u();
            final long jS = ComposeColorsKt.j(composerK, 0).s();
            float f5 = f3;
            float radians = (float) Math.toRadians((f3 / 2.0f) - 90.0f);
            float f6 = f122855f;
            float fG = Dp.g(Dp.g(Dp.g(f6 - f122854e) / 2.0f) - f122856g);
            double d3 = radians;
            final float fG2 = Dp.g(((float) Math.cos(d3)) * fG);
            final float fG3 = Dp.g(fG * ((float) Math.sin(d3)));
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierV = SizeKt.v(companion, f6);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierV);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF2 = SizeKt.f(companion, 0.0f, 1, null);
            boolean zC = composerK.c(f4) | composerK.f(jR) | composerK.f(j6) | composerK.f(jB) | composerK.f(jU) | composerK.f(jS);
            Object objG = composerK.G();
            if (zC || objG == Composer.f23746a.a()) {
                final float f7 = f4;
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.timenudge.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimeNudgeScreenKt.p(f7, jR, j6, jB, jU, jS, (DrawScope) obj);
                    }
                };
                j3 = j6;
                j4 = jU;
                j5 = jS;
                composerK.w(objG);
            } else {
                j5 = jS;
                j3 = j6;
                j4 = jU;
            }
            final long j7 = j5;
            CanvasKt.b(modifierF2, (Function1) objG, composerK, 6);
            if (f5 <= 0.0f || timeNudgeViewState.b().isEmpty()) {
                composerK.a0(-1117423355);
            } else {
                composerK.a0(-1103739149);
                List listB = timeNudgeViewState.b();
                Modifier modifierA = OffsetKt.a(boxScopeInstance.f(companion, companion2.e()), fG2, fG3);
                boolean zF = composerK.f(j7) | composerK.c(fG2) | composerK.c(fG3) | composerK.c(f4) | composerK.f(jR) | composerK.f(j3) | composerK.f(jB) | composerK.f(j4);
                Object objG2 = composerK.G();
                if (zF || objG2 == Composer.f23746a.a()) {
                    final long j8 = j3;
                    final long j9 = j4;
                    final float f8 = f4;
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.timenudge.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimeNudgeScreenKt.q(fG2, fG3, f8, jR, j8, jB, j9, j7, (CacheDrawScope) obj);
                        }
                    };
                    composerK.w(objG2);
                }
                Modifier modifierC = DrawModifierKt.c(modifierA, (Function1) objG2);
                long j10 = f122859j;
                RoundedCornerShape roundedCornerShape = f122866q;
                Modifier modifierC2 = BackgroundKt.c(modifierC, j10, roundedCornerShape);
                Brush.Companion companion4 = Brush.Companion;
                AppIconsWithCountKt.c(listB, PaddingKt.j(BorderKt.e(BackgroundKt.b(modifierC2, Brush.Companion.m(companion4, CollectionsKt.listOf((Object[]) new Color[]{Color.n(f122860k), Color.n(f122861l)}), 0.0f, 0.0f, 0, 14, null), roundedCornerShape, 0.0f, 4, null), new BorderStroke(f122858i, Brush.Companion.m(companion4, CollectionsKt.listOf((Object[]) new Color[]{Color.n(f122862m), Color.n(f122863n)}), 0.0f, 0.0f, 0, 14, null), null), roundedCornerShape), f122864o, f122865p), 3, 0.0f, DarkThemeKt.a(composerK, 0) ? Color.f25715b.a() : ColorKt.d(4294111991L), null, ComposeColorsKt.j(composerK, 0).q0(), composerK, 384, 40);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.timenudge.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeScreenKt.t(timeNudgeViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(float f3, long j3, long j4, long j5, long j6, long j7, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        w(Canvas, Canvas.b(), f3, j3 > 0, j4 > 0, j5, j6, j7);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult q(float f3, float f4, final float f5, final long j3, final long j4, final long j5, final long j6, final long j7, CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        final GraphicsLayer graphicsLayerP = drawWithCache.p();
        final float fM1 = drawWithCache.M1(f122855f);
        float f6 = fM1 / 2.0f;
        final float fM12 = drawWithCache.M1(f3) + (f6 - (Float.intBitsToFloat((int) (drawWithCache.b() >> 32)) / 2.0f));
        final float fIntBitsToFloat = (f6 - (Float.intBitsToFloat((int) (drawWithCache.b() & 4294967295L)) / 2.0f)) + drawWithCache.M1(f4);
        float fM13 = drawWithCache.M1(f122857h);
        final float fCeil = (float) Math.ceil(fM13);
        float f7 = fCeil * 2.0f;
        CacheDrawScope.H(drawWithCache, graphicsLayerP, null, null, IntSize.c((((long) MathKt.d(Float.intBitsToFloat((int) (drawWithCache.b() & 4294967295L)) + f7)) & 4294967295L) | (((long) MathKt.d(Float.intBitsToFloat((int) (drawWithCache.b() >> 32)) + f7)) << 32)), new Function1() { // from class: cz.mobilesoft.coreblock.scene.timenudge.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeNudgeScreenKt.r(fCeil, fM12, fIntBitsToFloat, fM1, f5, j3, j4, j5, j6, j7, (ContentDrawScope) obj);
            }
        }, 3, null);
        graphicsLayerP.U(RenderEffectKt.a(fM13, fM13, TileMode.f25948b.b()));
        final Path pathA = AndroidPath_androidKt.a();
        Rect rectC = RectKt.c(Offset.f25596b.c(), drawWithCache.b());
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawWithCache.b() & 4294967295L)) / 2.0f;
        Path.s(pathA, RoundRectKt.e(rectC, CornerRadius.b((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))), null, 2, null);
        return drawWithCache.u(new Function1() { // from class: cz.mobilesoft.coreblock.scene.timenudge.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimeNudgeScreenKt.s(pathA, fCeil, graphicsLayerP, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(float f3, float f4, float f5, float f6, float f7, long j3, long j4, long j5, long j6, long j7, ContentDrawScope record) {
        float f8;
        long j8;
        long j9;
        long j10;
        Intrinsics.checkNotNullParameter(record, "$this$record");
        float f9 = f3 - f4;
        float f10 = f3 - f5;
        record.Q1().e().e(f9, f10);
        try {
            long jD = Size.d((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L));
            boolean z2 = false;
            boolean z3 = j3 > 0;
            if (j4 > 0) {
                z2 = true;
                f8 = f7;
                j9 = j6;
                j10 = j7;
                j8 = j5;
            } else {
                f8 = f7;
                j8 = j5;
                j9 = j6;
                j10 = j7;
            }
            w(record, jD, f8, z3, z2, j8, j9, j10);
            record.Q1().e().e(-f9, -f10);
            return Unit.f139807a;
        } catch (Throwable th) {
            record.Q1().e().e(-f9, -f10);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Path path, float f3, GraphicsLayer graphicsLayer, DrawScope onDrawBehind) {
        Intrinsics.checkNotNullParameter(onDrawBehind, "$this$onDrawBehind");
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = onDrawBehind.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().d(path, iB);
            float f4 = -f3;
            onDrawBehind.Q1().e().e(f4, f4);
            try {
                GraphicsLayerKt.a(onDrawBehind, graphicsLayer);
                drawContextQ1.g().k();
                drawContextQ1.h(jB);
                return Unit.f139807a;
            } finally {
                float f5 = -f4;
                onDrawBehind.Q1().e().e(f5, f5);
            }
        } catch (Throwable th) {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(TimeNudgeViewState timeNudgeViewState, int i3, Composer composer, int i4) throws Exception {
        o(timeNudgeViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final Path u(long j3, float f3, float f4, float f5, float f6, float f7) {
        Path pathA = AndroidPath_androidKt.a();
        float f8 = f5 - f4;
        if (f8 > 0.0f && f3 > 0.0f) {
            double d3 = f8;
            float fE = RangesKt.e(RangesKt.j(f6, ((float) Math.sin((float) Math.toRadians(d3 / 4.0d))) * f3), 0.0f);
            float fSin = (float) Math.sin((float) Math.toRadians(d3 / 2.0d));
            float fO = fSin > 1.0E-4f ? RangesKt.o(fE / fSin, 0.0f, f3) : 0.0f;
            float f9 = f4 + f5;
            double radians = (float) Math.toRadians(((double) f9) / 2.0d);
            long jE = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 >> 32)) + (((float) Math.cos(radians)) * fO))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)) + (fO * ((float) Math.sin(radians))))) & 4294967295L));
            WedgeCorners wedgeCornersZ = z(f3, f8, fE, fSin, f7);
            if (wedgeCornersZ == null) {
                float degrees = (float) Math.toDegrees((float) Math.asin(RangesKt.o(fE / f3, 0.0f, 1.0f)));
                float fE2 = RangesKt.e(f8 - (2 * degrees), 0.0f);
                pathA.a(Float.intBitsToFloat((int) (jE >> 32)), Float.intBitsToFloat((int) (jE & 4294967295L)));
                pathA.w(v(j3, f3), f4 + degrees, fE2, false);
                pathA.close();
                return pathA;
            }
            float fA = wedgeCornersZ.a();
            float fB = wedgeCornersZ.b();
            float fC = wedgeCornersZ.c();
            float fD = wedgeCornersZ.d();
            float fE3 = wedgeCornersZ.e();
            boolean zF = wedgeCornersZ.f();
            float f10 = f4 + fC;
            float f11 = f5 - fC;
            long jX = jE;
            long jX2 = x(j3, fB, f10);
            long jX3 = x(j3, fB, f11);
            float f12 = f4 - 90.0f;
            float f13 = f5 + 90.0f;
            boolean z2 = fD > 0.01f;
            long jX4 = x(j3, fE3, f9 / 2.0f);
            float f14 = zF ? fD : -fD;
            long jX5 = z2 ? x(jX4, f14, f12) : jX;
            if (z2) {
                jX = x(jX4, f14, f13);
            }
            pathA.a(Float.intBitsToFloat((int) (jX5 >> 32)), Float.intBitsToFloat((int) (jX5 & 4294967295L)));
            long jX6 = x(jX2, fA, f12);
            pathA.c(Float.intBitsToFloat((int) (jX6 >> 32)), Float.intBitsToFloat((int) (jX6 & 4294967295L)));
            float f15 = fC + 90.0f;
            pathA.w(v(jX2, fA), f12, f15, false);
            pathA.w(v(j3, f3), f10, f11 - f10, false);
            pathA.w(v(jX3, fA), f11, f15, false);
            pathA.c(Float.intBitsToFloat((int) (jX >> 32)), Float.intBitsToFloat((int) (jX & 4294967295L)));
            if (z2) {
                Rect rectV = v(jX4, fD);
                if (!zF) {
                    f13 += 180.0f;
                }
                pathA.w(rectV, f13, 180.0f - f8, false);
            }
            pathA.close();
        }
        return pathA;
    }

    private static final Rect v(long j3, float f3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        return new Rect(Float.intBitsToFloat(i3) - f3, Float.intBitsToFloat(i4) - f3, Float.intBitsToFloat(i3) + f3, Float.intBitsToFloat(i4) + f3);
    }

    private static final void w(DrawScope drawScope, long j3, float f3, boolean z2, boolean z3, long j4, long j5, long j6) {
        long j7;
        float fM1 = drawScope.M1(f122854e);
        float fH = (Size.h(j3) - fM1) / 2.0f;
        float fE = RangesKt.e((fH - drawScope.M1(f122853d)) - (fM1 / 2.0f), 0.0f);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) / 2.0f;
        long jE = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        float fM12 = drawScope.M1(f122852c);
        float fM13 = drawScope.M1(y(f3)) / 2.0f;
        if (!z2) {
            DrawScope.e2(drawScope, j5, fE, jE, 0.0f, null, null, 0, 120, null);
        } else {
            if (z3) {
                float f4 = (360.0f * f3) - 90.0f;
                j7 = jE;
                DrawScope.u0(drawScope, u(jE, fE, -90.0f, f4, fM13, fM12), j4, 0.0f, null, null, 0, 60, null);
                DrawScope.u0(drawScope, u(j7, fE, f4, 270.0f, fM13, fM12), j5, 0.0f, null, null, 0, 60, null);
                DrawScope.e2(drawScope, j6, fH, j7, 0.0f, new Stroke(fM1, 0.0f, 0, 0, null, 30, null), null, 0, 104, null);
            }
            DrawScope.e2(drawScope, j4, fE, jE, 0.0f, null, null, 0, 120, null);
        }
        j7 = jE;
        DrawScope.e2(drawScope, j6, fH, j7, 0.0f, new Stroke(fM1, 0.0f, 0, 0, null, 30, null), null, 0, 104, null);
    }

    private static final long x(long j3, float f3, float f4) {
        double radians = (float) Math.toRadians(f4);
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 >> 32)) + (((float) Math.cos(radians)) * f3))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)) + (f3 * ((float) Math.sin(radians))))) & 4294967295L));
    }

    private static final float y(float f3) {
        return DpKt.c(f122851b, f122850a, RangesKt.o(RangesKt.e(Math.min(f3, 1.0f - f3), 0.0f) / 0.05f, 0.0f, 1.0f));
    }

    private static final WedgeCorners z(float f3, float f4, float f5, float f6, float f7) {
        if (f7 <= 0.0f || f6 <= 1.0E-4f) {
            return null;
        }
        float fJ = RangesKt.j(f7, (((f6 * f3) - f5) / (f6 + 1.0f)) * 0.95f);
        if (fJ <= 0.0f) {
            return null;
        }
        float f8 = f3 - fJ;
        if (f8 <= 0.0f) {
            return null;
        }
        float degrees = (float) Math.toDegrees((float) Math.asin(RangesKt.o((f5 + fJ) / f8, 0.0f, 1.0f)));
        if (f4 <= 2.0f * degrees) {
            return null;
        }
        boolean z2 = f4 < 180.0f;
        float fJ2 = f6 < 0.999f ? RangesKt.j(f6 / (1.0f - f6), 1.0f) : 1.0f;
        float f9 = z2 ? fJ * fJ2 * fJ2 : fJ * fJ2;
        return new WedgeCorners(fJ, f8, degrees, f9, z2 ? RangesKt.j((f5 + f9) / f6, f8) : RangesKt.j((f5 - f9) / f6, f8), z2);
    }
}
