package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
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
public final class ImageBitmapKt {
    public static final ImageBitmap a(int i3, int i4, int i5, boolean z2, ColorSpace colorSpace) {
        return AndroidImageBitmap_androidKt.a(i3, i4, i5, z2, colorSpace);
    }

    public static /* synthetic */ ImageBitmap b(int i3, int i4, int i5, boolean z2, ColorSpace colorSpace, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i5 = ImageBitmapConfig.f25784b.b();
        }
        if ((i6 & 8) != 0) {
            z2 = true;
        }
        if ((i6 & 16) != 0) {
            colorSpace = ColorSpaces.f25979a.G();
        }
        return a(i3, i4, i5, z2, colorSpace);
    }
}
