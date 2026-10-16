package cz.mobilesoft.coreblock.scene.sharing.images.screentime;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$ScreenTimeImageKt;
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
public final class ComposableSingletons$ScreenTimeImageKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ScreenTimeImageKt f119430a = new ComposableSingletons$ScreenTimeImageKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119431b = ComposableLambdaKt.c(54119506, false, new Function2() { // from class: r1.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScreenTimeImageKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f119432c = ComposableLambdaKt.c(-1272676958, false, new Function2() { // from class: r1.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScreenTimeImageKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f119433d = ComposableLambdaKt.c(-2127899948, false, new Function2() { // from class: r1.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScreenTimeImageKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f119434e = ComposableLambdaKt.c(-1574014940, false, new Function2() { // from class: r1.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScreenTimeImageKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        Float fValueOf = Float.valueOf(2.0f);
        Float fValueOf2 = Float.valueOf(15.0f);
        Float fValueOf3 = Float.valueOf(14.0f);
        Float fValueOf4 = Float.valueOf(11.0f);
        Float fValueOf5 = Float.valueOf(12.0f);
        Float fValueOf6 = Float.valueOf(9.0f);
        Float fValueOf7 = Float.valueOf(0.0f);
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(54119506, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$ScreenTimeImageKt.lambda$54119506.<anonymous> (ScreenTimeImage.kt:145)");
            }
            ScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), SocialShareTemplate.ScreenTimeSquare, new SocialsSharePayload(SocialsSharePayload.PeriodType.Day, CollectionsKt.listOf((Object[]) new Float[]{fValueOf7, fValueOf7, fValueOf7, fValueOf6, fValueOf5, fValueOf4, fValueOf3, fValueOf2, Float.valueOf(13.0f), fValueOf6, fValueOf7, fValueOf7, fValueOf, Float.valueOf(10.0f), Float.valueOf(4.0f), fValueOf6, fValueOf, fValueOf4, fValueOf3, fValueOf2, fValueOf5, fValueOf6, fValueOf7, fValueOf7}), null, null, 1, "4h 32m", 2, 0L, 0L, null, null, null, null, null, null, null, 65420, null), "April 12 2026", "1h 12m less than yesterday", composer, 27702, 0);
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
                ComposerKt.U(-1272676958, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$ScreenTimeImageKt.lambda$-1272676958.<anonymous> (ScreenTimeImage.kt:144)");
            }
            ShareCanvasPreviewFrameKt.b(SocialShareTemplate.ScreenTimeSquare, f119431b, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1574014940, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$ScreenTimeImageKt.lambda$-1574014940.<anonymous> (ScreenTimeImage.kt:168)");
            }
            ShareCanvasPreviewFrameKt.b(SocialShareTemplate.ScreenTimePortrait, f119433d, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2127899948, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.screentime.ComposableSingletons$ScreenTimeImageKt.lambda$-2127899948.<anonymous> (ScreenTimeImage.kt:169)");
            }
            ScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), SocialShareTemplate.ScreenTimePortrait, new SocialsSharePayload(SocialsSharePayload.PeriodType.Week, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(7.0f), Float.valueOf(8.0f), Float.valueOf(5.0f), Float.valueOf(6.0f), Float.valueOf(9.0f), Float.valueOf(10.0f), Float.valueOf(0.0f)}), null, null, 1, "6h 01m", 17, 0L, 0L, Float.valueOf(-0.15f), null, null, null, null, null, null, 64908, null), "10/2/2026 - 16/2/2026", "2h 10m more than last week", composer, 27702, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
