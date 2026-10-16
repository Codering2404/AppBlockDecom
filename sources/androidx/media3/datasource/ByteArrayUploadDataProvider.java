package androidx.media3.datasource;

import android.net.http.UploadDataProvider;
import android.net.http.UploadDataSink;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ByteArrayUploadDataProvider extends UploadDataProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f41805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f41806b;

    public ByteArrayUploadDataProvider(byte[] bArr) {
        this.f41805a = bArr;
    }

    public long getLength() {
        return this.f41805a.length;
    }

    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int iMin = Math.min(byteBuffer.remaining(), this.f41805a.length - this.f41806b);
        byteBuffer.put(this.f41805a, this.f41806b, iMin);
        this.f41806b += iMin;
        uploadDataSink.onReadSucceeded(false);
    }

    public void rewind(UploadDataSink uploadDataSink) {
        this.f41806b = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
