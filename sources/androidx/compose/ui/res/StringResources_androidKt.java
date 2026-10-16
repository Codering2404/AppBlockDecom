package androidx.compose.ui.res;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Arrays;
import kotlin.Metadata;

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
public final class StringResources_androidKt {
    public static final String a(int i3, int i4, Composer composer, int i5) {
        if (ComposerKt.M()) {
            ComposerKt.U(1784741530, i5, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:73)");
        }
        String quantityString = Resources_androidKt.a(composer, 0).getQuantityString(i3, i4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return quantityString;
    }

    public static final String b(int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(1223887937, i4, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        String string = Resources_androidKt.a(composer, 0).getString(i3);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return string;
    }

    public static final String c(int i3, Object[] objArr, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(2071230100, i4, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
        }
        String string = Resources_androidKt.a(composer, 0).getString(i3, Arrays.copyOf(objArr, objArr.length));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return string;
    }
}
