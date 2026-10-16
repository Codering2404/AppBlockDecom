package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
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
public final class SettingsRowKt {
    public static final void h(boolean z2, final AppBlockingSettings appBlockingSettings, Function1 onEvent, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        final Function1 function1;
        final boolean z4;
        Intrinsics.checkNotNullParameter(appBlockingSettings, "appBlockingSettings");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1740621257);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(appBlockingSettings) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            boolean z5 = i6 != 0 ? true : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(-1740621257, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.SettingsRow (SettingsRow.kt:36)");
            }
            boolean zB = composerK.b(appBlockingSettings.a());
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.l5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(SettingsRowKt.i(appBlockingSettings));
                    }
                });
                composerK.w(objG);
            }
            State state = (State) objG;
            boolean zB2 = composerK.b(appBlockingSettings.b());
            Object objG2 = composerK.G();
            if (zB2 || objG2 == Composer.f23746a.a()) {
                objG2 = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.m5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(SettingsRowKt.j(appBlockingSettings));
                    }
                });
                composerK.w(objG2);
            }
            State state2 = (State) objG2;
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            int i7 = R.dimen.f95467a;
            Modifier modifierK = PaddingKt.k(modifierH, PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 2, null);
            float f3 = 8;
            Modifier modifierK2 = PaddingKt.k(modifierK, 0.0f, Dp.g(f3), 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK2);
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
            int i8 = i5;
            boolean z6 = z5;
            TextKt.c(StringResources_androidKt.b(R.string.f95845t, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65534);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.ar, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65530);
            composerK = composerK;
            composerK.y();
            Modifier modifierK3 = PaddingKt.k(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 1, null);
            float f4 = 2;
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f4)), companion2.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK3);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            int i9 = R.dimen.f95480n;
            RoundedCornerShape roundedCornerShapeE = RoundedCornerShapeKt.e(PrimitiveResources_androidKt.a(i9, composerK, 0), PrimitiveResources_androidKt.a(i9, composerK, 0), Dp.g(f4), Dp.g(f4));
            String strB = StringResources_androidKt.b(R.string.FD, composerK, 0);
            boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
            int i10 = i8 & 896;
            boolean z7 = i10 == 256;
            Object objG3 = composerK.G();
            if (z7 || objG3 == Composer.f23746a.a()) {
                function1 = onEvent;
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.n5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsRowKt.k(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG3);
            } else {
                function1 = onEvent;
            }
            int i11 = (i8 << 9) & 7168;
            n(roundedCornerShapeE, strB, zBooleanValue, z6, (Function1) objG3, composerK, i11, 0);
            RoundedCornerShape roundedCornerShapeE2 = RoundedCornerShapeKt.e(Dp.g(f4), Dp.g(f4), PrimitiveResources_androidKt.a(i9, composerK, 0), PrimitiveResources_androidKt.a(i9, composerK, 0));
            String strB2 = StringResources_androidKt.b(R.string.GD, composerK, 0);
            boolean zBooleanValue2 = ((Boolean) state2.getValue()).booleanValue();
            boolean z8 = i10 == 256;
            Object objG4 = composerK.G();
            if (z8 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.o5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsRowKt.l(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG4);
            }
            n(roundedCornerShapeE2, strB2, zBooleanValue2, z6, (Function1) objG4, composerK, i11, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z4 = z6;
        } else {
            function1 = onEvent;
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function1 function12 = function1;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.p5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsRowKt.m(z4, appBlockingSettings, function12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(AppBlockingSettings appBlockingSettings) {
        return appBlockingSettings.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(AppBlockingSettings appBlockingSettings) {
        return appBlockingSettings.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, boolean z2) {
        function1.invoke(new ScheduleViewEvent.OnAppBlockingSettingCheckedChanged(AppBlockingSetting.Launch, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1, boolean z2) {
        function1.invoke(new ScheduleViewEvent.OnAppBlockingSettingCheckedChanged(AppBlockingSetting.Notifications, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(boolean z2, AppBlockingSettings appBlockingSettings, Function1 function1, int i3, int i4, Composer composer, int i5) {
        h(z2, appBlockingSettings, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(final androidx.compose.foundation.shape.RoundedCornerShape r15, final java.lang.String r16, final boolean r17, boolean r18, final kotlin.jvm.functions.Function1 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.SettingsRowKt.n(androidx.compose.foundation.shape.RoundedCornerShape, java.lang.String, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(String str, boolean z2, boolean z3, Function1 function1, ColumnScope BaseCard, Composer composer, int i3) {
        long jQ;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(955674640, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.SwitchCard.<anonymous> (SettingsRow.kt:117)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.e(), Alignment.f25072a.i(), composer, 54);
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
            if (z2) {
                composer.a0(-1341154432);
                jQ = ComposeColorsKt.j(composer, 0).p();
            } else {
                composer.a0(-1341153631);
                jQ = ComposeColorsKt.j(composer, 0).q();
            }
            composer.U();
            TextKt.c(str, null, jQ, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SwitchKt.a(z3, function1, SizeKt.A(SizeKt.i(companion, Dp.g(32)), Dp.g(52)), null, z2, cz.mobilesoft.coreblock.view.compose.material3.SwitchKt.a(composer, 0), null, composer, 384, 72);
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
    public static final Unit p(RoundedCornerShape roundedCornerShape, String str, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        n(roundedCornerShape, str, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
