package androidx.media3.transformer;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SurfaceAssetLoader implements AssetLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditedMediaItem f48455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetLoader.Listener f48456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f48457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Callback f48458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f48459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f48460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f48461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SampleConsumer f48462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Format f48463i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback {
        void e(Surface surface, EditedMediaItem editedMediaItem);

        void g(SurfaceAssetLoader surfaceAssetLoader);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements AssetLoader.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Callback f48464a;

        public Factory(Callback callback) {
            this.f48464a = callback;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SurfaceAssetLoader a(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            Assertions.g(((String) Assertions.e(((MediaItem.LocalConfiguration) Assertions.e(editedMediaItem.f48095a.f40714b)).f40810a.getScheme())).equals("transformer_surface_asset"));
            SurfaceAssetLoader surfaceAssetLoader = new SurfaceAssetLoader(editedMediaItem, looper, listener, this.f48464a);
            this.f48464a.g(surfaceAssetLoader);
            return surfaceAssetLoader;
        }
    }

    public static /* synthetic */ void a(SurfaceAssetLoader surfaceAssetLoader) {
        SampleConsumer sampleConsumer;
        surfaceAssetLoader.getClass();
        try {
            if (surfaceAssetLoader.f48461g || (sampleConsumer = surfaceAssetLoader.f48462h) == null) {
                return;
            }
            surfaceAssetLoader.f48461g = true;
            sampleConsumer.h();
        } catch (RuntimeException e3) {
            surfaceAssetLoader.f48456b.d(ExportException.a(e3, 1000));
        }
    }

    public static /* synthetic */ void b(SurfaceAssetLoader surfaceAssetLoader, Format format) {
        surfaceAssetLoader.f48463i = format;
        try {
            surfaceAssetLoader.d();
        } catch (RuntimeException e3) {
            surfaceAssetLoader.f48456b.d(ExportException.a(e3, 1000));
        }
    }

    private void d() {
        if (!this.f48460f || this.f48463i == null) {
            return;
        }
        this.f48456b.c(1);
        this.f48456b.f(-9223372036854775807L);
        this.f48456b.b(this.f48463i, 2);
        try {
            SampleConsumer sampleConsumer = (SampleConsumer) Assertions.e(this.f48456b.a(this.f48463i));
            this.f48462h = sampleConsumer;
            sampleConsumer.e(new Runnable() { // from class: androidx.media3.transformer.a2
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceAssetLoader surfaceAssetLoader = this.f48655a;
                    surfaceAssetLoader.f48458d.e(((SampleConsumer) Assertions.e(surfaceAssetLoader.f48462h)).a(), surfaceAssetLoader.f48455a);
                }
            });
        } catch (ExportException e3) {
            this.f48456b.d(e3);
        }
        this.f48459e = 3;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        return this.f48459e;
    }

    public void f(final Format format) {
        Assertions.a(Objects.equals(format.f40632o, "video/raw"));
        Assertions.a(format.f40639v != -1);
        Assertions.a(format.f40640w != -1);
        Assertions.a(((ColorInfo) Assertions.e(format.C)).j());
        this.f48457c.post(new Runnable() { // from class: androidx.media3.transformer.b2
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceAssetLoader.b(this.f48656a, format);
            }
        });
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        return ImmutableMap.n();
    }

    public void h() {
        this.f48457c.post(new Runnable() { // from class: androidx.media3.transformer.z1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceAssetLoader.a(this.f48730a);
            }
        });
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.f48460f = true;
        d();
    }

    private SurfaceAssetLoader(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, Callback callback) {
        this.f48455a = editedMediaItem;
        this.f48456b = listener;
        this.f48458d = callback;
        this.f48457c = new Handler(looper);
        this.f48459e = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
    }
}
