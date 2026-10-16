package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

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
final class AndroidExternalSurfaceState extends BaseAndroidExternalSurfaceState implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4577h;

    public AndroidExternalSurfaceState(CoroutineScope coroutineScope) {
        super(coroutineScope);
        this.f4576g = -1;
        this.f4577h = -1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
        if (this.f4576g == i4 && this.f4577h == i5) {
            return;
        }
        this.f4576g = i4;
        this.f4577h = i5;
        c(surfaceHolder.getSurface(), i4, i5);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        this.f4576g = surfaceFrame.width();
        this.f4577h = surfaceFrame.height();
        d(surfaceHolder.getSurface(), this.f4576g, this.f4577h);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        e(surfaceHolder.getSurface());
    }
}
