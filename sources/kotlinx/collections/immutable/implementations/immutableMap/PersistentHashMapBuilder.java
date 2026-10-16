package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue;
import kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import kotlinx.collections.immutable.internal.DeltaCounter;
import kotlinx.collections.immutable.internal.MapImplementation;
import kotlinx.collections.immutable.internal.MutabilityOwnership;

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
public final class PersistentHashMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentHashMap f140746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutabilityOwnership f140747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TrieNode f140748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f140749d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f140750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f140751g;

    public PersistentHashMapBuilder(PersistentHashMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f140746a = map;
        this.f140747b = new MutabilityOwnership();
        this.f140748c = this.f140746a.g();
        this.f140751g = this.f140746a.size();
    }

    public PersistentHashMap a() {
        PersistentHashMap persistentHashMap;
        if (this.f140748c == this.f140746a.g()) {
            persistentHashMap = this.f140746a;
        } else {
            this.f140747b = new MutabilityOwnership();
            persistentHashMap = new PersistentHashMap(this.f140748c, size());
        }
        this.f140746a = persistentHashMap;
        return persistentHashMap;
    }

    public final int b() {
        return this.f140750f;
    }

    public final TrieNode c() {
        return this.f140748c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f140748c = TrieNode.f140767e.a();
        g(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f140748c.g(obj == null ? 0 : obj.hashCode(), obj, 0);
    }

    public final MutabilityOwnership d() {
        return this.f140747b;
    }

    public final void e(int i3) {
        this.f140750f = i3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        return map instanceof PersistentHashMap ? this.f140748c.k(((PersistentHashMap) obj).g(), new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder.equals.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, Object obj3) {
                return Boolean.valueOf(Intrinsics.areEqual(obj2, obj3));
            }
        }) : map instanceof PersistentHashMapBuilder ? this.f140748c.k(((PersistentHashMapBuilder) obj).f140748c, new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder.equals.2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, Object obj3) {
                return Boolean.valueOf(Intrinsics.areEqual(obj2, obj3));
            }
        }) : map instanceof PersistentOrderedMap ? this.f140748c.k(((PersistentOrderedMap) obj).e().g(), new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder.equals.3
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(obj2, b3.e()));
            }
        }) : map instanceof PersistentOrderedMapBuilder ? this.f140748c.k(((PersistentOrderedMapBuilder) obj).b().f140748c, new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder.equals.4
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(obj2, b3.e()));
            }
        }) : MapImplementation.f140868a.b(this, map);
    }

    public final void f(Object obj) {
        this.f140749d = obj;
    }

    public void g(int i3) {
        this.f140751g = i3;
        this.f140750f++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.f140748c.l(obj == null ? 0 : obj.hashCode(), obj, 0);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set getEntries() {
        return new PersistentHashMapBuilderEntries(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set getKeys() {
        return new PersistentHashMapBuilderKeys(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.f140751g;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return MapImplementation.f140868a.c(this);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f140749d = null;
        this.f140748c = this.f140748c.y(obj == null ? 0 : obj.hashCode(), obj, obj2, 0, this);
        return this.f140749d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        PersistentHashMap persistentHashMapA = from instanceof PersistentHashMap ? (PersistentHashMap) from : null;
        if (persistentHashMapA == null) {
            PersistentHashMapBuilder persistentHashMapBuilder = from instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) from : null;
            persistentHashMapA = persistentHashMapBuilder == null ? null : persistentHashMapBuilder.a();
        }
        if (persistentHashMapA == null) {
            super.putAll(from);
            return;
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        this.f140748c = this.f140748c.z(persistentHashMapA.g(), 0, deltaCounter, this);
        int size2 = (persistentHashMapA.size() + size) - deltaCounter.a();
        if (size != size2) {
            g(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        this.f140749d = null;
        TrieNode trieNodeB = this.f140748c.B(obj == null ? 0 : obj.hashCode(), obj, 0, this);
        if (trieNodeB == null) {
            trieNodeB = TrieNode.f140767e.a();
        }
        this.f140748c = trieNodeB;
        return this.f140749d;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        TrieNode trieNodeC = this.f140748c.C(obj == null ? 0 : obj.hashCode(), obj, obj2, 0, this);
        if (trieNodeC == null) {
            trieNodeC = TrieNode.f140767e.a();
        }
        this.f140748c = trieNodeC;
        return size != size();
    }
}
