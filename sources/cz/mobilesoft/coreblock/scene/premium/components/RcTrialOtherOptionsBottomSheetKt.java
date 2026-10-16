package cz.mobilesoft.coreblock.scene.premium.components;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase;
import cz.mobilesoft.coreblock.usecase.YearlySavingsData;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class RcTrialOtherOptionsBottomSheetKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112580a;

        static {
            int[] iArr = new int[PremiumOptionPeriod.values().length];
            try {
                iArr[PremiumOptionPeriod.Lifetime.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumOptionPeriod.Yearly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PremiumOptionPeriod.Monthly.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f112580a = iArr;
        }
    }

    public static final void g(final PremiumScreenViewState viewState, Function1 onEvent, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        String strB;
        String strB2;
        YearlySavingsData yearlySavingsDataA;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1347593160);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1347593160, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialOtherOptionsBottomSheet (RcTrialOtherOptionsBottomSheet.kt:54)");
            }
            ImmutableList immutableListH = ExtensionsKt.h(CollectionsKt.sortedWith(viewState.w(), new Comparator() { // from class: cz.mobilesoft.coreblock.scene.premium.components.RcTrialOtherOptionsBottomSheetKt$RcTrialOtherOptionsBottomSheet$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.d(Integer.valueOf(((PremiumOptionDTO) obj).j().ordinal()), Integer.valueOf(((PremiumOptionDTO) obj2).j().ordinal()));
                }
            }));
            PremiumOptionDTO premiumOptionDTOD = viewState.D();
            Offering offeringS = viewState.s();
            Integer numValueOf = (offeringS == null || (yearlySavingsDataA = CalculateYearlySavingsUseCase.f126952d.a(offeringS)) == null) ? null : Integer.valueOf(yearlySavingsDataA.c());
            if (viewState.Z()) {
                composerK.a0(1089708621);
                strB = StringResources_androidKt.b(R.string.Zr, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(1089790802);
                strB = StringResources_androidKt.b(R.string.l8, composerK, 0);
                composerK.U();
            }
            boolean zX = viewState.X();
            if (viewState.Z()) {
                composerK.a0(1089984211);
                strB2 = StringResources_androidKt.b(R.string.cl, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(1090060626);
                strB2 = StringResources_androidKt.b(R.string.P4, composerK, 0);
                composerK.U();
            }
            function1 = onEvent;
            h(immutableListH, premiumOptionDTOD, numValueOf, strB, zX, strB2, function1, composerK, (i4 << 15) & 3670016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onEvent;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.e4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RcTrialOtherOptionsBottomSheetKt.i(viewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void h(final ImmutableList optionsToShow, final PremiumOptionDTO premiumOptionDTO, final Integer num, final String buttonText, final boolean z2, final String reassuranceText, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(optionsToShow, "optionsToShow");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(reassuranceText, "reassuranceText");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1980098261);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(optionsToShow) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(premiumOptionDTO) ? 32 : 16;
        }
        Integer num2 = num;
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(num2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(buttonText) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(reassuranceText) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(onEvent) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1980098261, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialOtherOptionsBottomSheet (RcTrialOtherOptionsBottomSheet.kt:94)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).X(), null, 2, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(24), 0.0f, Dp.g(32), 5, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            char c3 = 14;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(14)), companion2.g(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(-1708593197);
            Iterator<E> it = optionsToShow.iterator();
            while (it.hasNext()) {
                final PremiumOptionDTO premiumOptionDTO2 = (PremiumOptionDTO) it.next();
                boolean zAreEqual = Intrinsics.areEqual(premiumOptionDTO2, premiumOptionDTO);
                boolean Z = ((i4 & 3670016) == 1048576) | composerK.Z(premiumOptionDTO2);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.z3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RcTrialOtherOptionsBottomSheetKt.j(onEvent, premiumOptionDTO2);
                        }
                    };
                    composerK.w(objG);
                }
                m(premiumOptionDTO2, zAreEqual, num2, (Function0) objG, composerK, i4 & 896);
                num2 = num;
                c3 = c3;
            }
            composerK.U();
            if (premiumOptionDTO == null) {
                composerK.a0(-1426401339);
                composerK.U();
                i5 = 1048576;
            } else {
                composerK.a0(-1426401338);
                i5 = 1048576;
                TextKt.c(p(premiumOptionDTO, composerK, 0), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65018);
                composerK = composerK;
                Unit unit = Unit.f139807a;
                composerK.U();
            }
            int i6 = i4;
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean z3 = !z2;
            boolean zI = composerK.I(context) | ((i6 & 3670016) == i5) | ((i6 & 112) == 32);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.a4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RcTrialOtherOptionsBottomSheetKt.k(context, onEvent, premiumOptionDTO);
                    }
                };
                composerK.w(objG2);
            }
            Composer composer2 = composerK;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, primary, null, buttonText, null, 0L, null, null, z3, false, (Function0) objG2, composer2, ((i6 << 9) & 3670016) | 24576, 0, 6063);
            composerK = composer2;
            RcTrialPremiumFooterKt.n(reassuranceText, null, composerK, (i6 >> 15) & 14, 2);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.b4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RcTrialOtherOptionsBottomSheetKt.l(optionsToShow, premiumOptionDTO, num, buttonText, z2, reassuranceText, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PremiumScreenViewState premiumScreenViewState, Function1 function1, int i3, Composer composer, int i4) {
        g(premiumScreenViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1, PremiumOptionDTO premiumOptionDTO) {
        function1.invoke(new PremiumScreenViewEvent.OnOptionSelected(premiumOptionDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Context context, Function1 function1, PremiumOptionDTO premiumOptionDTO) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, premiumOptionDTO));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(ImmutableList immutableList, PremiumOptionDTO premiumOptionDTO, Integer num, String str, boolean z2, String str2, Function1 function1, int i3, Composer composer, int i4) {
        h(immutableList, premiumOptionDTO, num, str, z2, str2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void m(final PremiumOptionDTO premiumOptionDTO, final boolean z2, final Integer num, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        String strC;
        String strC2;
        String strC3;
        long jS;
        long jL0;
        Composer composerK = composer.k(-1900655871);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(premiumOptionDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(num) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1900655871, i5, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPlanCard (RcTrialOtherOptionsBottomSheet.kt:151)");
            }
            boolean z3 = premiumOptionDTO.j() == PremiumOptionPeriod.Yearly;
            String strN = premiumOptionDTO.n();
            if (!z3) {
                composerK.a0(-1884573636);
                composerK.U();
                strC = null;
            } else if (num == null) {
                composerK.a0(-1169168756);
                strC = StringResources_androidKt.b(R.string.h3, composerK, 0).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(strC, "toUpperCase(...)");
                composerK.U();
            } else if (strN != null) {
                composerK.a0(-1169167375);
                strC = StringResources_androidKt.c(R.string.Pr, new Object[]{num}, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(-1169164277);
                strC = StringResources_androidKt.c(R.string.Or, new Object[]{num}, composerK, 0);
                composerK.U();
            }
            final String strB = StringResources_androidKt.b(premiumOptionDTO.j().getTitleShort(), composerK, 0);
            if (!z3) {
                composerK.a0(-1883960580);
                composerK.U();
                strC2 = null;
            } else if (strN != null) {
                composerK.a0(-1169150318);
                strC2 = StringResources_androidKt.c(R.string.Yr, new Object[]{strN, 12, premiumOptionDTO.a()}, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(-1169144143);
                strC2 = StringResources_androidKt.c(R.string.Xr, new Object[]{12, premiumOptionDTO.a()}, composerK, 0);
                composerK.U();
            }
            if (WhenMappings.f112580a[premiumOptionDTO.j().ordinal()] == 1) {
                composerK.a0(-1169136242);
                composerK.U();
                strC3 = premiumOptionDTO.a();
            } else {
                composerK.a0(-1169135163);
                int i6 = R.string.kq;
                String strI = premiumOptionDTO.i();
                if (strI == null) {
                    strI = premiumOptionDTO.a();
                }
                strC3 = StringResources_androidKt.c(i6, new Object[]{strI}, composerK, 0);
                composerK.U();
            }
            final String str = strC3;
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            float fG = Dp.g(z2 ? 2 : 1);
            if (z2) {
                composerK.a0(-1169125273);
                jS = ComposeColorsKt.j(composerK, 0).b();
            } else {
                composerK.a0(-1169124658);
                jS = ComposeColorsKt.j(composerK, 0).s();
            }
            composerK.U();
            long j3 = jS;
            float fG2 = Dp.g(22);
            if (z2) {
                composerK.a0(-1169121394);
                jL0 = ComposeColorsKt.j(composerK, 0).i();
            } else {
                composerK.a0(-1169120568);
                jL0 = ComposeColorsKt.j(composerK, 0).l0();
            }
            composerK.U();
            final String str2 = strC2;
            final String str3 = strC;
            composer2 = composerK;
            CardsKt.n(modifierH, fG, j3, fG2, jL0, false, null, function0, ComposableLambdaKt.e(2065877409, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.c4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RcTrialOtherOptionsBottomSheetKt.n(str3, z2, str, strB, str2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, (29360128 & (i5 << 12)) | 100666374, 96);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.d4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RcTrialOtherOptionsBottomSheetKt.o(premiumOptionDTO, z2, num, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, boolean z2, String str2, String str3, String str4, ColumnScope BorderedCard, Composer composer, int i3) {
        long jQ;
        long jU;
        Modifier.Companion companion;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2065877409, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPlanCard.<anonymous> (RcTrialOtherOptionsBottomSheet.kt:200)");
            }
            if (str == null) {
                composer2.a0(1967544894);
            } else {
                composer2.a0(1967544895);
                TextStyle textStyleD = ComposeTypographyKt.g(composer2, 0).d();
                FontWeight fontWeightB = FontWeight.f29233b.b();
                if (z2) {
                    composer2.a0(586700264);
                    jQ = ComposeColorsKt.j(composer2, 0).q0();
                } else {
                    composer2.a0(586700848);
                    jQ = ComposeColorsKt.j(composer2, 0).q();
                }
                composer2.U();
                int iA = TextAlign.f29616b.a();
                Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
                if (z2) {
                    composer2.a0(586707625);
                    jU = ComposeColorsKt.j(composer2, 0).b();
                } else {
                    composer2.a0(586708240);
                    jU = ComposeColorsKt.j(composer2, 0).u();
                }
                composer2.U();
                TextKt.c(str, PaddingKt.k(BackgroundKt.d(modifierH, jU, null, 2, null), 0.0f, Dp.g(6), 1, null), jQ, 0L, null, fontWeightB, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, textStyleD, composer2, 196608, 0, 64984);
                composer2 = composer2;
                Unit unit = Unit.f139807a;
            }
            composer2.U();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(16), Dp.g(14));
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion3.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer2, 48);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA2))) {
                composerA.w(Integer.valueOf(iA2));
                composerA.p(Integer.valueOf(iA2), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion2, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion3.k(), composer2, 0);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierC);
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
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA3))) {
                composerA2.w(Integer.valueOf(iA3));
                composerA2.p(Integer.valueOf(iA3), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Composer composer3 = composer2;
            TextKt.c(str3, null, ComposeColorsKt.j(composer2, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).i(), composer3, 0, 0, 65530);
            Composer composer4 = composer3;
            if (str4 == null) {
                composer4.a0(-2018090930);
                composer4.U();
                companion = companion2;
            } else {
                composer4.a0(-2018090929);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(2)), composer4, 6);
                companion = companion2;
                TextKt.c(str4, null, ComposeColorsKt.j(composer4, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).j(), composer4, 0, 0, 65530);
                composer4 = composer4;
                Unit unit2 = Unit.f139807a;
                composer4.U();
            }
            composer4.y();
            SpacerKt.a(SizeKt.A(companion, Dp.g(12)), composer4, 6);
            TextKt.c(str2, null, ComposeColorsKt.j(composer4, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).i(), composer4, 0, 0, 65530);
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
    public static final Unit o(PremiumOptionDTO premiumOptionDTO, boolean z2, Integer num, Function0 function0, int i3, Composer composer, int i4) {
        m(premiumOptionDTO, z2, num, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final String p(PremiumOptionDTO premiumOptionDTO, Composer composer, int i3) {
        Integer numValueOf;
        String strA;
        composer.a0(1100629830);
        if (ComposerKt.M()) {
            ComposerKt.U(1100629830, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.rcBillingText (RcTrialOtherOptionsBottomSheet.kt:253)");
        }
        PremiumOptionPeriod premiumOptionPeriodJ = premiumOptionDTO.j();
        int[] iArr = WhenMappings.f112580a;
        int i4 = iArr[premiumOptionPeriodJ.ordinal()];
        if (i4 == 1) {
            numValueOf = null;
        } else if (i4 == 2) {
            numValueOf = Integer.valueOf(R.string.Vr);
        } else {
            if (i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            numValueOf = Integer.valueOf(R.string.Ur);
        }
        String strN = premiumOptionDTO.n();
        if (strN == null) {
            composer.a0(1083351482);
        } else {
            composer.a0(1083351483);
            if (numValueOf != null) {
                composer.a0(2079016600);
                String strC = StringResources_androidKt.c(numValueOf.intValue(), new Object[]{strN, premiumOptionDTO.a()}, composer, 0);
                composer.U();
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return strC;
            }
            composer.a0(2079016599);
            composer.U();
        }
        composer.U();
        int i5 = iArr[premiumOptionDTO.j().ordinal()];
        if (i5 == 1) {
            composer.a0(1143339443);
            composer.U();
            strA = premiumOptionDTO.a();
        } else if (i5 == 2) {
            composer.a0(1143331548);
            strA = StringResources_androidKt.c(R.string.lq, new Object[]{premiumOptionDTO.a()}, composer, 0);
            composer.U();
        } else {
            if (i5 != 3) {
                composer.a0(1143329684);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(1143334557);
            strA = StringResources_androidKt.c(R.string.kq, new Object[]{premiumOptionDTO.a()}, composer, 0);
            composer.U();
        }
        String strC2 = StringResources_androidKt.c(R.string.Sr, new Object[]{strA}, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC2;
    }
}
