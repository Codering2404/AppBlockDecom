package cz.mobilesoft.coreblock.scene.selection.recommended;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.messenger.MessengerUtils;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.enums.ProfileType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$RecommendedAppsScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$RecommendedAppsScreenKt f119174a = new ComposableSingletons$RecommendedAppsScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119175b = ComposableLambdaKt.c(-2105238099, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RecommendedAppsScreenKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2105238099, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.ComposableSingletons$RecommendedAppsScreenKt.lambda$-2105238099.<anonymous> (RecommendedAppsScreen.kt:87)");
            }
            RecommendedAppsViewState recommendedAppsViewState = new RecommendedAppsViewState(ExtensionsKt.b(new ApplicationDTO("com.facebook.katana", "Facebook", null, true, true, 50, null, false, null, 452, null), new ApplicationDTO("com.instagram.android", "Instagram", null, true, true, 35, null, false, null, 452, null), new ApplicationDTO(MessengerUtils.PACKAGE_NAME, "Messenger", null, true, true, 25, null, false, null, 452, null), new ApplicationDTO("com.zhiliaoapp.musically", "TikTok", null, false, true, 20, null, false, null, 452, null), new ApplicationDTO("com.snapchat.android", "Snapchat", null, false, true, 10, null, false, null, 452, null)), null, 2, null);
            Integer titleResId = ProfileType.QUICK_BLOCK.getTitleResId();
            MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$RecommendedAppsScreenKt.d((RecommendedAppsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            RecommendedAppsScreenKt.w(recommendedAppsViewState, titleResId, mutableStateE, (Function1) objG, composer, 3072);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(RecommendedAppsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
