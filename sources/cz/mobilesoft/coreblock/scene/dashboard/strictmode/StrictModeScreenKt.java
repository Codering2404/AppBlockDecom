package cz.mobilesoft.coreblock.scene.dashboard.strictmode;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.compose.FlowExtKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewState;
import cz.mobilesoft.coreblock.scene.dashboard.strictmode.StrictModeScreenKt;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroActivity;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavigation;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeStartScreenKt;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.ShimmerThemeKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposePlaceHoldersKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f101540a;

        static {
            int[] iArr = new int[DashboardViewModel.StrictModeScreenType.values().length];
            try {
                iArr[DashboardViewModel.StrictModeScreenType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DashboardViewModel.StrictModeScreenType.ONBOARDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f101540a = iArr;
        }
    }

    public static final void j(final Function0 onGoToBlockingTabClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onGoToBlockingTabClicked, "onGoToBlockingTabClicked");
        Composer composerK = composer.k(-126501746);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onGoToBlockingTabClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-126501746, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.strictmode.NoBlockingsSheetContent (StrictModeScreen.kt:167)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(f3)), companion2.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            Alignment alignmentE = companion2.e();
            Modifier modifierI2 = SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(120));
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI2);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            StrictModeBallKt.q(null, StrictModeGlowColor.White, R.drawable.cb, Dp.g(40), null, false, null, composerK, 3120, 113);
            composerK.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            String strB = StringResources_androidKt.b(R.string.Dy, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            long jO = ComposeColorsKt.j(composerK, 0).O();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), jO, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.Ey, composerK, 0), PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composerK, 6);
            Modifier modifierI3 = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierI3);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ComposeButtonsKt.i0(SizeKt.h(companion, 0.0f, 1, null), new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Te, composerK, 0), 0.0f, 11, null), new ButtonColor.Light(false, Color.n(ComposeColorsKt.j(composerK, 0).e()), false, null, null, 29, null), onGoToBlockingTabClicked, composerK, ((i4 << 9) & 7168) | 6, 0);
            composer2 = composerK;
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: v0.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeScreenKt.k(onGoToBlockingTabClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function0 function0, int i3, Composer composer, int i4) {
        j(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Composer composer, final int i3) throws XmlPullParserException, IOException {
        Composer composer2;
        Composer composerK = composer.k(369766433);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(369766433, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.strictmode.StrictModeLoading (StrictModeScreen.kt:129)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.m(PaddingKt.j(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), PrimitiveResources_androidKt.a(R.dimen.f95468b, composerK, 0)), 0.0f, PrimitiveResources_androidKt.a(com.google.android.material.R.dimen.f79554a, composerK, 0), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Shimmer shimmerA = ShimmerThemeKt.a(null, composerK, 0, 1);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.Z5, composerK, 6);
            int i4 = R.string.PD;
            ImageKt.b(imageVectorB, StringResources_androidKt.b(i4, composerK, 0), PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), 0.0f, 0.0f, 0.0f, Dp.g(32), 7, null), null, null, 0.0f, null, composerK, 0, 120);
            Modifier modifierC = columnScopeInstance.c(companion, companion2.g());
            String strB = StringResources_androidKt.b(i4, composerK, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composerK, 0).h();
            int i5 = Shimmer.f93784d;
            ComposePlaceHoldersKt.h(modifierC, strB, textStyleH, 0L, shimmerA, composerK, i5 << 12, 8);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composerK, 6);
            ComposePlaceHoldersKt.f(null, 2, ComposeTypographyKt.g(composerK, 0).b(), 0L, 0.0f, null, shimmerA, composerK, (i5 << 18) | 48, 57);
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: v0.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeScreenKt.m(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        l(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void n(Flow viewState, final Function1 onEvent, final ScaffoldState scaffoldState, Composer composer, final int i3) {
        int i4;
        final Flow flow;
        final ScaffoldState scaffoldState2;
        final MutableState mutableState;
        int i5;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Composer composerK = composer.k(-781869189);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scaffoldState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i6 = i4;
        if (composerK.r((i6 & 147) != 146, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-781869189, i6, -1, "cz.mobilesoft.coreblock.scene.dashboard.strictmode.StrictModeScreen (StrictModeScreen.kt:64)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState2 = (MutableState) objG;
            final State stateB = FlowExtKt.b(viewState, new DashboardViewState(PremiumState.None.INSTANCE, null, null, null, null, false, false, false, null, false, false, false, 4094, null), null, null, null, composerK, i6 & 14, 14);
            flow = viewState;
            composerK = composerK;
            int i7 = WhenMappings.f101540a[((DashboardViewState) stateB.getValue()).k().ordinal()];
            if (i7 == 1) {
                scaffoldState2 = scaffoldState;
                composerK.a0(243001934);
                l(composerK, 0);
                composerK.U();
            } else if (i7 != 2) {
                composerK.a0(-1054984659);
                CompositionLocalKt.b(CompositionLocalsKt.f().d(DensityKt.a(((Density) composerK.q(CompositionLocalsKt.f())).getDensity(), 1.0f)), ComposableLambdaKt.e(-1835188390, true, new Function2() { // from class: v0.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StrictModeScreenKt.t(scaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
                composerK.U();
                scaffoldState2 = scaffoldState;
            } else {
                composerK.a0(-1056738236);
                ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
                boolean z2 = (i6 & 112) == 32;
                Object objG2 = composerK.G();
                if (z2 || objG2 == companion.a()) {
                    objG2 = new Function1() { // from class: v0.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StrictModeScreenKt.o(onEvent, (ActivityResult) obj);
                        }
                    };
                    composerK.w(objG2);
                }
                final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 0);
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    composerK.a0(-1056419711);
                    mutableState = mutableState2;
                    ComposableLambda composableLambdaE = ComposableLambdaKt.e(1587177150, true, new Function4() { // from class: v0.f
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return StrictModeScreenKt.p(onEvent, mutableState, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerK, 54);
                    Object objG3 = composerK.G();
                    if (objG3 == companion.a()) {
                        objG3 = new Function0() { // from class: v0.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StrictModeScreenKt.r(mutableState);
                            }
                        };
                        composerK.w(objG3);
                    }
                    Function0 function0 = (Function0) objG3;
                    i5 = i6;
                    ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, function0, composerK, 200064, 19);
                } else {
                    mutableState = mutableState2;
                    i5 = i6;
                    composerK.a0(-1060432537);
                }
                composerK.U();
                boolean Z = composerK.Z(stateB) | composerK.I(context) | composerK.I(managedActivityResultLauncherA);
                Object objG4 = composerK.G();
                if (Z || objG4 == companion.a()) {
                    objG4 = new Function0() { // from class: v0.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictModeScreenKt.s(stateB, mutableState, context, managedActivityResultLauncherA);
                        }
                    };
                    composerK.w(objG4);
                }
                scaffoldState2 = scaffoldState;
                StrictModeStartScreenKt.k(scaffoldState2, (Function0) objG4, null, composerK, (i5 >> 6) & 14, 4);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            flow = viewState;
            scaffoldState2 = scaffoldState;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: v0.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeScreenKt.u(flow, onEvent, scaffoldState2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            function1.invoke(DashboardViewEvent.OnStrictModeOnboardingFinished.f99251a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final Function1 function1, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState sheetState, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1587177150, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.strictmode.StrictModeScreen.<anonymous> (StrictModeScreen.kt:86)");
            }
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: v0.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeScreenKt.q(mutableState, function1);
                    }
                };
                composer.w(objG);
            }
            j((Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MutableState mutableState, Function1 function1) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(new DashboardViewEvent.OnNavPageRequested(DashboardActivity.NavBarItem.Blocking.f99175i));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(State state, MutableState mutableState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher) {
        if (((DashboardViewState) state.getValue()).d()) {
            mutableState.setValue(Boolean.TRUE);
        } else {
            managedActivityResultLauncher.b(StrictModeIntroActivity.Companion.b(StrictModeIntroActivity.f105009i, context, null, StrictModeIntroNavigation.SmartLock, false, 2, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(ScaffoldState scaffoldState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1835188390, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.strictmode.StrictModeScreen.<anonymous> (StrictModeScreen.kt:122)");
            }
            StrictMode3ScreenKt.L(scaffoldState, null, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Flow flow, Function1 function1, ScaffoldState scaffoldState, int i3, Composer composer, int i4) {
        n(flow, function1, scaffoldState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
