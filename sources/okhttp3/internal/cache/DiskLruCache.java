package okhttp3.internal.cache;

import com.facebook.appevents.AppEventsConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class DiskLruCache implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileSystem f144310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f144311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f144312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f144313d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f144314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final File f144315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f144316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final File f144317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f144318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BufferedSink f144319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LinkedHashMap f144320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f144321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f144322n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f144323o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f144324p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f144325q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f144326r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f144327s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f144328t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final TaskQueue f144329u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final DiskLruCache$cleanupTask$1 f144330v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Companion f144306w = new Companion(null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f144307x = "journal";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f144308y = "journal.tmp";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f144309z = "journal.bkp";
    public static final String A = "libcore.io.DiskLruCache";
    public static final String B = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    public static final long C = -1;
    public static final Regex D = new Regex("[a-z0-9_-]{1,120}");
    public static final String E = "CLEAN";
    public static final String F = "DIRTY";
    public static final String G = "REMOVE";
    public static final String H = "READ";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Entry f144331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f144332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f144333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DiskLruCache f144334d;

        public Editor(DiskLruCache this$0, Entry entry) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.f144334d = this$0;
            this.f144331a = entry;
            this.f144332b = entry.g() ? null : new boolean[this$0.N()];
        }

        public final void a() {
            DiskLruCache diskLruCache = this.f144334d;
            synchronized (diskLruCache) {
                try {
                    if (this.f144333c) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (Intrinsics.areEqual(d().b(), this)) {
                        diskLruCache.n(this, false);
                    }
                    this.f144333c = true;
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void b() {
            DiskLruCache diskLruCache = this.f144334d;
            synchronized (diskLruCache) {
                try {
                    if (this.f144333c) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (Intrinsics.areEqual(d().b(), this)) {
                        diskLruCache.n(this, true);
                    }
                    this.f144333c = true;
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void c() {
            if (Intrinsics.areEqual(this.f144331a.b(), this)) {
                if (this.f144334d.f144323o) {
                    this.f144334d.n(this, false);
                } else {
                    this.f144331a.q(true);
                }
            }
        }

        public final Entry d() {
            return this.f144331a;
        }

        public final boolean[] e() {
            return this.f144332b;
        }

        public final Sink f(int i3) {
            final DiskLruCache diskLruCache = this.f144334d;
            synchronized (diskLruCache) {
                if (this.f144333c) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!Intrinsics.areEqual(d().b(), this)) {
                    return Okio.b();
                }
                if (!d().g()) {
                    boolean[] zArrE = e();
                    Intrinsics.checkNotNull(zArrE);
                    zArrE[i3] = true;
                }
                try {
                    return new FaultHidingSink(diskLruCache.L().f((File) d().c().get(i3)), new Function1<IOException, Unit>() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void c(IOException it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            DiskLruCache diskLruCache2 = diskLruCache;
                            DiskLruCache.Editor editor = this;
                            synchronized (diskLruCache2) {
                                editor.c();
                                Unit unit = Unit.f139807a;
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c((IOException) obj);
                            return Unit.f139807a;
                        }
                    });
                } catch (FileNotFoundException unused) {
                    return Okio.b();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f144337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f144338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f144339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f144340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f144341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f144342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Editor f144343g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f144344h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f144345i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ DiskLruCache f144346j;

        public Entry(DiskLruCache this$0, String key) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "key");
            this.f144346j = this$0;
            this.f144337a = key;
            this.f144338b = new long[this$0.N()];
            this.f144339c = new ArrayList();
            this.f144340d = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int iN = this$0.N();
            for (int i3 = 0; i3 < iN; i3++) {
                sb.append(i3);
                this.f144339c.add(new File(this.f144346j.K(), sb.toString()));
                sb.append(".tmp");
                this.f144340d.add(new File(this.f144346j.K(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void j(List list) throws IOException {
            throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", list));
        }

        private final Source k(int i3) {
            final Source sourceE = this.f144346j.L().e((File) this.f144339c.get(i3));
            if (this.f144346j.f144323o) {
                return sourceE;
            }
            this.f144344h++;
            final DiskLruCache diskLruCache = this.f144346j;
            return new ForwardingSource(diskLruCache, this) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private boolean f144347b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ DiskLruCache f144349d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ DiskLruCache.Entry f144350f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this.f144348c);
                    this.f144349d = diskLruCache;
                    this.f144350f = this;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (this.f144347b) {
                        return;
                    }
                    this.f144347b = true;
                    DiskLruCache diskLruCache2 = this.f144349d;
                    DiskLruCache.Entry entry = this.f144350f;
                    synchronized (diskLruCache2) {
                        try {
                            entry.n(entry.f() - 1);
                            if (entry.f() == 0 && entry.i()) {
                                diskLruCache2.z0(entry);
                            }
                            Unit unit = Unit.f139807a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
        }

        public final List a() {
            return this.f144339c;
        }

        public final Editor b() {
            return this.f144343g;
        }

        public final List c() {
            return this.f144340d;
        }

        public final String d() {
            return this.f144337a;
        }

        public final long[] e() {
            return this.f144338b;
        }

        public final int f() {
            return this.f144344h;
        }

        public final boolean g() {
            return this.f144341e;
        }

        public final long h() {
            return this.f144345i;
        }

        public final boolean i() {
            return this.f144342f;
        }

        public final void l(Editor editor) {
            this.f144343g = editor;
        }

        public final void m(List strings) throws IOException {
            Intrinsics.checkNotNullParameter(strings, "strings");
            if (strings.size() != this.f144346j.N()) {
                j(strings);
                throw new KotlinNothingValueException();
            }
            try {
                int size = strings.size();
                int i3 = 0;
                while (i3 < size) {
                    int i4 = i3 + 1;
                    this.f144338b[i3] = Long.parseLong((String) strings.get(i3));
                    i3 = i4;
                }
            } catch (NumberFormatException unused) {
                j(strings);
                throw new KotlinNothingValueException();
            }
        }

        public final void n(int i3) {
            this.f144344h = i3;
        }

        public final void o(boolean z2) {
            this.f144341e = z2;
        }

        public final void p(long j3) {
            this.f144345i = j3;
        }

        public final void q(boolean z2) {
            this.f144342f = z2;
        }

        public final Snapshot r() {
            DiskLruCache diskLruCache = this.f144346j;
            if (Util.f144281h && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            }
            if (!this.f144341e) {
                return null;
            }
            if (!this.f144346j.f144323o && (this.f144343g != null || this.f144342f)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.f144338b.clone();
            int i3 = 0;
            try {
                int iN = this.f144346j.N();
                for (int i4 = 0; i4 < iN; i4++) {
                    arrayList.add(k(i4));
                }
                return new Snapshot(this.f144346j, this.f144337a, this.f144345i, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    Util.m((Source) obj);
                }
                try {
                    this.f144346j.z0(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void s(BufferedSink writer) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            long[] jArr = this.f144338b;
            int length = jArr.length;
            int i3 = 0;
            while (i3 < length) {
                long j3 = jArr[i3];
                i3++;
                writer.writeByte(32).j1(j3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f144351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f144352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f144353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f144354d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DiskLruCache f144355f;

        public Snapshot(DiskLruCache this$0, String key, long j3, List sources, long[] lengths) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.f144355f = this$0;
            this.f144351a = key;
            this.f144352b = j3;
            this.f144353c = sources;
            this.f144354d = lengths;
        }

        public final Editor a() {
            return this.f144355f.z(this.f144351a, this.f144352b);
        }

        public final Source b(int i3) {
            return (Source) this.f144353c.get(i3);
        }

        public final String c() {
            return this.f144351a;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator it = this.f144353c.iterator();
            while (it.hasNext()) {
                Util.m((Source) it.next());
            }
        }
    }

    private final boolean A0() {
        for (Entry toEvict : this.f144320l.values()) {
            if (!toEvict.i()) {
                Intrinsics.checkNotNullExpressionValue(toEvict, "toEvict");
                z0(toEvict);
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Editor C(DiskLruCache diskLruCache, String str, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = C;
        }
        return diskLruCache.z(str, j3);
    }

    private final void R0(String str) {
        if (D.k(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T() {
        int i3 = this.f144321m;
        return i3 >= 2000 && i3 >= this.f144320l.size();
    }

    private final BufferedSink V() {
        return Okio.c(new FaultHidingSink(this.f144310a.c(this.f144315g), new Function1<IOException, Unit>() { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            {
                super(1);
            }

            public final void c(IOException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DiskLruCache diskLruCache = this.f144357a;
                if (!Util.f144281h || Thread.holdsLock(diskLruCache)) {
                    this.f144357a.f144322n = true;
                    return;
                }
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + diskLruCache);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((IOException) obj);
                return Unit.f139807a;
            }
        }));
    }

    private final void e0() {
        this.f144310a.h(this.f144316h);
        Iterator it = this.f144320l.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            Entry entry = (Entry) next;
            int i3 = 0;
            if (entry.b() == null) {
                int i4 = this.f144313d;
                while (i3 < i4) {
                    this.f144318j += entry.e()[i3];
                    i3++;
                }
            } else {
                entry.l(null);
                int i5 = this.f144313d;
                while (i3 < i5) {
                    this.f144310a.h((File) entry.a().get(i3));
                    this.f144310a.h((File) entry.c().get(i3));
                    i3++;
                }
                it.remove();
            }
        }
    }

    private final void g0() {
        BufferedSource bufferedSourceD = Okio.d(this.f144310a.e(this.f144315g));
        try {
            String strQ0 = bufferedSourceD.Q0();
            String strQ02 = bufferedSourceD.Q0();
            String strQ03 = bufferedSourceD.Q0();
            String strQ04 = bufferedSourceD.Q0();
            String strQ05 = bufferedSourceD.Q0();
            if (!Intrinsics.areEqual(A, strQ0) || !Intrinsics.areEqual(B, strQ02) || !Intrinsics.areEqual(String.valueOf(this.f144312c), strQ03) || !Intrinsics.areEqual(String.valueOf(N()), strQ04) || strQ05.length() > 0) {
                throw new IOException("unexpected journal header: [" + strQ0 + ", " + strQ02 + ", " + strQ04 + ", " + strQ05 + ']');
            }
            int i3 = 0;
            while (true) {
                try {
                    j0(bufferedSourceD.Q0());
                    i3++;
                } catch (EOFException unused) {
                    this.f144321m = i3 - M().size();
                    if (bufferedSourceD.G1()) {
                        this.f144319k = V();
                    } else {
                        q0();
                    }
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(bufferedSourceD, null);
                    return;
                }
            }
        } finally {
        }
    }

    private final void j0(String str) throws IOException {
        String strSubstring;
        int iM0 = StringsKt.m0(str, ' ', 0, false, 6, null);
        if (iM0 == -1) {
            throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", str));
        }
        int i3 = iM0 + 1;
        int iM02 = StringsKt.m0(str, ' ', i3, false, 4, null);
        if (iM02 == -1) {
            strSubstring = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            String str2 = G;
            if (iM0 == str2.length() && StringsKt.U(str, str2, false, 2, null)) {
                this.f144320l.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i3, iM02);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Entry entry = (Entry) this.f144320l.get(strSubstring);
        if (entry == null) {
            entry = new Entry(this, strSubstring);
            this.f144320l.put(strSubstring, entry);
        }
        if (iM02 != -1) {
            String str3 = E;
            if (iM0 == str3.length() && StringsKt.U(str, str3, false, 2, null)) {
                String strSubstring2 = str.substring(iM02 + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                List listU0 = StringsKt.U0(strSubstring2, new char[]{' '}, false, 0, 6, null);
                entry.o(true);
                entry.l(null);
                entry.m(listU0);
                return;
            }
        }
        if (iM02 == -1) {
            String str4 = F;
            if (iM0 == str4.length() && StringsKt.U(str, str4, false, 2, null)) {
                entry.l(new Editor(this, entry));
                return;
            }
        }
        if (iM02 == -1) {
            String str5 = H;
            if (iM0 == str5.length() && StringsKt.U(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", str));
    }

    private final synchronized void m() {
        if (this.f144325q) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized Snapshot F(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        O();
        m();
        R0(key);
        Entry entry = (Entry) this.f144320l.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshotR = entry.r();
        if (snapshotR == null) {
            return null;
        }
        this.f144321m++;
        BufferedSink bufferedSink = this.f144319k;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.C0(H).writeByte(32).C0(key).writeByte(10);
        if (T()) {
            TaskQueue.j(this.f144329u, this.f144330v, 0L, 2, null);
        }
        return snapshotR;
    }

    public final boolean J() {
        return this.f144325q;
    }

    public final File K() {
        return this.f144311b;
    }

    public final FileSystem L() {
        return this.f144310a;
    }

    public final LinkedHashMap M() {
        return this.f144320l;
    }

    public final int N() {
        return this.f144313d;
    }

    public final synchronized void O() {
        try {
            if (Util.f144281h && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
            }
            if (this.f144324p) {
                return;
            }
            if (this.f144310a.b(this.f144317i)) {
                if (this.f144310a.b(this.f144315g)) {
                    this.f144310a.h(this.f144317i);
                } else {
                    this.f144310a.g(this.f144317i, this.f144315g);
                }
            }
            this.f144323o = Util.F(this.f144310a, this.f144317i);
            if (this.f144310a.b(this.f144315g)) {
                try {
                    g0();
                    e0();
                    this.f144324p = true;
                    return;
                } catch (IOException e3) {
                    Platform.f144818a.g().k("DiskLruCache " + this.f144311b + " is corrupt: " + ((Object) e3.getMessage()) + ", removing", 5, e3);
                    try {
                        r();
                        this.f144325q = false;
                        q0();
                        this.f144324p = true;
                    } catch (Throwable th) {
                        this.f144325q = false;
                        throw th;
                    }
                }
            }
            q0();
            this.f144324p = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void O0() {
        while (this.f144318j > this.f144314f) {
            if (!A0()) {
                return;
            }
        }
        this.f144326r = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Editor editorB;
        try {
            if (this.f144324p && !this.f144325q) {
                Collection collectionValues = this.f144320l.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "lruEntries.values");
                int i3 = 0;
                Object[] array = collectionValues.toArray(new Entry[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                Entry[] entryArr = (Entry[]) array;
                int length = entryArr.length;
                while (i3 < length) {
                    Entry entry = entryArr[i3];
                    i3++;
                    if (entry.b() != null && (editorB = entry.b()) != null) {
                        editorB.c();
                    }
                }
                O0();
                BufferedSink bufferedSink = this.f144319k;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.close();
                this.f144319k = null;
                this.f144325q = true;
                return;
            }
            this.f144325q = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.f144324p) {
            m();
            O0();
            BufferedSink bufferedSink = this.f144319k;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final synchronized void n(Editor editor, boolean z2) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entryD = editor.d();
        if (!Intrinsics.areEqual(entryD.b(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        int i3 = 0;
        if (z2 && !entryD.g()) {
            int i4 = this.f144313d;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 + 1;
                boolean[] zArrE = editor.e();
                Intrinsics.checkNotNull(zArrE);
                if (!zArrE[i5]) {
                    editor.a();
                    throw new IllegalStateException(Intrinsics.stringPlus("Newly created entry didn't create value for index ", Integer.valueOf(i5)));
                }
                if (!this.f144310a.b((File) entryD.c().get(i5))) {
                    editor.a();
                    return;
                }
                i5 = i6;
            }
        }
        int i7 = this.f144313d;
        while (i3 < i7) {
            int i8 = i3 + 1;
            File file = (File) entryD.c().get(i3);
            if (!z2 || entryD.i()) {
                this.f144310a.h(file);
            } else if (this.f144310a.b(file)) {
                File file2 = (File) entryD.a().get(i3);
                this.f144310a.g(file, file2);
                long j3 = entryD.e()[i3];
                long jD = this.f144310a.d(file2);
                entryD.e()[i3] = jD;
                this.f144318j = (this.f144318j - j3) + jD;
            }
            i3 = i8;
        }
        entryD.l(null);
        if (entryD.i()) {
            z0(entryD);
            return;
        }
        this.f144321m++;
        BufferedSink bufferedSink = this.f144319k;
        Intrinsics.checkNotNull(bufferedSink);
        if (entryD.g() || z2) {
            entryD.o(true);
            bufferedSink.C0(E).writeByte(32);
            bufferedSink.C0(entryD.d());
            entryD.s(bufferedSink);
            bufferedSink.writeByte(10);
            if (z2) {
                long j4 = this.f144328t;
                this.f144328t = 1 + j4;
                entryD.p(j4);
            }
        } else {
            M().remove(entryD.d());
            bufferedSink.C0(G).writeByte(32);
            bufferedSink.C0(entryD.d());
            bufferedSink.writeByte(10);
        }
        bufferedSink.flush();
        if (this.f144318j > this.f144314f || T()) {
            TaskQueue.j(this.f144329u, this.f144330v, 0L, 2, null);
        }
    }

    public final synchronized void q0() {
        try {
            BufferedSink bufferedSink = this.f144319k;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkC = Okio.c(this.f144310a.f(this.f144316h));
            try {
                bufferedSinkC.C0(A).writeByte(10);
                bufferedSinkC.C0(B).writeByte(10);
                bufferedSinkC.j1(this.f144312c).writeByte(10);
                bufferedSinkC.j1(N()).writeByte(10);
                bufferedSinkC.writeByte(10);
                for (Entry entry : M().values()) {
                    if (entry.b() != null) {
                        bufferedSinkC.C0(F).writeByte(32);
                        bufferedSinkC.C0(entry.d());
                        bufferedSinkC.writeByte(10);
                    } else {
                        bufferedSinkC.C0(E).writeByte(32);
                        bufferedSinkC.C0(entry.d());
                        entry.s(bufferedSinkC);
                        bufferedSinkC.writeByte(10);
                    }
                }
                Unit unit = Unit.f139807a;
                CloseableKt.a(bufferedSinkC, null);
                if (this.f144310a.b(this.f144315g)) {
                    this.f144310a.g(this.f144315g, this.f144317i);
                }
                this.f144310a.g(this.f144316h, this.f144315g);
                this.f144310a.h(this.f144317i);
                this.f144319k = V();
                this.f144322n = false;
                this.f144327s = false;
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void r() {
        close();
        this.f144310a.a(this.f144311b);
    }

    public final synchronized boolean w0(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        O();
        m();
        R0(key);
        Entry entry = (Entry) this.f144320l.get(key);
        if (entry == null) {
            return false;
        }
        boolean zZ0 = z0(entry);
        if (zZ0 && this.f144318j <= this.f144314f) {
            this.f144326r = false;
        }
        return zZ0;
    }

    public final synchronized Editor z(String key, long j3) {
        Intrinsics.checkNotNullParameter(key, "key");
        O();
        m();
        R0(key);
        Entry entry = (Entry) this.f144320l.get(key);
        if (j3 != C && (entry == null || entry.h() != j3)) {
            return null;
        }
        if ((entry == null ? null : entry.b()) != null) {
            return null;
        }
        if (entry != null && entry.f() != 0) {
            return null;
        }
        if (!this.f144326r && !this.f144327s) {
            BufferedSink bufferedSink = this.f144319k;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.C0(F).writeByte(32).C0(key).writeByte(10);
            bufferedSink.flush();
            if (this.f144322n) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.f144320l.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.l(editor);
            return editor;
        }
        TaskQueue.j(this.f144329u, this.f144330v, 0L, 2, null);
        return null;
    }

    public final boolean z0(Entry entry) {
        BufferedSink bufferedSink;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.f144323o) {
            if (entry.f() > 0 && (bufferedSink = this.f144319k) != null) {
                bufferedSink.C0(F);
                bufferedSink.writeByte(32);
                bufferedSink.C0(entry.d());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.f() > 0 || entry.b() != null) {
                entry.q(true);
                return true;
            }
        }
        Editor editorB = entry.b();
        if (editorB != null) {
            editorB.c();
        }
        int i3 = this.f144313d;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f144310a.h((File) entry.a().get(i4));
            this.f144318j -= entry.e()[i4];
            entry.e()[i4] = 0;
        }
        this.f144321m++;
        BufferedSink bufferedSink2 = this.f144319k;
        if (bufferedSink2 != null) {
            bufferedSink2.C0(G);
            bufferedSink2.writeByte(32);
            bufferedSink2.C0(entry.d());
            bufferedSink2.writeByte(10);
        }
        this.f144320l.remove(entry.d());
        if (T()) {
            TaskQueue.j(this.f144329u, this.f144330v, 0L, 2, null);
        }
        return true;
    }
}
