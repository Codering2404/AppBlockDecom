package androidx.media3.muxer;

import android.media.MediaCodec;
import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentedMp4Muxer implements AutoCloseable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ImmutableList f47801d = ImmutableList.G("video/av01", "video/3gpp", "video/avc", "video/hevc", "video/mp4v-es", "video/x-vnd.on2.vp9", "video/apv");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ImmutableList f47802f = ImmutableList.E("audio/mp4a-latm", "audio/3gpp", "audio/amr-wb", "audio/opus", "audio/vorbis", "audio/raw");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentedMp4Writer f47803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetadataCollector f47804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f47805c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OutputStream f47806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f47807b = 2000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f47808c = true;

        public Builder(OutputStream outputStream) {
            this.f47806a = outputStream;
        }

        public FragmentedMp4Muxer a() {
            return new FragmentedMp4Muxer(this.f47806a, this.f47807b, this.f47808c);
        }

        public Builder b(long j3) {
            this.f47807b = j3;
            return this;
        }
    }

    public void a(Metadata.Entry entry) {
        Assertions.b(MuxerUtil.g(entry), "Unsupported metadata");
        this.f47804b.a(entry);
    }

    public int b(Format format) {
        Track trackA = this.f47803a.a(1, format);
        this.f47805c.append(trackA.f47889a, trackA);
        return trackA.f47889a;
    }

    public void c(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws MuxerException {
        try {
            this.f47803a.k((Track) this.f47805c.get(i3), byteBuffer, bufferInfo);
        } catch (IOException e3) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + bufferInfo.presentationTimeUs + ", size=" + bufferInfo.size, e3);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws MuxerException {
        try {
            this.f47803a.c();
        } catch (IOException e3) {
            throw new MuxerException("Failed to close the muxer", e3);
        }
    }

    private FragmentedMp4Muxer(OutputStream outputStream, long j3, boolean z2) {
        Assertions.e(outputStream);
        MetadataCollector metadataCollector = new MetadataCollector();
        this.f47804b = metadataCollector;
        this.f47803a = new FragmentedMp4Writer(outputStream, metadataCollector, AnnexBToAvccConverter.f47798a, j3, z2);
        this.f47805c = new SparseArray();
    }
}
