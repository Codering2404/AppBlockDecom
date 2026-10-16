package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LayerSnapshotV28 implements LayerSnapshotImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LayerSnapshotV28 f26247a = new LayerSnapshotV28();

    private LayerSnapshotV28() {
    }

    @Override // androidx.compose.ui.graphics.layer.LayerSnapshotImpl
    public Object a(GraphicsLayer graphicsLayer, Continuation continuation) {
        return Bitmap.createBitmap(new GraphicsLayerPicture(graphicsLayer));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class GraphicsLayerPicture extends Picture {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GraphicsLayer f26248a;

        public GraphicsLayerPicture(GraphicsLayer graphicsLayer) {
            this.f26248a = graphicsLayer;
        }

        @Override // android.graphics.Picture
        public Canvas beginRecording(int i3, int i4) {
            return new Canvas();
        }

        @Override // android.graphics.Picture
        public void draw(Canvas canvas) {
            this.f26248a.h(AndroidCanvas_androidKt.b(canvas), null);
        }

        @Override // android.graphics.Picture
        public int getHeight() {
            return (int) (this.f26248a.x() & 4294967295L);
        }

        @Override // android.graphics.Picture
        public int getWidth() {
            return (int) (this.f26248a.x() >> 32);
        }

        @Override // android.graphics.Picture
        public boolean requiresHardwareAcceleration() {
            return true;
        }

        @Override // android.graphics.Picture
        public void endRecording() {
        }
    }
}
