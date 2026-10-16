package com.squareup.okhttp.internal;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.facebook.appevents.AppEventsConstants;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class DiskLruCache implements Closeable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final Pattern f93051t = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Sink f93052u = new Sink() { // from class: com.squareup.okhttp.internal.DiskLruCache.4
        @Override // okio.Sink
        public void H0(Buffer buffer, long j3) throws EOFException {
            buffer.skip(j3);
        }

        @Override // okio.Sink
        public Timeout v() {
            return Timeout.f145128e;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileSystem f93053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f93054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f93055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f93056d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f93057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f93058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f93059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f93060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f93061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BufferedSink f93062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LinkedHashMap f93063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f93064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f93065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f93066o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f93067p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f93068q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Executor f93069r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f93070s;

    /* JADX INFO: renamed from: com.squareup.okhttp.internal.DiskLruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiskLruCache f93071a;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f93071a) {
                if ((!this.f93071a.f93066o) || this.f93071a.f93067p) {
                    return;
                }
                try {
                    this.f93071a.O0();
                    if (this.f93071a.V()) {
                        this.f93071a.w0();
                        this.f93071a.f93064m = 0;
                    }
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.squareup.okhttp.internal.DiskLruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Iterator<Snapshot> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator f93073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Snapshot f93074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Snapshot f93075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DiskLruCache f93076d;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.f93074b;
            this.f93075c = snapshot;
            this.f93074b = null;
            return snapshot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f93074b != null) {
                return true;
            }
            synchronized (this.f93076d) {
                try {
                    if (this.f93076d.f93067p) {
                        return false;
                    }
                    while (this.f93073a.hasNext()) {
                        Snapshot snapshotN = ((Entry) this.f93073a.next()).n();
                        if (snapshotN != null) {
                            this.f93074b = snapshotN;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot snapshot = this.f93075c;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                this.f93076d.z0(snapshot.f93091a);
            } catch (IOException unused) {
            } finally {
                this.f93075c = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Entry f93077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f93078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f93079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f93080d;

        /* synthetic */ Editor(DiskLruCache diskLruCache, Entry entry, AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        public void a() {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.K(this, false);
            }
        }

        public void e() {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f93079c) {
                        DiskLruCache.this.K(this, false);
                        DiskLruCache.this.A0(this.f93077a);
                    } else {
                        DiskLruCache.this.K(this, true);
                    }
                    this.f93080d = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Sink f(int i3) {
            FaultHidingSink faultHidingSink;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f93077a.f93088f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f93077a.f93087e) {
                        this.f93078b[i3] = true;
                    }
                    try {
                        faultHidingSink = new FaultHidingSink(DiskLruCache.this.f93053a.f(this.f93077a.f93086d[i3])) { // from class: com.squareup.okhttp.internal.DiskLruCache.Editor.1
                            @Override // com.squareup.okhttp.internal.FaultHidingSink
                            protected void a(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.f93079c = true;
                                }
                            }
                        };
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.f93052u;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return faultHidingSink;
        }

        private Editor(Entry entry) {
            this.f93077a = entry;
            this.f93078b = entry.f93087e ? null : new boolean[DiskLruCache.this.f93060i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f93083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f93084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final File[] f93085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f93086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f93087e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Editor f93088f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f93089g;

        /* synthetic */ Entry(DiskLruCache diskLruCache, String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private IOException l(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f93060i) {
                throw l(strArr);
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                try {
                    this.f93084b[i3] = Long.parseLong(strArr[i3]);
                } catch (NumberFormatException unused) {
                    throw l(strArr);
                }
            }
        }

        Snapshot n() {
            Source source;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.f93060i];
            long[] jArr = (long[]) this.f93084b.clone();
            for (int i3 = 0; i3 < DiskLruCache.this.f93060i; i3++) {
                try {
                    sourceArr[i3] = DiskLruCache.this.f93053a.e(this.f93085c[i3]);
                } catch (FileNotFoundException unused) {
                    for (int i4 = 0; i4 < DiskLruCache.this.f93060i && (source = sourceArr[i4]) != null; i4++) {
                        Util.c(source);
                    }
                    return null;
                }
            }
            return new Snapshot(DiskLruCache.this, this.f93083a, this.f93089g, sourceArr, jArr, null);
        }

        void o(BufferedSink bufferedSink) {
            for (long j3 : this.f93084b) {
                bufferedSink.writeByte(32).j1(j3);
            }
        }

        private Entry(String str) {
            this.f93083a = str;
            this.f93084b = new long[DiskLruCache.this.f93060i];
            this.f93085c = new File[DiskLruCache.this.f93060i];
            this.f93086d = new File[DiskLruCache.this.f93060i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i3 = 0; i3 < DiskLruCache.this.f93060i; i3++) {
                sb.append(i3);
                this.f93085c[i3] = new File(DiskLruCache.this.f93054b, sb.toString());
                sb.append(QaXmqxvjHhxVy.Bmp);
                this.f93086d[i3] = new File(DiskLruCache.this.f93054b, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f93091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f93092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Source[] f93093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f93094d;

        /* synthetic */ Snapshot(DiskLruCache diskLruCache, String str, long j3, Source[] sourceArr, long[] jArr, AnonymousClass1 anonymousClass1) {
            this(str, j3, sourceArr, jArr);
        }

        public Editor b() {
            return DiskLruCache.this.N(this.f93091a, this.f93092b);
        }

        public Source c(int i3) {
            return this.f93093c[i3];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.f93093c) {
                Util.c(source);
            }
        }

        private Snapshot(String str, long j3, Source[] sourceArr, long[] jArr) {
            this.f93091a = str;
            this.f93092b = j3;
            this.f93093c = sourceArr;
            this.f93094d = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0(Entry entry) {
        if (entry.f93088f != null) {
            entry.f93088f.f93079c = true;
        }
        for (int i3 = 0; i3 < this.f93060i; i3++) {
            this.f93053a.h(entry.f93085c[i3]);
            this.f93061j -= entry.f93084b[i3];
            entry.f93084b[i3] = 0;
        }
        this.f93064m++;
        this.f93062k.C0("REMOVE").writeByte(32).C0(entry.f93083a).writeByte(10);
        this.f93063l.remove(entry.f93083a);
        if (V()) {
            this.f93069r.execute(this.f93070s);
        }
        return true;
    }

    private synchronized void J() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void K(Editor editor, boolean z2) {
        Entry entry = editor.f93077a;
        if (entry.f93088f != editor) {
            throw new IllegalStateException();
        }
        if (z2 && !entry.f93087e) {
            for (int i3 = 0; i3 < this.f93060i; i3++) {
                if (!editor.f93078b[i3]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                }
                if (!this.f93053a.b(entry.f93086d[i3])) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i4 = 0; i4 < this.f93060i; i4++) {
            File file = entry.f93086d[i4];
            if (!z2) {
                this.f93053a.h(file);
            } else if (this.f93053a.b(file)) {
                File file2 = entry.f93085c[i4];
                this.f93053a.g(file, file2);
                long j3 = entry.f93084b[i4];
                long jD = this.f93053a.d(file2);
                entry.f93084b[i4] = jD;
                this.f93061j = (this.f93061j - j3) + jD;
            }
        }
        this.f93064m++;
        entry.f93088f = null;
        if (entry.f93087e || z2) {
            entry.f93087e = true;
            this.f93062k.C0("CLEAN").writeByte(32);
            this.f93062k.C0(entry.f93083a);
            entry.o(this.f93062k);
            this.f93062k.writeByte(10);
            if (z2) {
                long j4 = this.f93068q;
                this.f93068q = 1 + j4;
                entry.f93089g = j4;
            }
        } else {
            this.f93063l.remove(entry.f93083a);
            this.f93062k.C0("REMOVE").writeByte(32);
            this.f93062k.C0(entry.f93083a);
            this.f93062k.writeByte(10);
        }
        this.f93062k.flush();
        if (this.f93061j > this.f93059h || V()) {
            this.f93069r.execute(this.f93070s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor N(String str, long j3) {
        T();
        J();
        R0(str);
        Entry entry = (Entry) this.f93063l.get(str);
        AnonymousClass1 anonymousClass1 = null;
        if (j3 != -1 && (entry == null || entry.f93089g != j3)) {
            return null;
        }
        if (entry != null && entry.f93088f != null) {
            return null;
        }
        this.f93062k.C0("DIRTY").writeByte(32).C0(str).writeByte(10);
        this.f93062k.flush();
        if (this.f93065n) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(this, str, anonymousClass1);
            this.f93063l.put(str, entry);
        }
        Editor editor = new Editor(this, entry, anonymousClass1);
        entry.f93088f = editor;
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        while (this.f93061j > this.f93059h) {
            A0((Entry) this.f93063l.values().iterator().next());
        }
    }

    private void R0(String str) {
        if (f93051t.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        int i3 = this.f93064m;
        return i3 >= 2000 && i3 >= this.f93063l.size();
    }

    private BufferedSink e0() {
        return Okio.c(new FaultHidingSink(this.f93053a.c(this.f93055c)) { // from class: com.squareup.okhttp.internal.DiskLruCache.2
            @Override // com.squareup.okhttp.internal.FaultHidingSink
            protected void a(IOException iOException) {
                DiskLruCache.this.f93065n = true;
            }
        });
    }

    private void g0() {
        this.f93053a.h(this.f93056d);
        Iterator it = this.f93063l.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i3 = 0;
            if (entry.f93088f == null) {
                while (i3 < this.f93060i) {
                    this.f93061j += entry.f93084b[i3];
                    i3++;
                }
            } else {
                entry.f93088f = null;
                while (i3 < this.f93060i) {
                    this.f93053a.h(entry.f93085c[i3]);
                    this.f93053a.h(entry.f93086d[i3]);
                    i3++;
                }
                it.remove();
            }
        }
    }

    private void j0() {
        BufferedSource bufferedSourceD = Okio.d(this.f93053a.e(this.f93055c));
        try {
            String strQ0 = bufferedSourceD.Q0();
            String strQ02 = bufferedSourceD.Q0();
            String strQ03 = bufferedSourceD.Q0();
            String strQ04 = bufferedSourceD.Q0();
            String strQ05 = bufferedSourceD.Q0();
            if (!"libcore.io.DiskLruCache".equals(strQ0) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strQ02) || !Integer.toString(this.f93058g).equals(strQ03) || !Integer.toString(this.f93060i).equals(strQ04) || !"".equals(strQ05)) {
                throw new IOException("unexpected journal header: [" + strQ0 + ", " + strQ02 + ", " + strQ04 + ", " + strQ05 + "]");
            }
            int i3 = 0;
            while (true) {
                try {
                    q0(bufferedSourceD.Q0());
                    i3++;
                } catch (EOFException unused) {
                    this.f93064m = i3 - this.f93063l.size();
                    if (bufferedSourceD.G1()) {
                        this.f93062k = e0();
                    } else {
                        w0();
                    }
                    Util.c(bufferedSourceD);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.c(bufferedSourceD);
            throw th;
        }
    }

    private void q0(String str) throws IOException {
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
                this.f93063l.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i3, iIndexOf2);
        }
        Entry entry = (Entry) this.f93063l.get(strSubstring);
        AnonymousClass1 anonymousClass1 = null;
        if (entry == null) {
            entry = new Entry(this, strSubstring, anonymousClass1);
            this.f93063l.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.f93087e = true;
            entry.f93088f = null;
            entry.m(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            entry.f93088f = new Editor(this, entry, anonymousClass1);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w0() {
        try {
            BufferedSink bufferedSink = this.f93062k;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkC = Okio.c(this.f93053a.f(this.f93056d));
            try {
                bufferedSinkC.C0("libcore.io.DiskLruCache").writeByte(10);
                bufferedSinkC.C0(AppEventsConstants.EVENT_PARAM_VALUE_YES).writeByte(10);
                bufferedSinkC.j1(this.f93058g).writeByte(10);
                bufferedSinkC.j1(this.f93060i).writeByte(10);
                bufferedSinkC.writeByte(10);
                for (Entry entry : this.f93063l.values()) {
                    if (entry.f93088f != null) {
                        bufferedSinkC.C0("DIRTY").writeByte(32);
                        bufferedSinkC.C0(entry.f93083a);
                        bufferedSinkC.writeByte(10);
                    } else {
                        bufferedSinkC.C0("CLEAN").writeByte(32);
                        bufferedSinkC.C0(entry.f93083a);
                        entry.o(bufferedSinkC);
                        bufferedSinkC.writeByte(10);
                    }
                }
                bufferedSinkC.close();
                if (this.f93053a.b(this.f93055c)) {
                    this.f93053a.g(this.f93055c, this.f93057f);
                }
                this.f93053a.g(this.f93056d, this.f93055c);
                this.f93053a.h(this.f93057f);
                this.f93062k = e0();
                this.f93065n = false;
            } catch (Throwable th) {
                bufferedSinkC.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void L() {
        close();
        this.f93053a.a(this.f93054b);
    }

    public Editor M(String str) {
        return N(str, -1L);
    }

    public synchronized Snapshot O(String str) {
        T();
        J();
        R0(str);
        Entry entry = (Entry) this.f93063l.get(str);
        if (entry != null && entry.f93087e) {
            Snapshot snapshotN = entry.n();
            if (snapshotN == null) {
                return null;
            }
            this.f93064m++;
            this.f93062k.C0("READ").writeByte(32).C0(str).writeByte(10);
            if (V()) {
                this.f93069r.execute(this.f93070s);
            }
            return snapshotN;
        }
        return null;
    }

    public synchronized void T() {
        try {
            if (this.f93066o) {
                return;
            }
            if (this.f93053a.b(this.f93057f)) {
                if (this.f93053a.b(this.f93055c)) {
                    this.f93053a.h(this.f93057f);
                } else {
                    this.f93053a.g(this.f93057f, this.f93055c);
                }
            }
            if (this.f93053a.b(this.f93055c)) {
                try {
                    j0();
                    g0();
                    this.f93066o = true;
                    return;
                } catch (IOException e3) {
                    Platform.f().i("DiskLruCache " + this.f93054b + " is corrupt: " + e3.getMessage() + ", removing");
                    L();
                    this.f93067p = false;
                }
            }
            w0();
            this.f93066o = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f93066o && !this.f93067p) {
                for (Entry entry : (Entry[]) this.f93063l.values().toArray(new Entry[this.f93063l.size()])) {
                    if (entry.f93088f != null) {
                        entry.f93088f.a();
                    }
                }
                O0();
                this.f93062k.close();
                this.f93062k = null;
                this.f93067p = true;
                return;
            }
            this.f93067p = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isClosed() {
        return this.f93067p;
    }

    public synchronized boolean z0(String str) {
        T();
        J();
        R0(str);
        Entry entry = (Entry) this.f93063l.get(str);
        if (entry == null) {
            return false;
        }
        return A0(entry);
    }
}
