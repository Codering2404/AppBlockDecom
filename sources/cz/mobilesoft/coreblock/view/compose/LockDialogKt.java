package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CheckboxColors;
import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class LockDialogKt {
    public static final void i(final boolean z2, final boolean z3, final Function0 onDismissRequest, final Function0 onLockClicked, final Function0 onCancelClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onLockClicked, "onLockClicked");
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Composer composerK = composer.k(582648650);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismissRequest) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onLockClicked) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onCancelClicked) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(582648650, i4, -1, "cz.mobilesoft.coreblock.view.compose.LockDialog (LockDialog.kt:34)");
            }
            if (!z3) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.g9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LockDialogKt.j(z2, z3, onDismissRequest, onLockClicked, onCancelClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composer2 = composerK;
            AndroidAlertDialog_androidKt.a(onDismissRequest, ComposableLambdaKt.e(95321090, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.h9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockDialogKt.k(onLockClicked, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableLambdaKt.e(433608640, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.i9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockDialogKt.m(onCancelClicked, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableSingletons$LockDialogKt.f130386a.j(), ComposableLambdaKt.e(941039965, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.j9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockDialogKt.o(z2, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposeColorsKt.j(composerK, 0).l0(), 0L, 0L, 0L, 0.0f, null, composer2, ((i4 >> 6) & 14) | 1772592, 0, 16020);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.k9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockDialogKt.q(z2, z3, onDismissRequest, onLockClicked, onCancelClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(boolean z2, boolean z3, Function0 function0, Function0 function02, Function0 function03, int i3, Composer composer, int i4) {
        i(z2, z3, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final Function0 function0, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(95321090, i3, -1, "cz.mobilesoft.coreblock.view.compose.LockDialog.<anonymous> (LockDialog.kt:92)");
            }
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.n9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LockDialogKt.l(mutableState, function0);
                    }
                };
                composer.w(objG);
            }
            ButtonKt.e((Function0) objG, null, false, null, null, null, null, null, null, ComposableSingletons$LockDialogKt.f130386a.i(), composer, 805306368, 510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(MutableState mutableState, Function0 function0) {
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            PrefManager.f126839a.E2(false);
        }
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final Function0 function0, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(433608640, i3, -1, "cz.mobilesoft.coreblock.view.compose.LockDialog.<anonymous> (LockDialog.kt:106)");
            }
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.l9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LockDialogKt.n(mutableState, function0);
                    }
                };
                composer.w(objG);
            }
            ButtonKt.e((Function0) objG, null, false, null, null, null, null, null, null, ComposableSingletons$LockDialogKt.f130386a.h(), composer, 805306368, 510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(MutableState mutableState, Function0 function0) {
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            PrefManager.f126839a.E2(false);
        }
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(941039965, i3, -1, "cz.mobilesoft.coreblock.view.compose.LockDialog.<anonymous> (LockDialog.kt:50)");
            }
            Modifier.Companion companion = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.t3, composer, 6), null, PaddingKt.k(RowScopeInstance.f7101a.d(companion, companion2.i()), Dp.g(12), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).k(), composer, 48, 0);
            androidx.compose.material3.TextKt.c(StringResources_androidKt.b(z2 ? R.string.yj : R.string.t7, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            composer.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, companion);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            CheckboxColors checkboxColorsB = CheckboxDefaults.f16275a.b(ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q(), 0L, 0L, 0L, 0L, composer, CheckboxDefaults.f16276b << 18, 60);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.m9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LockDialogKt.p(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            CheckboxKt.a(zBooleanValue, (Function1) objG, null, false, checkboxColorsB, null, composer, 48, 44);
            androidx.compose.material3.TextKt.c(StringResources_androidKt.b(R.string.Dk, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            composer.y();
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
    public static final Unit p(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(boolean z2, boolean z3, Function0 function0, Function0 function02, Function0 function03, int i3, Composer composer, int i4) {
        i(z2, z3, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
