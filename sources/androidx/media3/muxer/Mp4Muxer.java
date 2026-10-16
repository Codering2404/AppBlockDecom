package androidx.media3.muxer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4Muxer implements AutoCloseable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ImmutableList f47841t = ImmutableList.G("video/av01", "video/3gpp", "video/avc", "video/hevc", "video/mp4v-es", "video/x-vnd.on2.vp9", "video/apv");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ImmutableList f47842u = ImmutableList.E("audio/mp4a-latm", "audio/3gpp", "audio/amr-wb", "audio/opus", "audio/vorbis", "audio/raw");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileOutputStream f47843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileChannel f47844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f47845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnnexBToAvccConverter f47846d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f47847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f47848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f47849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f47850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Mp4AtFileParameters f47851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MetadataCollector f47852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Mp4Writer f47853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f47854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f47855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f47856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private FileOutputStream f47857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MetadataCollector f47858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Mp4Writer f47859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f47860s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileOutputStream f47861a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AnnexBToAvccConverter f47863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f47864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f47865e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Mp4AtFileParameters f47868h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f47862b = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f47866f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47867g = 0;

        public Builder(FileOutputStream fileOutputStream) {
            this.f47861a = fileOutputStream;
        }

        public Mp4Muxer a() {
            boolean z2 = false;
            if (this.f47867g != 1 ? this.f47868h == null : this.f47868h != null) {
                z2 = true;
            }
            Assertions.b(z2, "Mp4AtFileParameters must be set for FILE_FORMAT_MP4_WITH_AUXILIARY_TRACKS_EXTENSION");
            FileOutputStream fileOutputStream = this.f47861a;
            int i3 = this.f47862b;
            AnnexBToAvccConverter annexBToAvccConverter = this.f47863c;
            if (annexBToAvccConverter == null) {
                annexBToAvccConverter = AnnexBToAvccConverter.f47798a;
            }
            return new Mp4Muxer(fileOutputStream, i3, annexBToAvccConverter, this.f47864d, this.f47865e, this.f47866f, this.f47867g, this.f47868h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FileFormat {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LastSampleDurationBehavior {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Mp4AtFileParameters {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f47869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CacheFileProvider f47870b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface CacheFileProvider {
            String a();
        }
    }

    private void f() throws IOException {
        if (this.f47859r == null) {
            return;
        }
        FileChannel fileChannel = this.f47844b;
        fileChannel.position(fileChannel.size());
        FileInputStream fileInputStream = new FileInputStream((String) Assertions.e(this.f47856o));
        this.f47844b.write(Boxes.x(fileInputStream.getChannel().size()));
        ByteStreams.b(fileInputStream, this.f47843a);
        fileInputStream.close();
    }

    private void i() {
        if (this.f47859r == null) {
            this.f47856o = ((Mp4AtFileParameters.CacheFileProvider) Assertions.e(((Mp4AtFileParameters) Assertions.e(this.f47851j)).f47870b)).a();
            this.f47857p = new FileOutputStream(this.f47856o);
            this.f47858q = new MetadataCollector();
            this.f47859r = new Mp4Writer(this.f47857p.getChannel(), (MetadataCollector) Assertions.e(this.f47858q), this.f47846d, this.f47845c, this.f47847f, this.f47848g, this.f47849h);
        }
    }

    private void j() throws IOException {
        if (this.f47859r == null) {
            return;
        }
        MuxerUtil.i((MetadataCollector) Assertions.e(this.f47858q), this.f47852k.f47839d, false, this.f47855n);
        ((Mp4Writer) Assertions.e(this.f47859r)).h();
    }

    private void k() throws IOException {
        MdtaMetadataEntry mdtaMetadataEntryC = MuxerUtil.c(0L);
        if (this.f47859r != null) {
            this.f47852k.a(MuxerUtil.a(((FileOutputStream) Assertions.e(this.f47857p)).getChannel().size() + 16));
            this.f47852k.a(mdtaMetadataEntryC);
        }
        this.f47853l.h();
        if (this.f47859r != null) {
            long size = this.f47844b.size();
            this.f47852k.b(mdtaMetadataEntryC);
            this.f47852k.a(MuxerUtil.c(size));
            this.f47853l.g();
            Assertions.h(this.f47844b.size() == size, "The auxiliary tracks offset should remain the same");
        }
    }

    public void a(Metadata.Entry entry) {
        Assertions.b(MuxerUtil.g(entry), "Unsupported metadata");
        this.f47852k.a(entry);
    }

    public int b(int i3, Format format) throws MuxerException {
        Track trackD;
        if (this.f47850i != 1 || !MuxerUtil.e(format)) {
            Mp4Writer mp4Writer = this.f47853l;
            int i4 = this.f47860s;
            this.f47860s = i4 + 1;
            trackD = mp4Writer.d(i4, i3, format);
        } else if (((Mp4AtFileParameters) Assertions.e(this.f47851j)).f47869a) {
            Mp4Writer mp4Writer2 = this.f47853l;
            int i5 = this.f47860s;
            this.f47860s = i5 + 1;
            trackD = mp4Writer2.c(i5, i3, format);
        } else {
            try {
                i();
                Mp4Writer mp4Writer3 = this.f47859r;
                int i6 = this.f47860s;
                this.f47860s = i6 + 1;
                trackD = mp4Writer3.d(i6, i3, format);
                this.f47855n.add(trackD);
            } catch (FileNotFoundException e3) {
                throw new MuxerException("Cache file not found", e3);
            }
        }
        this.f47854m.add(trackD);
        return trackD.f47889a;
    }

    public int c(Format format) {
        return b(1, format);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        MuxerException muxerException;
        try {
            j();
            k();
            f();
            muxerException = null;
        } catch (IOException e3) {
            muxerException = new MuxerException("Failed to finish writing data", e3);
        }
        try {
            this.f47843a.close();
        } catch (IOException e4) {
            if (muxerException == null) {
                muxerException = new MuxerException("Failed to close output stream", e4);
            } else {
                Log.e("Mp4Muxer", "Failed to close output stream", e4);
            }
        }
        FileOutputStream fileOutputStream = this.f47857p;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                if (muxerException == null) {
                    muxerException = new MuxerException("Failed to close the cache file output stream", e5);
                } else {
                    Log.e("Mp4Muxer", "Failed to close cache file output stream", e5);
                }
            }
        }
        if (muxerException != null) {
            throw muxerException;
        }
    }

    public void l(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Track track = (Track) this.f47854m.get(i3);
        try {
            if (this.f47855n.contains(track)) {
                ((Mp4Writer) Assertions.e(this.f47859r)).t(track, byteBuffer, bufferInfo);
            } else {
                this.f47853l.t(track, byteBuffer, bufferInfo);
            }
        } catch (IOException e3) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + bufferInfo.presentationTimeUs + ", size=" + bufferInfo.size, e3);
        }
    }

    private Mp4Muxer(FileOutputStream fileOutputStream, int i3, AnnexBToAvccConverter annexBToAvccConverter, boolean z2, boolean z3, boolean z4, int i4, Mp4AtFileParameters mp4AtFileParameters) {
        this.f47843a = fileOutputStream;
        FileChannel channel = fileOutputStream.getChannel();
        this.f47844b = channel;
        this.f47845c = i3;
        this.f47846d = annexBToAvccConverter;
        this.f47847f = z3 && z2;
        this.f47848g = z3;
        this.f47849h = z4;
        this.f47850i = i4;
        this.f47851j = mp4AtFileParameters;
        MetadataCollector metadataCollector = new MetadataCollector();
        this.f47852k = metadataCollector;
        this.f47853l = new Mp4Writer(channel, metadataCollector, annexBToAvccConverter, i3, z2, z3, z4);
        this.f47854m = new ArrayList();
        this.f47855n = new ArrayList();
    }
}
