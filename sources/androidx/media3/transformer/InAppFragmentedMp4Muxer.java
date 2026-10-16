package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.muxer.FragmentedMp4Muxer;
import androidx.media3.muxer.MuxerException;
import androidx.media3.muxer.MuxerUtil;
import androidx.media3.transformer.Muxer;
import com.google.common.collect.ImmutableList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InAppFragmentedMp4Muxer implements Muxer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentedMp4Muxer f48271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f48272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f48273c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements Muxer.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f48274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f48275b;

        @Override // androidx.media3.transformer.Muxer.Factory
        public ImmutableList b(int i3) {
            return i3 == 2 ? FragmentedMp4Muxer.f47801d : i3 == 1 ? FragmentedMp4Muxer.f47802f : ImmutableList.y();
        }

        @Override // androidx.media3.transformer.Muxer.Factory
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public InAppFragmentedMp4Muxer a(String str) throws MuxerException {
            try {
                FragmentedMp4Muxer.Builder builder = new FragmentedMp4Muxer.Builder(new FileOutputStream(str));
                long j3 = this.f48274a;
                if (j3 != -9223372036854775807L) {
                    builder.b(j3);
                }
                return new InAppFragmentedMp4Muxer(builder.a(), this.f48275b);
            } catch (FileNotFoundException e3) {
                throw new MuxerException("Error creating file output stream", e3);
            }
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void a(Metadata.Entry entry) {
        if (MuxerUtil.g(entry)) {
            this.f48271a.a(entry);
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws MuxerException {
        long j3 = this.f48272b;
        if (j3 != -9223372036854775807L && i3 == this.f48273c) {
            long j4 = bufferInfo.presentationTimeUs;
            if (j4 > j3) {
                Log.i("InAppFragmentedMp4Muxer", String.format(Locale.US, "Skipped sample with presentation time (%d) > video duration (%d)", Long.valueOf(j4), Long.valueOf(this.f48272b)));
                return;
            }
        }
        this.f48271a.c(i3, byteBuffer, bufferInfo);
    }

    @Override // androidx.media3.transformer.Muxer
    public int c(Format format) {
        int iB = this.f48271a.b(format);
        if (MimeTypes.q(format.f40632o)) {
            this.f48271a.a(new Mp4OrientationData(format.f40642y));
            this.f48273c = iB;
        }
        return iB;
    }

    @Override // androidx.media3.transformer.Muxer
    public void close() throws MuxerException {
        if (this.f48272b != -9223372036854775807L && this.f48273c != -1) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(0, 0, this.f48272b, 4);
            b(this.f48273c, ByteBuffer.allocateDirect(0), bufferInfo);
        }
        this.f48271a.close();
    }

    private InAppFragmentedMp4Muxer(FragmentedMp4Muxer fragmentedMp4Muxer, long j3) {
        this.f48271a = fragmentedMp4Muxer;
        this.f48272b = j3;
        this.f48273c = -1;
    }
}
