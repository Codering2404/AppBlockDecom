package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Offset;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class ComposableSingletons$ShareScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ShareScreenKt f103874a = new ComposableSingletons$ShareScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f103875b = ComposableLambdaKt.c(1220786372, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ShareScreenKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1220786372, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ShareScreenKt.lambda$1220786372.<anonymous> (ShareScreen.kt:106)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ShareScreenKt.e((Offset) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            SocialsSharePayload.PeriodType periodType = SocialsSharePayload.PeriodType.WeeklyReport;
            List listListOf = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(7.0f), Float.valueOf(8.0f), Float.valueOf(5.0f), Float.valueOf(6.0f), Float.valueOf(9.0f), Float.valueOf(10.0f), Float.valueOf(0.0f)});
            List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
            AppDistractionType appDistractionType = AppDistractionType.Distractive;
            SocialsSharePayload.ColorfulBarSection colorfulBarSection = new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType);
            AppDistractionType appDistractionType2 = AppDistractionType.Neutral;
            SocialsSharePayload.ColorfulBarSection colorfulBarSection2 = new SocialsSharePayload.ColorfulBarSection(3.0f, appDistractionType2);
            AppDistractionType appDistractionType3 = AppDistractionType.Productive;
            SocialsSharePayload socialsSharePayload = new SocialsSharePayload(periodType, listListOf, listListOf2, CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarValue[]{new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{colorfulBarSection, colorfulBarSection2, new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType3)})), new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{new SocialsSharePayload.ColorfulBarSection(3.0f, appDistractionType), new SocialsSharePayload.ColorfulBarSection(3.0f, appDistractionType2), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType3)})), new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{new SocialsSharePayload.ColorfulBarSection(1.0f, appDistractionType), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType2), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType3)})), new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType2), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType3)})), new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{new SocialsSharePayload.ColorfulBarSection(3.0f, appDistractionType), new SocialsSharePayload.ColorfulBarSection(4.0f, appDistractionType2), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType3)})), new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{new SocialsSharePayload.ColorfulBarSection(4.0f, appDistractionType), new SocialsSharePayload.ColorfulBarSection(4.0f, appDistractionType2), new SocialsSharePayload.ColorfulBarSection(2.0f, appDistractionType3)})), new SocialsSharePayload.ColorfulBarValue(CollectionsKt.listOf((Object[]) new SocialsSharePayload.ColorfulBarSection[]{new SocialsSharePayload.ColorfulBarSection(0.0f, appDistractionType), new SocialsSharePayload.ColorfulBarSection(0.0f, appDistractionType2), new SocialsSharePayload.ColorfulBarSection(0.0f, appDistractionType3)}))}), 3, "3h 04m", 17, 0L, 0L, Float.valueOf(-0.15f), null, null, null, null, null, null, 64512, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ShareScreenKt.f();
                    }
                };
                composer.w(objG2);
            }
            ShareScreenKt.d(function1, socialsSharePayload, "10/2/2026 - 16/2/2026", (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Offset offset) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.f139807a;
    }
}
