package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
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
public final class BitmapPainterKt {
    public static final BitmapPainter a(ImageBitmap imageBitmap, long j3, long j4, int i3) {
        BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, j3, j4, null);
        bitmapPainter.o(i3);
        return bitmapPainter;
    }

    public static /* synthetic */ BitmapPainter b(ImageBitmap imageBitmap, long j3, long j4, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j3 = IntOffset.f29988b.b();
        }
        long j5 = j3;
        if ((i4 & 4) != 0) {
            j4 = IntSize.c((((long) imageBitmap.getHeight()) & 4294967295L) | (((long) imageBitmap.getWidth()) << 32));
        }
        long j6 = j4;
        if ((i4 & 8) != 0) {
            i3 = FilterQuality.f25743b.a();
        }
        return a(imageBitmap, j5, j6, i3);
    }
}
