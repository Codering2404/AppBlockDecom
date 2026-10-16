package cz.mobilesoft.coreblock.scene.more.help;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.NumberedRowKt;
import java.text.MessageFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IgnoreBatteryOptimizationGuideActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f107778g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f107779h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f107780f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) IgnoreBatteryOptimizationGuideActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IgnoreBatteryOptimizationGuideActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f107780f = LazyKt.a(lazyThreadSafetyMode, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
    }

    private final void q0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(874355013);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(874355013, i4, -1, "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity.Content (IgnoreBatteryOptimizationGuideActivity.kt:95)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.h(companion, paddingValues), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            Modifier modifierF3 = BoxScopeInstance.f6642a.f(companion, companion2.o());
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.help.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IgnoreBatteryOptimizationGuideActivity.s0(this.f107815a);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.o0(modifierF3, null, 0, (Function0) objG, composerK, 0, 6);
            Modifier modifierJ = PaddingKt.j(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), PrimitiveResources_androidKt.a(R.dimen.f95468b, composerK, 0));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierJ);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion3.f());
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.J7, composerK, 6), null, ColumnScopeInstance.f6666a.c(companion, companion2.g()), companion2.e(), null, 0.0f, null, composerK, 3120, 112);
            TextKt.c(StringResources_androidKt.b(R.string.So, composerK, 0), PaddingKt.m(companion, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 48, 0, 65532);
            String strB = StringResources_androidKt.b(R.string.f95790f1, composerK, 0);
            String str = MessageFormat.format("{0} {1}:", StringResources_androidKt.c(R.string.Ro, new Object[]{strB, strB}, composerK, 0), StringResources_androidKt.b(R.string.ho, composerK, 0));
            Intrinsics.checkNotNull(str);
            float f3 = 16;
            TextKt.c(str, PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65528);
            composerK = composerK;
            NumberedRowKt.c(1, StringResources_androidKt.b(R.string.Df, composerK, 0), PaddingKt.m(companion, 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null), 0L, 0L, null, 0L, composerK, 390, 120);
            NumberedRowKt.c(2, StringResources_androidKt.b(R.string.Ef, composerK, 0), PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 0L, 0L, null, 0L, composerK, 390, 120);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IgnoreBatteryOptimizationGuideActivity.t0(this.f107816a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity) {
        ignoreBatteryOptimizationGuideActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        ignoreBatteryOptimizationGuideActivity.q0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, final ScaffoldState scaffoldState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1836742648, i3, -1, "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity.RootCompose.<anonymous> (IgnoreBatteryOptimizationGuideActivity.kt:64)");
            }
            final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            final String strB = StringResources_androidKt.b(StrictModeTitleAlternatives.Companion.a(), composer, 0);
            Modifier modifierJ = PaddingKt.j(Modifier.b8, Dp.g(16), Dp.g(8));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Qm, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zI = composer.I(ignoreBatteryOptimizationGuideActivity) | composer.Z(scaffoldState) | composer.Z(strB) | composer.I(context);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.help.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IgnoreBatteryOptimizationGuideActivity.v0(this.f107819a, scaffoldState, strB, context);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
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
    public static final Unit v0(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, ScaffoldState scaffoldState, String str, Context context) {
        CoroutinesHelperExtKt.h(ignoreBatteryOptimizationGuideActivity, new IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1(ignoreBatteryOptimizationGuideActivity, scaffoldState, str, context, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-441402608, i3, -1, "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity.RootCompose.<anonymous> (IgnoreBatteryOptimizationGuideActivity.kt:61)");
            }
            ignoreBatteryOptimizationGuideActivity.q0(it, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        ignoreBatteryOptimizationGuideActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository z0() {
        return (StrictModeRepository) this.f107780f.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(709648910);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(709648910, i4, -1, "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity.RootCompose (IgnoreBatteryOptimizationGuideActivity.kt:52)");
            }
            final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            composer2 = composerK;
            ScaffoldKt.a(null, scaffoldStateG, null, ComposableLambdaKt.e(-1836742648, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IgnoreBatteryOptimizationGuideActivity.u0(this.f107809a, scaffoldStateG, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableSingletons$IgnoreBatteryOptimizationGuideActivityKt.f107720a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-441402608, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.help.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IgnoreBatteryOptimizationGuideActivity.w0(this.f107811a, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 27648, 12582912, 131045);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IgnoreBatteryOptimizationGuideActivity.x0(this.f107812a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
