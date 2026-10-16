package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class MultiReader extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator f85278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Reader f85279b;

    MultiReader(Iterator it) {
        this.f85278a = it;
        a();
    }

    private void a() {
        close();
        if (this.f85278a.hasNext()) {
            this.f85279b = ((CharSource) this.f85278a.next()).a();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Reader reader = this.f85279b;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f85279b = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) throws IOException {
        Preconditions.t(cArr);
        Reader reader = this.f85279b;
        if (reader == null) {
            return -1;
        }
        int i5 = reader.read(cArr, i3, i4);
        if (i5 != -1) {
            return i5;
        }
        a();
        return read(cArr, i3, i4);
    }

    @Override // java.io.Reader
    public boolean ready() {
        Reader reader = this.f85279b;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j3) throws IOException {
        Preconditions.e(j3 >= 0, "n is negative");
        if (j3 > 0) {
            while (true) {
                Reader reader = this.f85279b;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(j3);
                if (jSkip > 0) {
                    return jSkip;
                }
                a();
            }
        }
        return 0L;
    }
}
