package cz.mobilesoft.coreblock.scene.intro;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$OnboardingComposeCommonsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$OnboardingComposeCommonsKt f104473a = new ComposableSingletons$OnboardingComposeCommonsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f104474b = ComposableLambdaKt.c(833913193, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.g
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingComposeCommonsKt.c((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(RowScope TwoLineToolbar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TwoLineToolbar, "$this$TwoLineToolbar");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(TwoLineToolbar) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(833913193, i3, -1, "cz.mobilesoft.coreblock.scene.intro.ComposableSingletons$OnboardingComposeCommonsKt.lambda$833913193.<anonymous> (OnboardingComposeCommons.kt:25)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(RowScope.c(TwoLineToolbar, companion, 1.0f, false, 2, null), composer, 0);
            float f3 = 6;
            OnboardingComposeCommonsKt.g(PaddingKt.m(companion, 0.0f, Dp.g(f3), Dp.g(f3), 0.0f, 9, null), composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 b() {
        return f104474b;
    }
}
