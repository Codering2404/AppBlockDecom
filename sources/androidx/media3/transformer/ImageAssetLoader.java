package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.ConstantRateTimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.transformer.AssetLoader;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageAssetLoader implements AssetLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EditedMediaItem f48260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BitmapLoader f48261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AssetLoader.Listener f48262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f48263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f48264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SampleConsumer f48265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f48266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f48267i;

    /* JADX INFO: renamed from: androidx.media3.transformer.ImageAssetLoader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements FutureCallback<Bitmap> {
        AnonymousClass1() {
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final Bitmap bitmap) {
            ImageAssetLoader.this.f48267i = 50;
            Format formatN = new Format.Builder().d0(bitmap.getHeight()).B0(bitmap.getWidth()).u0("image/raw").T(ColorInfo.f40547i).N();
            final Format formatN2 = (ImageAssetLoader.this.f48263e && Util.f41609a >= 34 && bitmap.hasGainmap()) ? formatN.b().u0("image/jpeg_r").N() : formatN;
            try {
                ImageAssetLoader.this.f48262d.b(formatN, 2);
                ImageAssetLoader.this.f48264f.submit(new Runnable() { // from class: androidx.media3.transformer.u1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageAssetLoader.this.j(bitmap, formatN2);
                    }
                });
            } catch (RuntimeException e3) {
                ImageAssetLoader.this.f48262d.d(ExportException.a(e3, 1000));
            }
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            ImageAssetLoader.this.f48262d.d(ExportException.a(th, AdError.SERVER_ERROR_CODE));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements AssetLoader.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f48269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BitmapLoader f48270b;

        public Factory(Context context, BitmapLoader bitmapLoader) {
            this.f48269a = context;
            this.f48270b = bitmapLoader;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public AssetLoader a(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            return new ImageAssetLoader(this.f48269a, editedMediaItem, listener, this.f48270b, compositionSettings.f47901b, null);
        }
    }

    /* synthetic */ ImageAssetLoader(Context context, EditedMediaItem editedMediaItem, AssetLoader.Listener listener, BitmapLoader bitmapLoader, boolean z2, AnonymousClass1 anonymousClass1) {
        this(context, editedMediaItem, listener, bitmapLoader, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Bitmap bitmap, final Format format) {
        try {
            SampleConsumer sampleConsumer = this.f48265g;
            if (sampleConsumer == null) {
                this.f48265g = this.f48262d.a(format);
                this.f48264f.schedule(new Runnable() { // from class: androidx.media3.transformer.s1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48708a.j(bitmap, format);
                    }
                }, 10L, TimeUnit.MILLISECONDS);
                return;
            }
            int iG = sampleConsumer.g(bitmap, new ConstantRateTimestampIterator(this.f48260b.f48099e, r4.f48100f));
            if (iG == 1) {
                this.f48267i = 100;
                this.f48265g.h();
            } else if (iG == 2) {
                this.f48264f.schedule(new Runnable() { // from class: androidx.media3.transformer.t1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48712a.j(bitmap, format);
                    }
                }, 10L, TimeUnit.MILLISECONDS);
            } else {
                if (iG != 3) {
                    throw new IllegalStateException();
                }
                this.f48267i = 100;
            }
        } catch (ExportException e3) {
            this.f48262d.d(e3);
        } catch (RuntimeException e4) {
            this.f48262d.d(ExportException.a(e4, 1000));
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        if (this.f48266h == 2) {
            progressHolder.f48349a = this.f48267i;
        }
        return this.f48266h;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        return ImmutableMap.n();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.f48266h = 0;
        this.f48264f.shutdownNow();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        ListenableFuture listenableFutureE;
        this.f48266h = 2;
        this.f48262d.f(this.f48260b.f48099e);
        this.f48262d.c(1);
        String strD = TransformerUtil.d(this.f48259a, this.f48260b.f48095a);
        if (strD == null || !this.f48261c.a(strD)) {
            listenableFutureE = Futures.e(ParserException.c("Attempted to load a Bitmap from unsupported MIME type: " + strD));
        } else {
            listenableFutureE = this.f48261c.b(((MediaItem.LocalConfiguration) Assertions.e(this.f48260b.f48095a.f40714b)).f40810a);
        }
        Futures.a(listenableFutureE, new AnonymousClass1(), this.f48264f);
    }

    private ImageAssetLoader(Context context, EditedMediaItem editedMediaItem, AssetLoader.Listener listener, BitmapLoader bitmapLoader, boolean z2) {
        Assertions.g(editedMediaItem.f48099e != -9223372036854775807L);
        Assertions.g(editedMediaItem.f48100f != -2147483647);
        this.f48259a = context;
        this.f48260b = editedMediaItem;
        this.f48262d = listener;
        this.f48261c = bitmapLoader;
        this.f48263e = z2;
        this.f48264f = Executors.newSingleThreadScheduledExecutor();
        this.f48266h = 0;
    }
}
