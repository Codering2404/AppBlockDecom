package androidx.media3.exoplayer.source.mediaparser;

import android.media.MediaParser$SeekableInputReader;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InputReaderAdapterV30 implements MediaParser$SeekableInputReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DataReader f45174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f45175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f45176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f45177d;

    public long a() {
        long j3 = this.f45177d;
        this.f45177d = -1L;
        return j3;
    }

    public void b(long j3) {
        this.f45176c = j3;
    }

    public void c(DataReader dataReader, long j3) {
        this.f45174a = dataReader;
        this.f45175b = j3;
        this.f45177d = -1L;
    }

    public long getLength() {
        return this.f45175b;
    }

    public long getPosition() {
        return this.f45176c;
    }

    public int read(byte[] bArr, int i3, int i4) {
        int i5 = ((DataReader) Util.k(this.f45174a)).read(bArr, i3, i4);
        this.f45176c += (long) i5;
        return i5;
    }

    public void seekToPosition(long j3) {
        this.f45177d = j3;
    }
}
