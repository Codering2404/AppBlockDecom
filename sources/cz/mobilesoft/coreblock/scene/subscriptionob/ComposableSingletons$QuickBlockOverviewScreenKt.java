package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewState;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$QuickBlockOverviewScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$QuickBlockOverviewScreenKt f122667a = new ComposableSingletons$QuickBlockOverviewScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f122668b = ComposableLambdaKt.c(-2134688043, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$QuickBlockOverviewScreenKt.d((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(BoxScope BasePremiumOnboardingScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BasePremiumOnboardingScreen, "$this$BasePremiumOnboardingScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BasePremiumOnboardingScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2134688043, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$QuickBlockOverviewScreenKt.lambda$-2134688043.<anonymous> (QuickBlockOverviewScreen.kt:40)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.fb, composer, 0), null, BasePremiumOnboardingScreen.f(companion, companion2.b()), null, ContentScale.f27054a.d(), 0.0f, null, composer, 24624, 104);
            float f3 = 16;
            Modifier modifierF = BasePremiumOnboardingScreen.f(PaddingKt.i(PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), Dp.g(f3)), companion2.e());
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            QuickBlockViewState quickBlockViewState = new QuickBlockViewState(new QuickBlockRepository.QuickBlockState.Pomodoro(new PomodoroSession(0L, 1L, (TimeHelperExt.c() - TimeUnit.SECONDS.toMillis(2742L)) - ((long) 500), 1500000L, 300000L, 4, false, 0L, 0L, 449, null), false, 2, null), null, CollectionsKt.listOf(new ProfileWithBlockedItems.ApplicationProfileRelationWithApplication(new Application(BuildConfig.LIBRARY_PACKAGE_NAME, "Facebook", "Facebook", false, 2048, 8, null), new ApplicationProfileRelation(0L, BuildConfig.LIBRARY_PACKAGE_NAME, 2L, false, 0, 25, null))), null, null, null, false, null, 1200000L, TimeHelperExt.c(), false, true, null, false, null, false, false, false, false, true, 521466, null);
            long jB = ComposeColorsKt.j(composer, 0).b();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$QuickBlockOverviewScreenKt.e((QuickBlockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            QuickBlockCardKt.R0(quickBlockViewState, (Function1) objG, null, Color.n(jB), false, null, composer, 221616, 0);
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
    public static final Unit e(QuickBlockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final Function3 c() {
        return f122668b;
    }
}
