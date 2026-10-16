package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ThemedSnackbarHostKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableSingletons$SubscriptionOnboardingActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SubscriptionOnboardingActivityKt f122676a = new ComposableSingletons$SubscriptionOnboardingActivityKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f122677b = ComposableLambdaKt.c(67599781, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.i
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SubscriptionOnboardingActivityKt.h((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f122678c = ComposableLambdaKt.c(356114029, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.j
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SubscriptionOnboardingActivityKt.g((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f122679d = ComposableLambdaKt.c(-2017839173, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.k
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SubscriptionOnboardingActivityKt.i((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(BoxScope BasePremiumOnboardingScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BasePremiumOnboardingScreen, "$this$BasePremiumOnboardingScreen");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(BasePremiumOnboardingScreen) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(356114029, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$SubscriptionOnboardingActivityKt.lambda$356114029.<anonymous> (SubscriptionOnboardingActivity.kt:223)");
            }
            ImageKt.a(PainterResources_androidKt.c(R.drawable.O7, composer, 0), null, BasePremiumOnboardingScreen.f(Modifier.b8, Alignment.f25072a.e()), null, ContentScale.f27054a.d(), 0.0f, null, composer, 24624, 104);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(67599781, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$SubscriptionOnboardingActivityKt.lambda$67599781.<anonymous> (SubscriptionOnboardingActivity.kt:74)");
            }
            ThemedSnackbarHostKt.b(it, null, composer, i3 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(BoxScope BaseScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseScreen, "$this$BaseScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2017839173, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$SubscriptionOnboardingActivityKt.lambda$-2017839173.<anonymous> (SubscriptionOnboardingActivity.kt:283)");
            }
            TextKt.c("PREMIUM ONLY", PaddingKt.j(Modifier.b8, Dp.g(12), Dp.g(6)), ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 54, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 d() {
        return f122679d;
    }

    public final Function3 e() {
        return f122678c;
    }

    public final Function3 f() {
        return f122677b;
    }
}
