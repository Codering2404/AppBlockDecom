package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.common.FileTypes;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.amr.AmrExtractor;
import androidx.media3.extractor.avi.AviExtractor;
import androidx.media3.extractor.avif.AvifExtractor;
import androidx.media3.extractor.bmp.BmpExtractor;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.heif.HeifExtractor;
import androidx.media3.extractor.jpeg.JpegExtractor;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.png.PngExtractor;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.wav.WavExtractor;
import androidx.media3.extractor.webp.WebpExtractor;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[] f46107s = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ExtensionLoader f46108t = new ExtensionLoader(new ExtensionLoader.ConstructorSupplier() { // from class: androidx.media3.extractor.a
        @Override // androidx.media3.extractor.DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier
        public final Constructor a() {
            return DefaultExtractorsFactory.l();
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final ExtensionLoader f46109u = new ExtensionLoader(new ExtensionLoader.ConstructorSupplier() { // from class: androidx.media3.extractor.b
        @Override // androidx.media3.extractor.DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier
        public final Constructor a() {
            return DefaultExtractorsFactory.m();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f46110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f46111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46118j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f46120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImmutableList f46121m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f46125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f46126r;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f46119k = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f46122n = 112800;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SubtitleParser.Factory f46124p = new DefaultSubtitleParserFactory();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f46123o = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ExtensionLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConstructorSupplier f46127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f46128b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Constructor f46129c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ConstructorSupplier {
            Constructor a();
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier) {
            this.f46127a = constructorSupplier;
        }

        private Constructor b() {
            synchronized (this.f46128b) {
                if (this.f46128b.get()) {
                    return this.f46129c;
                }
                try {
                    return this.f46127a.a();
                } catch (ClassNotFoundException unused) {
                    this.f46128b.set(true);
                    return this.f46129c;
                } catch (Exception e3) {
                    throw new RuntimeException("Error instantiating extension", e3);
                }
            }
        }

        public Extractor a(Object... objArr) {
            Constructor constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return (Extractor) constructorB.newInstance(objArr);
            } catch (Exception e3) {
                throw new IllegalStateException("Unexpected error creating extractor", e3);
            }
        }
    }

    private void i(int i3, List list) {
        switch (i3) {
            case 0:
                list.add(new Ac3Extractor());
                break;
            case 1:
                list.add(new Ac4Extractor());
                break;
            case 2:
                list.add(new AdtsExtractor((this.f46111c ? 2 : 0) | this.f46112d | (this.f46110b ? 1 : 0)));
                break;
            case 3:
                list.add(new AmrExtractor((this.f46111c ? 2 : 0) | this.f46113e | (this.f46110b ? 1 : 0)));
                break;
            case 4:
                Extractor extractorA = f46108t.a(Integer.valueOf(this.f46114f));
                if (extractorA == null) {
                    list.add(new FlacExtractor(this.f46114f));
                } else {
                    list.add(extractorA);
                }
                break;
            case 5:
                list.add(new FlvExtractor());
                break;
            case 6:
                list.add(new MatroskaExtractor(this.f46124p, (this.f46123o ? 0 : 2) | this.f46115g));
                break;
            case 7:
                list.add(new Mp3Extractor((this.f46111c ? 2 : 0) | this.f46118j | (this.f46110b ? 1 : 0)));
                break;
            case 8:
                list.add(new FragmentedMp4Extractor(this.f46124p, this.f46117i | FragmentedMp4Extractor.k(this.f46125q) | (this.f46123o ? 0 : 32)));
                list.add(new Mp4Extractor(this.f46124p, (this.f46123o ? 0 : 16) | this.f46116h | Mp4Extractor.r(this.f46125q)));
                break;
            case 9:
                list.add(new OggExtractor());
                break;
            case 10:
                list.add(new PsExtractor());
                break;
            case 11:
                if (this.f46121m == null) {
                    this.f46121m = ImmutableList.y();
                }
                list.add(new TsExtractor(this.f46119k, !this.f46123o ? 1 : 0, this.f46124p, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(this.f46120l, this.f46121m), this.f46122n));
                break;
            case 12:
                list.add(new WavExtractor());
                break;
            case 14:
                list.add(new JpegExtractor(this.f46126r));
                break;
            case 15:
                Extractor extractorA2 = f46109u.a(new Object[0]);
                if (extractorA2 != null) {
                    list.add(extractorA2);
                }
                break;
            case 16:
                list.add(new AviExtractor(!this.f46123o ? 1 : 0, this.f46124p));
                break;
            case 17:
                list.add(new PngExtractor());
                break;
            case 18:
                list.add(new WebpExtractor());
                break;
            case 19:
                list.add(new BmpExtractor());
                break;
            case 20:
                int i4 = this.f46116h;
                if ((i4 & 2) == 0 && (i4 & 4) == 0) {
                    list.add(new HeifExtractor());
                    break;
                }
                break;
            case 21:
                list.add(new AvifExtractor());
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor l() {
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor m() {
        return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(null);
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public synchronized Extractor[] d(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = f46107s;
            arrayList = new ArrayList(iArr.length);
            int iB = FileTypes.b(map);
            if (iB != -1) {
                i(iB, arrayList);
            }
            int iC = FileTypes.c(uri);
            if (iC != -1 && iC != iB) {
                i(iC, arrayList);
            }
            for (int i3 : iArr) {
                if (i3 != iB && i3 != iC) {
                    i(i3, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public synchronized Extractor[] f() {
        return d(Uri.EMPTY, new HashMap());
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized DefaultExtractorsFactory b(int i3) {
        this.f46125q = i3;
        return this;
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public synchronized DefaultExtractorsFactory c(boolean z2) {
        this.f46123o = z2;
        return this;
    }

    public synchronized DefaultExtractorsFactory n(int i3) {
        this.f46126r = i3;
        return this;
    }

    public synchronized DefaultExtractorsFactory o(int i3) {
        this.f46116h = i3;
        return this;
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public synchronized DefaultExtractorsFactory a(SubtitleParser.Factory factory) {
        this.f46124p = factory;
        return this;
    }
}
