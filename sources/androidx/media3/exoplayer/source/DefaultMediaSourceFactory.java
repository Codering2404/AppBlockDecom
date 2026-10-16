package androidx.media3.exoplayer.source;

import android.content.Context;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.ExternallyLoadedMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.source.SingleSampleMediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DelegateFactoryLoader f44652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DataSource.Factory f44653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SubtitleParser.Factory f44654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MediaSource.Factory f44655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ExternalLoader f44656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdsLoader.Provider f44657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AdViewProvider f44658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LoadErrorHandlingPolicy f44659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f44660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f44661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f44662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f44663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f44664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f44665p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelegateFactoryLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExtractorsFactory f44666a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DataSource.Factory f44669d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private SubtitleParser.Factory f44671f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f44672g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CmcdConfiguration.Factory f44673h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private DrmSessionManagerProvider f44674i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private LoadErrorHandlingPolicy f44675j;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f44667b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f44668c = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f44670e = true;

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
            this.f44666a = extractorsFactory;
            this.f44671f = factory;
        }

        public static /* synthetic */ MediaSource.Factory c(DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
            delegateFactoryLoader.getClass();
            return new ProgressiveMediaSource.Factory(factory, delegateFactoryLoader.f44666a);
        }

        private void f() {
            j(0);
            j(1);
            j(2);
            j(3);
            j(4);
        }

        private Supplier i(int i3) {
            Supplier supplier;
            Supplier supplier2;
            Supplier supplier3 = (Supplier) this.f44667b.get(Integer.valueOf(i3));
            if (supplier3 != null) {
                return supplier3;
            }
            final DataSource.Factory factory = (DataSource.Factory) Assertions.e(this.f44669d);
            if (i3 == 0) {
                final Class<? extends U> clsAsSubclass = Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(MediaSource.Factory.class);
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.f
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        return DefaultMediaSourceFactory.q(clsAsSubclass, factory);
                    }
                };
            } else if (i3 == 1) {
                final Class<? extends U> clsAsSubclass2 = Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSource.Factory.class);
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.g
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        return DefaultMediaSourceFactory.q(clsAsSubclass2, factory);
                    }
                };
            } else {
                if (i3 != 2) {
                    if (i3 == 3) {
                        final Class<? extends U> clsAsSubclass3 = Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(MediaSource.Factory.class);
                        supplier2 = new Supplier() { // from class: androidx.media3.exoplayer.source.i
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                return DefaultMediaSourceFactory.p(clsAsSubclass3);
                            }
                        };
                    } else {
                        if (i3 != 4) {
                            throw new IllegalArgumentException("Unrecognized contentType: " + i3);
                        }
                        supplier2 = new Supplier() { // from class: androidx.media3.exoplayer.source.j
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                return DefaultMediaSourceFactory.DelegateFactoryLoader.c(this.f45172a, factory);
                            }
                        };
                    }
                    this.f44667b.put(Integer.valueOf(i3), supplier2);
                    return supplier2;
                }
                final Class<? extends U> clsAsSubclass4 = Class.forName("androidx.media3.exoplayer.hls.HlsMediaSource$Factory").asSubclass(MediaSource.Factory.class);
                supplier = new Supplier() { // from class: androidx.media3.exoplayer.source.h
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        return DefaultMediaSourceFactory.q(clsAsSubclass4, factory);
                    }
                };
            }
            supplier2 = supplier;
            this.f44667b.put(Integer.valueOf(i3), supplier2);
            return supplier2;
        }

        private Supplier j(int i3) {
            try {
                return i(i3);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        public MediaSource.Factory g(int i3) {
            MediaSource.Factory factory = (MediaSource.Factory) this.f44668c.get(Integer.valueOf(i3));
            if (factory != null) {
                return factory;
            }
            MediaSource.Factory factory2 = (MediaSource.Factory) i(i3).get();
            CmcdConfiguration.Factory factory3 = this.f44673h;
            if (factory3 != null) {
                factory2.h(factory3);
            }
            DrmSessionManagerProvider drmSessionManagerProvider = this.f44674i;
            if (drmSessionManagerProvider != null) {
                factory2.d(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f44675j;
            if (loadErrorHandlingPolicy != null) {
                factory2.f(loadErrorHandlingPolicy);
            }
            factory2.a(this.f44671f);
            factory2.g(this.f44670e);
            factory2.b(this.f44672g);
            this.f44668c.put(Integer.valueOf(i3), factory2);
            return factory2;
        }

        public int[] h() {
            f();
            return Ints.n(this.f44667b.keySet());
        }

        public void k(CmcdConfiguration.Factory factory) {
            this.f44673h = factory;
            Iterator it = this.f44668c.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).h(factory);
            }
        }

        public void l(int i3) {
            this.f44672g = i3;
            this.f44666a.b(i3);
        }

        public void m(DataSource.Factory factory) {
            if (factory != this.f44669d) {
                this.f44669d = factory;
                this.f44667b.clear();
                this.f44668c.clear();
            }
        }

        public void n(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f44674i = drmSessionManagerProvider;
            Iterator it = this.f44668c.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).d(drmSessionManagerProvider);
            }
        }

        public void o(int i3) {
            ExtractorsFactory extractorsFactory = this.f44666a;
            if (extractorsFactory instanceof DefaultExtractorsFactory) {
                ((DefaultExtractorsFactory) extractorsFactory).n(i3);
            }
        }

        public void p(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f44675j = loadErrorHandlingPolicy;
            Iterator it = this.f44668c.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).f(loadErrorHandlingPolicy);
            }
        }

        public void q(boolean z2) {
            this.f44670e = z2;
            this.f44666a.c(z2);
            Iterator it = this.f44668c.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).g(z2);
            }
        }

        public void r(SubtitleParser.Factory factory) {
            this.f44671f = factory;
            this.f44666a.a(factory);
            Iterator it = this.f44668c.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).a(factory);
            }
        }
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSource.Factory(context), extractorsFactory);
    }

    public static /* synthetic */ Extractor[] i(DefaultMediaSourceFactory defaultMediaSourceFactory, Format format) {
        return new Extractor[]{defaultMediaSourceFactory.f44654e.a(format) ? new SubtitleExtractor(defaultMediaSourceFactory.f44654e.c(format), null) : new UnknownSubtitlesExtractor(format)};
    }

    private static MediaSource n(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.f40718f;
        return (clippingConfiguration.f40747b == 0 && clippingConfiguration.f40749d == Long.MIN_VALUE && !clippingConfiguration.f40751f) ? mediaSource : new ClippingMediaSource.Builder(mediaSource).m(mediaItem.f40718f.f40747b).k(mediaItem.f40718f.f40749d).j(!mediaItem.f40718f.f40752g).i(mediaItem.f40718f.f40750e).l(mediaItem.f40718f.f40751f).h();
    }

    private MediaSource o(MediaItem mediaItem, MediaSource mediaSource) {
        Assertions.e(mediaItem.f40714b);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.f40714b.f40813d;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoader.Provider provider = this.f44657h;
        AdViewProvider adViewProvider = this.f44658i;
        if (provider == null || adViewProvider == null) {
            Log.i("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoaderA = provider.a(adsConfiguration);
        if (adsLoaderA == null) {
            Log.i("DMediaSourceFactory", "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.f40722a);
        Object objB = adsConfiguration.f40723b;
        if (objB == null) {
            objB = ImmutableList.B(mediaItem.f40713a, mediaItem.f40714b.f40810a, adsConfiguration.f40722a);
        }
        return new AdsMediaSource(mediaSource, dataSpec, objB, this, adsLoaderA, adViewProvider, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.Factory p(Class cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor(null).newInstance(null);
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.Factory q(Class cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e3) {
            throw new IllegalStateException(e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public MediaSource c(MediaItem mediaItem) {
        Assertions.e(mediaItem.f40714b);
        String scheme = mediaItem.f40714b.f40810a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((MediaSource.Factory) Assertions.e(this.f44655f)).c(mediaItem);
        }
        if (Objects.equals(mediaItem.f40714b.f40811b, "application/x-image-uri")) {
            return new ExternallyLoadedMediaSource.Factory(Util.P0(mediaItem.f40714b.f40819j), (ExternalLoader) Assertions.e(this.f44656g)).c(mediaItem);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f40714b;
        int iW0 = Util.w0(localConfiguration.f40810a, localConfiguration.f40811b);
        if (mediaItem.f40714b.f40819j != -9223372036854775807L) {
            this.f44652c.o(1);
        }
        try {
            MediaSource.Factory factoryG = this.f44652c.g(iW0);
            MediaItem.LiveConfiguration.Builder builderA = mediaItem.f40716d.a();
            if (mediaItem.f40716d.f40792a == -9223372036854775807L) {
                builderA.k(this.f44660k);
            }
            if (mediaItem.f40716d.f40795d == -3.4028235E38f) {
                builderA.j(this.f44663n);
            }
            if (mediaItem.f40716d.f40796e == -3.4028235E38f) {
                builderA.h(this.f44664o);
            }
            if (mediaItem.f40716d.f40793b == -9223372036854775807L) {
                builderA.i(this.f44661l);
            }
            if (mediaItem.f40716d.f40794c == -9223372036854775807L) {
                builderA.g(this.f44662m);
            }
            MediaItem.LiveConfiguration liveConfigurationF = builderA.f();
            if (!liveConfigurationF.equals(mediaItem.f40716d)) {
                mediaItem = mediaItem.a().e(liveConfigurationF).a();
            }
            MediaSource mediaSourceC = factoryG.c(mediaItem);
            ImmutableList immutableList = ((MediaItem.LocalConfiguration) Util.k(mediaItem.f40714b)).f40816g;
            if (!immutableList.isEmpty()) {
                MediaSource[] mediaSourceArr = new MediaSource[immutableList.size() + 1];
                mediaSourceArr[0] = mediaSourceC;
                for (int i3 = 0; i3 < immutableList.size(); i3++) {
                    if (this.f44665p) {
                        final Format formatN = new Format.Builder().u0(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40838b).j0(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40839c).w0(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40840d).s0(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40841e).h0(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40842f).f0(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40843g).N();
                        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.f44653d, new ExtractorsFactory() { // from class: androidx.media3.exoplayer.source.e
                            @Override // androidx.media3.extractor.ExtractorsFactory
                            public final Extractor[] f() {
                                return DefaultMediaSourceFactory.i(this.f45160b, formatN);
                            }
                        });
                        if (this.f44654e.a(formatN)) {
                            formatN = formatN.b().u0("application/x-media3-cues").S(formatN.f40632o).W(this.f44654e.b(formatN)).N();
                        }
                        ProgressiveMediaSource.Factory factoryK = factory.k(0, formatN);
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f44659j;
                        if (loadErrorHandlingPolicy != null) {
                            factoryK.f(loadErrorHandlingPolicy);
                        }
                        mediaSourceArr[i3 + 1] = factoryK.c(MediaItem.c(((MediaItem.SubtitleConfiguration) immutableList.get(i3)).f40837a.toString()));
                    } else {
                        SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.f44653d);
                        LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f44659j;
                        if (loadErrorHandlingPolicy2 != null) {
                            factory2.b(loadErrorHandlingPolicy2);
                        }
                        mediaSourceArr[i3 + 1] = factory2.a((MediaItem.SubtitleConfiguration) immutableList.get(i3), -9223372036854775807L);
                    }
                }
                mediaSourceC = new MergingMediaSource(mediaSourceArr);
            }
            return o(mediaItem, n(mediaItem, mediaSourceC));
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    public int[] e() {
        return this.f44652c.h();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory g(boolean z2) {
        this.f44665p = z2;
        this.f44652c.q(z2);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory b(int i3) {
        this.f44652c.l(i3);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory h(CmcdConfiguration.Factory factory) {
        this.f44652c.k((CmcdConfiguration.Factory) Assertions.e(factory));
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory d(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.f44652c.n((DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory f(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f44659j = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f44652c.p(loadErrorHandlingPolicy);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.Factory
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory a(SubtitleParser.Factory factory) {
        this.f44654e = (SubtitleParser.Factory) Assertions.e(factory);
        this.f44652c.r(factory);
        return this;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.f44653d = factory;
        DefaultSubtitleParserFactory defaultSubtitleParserFactory = new DefaultSubtitleParserFactory();
        this.f44654e = defaultSubtitleParserFactory;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(extractorsFactory, defaultSubtitleParserFactory);
        this.f44652c = delegateFactoryLoader;
        delegateFactoryLoader.m(factory);
        this.f44660k = -9223372036854775807L;
        this.f44661l = -9223372036854775807L;
        this.f44662m = -9223372036854775807L;
        this.f44663n = -3.4028235E38f;
        this.f44664o = -3.4028235E38f;
        this.f44665p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnknownSubtitlesExtractor implements Extractor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Format f44676a;

        public UnknownSubtitlesExtractor(Format format) {
            this.f44676a = format;
        }

        @Override // androidx.media3.extractor.Extractor
        public boolean g(ExtractorInput extractorInput) {
            return true;
        }

        @Override // androidx.media3.extractor.Extractor
        public void h(ExtractorOutput extractorOutput) {
            TrackOutput trackOutputD = extractorOutput.d(0, 3);
            extractorOutput.n(new SeekMap.Unseekable(-9223372036854775807L));
            extractorOutput.q();
            trackOutputD.c(this.f44676a.b().u0("text/x-unknown").S(this.f44676a.f40632o).N());
        }

        @Override // androidx.media3.extractor.Extractor
        public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
            return extractorInput.a(Api.BaseClientBuilder.API_PRIORITY_OTHER) == -1 ? -1 : 0;
        }

        @Override // androidx.media3.extractor.Extractor
        public void release() {
        }

        @Override // androidx.media3.extractor.Extractor
        public void a(long j3, long j4) {
        }
    }
}
