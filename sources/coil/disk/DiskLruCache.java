package coil.disk;

import coil.util.FileSystems;
import com.facebook.appevents.AppEventsConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DiskLruCache implements Closeable, Flushable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f55756t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Regex f55757u = new Regex("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f55758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f55759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f55760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f55761d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f55762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f55763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Path f55764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedHashMap f55765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CoroutineScope f55766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f55767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f55768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private BufferedSink f55769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f55770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f55771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f55772p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f55773q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f55774r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final DiskLruCache$fileSystem$1 f55775s;

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
        private final Entry f55776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f55777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean[] f55778c;

        public Editor(Entry entry) {
            this.f55776a = entry;
            this.f55778c = new boolean[DiskLruCache.this.f55761d];
        }

        private final void d(boolean z2) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    if (this.f55777b) {
                        throw new IllegalStateException("editor is closed");
                    }
                    if (Intrinsics.areEqual(this.f55776a.b(), this)) {
                        diskLruCache.K(this, z2);
                    }
                    this.f55777b = true;
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void a() {
            d(false);
        }

        public final void b() {
            d(true);
        }

        public final Snapshot c() {
            Snapshot snapshotN;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                b();
                snapshotN = diskLruCache.N(this.f55776a.d());
            }
            return snapshotN;
        }

        public final void e() {
            if (Intrinsics.areEqual(this.f55776a.b(), this)) {
                this.f55776a.m(true);
            }
        }

        public final Path f(int i3) {
            Path path;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (this.f55777b) {
                    throw new IllegalStateException("editor is closed");
                }
                this.f55778c[i3] = true;
                Object obj = this.f55776a.c().get(i3);
                FileSystems.a(diskLruCache.f55775s, (Path) obj);
                path = (Path) obj;
            }
            return path;
        }

        public final Entry g() {
            return this.f55776a;
        }

        public final boolean[] h() {
            return this.f55778c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f55780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f55781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList f55782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ArrayList f55783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f55784e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f55785f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Editor f55786g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f55787h;

        public Entry(String str) {
            this.f55780a = str;
            this.f55781b = new long[DiskLruCache.this.f55761d];
            this.f55782c = new ArrayList(DiskLruCache.this.f55761d);
            this.f55783d = new ArrayList(DiskLruCache.this.f55761d);
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i3 = DiskLruCache.this.f55761d;
            for (int i4 = 0; i4 < i3; i4++) {
                sb.append(i4);
                this.f55782c.add(DiskLruCache.this.f55758a.j(sb.toString()));
                sb.append(".tmp");
                this.f55783d.add(DiskLruCache.this.f55758a.j(sb.toString()));
                sb.setLength(length);
            }
        }

        public final ArrayList a() {
            return this.f55782c;
        }

        public final Editor b() {
            return this.f55786g;
        }

        public final ArrayList c() {
            return this.f55783d;
        }

        public final String d() {
            return this.f55780a;
        }

        public final long[] e() {
            return this.f55781b;
        }

        public final int f() {
            return this.f55787h;
        }

        public final boolean g() {
            return this.f55784e;
        }

        public final boolean h() {
            return this.f55785f;
        }

        public final void i(Editor editor) {
            this.f55786g = editor;
        }

        public final void j(List list) throws IOException {
            if (list.size() != DiskLruCache.this.f55761d) {
                throw new IOException("unexpected journal line: " + list);
            }
            try {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f55781b[i3] = Long.parseLong((String) list.get(i3));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void k(int i3) {
            this.f55787h = i3;
        }

        public final void l(boolean z2) {
            this.f55784e = z2;
        }

        public final void m(boolean z2) {
            this.f55785f = z2;
        }

        public final Snapshot n() {
            if (!this.f55784e || this.f55786g != null || this.f55785f) {
                return null;
            }
            ArrayList arrayList = this.f55782c;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!diskLruCache.f55775s.j((Path) arrayList.get(i3))) {
                    try {
                        diskLruCache.w0(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.f55787h++;
            return DiskLruCache.this.new Snapshot(this);
        }

        public final void o(BufferedSink bufferedSink) {
            for (long j3 : this.f55781b) {
                bufferedSink.writeByte(32).j1(j3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Snapshot implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Entry f55789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f55790b;

        public Snapshot(Entry entry) {
            this.f55789a = entry;
        }

        public final Editor a() {
            Editor editorM;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                close();
                editorM = diskLruCache.M(this.f55789a.d());
            }
            return editorM;
        }

        public final Path b(int i3) {
            if (this.f55790b) {
                throw new IllegalStateException("snapshot is closed");
            }
            return (Path) this.f55789a.a().get(i3);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f55790b) {
                return;
            }
            this.f55790b = true;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    this.f55789a.k(r1.f() - 1);
                    if (this.f55789a.f() == 0 && this.f55789a.h()) {
                        diskLruCache.w0(this.f55789a);
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [coil.disk.DiskLruCache$fileSystem$1] */
    public DiskLruCache(final FileSystem fileSystem, Path path, CoroutineDispatcher coroutineDispatcher, long j3, int i3, int i4) {
        this.f55758a = path;
        this.f55759b = j3;
        this.f55760c = i3;
        this.f55761d = i4;
        if (j3 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.f55762f = path.j("journal");
        this.f55763g = path.j("journal.tmp");
        this.f55764h = path.j("journal.bkp");
        this.f55765i = new LinkedHashMap(0, 0.75f, true);
        this.f55766j = CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(coroutineDispatcher.g0(1)));
        this.f55775s = new ForwardingFileSystem(fileSystem) { // from class: coil.disk.DiskLruCache$fileSystem$1
            @Override // okio.ForwardingFileSystem, okio.FileSystem
            public Sink s(Path path2, boolean z2) {
                Path pathH = path2.h();
                if (pathH != null) {
                    d(pathH);
                }
                return super.s(path2, z2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        while (this.f55767k > this.f55759b) {
            if (!z0()) {
                return;
            }
        }
        this.f55773q = false;
    }

    private final void J() {
        if (this.f55772p) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void K(Editor editor, boolean z2) {
        Entry entryG = editor.g();
        if (!Intrinsics.areEqual(entryG.b(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        int i3 = 0;
        if (!z2 || entryG.h()) {
            int i4 = this.f55761d;
            while (i3 < i4) {
                h((Path) entryG.c().get(i3));
                i3++;
            }
        } else {
            int i5 = this.f55761d;
            for (int i6 = 0; i6 < i5; i6++) {
                if (editor.h()[i6] && !j((Path) entryG.c().get(i6))) {
                    editor.a();
                    return;
                }
            }
            int i7 = this.f55761d;
            while (i3 < i7) {
                Path path = (Path) entryG.c().get(i3);
                Path path2 = (Path) entryG.a().get(i3);
                if (j(path)) {
                    c(path, path2);
                } else {
                    FileSystems.a(this.f55775s, (Path) entryG.a().get(i3));
                }
                long j3 = entryG.e()[i3];
                Long lD = m(path2).d();
                long jLongValue = lD != null ? lD.longValue() : 0L;
                entryG.e()[i3] = jLongValue;
                this.f55767k = (this.f55767k - j3) + jLongValue;
                i3++;
            }
        }
        entryG.i(null);
        if (entryG.h()) {
            w0(entryG);
            return;
        }
        this.f55768l++;
        BufferedSink bufferedSink = this.f55769m;
        Intrinsics.checkNotNull(bufferedSink);
        if (z2 || entryG.g()) {
            entryG.l(true);
            bufferedSink.C0("CLEAN");
            bufferedSink.writeByte(32);
            bufferedSink.C0(entryG.d());
            entryG.o(bufferedSink);
            bufferedSink.writeByte(10);
        } else {
            this.f55765i.remove(entryG.d());
            bufferedSink.C0("REMOVE");
            bufferedSink.writeByte(32);
            bufferedSink.C0(entryG.d());
            bufferedSink.writeByte(10);
        }
        bufferedSink.flush();
        if (this.f55767k > this.f55759b || T()) {
            V();
        }
    }

    private final void L() throws IOException {
        close();
        FileSystems.b(this.f55775s, this.f55758a);
    }

    private final void O0(String str) {
        if (f55757u.k(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void R0() {
        Unit unit;
        try {
            BufferedSink bufferedSink = this.f55769m;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkC = Okio.c(s(this.f55763g, false));
            Throwable th = null;
            try {
                bufferedSinkC.C0("libcore.io.DiskLruCache").writeByte(10);
                bufferedSinkC.C0(AppEventsConstants.EVENT_PARAM_VALUE_YES).writeByte(10);
                bufferedSinkC.j1(this.f55760c).writeByte(10);
                bufferedSinkC.j1(this.f55761d).writeByte(10);
                bufferedSinkC.writeByte(10);
                for (Entry entry : this.f55765i.values()) {
                    if (entry.b() != null) {
                        bufferedSinkC.C0("DIRTY");
                        bufferedSinkC.writeByte(32);
                        bufferedSinkC.C0(entry.d());
                        bufferedSinkC.writeByte(10);
                    } else {
                        bufferedSinkC.C0("CLEAN");
                        bufferedSinkC.writeByte(32);
                        bufferedSinkC.C0(entry.d());
                        entry.o(bufferedSinkC);
                        bufferedSinkC.writeByte(10);
                    }
                }
                unit = Unit.f139807a;
                if (bufferedSinkC != null) {
                    try {
                        bufferedSinkC.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (bufferedSinkC != null) {
                    try {
                        bufferedSinkC.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.a(th3, th4);
                    }
                }
                unit = null;
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(unit);
            if (j(this.f55762f)) {
                c(this.f55762f, this.f55764h);
                c(this.f55763g, this.f55762f);
                h(this.f55764h);
            } else {
                c(this.f55763g, this.f55762f);
            }
            this.f55769m = e0();
            this.f55768l = 0;
            this.f55770n = false;
            this.f55774r = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T() {
        return this.f55768l >= 2000;
    }

    private final void V() {
        BuildersKt__Builders_commonKt.d(this.f55766j, null, null, new DiskLruCache$launchCleanup$1(this, null), 3, null);
    }

    private final BufferedSink e0() {
        return Okio.c(new FaultHidingSink(a(this.f55762f), new Function1<IOException, Unit>() { // from class: coil.disk.DiskLruCache$newJournalWriter$faultHidingSink$1
            {
                super(1);
            }

            public final void c(IOException iOException) {
                this.f55794a.f55770n = true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((IOException) obj);
                return Unit.f139807a;
            }
        }));
    }

    private final void g0() {
        Iterator it = this.f55765i.values().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i3 = 0;
            if (entry.b() == null) {
                int i4 = this.f55761d;
                while (i3 < i4) {
                    j3 += entry.e()[i3];
                    i3++;
                }
            } else {
                entry.i(null);
                int i5 = this.f55761d;
                while (i3 < i5) {
                    h((Path) entry.a().get(i3));
                    h((Path) entry.c().get(i3));
                    i3++;
                }
                it.remove();
            }
        }
        this.f55767k = j3;
    }

    private final void j0() throws Throwable {
        Unit unit;
        BufferedSource bufferedSourceD = Okio.d(t(this.f55762f));
        Throwable th = null;
        try {
            String strQ0 = bufferedSourceD.Q0();
            String strQ02 = bufferedSourceD.Q0();
            String strQ03 = bufferedSourceD.Q0();
            String strQ04 = bufferedSourceD.Q0();
            String strQ05 = bufferedSourceD.Q0();
            if (!Intrinsics.areEqual("libcore.io.DiskLruCache", strQ0) || !Intrinsics.areEqual(AppEventsConstants.EVENT_PARAM_VALUE_YES, strQ02) || !Intrinsics.areEqual(String.valueOf(this.f55760c), strQ03) || !Intrinsics.areEqual(String.valueOf(this.f55761d), strQ04) || strQ05.length() > 0) {
                throw new IOException("unexpected journal header: [" + strQ0 + ", " + strQ02 + ", " + strQ03 + ", " + strQ04 + ", " + strQ05 + ']');
            }
            int i3 = 0;
            while (true) {
                try {
                    q0(bufferedSourceD.Q0());
                    i3++;
                } catch (EOFException unused) {
                    this.f55768l = i3 - this.f55765i.size();
                    if (bufferedSourceD.G1()) {
                        this.f55769m = e0();
                    } else {
                        R0();
                    }
                    unit = Unit.f139807a;
                    if (bufferedSourceD != null) {
                        try {
                            bufferedSourceD.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            if (bufferedSourceD != null) {
                try {
                    bufferedSourceD.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
            }
            th = th3;
            unit = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(unit);
    }

    private final void q0(String str) throws IOException {
        String strSubstring;
        int iM0 = StringsKt.m0(str, ' ', 0, false, 6, null);
        if (iM0 == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i3 = iM0 + 1;
        int iM02 = StringsKt.m0(str, ' ', i3, false, 4, null);
        if (iM02 == -1) {
            strSubstring = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (iM0 == 6 && StringsKt.U(str, "REMOVE", false, 2, null)) {
                this.f55765i.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i3, iM02);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        LinkedHashMap linkedHashMap = this.f55765i;
        Object entry = linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        Entry entry2 = (Entry) entry;
        if (iM02 != -1 && iM0 == 5 && StringsKt.U(str, "CLEAN", false, 2, null)) {
            String strSubstring2 = str.substring(iM02 + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            List listU0 = StringsKt.U0(strSubstring2, new char[]{' '}, false, 0, 6, null);
            entry2.l(true);
            entry2.i(null);
            entry2.j(listU0);
            return;
        }
        if (iM02 == -1 && iM0 == 5 && StringsKt.U(str, "DIRTY", false, 2, null)) {
            entry2.i(new Editor(entry2));
            return;
        }
        if (iM02 == -1 && iM0 == 4 && StringsKt.U(str, "READ", false, 2, null)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w0(Entry entry) {
        BufferedSink bufferedSink;
        if (entry.f() > 0 && (bufferedSink = this.f55769m) != null) {
            bufferedSink.C0("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.C0(entry.d());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.f() > 0 || entry.b() != null) {
            entry.m(true);
            return true;
        }
        int i3 = this.f55761d;
        for (int i4 = 0; i4 < i3; i4++) {
            h((Path) entry.a().get(i4));
            this.f55767k -= entry.e()[i4];
            entry.e()[i4] = 0;
        }
        this.f55768l++;
        BufferedSink bufferedSink2 = this.f55769m;
        if (bufferedSink2 != null) {
            bufferedSink2.C0("REMOVE");
            bufferedSink2.writeByte(32);
            bufferedSink2.C0(entry.d());
            bufferedSink2.writeByte(10);
        }
        this.f55765i.remove(entry.d());
        if (T()) {
            V();
        }
        return true;
    }

    private final boolean z0() {
        for (Entry entry : this.f55765i.values()) {
            if (!entry.h()) {
                w0(entry);
                return true;
            }
        }
        return false;
    }

    public final synchronized Editor M(String str) {
        J();
        O0(str);
        O();
        Entry entry = (Entry) this.f55765i.get(str);
        if ((entry != null ? entry.b() : null) != null) {
            return null;
        }
        if (entry != null && entry.f() != 0) {
            return null;
        }
        if (!this.f55773q && !this.f55774r) {
            BufferedSink bufferedSink = this.f55769m;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.C0("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.C0(str);
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.f55770n) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.f55765i.put(str, entry);
            }
            Editor editor = new Editor(entry);
            entry.i(editor);
            return editor;
        }
        V();
        return null;
    }

    public final synchronized Snapshot N(String str) {
        Snapshot snapshotN;
        J();
        O0(str);
        O();
        Entry entry = (Entry) this.f55765i.get(str);
        if (entry != null && (snapshotN = entry.n()) != null) {
            this.f55768l++;
            BufferedSink bufferedSink = this.f55769m;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.C0("READ");
            bufferedSink.writeByte(32);
            bufferedSink.C0(str);
            bufferedSink.writeByte(10);
            if (T()) {
                V();
            }
            return snapshotN;
        }
        return null;
    }

    public final synchronized void O() {
        try {
            if (this.f55771o) {
                return;
            }
            h(this.f55763g);
            if (j(this.f55764h)) {
                if (j(this.f55762f)) {
                    h(this.f55764h);
                } else {
                    c(this.f55764h, this.f55762f);
                }
            }
            if (j(this.f55762f)) {
                try {
                    j0();
                    g0();
                    this.f55771o = true;
                    return;
                } catch (IOException unused) {
                    try {
                        L();
                        this.f55772p = false;
                        R0();
                        this.f55771o = true;
                    } catch (Throwable th) {
                        this.f55772p = false;
                        throw th;
                    }
                }
            }
            R0();
            this.f55771o = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f55771o && !this.f55772p) {
                for (Entry entry : (Entry[]) this.f55765i.values().toArray(new Entry[0])) {
                    Editor editorB = entry.b();
                    if (editorB != null) {
                        editorB.e();
                    }
                }
                A0();
                CoroutineScopeKt.e(this.f55766j, null, 1, null);
                BufferedSink bufferedSink = this.f55769m;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.close();
                this.f55769m = null;
                this.f55772p = true;
                return;
            }
            this.f55772p = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.f55771o) {
            J();
            A0();
            BufferedSink bufferedSink = this.f55769m;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }
}
