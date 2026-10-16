package cz.mobilesoft.coreblock.scene.strictmode3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeButtonState;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ThemedSnackbarHostKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;

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
public final class ComposableSingletons$StrictMode3OverviewKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StrictMode3OverviewKt f121092a = new ComposableSingletons$StrictMode3OverviewKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f121093b = ComposableLambdaKt.c(-1174495816, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictMode3OverviewKt.x((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f121094c = ComposableLambdaKt.c(1393678227, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictMode3OverviewKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f121095d = ComposableLambdaKt.c(411356714, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictMode3OverviewKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f121096e = ComposableLambdaKt.c(942497321, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.i
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StrictMode3OverviewKt.w((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f121097f = ComposableLambdaKt.c(-2129897854, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictMode3OverviewKt.A((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f121098g = ComposableLambdaKt.c(302686382, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.k
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictMode3OverviewKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2129897854, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ComposableSingletons$StrictMode3OverviewKt.lambda$-2129897854.<anonymous> (StrictMode3Overview.kt:598)");
            }
            TextKt.c(StringHelperExtKt.p(StringResources_androidKt.b(R.string.ye, composer, 0), "00:00:00", " "), PaddingKt.m(Modifier.b8, Dp.g(4), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).Y(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).j()), composer, 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1393678227, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ComposableSingletons$StrictMode3OverviewKt.lambda$1393678227.<anonymous> (StrictMode3Overview.kt:138)");
            }
            StrictMode3ViewState strictMode3ViewState = new StrictMode3ViewState(new StrictMode3ViewState.ActiveState(StrictModeState.Active, false, false, true, StrictModeButtonState.Deactivate, 6, null), "Active", null, null, "Your blocking are locked against any bypassing when selected schedules are active.", null, ExtensionsKt.b(StrictModeAccessMethod.PinCode, StrictModeAccessMethod.Timer), null, ExtensionsKt.a(), null, new StrictMode3ViewState.MissingPermissions(ExtensionsKt.b(new PermissionDTO(new Permission.USAGE_ACCESS(null, 1, null), false, false, 6, null), new PermissionDTO(Permission.SYSTEM_OVERLAY.f97003d, false, false, 6, null)), false), null, 0L, false, false, false, null, null, null, null, 0L, 2095788, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictMode3OverviewKt.q((StrictMode3ViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictMode3OverviewKt.r();
                    }
                };
                composer.w(objG2);
            }
            StrictMode3OverviewKt.O0(strictMode3ViewState, null, function1, null, false, (Function0) objG2, null, composer, 196992, 90);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(StrictMode3ViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(302686382, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ComposableSingletons$StrictMode3OverviewKt.lambda$302686382.<anonymous> (StrictMode3Overview.kt:923)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierJ = PaddingKt.j(SizeKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(40), 0.0f, 2, null), Dp.g(16), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalB, verticalI, composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.h5, composer, 6), null, null, ComposeColorsKt.j(composer, 0).p(), composer, 48, 4);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Hx, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
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
    public static final Unit t(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(411356714, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ComposableSingletons$StrictMode3OverviewKt.lambda$411356714.<anonymous> (StrictMode3Overview.kt:167)");
            }
            StrictMode3ViewState strictMode3ViewState = new StrictMode3ViewState(new StrictMode3ViewState.ActiveState(StrictModeState.Active, false, false, true, StrictModeButtonState.Deactivate, 6, null), "Active", null, null, "Your blocking are locked against any bypassing when selected schedules are active.", null, ExtensionsKt.b(StrictModeAccessMethod.PinCode, StrictModeAccessMethod.Timer), null, ExtensionsKt.a(), null, new StrictMode3ViewState.MissingPermissions(ExtensionsKt.a(), false), null, 0L, false, false, false, null, null, null, null, 0L, 2095788, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictMode3OverviewKt.u((StrictMode3ViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictMode3OverviewKt.v();
                    }
                };
                composer.w(objG2);
            }
            StrictMode3OverviewKt.O0(strictMode3ViewState, null, function1, null, false, (Function0) objG2, null, composer, 196992, 90);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(StrictMode3ViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(942497321, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ComposableSingletons$StrictMode3OverviewKt.lambda$942497321.<anonymous> (StrictMode3Overview.kt:207)");
            }
            ThemedSnackbarHostKt.b(it, null, composer, i3 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1174495816, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ComposableSingletons$StrictMode3OverviewKt.lambda$-1174495816.<anonymous> (StrictMode3Overview.kt:116)");
            }
            StrictMode3ViewState strictMode3ViewState = new StrictMode3ViewState(new StrictMode3ViewState.ActiveState(null, true, false, false, StrictModeButtonState.Activate, 13, null), "Your blocking are unlocked", null, null, "Activate Strict Mode so you can’t bypass them.", null, ExtensionsKt.b(StrictModeAccessMethod.FollowSchedules), new AccessMethodConfiguration.Schedules(new long[]{1, 2, 3}, null, 2, null), ExtensionsKt.a(), PremiumState.Subscription.Yearly.INSTANCE, null, null, 0L, false, false, false, null, null, null, null, 0L, 2096172, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictMode3OverviewKt.y((StrictMode3ViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictMode3OverviewKt.z();
                    }
                };
                composer.w(objG2);
            }
            StrictMode3OverviewKt.O0(strictMode3ViewState, null, function1, null, false, (Function0) objG2, null, composer, 196992, 90);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(StrictMode3ViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z() {
        return Unit.f139807a;
    }

    public final Function2 m() {
        return f121097f;
    }

    public final Function2 n() {
        return f121098g;
    }

    public final Function3 o() {
        return f121096e;
    }
}
