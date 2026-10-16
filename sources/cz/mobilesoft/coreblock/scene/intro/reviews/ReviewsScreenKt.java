package cz.mobilesoft.coreblock.scene.intro.reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RatingBar;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.LayoutRatingBarBinding;
import cz.mobilesoft.coreblock.enums.Review;
import cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem;
import cz.mobilesoft.coreblock.scene.intro.question.ExplanationScreenKt;
import cz.mobilesoft.coreblock.scene.intro.reviews.ReviewsScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ReviewsScreenKt {
    public static final void g(final Review review, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(review, "review");
        Composer composerK = composer.k(2109948017);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(review.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2109948017, i4, -1, "cz.mobilesoft.coreblock.scene.intro.reviews.ReviewCard (ReviewsScreen.kt:76)");
            }
            ComposeCardsKt.m(null, new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-599804330, true, new Function2() { // from class: a1.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReviewsScreenKt.h(review, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3456, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: a1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReviewsScreenKt.k(review, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(final Review review, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-599804330, i3, -1, "cz.mobilesoft.coreblock.scene.intro.reviews.ReviewCard.<anonymous> (ReviewsScreen.kt:81)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(review.getReview(), composer, 0), PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65532);
            TextKt.c(review.getUserName(), PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(4), 7, null), ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65528);
            Object objG = composer.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = new Function1() { // from class: a1.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReviewsScreenKt.i((Context) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            boolean zE = composer.e(review.ordinal());
            Object objG2 = composer.G();
            if (zE || objG2 == companion3.a()) {
                objG2 = new Function1() { // from class: a1.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReviewsScreenKt.j(review, (RatingBar) obj);
                    }
                };
                composer.w(objG2);
            }
            AndroidView_androidKt.a(function1, null, (Function1) objG2, composer, 6, 2);
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
    public static final RatingBar i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LayoutRatingBarBinding.c(LayoutInflater.from(context)).getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Review review, RatingBar ratingBar) {
        Intrinsics.checkNotNullParameter(ratingBar, "ratingBar");
        ratingBar.setRating(review.getRating());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Review review, int i3, Composer composer, int i4) {
        g(review, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void l(final OnboardingHelpItem item, Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(484971569);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(item) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(484971569, i4, -1, "cz.mobilesoft.coreblock.scene.intro.reviews.ReviewsScreen (ReviewsScreen.kt:43)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = Boolean.valueOf(ContextExtKt.f(context));
                composerK.w(objG);
            }
            final boolean zBooleanValue = ((Boolean) objG).booleanValue();
            function0 = onContinueClicked;
            ExplanationScreenKt.e(StringResources_androidKt.c(R.string.wm, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composerK, 0)}, composerK, 0), null, null, function0, null, ComposableLambdaKt.e(-399931274, true, new Function3() { // from class: a1.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReviewsScreenKt.m(item, zBooleanValue, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 6) & 7168) | 196608, 22);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onContinueClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: a1.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReviewsScreenKt.n(item, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(OnboardingHelpItem onboardingHelpItem, boolean z2, ColumnScope ExplanationScreen, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-399931274, i3, -1, "cz.mobilesoft.coreblock.scene.intro.reviews.ReviewsScreen.<anonymous> (ReviewsScreen.kt:52)");
            }
            float f3 = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f3));
            Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer2, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, Alignment.f25072a.k(), composer2, 6);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierM);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composer2.a0(-1775897999);
            Iterator it = Review.Companion.b(onboardingHelpItem).iterator();
            while (it.hasNext()) {
                g((Review) it.next(), composer2, 0);
            }
            composer2.U();
            if (z2) {
                composer2.a0(779480546);
            } else {
                composer2.a0(781910140);
                TextKt.c(StringResources_androidKt.b(R.string.bE, composer2, 0), columnScopeInstance.c(Modifier.b8, Alignment.f25072a.g()), ComposeColorsKt.j(composer2, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).b(), 0L, TextUnitKt.i(11), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer, 0, 0, 65528);
                composer2 = composer;
            }
            composer2.U();
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
    public static final Unit n(OnboardingHelpItem onboardingHelpItem, Function0 function0, int i3, Composer composer, int i4) {
        l(onboardingHelpItem, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
