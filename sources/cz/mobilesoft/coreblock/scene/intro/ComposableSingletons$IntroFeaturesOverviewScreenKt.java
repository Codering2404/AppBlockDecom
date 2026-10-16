package cz.mobilesoft.coreblock.scene.intro;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$IntroFeaturesOverviewScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$IntroFeaturesOverviewScreenKt f104468a = new ComposableSingletons$IntroFeaturesOverviewScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f104469b = ComposableLambdaKt.c(270812598, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$IntroFeaturesOverviewScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f104470c = ComposableLambdaKt.c(-597843621, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$IntroFeaturesOverviewScreenKt.i((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(270812598, i3, -1, "cz.mobilesoft.coreblock.scene.intro.ComposableSingletons$IntroFeaturesOverviewScreenKt.lambda$270812598.<anonymous> (IntroFeaturesOverviewScreen.kt:30)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$IntroFeaturesOverviewScreenKt.g();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$IntroFeaturesOverviewScreenKt.h();
                    }
                };
                composer.w(objG2);
            }
            IntroFeaturesOverviewScreenKt.d(function0, (Function0) objG2, composer, 54);
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
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ColumnScope ExplanationScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-597843621, i3, -1, "cz.mobilesoft.coreblock.scene.intro.ComposableSingletons$IntroFeaturesOverviewScreenKt.lambda$-597843621.<anonymous> (IntroFeaturesOverviewScreen.kt:63)");
            }
            IntroFeaturesOverviewScreenKt.j(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 e() {
        return f104470c;
    }
}
