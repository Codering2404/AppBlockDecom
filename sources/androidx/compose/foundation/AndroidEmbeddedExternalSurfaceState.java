package androidx.compose.foundation;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
final class AndroidEmbeddedExternalSurfaceState extends BaseAndroidExternalSurfaceState implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f4573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Matrix f4574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Surface f4575i;

    public AndroidEmbeddedExternalSurfaceState(CoroutineScope coroutineScope) {
        super(coroutineScope);
        this.f4573g = IntSize.f29998b.a();
        this.f4574h = new Matrix();
    }

    public final Matrix f() {
        return this.f4574h;
    }

    public final void g(long j3) {
        this.f4573g = j3;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
        if (!IntSize.e(this.f4573g, IntSize.f29998b.a())) {
            long j3 = this.f4573g;
            int i5 = (int) (j3 >> 32);
            i4 = (int) (j3 & 4294967295L);
            surfaceTexture.setDefaultBufferSize(i5, i4);
            i3 = i5;
        }
        Surface surface = new Surface(surfaceTexture);
        this.f4575i = surface;
        d(surface, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surface = this.f4575i;
        Intrinsics.checkNotNull(surface);
        e(surface);
        this.f4575i = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
        if (!IntSize.e(this.f4573g, IntSize.f29998b.a())) {
            long j3 = this.f4573g;
            int i5 = (int) (j3 >> 32);
            i4 = (int) (j3 & 4294967295L);
            surfaceTexture.setDefaultBufferSize(i5, i4);
            i3 = i5;
        }
        Surface surface = this.f4575i;
        Intrinsics.checkNotNull(surface);
        c(surface, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
