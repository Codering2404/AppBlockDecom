package cz.mobilesoft.coreblock.scene.sharing.images.ups_downs;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.ComposableSingletons$UpsDownsImageKt;
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
public final class ComposableSingletons$UpsDownsImageKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$UpsDownsImageKt f119441a = new ComposableSingletons$UpsDownsImageKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119442b = ComposableLambdaKt.c(-571712804, false, new Function2() { // from class: s1.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$UpsDownsImageKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f119443c = ComposableLambdaKt.c(-840829297, false, new Function2() { // from class: s1.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$UpsDownsImageKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f119444d = ComposableLambdaKt.c(473550938, false, new Function2() { // from class: s1.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$UpsDownsImageKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f119445e = ComposableLambdaKt.c(-449361075, false, new Function2() { // from class: s1.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$UpsDownsImageKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(473550938, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.ComposableSingletons$UpsDownsImageKt.lambda$473550938.<anonymous> (UpsDownsImage.kt:179)");
            }
            UpsDownsImageKt.e(SizeKt.f(Modifier.b8, 0.0f, 1, null), SocialShareTemplate.UpsDownsPortrait, new SocialsSharePayload(SocialsSharePayload.PeriodType.Trend, CollectionsKt.emptyList(), null, null, 0, "58m", 0, 0L, 0L, null, null, Boolean.TRUE, "+20m", null, "1h 5min", null, 42972, null), "Since April 01 2026", composer, 3126, 0);
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
                ComposerKt.U(-449361075, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.ComposableSingletons$UpsDownsImageKt.lambda$-449361075.<anonymous> (UpsDownsImage.kt:178)");
            }
            UpsDownPreviewFrameKt.b(SocialShareTemplate.UpsDownsPortrait, f119444d, composer, 54);
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
                ComposerKt.U(-571712804, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.ComposableSingletons$UpsDownsImageKt.lambda$-571712804.<anonymous> (UpsDownsImage.kt:157)");
            }
            UpsDownsImageKt.e(SizeKt.f(Modifier.b8, 0.0f, 1, null), SocialShareTemplate.UpsDownsSquare, new SocialsSharePayload(SocialsSharePayload.PeriodType.Trend, CollectionsKt.emptyList(), null, null, 0, "2h 17m", 0, 0L, 0L, null, null, Boolean.FALSE, "-20m", null, "1h 5min", null, 42972, null), "Since April 01 2026", composer, 3126, 0);
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
                ComposerKt.U(-840829297, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.ComposableSingletons$UpsDownsImageKt.lambda$-840829297.<anonymous> (UpsDownsImage.kt:156)");
            }
            UpsDownPreviewFrameKt.b(SocialShareTemplate.UpsDownsSquare, f119442b, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
