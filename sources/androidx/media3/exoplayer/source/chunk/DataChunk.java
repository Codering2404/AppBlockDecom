package androidx.media3.exoplayer.source.chunk;

import androidx.media3.datasource.DataSourceUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DataChunk extends Chunk {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f45136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f45137k;

    private void g(int i3) {
        byte[] bArr = this.f45136j;
        if (bArr.length < i3 + 16384) {
            this.f45136j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        try {
            this.f45100i.b(this.f45093b);
            int i3 = 0;
            int i4 = 0;
            while (i3 != -1 && !this.f45137k) {
                g(i4);
                i3 = this.f45100i.read(this.f45136j, i4, 16384);
                if (i3 != -1) {
                    i4 += i3;
                }
            }
            if (!this.f45137k) {
                f(this.f45136j, i4);
            }
            DataSourceUtil.a(this.f45100i);
        } catch (Throwable th) {
            DataSourceUtil.a(this.f45100i);
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void c() {
        this.f45137k = true;
    }

    protected abstract void f(byte[] bArr, int i3);
}
