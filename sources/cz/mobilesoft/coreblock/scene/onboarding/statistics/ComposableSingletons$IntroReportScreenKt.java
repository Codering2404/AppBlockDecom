package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.login.widget.ToolTipPopup;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.util.Success;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ComposableSingletons$IntroReportScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$IntroReportScreenKt f111361a = new ComposableSingletons$IntroReportScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f111362b = ComposableLambdaKt.c(151472150, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$IntroReportScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f111363c = ComposableLambdaKt.c(1174494108, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$IntroReportScreenKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f111364d = ComposableLambdaKt.c(789127325, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$IntroReportScreenKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1174494108, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ComposableSingletons$IntroReportScreenKt.lambda$1174494108.<anonymous> (IntroReportScreen.kt:414)");
            }
            IntroReportScreenKt.o(6000, 9000, null, null, composer, 54, 12);
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
                ComposerKt.U(151472150, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ComposableSingletons$IntroReportScreenKt.lambda$151472150.<anonymous> (IntroReportScreen.kt:399)");
            }
            Success success = Success.f128020a;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$IntroReportScreenKt.g();
                    }
                };
                composer.w(objG);
            }
            IntroReportScreenKt.q(0.0f, success, true, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, 2, 60, (Function0) objG, composer, 1794486, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(789127325, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ComposableSingletons$IntroReportScreenKt.lambda$789127325.<anonymous> (IntroReportScreen.kt:425)");
            }
            IntroReportScreenKt.o(RCHTTPStatusCodes.BAD_REQUEST, 9000, null, null, composer, 54, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
