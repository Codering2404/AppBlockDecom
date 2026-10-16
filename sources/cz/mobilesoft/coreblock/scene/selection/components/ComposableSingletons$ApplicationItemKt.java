package cz.mobilesoft.coreblock.scene.selection.components;

import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$ApplicationItemKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ApplicationItemKt f118976a = new ComposableSingletons$ApplicationItemKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f118977b = ComposableLambdaKt.c(1877694148, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ApplicationItemKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1877694148, i3, -1, "cz.mobilesoft.coreblock.scene.selection.components.ComposableSingletons$ApplicationItemKt.lambda$1877694148.<anonymous> (ApplicationItem.kt:56)");
            }
            ApplicationStateDTO applicationStateDTO = new ApplicationStateDTO(new ApplicationDTO("com.facebook.katana", "Facebook", null, true, true, null, null, false, null, 484, null), CollectionsKt.listOf(new SubAppStateDTO(new SubApp("Stories", R.string.Hh, "com.facebook.katana", "", CollectionsKt.emptyList()), false, false, 6, null)));
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            Profile.BlockingMode blockingMode = Profile.BlockingMode.Blocklist;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ApplicationItemKt.d(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            ApplicationItemKt.m(null, scaffoldStateG, applicationStateDTO, (Function1) objG, true, blockingMode, null, null, null, composer, (ApplicationStateDTO.f118052c << 6) | 224256, 449);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(boolean z2) {
        return Unit.f139807a;
    }
}
