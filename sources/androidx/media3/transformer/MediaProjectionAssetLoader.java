package androidx.media3.transformer;

import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.SurfaceAssetLoader;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaProjectionAssetLoader implements AssetLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaProjection f48284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Format f48285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f48286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AssetLoader.Listener f48287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f48288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SurfaceAssetLoader f48289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Format f48290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private VirtualDisplay f48291h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements AssetLoader.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaProjection f48294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f48295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f48296c;

        @Override // androidx.media3.transformer.AssetLoader.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaProjectionAssetLoader a(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            return new MediaProjectionAssetLoader(this.f48294a, this.f48295b, this.f48296c, editedMediaItem, looper, listener, compositionSettings);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Surface surface) {
        this.f48284a.registerCallback(new MediaProjection.Callback() { // from class: androidx.media3.transformer.MediaProjectionAssetLoader.1
            @Override // android.media.projection.MediaProjection.Callback
            public void onStop() {
                super.onStop();
                if (MediaProjectionAssetLoader.this.f48291h != null) {
                    MediaProjectionAssetLoader.this.f48291h.setSurface(null);
                    MediaProjectionAssetLoader.this.f48291h.release();
                }
                MediaProjectionAssetLoader.this.f48289f.h();
            }
        }, new Handler());
        this.f48291h = ((MediaProjection) Assertions.e(this.f48284a)).createVirtualDisplay("MediaProjectionAssetLoader", ((Format) Assertions.e(this.f48285b)).f40639v, this.f48285b.f40640w, this.f48286c, 16, surface, null, null);
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        return this.f48289f.e(progressHolder);
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        return this.f48289f.g();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.f48289f.release();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.f48289f.start();
    }

    private MediaProjectionAssetLoader(MediaProjection mediaProjection, Rect rect, int i3, EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
        this.f48284a = mediaProjection;
        Format formatN = new Format.Builder().u0("video/raw").B0(rect.width()).d0(rect.height()).T(ColorInfo.f40547i).N();
        this.f48285b = formatN;
        this.f48286c = i3;
        this.f48287d = listener;
        this.f48288e = new Handler(Looper.getMainLooper());
        ComponentListener componentListener = new ComponentListener();
        SurfaceAssetLoader surfaceAssetLoaderA = new SurfaceAssetLoader.Factory(componentListener).a(editedMediaItem, looper, componentListener, compositionSettings);
        this.f48289f = surfaceAssetLoaderA;
        surfaceAssetLoaderA.f(formatN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ComponentListener implements SurfaceAssetLoader.Callback, AssetLoader.Listener {
        private ComponentListener() {
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public SampleConsumer a(Format format) {
            if (MediaProjectionAssetLoader.this.f48290g == null) {
                return null;
            }
            return MediaProjectionAssetLoader.this.f48287d.a(format);
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public boolean b(Format format, int i3) {
            if (MimeTypes.q(format.f40632o)) {
                MediaProjectionAssetLoader.this.f48290g = format;
                MediaProjectionAssetLoader.this.f48287d.f(-9223372036854775807L);
                MediaProjectionAssetLoader.this.f48287d.c(1);
                MediaProjectionAssetLoader.this.f48287d.b(format, 2);
            }
            return true;
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public void d(ExportException exportException) {
            MediaProjectionAssetLoader.this.f48287d.d(exportException);
        }

        @Override // androidx.media3.transformer.SurfaceAssetLoader.Callback
        public void e(final Surface surface, EditedMediaItem editedMediaItem) {
            MediaProjectionAssetLoader.this.f48288e.post(new Runnable() { // from class: androidx.media3.transformer.v1
                @Override // java.lang.Runnable
                public final void run() {
                    MediaProjectionAssetLoader.this.j(surface);
                }
            });
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public void c(int i3) {
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public void f(long j3) {
        }

        @Override // androidx.media3.transformer.SurfaceAssetLoader.Callback
        public void g(SurfaceAssetLoader surfaceAssetLoader) {
        }
    }
}
