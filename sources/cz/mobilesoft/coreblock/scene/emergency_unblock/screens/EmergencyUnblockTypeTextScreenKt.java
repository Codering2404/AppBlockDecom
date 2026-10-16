package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmergencyUnblockTypeTextScreenKt {
    public static final void i(final Function0 onCloseClicked, final Function0 onContinueUnblocking, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onContinueUnblocking, "onContinueUnblocking");
        Composer composerK = composer.k(-1551555412);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCloseClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueUnblocking) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1551555412, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockTypeTextScreen (EmergencyUnblockTypeTextScreen.kt:72)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-558786886, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.g0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EmergencyUnblockTypeTextScreenKt.n(z2, onContinueUnblocking, mutableState2, mutableState, onCloseClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmergencyUnblockTypeTextScreenKt.u(onCloseClicked, onContinueUnblocking, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String j(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void k(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final boolean l(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void m(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final boolean z2, final Function0 function0, final MutableState mutableState, final MutableState mutableState2, final Function0 function02, BoxScope GradientBox, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(GradientBox) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-558786886, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockTypeTextScreen.<anonymous> (EmergencyUnblockTypeTextScreen.kt:80)");
            }
            ScaffoldKt.a(GradientBox.f(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), Alignment.f25072a.m()), null, null, ComposableLambdaKt.e(-137197004, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmergencyUnblockTypeTextScreenKt.o(z2, function0, mutableState, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(1568926524, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EmergencyUnblockTypeTextScreenKt.q(function02, z2, mutableState2, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12779520, 98294);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, final Function0 function0, MutableState mutableState, MutableState mutableState2, Composer composer, int i3) {
        Modifier.Companion companion;
        float f3;
        float f4;
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-137197004, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockTypeTextScreen.<anonymous>.<anonymous> (EmergencyUnblockTypeTextScreen.kt:158)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            float f5 = 16;
            Modifier modifierD = BackgroundKt.d(PaddingKt.k(companion2, Dp.g(f5), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).e(), null, 2, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f6 = 8;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f6)), composer2, 6);
            if (l(mutableState) || StringsKt.p0(j(mutableState2))) {
                companion = companion2;
                f3 = f5;
                f4 = f6;
                composer2.a0(-1883541660);
            } else {
                composer2.a0(-1875222345);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f6)), composer2, 6);
                f4 = f6;
                f3 = f5;
                companion = companion2;
                TextKt.c(StringResources_androidKt.b(R.string.WE, composer2, 0), PaddingKt.k(columnScopeInstance.c(companion2, companion3.g()), Dp.g(f5), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).k(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 0, 0, 65016);
                composer2 = composer;
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer2, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer2, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(Intrinsics.areEqual(j(mutableState2), "If*this*is^not@a%REAL&emergency,I^will*NOT$disableStrict#Mode&weaken^my@COMMITMENT-to^myself&my$goals.I'm&here^to$reduce*SCREEN-TIME,regain^focus,and*build%better#habits.I'll^stick@to*that-NOEXCUSES.This$is^urgent,&next*time*I'll^be%more#MINDFUL&intentional.") || z2, null, false, null, 14, null);
            boolean Z = composer2.Z(function0);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmergencyUnblockTypeTextScreenKt.p(function0);
                    }
                };
                composer2.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer2, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(final Function0 function0, final boolean z2, final MutableState mutableState, final MutableState mutableState2, PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1568926524, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockTypeTextScreen.<anonymous>.<anonymous> (EmergencyUnblockTypeTextScreen.kt:87)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(SizeKt.f(ScrollKt.g(companion, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), 0.0f, 1, null), it);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmergencyUnblockTypeTextScreenKt.r(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 253);
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.VE, composer, 0);
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), Dp.g(f3), 0.0f, 2, null), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer, 6);
            TextKt.c("If*this*is^not@a%REAL&emergency,I^will*NOT$disableStrict#Mode&weaken^my@COMMITMENT-to^myself&my$goals.I'm&here^to$reduce*SCREEN-TIME,regain^focus,and*build%better#habits.I'll^stick@to*that-NOEXCUSES.This$is^urgent,&next*time*I'll^be%more#MINDFUL&intentional.", PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).b(), TextUnitKt.i(17), FontStyle.c(FontStyle.f29211b.a()), null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, null, composer, 3078, 0, 130528);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            final BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            CompositionLocalKt.b(CompositionLocalsKt.r().d(new NoOpTextToolbar()), ComposableLambdaKt.e(-1840356992, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmergencyUnblockTypeTextScreenKt.s(boxScopeInstance, z2, mutableState, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.f24012i | 48);
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
    public static final Unit r(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(BoxScope boxScope, final boolean z2, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1840356992, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockTypeTextScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockTypeTextScreen.kt:124)");
            }
            String strJ = j(mutableState);
            Modifier modifierK = SizeKt.k(Modifier.b8, Dp.g(150), 0.0f, 2, null);
            long jL0 = ComposeColorsKt.j(composer, 0).l0();
            int i4 = R.dimen.f95478l;
            Modifier modifierH = SizeKt.h(boxScope.f(BackgroundKt.c(modifierK, jL0, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i4, composer, 0))), Alignment.f25072a.e()), 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i4, composer, 0));
            TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(ComposeColorsKt.j(composer, 0).p(), 0L, ComposeColorsKt.j(composer, 0).l0(), 0L, 0L, ComposeColorsKt.j(composer, 0).b(), Color.f25715b.j(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 1572864, 0, 48, 2097050);
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.f29372b.b(), Boolean.FALSE, KeyboardType.f29379b.h(), ImeAction.f29348b.b(), null, null, null, 112, null);
            boolean zB = composer.b(z2);
            Object objG = composer.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EmergencyUnblockTypeTextScreenKt.t(z2, mutableState, mutableState2, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.c(strJ, (Function1) objG, modifierH, false, false, null, null, null, null, null, false, null, keyboardOptions, null, false, 0, 0, null, roundedCornerShapeD, textFieldColorsO, composer, 0, 384, 258040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(boolean z2, MutableState mutableState, MutableState mutableState2, String rawInput) {
        Intrinsics.checkNotNullParameter(rawInput, "rawInput");
        if (rawInput.length() <= j(mutableState).length() + 3) {
            String strB1 = StringsKt.B1(rawInput, 258);
            k(mutableState, strB1);
            m(mutableState2, v(strB1, "If*this*is^not@a%REAL&emergency,I^will*NOT$disableStrict#Mode&weaken^my@COMMITMENT-to^myself&my$goals.I'm&here^to$reduce*SCREEN-TIME,regain^focus,and*build%better#habits.I'll^stick@to*that-NOEXCUSES.This$is^urgent,&next*time*I'll^be%more#MINDFUL&intentional.") || z2);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0, Function0 function02, boolean z2, int i3, Composer composer, int i4) {
        i(function0, function02, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final boolean v(String message, String controlText) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(controlText, "controlText");
        int length = message.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (message.charAt(i3) != controlText.charAt(i3)) {
                return false;
            }
        }
        return true;
    }
}
