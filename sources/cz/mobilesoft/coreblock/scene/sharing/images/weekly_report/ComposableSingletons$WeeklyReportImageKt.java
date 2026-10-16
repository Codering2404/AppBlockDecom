package cz.mobilesoft.coreblock.scene.sharing.images.weekly_report;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.ShareCanvasPreviewFrameKt;
import cz.mobilesoft.coreblock.scene.sharing.images.weekly_report.ComposableSingletons$WeeklyReportImageKt;
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
public final class ComposableSingletons$WeeklyReportImageKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$WeeklyReportImageKt f119446a = new ComposableSingletons$WeeklyReportImageKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119447b = ComposableLambdaKt.c(-526579318, false, new Function2() { // from class: t1.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WeeklyReportImageKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f119448c = ComposableLambdaKt.c(1292403258, false, new Function2() { // from class: t1.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WeeklyReportImageKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1292403258, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.weekly_report.ComposableSingletons$WeeklyReportImageKt.lambda$1292403258.<anonymous> (WeeklyReportImage.kt:191)");
            }
            ShareCanvasPreviewFrameKt.b(SocialShareTemplate.ScreenTimePortrait, f119447b, composer, 54);
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
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-526579318, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.weekly_report.ComposableSingletons$WeeklyReportImageKt.lambda$-526579318.<anonymous> (WeeklyReportImage.kt:192)");
            }
            WeeklyReportImageKt.c(SizeKt.f(Modifier.b8, 0.0f, 1, null), new SocialsSharePayload(SocialsSharePayload.PeriodType.Week, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(7.0f), Float.valueOf(8.0f), Float.valueOf(5.0f), Float.valueOf(6.0f), Float.valueOf(9.0f), Float.valueOf(10.0f), Float.valueOf(0.0f)}), null, null, 1, "6h 2min", 17, 0L, 0L, Float.valueOf(-0.15f), null, Boolean.FALSE, "-30m", null, null, null, 58764, null), "10/2/2026 - 16/2/2026", "20% lower than last week", composer, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
