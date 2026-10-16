package androidx.media3.extractor;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.Util;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacStreamMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f46160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f46161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f46162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f46163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f46164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SeekTable f46165k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Metadata f46166l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SeekTable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f46167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f46168b;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.f46167a = jArr;
            this.f46168b = jArr2;
        }
    }

    public FlacStreamMetadata(byte[] bArr, int i3) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.p(i3 * 8);
        this.f46155a = parsableBitArray.h(16);
        this.f46156b = parsableBitArray.h(16);
        this.f46157c = parsableBitArray.h(24);
        this.f46158d = parsableBitArray.h(24);
        int iH = parsableBitArray.h(20);
        this.f46159e = iH;
        this.f46160f = j(iH);
        this.f46161g = parsableBitArray.h(3) + 1;
        int iH2 = parsableBitArray.h(5) + 1;
        this.f46162h = iH2;
        this.f46163i = e(iH2);
        this.f46164j = parsableBitArray.j(36);
        this.f46165k = null;
        this.f46166l = null;
    }

    private static int e(int i3) {
        if (i3 == 8) {
            return 1;
        }
        if (i3 == 12) {
            return 2;
        }
        if (i3 == 16) {
            return 4;
        }
        if (i3 == 20) {
            return 5;
        }
        if (i3 != 24) {
            return i3 != 32 ? -1 : 7;
        }
        return 6;
    }

    private static int j(int i3) {
        switch (i3) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public FlacStreamMetadata a(List list) {
        return new FlacStreamMetadata(this.f46155a, this.f46156b, this.f46157c, this.f46158d, this.f46159e, this.f46161g, this.f46162h, this.f46164j, this.f46165k, h(new Metadata(list)));
    }

    public FlacStreamMetadata b(SeekTable seekTable) {
        return new FlacStreamMetadata(this.f46155a, this.f46156b, this.f46157c, this.f46158d, this.f46159e, this.f46161g, this.f46162h, this.f46164j, seekTable, this.f46166l);
    }

    public FlacStreamMetadata c(List list) {
        return new FlacStreamMetadata(this.f46155a, this.f46156b, this.f46157c, this.f46158d, this.f46159e, this.f46161g, this.f46162h, this.f46164j, this.f46165k, h(VorbisUtil.d(list)));
    }

    public long d() {
        long j3;
        long j4;
        int i3 = this.f46158d;
        if (i3 > 0) {
            j3 = (((long) i3) + ((long) this.f46157c)) / 2;
            j4 = 1;
        } else {
            int i4 = this.f46155a;
            j3 = ((((i4 != this.f46156b || i4 <= 0) ? 4096L : i4) * ((long) this.f46161g)) * ((long) this.f46162h)) / 8;
            j4 = 64;
        }
        return j3 + j4;
    }

    public long f() {
        long j3 = this.f46164j;
        if (j3 == 0) {
            return -9223372036854775807L;
        }
        return (j3 * 1000000) / ((long) this.f46159e);
    }

    public Format g(byte[] bArr, Metadata metadata) {
        bArr[4] = -128;
        int i3 = this.f46158d;
        if (i3 <= 0) {
            i3 = -1;
        }
        return new Format.Builder().u0("audio/flac").k0(i3).R(this.f46161g).v0(this.f46159e).o0(Util.h0(this.f46162h)).g0(Collections.singletonList(bArr)).n0(h(metadata)).N();
    }

    public Metadata h(Metadata metadata) {
        Metadata metadata2 = this.f46166l;
        return metadata2 == null ? metadata : metadata2.b(metadata);
    }

    public long i(long j3) {
        return Util.s((j3 * ((long) this.f46159e)) / 1000000, 0L, this.f46164j - 1);
    }

    private FlacStreamMetadata(int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, SeekTable seekTable, Metadata metadata) {
        this.f46155a = i3;
        this.f46156b = i4;
        this.f46157c = i5;
        this.f46158d = i6;
        this.f46159e = i7;
        this.f46160f = j(i7);
        this.f46161g = i8;
        this.f46162h = i9;
        this.f46163i = e(i9);
        this.f46164j = j3;
        this.f46165k = seekTable;
        this.f46166l = metadata;
    }
}
