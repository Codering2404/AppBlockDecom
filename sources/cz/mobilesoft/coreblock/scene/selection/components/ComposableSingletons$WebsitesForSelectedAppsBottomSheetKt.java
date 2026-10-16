package cz.mobilesoft.coreblock.scene.selection.components;

import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.FacebookSdk;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.CoroutineScope;

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
public final class ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt f118984a = new ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f118985b = ComposableLambdaKt.c(1972702308, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.a0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1972702308, i3, -1, "cz.mobilesoft.coreblock.scene.selection.components.ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt.lambda$1972702308.<anonymous> (WebsitesForSelectedAppsBottomSheet.kt:140)");
            }
            WebsiteProfileRelation.BlockingType blockingType = WebsiteProfileRelation.BlockingType.DOMAIN;
            PersistentList persistentListB = ExtensionsKt.b(new WebsiteDTO(FacebookSdk.INSTAGRAM_COM, blockingType, false, false, 12, null), new WebsiteDTO(FacebookSdk.FACEBOOK_COM, blockingType, false, false, 12, null), new WebsiteDTO("youtube.com", blockingType, false, false, 12, null));
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composer, 6, 14);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.b0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt.e();
                    }
                };
                composer.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.c0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$WebsitesForSelectedAppsBottomSheetKt.f();
                    }
                };
                composer.w(objG3);
            }
            WebsitesForSelectedAppsBottomSheetKt.e(persistentListB, modalBottomSheetStateJ, coroutineScope, function0, (Function0) objG3, composer, (ModalBottomSheetState.f13222e << 3) | 27654);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.f139807a;
    }
}
