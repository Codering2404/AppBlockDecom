package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultExtractorInput implements ExtractorInput {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataReader f46101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f46102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f46103d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46106g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f46104e = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46100a = new byte[4096];

    static {
        MediaLibraryInfo.a("media3.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j3, long j4) {
        this.f46101b = dataReader;
        this.f46103d = j3;
        this.f46102c = j4;
    }

    private void n(int i3) {
        if (i3 != -1) {
            this.f46103d += (long) i3;
        }
    }

    private void o(int i3) {
        int i4 = this.f46105f + i3;
        byte[] bArr = this.f46104e;
        if (i4 > bArr.length) {
            this.f46104e = Arrays.copyOf(this.f46104e, Util.r(bArr.length * 2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i4, i4 + 524288));
        }
    }

    private int p(byte[] bArr, int i3, int i4) {
        int i5 = this.f46106g;
        if (i5 == 0) {
            return 0;
        }
        int iMin = Math.min(i5, i4);
        System.arraycopy(this.f46104e, 0, bArr, i3, iMin);
        t(iMin);
        return iMin;
    }

    private int q(byte[] bArr, int i3, int i4, int i5, boolean z2) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i6 = this.f46101b.read(bArr, i3 + i5, i4 - i5);
        if (i6 != -1) {
            return i5 + i6;
        }
        if (i5 == 0 && z2) {
            return -1;
        }
        throw new EOFException();
    }

    private int r(int i3) {
        int iMin = Math.min(this.f46106g, i3);
        t(iMin);
        return iMin;
    }

    private void t(int i3) {
        int i4 = this.f46106g - i3;
        this.f46106g = i4;
        this.f46105f = 0;
        byte[] bArr = this.f46104e;
        byte[] bArr2 = i4 < bArr.length - 524288 ? new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i4] : bArr;
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        this.f46104e = bArr2;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public int a(int i3) throws EOFException, InterruptedIOException {
        int iR = r(i3);
        if (iR == 0) {
            byte[] bArr = this.f46100a;
            iR = q(bArr, 0, Math.min(i3, bArr.length), 0, true);
        }
        n(iR);
        return iR;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean d(byte[] bArr, int i3, int i4, boolean z2) {
        if (!l(i4, z2)) {
            return false;
        }
        System.arraycopy(this.f46104e, this.f46105f - i4, bArr, i3, i4);
        return true;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void f() {
        this.f46105f = 0;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean g(byte[] bArr, int i3, int i4, boolean z2) throws EOFException, InterruptedIOException {
        int iP = p(bArr, i3, i4);
        while (iP < i4 && iP != -1) {
            iP = q(bArr, i3, i4, iP, z2);
        }
        n(iP);
        return iP != -1;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getLength() {
        return this.f46102c;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getPosition() {
        return this.f46103d;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long h() {
        return this.f46103d + ((long) this.f46105f);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void i(int i3) throws EOFException, InterruptedIOException {
        l(i3, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public int j(byte[] bArr, int i3, int i4) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int iMin;
        o(i4);
        int i5 = this.f46106g;
        int i6 = this.f46105f;
        int i7 = i5 - i6;
        if (i7 == 0) {
            defaultExtractorInput = this;
            iMin = defaultExtractorInput.q(this.f46104e, i6, i4, 0, true);
            if (iMin == -1) {
                return -1;
            }
            defaultExtractorInput.f46106g += iMin;
        } else {
            defaultExtractorInput = this;
            iMin = Math.min(i4, i7);
        }
        System.arraycopy(defaultExtractorInput.f46104e, defaultExtractorInput.f46105f, bArr, i3, iMin);
        defaultExtractorInput.f46105f += iMin;
        return iMin;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void k(int i3) throws EOFException, InterruptedIOException {
        s(i3, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean l(int i3, boolean z2) throws EOFException, InterruptedIOException {
        o(i3);
        int iQ = this.f46106g - this.f46105f;
        while (iQ < i3) {
            int i4 = i3;
            boolean z3 = z2;
            iQ = q(this.f46104e, this.f46105f, i4, iQ, z3);
            if (iQ == -1) {
                return false;
            }
            this.f46106g = this.f46105f + iQ;
            i3 = i4;
            z2 = z3;
        }
        this.f46105f += i3;
        return true;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void m(byte[] bArr, int i3, int i4) {
        d(bArr, i3, i4, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput, androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws EOFException, InterruptedIOException {
        int iP = p(bArr, i3, i4);
        if (iP == 0) {
            iP = q(bArr, i3, i4, 0, true);
        }
        n(iP);
        return iP;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i3, int i4) throws EOFException, InterruptedIOException {
        g(bArr, i3, i4, false);
    }

    public boolean s(int i3, boolean z2) throws EOFException, InterruptedIOException {
        int iR = r(i3);
        while (iR < i3 && iR != -1) {
            iR = q(this.f46100a, -iR, Math.min(i3, this.f46100a.length + iR), iR, z2);
        }
        n(iR);
        return iR != -1;
    }
}
