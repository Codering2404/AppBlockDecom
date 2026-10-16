package cz.mobilesoft.coreblock.scene.schedule.condition;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionsScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class ConditionsScreenKt {
    public static final void A(Function0 onCreateCustomCombinationClick, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onCreateCustomCombinationClick, "onCreateCustomCombinationClick");
        Composer composerK = composer.k(565147753);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCreateCustomCombinationClick) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(565147753, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.CreateCustomCombinationCard (ConditionsScreen.kt:245)");
            }
            function0 = onCreateCustomCombinationClick;
            FlatButtonsKt.r(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0.0f, null, FlatButtonColors.Primary.f131166a.a(Color.n(ComposeColorsKt.j(composerK, 0).p()), Color.n(ComposeColorsKt.j(composerK, 0).l0())), false, false, function0, ComposableSingletons$ConditionsScreenKt.f115188a.g(), composerK, ((i4 << 18) & 3670016) | 12582918, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onCreateCustomCombinationClick;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: m1.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConditionsScreenKt.B(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Function0 function0, int i3, Composer composer, int i4) {
        A(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void m(Modifier modifier, final ProfileType profileType, final boolean z2, final Function1 onClick, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        long j3;
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-620531141);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.e(profileType.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onClick) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-620531141, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.ConditionCard (ConditionsScreen.kt:144)");
            }
            final List<Integer> scheduleHintTagResIdList = profileType.getScheduleHintTagResIdList();
            if (scheduleHintTagResIdList == null) {
                scheduleHintTagResIdList = CollectionsKt.emptyList();
            }
            final long jU = ComposeColorsKt.j(composerK, 0).u();
            final RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0));
            Modifier modifierH = SizeKt.h(modifier3, 0.0f, 1, null);
            boolean z3 = !z2;
            boolean zF = composerK.f(jU) | composerK.Z(roundedCornerShapeD);
            Object objG = composerK.G();
            if (zF || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: m1.h1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConditionsScreenKt.n(jU, roundedCornerShapeD, (Modifier) obj);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierR = ComposableExtKt.r(modifierH, z3, (Function1) objG);
            if (z2) {
                composerK.a0(670048898);
                j3 = ComposeColorsKt.j(composerK, 0).l0();
                composerK.U();
            } else {
                composerK.a0(670049510);
                composerK.U();
                j3 = Color.f25715b.j();
            }
            boolean z4 = ((i5 & 7168) == 2048) | ((i5 & 112) == 32);
            Object objG2 = composerK.G();
            if (z4 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: m1.i1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConditionsScreenKt.o(onClick, profileType);
                    }
                };
                composerK.w(objG2);
            }
            CardsKt.j(modifierR, j3, 0.0f, false, null, (Function0) objG2, ComposableLambdaKt.e(156737119, true, new Function3() { // from class: m1.j1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConditionsScreenKt.p(z2, scheduleHintTagResIdList, profileType, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 1572864, 28);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: m1.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConditionsScreenKt.r(modifier3, profileType, z2, onClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier n(long j3, Shape shape, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return BorderKt.f(applyIf, Dp.g(1), j3, shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1, ProfileType profileType) {
        function1.invoke(profileType);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final boolean z2, final List list, ProfileType profileType, ColumnScope BaseCard, Composer composer, int i3) {
        long jQ;
        float f3;
        int i4;
        Arrangement arrangement;
        String strB;
        Modifier.Companion companion;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(156737119, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.ConditionCard.<anonymous> (ConditionsScreen.kt:159)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f4));
            Arrangement arrangement2 = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement2.o(Dp.g(f4));
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion3.k(), composer2, 6);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
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
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement2.o(Dp.g(f4)), companion3.l(), composer2, 54);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierH);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion2, 1.0f, false, 2, null);
            float f5 = 4;
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement2.o(Dp.g(f5)), companion3.k(), composer2, 6);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierC);
            Function0 function0A3 = companion4.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyA2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            Integer titleResId = profileType.getTitleResId();
            if (titleResId == null) {
                composer2.a0(2083127907);
                composer2.U();
                i4 = 0;
                arrangement = arrangement2;
                f3 = f5;
            } else {
                composer2.a0(2083127908);
                String strB2 = StringResources_androidKt.b(titleResId.intValue(), composer2, 0);
                TextStyle textStyleG = ComposeTypographyKt.g(composer2, 0).g();
                if (z2) {
                    composer2.a0(-521556763);
                    jQ = ComposeColorsKt.j(composer2, 0).p();
                } else {
                    composer2.a0(-521555962);
                    jQ = ComposeColorsKt.j(composer2, 0).q();
                }
                composer2.U();
                f3 = f5;
                i4 = 0;
                arrangement = arrangement2;
                TextKt.c(strB2, null, jQ, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleG, composer, 0, 0, 65530);
                composer2 = composer;
                Unit unit = Unit.f139807a;
                composer2.U();
            }
            Integer hintResId = profileType.getHintResId();
            if (hintResId == null) {
                composer2.a0(2083477525);
                composer2.U();
                companion = companion2;
            } else {
                composer2.a0(2083477526);
                int iIntValue = hintResId.intValue();
                Modifier modifierM = PaddingKt.m(companion2, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
                if (profileType == ProfileType.LAUNCH_COUNT) {
                    composer2.a0(-653488058);
                    strB = StringResources_androidKt.c(iIntValue, new Object[]{Integer.valueOf(Limit.LAUNCH_COUNT.getLimitValue())}, composer2, i4);
                } else {
                    composer2.a0(-653486169);
                    strB = StringResources_androidKt.b(iIntValue, composer2, i4);
                }
                composer2.U();
                companion = companion2;
                TextKt.c(strB, modifierM, ComposeColorsKt.j(composer2, i4).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, i4).b(), composer, 48, 0, 65528);
                composer2 = composer;
                Unit unit2 = Unit.f139807a;
                composer2.U();
            }
            composer2.y();
            Integer bigScheduleImageResId = z2 ? profileType.getBigScheduleImageResId() : profileType.getDisabledBigScheduleImageResId();
            if (bigScheduleImageResId == null) {
                composer2.a0(1659690568);
            } else {
                composer2.a0(1659690569);
                ImageKt.a(PainterResources_androidKt.c(bigScheduleImageResId.intValue(), composer2, i4), null, SizeKt.v(companion, Dp.g(64)), null, null, z2 ? 1.0f : 0.5f, null, composer, 432, 88);
                composer2 = composer;
                Unit unit3 = Unit.f139807a;
            }
            composer2.U();
            composer2.y();
            if (z2) {
                composer2.a0(965155335);
                if (list.isEmpty()) {
                    composer2.a0(956730093);
                } else {
                    composer2.a0(965194302);
                    Arrangement arrangement3 = arrangement;
                    FlowLayoutKt.d(SizeKt.h(companion, 0.0f, 1, null), arrangement3.o(Dp.g(8)), arrangement3.o(Dp.g(f3)), null, 0, 1, ComposableLambdaKt.e(16869552, true, new Function3() { // from class: m1.a1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ConditionsScreenKt.q(list, z2, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54), composer2, 1769910, 24);
                }
                composer2.U();
                composer2.U();
            } else {
                composer2.a0(966698577);
                TextKt.c(StringResources_androidKt.b(R.string.f95841ru, composer2, i4), null, ComposeColorsKt.j(composer2, i4).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, i4).d(), composer, 0, 0, 65530);
                composer.U();
            }
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public static final Unit q(List list, boolean z2, FlowRowScope FlowRow, Composer composer, int i3) {
        long jQ;
        long jQ2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        int i4 = 1;
        ?? r5 = 0;
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(16869552, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.ConditionCard.<anonymous>.<anonymous>.<anonymous> (ConditionsScreen.kt:211)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                Modifier.Companion companion = Modifier.b8;
                float fG = Dp.g(i4);
                if (z2) {
                    composer2.a0(1829384277);
                    jQ = ComposeColorsKt.j(composer2, r5).u();
                } else {
                    composer2.a0(1829385109);
                    jQ = ComposeColorsKt.j(composer2, r5).q();
                }
                composer2.U();
                Modifier modifierJ = PaddingKt.j(BorderKt.f(companion, fG, jQ, MaterialTheme.f18110a.b(composer2, MaterialTheme.f18111b).b()), Dp.g(4), Dp.g(2));
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), r5);
                int iA = ComposablesKt.a(composer2, r5);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierJ);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
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
                Updater.e(composerA, measurePolicyG, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                String upperCase = StringResources_androidKt.b(iIntValue, composer2, r5).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer2, r5).d(), 0L, TextUnitKt.i(11), FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null);
                if (z2) {
                    composer2.a0(-552521292);
                    jQ2 = ComposeColorsKt.j(composer2, r5).b();
                } else {
                    composer2.a0(-552520677);
                    jQ2 = ComposeColorsKt.j(composer2, r5).q();
                }
                composer2.U();
                TextKt.c(upperCase, null, jQ2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleE, composer, 0, 0, 65530);
                composer.y();
                composer2 = composer;
                i4 = i4;
                r5 = r5 == true ? 1 : 0;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Modifier modifier, ProfileType profileType, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        m(modifier, profileType, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void s(final ImmutableList disabledConditions, final MutableState showPickerBottomSheet, final boolean z2, final Function1 onConditionSelected, final Function0 onCreateCustomCombinationClick, final Function1 onDisabledConditionClick, final Function0 onCloseClick, Composer composer, final int i3) {
        int i4;
        boolean z3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(disabledConditions, "disabledConditions");
        Intrinsics.checkNotNullParameter(showPickerBottomSheet, "showPickerBottomSheet");
        Intrinsics.checkNotNullParameter(onConditionSelected, "onConditionSelected");
        Intrinsics.checkNotNullParameter(onCreateCustomCombinationClick, "onCreateCustomCombinationClick");
        Intrinsics.checkNotNullParameter(onDisabledConditionClick, "onDisabledConditionClick");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerK = composer.k(1790948130);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(disabledConditions) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(showPickerBottomSheet) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            z3 = z2;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onConditionSelected) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onCreateCustomCombinationClick) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onDisabledConditionClick) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(onCloseClick) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1790948130, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.ConditionsScreen (ConditionsScreen.kt:66)");
            }
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), !DarkThemeKt.a(composerK, 0), null, 4, null);
            boolean z4 = ((i4 & 112) == 32) | ((i4 & 3670016) == 1048576);
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: m1.y0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConditionsScreenKt.t(showPickerBottomSheet, onCloseClick);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            final boolean z5 = z3;
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), ComposableLambdaKt.e(1027280606, true, new Function2() { // from class: m1.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConditionsScreenKt.u(onCloseClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, ComposeColorsKt.j(composerK, 0).e(), 0L, null, ComposableLambdaKt.e(92711795, true, new Function3() { // from class: m1.c1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConditionsScreenKt.v(z5, disabledConditions, onConditionSelected, onCreateCustomCombinationClick, onDisabledConditionClick, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 805306416, 444);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: m1.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConditionsScreenKt.w(disabledConditions, showPickerBottomSheet, z2, onConditionSelected, onCreateCustomCombinationClick, onDisabledConditionClick, onCloseClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, Function0 function0) {
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState.setValue(Boolean.FALSE);
        } else {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1027280606, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.ConditionsScreen.<anonymous> (ConditionsScreen.kt:83)");
            }
            ToolbarKt.e(null, function0, null, false, null, false, false, null, null, composer, 0, 509);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(boolean z2, ImmutableList immutableList, Function1 function1, Function0 function0, Function1 function12, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(it) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(92711795, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.ConditionsScreen.<anonymous> (ConditionsScreen.kt:86)");
            }
            x(it, z2, immutableList, function1, function0, function12, composer, i4 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(ImmutableList immutableList, MutableState mutableState, boolean z2, Function1 function1, Function0 function0, Function1 function12, Function0 function02, int i3, Composer composer, int i4) {
        s(immutableList, mutableState, z2, function1, function0, function12, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void x(final PaddingValues paddingValues, final boolean z2, final ImmutableList immutableList, final Function1 function1, final Function0 function0, final Function1 function12, Composer composer, final int i3) {
        Composer composerK = composer.k(-818803919);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(paddingValues) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(immutableList) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function12) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-818803919, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.Content (ConditionsScreen.kt:106)");
            }
            Modifier modifierJ = PaddingKt.j(ScrollKt.g(PaddingKt.h(Modifier.b8, paddingValues), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), PrimitiveResources_androidKt.a(R.dimen.f95468b, composerK, 0));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(16)), Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = i4;
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.H8 : R.string.b4, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 0, 0, 65534);
            composerK = composerK;
            composerK.a0(-1946973925);
            for (ProfileType profileType : ProfileHelper.f129250a.y()) {
                final boolean z3 = !immutableList.contains(profileType);
                boolean zB = composerK.b(z3) | ((i5 & 7168) == 2048) | ((458752 & i5) == 131072);
                Object objG = composerK.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: m1.e1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ConditionsScreenKt.y(z3, function1, function12, (ProfileType) obj);
                        }
                    };
                    composerK.w(objG);
                }
                m(null, profileType, z3, (Function1) objG, composerK, 0, 1);
            }
            composerK.U();
            A(function0, composerK, (i5 >> 12) & 14);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: m1.f1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConditionsScreenKt.z(paddingValues, z2, immutableList, function1, function0, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(boolean z2, Function1 function1, Function1 function12, ProfileType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (z2) {
            function1.invoke(it);
        } else {
            function12.invoke(it);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(PaddingValues paddingValues, boolean z2, ImmutableList immutableList, Function1 function1, Function0 function0, Function1 function12, int i3, Composer composer, int i4) {
        x(paddingValues, z2, immutableList, function1, function0, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
