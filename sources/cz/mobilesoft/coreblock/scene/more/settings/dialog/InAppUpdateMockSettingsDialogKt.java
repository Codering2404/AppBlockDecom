package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.SwitchKt;
import androidx.compose.material.TextFieldKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDateTimePickersKt;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class InAppUpdateMockSettingsDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Function1 function1, MutableState mutableState5) {
        inAppUpdatesMockSettingsDTO.setEnabled(((Boolean) mutableState.getValue()).booleanValue());
        inAppUpdatesMockSettingsDTO.setAppVersion(StringsKt.u(o(mutableState5).i()));
        inAppUpdatesMockSettingsDTO.setReleaseDate(Long.valueOf(((Calendar) mutableState2.getValue()).getTimeInMillis()));
        inAppUpdatesMockSettingsDTO.setAvailable(((Boolean) mutableState3.getValue()).booleanValue());
        inAppUpdatesMockSettingsDTO.setPrioritiesMapString(((TextFieldValue) mutableState4.getValue()).i());
        function1.invoke(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, Function1 function1, int i3, Composer composer, int i4) {
        n(inAppUpdatesMockSettingsDTO, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void n(final InAppUpdatesMockSettingsDTO dto, final Function1 onClosed, Composer composer, final int i3) {
        int i4;
        final InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO;
        final Function1 function1;
        final MutableState mutableState;
        final Function1 function12;
        String strValueOf;
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(onClosed, "onClosed");
        Composer composerK = composer.k(-509015778);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(dto) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onClosed) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-509015778, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.dialog.InAppUpdateMockSettingsDialog (InAppUpdateMockSettingsDialog.kt:40)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(dto.getEnabled()), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState2 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                Integer appVersion = dto.getAppVersion();
                if (appVersion == null || (strValueOf = String.valueOf(appVersion.intValue())) == null) {
                    strValueOf = "";
                }
                objG2 = SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue(strValueOf, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState3 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                Calendar calendar = Calendar.getInstance();
                Long releaseDate = dto.getReleaseDate();
                if (releaseDate != null) {
                    calendar.setTimeInMillis(releaseDate.longValue());
                    Unit unit = Unit.f139807a;
                }
                calendar.set(13, 0);
                objG3 = SnapshotStateKt__SnapshotStateKt.e(calendar, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState4 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(dto.getAvailable()), null, 2, null);
                composerK.w(objG4);
            }
            final MutableState mutableState5 = (MutableState) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                String prioritiesMapString = dto.getPrioritiesMapString();
                if (prioritiesMapString == null) {
                    prioritiesMapString = InAppUpdatesMockSettingsDTO.Companion.a();
                }
                objG5 = SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue(prioritiesMapString, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerK.w(objG5);
            }
            final MutableState mutableState6 = (MutableState) objG5;
            int i5 = i4 & 112;
            boolean z2 = i5 == 32;
            Object objG6 = composerK.G();
            if (z2 || objG6 == companion.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InAppUpdateMockSettingsDialogKt.q(onClosed);
                    }
                };
                composerK.w(objG6);
            }
            BackHandlerKt.a(false, (Function0) objG6, composerK, 0, 1);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerK.q(CompositionLocalsKt.q());
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(companion2, ComposeColorsKt.j(composerK, 0).e(), null, 2, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(BoxScopeInstance.f6642a.f(companion2, companion3.b()), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(f3)), companion3.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A3 = companion4.a();
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
            Updater.e(composerA3, measurePolicyB, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(StringResources_androidKt.b(R.string.ia, composerK, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65532);
            boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.r(mutableState2, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG7);
            }
            SwitchKt.a(zBooleanValue, (Function1) objG7, null, false, null, null, composerK, 48, 60);
            composerK.y();
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion3.i(), composerK, 48);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A4 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyB2, companion4.e());
            Updater.e(composerA4, compositionLocalMapU4, companion4.g());
            Function2 function2B4 = companion4.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion4.f());
            TextKt.c(StringResources_androidKt.b(R.string.ja, composerK, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65532);
            TextFieldValue textFieldValueO = o(mutableState3);
            float f4 = 120;
            Modifier modifierA = SizeKt.A(companion2, Dp.g(f4));
            KeyboardType.Companion companion5 = KeyboardType.f29379b;
            int iD = companion5.d();
            ImeAction.Companion companion6 = ImeAction.f29348b;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, iD, companion6.b(), null, null, null, 115, null);
            boolean Z = composerK.Z(softwareKeyboardController);
            Object objG8 = composerK.G();
            if (Z || objG8 == companion.a()) {
                objG8 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.s(softwareKeyboardController, (KeyboardActionScope) obj);
                    }
                };
                composerK.w(objG8);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG8, null, null, null, null, null, 62, null);
            TextStyle textStyleA = ComposeTypographyKt.g(composerK, 0).a();
            Object objG9 = composerK.G();
            if (objG9 == companion.a()) {
                mutableState = mutableState3;
                objG9 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.t(mutableState, (TextFieldValue) obj);
                    }
                };
                composerK.w(objG9);
            } else {
                mutableState = mutableState3;
            }
            final MutableState mutableState7 = mutableState;
            TextFieldKt.a(textFieldValueO, (Function1) objG9, modifierA, false, false, textStyleA, null, null, null, null, false, null, keyboardOptions, keyboardActions, true, 1, 0, null, null, null, composerK, 432, 221568, 987096);
            composerK.y();
            float f5 = 8;
            MeasurePolicy measurePolicyB3 = RowKt.b(arrangement.o(Dp.g(f5)), companion3.i(), composerK, 54);
            int iA5 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU5 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A5 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A5);
            } else {
                composerK.v();
            }
            Composer composerA5 = Updater.a(composerK);
            Updater.e(composerA5, measurePolicyB3, companion4.e());
            Updater.e(composerA5, compositionLocalMapU5, companion4.g());
            Function2 function2B5 = companion4.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion4.f());
            TextKt.c(StringResources_androidKt.b(R.string.ha, composerK, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65532);
            Modifier modifierA2 = SizeKt.A(companion2, Dp.g(f4));
            Object value = mutableState4.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            Calendar calendar2 = (Calendar) value;
            Object objG10 = composerK.G();
            if (objG10 == companion.a()) {
                objG10 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.u(mutableState4, (Calendar) obj);
                    }
                };
                composerK.w(objG10);
            }
            ComposeDateTimePickersKt.k(modifierA2, calendar2, (Function1) objG10, null, null, null, composerK, 390, 56);
            Modifier modifierA3 = SizeKt.A(companion2, Dp.g(80));
            Object value2 = mutableState4.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "<get-value>(...)");
            Calendar calendar3 = (Calendar) value2;
            Object objG11 = composerK.G();
            if (objG11 == companion.a()) {
                objG11 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.v(mutableState4, (Calendar) obj);
                    }
                };
                composerK.w(objG11);
            }
            ComposeDateTimePickersKt.q(modifierA3, calendar3, (Function1) objG11, null, null, null, false, composerK, 390, 120);
            composerK.y();
            MeasurePolicy measurePolicyB4 = RowKt.b(arrangement.g(), companion3.i(), composerK, 48);
            int iA6 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU6 = composerK.u();
            Modifier modifierF6 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A6 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A6);
            } else {
                composerK.v();
            }
            Composer composerA6 = Updater.a(composerK);
            Updater.e(composerA6, measurePolicyB4, companion4.e());
            Updater.e(composerA6, compositionLocalMapU6, companion4.g());
            Function2 function2B6 = companion4.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                composerA6.w(Integer.valueOf(iA6));
                composerA6.p(Integer.valueOf(iA6), function2B6);
            }
            Updater.e(composerA6, modifierF6, companion4.f());
            TextKt.c(StringResources_androidKt.b(R.string.ka, composerK, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65532);
            boolean zBooleanValue2 = ((Boolean) mutableState5.getValue()).booleanValue();
            Object objG12 = composerK.G();
            if (objG12 == companion.a()) {
                objG12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.w(mutableState5, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG12);
            }
            SwitchKt.a(zBooleanValue2, (Function1) objG12, null, false, null, null, composerK, 48, 60);
            composerK.y();
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.k(), composerK, 0);
            int iA7 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU7 = composerK.u();
            Modifier modifierF7 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A7 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A7);
            } else {
                composerK.v();
            }
            Composer composerA7 = Updater.a(composerK);
            Updater.e(composerA7, measurePolicyA2, companion4.e());
            Updater.e(composerA7, compositionLocalMapU7, companion4.g());
            Function2 function2B7 = companion4.b();
            if (composerA7.i() || !Intrinsics.areEqual(composerA7.G(), Integer.valueOf(iA7))) {
                composerA7.w(Integer.valueOf(iA7));
                composerA7.p(Integer.valueOf(iA7), function2B7);
            }
            Updater.e(composerA7, modifierF7, companion4.f());
            MeasurePolicy measurePolicyB5 = RowKt.b(arrangement.g(), companion3.i(), composerK, 48);
            int iA8 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU8 = composerK.u();
            Modifier modifierF8 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A8 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A8);
            } else {
                composerK.v();
            }
            Composer composerA8 = Updater.a(composerK);
            Updater.e(composerA8, measurePolicyB5, companion4.e());
            Updater.e(composerA8, compositionLocalMapU8, companion4.g());
            Function2 function2B8 = companion4.b();
            if (composerA8.i() || !Intrinsics.areEqual(composerA8.G(), Integer.valueOf(iA8))) {
                composerA8.w(Integer.valueOf(iA8));
                composerA8.p(Integer.valueOf(iA8), function2B8);
            }
            Updater.e(composerA8, modifierF8, companion4.f());
            TextKt.c(StringResources_androidKt.b(R.string.ea, composerK, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65532);
            ButtonType.TinyRound tinyRound = new ButtonType.TinyRound(null, null, StringResources_androidKt.b(R.string.ga, composerK, 0), 3, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            Object objG13 = composerK.G();
            if (objG13 == companion.a()) {
                objG13 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InAppUpdateMockSettingsDialogKt.x(mutableState6);
                    }
                };
                composerK.w(objG13);
            }
            ComposeButtonsKt.i0(null, tinyRound, surface, (Function0) objG13, composerK, 3072, 1);
            composerK.y();
            TextFieldValue textFieldValue = (TextFieldValue) mutableState6.getValue();
            Modifier modifierK = SizeKt.k(SizeKt.h(PaddingKt.m(companion2, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.g(250), 0.0f, 2, null);
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, null, companion5.a(), companion6.b(), null, null, null, 115, null);
            boolean Z2 = composerK.Z(softwareKeyboardController);
            Object objG14 = composerK.G();
            if (Z2 || objG14 == companion.a()) {
                objG14 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.y(softwareKeyboardController, (KeyboardActionScope) obj);
                    }
                };
                composerK.w(objG14);
            }
            KeyboardActions keyboardActions2 = new KeyboardActions((Function1) objG14, null, null, null, null, null, 62, null);
            TextStyle textStyleA2 = ComposeTypographyKt.g(composerK, 0).a();
            Object objG15 = composerK.G();
            if (objG15 == companion.a()) {
                objG15 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InAppUpdateMockSettingsDialogKt.z(mutableState6, (TextFieldValue) obj);
                    }
                };
                composerK.w(objG15);
            }
            TextFieldKt.a(textFieldValue, (Function1) objG15, modifierK, false, false, textStyleA2, null, null, null, null, false, null, keyboardOptions2, keyboardActions2, false, 0, 0, null, null, null, composerK, 432, 24960, 1019864);
            composerK.y();
            MeasurePolicy measurePolicyB6 = RowKt.b(arrangement.o(Dp.g(f3)), companion3.l(), composerK, 6);
            int iA9 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU9 = composerK.u();
            Modifier modifierF9 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A9 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A9);
            } else {
                composerK.v();
            }
            Composer composerA9 = Updater.a(composerK);
            Updater.e(composerA9, measurePolicyB6, companion4.e());
            Updater.e(composerA9, compositionLocalMapU9, companion4.g());
            Function2 function2B9 = companion4.b();
            if (composerA9.i() || !Intrinsics.areEqual(composerA9.G(), Integer.valueOf(iA9))) {
                composerA9.w(Integer.valueOf(iA9));
                composerA9.p(Integer.valueOf(iA9), function2B9);
            }
            Updater.e(composerA9, modifierF9, companion4.f());
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.O4, composerK, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean z3 = i5 == 32;
            Object objG16 = composerK.G();
            if (z3 || objG16 == companion.a()) {
                function12 = onClosed;
                objG16 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InAppUpdateMockSettingsDialogKt.A(function12);
                    }
                };
                composerK.w(objG16);
            } else {
                function12 = onClosed;
            }
            ComposeButtonsKt.i0(modifierC, big, accent, (Function0) objG16, composerK, 0, 0);
            composerK = composerK;
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Lt, composerK, 0), 0.0f, 11, null);
            ButtonColor.Accent accent2 = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zI = composerK.I(dto) | (i5 == 32);
            Object objG17 = composerK.G();
            if (zI || objG17 == companion.a()) {
                final Function1 function13 = function12;
                Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InAppUpdateMockSettingsDialogKt.B(dto, mutableState2, mutableState4, mutableState5, mutableState6, function13, mutableState7);
                    }
                };
                inAppUpdatesMockSettingsDTO = dto;
                function1 = function13;
                composerK.w(function0);
                objG17 = function0;
            } else {
                inAppUpdatesMockSettingsDTO = dto;
                function1 = function12;
            }
            ComposeButtonsKt.i0(modifierC2, big2, accent2, (Function0) objG17, composerK, 0, 0);
            composerK.y();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            inAppUpdatesMockSettingsDTO = dto;
            function1 = onClosed;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InAppUpdateMockSettingsDialogKt.C(inAppUpdatesMockSettingsDTO, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final TextFieldValue o(MutableState mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    private static final void p(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(SoftwareKeyboardController softwareKeyboardController, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.a();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        p(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState, Calendar it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableState mutableState, Calendar it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(MutableState mutableState) {
        mutableState.setValue(new TextFieldValue(InAppUpdatesMockSettingsDTO.Companion.a(), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(SoftwareKeyboardController softwareKeyboardController, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.a();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(MutableState mutableState, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.f139807a;
    }
}
