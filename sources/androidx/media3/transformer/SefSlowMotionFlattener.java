package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SefSlowMotionFlattener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f48368l = NalUnitUtil.f41674a.length;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SlowMotionData f48370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f48371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Iterator f48372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f48373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f48374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f48375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SegmentInfo f48376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SegmentInfo f48377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f48378j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f48369a = new byte[f48368l];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f48379k = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MetadataInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f48380a = -3.4028235E38f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f48381b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f48382c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SlowMotionData f48383d;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SegmentInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f48384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f48385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f48386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f48387d;

        public SegmentInfo(SlowMotionData.Segment segment, int i3, int i4) {
            this.f48384a = Util.P0(segment.f46499a);
            this.f48385b = Util.P0(segment.f46500b);
            int i5 = segment.f46501c;
            this.f48386c = i5;
            this.f48387d = a(i5, i3, i4);
        }

        private static int a(int i3, int i4, int i5) {
            int i6 = i3;
            while (true) {
                if (i6 <= 0) {
                    break;
                }
                if ((i6 & 1) == 1) {
                    Assertions.h((i6 >> 1) == 0, "Invalid speed divisor: " + i3);
                } else {
                    i5++;
                    i6 >>= 1;
                }
            }
            return Math.min(i5, i4);
        }
    }

    public SefSlowMotionFlattener(Format format) {
        MetadataInfo metadataInfoD = d(format.f40629l);
        SlowMotionData slowMotionData = metadataInfoD.f48383d;
        this.f48370b = slowMotionData;
        String str = (String) Assertions.e(format.f40632o);
        this.f48371c = str;
        if (slowMotionData != null) {
            Assertions.b(str.equals("video/avc") || str.equals("video/hevc"), "Unsupported MIME type for SEF slow motion video track: " + str);
        }
        Iterator it = (slowMotionData != null ? slowMotionData.f46497a : ImmutableList.y()).iterator();
        this.f48372d = it;
        this.f48373e = metadataInfoD.f48380a;
        int i3 = metadataInfoD.f48381b;
        this.f48374f = i3;
        int i4 = metadataInfoD.f48382c;
        this.f48375g = i4;
        this.f48377i = it.hasNext() ? new SegmentInfo((SlowMotionData.Segment) it.next(), i3, i4) : null;
    }

    private void b() {
        if (this.f48376h != null) {
            f();
        }
        this.f48376h = this.f48377i;
        this.f48377i = this.f48372d.hasNext() ? new SegmentInfo((SlowMotionData.Segment) this.f48372d.next(), this.f48374f, this.f48375g) : null;
    }

    private static MetadataInfo d(Metadata metadata) {
        MetadataInfo metadataInfo = new MetadataInfo();
        if (metadata != null) {
            for (int i3 = 0; i3 < metadata.e(); i3++) {
                Metadata.Entry entryD = metadata.d(i3);
                if (entryD instanceof SmtaMetadataEntry) {
                    SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) entryD;
                    metadataInfo.f48380a = smtaMetadataEntry.f46502a;
                    metadataInfo.f48381b = smtaMetadataEntry.f46503b - 1;
                } else if (entryD instanceof SlowMotionData) {
                    metadataInfo.f48383d = (SlowMotionData) entryD;
                }
            }
            if (metadataInfo.f48383d != null) {
                Assertions.h(metadataInfo.f48381b != -1, "SVC temporal layer count not found.");
                Assertions.h(metadataInfo.f48380a != -3.4028235E38f, "Capture frame rate not found.");
                float f3 = metadataInfo.f48380a;
                Assertions.h(f3 % 1.0f == 0.0f && f3 % 30.0f == 0.0f, "Invalid capture frame rate: " + metadataInfo.f48380a);
                int i4 = ((int) metadataInfo.f48380a) / 30;
                for (int i5 = metadataInfo.f48381b; i5 >= 0; i5--) {
                    if ((i4 & 1) == 1) {
                        Assertions.h((i4 >> 1) == 0, "Could not compute normal speed max SVC layer for capture frame rate  " + metadataInfo.f48380a);
                        metadataInfo.f48382c = i5;
                        return metadataInfo;
                    }
                    i4 >>= 1;
                }
            }
        }
        return metadataInfo;
    }

    private void f() {
        long j3 = this.f48378j;
        SegmentInfo segmentInfo = this.f48376h;
        this.f48378j = j3 + ((segmentInfo.f48385b - segmentInfo.f48384a) * ((long) (segmentInfo.f48386c - 1)));
        this.f48376h = null;
    }

    private boolean h(int i3, long j3) {
        int i4;
        SegmentInfo segmentInfo = this.f48377i;
        if (segmentInfo != null && i3 < (i4 = segmentInfo.f48387d)) {
            long j4 = ((segmentInfo.f48384a - j3) * 30) / 1000000;
            float f3 = (-(1 << (this.f48374f - i4))) + 0.45f;
            for (int i5 = 1; i5 < this.f48377i.f48387d && j4 < (1 << (this.f48374f - i5)) + f3; i5++) {
                if (i3 <= i5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(ByteBuffer byteBuffer, long j3) {
        int i3;
        if (this.f48370b == null) {
            this.f48379k = j3;
            return false;
        }
        int iPosition = byteBuffer.position();
        byteBuffer.position(f48368l + iPosition);
        byteBuffer.get(this.f48369a, 0, 4);
        if (this.f48371c.equals("video/avc")) {
            byte[] bArr = this.f48369a;
            Assertions.h((bArr[0] & Ascii.US) == 14 && (((bArr[1] & 255) >> 7) == 1), "Missing SVC extension prefix NAL unit.");
            i3 = (this.f48369a[3] & 255) >> 5;
        } else {
            if (!this.f48371c.equals("video/hevc")) {
                throw new IllegalStateException();
            }
            i3 = (this.f48369a[1] & 7) - 1;
        }
        boolean zG = g(i3, j3);
        this.f48379k = c(j3);
        if (!zG) {
            return true;
        }
        byteBuffer.position(iPosition);
        return false;
    }

    long c(long j3) {
        long j4 = this.f48378j + j3;
        SegmentInfo segmentInfo = this.f48376h;
        if (segmentInfo != null) {
            j4 += (j3 - segmentInfo.f48384a) * ((long) (segmentInfo.f48386c - 1));
        }
        return Math.round((j4 * 30) / this.f48373e);
    }

    public long e() {
        Assertions.g(this.f48379k != -9223372036854775807L);
        return this.f48379k;
    }

    boolean g(int i3, long j3) {
        SegmentInfo segmentInfo;
        while (true) {
            segmentInfo = this.f48377i;
            if (segmentInfo == null || j3 < segmentInfo.f48385b) {
                break;
            }
            b();
        }
        if (segmentInfo == null || j3 < segmentInfo.f48384a) {
            SegmentInfo segmentInfo2 = this.f48376h;
            if (segmentInfo2 != null && j3 >= segmentInfo2.f48385b) {
                f();
            }
        } else {
            b();
        }
        SegmentInfo segmentInfo3 = this.f48376h;
        return i3 <= (segmentInfo3 != null ? segmentInfo3.f48387d : this.f48375g) || h(i3, j3);
    }
}
