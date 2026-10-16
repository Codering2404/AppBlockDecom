package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class ComposableSingletons$ScheduleOverviewScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ScheduleOverviewScreenKt f122674a = new ComposableSingletons$ScheduleOverviewScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f122675b = ComposableLambdaKt.c(226817127, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.h
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ScheduleOverviewScreenKt.c((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(BoxScope BasePremiumOnboardingScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BasePremiumOnboardingScreen, "$this$BasePremiumOnboardingScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BasePremiumOnboardingScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(226817127, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$ScheduleOverviewScreenKt.lambda$226817127.<anonymous> (ScheduleOverviewScreen.kt:35)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            float f3 = 18;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.jb, composer, 0), null, PaddingKt.m(BasePremiumOnboardingScreen.f(companion, companion2.b()), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), null, ContentScale.f27054a.d(), 0.0f, null, composer, 24624, 104);
            SpacerKt.a(BackgroundKt.b(PaddingKt.m(SizeKt.i(SizeKt.h(BasePremiumOnboardingScreen.f(companion, companion2.b()), 0.0f, 1, null), Dp.g(112)), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.f25715b.j()), Color.n(ComposeColorsKt.j(composer, 0).e())}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 b() {
        return f122675b;
    }
}
