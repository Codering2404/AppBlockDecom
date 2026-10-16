package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
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
final class HandleImageCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandleImageCache f11228a = new HandleImageCache();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ImageBitmap f11229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Canvas f11230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static CanvasDrawScope f11231d;

    private HandleImageCache() {
    }

    public final Canvas a() {
        return f11230c;
    }

    public final CanvasDrawScope b() {
        return f11231d;
    }

    public final ImageBitmap c() {
        return f11229b;
    }

    public final void d(Canvas canvas) {
        f11230c = canvas;
    }

    public final void e(CanvasDrawScope canvasDrawScope) {
        f11231d = canvasDrawScope;
    }

    public final void f(ImageBitmap imageBitmap) {
        f11229b = imageBitmap;
    }
}
