package cz.mobilesoft.coreblock.scene.intro.quickblock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistOrAllowlistRowKt;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.NumberedRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class QuickBlockBlockingTestActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f104744f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f104745g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) QuickBlockBlockingTestActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f104749a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f104749a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(QuickBlockBlockingTestActivity quickBlockBlockingTestActivity, QuickBlockBlockingTestViewState quickBlockBlockingTestViewState, Function1 function1, int i3, Composer composer, int i4) throws Exception {
        quickBlockBlockingTestActivity.u0(quickBlockBlockingTestViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f104749a[event.ordinal()] == 1) {
            function1.invoke(QuickBlockBlockingTestViewEvent.OnResume.f104752a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(QuickBlockBlockingTestActivity quickBlockBlockingTestActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) throws Exception {
        quickBlockBlockingTestActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void s0(QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel, Composer composer, final int i3) {
        int i4;
        final QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel2;
        Composer composerK = composer.k(-909094697);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(quickBlockBlockingTestViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-909094697, i4, -1, "cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestActivity.CommandProcessor (QuickBlockBlockingTestActivity.kt:97)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new QuickBlockBlockingTestActivity$CommandProcessor$1$1(this, null);
                composerK.w(objG);
            }
            quickBlockBlockingTestViewModel2 = quickBlockBlockingTestViewModel;
            FlowExtKt.g(quickBlockBlockingTestViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            quickBlockBlockingTestViewModel2 = quickBlockBlockingTestViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockBlockingTestActivity.t0(this.f104780a, quickBlockBlockingTestViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(QuickBlockBlockingTestActivity quickBlockBlockingTestActivity, QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel, int i3, Composer composer, int i4) {
        quickBlockBlockingTestActivity.s0(quickBlockBlockingTestViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void u0(final QuickBlockBlockingTestViewState quickBlockBlockingTestViewState, final Function1 function1, Composer composer, final int i3) throws Exception {
        int i4;
        final Function1 function12;
        Composer composer2;
        Composer composerK = composer.k(798999842);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(quickBlockBlockingTestViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(798999842, i4, -1, "cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestActivity.Content (QuickBlockBlockingTestActivity.kt:115)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
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
            Object objG = composerK.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(0, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            int i5 = i4 & 112;
            boolean z2 = i5 == 32;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockBlockingTestActivity.x0(function1);
                    }
                };
                composerK.w(objG2);
            }
            ComposeButtonsKt.o0(null, null, 0, (Function0) objG2, composerK, 0, 7);
            int i6 = R.dimen.f95467a;
            float f3 = 8;
            float fG = Dp.g(PrimitiveResources_androidKt.a(i6, composerK, 0) + Dp.g(f3));
            Modifier modifierG = ScrollKt.g(SizeKt.d(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Object objG3 = composerK.G();
            if (objG3 == companion4.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickBlockBlockingTestActivity.y0(mutableState, (LayoutCoordinates) obj);
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierA = OnGloballyPositionedModifierKt.a(modifierG, (Function1) objG3);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierA);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            float f4 = 16;
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.d8, composerK, 6), null, PaddingKt.k(PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), fG, 0.0f, 2, null), companion2.e(), null, 0.0f, null, composerK, 3120, 112);
            TextKt.c(StringResources_androidKt.b(R.string.gr, composerK, 0), PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), fG, 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 0, 0, 65532);
            TextKt.c(StringResources_androidKt.b(R.string.o4, composerK, 0), PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), fG, 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 65528);
            String strB = StringResources_androidKt.b(R.string.f95790f1, composerK, 0);
            NumberedRowKt.c(1, StringResources_androidKt.b(R.string.s4, composerK, 0), PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null), fG, 0.0f, 2, null), 0L, 0L, null, 0L, composerK, 6, 120);
            Composer composer3 = composerK;
            float fG2 = Dp.g(Dp.g(48) + fG);
            ImmutableList immutableListC = quickBlockBlockingTestViewState.c();
            if ((immutableListC == null || immutableListC.isEmpty()) && !Intrinsics.areEqual(quickBlockBlockingTestViewState.b(), Boolean.TRUE)) {
                composer3.a0(71305524);
            } else {
                composer3.a0(79250235);
                SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer3, 6);
                ImmutableList immutableListC2 = quickBlockBlockingTestViewState.c();
                if (immutableListC2 == null) {
                    immutableListC2 = ExtensionsKt.a();
                }
                BlocklistOrAllowlistRowKt.V(immutableListC2, false, ComposeColorsKt.j(composer3, 0).e(), composer3, 48, 0);
            }
            composer3.U();
            ImmutableList immutableListD = quickBlockBlockingTestViewState.d();
            if (immutableListD == null || immutableListD.isEmpty()) {
                composer3.a0(71305524);
            } else {
                composer3.a0(79627009);
                BlocklistOrAllowlistRowKt.K0(null, quickBlockBlockingTestViewState.d(), ComposeColorsKt.j(composer3, 0).N(), fG2, Dp.g(f4), composer3, 24576, 1);
                composer3 = composer3;
            }
            composer3.U();
            Composer composer4 = composer3;
            NumberedRowKt.c(2, StringResources_androidKt.b(R.string.t4, composer3, 0), PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), fG, 0.0f, 2, null), 0L, 0L, null, 0L, composer4, 6, 120);
            NumberedRowKt.c(3, StringResources_androidKt.c(R.string.u4, new Object[]{strB}, composer4, 0), PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), fG, 0.0f, 2, null), 0L, 0L, null, 0L, composer4, 6, 120);
            composer2 = composer4;
            composer2.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(i6, composer2, 0), 0.0f, 2, null);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.LE, composer2, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean z3 = i5 == 32;
            Object objG4 = composer2.G();
            if (z3 || objG4 == companion4.a()) {
                function12 = function1;
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockBlockingTestActivity.z0(function12);
                    }
                };
                composer2.w(objG4);
            } else {
                function12 = function1;
            }
            ComposeButtonsKt.i0(modifierK, big, accent, (Function0) objG4, composer2, 0, 0);
            SpacerKt.a(SizeKt.i(companion, PrimitiveResources_androidKt.a(R.dimen.f95468b, composer2, 0)), composer2, 0);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function12 = function1;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockBlockingTestActivity.A0(this.f104786a, quickBlockBlockingTestViewState, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int v0(MutableState mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final void w0(MutableState mutableState, int i3) {
        mutableState.setValue(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(Function1 function1) {
        function1.invoke(QuickBlockBlockingTestViewEvent.OnTestSkipped.f104753a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (v0(mutableState) == 0) {
            w0(mutableState, (int) (coordinates.a() >> 32));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(Function1 function1) {
        function1.invoke(QuickBlockBlockingTestViewEvent.OnTestStarted.f104754a);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) throws Exception {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-369489158);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-369489158, i4, -1, "cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestActivity.RootCompose (QuickBlockBlockingTestActivity.kt:79)");
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
            KClass kClassB = Reflection.b(QuickBlockBlockingTestViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel = (QuickBlockBlockingTestViewModel) viewModelA;
            QuickBlockBlockingTestViewState quickBlockBlockingTestViewState = (QuickBlockBlockingTestViewState) FlowExtKt.m(quickBlockBlockingTestViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(quickBlockBlockingTestViewModel, composerK, 0);
            u0(quickBlockBlockingTestViewState, function1N, composerK, (i4 << 3) & 896);
            s0(quickBlockBlockingTestViewModel, composerK, i4 & 112);
            boolean Z = composerK.Z(function1N);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickBlockBlockingTestActivity.B0(function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG);
            }
            ComposableExtKt.j(null, (Function2) objG, composerK, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockBlockingTestActivity.C0(this.f104777a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
