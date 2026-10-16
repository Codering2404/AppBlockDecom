package androidx.media3.transformer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.ExoPlayerAssetLoader;
import androidx.media3.transformer.ImageAssetLoader;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAssetLoaderFactory implements AssetLoader.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Codec.DecoderFactory f48019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f48020c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BitmapLoader f48022e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AssetLoader.Factory f48024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AssetLoader.Factory f48025h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MediaSource.Factory f48021d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TrackSelector.Factory f48023f = null;

    public DefaultAssetLoaderFactory(Context context, Codec.DecoderFactory decoderFactory, Clock clock) {
        this.f48018a = context.getApplicationContext();
        this.f48019b = decoderFactory;
        this.f48020c = clock;
        BitmapFactory.Options options = null;
        if (Util.f41609a >= 26) {
            options = new BitmapFactory.Options();
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.f48022e = new DataSourceBitmapLoader(MoreExecutors.c(Executors.newSingleThreadExecutor()), new DefaultDataSource.Factory(context), options, 4096);
    }

    @Override // androidx.media3.transformer.AssetLoader.Factory
    public AssetLoader a(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
        MediaItem mediaItem = editedMediaItem.f48095a;
        boolean zI = TransformerUtil.i(this.f48018a, mediaItem);
        boolean z2 = zI && editedMediaItem.f48099e == -9223372036854775807L;
        if (!zI || z2) {
            if (this.f48025h == null) {
                this.f48025h = new ExoPlayerAssetLoader.Factory(this.f48018a, this.f48019b, this.f48020c, this.f48021d, this.f48023f);
            }
            return this.f48025h.a(editedMediaItem, looper, listener, compositionSettings);
        }
        if (((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f40714b)).f40819j == -9223372036854775807L) {
            Log.i("DefaultAssetLoaderFact", "The imageDurationMs field must be set on image MediaItems.");
        }
        if (this.f48024g == null) {
            this.f48024g = new ImageAssetLoader.Factory(this.f48018a, this.f48022e);
        }
        return this.f48024g.a(editedMediaItem, looper, listener, compositionSettings);
    }
}
