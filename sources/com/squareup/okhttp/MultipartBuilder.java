package com.squareup.okhttp;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class MultipartBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaType f92951a = MediaType.a("multipart/mixed");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaType f92952b = MediaType.a("multipart/alternative");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaType f92953c = MediaType.a("multipart/digest");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MediaType f92954d = MediaType.a("multipart/parallel");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MediaType f92955e = MediaType.a("multipart/form-data");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f92956f = {58, 32};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f92957g = {Ascii.CR, 10};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f92958h = {Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MultipartRequestBody extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteString f92959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaType f92960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f92961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f92962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f92963e;

        /* JADX WARN: Multi-variable type inference failed */
        private long d(BufferedSink bufferedSink, boolean z2) throws EOFException {
            Buffer buffer;
            if (z2) {
                bufferedSink = new Buffer();
                buffer = bufferedSink;
            } else {
                buffer = 0;
            }
            int size = this.f92961c.size();
            long j3 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Headers headers = (Headers) this.f92961c.get(i3);
                RequestBody requestBody = (RequestBody) this.f92962d.get(i3);
                bufferedSink.write(MultipartBuilder.f92958h);
                bufferedSink.q2(this.f92959a);
                bufferedSink.write(MultipartBuilder.f92957g);
                if (headers != null) {
                    int iF = headers.f();
                    for (int i4 = 0; i4 < iF; i4++) {
                        bufferedSink.C0(headers.d(i4)).write(MultipartBuilder.f92956f).C0(headers.g(i4)).write(MultipartBuilder.f92957g);
                    }
                }
                MediaType mediaTypeB = requestBody.b();
                if (mediaTypeB != null) {
                    bufferedSink.C0("Content-Type: ").C0(mediaTypeB.toString()).write(MultipartBuilder.f92957g);
                }
                long jA = requestBody.a();
                if (jA != -1) {
                    bufferedSink.C0("Content-Length: ").j1(jA).write(MultipartBuilder.f92957g);
                } else if (z2) {
                    buffer.a();
                    return -1L;
                }
                bufferedSink.write(MultipartBuilder.f92957g);
                if (z2) {
                    j3 += jA;
                } else {
                    ((RequestBody) this.f92962d.get(i3)).c(bufferedSink);
                }
                bufferedSink.write(MultipartBuilder.f92957g);
            }
            bufferedSink.write(MultipartBuilder.f92958h);
            bufferedSink.q2(this.f92959a);
            bufferedSink.write(MultipartBuilder.f92958h);
            bufferedSink.write(MultipartBuilder.f92957g);
            if (!z2) {
                return j3;
            }
            long size2 = j3 + buffer.size();
            buffer.a();
            return size2;
        }

        @Override // com.squareup.okhttp.RequestBody
        public long a() throws EOFException {
            long j3 = this.f92963e;
            if (j3 != -1) {
                return j3;
            }
            long jD = d(null, true);
            this.f92963e = jD;
            return jD;
        }

        @Override // com.squareup.okhttp.RequestBody
        public MediaType b() {
            return this.f92960b;
        }

        @Override // com.squareup.okhttp.RequestBody
        public void c(BufferedSink bufferedSink) throws EOFException {
            d(bufferedSink, false);
        }
    }
}
