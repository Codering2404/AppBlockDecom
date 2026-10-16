package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class QueueFile implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Logger f88525h = Logger.getLogger(QueueFile.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f88526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f88527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f88528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Element f88529d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Element f88530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f88531g = new byte[16];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Element {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Element f88535c = new Element(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f88536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f88537b;

        Element(int i3, int i4) {
            this.f88536a = i3;
            this.f88537b = i4;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f88536a + ", length = " + this.f88537b + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ElementInputStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f88538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f88539b;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            QueueFile.z(bArr, "buffer");
            if ((i3 | i4) < 0 || i4 > bArr.length - i3) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i5 = this.f88539b;
            if (i5 <= 0) {
                return -1;
            }
            if (i4 > i5) {
                i4 = i5;
            }
            QueueFile.this.N(this.f88538a, bArr, i3, i4);
            this.f88538a = QueueFile.this.e0(this.f88538a + i4);
            this.f88539b -= i4;
            return i4;
        }

        private ElementInputStream(Element element) {
            this.f88538a = QueueFile.this.e0(element.f88536a + 4);
            this.f88539b = element.f88537b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f88539b == 0) {
                return -1;
            }
            QueueFile.this.f88526a.seek(this.f88538a);
            int i3 = QueueFile.this.f88526a.read();
            this.f88538a = QueueFile.this.e0(this.f88538a + 1);
            this.f88539b--;
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ElementReader {
        void a(InputStream inputStream, int i3);
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            n(file);
        }
        this.f88526a = C(file);
        J();
    }

    private static RandomAccessFile C(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private Element F(int i3) throws IOException {
        if (i3 == 0) {
            return Element.f88535c;
        }
        this.f88526a.seek(i3);
        return new Element(i3, this.f88526a.readInt());
    }

    private void J() throws IOException {
        this.f88526a.seek(0L);
        this.f88526a.readFully(this.f88531g);
        int iK = K(this.f88531g, 0);
        this.f88527b = iK;
        if (iK <= this.f88526a.length()) {
            this.f88528c = K(this.f88531g, 4);
            int iK2 = K(this.f88531g, 8);
            int iK3 = K(this.f88531g, 12);
            this.f88529d = F(iK2);
            this.f88530f = F(iK3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f88527b + ", Actual length: " + this.f88526a.length());
    }

    private static int K(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + (bArr[i3 + 3] & 255);
    }

    private int L() {
        return this.f88527b - V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i3, byte[] bArr, int i4, int i5) throws IOException {
        int iE0 = e0(i3);
        int i6 = iE0 + i5;
        int i7 = this.f88527b;
        if (i6 <= i7) {
            this.f88526a.seek(iE0);
            this.f88526a.readFully(bArr, i4, i5);
            return;
        }
        int i8 = i7 - iE0;
        this.f88526a.seek(iE0);
        this.f88526a.readFully(bArr, i4, i8);
        this.f88526a.seek(16L);
        this.f88526a.readFully(bArr, i4 + i8, i5 - i8);
    }

    private void O(int i3, byte[] bArr, int i4, int i5) throws IOException {
        int iE0 = e0(i3);
        int i6 = iE0 + i5;
        int i7 = this.f88527b;
        if (i6 <= i7) {
            this.f88526a.seek(iE0);
            this.f88526a.write(bArr, i4, i5);
            return;
        }
        int i8 = i7 - iE0;
        this.f88526a.seek(iE0);
        this.f88526a.write(bArr, i4, i8);
        this.f88526a.seek(16L);
        this.f88526a.write(bArr, i4 + i8, i5 - i8);
    }

    private void T(int i3) throws IOException {
        this.f88526a.setLength(i3);
        this.f88526a.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e0(int i3) {
        int i4 = this.f88527b;
        return i3 < i4 ? i3 : (i3 + 16) - i4;
    }

    private void g0(int i3, int i4, int i5, int i6) throws IOException {
        q0(this.f88531g, i3, i4, i5, i6);
        this.f88526a.seek(0L);
        this.f88526a.write(this.f88531g);
    }

    private static void j0(byte[] bArr, int i3, int i4) {
        bArr[i3] = (byte) (i4 >> 24);
        bArr[i3 + 1] = (byte) (i4 >> 16);
        bArr[i3 + 2] = (byte) (i4 >> 8);
        bArr[i3 + 3] = (byte) i4;
    }

    private void l(int i3) throws IOException {
        int i4 = i3 + 4;
        int iL = L();
        if (iL >= i4) {
            return;
        }
        int i5 = this.f88527b;
        do {
            iL += i5;
            i5 <<= 1;
        } while (iL < i4);
        T(i5);
        Element element = this.f88530f;
        int iE0 = e0(element.f88536a + 4 + element.f88537b);
        if (iE0 < this.f88529d.f88536a) {
            FileChannel channel = this.f88526a.getChannel();
            channel.position(this.f88527b);
            long j3 = iE0 - 4;
            if (channel.transferTo(16L, j3, channel) != j3) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i6 = this.f88530f.f88536a;
        int i7 = this.f88529d.f88536a;
        if (i6 < i7) {
            int i8 = (this.f88527b + i6) - 16;
            g0(i5, this.f88528c, i7, i8);
            this.f88530f = new Element(i8, this.f88530f.f88537b);
        } else {
            g0(i5, this.f88528c, i7, i6);
        }
        this.f88527b = i5;
    }

    private static void n(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileC = C(file2);
        try {
            randomAccessFileC.setLength(4096L);
            randomAccessFileC.seek(0L);
            byte[] bArr = new byte[16];
            q0(bArr, 4096, 0, 0, 0);
            randomAccessFileC.write(bArr);
            randomAccessFileC.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileC.close();
            throw th;
        }
    }

    private static void q0(byte[] bArr, int... iArr) {
        int i3 = 0;
        for (int i4 : iArr) {
            j0(bArr, i3, i4);
            i3 += 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object z(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public synchronized void M() {
        try {
            if (r()) {
                throw new NoSuchElementException();
            }
            if (this.f88528c == 1) {
                k();
            } else {
                Element element = this.f88529d;
                int iE0 = e0(element.f88536a + 4 + element.f88537b);
                N(iE0, this.f88531g, 0, 4);
                int iK = K(this.f88531g, 0);
                g0(this.f88527b, this.f88528c - 1, iE0, this.f88530f.f88536a);
                this.f88528c--;
                this.f88529d = new Element(iE0, iK);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int V() {
        if (this.f88528c == 0) {
            return 16;
        }
        Element element = this.f88530f;
        int i3 = element.f88536a;
        int i4 = this.f88529d.f88536a;
        return i3 >= i4 ? (i3 - i4) + 4 + element.f88537b + 16 : (((i3 + 4) + element.f88537b) + this.f88527b) - i4;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f88526a.close();
    }

    public void i(byte[] bArr) {
        j(bArr, 0, bArr.length);
    }

    public synchronized void j(byte[] bArr, int i3, int i4) {
        int iE0;
        try {
            z(bArr, "buffer");
            if ((i3 | i4) < 0 || i4 > bArr.length - i3) {
                throw new IndexOutOfBoundsException();
            }
            l(i4);
            boolean zR = r();
            if (zR) {
                iE0 = 16;
            } else {
                Element element = this.f88530f;
                iE0 = e0(element.f88536a + 4 + element.f88537b);
            }
            Element element2 = new Element(iE0, i4);
            j0(this.f88531g, 0, i4);
            O(element2.f88536a, this.f88531g, 0, 4);
            O(element2.f88536a + 4, bArr, i3, i4);
            g0(this.f88527b, this.f88528c + 1, zR ? element2.f88536a : this.f88529d.f88536a, element2.f88536a);
            this.f88530f = element2;
            this.f88528c++;
            if (zR) {
                this.f88529d = element2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void k() {
        try {
            g0(4096, 0, 0, 0);
            this.f88528c = 0;
            Element element = Element.f88535c;
            this.f88529d = element;
            this.f88530f = element;
            if (this.f88527b > 4096) {
                T(4096);
            }
            this.f88527b = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m(ElementReader elementReader) {
        int iE0 = this.f88529d.f88536a;
        for (int i3 = 0; i3 < this.f88528c; i3++) {
            Element elementF = F(iE0);
            elementReader.a(new ElementInputStream(elementF), elementF.f88537b);
            iE0 = e0(elementF.f88536a + 4 + elementF.f88537b);
        }
    }

    public synchronized boolean r() {
        return this.f88528c == 0;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f88527b);
        sb.append(", size=");
        sb.append(this.f88528c);
        sb.append(", first=");
        sb.append(this.f88529d);
        sb.append(", last=");
        sb.append(this.f88530f);
        sb.append(", element lengths=[");
        try {
            m(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                boolean f88532a = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void a(InputStream inputStream, int i3) {
                    if (this.f88532a) {
                        this.f88532a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i3);
                }
            });
        } catch (IOException e3) {
            f88525h.log(Level.WARNING, "read error", (Throwable) e3);
        }
        sb.append("]]");
        return sb.toString();
    }
}
