package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.muxer.Mp4Muxer;
import androidx.media3.muxer.MuxerException;
import androidx.media3.muxer.MuxerUtil;
import androidx.media3.transformer.Muxer;
import com.google.common.collect.ImmutableList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InAppMp4Muxer implements Muxer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mp4Muxer f48276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetadataProvider f48277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f48278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f48279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f48280e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements Muxer.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MetadataProvider f48281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f48282b;

        @Override // androidx.media3.transformer.Muxer.Factory
        public ImmutableList b(int i3) {
            return i3 == 2 ? Mp4Muxer.f47841t : i3 == 1 ? Mp4Muxer.f47842u : ImmutableList.y();
        }

        @Override // androidx.media3.transformer.Muxer.Factory
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public InAppMp4Muxer a(String str) throws MuxerException {
            try {
                return new InAppMp4Muxer(new Mp4Muxer.Builder(new FileOutputStream(str)).a(), this.f48281a, this.f48282b);
            } catch (FileNotFoundException e3) {
                throw new MuxerException("Error creating file output stream", e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MetadataProvider {
        void a(Set set);
    }

    private void d() {
        if (this.f48277b != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f48279d);
            this.f48277b.a(linkedHashSet);
            this.f48279d.clear();
            this.f48279d.addAll(linkedHashSet);
        }
        Iterator it = this.f48279d.iterator();
        while (it.hasNext()) {
            this.f48276a.a((Metadata.Entry) it.next());
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void a(Metadata.Entry entry) {
        if (MuxerUtil.g(entry)) {
            this.f48279d.add(entry);
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        long j3 = this.f48278c;
        if (j3 != -9223372036854775807L && i3 == this.f48280e) {
            long j4 = bufferInfo.presentationTimeUs;
            if (j4 > j3) {
                Log.i("InAppMp4Muxer", String.format(Locale.US, "Skipped sample with presentation time (%d) > video duration (%d)", Long.valueOf(j4), Long.valueOf(this.f48278c)));
                return;
            }
        }
        this.f48276a.l(i3, byteBuffer, bufferInfo);
    }

    @Override // androidx.media3.transformer.Muxer
    public int c(Format format) {
        int iC = this.f48276a.c(format);
        if (MimeTypes.q(format.f40632o)) {
            this.f48276a.a(new Mp4OrientationData(format.f40642y));
            this.f48280e = iC;
        }
        return iC;
    }

    @Override // androidx.media3.transformer.Muxer
    public void close() {
        if (this.f48278c != -9223372036854775807L && this.f48280e != -1) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(0, 0, this.f48278c, 4);
            b(this.f48280e, ByteBuffer.allocateDirect(0), bufferInfo);
        }
        d();
        this.f48276a.close();
    }

    private InAppMp4Muxer(Mp4Muxer mp4Muxer, MetadataProvider metadataProvider, long j3) {
        this.f48276a = mp4Muxer;
        this.f48277b = metadataProvider;
        this.f48278c = j3;
        this.f48279d = new LinkedHashSet();
        this.f48280e = -1;
    }
}
