package cz.mobilesoft.coreblock.scene.selection.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.dto.WebAllowlistBrowserItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt f118978a = new ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f118979b = ComposableLambdaKt.c(1262471178, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.v
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1262471178, i3, -1, "cz.mobilesoft.coreblock.scene.selection.components.ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt.lambda$1262471178.<anonymous> (BrowsersForWebAllowlistBottomSheet.kt:145)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new WebAllowlistBrowserItem[]{new WebAllowlistBrowserItem("com.android.chrome", "Chrome", null, 4, null), new WebAllowlistBrowserItem("org.mozilla.firefox", "Firefox", null, 4, null), new WebAllowlistBrowserItem("com.brave.browser", "Brave", null, 4, null)});
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt.e();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BrowsersForWebAllowlistBottomSheetKt.f((List) obj);
                    }
                };
                composer.w(objG2);
            }
            BrowsersForWebAllowlistBottomSheetKt.l(listListOf, function0, (Function1) objG2, composer, 432);
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
    public static final Unit f(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
