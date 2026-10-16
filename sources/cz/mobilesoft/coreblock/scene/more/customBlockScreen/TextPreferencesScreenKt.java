package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TextPreferencesScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(final Function1 function1, final MutableState mutableState, RowScope TopAppBar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-681500919, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.TextPreferencesScreen.<anonymous>.<anonymous> (TextPreferencesScreen.kt:70)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            long jB = ComposeColorsKt.j(composer, 0).b();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.g3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextPreferencesScreenKt.B(function1, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.c0(strB, null, false, jB, null, 0.0f, null, (Function0) objG, composer, 0, 118);
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
    public static final Unit B(Function1 function1, MutableState mutableState) {
        function1.invoke(v(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        w(mutableState, CustomBlockingScreenConfigEntity.b(v(mutableState), null, null, null, false, 0, false, 0, it, null, null, null, 1919, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        w(mutableState, CustomBlockingScreenConfigEntity.b(v(mutableState), null, null, null, false, 0, false, 0, null, it, null, null, 1791, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        w(mutableState, CustomBlockingScreenConfigEntity.b(v(mutableState), null, null, null, false, 0, false, 0, null, null, it, null, 1535, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        u(customBlockingScreenConfigEntity, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o(final String str, final Function1 function1, final int i3, final int i4, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer composerK = composer.k(-1270535540);
        if ((i5 & 6) == 0) {
            i6 = (composerK.Z(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.e(i4) ? 2048 : 1024;
        }
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1270535540, i6, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomTextPreferencesTextField (TextPreferencesScreen.kt:131)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(companion, Dp.g(16), Dp.g(8));
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            long jL0 = ComposeColorsKt.j(composerK, 0).l0();
            int i7 = R.dimen.f95480n;
            Modifier modifierH = SizeKt.h(BackgroundKt.c(companion, jL0, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i7, composerK, 0))), 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i7, composerK, 0));
            int i8 = i6;
            TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(ComposeColorsKt.j(composerK, 0).L(), 0L, ComposeColorsKt.j(composerK, 0).l0(), 0L, 0L, ComposeColorsKt.j(composerK, 0).b(), Color.f25715b.j(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerK, 1572864, 0, 48, 2097050);
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.f29372b.c(), null, 0, 0, null, null, null, 126, null);
            boolean z2 = ((i8 & 112) == 32) | ((i8 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.h3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextPreferencesScreenKt.p(i3, function1, (String) obj);
                    }
                };
                composerK.w(objG);
            }
            OutlinedTextFieldKt.c(str, (Function1) objG, modifierH, false, false, null, null, null, ComposableLambdaKt.e(2085648858, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.v2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextPreferencesScreenKt.q(i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(750275129, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.w2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextPreferencesScreenKt.r(str, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), false, null, keyboardOptions, null, false, 4, 1, null, roundedCornerShapeD, textFieldColorsO, composerK, (i8 & 14) | 905969664, 1769856, 158968);
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.c(R.string.Yi, new Object[]{Integer.valueOf(str.length()), Integer.valueOf(i3)}, composerK, 0), PaddingKt.m(columnScopeInstance.c(companion, companion2.j()), 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 0, 0, 65528);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.x2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextPreferencesScreenKt.t(str, function1, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i3, Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.length() <= i3) {
            function1.invoke(it);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i3, Composer composer, int i4) {
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2085648858, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomTextPreferencesTextField.<anonymous>.<anonymous> (TextPreferencesScreen.kt:149)");
            }
            IconKt.a(PainterResources_androidKt.c(i3, composer, 0), null, null, ComposeColorsKt.j(composer, 0).b(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(String str, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(750275129, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomTextPreferencesTextField.<anonymous>.<anonymous> (TextPreferencesScreen.kt:162)");
            }
            if (str.length() > 0) {
                composer.a0(436643047);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
                long jM = ComposeColorsKt.j(composer, 0).M();
                float fG = Dp.g(20);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.y2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TextPreferencesScreenKt.s(function1);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, fG, jM, null, (Function0) objG, composer, 196608, 157);
            } else {
                composer.a0(430197961);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1) {
        function1.invoke("");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(String str, Function1 function1, int i3, int i4, int i5, Composer composer, int i6) {
        o(str, function1, i3, i4, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    public static final void u(final CustomBlockingScreenConfigEntity config, final Function0 onCloseClicked, final Function1 onSaveClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onSaveClicked, "onSaveClicked");
        Composer composerK = composer.k(365431952);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(config) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onSaveClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(365431952, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.TextPreferencesScreen (TextPreferencesScreen.kt:44)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(config, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            boolean z2 = (i4 & 112) == 32;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.u2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextPreferencesScreenKt.x(onCloseClicked);
                    }
                };
                composerK.w(objG2);
            }
            BackHandlerKt.a(false, (Function0) objG2, composerK, 0, 1);
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            AppBarKt.g(ComposableSingletons$TextPreferencesScreenKt.f107059a.b(), null, ComposableLambdaKt.e(2085108512, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.z2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextPreferencesScreenKt.y(onCloseClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-681500919, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.a3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextPreferencesScreenKt.A(onSaveClicked, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposeColorsKt.j(composerK, 0).e(), 0L, Dp.g(0), composerK, 1576326, 34);
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.uD, composerK, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 48, 0, 65532);
            String strG = v(mutableState).g();
            int i5 = R.drawable.u6;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.b3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextPreferencesScreenKt.C(mutableState, (String) obj);
                    }
                };
                composerK.w(objG3);
            }
            o(strG, (Function1) objG3, 60, i5, composerK, 432);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.tC, composerK, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 48, 0, 65532);
            String strF = v(mutableState).f();
            int i6 = R.drawable.T3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.c3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextPreferencesScreenKt.D(mutableState, (String) obj);
                    }
                };
                composerK.w(objG4);
            }
            o(strF, (Function1) objG4, 100, i6, composerK, 432);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Zd, composerK, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 48, 0, 65532);
            composerK = composerK;
            String strE = v(mutableState).e();
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.d3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextPreferencesScreenKt.E(mutableState, (String) obj);
                    }
                };
                composerK.w(objG5);
            }
            o(strE, (Function1) objG5, 20, R.drawable.f95540m2, composerK, 432);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.e3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextPreferencesScreenKt.F(config, onCloseClicked, onSaveClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final CustomBlockingScreenConfigEntity v(MutableState mutableState) {
        return (CustomBlockingScreenConfigEntity) mutableState.getValue();
    }

    private static final void w(MutableState mutableState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        mutableState.setValue(customBlockingScreenConfigEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2085108512, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.TextPreferencesScreen.<anonymous>.<anonymous> (TextPreferencesScreen.kt:60)");
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jB = ComposeColorsKt.j(composer, 0).b();
            String strB = StringResources_androidKt.b(R.string.N7, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.f3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextPreferencesScreenKt.z(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jB, strB, (Function0) objG, composer, 0, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }
}
