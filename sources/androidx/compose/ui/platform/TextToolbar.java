package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface TextToolbar {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ void c(TextToolbar textToolbar, Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        if ((i3 & 4) != 0) {
            function02 = null;
        }
        if ((i3 & 8) != 0) {
            function03 = null;
        }
        if ((i3 & 16) != 0) {
            function04 = null;
        }
        if ((i3 & 32) != 0) {
            function05 = null;
        }
        textToolbar.d(rect, function0, function02, function03, function04, function05);
    }

    void a();

    void b(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04);

    default void d(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05) {
        b(rect, function0, function02, function03, function04);
    }

    TextToolbarStatus getStatus();
}
