package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class PersistentHashMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentHashMap f24465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutabilityOwnership f24466b = new MutabilityOwnership();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TrieNode f24467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f24468d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24470g;

    public PersistentHashMapBuilder(PersistentHashMap persistentHashMap) {
        this.f24465a = persistentHashMap;
        this.f24467c = this.f24465a.g();
        this.f24470g = this.f24465a.size();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersistentHashMap build() {
        PersistentHashMap persistentHashMap;
        if (this.f24467c == this.f24465a.g()) {
            persistentHashMap = this.f24465a;
        } else {
            this.f24466b = new MutabilityOwnership();
            persistentHashMap = new PersistentHashMap(this.f24467c, size());
        }
        this.f24465a = persistentHashMap;
        return persistentHashMap;
    }

    public final int b() {
        return this.f24469f;
    }

    public final TrieNode c() {
        return this.f24467c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        TrieNode trieNodeA = TrieNode.f24482e.a();
        Intrinsics.checkNotNull(trieNodeA, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f24467c = trieNodeA;
        h(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f24467c.k(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    public final MutabilityOwnership d() {
        return this.f24466b;
    }

    public final void e(int i3) {
        this.f24469f = i3;
    }

    public final void f(Object obj) {
        this.f24468d = obj;
    }

    protected final void g(MutabilityOwnership mutabilityOwnership) {
        this.f24466b = mutabilityOwnership;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.f24467c.o(obj != null ? obj.hashCode() : 0, obj, 0);
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
        return this.f24470g;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    public void h(int i3) {
        this.f24470g = i3;
        this.f24469f++;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f24468d = null;
        this.f24467c = this.f24467c.D(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        return this.f24468d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        PersistentHashMap persistentHashMapBuild = map instanceof PersistentHashMap ? (PersistentHashMap) map : null;
        if (persistentHashMapBuild == null) {
            PersistentHashMapBuilder persistentHashMapBuilder = map instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) map : null;
            persistentHashMapBuild = persistentHashMapBuilder != null ? persistentHashMapBuilder.build() : null;
        }
        if (persistentHashMapBuild == null) {
            super.putAll(map);
            return;
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        TrieNode trieNode = this.f24467c;
        TrieNode trieNodeG = persistentHashMapBuild.g();
        Intrinsics.checkNotNull(trieNodeG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f24467c = trieNode.E(trieNodeG, 0, deltaCounter, this);
        int size2 = (persistentHashMapBuild.size() + size) - deltaCounter.a();
        if (size != size2) {
            h(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        this.f24468d = null;
        TrieNode trieNodeG = this.f24467c.G(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (trieNodeG == null) {
            trieNodeG = TrieNode.f24482e.a();
            Intrinsics.checkNotNull(trieNodeG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.f24467c = trieNodeG;
        return this.f24468d;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        TrieNode trieNodeH = this.f24467c.H(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (trieNodeH == null) {
            trieNodeH = TrieNode.f24482e.a();
            Intrinsics.checkNotNull(trieNodeH, bfIdKSjLOVjG.dkcwml);
        }
        this.f24467c = trieNodeH;
        return size != size();
    }
}
