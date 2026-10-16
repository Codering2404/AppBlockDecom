package androidx.media3.exoplayer.source;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class SampleDataQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Allocator f44867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f44868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f44869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AllocationNode f44870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AllocationNode f44871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AllocationNode f44872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f44873g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AllocationNode implements Allocator.AllocationNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f44874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f44875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Allocation f44876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AllocationNode f44877d;

        public AllocationNode(long j3, int i3) {
            d(j3, i3);
        }

        @Override // androidx.media3.exoplayer.upstream.Allocator.AllocationNode
        public Allocation a() {
            return (Allocation) Assertions.e(this.f44876c);
        }

        public AllocationNode b() {
            this.f44876c = null;
            AllocationNode allocationNode = this.f44877d;
            this.f44877d = null;
            return allocationNode;
        }

        public void c(Allocation allocation, AllocationNode allocationNode) {
            this.f44876c = allocation;
            this.f44877d = allocationNode;
        }

        public void d(long j3, int i3) {
            Assertions.g(this.f44876c == null);
            this.f44874a = j3;
            this.f44875b = j3 + ((long) i3);
        }

        public int e(long j3) {
            return ((int) (j3 - this.f44874a)) + this.f44876c.f45481b;
        }

        @Override // androidx.media3.exoplayer.upstream.Allocator.AllocationNode
        public Allocator.AllocationNode next() {
            AllocationNode allocationNode = this.f44877d;
            if (allocationNode == null || allocationNode.f44876c == null) {
                return null;
            }
            return allocationNode;
        }
    }

    public SampleDataQueue(Allocator allocator) {
        this.f44867a = allocator;
        int iE = allocator.e();
        this.f44868b = iE;
        this.f44869c = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, iE);
        this.f44870d = allocationNode;
        this.f44871e = allocationNode;
        this.f44872f = allocationNode;
    }

    private void a(AllocationNode allocationNode) {
        if (allocationNode.f44876c == null) {
            return;
        }
        this.f44867a.a(allocationNode);
        allocationNode.b();
    }

    private static AllocationNode d(AllocationNode allocationNode, long j3) {
        while (j3 >= allocationNode.f44875b) {
            allocationNode = allocationNode.f44877d;
        }
        return allocationNode;
    }

    private void g(int i3) {
        long j3 = this.f44873g + ((long) i3);
        this.f44873g = j3;
        AllocationNode allocationNode = this.f44872f;
        if (j3 == allocationNode.f44875b) {
            this.f44872f = allocationNode.f44877d;
        }
    }

    private int h(int i3) {
        AllocationNode allocationNode = this.f44872f;
        if (allocationNode.f44876c == null) {
            allocationNode.c(this.f44867a.b(), new AllocationNode(this.f44872f.f44875b, this.f44868b));
        }
        return Math.min(i3, (int) (this.f44872f.f44875b - this.f44873g));
    }

    private static AllocationNode i(AllocationNode allocationNode, long j3, ByteBuffer byteBuffer, int i3) {
        AllocationNode allocationNodeD = d(allocationNode, j3);
        while (i3 > 0) {
            int iMin = Math.min(i3, (int) (allocationNodeD.f44875b - j3));
            byteBuffer.put(allocationNodeD.f44876c.f45480a, allocationNodeD.e(j3), iMin);
            i3 -= iMin;
            j3 += (long) iMin;
            if (j3 == allocationNodeD.f44875b) {
                allocationNodeD = allocationNodeD.f44877d;
            }
        }
        return allocationNodeD;
    }

    private static AllocationNode j(AllocationNode allocationNode, long j3, byte[] bArr, int i3) {
        AllocationNode allocationNodeD = d(allocationNode, j3);
        int i4 = i3;
        while (i4 > 0) {
            int iMin = Math.min(i4, (int) (allocationNodeD.f44875b - j3));
            System.arraycopy(allocationNodeD.f44876c.f45480a, allocationNodeD.e(j3), bArr, i3 - i4, iMin);
            i4 -= iMin;
            j3 += (long) iMin;
            if (j3 == allocationNodeD.f44875b) {
                allocationNodeD = allocationNodeD.f44877d;
            }
        }
        return allocationNodeD;
    }

    private static AllocationNode k(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        long j3 = sampleExtrasHolder.f44905b;
        int iP = 1;
        parsableByteArray.S(1);
        AllocationNode allocationNodeJ = j(allocationNode, j3, parsableByteArray.e(), 1);
        long j4 = j3 + 1;
        byte b3 = parsableByteArray.e()[0];
        boolean z2 = (b3 & 128) != 0;
        int i3 = b3 & Ascii.DEL;
        CryptoInfo cryptoInfo = decoderInputBuffer.f42137c;
        byte[] bArr = cryptoInfo.f42124a;
        if (bArr == null) {
            cryptoInfo.f42124a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        AllocationNode allocationNodeJ2 = j(allocationNodeJ, j4, cryptoInfo.f42124a, i3);
        long j5 = j4 + ((long) i3);
        if (z2) {
            parsableByteArray.S(2);
            allocationNodeJ2 = j(allocationNodeJ2, j5, parsableByteArray.e(), 2);
            j5 += 2;
            iP = parsableByteArray.P();
        }
        int i4 = iP;
        int[] iArr = cryptoInfo.f42127d;
        if (iArr == null || iArr.length < i4) {
            iArr = new int[i4];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.f42128e;
        if (iArr3 == null || iArr3.length < i4) {
            iArr3 = new int[i4];
        }
        int[] iArr4 = iArr3;
        if (z2) {
            int i5 = i4 * 6;
            parsableByteArray.S(i5);
            allocationNodeJ2 = j(allocationNodeJ2, j5, parsableByteArray.e(), i5);
            j5 += (long) i5;
            parsableByteArray.W(0);
            for (int i6 = 0; i6 < i4; i6++) {
                iArr2[i6] = parsableByteArray.P();
                iArr4[i6] = parsableByteArray.L();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.f44904a - ((int) (j5 - sampleExtrasHolder.f44905b));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.k(sampleExtrasHolder.f44906c);
        cryptoInfo.c(i4, iArr2, iArr4, cryptoData.f46228b, cryptoInfo.f42124a, cryptoData.f46227a, cryptoData.f46229c, cryptoData.f46230d);
        long j6 = sampleExtrasHolder.f44905b;
        int i7 = (int) (j5 - j6);
        sampleExtrasHolder.f44905b = j6 + ((long) i7);
        sampleExtrasHolder.f44904a -= i7;
        return allocationNodeJ2;
    }

    private static AllocationNode l(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.r()) {
            allocationNode = k(allocationNode, decoderInputBuffer, sampleExtrasHolder, parsableByteArray);
        }
        if (!decoderInputBuffer.h()) {
            decoderInputBuffer.p(sampleExtrasHolder.f44904a);
            return i(allocationNode, sampleExtrasHolder.f44905b, decoderInputBuffer.f42138d, sampleExtrasHolder.f44904a);
        }
        parsableByteArray.S(4);
        AllocationNode allocationNodeJ = j(allocationNode, sampleExtrasHolder.f44905b, parsableByteArray.e(), 4);
        int iL = parsableByteArray.L();
        sampleExtrasHolder.f44905b += 4;
        sampleExtrasHolder.f44904a -= 4;
        decoderInputBuffer.p(iL);
        AllocationNode allocationNodeI = i(allocationNodeJ, sampleExtrasHolder.f44905b, decoderInputBuffer.f42138d, iL);
        sampleExtrasHolder.f44905b += (long) iL;
        int i3 = sampleExtrasHolder.f44904a - iL;
        sampleExtrasHolder.f44904a = i3;
        decoderInputBuffer.t(i3);
        return i(allocationNodeI, sampleExtrasHolder.f44905b, decoderInputBuffer.f42141h, sampleExtrasHolder.f44904a);
    }

    public void b(long j3) {
        AllocationNode allocationNode;
        if (j3 == -1) {
            return;
        }
        while (true) {
            allocationNode = this.f44870d;
            if (j3 < allocationNode.f44875b) {
                break;
            }
            this.f44867a.c(allocationNode.f44876c);
            this.f44870d = this.f44870d.b();
        }
        if (this.f44871e.f44874a < allocationNode.f44874a) {
            this.f44871e = allocationNode;
        }
    }

    public void c(long j3) {
        Assertions.a(j3 <= this.f44873g);
        this.f44873g = j3;
        if (j3 != 0) {
            AllocationNode allocationNode = this.f44870d;
            if (j3 != allocationNode.f44874a) {
                while (this.f44873g > allocationNode.f44875b) {
                    allocationNode = allocationNode.f44877d;
                }
                AllocationNode allocationNode2 = (AllocationNode) Assertions.e(allocationNode.f44877d);
                a(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.f44875b, this.f44868b);
                allocationNode.f44877d = allocationNode3;
                if (this.f44873g == allocationNode.f44875b) {
                    allocationNode = allocationNode3;
                }
                this.f44872f = allocationNode;
                if (this.f44871e == allocationNode2) {
                    this.f44871e = allocationNode3;
                    return;
                }
                return;
            }
        }
        a(this.f44870d);
        AllocationNode allocationNode4 = new AllocationNode(this.f44873g, this.f44868b);
        this.f44870d = allocationNode4;
        this.f44871e = allocationNode4;
        this.f44872f = allocationNode4;
    }

    public long e() {
        return this.f44873g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        l(this.f44871e, decoderInputBuffer, sampleExtrasHolder, this.f44869c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.f44871e = l(this.f44871e, decoderInputBuffer, sampleExtrasHolder, this.f44869c);
    }

    public void n() {
        a(this.f44870d);
        this.f44870d.d(0L, this.f44868b);
        AllocationNode allocationNode = this.f44870d;
        this.f44871e = allocationNode;
        this.f44872f = allocationNode;
        this.f44873g = 0L;
        this.f44867a.d();
    }

    public void o() {
        this.f44871e = this.f44870d;
    }

    public int p(DataReader dataReader, int i3, boolean z2) throws EOFException {
        int iH = h(i3);
        AllocationNode allocationNode = this.f44872f;
        int i4 = dataReader.read(allocationNode.f44876c.f45480a, allocationNode.e(this.f44873g), iH);
        if (i4 != -1) {
            g(i4);
            return i4;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(ParsableByteArray parsableByteArray, int i3) {
        while (i3 > 0) {
            int iH = h(i3);
            AllocationNode allocationNode = this.f44872f;
            parsableByteArray.l(allocationNode.f44876c.f45480a, allocationNode.e(this.f44873g), iH);
            i3 -= iH;
            g(iH);
        }
    }
}
