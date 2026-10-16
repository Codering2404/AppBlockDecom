package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
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
public final class ComposableSingletons$RadioPickerDialogKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$RadioPickerDialogKt f131144a = new ComposableSingletons$RadioPickerDialogKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f131145b = ComposableLambdaKt.c(-1860935631, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.a0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RadioPickerDialogKt.c((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1860935631, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RadioPickerDialogKt.lambda$-1860935631.<anonymous> (RadioPickerDialog.kt:169)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composer.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            List listListOf = CollectionsKt.listOf((Object[]) new RadioPickerItem[]{new RadioPickerItem(0, "0 seconds", false, 4, null), new RadioPickerItem(3, "3 seconds", false, 4, null), new RadioPickerItem(5, "5 seconds", false), new RadioPickerItem(10, "10 seconds", false)});
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.material3.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$RadioPickerDialogKt.d(((Integer) obj).intValue());
                    }
                };
                composer.w(objG2);
            }
            RadioPickerDialogKt.r(mutableState, "Select timeout", listListOf, 3, (Function1) objG2, "Nice try, but you can't bypass blockings now.", composer, 224310, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(int i3) {
        return Unit.f139807a;
    }
}
