package cz.mobilesoft.coreblock.scene.intro.schedule;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;

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
public final class ComposableSingletons$ScheduleReadyScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ScheduleReadyScreenKt f104811a = new ComposableSingletons$ScheduleReadyScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f104812b = ComposableLambdaKt.c(-1342036295, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScheduleReadyScreenKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1342036295, i3, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.ComposableSingletons$ScheduleReadyScreenKt.lambda$-1342036295.<anonymous> (ScheduleReadyScreen.kt:42)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            AppIconCache appIconCache = new AppIconCache();
            ProfileViewDTO profileViewDTO = new ProfileViewDTO(10L, false, "New schedule", Profile.BlockingMode.Blocklist, true, false, null, false, false, false, false, CollectionsKt.listOf((Object[]) new String[]{muQRKXGtpOhe.BSc, "druhe", "treti"}), CollectionsKt.emptyList(), CollectionsKt.emptyList(), ExtensionsKt.h(CollectionsKt.emptyList()), Integer.valueOf(R.drawable.m6), "Active till 12:00", null, null, true, true, true, false, true, false, null, ScheduleEmoji.Clock, false, false, false, false, null, null, null, -96075680, 3, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ScheduleReadyScreenKt.d();
                    }
                };
                composer.w(objG);
            }
            ScheduleReadyScreenKt.f(scaffoldStateG, appIconCache, profileViewDTO, null, (Function0) objG, composer, 24576, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
