package androidx.media3.transformer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoTimeoutException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.ExoPlayerAssetLoader;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExoPlayerAssetLoader implements AssetLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EditedMediaItem f48150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CapturingDecoderFactory f48151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExoPlayer f48152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f48153e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements AssetLoader.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f48154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Codec.DecoderFactory f48155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Clock f48156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MediaSource.Factory f48157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final TrackSelector.Factory f48158e;

        public Factory(Context context, Codec.DecoderFactory decoderFactory, Clock clock, MediaSource.Factory factory, TrackSelector.Factory factory2) {
            this.f48154a = context;
            this.f48155b = decoderFactory;
            this.f48156c = clock;
            this.f48157d = factory;
            this.f48158e = factory2;
        }

        public static /* synthetic */ TrackSelector b(DefaultTrackSelector.Parameters parameters, Context context) {
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
            defaultTrackSelector.d0(parameters);
            return defaultTrackSelector;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public AssetLoader a(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            MediaSource.Factory defaultMediaSourceFactory;
            TrackSelector.Factory factory;
            MediaSource.Factory factory2 = this.f48157d;
            if (factory2 == null) {
                DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                if (editedMediaItem.f48098d) {
                    defaultExtractorsFactory.o(4);
                }
                defaultMediaSourceFactory = new DefaultMediaSourceFactory(this.f48154a, defaultExtractorsFactory);
            } else {
                defaultMediaSourceFactory = factory2;
            }
            TrackSelector.Factory factory3 = this.f48158e;
            if (factory3 == null) {
                final DefaultTrackSelector.Parameters parametersF = new DefaultTrackSelector.Parameters.Builder(this.f48154a).f0(true).e0(false).F();
                factory = new TrackSelector.Factory() { // from class: androidx.media3.transformer.n1
                    @Override // androidx.media3.exoplayer.trackselection.TrackSelector.Factory
                    public final TrackSelector a(Context context) {
                        return ExoPlayerAssetLoader.Factory.b(parametersF, context);
                    }
                };
            } else {
                factory = factory3;
            }
            return new ExoPlayerAssetLoader(this.f48154a, editedMediaItem, defaultMediaSourceFactory, this.f48155b, compositionSettings.f47900a, looper, listener, this.f48156c, factory);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PlayerListener implements Player.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetLoader.Listener f48159a;

        public PlayerListener(AssetLoader.Listener listener) {
            this.f48159a = listener;
        }

        @Override // androidx.media3.common.Player.Listener
        public void T(PlaybackException playbackException) {
            Throwable cause = playbackException.getCause();
            if ((cause instanceof ExoTimeoutException) && ((ExoTimeoutException) cause).f43106a == 1) {
                Log.e("ExoPlayerAssetLoader", "Releasing the player timed out.", playbackException);
            } else {
                this.f48159a.d(ExportException.a(playbackException, ((Integer) Assertions.e((Integer) ExportException.f48192d.getOrDefault(playbackException.a(), 1000))).intValue()));
            }
        }

        @Override // androidx.media3.common.Player.Listener
        public void j0(Timeline timeline, int i3) {
            try {
                if (ExoPlayerAssetLoader.this.f48153e != 1) {
                    return;
                }
                Timeline.Window window = new Timeline.Window();
                timeline.n(0, window);
                if (window.f41145k) {
                    return;
                }
                long j3 = window.f41147m;
                ExoPlayerAssetLoader.this.f48153e = (j3 <= 0 || j3 == -9223372036854775807L) ? 3 : 2;
                this.f48159a.f(window.f41147m);
            } catch (RuntimeException e3) {
                this.f48159a.d(ExportException.a(e3, 1000));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r3v9, types: [androidx.media3.transformer.AssetLoader$Listener] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.media3.common.Player.Listener
        public void o0(Tracks tracks) {
            try {
                ?? B = tracks.b(1);
                ?? r02 = B;
                if (tracks.b(2)) {
                    r02 = B + 1;
                }
                ExoPlayerAssetLoader.i(tracks);
                if (r02 > 0) {
                    this.f48159a.c(r02);
                    ExoPlayerAssetLoader.this.f48152d.q();
                    return;
                }
                String str = "The asset loader has no audio or video track to output.";
                if (TransformerUtil.i(ExoPlayerAssetLoader.this.f48149a, ExoPlayerAssetLoader.this.f48150b.f48095a)) {
                    str = "The asset loader has no audio or video track to output. Try setting an image duration on input image MediaItems.";
                }
                this.f48159a.d(ExportException.a(new IllegalStateException(str), AdError.NO_FILL_ERROR_CODE));
            } catch (RuntimeException e3) {
                this.f48159a.d(ExportException.a(e3, 1000));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RenderersFactoryImpl implements RenderersFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TransformerMediaClock f48161a = new TransformerMediaClock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f48162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f48163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f48164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Codec.DecoderFactory f48165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f48166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AssetLoader.Listener f48167g;

        public RenderersFactoryImpl(boolean z2, boolean z3, boolean z4, Codec.DecoderFactory decoderFactory, int i3, AssetLoader.Listener listener) {
            this.f48162b = z2;
            this.f48163c = z3;
            this.f48164d = z4;
            this.f48165e = decoderFactory;
            this.f48166f = i3;
            this.f48167g = listener;
        }

        @Override // androidx.media3.exoplayer.RenderersFactory
        public Renderer[] b(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
            ArrayList arrayList = new ArrayList();
            if (!this.f48162b) {
                arrayList.add(new ExoAssetLoaderAudioRenderer(this.f48165e, this.f48161a, this.f48167g));
            }
            if (!this.f48163c) {
                arrayList.add(new ExoAssetLoaderVideoRenderer(this.f48164d, this.f48165e, this.f48166f, this.f48161a, this.f48167g));
            }
            return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void i(Tracks tracks) {
        for (int i3 = 0; i3 < tracks.a().size(); i3++) {
            int iC = ((Tracks.Group) tracks.a().get(i3)).c();
            if (iC != 1 && iC != 2) {
                Log.i("ExoPlayerAssetLoader", "Unsupported track type: " + iC);
            }
        }
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        if (this.f48153e == 2) {
            progressHolder.f48349a = Math.min((int) ((this.f48152d.getCurrentPosition() * 100) / this.f48152d.getDuration()), 99);
        }
        return this.f48153e;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        String strC = this.f48151c.c();
        if (strC != null) {
            builder.g(1, strC);
        }
        String strD = this.f48151c.d();
        if (strD != null) {
            builder.g(2, strD);
        }
        return builder.d();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.f48152d.release();
        this.f48153e = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.f48152d.o(this.f48150b.f48095a);
        this.f48152d.e();
        this.f48153e = 1;
    }

    private ExoPlayerAssetLoader(Context context, EditedMediaItem editedMediaItem, MediaSource.Factory factory, Codec.DecoderFactory decoderFactory, int i3, Looper looper, AssetLoader.Listener listener, Clock clock, TrackSelector.Factory factory2) {
        this.f48149a = context;
        this.f48150b = editedMediaItem;
        CapturingDecoderFactory capturingDecoderFactory = new CapturingDecoderFactory(decoderFactory);
        this.f48151c = capturingDecoderFactory;
        TrackSelector trackSelectorA = factory2.a(context);
        ExoPlayer.Builder builderO = new ExoPlayer.Builder(context, new RenderersFactoryImpl(editedMediaItem.f48096b, editedMediaItem.f48097c, editedMediaItem.f48098d, capturingDecoderFactory, i3, listener)).m(factory).n(trackSelectorA).k(new DefaultLoadControl.Builder().b(50000, 50000, 100, 200).a()).l(looper).o(false);
        if (decoderFactory instanceof DefaultDecoderFactory) {
            builderO.i(((DefaultDecoderFactory) decoderFactory).o());
        }
        if (clock != Clock.f41485a) {
            builderO.j(clock);
        }
        ExoPlayer exoPlayerH = builderO.h();
        this.f48152d = exoPlayerH;
        exoPlayerH.B(new PlayerListener(listener));
        this.f48153e = 0;
    }
}
