package cz.mobilesoft.coreblock.scene.onboarding;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.permission.privacy.PrivacyItem;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class OnboardingDataUsageScreenKt {
    public static final void f(final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-556926874);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCloseClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-556926874, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingDataUsageScreen (OnboardingDataUsageScreen.kt:45)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(637242136, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.c2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingDataUsageScreenKt.g(onCloseClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.d2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingDataUsageScreenKt.i(onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(final Function0 function0, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(637242136, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingDataUsageScreen.<anonymous> (OnboardingDataUsageScreen.kt:47)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, ComposableLambdaKt.e(-150589475, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingDataUsageScreenKt.h(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableSingletons$OnboardingDataUsageScreenKt.f110874a.d(), composer, 384, 12779520, 98298);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-150589475, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingDataUsageScreen.<anonymous>.<anonymous> (OnboardingDataUsageScreen.kt:51)");
            }
            ComposeCommonsKt.n(StringResources_androidKt.b(R.string.Sf, composer, 0), function0, null, composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0, int i3, Composer composer, int i4) {
        f(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final PrivacyItem privacyItem, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1482215700);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(privacyItem.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1482215700, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.PrivacyItemCard (OnboardingDataUsageScreen.kt:105)");
            }
            ComposeCardsKt.m(null, new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-1972806425, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingDataUsageScreenKt.k(privacyItem, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3072, 5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.b2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingDataUsageScreenKt.l(privacyItem, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(PrivacyItem privacyItem, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1972806425, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.PrivacyItemCard.<anonymous> (OnboardingDataUsageScreen.kt:107)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            float f3 = 6;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            Modifier.Companion companion = Modifier.b8;
            float f4 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f4));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(f3)), companion2.i(), composer, 54);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95495b1, composer, 6), null, SizeKt.v(companion, Dp.g(f4)), ComposeColorsKt.j(composer, 0).b(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(privacyItem.getTitleResId(), composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65534);
            composer.y();
            int descriptionResId = privacyItem.getDescriptionResId();
            composer.a0(-712039236);
            List<Integer> descriptionPlaceholderResIds = privacyItem.getDescriptionPlaceholderResIds();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(descriptionPlaceholderResIds, 10));
            Iterator<T> it = descriptionPlaceholderResIds.iterator();
            while (it.hasNext()) {
                arrayList.add(StringResources_androidKt.b(((Number) it.next()).intValue(), composer, 0));
            }
            composer.U();
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            TextKt.c(StringResources_androidKt.c(descriptionResId, Arrays.copyOf(strArr, strArr.length), composer, 0), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
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
    public static final Unit l(PrivacyItem privacyItem, int i3, Composer composer, int i4) {
        j(privacyItem, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
