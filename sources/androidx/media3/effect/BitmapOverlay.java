package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.datasource.DataSourceBitmapLoader;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BitmapOverlay extends TextureOverlay {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f42184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f42185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f42186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f42187e;

    /* JADX INFO: renamed from: androidx.media3.effect.BitmapOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends BitmapOverlay {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bitmap f42188f;

        @Override // androidx.media3.effect.BitmapOverlay
        public Bitmap g(long j3) {
            return this.f42188f;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.BitmapOverlay$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends BitmapOverlay {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bitmap f42189f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ StaticOverlaySettings f42190g;

        @Override // androidx.media3.effect.TextureOverlay
        public OverlaySettings b(long j3) {
            return this.f42190g;
        }

        @Override // androidx.media3.effect.BitmapOverlay
        public Bitmap g(long j3) {
            return this.f42189f;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.BitmapOverlay$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends BitmapOverlay {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Bitmap f42191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f42192g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Uri f42193h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ StaticOverlaySettings f42194i;

        @Override // androidx.media3.effect.TextureOverlay
        public OverlaySettings b(long j3) {
            return this.f42194i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.effect.BitmapOverlay
        public Bitmap g(long j3) throws VideoFrameProcessingException {
            if (this.f42191f == null) {
                try {
                    this.f42191f = (Bitmap) new DataSourceBitmapLoader(this.f42192g).b(this.f42193h).get();
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                    throw new VideoFrameProcessingException(e3);
                } catch (ExecutionException e4) {
                    throw new VideoFrameProcessingException(e4);
                }
            }
            return this.f42191f;
        }
    }

    @Override // androidx.media3.effect.TextureOverlay
    public int c(long j3) throws VideoFrameProcessingException {
        Bitmap bitmapG = g(j3);
        int generationId = bitmapG.getGenerationId();
        if (bitmapG != this.f42187e || generationId != this.f42186d) {
            this.f42187e = bitmapG;
            this.f42186d = generationId;
            try {
                if (this.f42185c == -1) {
                    this.f42185c = GlUtil.J();
                }
                GlUtil.X(this.f42185c, bitmapG);
            } catch (GlUtil.GlException e3) {
                throw new VideoFrameProcessingException(e3);
            }
        }
        return this.f42185c;
    }

    @Override // androidx.media3.effect.TextureOverlay
    public Size d(long j3) {
        return new Size(((Bitmap) Assertions.e(this.f42187e)).getWidth(), ((Bitmap) Assertions.e(this.f42187e)).getHeight());
    }

    @Override // androidx.media3.effect.TextureOverlay
    public float[] e(long j3) {
        return this.f42184b;
    }

    @Override // androidx.media3.effect.TextureOverlay
    public void f() throws VideoFrameProcessingException {
        super.f();
        this.f42187e = null;
        int i3 = this.f42185c;
        if (i3 != -1) {
            try {
                GlUtil.D(i3);
            } catch (GlUtil.GlException e3) {
                throw new VideoFrameProcessingException(e3);
            }
        }
        this.f42185c = -1;
    }

    public abstract Bitmap g(long j3);
}
