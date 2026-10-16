package androidx.compose.ui.autofill;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AndroidAutofillManager_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(SemanticsConfiguration semanticsConfiguration) {
        return semanticsConfiguration.n().b(SemanticsActions.f28471a.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(SemanticsConfiguration semanticsConfiguration) {
        return semanticsConfiguration.n().b(SemanticsProperties.f28517a.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(SemanticsConfiguration semanticsConfiguration) {
        if (semanticsConfiguration.n().b(SemanticsActions.f28471a.k())) {
            return true;
        }
        MutableScatterMap mutableScatterMapN = semanticsConfiguration.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        return mutableScatterMapN.b(semanticsProperties.e()) || semanticsConfiguration.n().b(semanticsProperties.c());
    }
}
