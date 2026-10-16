package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class NameValueBlockReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InflaterSource f93288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f93289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BufferedSource f93290c;

    public NameValueBlockReader(BufferedSource bufferedSource) {
        InflaterSource inflaterSource = new InflaterSource(new ForwardingSource(bufferedSource) { // from class: com.squareup.okhttp.internal.framed.NameValueBlockReader.1
            @Override // okio.ForwardingSource, okio.Source
            public long t2(Buffer buffer, long j3) {
                if (NameValueBlockReader.this.f93289b == 0) {
                    return -1L;
                }
                long jT2 = super.t2(buffer, Math.min(j3, NameValueBlockReader.this.f93289b));
                if (jT2 == -1) {
                    return -1L;
                }
                NameValueBlockReader nameValueBlockReader = NameValueBlockReader.this;
                nameValueBlockReader.f93289b = (int) (((long) nameValueBlockReader.f93289b) - jT2);
                return jT2;
            }
        }, new Inflater() { // from class: com.squareup.okhttp.internal.framed.NameValueBlockReader.2
            @Override // java.util.zip.Inflater
            public int inflate(byte[] bArr, int i3, int i4) throws DataFormatException {
                int iInflate = super.inflate(bArr, i3, i4);
                if (iInflate != 0 || !needsDictionary()) {
                    return iInflate;
                }
                setDictionary(Spdy3.f93301a);
                return super.inflate(bArr, i3, i4);
            }
        });
        this.f93288a = inflaterSource;
        this.f93290c = Okio.d(inflaterSource);
    }

    private void d() throws IOException {
        if (this.f93289b > 0) {
            this.f93288a.b();
            if (this.f93289b == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.f93289b);
        }
    }

    private ByteString e() {
        return this.f93290c.q1(this.f93290c.readInt());
    }

    public void c() {
        this.f93290c.close();
    }

    public List f(int i3) {
        this.f93289b += i3;
        int i4 = this.f93290c.readInt();
        if (i4 < 0) {
            throw new IOException("numberOfPairs < 0: " + i4);
        }
        if (i4 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + i4);
        }
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            ByteString byteStringG = e().G();
            ByteString byteStringE = e();
            if (byteStringG.C() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new Header(byteStringG, byteStringE));
        }
        d();
        return arrayList;
    }
}
