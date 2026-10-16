package androidx.media3.datasource.cache;

import android.os.ConditionVariable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.datasource.cache.Cache;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SimpleCache implements Cache {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final HashSet f42104l = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f42105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CacheEvictor f42106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CachedContentIndex f42107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CacheFileMetadataIndex f42108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f42109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Random f42110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f42111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f42113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f42114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Cache.CacheException f42115k;

    /* JADX INFO: renamed from: androidx.media3.datasource.cache.SimpleCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ConditionVariable f42116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SimpleCache f42117b;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (this.f42117b) {
                this.f42116a.open();
                this.f42117b.u();
                this.f42117b.f42106b.e();
            }
        }
    }

    private static long A(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void B(CacheSpan cacheSpan) {
        CachedContent cachedContentF = this.f42107c.f(cacheSpan.f42054a);
        if (cachedContentF == null || !cachedContentF.k(cacheSpan)) {
            return;
        }
        this.f42113i -= cacheSpan.f42056c;
        if (this.f42108d != null) {
            String name = ((File) Assertions.e(cacheSpan.f42058f)).getName();
            try {
                this.f42108d.f(name);
            } catch (IOException unused) {
                Log.i("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.f42107c.n(cachedContentF.f42071b);
        y(cacheSpan);
    }

    private void C() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f42107c.g().iterator();
        while (it.hasNext()) {
            for (CacheSpan cacheSpan : ((CachedContent) it.next()).f()) {
                if (((File) Assertions.e(cacheSpan.f42058f)).length() != cacheSpan.f42056c) {
                    arrayList.add(cacheSpan);
                }
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            B((CacheSpan) arrayList.get(i3));
        }
    }

    private SimpleCacheSpan D(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z2;
        if (!this.f42111g) {
            return simpleCacheSpan;
        }
        String name = ((File) Assertions.e(simpleCacheSpan.f42058f)).getName();
        long j3 = simpleCacheSpan.f42056c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f42108d;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.h(name, j3, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z2 = false;
        } else {
            z2 = true;
        }
        SimpleCacheSpan simpleCacheSpanL = ((CachedContent) Assertions.e(this.f42107c.f(str))).l(simpleCacheSpan, jCurrentTimeMillis, z2);
        z(simpleCacheSpan, simpleCacheSpanL);
        return simpleCacheSpanL;
    }

    private void o(SimpleCacheSpan simpleCacheSpan) {
        this.f42107c.k(simpleCacheSpan.f42054a).a(simpleCacheSpan);
        this.f42113i += simpleCacheSpan.f42056c;
        x(simpleCacheSpan);
    }

    private static void q(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        Log.d("SimpleCache", str);
        throw new Cache.CacheException(str);
    }

    private static long r(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    private SimpleCacheSpan t(String str, long j3, long j4) {
        SimpleCacheSpan simpleCacheSpanE;
        CachedContent cachedContentF = this.f42107c.f(str);
        if (cachedContentF == null) {
            return SimpleCacheSpan.g(str, j3, j4);
        }
        while (true) {
            simpleCacheSpanE = cachedContentF.e(j3, j4);
            if (!simpleCacheSpanE.f42057d || ((File) Assertions.e(simpleCacheSpanE.f42058f)).length() == simpleCacheSpanE.f42056c) {
                break;
            }
            C();
        }
        return simpleCacheSpanE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (!this.f42105a.exists()) {
            try {
                q(this.f42105a);
            } catch (Cache.CacheException e3) {
                this.f42115k = e3;
                return;
            }
        }
        File[] fileArrListFiles = this.f42105a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f42105a;
            Log.d("SimpleCache", str);
            this.f42115k = new Cache.CacheException(str);
            return;
        }
        long jW = w(fileArrListFiles);
        this.f42112h = jW;
        if (jW == -1) {
            try {
                this.f42112h = r(this.f42105a);
            } catch (IOException e4) {
                String str2 = "Failed to create cache UID: " + this.f42105a;
                Log.e("SimpleCache", str2, e4);
                this.f42115k = new Cache.CacheException(str2, e4);
                return;
            }
        }
        try {
            this.f42107c.l(this.f42112h);
            CacheFileMetadataIndex cacheFileMetadataIndex = this.f42108d;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.e(this.f42112h);
                Map mapB = this.f42108d.b();
                v(this.f42105a, true, fileArrListFiles, mapB);
                this.f42108d.g(mapB.keySet());
            } else {
                v(this.f42105a, true, fileArrListFiles, null);
            }
            this.f42107c.p();
            try {
                this.f42107c.q();
            } catch (IOException e5) {
                Log.e("SimpleCache", "Storing index file failed", e5);
            }
        } catch (IOException e6) {
            String str3 = "Failed to initialize cache indices: " + this.f42105a;
            Log.e("SimpleCache", str3, e6);
            this.f42115k = new Cache.CacheException(str3, e6);
        }
    }

    private void v(File file, boolean z2, File[] fileArr, Map map) {
        long j3;
        long j4;
        if (fileArr == null || fileArr.length == 0) {
            if (z2) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z2 && name.indexOf(46) == -1) {
                v(file2, false, file2.listFiles(), map);
            } else if (!z2 || (!CachedContentIndex.m(name) && !name.endsWith(".uid"))) {
                CacheFileMetadata cacheFileMetadata = map != null ? (CacheFileMetadata) map.remove(name) : null;
                if (cacheFileMetadata != null) {
                    j3 = cacheFileMetadata.f42048a;
                    j4 = cacheFileMetadata.f42049b;
                } else {
                    j3 = -1;
                    j4 = -9223372036854775807L;
                }
                SimpleCacheSpan simpleCacheSpanE = SimpleCacheSpan.e(file2, j3, j4, this.f42107c);
                if (simpleCacheSpanE != null) {
                    o(simpleCacheSpanE);
                } else {
                    file2.delete();
                }
            }
        }
    }

    private static long w(File[] fileArr) {
        int length = fileArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            File file = fileArr[i3];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return A(name);
                } catch (NumberFormatException unused) {
                    Log.d("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private void x(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = (ArrayList) this.f42109e.get(simpleCacheSpan.f42054a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).b(this, simpleCacheSpan);
            }
        }
        this.f42106b.b(this, simpleCacheSpan);
    }

    private void y(CacheSpan cacheSpan) {
        ArrayList arrayList = (ArrayList) this.f42109e.get(cacheSpan.f42054a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).d(this, cacheSpan);
            }
        }
        this.f42106b.d(this, cacheSpan);
    }

    private void z(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = (ArrayList) this.f42109e.get(simpleCacheSpan.f42054a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).a(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.f42106b.a(this, simpleCacheSpan, cacheSpan);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized File a(String str, long j3, long j4) throws Throwable {
        Throwable th;
        try {
            try {
                Assertions.g(!this.f42114j);
                p();
                CachedContent cachedContentF = this.f42107c.f(str);
                Assertions.e(cachedContentF);
                Assertions.g(cachedContentF.h(j3, j4));
                if (!this.f42105a.exists()) {
                    try {
                        q(this.f42105a);
                        C();
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                this.f42106b.c(this, str, j3, j4);
                File file = new File(this.f42105a, Integer.toString(this.f42110f.nextInt(10)));
                if (!file.exists()) {
                    q(file);
                }
                return SimpleCacheSpan.i(file, cachedContentF.f42070a, j3, System.currentTimeMillis());
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized ContentMetadata b(String str) {
        Assertions.g(!this.f42114j);
        return this.f42107c.h(str);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long c(String str, long j3, long j4) {
        long j5;
        long j6 = j4 == -1 ? Long.MAX_VALUE : j3 + j4;
        long j7 = j6 >= 0 ? j6 : Long.MAX_VALUE;
        long j8 = j3;
        j5 = 0;
        while (j8 < j7) {
            long jF = f(str, j8, j7 - j8);
            if (jF > 0) {
                j5 += jF;
            } else {
                jF = -jF;
            }
            j8 += jF;
        }
        return j5;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void d(CacheSpan cacheSpan) {
        Assertions.g(!this.f42114j);
        B(cacheSpan);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized CacheSpan e(String str, long j3, long j4) throws Throwable {
        try {
            try {
                Assertions.g(!this.f42114j);
                p();
                SimpleCacheSpan simpleCacheSpanT = t(str, j3, j4);
                if (simpleCacheSpanT.f42057d) {
                    return D(str, simpleCacheSpanT);
                }
                if (this.f42107c.k(str).j(j3, simpleCacheSpanT.f42056c)) {
                    return simpleCacheSpanT;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long f(String str, long j3, long j4) {
        CachedContent cachedContentF;
        Assertions.g(!this.f42114j);
        if (j4 == -1) {
            j4 = Long.MAX_VALUE;
        }
        cachedContentF = this.f42107c.f(str);
        return cachedContentF != null ? cachedContentF.c(j3, j4) : -j4;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long g() {
        Assertions.g(!this.f42114j);
        return this.f42113i;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void h(CacheSpan cacheSpan) {
        Assertions.g(!this.f42114j);
        CachedContent cachedContent = (CachedContent) Assertions.e(this.f42107c.f(cacheSpan.f42054a));
        cachedContent.m(cacheSpan.f42055b);
        this.f42107c.n(cachedContent.f42071b);
        notifyAll();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:? -> B:10:0x001e). Please report as a decompilation issue!!! */
    @Override // androidx.media3.datasource.cache.Cache
    public synchronized CacheSpan i(String str, long j3, long j4) throws Throwable {
        try {
            Assertions.g(!this.f42114j);
            p();
            while (true) {
                CacheSpan cacheSpanE = e(str, j3, j4);
                long j5 = j4;
                long j6 = j3;
                String str2 = str;
                if (cacheSpanE != null) {
                    return cacheSpanE;
                }
                try {
                    wait();
                    str = str2;
                    j3 = j6;
                    j4 = j5;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void j(File file, long j3) {
        boolean z2 = true;
        Assertions.g(!this.f42114j);
        if (file.exists()) {
            if (j3 == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.e(SimpleCacheSpan.f(file, j3, this.f42107c));
            CachedContent cachedContent = (CachedContent) Assertions.e(this.f42107c.f(simpleCacheSpan.f42054a));
            Assertions.g(cachedContent.h(simpleCacheSpan.f42055b, simpleCacheSpan.f42056c));
            long jB = ContentMetadata.b(cachedContent.d());
            if (jB != -1) {
                if (simpleCacheSpan.f42055b + simpleCacheSpan.f42056c > jB) {
                    z2 = false;
                }
                Assertions.g(z2);
            }
            if (this.f42108d == null) {
                o(simpleCacheSpan);
                this.f42107c.q();
                notifyAll();
                return;
            }
            try {
                this.f42108d.h(file.getName(), simpleCacheSpan.f42056c, simpleCacheSpan.f42059g);
                o(simpleCacheSpan);
                try {
                    this.f42107c.q();
                    notifyAll();
                    return;
                } catch (IOException e3) {
                    throw new Cache.CacheException(e3);
                }
            } catch (IOException e4) {
                throw new Cache.CacheException(e4);
            }
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void k(String str) {
        Assertions.g(!this.f42114j);
        Iterator it = s(str).iterator();
        while (it.hasNext()) {
            B((CacheSpan) it.next());
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void l(String str, ContentMetadataMutations contentMetadataMutations) {
        Assertions.g(!this.f42114j);
        p();
        this.f42107c.d(str, contentMetadataMutations);
        try {
            this.f42107c.q();
        } catch (IOException e3) {
            throw new Cache.CacheException(e3);
        }
    }

    public synchronized void p() {
        Cache.CacheException cacheException = this.f42115k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized NavigableSet s(String str) {
        CachedContent cachedContentF;
        try {
            Assertions.g(!this.f42114j);
            cachedContentF = this.f42107c.f(str);
        } catch (Throwable th) {
            throw th;
        }
        return (cachedContentF == null || cachedContentF.g()) ? new TreeSet() : new TreeSet((Collection) cachedContentF.f());
    }
}
