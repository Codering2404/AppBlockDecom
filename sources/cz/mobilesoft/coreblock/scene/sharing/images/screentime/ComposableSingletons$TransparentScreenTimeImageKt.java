package cz.mobilesoft.coreblock.scene.sharing.images.screentime;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$TransparentScreenTimeImageKt;
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
public final class ComposableSingletons$TransparentScreenTimeImageKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$TransparentScreenTimeImageKt f119435a = new ComposableSingletons$TransparentScreenTimeImageKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119436b = ComposableLambdaKt.c(-722583051, false, new Function2() { // from class: r1.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TransparentScreenTimeImageKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f119437c = ComposableLambdaKt.c(426529605, false, new Function2() { // from class: r1.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TransparentScreenTimeImageKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(426529605, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$TransparentScreenTimeImageKt.lambda$426529605.<anonymous> (TransparentScreenTimeImage.kt:105)");
            }
            ShareCanvasPreviewFrameKt.b(SocialShareTemplate.ScreenTimeTransparent, f119436b, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        Float fValueOf = Float.valueOf(9.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-722583051, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$TransparentScreenTimeImageKt.lambda$-722583051.<anonymous> (TransparentScreenTimeImage.kt:106)");
            }
            TransparentScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), new SocialsSharePayload(SocialsSharePayload.PeriodType.Day, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(2.0f), Float.valueOf(10.0f), Float.valueOf(7.0f), fValueOf, Float.valueOf(12.0f), Float.valueOf(11.0f), Float.valueOf(14.0f), Float.valueOf(15.0f), Float.valueOf(13.0f), fValueOf, fValueOf2, fValueOf2}), null, null, 0, "4h 32m", 2, 0L, 0L, null, null, null, null, null, null, null, 65436, null), "April 12 2026", composer, 390, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
