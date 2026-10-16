package com.bumptech.glide.disklrucache;

import android.os.StrictMode;
import com.facebook.appevents.AppEventsConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DiskLruCache implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f66131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f66132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f66133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f66134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f66135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f66136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f66137h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Writer f66139j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f66141l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f66138i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedHashMap f66140k = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f66142m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ThreadPoolExecutor f66143n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Callable f66144o = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.f66139j == null) {
                        return null;
                    }
                    DiskLruCache.this.q0();
                    if (DiskLruCache.this.M()) {
                        DiskLruCache.this.e0();
                        DiskLruCache.this.f66141l = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Entry f66146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f66147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f66148c;

        public void a() {
            DiskLruCache.this.r(this, false);
        }

        public void b() {
            if (this.f66148c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            DiskLruCache.this.r(this, true);
            this.f66148c = true;
        }

        public File f(int i3) {
            File fileK;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f66146a.f66155f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f66146a.f66154e) {
                        this.f66147b[i3] = true;
                    }
                    fileK = this.f66146a.k(i3);
                    DiskLruCache.this.f66131a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        private Editor(Entry entry) {
            this.f66146a = entry;
            this.f66147b = entry.f66154e ? null : new boolean[DiskLruCache.this.f66137h];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f66150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f66151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f66152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f66153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f66154e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Editor f66155f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f66156g;

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f66137h) {
                throw m(strArr);
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                try {
                    this.f66151b[i3] = Long.parseLong(strArr[i3]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i3) {
            return this.f66152c[i3];
        }

        public File k(int i3) {
            return this.f66153d[i3];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j3 : this.f66151b) {
                sb.append(' ');
                sb.append(j3);
            }
            return sb.toString();
        }

        private Entry(String str) {
            this.f66150a = str;
            this.f66151b = new long[DiskLruCache.this.f66137h];
            this.f66152c = new File[DiskLruCache.this.f66137h];
            this.f66153d = new File[DiskLruCache.this.f66137h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i3 = 0; i3 < DiskLruCache.this.f66137h; i3++) {
                sb.append(i3);
                this.f66152c[i3] = new File(DiskLruCache.this.f66131a, sb.toString());
                sb.append(".tmp");
                this.f66153d[i3] = new File(DiskLruCache.this.f66131a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class Value {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f66158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f66159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f66160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f66161d;

        public File a(int i3) {
            return this.f66161d[i3];
        }

        private Value(String str, long j3, File[] fileArr, long[] jArr) {
            this.f66158a = str;
            this.f66159b = j3;
            this.f66161d = fileArr;
            this.f66160c = jArr;
        }
    }

    private DiskLruCache(File file, int i3, int i4, long j3) {
        this.f66131a = file;
        this.f66135f = i3;
        this.f66132b = new File(file, "journal");
        this.f66133c = new File(file, "journal.tmp");
        this.f66134d = new File(file, "journal.bkp");
        this.f66137h = i4;
        this.f66136g = j3;
    }

    private static void C(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized Editor J(String str, long j3) {
        m();
        Entry entry = (Entry) this.f66140k.get(str);
        if (j3 != -1 && (entry == null || entry.f66156g != j3)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.f66140k.put(str, entry);
        } else if (entry.f66155f != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.f66155f = editor;
        this.f66139j.append((CharSequence) "DIRTY");
        this.f66139j.append(' ');
        this.f66139j.append((CharSequence) str);
        this.f66139j.append('\n');
        K(this.f66139j);
        return editor;
    }

    private static void K(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        int i3 = this.f66141l;
        return i3 >= 2000 && i3 >= this.f66140k.size();
    }

    public static DiskLruCache N(File file, int i3, int i4, long j3) throws IOException {
        if (j3 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                j0(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i3, i4, j3);
        if (diskLruCache.f66132b.exists()) {
            try {
                diskLruCache.T();
                diskLruCache.O();
                return diskLruCache;
            } catch (IOException e3) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e3.getMessage() + ", removing");
                diskLruCache.z();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i3, i4, j3);
        diskLruCache2.e0();
        return diskLruCache2;
    }

    private void O() throws IOException {
        C(this.f66133c);
        Iterator it = this.f66140k.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i3 = 0;
            if (entry.f66155f == null) {
                while (i3 < this.f66137h) {
                    this.f66138i += entry.f66151b[i3];
                    i3++;
                }
            } else {
                entry.f66155f = null;
                while (i3 < this.f66137h) {
                    C(entry.j(i3));
                    C(entry.k(i3));
                    i3++;
                }
                it.remove();
            }
        }
    }

    private void T() {
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.f66132b), Util.f66169a);
        try {
            String strF = strictLineReader.f();
            String strF2 = strictLineReader.f();
            String strF3 = strictLineReader.f();
            String strF4 = strictLineReader.f();
            String strF5 = strictLineReader.f();
            if (!"libcore.io.DiskLruCache".equals(strF) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strF2) || !Integer.toString(this.f66135f).equals(strF3) || !Integer.toString(this.f66137h).equals(strF4) || !"".equals(strF5)) {
                throw new IOException("unexpected journal header: [" + strF + ", " + strF2 + ", " + strF4 + ", " + strF5 + "]");
            }
            int i3 = 0;
            while (true) {
                try {
                    V(strictLineReader.f());
                    i3++;
                } catch (EOFException unused) {
                    this.f66141l = i3 - this.f66140k.size();
                    if (strictLineReader.c()) {
                        e0();
                    } else {
                        this.f66139j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f66132b, true), Util.f66169a));
                    }
                    Util.a(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.a(strictLineReader);
            throw th;
        }
    }

    private void V(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i3 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i3);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i3);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f66140k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i3, iIndexOf2);
        }
        Entry entry = (Entry) this.f66140k.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            this.f66140k.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f66154e = true;
            entry.f66155f = null;
            entry.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            entry.f66155f = new Editor(entry);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e0() {
        try {
            Writer writer = this.f66139j;
            if (writer != null) {
                n(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f66133c), Util.f66169a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f66135f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f66137h));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.f66140k.values()) {
                    if (entry.f66155f != null) {
                        bufferedWriter.write("DIRTY " + entry.f66150a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + entry.f66150a + entry.l() + '\n');
                    }
                }
                n(bufferedWriter);
                if (this.f66132b.exists()) {
                    j0(this.f66132b, this.f66134d, true);
                }
                j0(this.f66133c, this.f66132b, false);
                this.f66134d.delete();
                this.f66139j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f66132b, true), Util.f66169a));
            } catch (Throwable th) {
                n(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void j0(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            C(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void m() {
        if (this.f66139j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void n(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        while (this.f66138i > this.f66136g) {
            g0((String) ((Map.Entry) this.f66140k.entrySet().iterator().next()).getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(Editor editor, boolean z2) {
        Entry entry = editor.f66146a;
        if (entry.f66155f != editor) {
            throw new IllegalStateException();
        }
        if (z2 && !entry.f66154e) {
            for (int i3 = 0; i3 < this.f66137h; i3++) {
                if (!editor.f66147b[i3]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                }
                if (!entry.k(i3).exists()) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i4 = 0; i4 < this.f66137h; i4++) {
            File fileK = entry.k(i4);
            if (!z2) {
                C(fileK);
            } else if (fileK.exists()) {
                File fileJ = entry.j(i4);
                fileK.renameTo(fileJ);
                long j3 = entry.f66151b[i4];
                long length = fileJ.length();
                entry.f66151b[i4] = length;
                this.f66138i = (this.f66138i - j3) + length;
            }
        }
        this.f66141l++;
        entry.f66155f = null;
        if (entry.f66154e || z2) {
            entry.f66154e = true;
            this.f66139j.append((CharSequence) "CLEAN");
            this.f66139j.append(' ');
            this.f66139j.append((CharSequence) entry.f66150a);
            this.f66139j.append((CharSequence) entry.l());
            this.f66139j.append('\n');
            if (z2) {
                long j4 = this.f66142m;
                this.f66142m = 1 + j4;
                entry.f66156g = j4;
            }
        } else {
            this.f66140k.remove(entry.f66150a);
            this.f66139j.append((CharSequence) "REMOVE");
            this.f66139j.append(' ');
            this.f66139j.append((CharSequence) entry.f66150a);
            this.f66139j.append('\n');
        }
        K(this.f66139j);
        if (this.f66138i > this.f66136g || M()) {
            this.f66143n.submit(this.f66144o);
        }
    }

    public Editor F(String str) {
        return J(str, -1L);
    }

    public synchronized Value L(String str) {
        Throwable th;
        try {
            try {
                m();
                Entry entry = (Entry) this.f66140k.get(str);
                if (entry == null) {
                    return null;
                }
                if (!entry.f66154e) {
                    return null;
                }
                for (File file : entry.f66152c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.f66141l++;
                this.f66139j.append((CharSequence) "READ");
                this.f66139j.append(' ');
                this.f66139j.append((CharSequence) str);
                this.f66139j.append('\n');
                if (M()) {
                    this.f66143n.submit(this.f66144o);
                }
                return new Value(str, entry.f66156g, entry.f66152c, entry.f66151b);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f66139j == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f66140k.values());
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Entry entry = (Entry) obj;
                if (entry.f66155f != null) {
                    entry.f66155f.a();
                }
            }
            q0();
            n(this.f66139j);
            this.f66139j = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean g0(String str) {
        try {
            m();
            Entry entry = (Entry) this.f66140k.get(str);
            if (entry != null && entry.f66155f == null) {
                for (int i3 = 0; i3 < this.f66137h; i3++) {
                    File fileJ = entry.j(i3);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f66138i -= entry.f66151b[i3];
                    entry.f66151b[i3] = 0;
                }
                this.f66141l++;
                this.f66139j.append((CharSequence) "REMOVE");
                this.f66139j.append(' ');
                this.f66139j.append((CharSequence) str);
                this.f66139j.append('\n');
                this.f66140k.remove(str);
                if (M()) {
                    this.f66143n.submit(this.f66144o);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public void z() throws IOException {
        close();
        Util.b(this.f66131a);
    }
}
