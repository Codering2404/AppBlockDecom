package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.thankyou;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.thankyou.ComposableSingletons$BackdoorThankYouScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableSingletons$BackdoorThankYouScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BackdoorThankYouScreenKt f102297a = new ComposableSingletons$BackdoorThankYouScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f102298b = ComposableLambdaKt.c(-1628623449, false, new Function2() { // from class: z0.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BackdoorThankYouScreenKt.b((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1628623449, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.thankyou.ComposableSingletons$BackdoorThankYouScreenKt.lambda$-1628623449.<anonymous> (BackdoorThankYouScreen.kt:33)");
            }
            BackdoorThankYouScreenKt.c(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
