package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import androidx.compose.ui.geometry.Offset;
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
public final class DragAndDrop_androidKt {
    public static final long a(DragAndDropEvent dragAndDropEvent) {
        float x2 = dragAndDropEvent.a().getX();
        float y2 = dragAndDropEvent.a().getY();
        return Offset.e((((long) Float.floatToRawIntBits(x2)) << 32) | (((long) Float.floatToRawIntBits(y2)) & 4294967295L));
    }

    public static final DragEvent b(DragAndDropEvent dragAndDropEvent) {
        return dragAndDropEvent.a();
    }
}
