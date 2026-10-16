package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$OnboardingYourPotentialScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$OnboardingYourPotentialScreenKt f111367a = new ComposableSingletons$OnboardingYourPotentialScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f111368b = ComposableLambdaKt.c(-213902471, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OnboardingYourPotentialScreenKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f111369c = ComposableLambdaKt.c(-962654366, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OnboardingYourPotentialScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-213902471, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ComposableSingletons$OnboardingYourPotentialScreenKt.lambda$-213902471.<anonymous> (OnboardingYourPotentialScreen.kt:203)");
            }
            BoxKt.a(BackgroundKt.b(SizeKt.k(Modifier.b8, Dp.g(40), 0.0f, 2, null), Brush.Companion.b(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4288104447L)), Color.n(ColorKt.d(4294916935L))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-962654366, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ComposableSingletons$OnboardingYourPotentialScreenKt.lambda$-962654366.<anonymous> (OnboardingYourPotentialScreen.kt:274)");
            }
            BoxKt.a(SizeKt.k(Modifier.b8, Dp.g(40), 0.0f, 2, null), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 c() {
        return f111368b;
    }

    public final Function2 d() {
        return f111369c;
    }
}
