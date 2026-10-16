package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DiskBasedCache implements Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f57775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f57776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FileSupplier f57777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f57778d;

    /* JADX INFO: renamed from: com.android.volley.toolbox.DiskBasedCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements FileSupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f57779a;

        @Override // com.android.volley.toolbox.DiskBasedCache.FileSupplier
        public File get() {
            return this.f57779a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FileSupplier {
        File get();
    }

    public DiskBasedCache(FileSupplier fileSupplier, int i3) {
        this.f57775a = new LinkedHashMap(16, 0.75f, true);
        this.f57776b = 0L;
        this.f57777c = fileSupplier;
        this.f57778d = i3;
    }

    private String g(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void h() {
        if (this.f57777c.get().exists()) {
            return;
        }
        VolleyLog.b("Re-initializing cache after external clearing.", new Object[0]);
        this.f57775a.clear();
        this.f57776b = 0L;
        initialize();
    }

    private void i() {
        if (this.f57776b < this.f57778d) {
            return;
        }
        int i3 = 0;
        if (VolleyLog.f57725b) {
            VolleyLog.e("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f57776b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.f57775a.entrySet().iterator();
        while (it.hasNext()) {
            CacheHeader cacheHeader = (CacheHeader) ((Map.Entry) it.next()).getValue();
            if (f(cacheHeader.f57781b).delete()) {
                this.f57776b -= cacheHeader.f57780a;
            } else {
                String str = cacheHeader.f57781b;
                VolleyLog.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
            }
            it.remove();
            i3++;
            if (this.f57776b < this.f57778d * 0.9f) {
                break;
            }
        }
        if (VolleyLog.f57725b) {
            VolleyLog.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.f57776b - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    private void j(String str, CacheHeader cacheHeader) {
        if (this.f57775a.containsKey(str)) {
            this.f57776b += cacheHeader.f57780a - ((CacheHeader) this.f57775a.get(str)).f57780a;
        } else {
            this.f57776b += cacheHeader.f57780a;
        }
        this.f57775a.put(str, cacheHeader);
    }

    private static int k(InputStream inputStream) throws IOException {
        int i3 = inputStream.read();
        if (i3 != -1) {
            return i3;
        }
        throw new EOFException();
    }

    static List l(CountingInputStream countingInputStream) throws IOException {
        int iM = m(countingInputStream);
        if (iM < 0) {
            throw new IOException("readHeaderList size=" + iM);
        }
        List arrayList = iM == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i3 = 0; i3 < iM; i3++) {
            arrayList.add(new Header(o(countingInputStream).intern(), o(countingInputStream).intern()));
        }
        return arrayList;
    }

    static int m(InputStream inputStream) {
        return (k(inputStream) << 24) | k(inputStream) | (k(inputStream) << 8) | (k(inputStream) << 16);
    }

    static long n(InputStream inputStream) {
        return (((long) k(inputStream)) & 255) | ((((long) k(inputStream)) & 255) << 8) | ((((long) k(inputStream)) & 255) << 16) | ((((long) k(inputStream)) & 255) << 24) | ((((long) k(inputStream)) & 255) << 32) | ((((long) k(inputStream)) & 255) << 40) | ((((long) k(inputStream)) & 255) << 48) | ((255 & ((long) k(inputStream))) << 56);
    }

    static String o(CountingInputStream countingInputStream) {
        return new String(r(countingInputStream, n(countingInputStream)), Utf8Charset.NAME);
    }

    private void q(String str) {
        CacheHeader cacheHeader = (CacheHeader) this.f57775a.remove(str);
        if (cacheHeader != null) {
            this.f57776b -= cacheHeader.f57780a;
        }
    }

    static byte[] r(CountingInputStream countingInputStream, long j3) throws IOException {
        long jA = countingInputStream.a();
        if (j3 >= 0 && j3 <= jA) {
            int i3 = (int) j3;
            if (i3 == j3) {
                byte[] bArr = new byte[i3];
                new DataInputStream(countingInputStream).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j3 + ", maxLength=" + jA);
    }

    static void s(List list, OutputStream outputStream) throws IOException {
        if (list == null) {
            t(outputStream, 0);
            return;
        }
        t(outputStream, list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            v(outputStream, header.a());
            v(outputStream, header.b());
        }
    }

    static void t(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(i3 & 255);
        outputStream.write((i3 >> 8) & 255);
        outputStream.write((i3 >> 16) & 255);
        outputStream.write((i3 >> 24) & 255);
    }

    static void u(OutputStream outputStream, long j3) throws IOException {
        outputStream.write((byte) j3);
        outputStream.write((byte) (j3 >>> 8));
        outputStream.write((byte) (j3 >>> 16));
        outputStream.write((byte) (j3 >>> 24));
        outputStream.write((byte) (j3 >>> 32));
        outputStream.write((byte) (j3 >>> 40));
        outputStream.write((byte) (j3 >>> 48));
        outputStream.write((byte) (j3 >>> 56));
    }

    static void v(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Utf8Charset.NAME);
        u(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // com.android.volley.Cache
    public synchronized Cache.Entry a(String str) {
        CacheHeader cacheHeader = (CacheHeader) this.f57775a.get(str);
        if (cacheHeader == null) {
            return null;
        }
        File fileF = f(str);
        try {
            CountingInputStream countingInputStream = new CountingInputStream(new BufferedInputStream(d(fileF)), fileF.length());
            try {
                CacheHeader cacheHeaderB = CacheHeader.b(countingInputStream);
                if (TextUtils.equals(str, cacheHeaderB.f57781b)) {
                    return cacheHeader.c(r(countingInputStream, countingInputStream.a()));
                }
                VolleyLog.b("%s: key=%s, found=%s", fileF.getAbsolutePath(), str, cacheHeaderB.f57781b);
                q(str);
                return null;
            } finally {
                countingInputStream.close();
            }
        } catch (IOException e3) {
            VolleyLog.b("%s: %s", fileF.getAbsolutePath(), e3.toString());
            p(str);
            return null;
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void b(String str, boolean z2) {
        try {
            Cache.Entry entryA = a(str);
            if (entryA != null) {
                entryA.f57647f = 0L;
                if (z2) {
                    entryA.f57646e = 0L;
                }
                c(str, entryA);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void c(String str, Cache.Entry entry) {
        BufferedOutputStream bufferedOutputStream;
        CacheHeader cacheHeader;
        long length = this.f57776b + ((long) entry.f57642a.length);
        int i3 = this.f57778d;
        if (length <= i3 || r2.length <= i3 * 0.9f) {
            File fileF = f(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(e(fileF));
                cacheHeader = new CacheHeader(str, entry);
            } catch (IOException unused) {
                if (!fileF.delete()) {
                    VolleyLog.b("Could not clean up file %s", fileF.getAbsolutePath());
                }
                h();
            }
            if (!cacheHeader.d(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.b("Failed to write header for %s", fileF.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(entry.f57642a);
            bufferedOutputStream.close();
            cacheHeader.f57780a = fileF.length();
            j(str, cacheHeader);
            i();
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        try {
            File[] fileArrListFiles = this.f57777c.get().listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
            this.f57775a.clear();
            this.f57776b = 0L;
            VolleyLog.b("Cache cleared.", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    InputStream d(File file) {
        return new FileInputStream(file);
    }

    OutputStream e(File file) {
        return new FileOutputStream(file);
    }

    public File f(String str) {
        return new File(this.f57777c.get(), g(str));
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        long length;
        CountingInputStream countingInputStream;
        File file = this.f57777c.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                VolleyLog.c("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                length = file2.length();
                countingInputStream = new CountingInputStream(new BufferedInputStream(d(file2)), length);
            } catch (IOException unused) {
                file2.delete();
            }
            try {
                CacheHeader cacheHeaderB = CacheHeader.b(countingInputStream);
                cacheHeaderB.f57780a = length;
                j(cacheHeaderB.f57781b, cacheHeaderB);
                countingInputStream.close();
            } catch (Throwable th) {
                countingInputStream.close();
                throw th;
            }
        }
    }

    public synchronized void p(String str) {
        boolean zDelete = f(str).delete();
        q(str);
        if (!zDelete) {
            VolleyLog.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CountingInputStream extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f57788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f57789b;

        CountingInputStream(InputStream inputStream, long j3) {
            super(inputStream);
            this.f57788a = j3;
        }

        long a() {
            return this.f57788a - this.f57789b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i3 = super.read();
            if (i3 != -1) {
                this.f57789b++;
            }
            return i3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = super.read(bArr, i3, i4);
            if (i5 != -1) {
                this.f57789b += (long) i5;
            }
            return i5;
        }
    }

    public DiskBasedCache(FileSupplier fileSupplier) {
        this(fileSupplier, 5242880);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CacheHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f57780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f57781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f57782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f57783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f57784e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f57785f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f57786g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final List f57787h;

        private CacheHeader(String str, String str2, long j3, long j4, long j5, long j6, List list) {
            this.f57781b = str;
            this.f57782c = "".equals(str2) ? null : str2;
            this.f57783d = j3;
            this.f57784e = j4;
            this.f57785f = j5;
            this.f57786g = j6;
            this.f57787h = list;
        }

        private static List a(Cache.Entry entry) {
            List list = entry.f57649h;
            return list != null ? list : HttpHeaderParser.i(entry.f57648g);
        }

        static CacheHeader b(CountingInputStream countingInputStream) throws IOException {
            if (DiskBasedCache.m(countingInputStream) == 538247942) {
                return new CacheHeader(DiskBasedCache.o(countingInputStream), DiskBasedCache.o(countingInputStream), DiskBasedCache.n(countingInputStream), DiskBasedCache.n(countingInputStream), DiskBasedCache.n(countingInputStream), DiskBasedCache.n(countingInputStream), DiskBasedCache.l(countingInputStream));
            }
            throw new IOException();
        }

        Cache.Entry c(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.f57642a = bArr;
            entry.f57643b = this.f57782c;
            entry.f57644c = this.f57783d;
            entry.f57645d = this.f57784e;
            entry.f57646e = this.f57785f;
            entry.f57647f = this.f57786g;
            entry.f57648g = HttpHeaderParser.j(this.f57787h);
            entry.f57649h = Collections.unmodifiableList(this.f57787h);
            return entry;
        }

        boolean d(OutputStream outputStream) {
            try {
                DiskBasedCache.t(outputStream, 538247942);
                DiskBasedCache.v(outputStream, this.f57781b);
                String str = this.f57782c;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.v(outputStream, str);
                DiskBasedCache.u(outputStream, this.f57783d);
                DiskBasedCache.u(outputStream, this.f57784e);
                DiskBasedCache.u(outputStream, this.f57785f);
                DiskBasedCache.u(outputStream, this.f57786g);
                DiskBasedCache.s(this.f57787h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e3) {
                VolleyLog.b("%s", e3.toString());
                return false;
            }
        }

        CacheHeader(String str, Cache.Entry entry) {
            this(str, entry.f57643b, entry.f57644c, entry.f57645d, entry.f57646e, entry.f57647f, a(entry));
        }
    }
}
