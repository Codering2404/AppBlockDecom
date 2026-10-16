package androidx.glance.action;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LambdaActionKt {
    public static final Action a(String str, Function0 function0, Composer composer, int i3, int i4) {
        composer.F(-242680581);
        if ((i4 & 1) != 0) {
            str = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-242680581, i3, -1, "androidx.glance.action.action (LambdaAction.kt:39)");
        }
        if (str == null || str.length() == 0) {
            str = String.valueOf(ComposablesKt.a(composer, 0));
        }
        LambdaAction lambdaAction = new LambdaAction(str, function0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return lambdaAction;
    }
}
