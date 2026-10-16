package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
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
public final class PreferencesScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A() {
        AnswersHelper.f128199a.y5();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(MutableState mutableState, String str) {
        String str2 = str;
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        answersHelper.z5();
        if (!Intrinsics.areEqual(str2, r(mutableState).c())) {
            answersHelper.x5();
        }
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityR = r(mutableState);
        if (str2 == null) {
            str2 = "";
        }
        s(mutableState, CustomBlockingScreenConfigEntity.b(customBlockingScreenConfigEntityR, null, null, str2, false, 0, false, 0, null, null, null, null, 2043, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(MutableState mutableState) {
        s(mutableState, CustomBlockingScreenConfigEntity.b(r(mutableState), null, null, null, !r(mutableState).j(), 0, false, 0, null, null, null, null, 2039, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(MutableState mutableState) {
        s(mutableState, CustomBlockingScreenConfigEntity.b(r(mutableState), null, null, null, false, 0, !r(mutableState).k(), 0, null, null, null, null, 2015, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(CustomBlockingViewState customBlockingViewState, Function0 function0, Function1 function1, String str, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, int i3, int i4, Composer composer, int i5) {
        q(customBlockingViewState, function0, function1, str, customBlockingScreenConfigEntity, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void o(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-2020009582);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2020009582, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.DescriptionText (PreferencesScreen.kt:176)");
            }
            composer2 = composerK;
            TextKt.c(str, PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, (i4 & 14) | 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.k2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreferencesScreenKt.p(str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, int i3, Composer composer, int i4) {
        o(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0256  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(final cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState r37, final kotlin.jvm.functions.Function0 r38, final kotlin.jvm.functions.Function1 r39, final java.lang.String r40, cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.PreferencesScreenKt.q(cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, java.lang.String, cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final CustomBlockingScreenConfigEntity r(MutableState mutableState) {
        return (CustomBlockingScreenConfigEntity) mutableState.getValue();
    }

    private static final void s(MutableState mutableState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        mutableState.setValue(customBlockingScreenConfigEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, int i3) {
        s(mutableState, CustomBlockingScreenConfigEntity.b(r(mutableState), null, null, null, false, i3, false, 0, null, null, null, null, 2031, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(final Context context, final MutableState mutableState, final Function0 function0, final Function1 function1, final MutableState mutableState2, PaddingValues padding, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        int i5;
        Modifier.Companion companion;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(164381605, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.PreferencesScreen.<anonymous> (PreferencesScreen.kt:75)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(PaddingKt.h(companion2, padding), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            AppBarKt.g(ComposableLambdaKt.e(-882211881, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.n2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreferencesScreenKt.v(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), null, ComposableLambdaKt.e(1753457429, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.o2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreferencesScreenKt.w(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), ComposableLambdaKt.e(273160204, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.p2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreferencesScreenKt.x(function1, function0, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), ComposeColorsKt.j(composer2, 0).e(), 0L, Dp.g(0), composer2, 1576326, 34);
            if (r(mutableState).m() != ConfigType.CUSTOM) {
                composer2.a0(189965128);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer2, 6);
                String strB = StringResources_androidKt.b(R.string.Lj, composer2, 0);
                String strC = r(mutableState).c();
                String str = strC.length() > 0 ? strC : null;
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.H4, composer2, 6);
                boolean zI = composer2.I(context);
                Object objG = composer2.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.q2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreferencesScreenKt.z(context, mutableState);
                        }
                    };
                    composer2.w(objG);
                }
                i5 = 6;
                companion = companion2;
                SectionedItemKt.G(null, strB, null, str, null, null, imageVectorB, null, null, false, 0L, 0L, null, false, (Function0) objG, false, null, 0L, composer, 0, 0, 245685);
                composer2 = composer;
            } else {
                i5 = 6;
                companion = companion2;
                composer2.a0(184945639);
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, i5);
            String strB2 = StringResources_androidKt.b(R.string.h4, composer2, 0);
            boolean zJ = r(mutableState).j();
            ImageVector.Companion companion4 = ImageVector.f26323k;
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion4, R.drawable.f95495b1, composer2, i5);
            Object objG2 = composer2.G();
            Composer.Companion companion5 = Composer.f23746a;
            if (objG2 == companion5.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.r2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreferencesScreenKt.C(mutableState);
                    }
                };
                composer2.w(objG2);
            }
            SectionedItemKt.P(null, strB2, null, null, null, imageVectorB2, 0L, 0L, 0L, null, null, (Function0) objG2, Boolean.valueOf(zJ), false, composer, 0, 48, 10205);
            float f4 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, i5);
            o(StringResources_androidKt.c(R.string.i4, new Object[]{StringResources_androidKt.b(R.string.zD, composer, 0)}, composer, 0), composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, i5);
            String strB3 = StringResources_androidKt.b(R.string.vj, composer, 0);
            String strC2 = StringResources_androidKt.c(R.string.Ev, new Object[]{Integer.valueOf(r(mutableState).l())}, composer, 0);
            ImageVector imageVectorB3 = VectorResources_androidKt.b(companion4, R.drawable.r6, composer, i5);
            Object objG3 = composer.G();
            if (objG3 == companion5.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.s2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreferencesScreenKt.D(mutableState2);
                    }
                };
                composer.w(objG3);
            }
            SectionedItemKt.L(null, strB3, strC2, null, imageVectorB3, 0L, true, false, 0L, null, 0L, 0L, null, null, null, false, (Function0) objG3, composer, 1572864, 1572864, 65449);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, i5);
            o(StringResources_androidKt.b(R.string.uj, composer, 0), composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, i5);
            String strB4 = StringResources_androidKt.b(R.string.Mm, composer, 0);
            boolean zK = r(mutableState).k();
            ImageVector imageVectorB4 = VectorResources_androidKt.b(companion4, R.drawable.H5, composer, i5);
            Object objG4 = composer.G();
            if (objG4 == companion5.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.t2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreferencesScreenKt.E(mutableState);
                    }
                };
                composer.w(objG4);
            }
            SectionedItemKt.P(null, strB4, null, null, null, imageVectorB4, 0L, 0L, 0L, null, null, (Function0) objG4, Boolean.valueOf(zK), false, composer, 0, 48, 10205);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            o(StringResources_androidKt.b(R.string.Nm, composer, 0), composer, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-882211881, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.PreferencesScreen.<anonymous>.<anonymous>.<anonymous> (PreferencesScreen.kt:82)");
            }
            TextKt.c(StringResources_androidKt.b(r(mutableState).m() == ConfigType.CUSTOM ? R.string.dp : R.string.rw, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65534);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1753457429, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.PreferencesScreen.<anonymous>.<anonymous>.<anonymous> (PreferencesScreen.kt:88)");
            }
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6), null, false, 0.0f, 0.0f, ComposeColorsKt.j(composer, 0).b(), StringResources_androidKt.b(R.string.N7, composer, 0), function0, composer, 0, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(final Function1 function1, final Function0 function0, final MutableState mutableState, RowScope TopAppBar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(273160204, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.PreferencesScreen.<anonymous>.<anonymous>.<anonymous> (PreferencesScreen.kt:96)");
            }
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            boolean Z = composer.Z(function1) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.j2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreferencesScreenKt.y(function1, function0, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.c0(strB, null, false, 0L, null, 0.0f, null, (Function0) objG, composer, 0, 126);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1, Function0 function0, MutableState mutableState) {
        function1.invoke(r(mutableState));
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Context context, final MutableState mutableState) {
        AnswersHelper.f128199a.A5();
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            String string = activityB.getString(R.string.Co);
            String strC = r(mutableState).c();
            if (strC.length() <= 0) {
                strC = null;
            }
            DialogHelperExtKt.E(activityB, string, strC, activityB.getString(R.string.Lj), true, null, 1, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.h2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PreferencesScreenKt.A();
                }
            }, 50, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.i2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PreferencesScreenKt.B(mutableState, (String) obj);
                }
            }, 16, null);
        }
        return Unit.f139807a;
    }
}
