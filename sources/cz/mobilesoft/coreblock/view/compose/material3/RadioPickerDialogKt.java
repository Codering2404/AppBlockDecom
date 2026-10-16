package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.RadioButtonColors;
import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class RadioPickerDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1663926012, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.RadioPickerDialog.<anonymous> (RadioPickerDialog.kt:64)");
            }
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final SnackbarHostState snackbarHostState, List list, final MutableState mutableState, final String str, final CoroutineScope coroutineScope, int i3, Composer composer, int i4) {
        Composer composer2 = composer;
        if (composer2.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1918315419, i4, -1, "cz.mobilesoft.coreblock.view.compose.material3.RadioPickerDialog.<anonymous> (RadioPickerDialog.kt:71)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer2, 0);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, companion);
            Function0 function0A2 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composer2.a0(1052433466);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final RadioPickerItem radioPickerItem = (RadioPickerItem) it.next();
                boolean zAreEqual = Intrinsics.areEqual(radioPickerItem.c(), u(mutableState));
                boolean Z = composer2.Z(mutableState) | composer2.I(radioPickerItem);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.n1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RadioPickerDialogKt.D(radioPickerItem, mutableState);
                        }
                    };
                    composer2.w(objG);
                }
                Function0 function0 = (Function0) objG;
                boolean Z2 = composer2.Z(str) | composer2.I(coroutineScope);
                Object objG2 = composer2.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.o1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RadioPickerDialogKt.E(str, coroutineScope, snackbarHostState);
                        }
                    };
                    composer2.w(objG2);
                }
                F(radioPickerItem, zAreEqual, function0, (Function0) objG2, composer2, (i3 >> 9) & 8);
                composer2 = composer;
            }
            composer.U();
            composer.y();
            SnackbarHostKt.b(snackbarHostState, boxScopeInstance.f(Modifier.b8, Alignment.f25072a.b()), null, composer, 6, 4);
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
    public static final Unit D(RadioPickerItem radioPickerItem, MutableState mutableState) {
        v(mutableState, radioPickerItem.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(String str, CoroutineScope coroutineScope, SnackbarHostState snackbarHostState) {
        if (str != null) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new RadioPickerDialogKt$RadioPickerDialog$6$1$1$1$2$1$1$1(snackbarHostState, str, null), 3, null);
        }
        return Unit.f139807a;
    }

    private static final void F(final RadioPickerItem radioPickerItem, final boolean z2, Function0 function0, Function0 function02, Composer composer, final int i3) {
        int i4;
        final Function0 function03;
        final Function0 function04;
        Composer composer2;
        long jS;
        long jS2;
        Composer composerK = composer.k(-1905344316);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(radioPickerItem) : composerK.I(radioPickerItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function03 = function0;
            i4 |= composerK.I(function03) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function03 = function0;
        }
        if ((i3 & 3072) == 0) {
            function04 = function02;
            i4 |= composerK.I(function04) ? 2048 : 1024;
        } else {
            function04 = function02;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1905344316, i4, -1, "cz.mobilesoft.coreblock.view.compose.material3.RadioPickerRow (RadioPickerDialog.kt:135)");
            }
            Function0 function05 = radioPickerItem.a() ? function03 : function04;
            if (radioPickerItem.a()) {
                composerK.a0(-1379810576);
                jS = ComposeColorsKt.j(composerK, 0).p();
            } else {
                composerK.a0(-1379809775);
                jS = ComposeColorsKt.j(composerK, 0).s();
            }
            composerK.U();
            long j3 = jS;
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = SelectableKt.d(SizeKt.h(companion, 0.0f, 1, null), z2, false, null, function05, 6, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            RadioButtonColors radioButtonColorsA = RadioButtonDefaults.f19329a.a(composerK, RadioButtonDefaults.f19330b);
            if (radioPickerItem.a()) {
                composerK.a0(-1526875162);
                jS2 = ComposeColorsKt.j(composerK, 0).b();
            } else {
                composerK.a0(-1526874547);
                jS2 = ComposeColorsKt.j(composerK, 0).s();
            }
            composerK.U();
            RadioButtonKt.a(z2, function05, null, false, RadioButtonColors.b(radioButtonColorsA, jS2, j3, 0L, 0L, 12, null), null, composerK, (i4 >> 3) & 14, 44);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composerK, 6);
            composer2 = composerK;
            TextKt.c(radioPickerItem.b(), null, j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RadioPickerDialogKt.G(radioPickerItem, z2, function03, function04, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(RadioPickerItem radioPickerItem, boolean z2, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        F(radioPickerItem, z2, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o(final String str, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-903455411);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-903455411, i4, -1, "cz.mobilesoft.coreblock.view.compose.material3.DialogTextButton (RadioPickerDialog.kt:112)");
            }
            ButtonKt.e(function0, null, false, RoundedCornerShapeKt.d(Dp.g(8)), null, null, null, null, null, ComposableLambdaKt.e(1536727882, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.material3.f1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RadioPickerDialogKt.p(str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 3) & 14) | 805306368, 502);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RadioPickerDialogKt.q(str, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1536727882, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.DialogTextButton.<anonymous> (RadioPickerDialog.kt:117)");
            }
            Modifier.Companion companion = Modifier.b8;
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.c(upperCase, companion, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).j(), 0L, TextUnitKt.i(13), new FontWeight(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(String str, Function0 function0, int i3, Composer composer, int i4) {
        o(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, String str, List list, Object obj, Function1 function1, String str2, int i3, int i4, Composer composer, int i5) {
        r(mutableState, str, list, obj, function1, str2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, String str, List list, Object obj, Function1 function1, String str2, int i3, int i4, Composer composer, int i5) {
        r(mutableState, str, list, obj, function1, str2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final Object u(MutableState mutableState) {
        return mutableState.getValue();
    }

    private static final void v(MutableState mutableState, Object obj) {
        mutableState.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(final MutableState mutableState, final Function1 function1, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(646368384, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.RadioPickerDialog.<anonymous> (RadioPickerDialog.kt:98)");
            }
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            boolean Z = composer.Z(mutableState) | composer.Z(function1) | composer.Z(mutableState2);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.d1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RadioPickerDialogKt.y(mutableState, function1, mutableState2);
                    }
                };
                composer.w(objG);
            }
            o(strB, (Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(MutableState mutableState, Function1 function1, MutableState mutableState2) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(u(mutableState2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1155147198, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.RadioPickerDialog.<anonymous> (RadioPickerDialog.kt:104)");
            }
            String strB = StringResources_androidKt.b(R.string.O4, composer, 0);
            boolean Z = composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.p1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RadioPickerDialogKt.A(mutableState);
                    }
                };
                composer.w(objG);
            }
            o(strB, (Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(final androidx.compose.runtime.MutableState r23, final java.lang.String r24, final java.util.List r25, final java.lang.Object r26, final kotlin.jvm.functions.Function1 r27, java.lang.String r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.RadioPickerDialogKt.r(androidx.compose.runtime.MutableState, java.lang.String, java.util.List, java.lang.Object, kotlin.jvm.functions.Function1, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }
}
