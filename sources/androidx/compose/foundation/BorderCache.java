package androidx.compose.foundation;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class BorderCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageBitmap f4734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Canvas f4735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CanvasDrawScope f4736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f4737d;

    public BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path) {
        this.f4734a = imageBitmap;
        this.f4735b = canvas;
        this.f4736c = canvasDrawScope;
        this.f4737d = path;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        return Intrinsics.areEqual(this.f4734a, borderCache.f4734a) && Intrinsics.areEqual(this.f4735b, borderCache.f4735b) && Intrinsics.areEqual(this.f4736c, borderCache.f4736c) && Intrinsics.areEqual(this.f4737d, borderCache.f4737d);
    }

    public final Path g() {
        Path path = this.f4737d;
        if (path != null) {
            return path;
        }
        Path pathA = AndroidPath_androidKt.a();
        this.f4737d = pathA;
        return pathA;
    }

    public int hashCode() {
        ImageBitmap imageBitmap = this.f4734a;
        int iHashCode = (imageBitmap == null ? 0 : imageBitmap.hashCode()) * 31;
        Canvas canvas = this.f4735b;
        int iHashCode2 = (iHashCode + (canvas == null ? 0 : canvas.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope = this.f4736c;
        int iHashCode3 = (iHashCode2 + (canvasDrawScope == null ? 0 : canvasDrawScope.hashCode())) * 31;
        Path path = this.f4737d;
        return iHashCode3 + (path != null ? path.hashCode() : 0);
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.f4734a + ", canvas=" + this.f4735b + ", canvasDrawScope=" + this.f4736c + ", borderPath=" + this.f4737d + ')';
    }

    public /* synthetic */ BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : imageBitmap, (i3 & 2) != 0 ? null : canvas, (i3 & 4) != 0 ? null : canvasDrawScope, (i3 & 8) != 0 ? null : path);
    }
}
