package cz.mobilesoft.coreblock.scene.insights.trial_summary;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.TrialSummaryData;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$TrialSummaryScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$TrialSummaryScreenKt f103589a = new ComposableSingletons$TrialSummaryScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f103590b = ComposableLambdaKt.c(578058623, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TrialSummaryScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f103591c = ComposableLambdaKt.c(1803573731, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TrialSummaryScreenKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1803573731, i3, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.ComposableSingletons$TrialSummaryScreenKt.lambda$1803573731.<anonymous> (TrialSummaryScreen.kt:334)");
            }
            TrialSummaryData trialSummaryData = new TrialSummaryData(7, Double.valueOf(52000.0d), 5, Double.valueOf(28000.0d), 81L);
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$TrialSummaryScreenKt.f();
                    }
                };
                composer.w(objG);
            }
            TrialSummaryScreenKt.l(trialSummaryData, strB, (Function0) objG, composer, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(578058623, i3, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.ComposableSingletons$TrialSummaryScreenKt.lambda$578058623.<anonymous> (TrialSummaryScreen.kt:316)");
            }
            TrialSummaryData trialSummaryData = new TrialSummaryData(7, Double.valueOf(52000.0d), 5, Double.valueOf(28000.0d), 81L);
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$TrialSummaryScreenKt.h();
                    }
                };
                composer.w(objG);
            }
            TrialSummaryScreenKt.w(trialSummaryData, strB, (Function0) objG, composer, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }
}
