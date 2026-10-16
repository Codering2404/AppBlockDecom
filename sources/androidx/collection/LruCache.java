package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i3) {
        this.maxSize = i3;
        if (!(i3 > 0)) {
            RuntimeHelpersKt.a("maxSize <= 0");
        }
        this.map = new LruHashMap<>(0, 0.75f);
        this.lock = new Lock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int a(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (!(iSizeOf >= 0)) {
            RuntimeHelpersKt.b("Negative size: " + obj + '=' + obj2);
        }
        return iSizeOf;
    }

    protected V create(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public final int createCount() {
        int i3;
        synchronized (this.lock) {
            i3 = this.createCount;
        }
        return i3;
    }

    protected void entryRemoved(boolean z2, K key, V oldValue, V v2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i3;
        synchronized (this.lock) {
            i3 = this.evictionCount;
        }
        return i3;
    }

    public final V get(K key) {
        V v2;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            V v3 = (V) this.map.a(key);
            if (v3 != null) {
                this.hitCount++;
                return v3;
            }
            this.missCount++;
            V vCreate = create(key);
            if (vCreate == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    v2 = (V) this.map.d(key, vCreate);
                    if (v2 != null) {
                        this.map.d(key, v2);
                    } else {
                        this.size += a(key, vCreate);
                        Unit unit = Unit.f139807a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v2 != null) {
                entryRemoved(false, key, vCreate, v2);
                return v2;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final int hitCount() {
        int i3;
        synchronized (this.lock) {
            i3 = this.hitCount;
        }
        return i3;
    }

    public final int maxSize() {
        int i3;
        synchronized (this.lock) {
            i3 = this.maxSize;
        }
        return i3;
    }

    public final int missCount() {
        int i3;
        synchronized (this.lock) {
            i3 = this.missCount;
        }
        return i3;
    }

    public final V put(K key, V value) {
        V v2;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += a(key, value);
                v2 = (V) this.map.d(key, value);
                if (v2 != null) {
                    this.size -= a(key, v2);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (v2 != null) {
            entryRemoved(false, key, v2, value);
        }
        trimToSize(this.maxSize);
        return v2;
    }

    public final int putCount() {
        int i3;
        synchronized (this.lock) {
            i3 = this.putCount;
        }
        return i3;
    }

    public final V remove(K key) {
        V v2;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            try {
                v2 = (V) this.map.e(key);
                if (v2 != null) {
                    this.size -= a(key, v2);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (v2 != null) {
            entryRemoved(false, key, v2, null);
        }
        return v2;
    }

    public void resize(int i3) {
        if (!(i3 > 0)) {
            RuntimeHelpersKt.a("maxSize <= 0");
        }
        synchronized (this.lock) {
            this.maxSize = i3;
            Unit unit = Unit.f139807a;
        }
        trimToSize(i3);
    }

    public final int size() {
        int i3;
        synchronized (this.lock) {
            i3 = this.size;
        }
        return i3;
    }

    protected int sizeOf(K key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.lock) {
            linkedHashMap = new LinkedHashMap(this.map.b().size());
            for (Map.Entry entry : this.map.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i3 = this.hitCount;
                int i4 = this.missCount + i3;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i4 != 0 ? (i3 * 100) / i4 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trimToSize(int r7) {
        /*
            r6 = this;
        L0:
            androidx.collection.internal.Lock r0 = r6.lock
            monitor-enter(r0)
            int r1 = r6.size     // Catch: java.lang.Throwable -> L15
            r2 = 1
            if (r1 < 0) goto L19
            androidx.collection.internal.LruHashMap<K, V> r1 = r6.map     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L17
            int r1 = r6.size     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L19
            goto L17
        L15:
            r7 = move-exception
            goto L63
        L17:
            r1 = r2
            goto L1a
        L19:
            r1 = 0
        L1a:
            if (r1 != 0) goto L21
            java.lang.String r1 = "LruCache.sizeOf() is reporting inconsistent results!"
            androidx.collection.internal.RuntimeHelpersKt.b(r1)     // Catch: java.lang.Throwable -> L15
        L21:
            int r1 = r6.size     // Catch: java.lang.Throwable -> L15
            if (r1 <= r7) goto L61
            androidx.collection.internal.LruHashMap<K, V> r1 = r6.map     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L2e
            goto L61
        L2e:
            androidx.collection.internal.LruHashMap<K, V> r1 = r6.map     // Catch: java.lang.Throwable -> L15
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L15
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L15
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)     // Catch: java.lang.Throwable -> L15
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L40
            monitor-exit(r0)
            return
        L40:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L15
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L15
            androidx.collection.internal.LruHashMap<K, V> r4 = r6.map     // Catch: java.lang.Throwable -> L15
            r4.e(r3)     // Catch: java.lang.Throwable -> L15
            int r4 = r6.size     // Catch: java.lang.Throwable -> L15
            int r5 = r6.a(r3, r1)     // Catch: java.lang.Throwable -> L15
            int r4 = r4 - r5
            r6.size = r4     // Catch: java.lang.Throwable -> L15
            int r4 = r6.evictionCount     // Catch: java.lang.Throwable -> L15
            int r4 = r4 + r2
            r6.evictionCount = r4     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r0 = 0
            r6.entryRemoved(r2, r3, r1, r0)
            goto L0
        L61:
            monitor-exit(r0)
            return
        L63:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
