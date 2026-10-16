package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class ComposableSingletons$ContinuousUseScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ContinuousUseScreenKt f103870a = new ComposableSingletons$ContinuousUseScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f103871b = ComposableLambdaKt.c(-929337363, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ContinuousUseScreenKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-929337363, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ContinuousUseScreenKt.lambda$-929337363.<anonymous> (ContinuousUseScreen.kt:110)");
            }
            int i4 = R.drawable.U4;
            int i5 = R.string.Fu;
            ScheduleEmoji scheduleEmoji = ScheduleEmoji.Hourglass;
            String strB = StringResources_androidKt.b(R.string.Gd, composer, 0);
            String lowerCase = StringResources_androidKt.b(R.string.Qj, composer, 0).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            ScheduleTemplatesSectionKt.O(i4, i5, scheduleEmoji, StringHelperExtKt.p(strB, StringHelperExtKt.q("15", lowerCase, null, 2, null), ", "), composer, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 b() {
        return f103871b;
    }
}
