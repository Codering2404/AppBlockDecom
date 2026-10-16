package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
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
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentHashSet f24500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutabilityOwnership f24501b = new MutabilityOwnership();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TrieNode f24502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24503d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24504f;

    public PersistentHashSetBuilder(PersistentHashSet persistentHashSet) {
        this.f24500a = persistentHashSet;
        this.f24502c = this.f24500a.b();
        this.f24504f = this.f24500a.size();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersistentHashSet build() {
        PersistentHashSet persistentHashSet;
        if (this.f24502c == this.f24500a.b()) {
            persistentHashSet = this.f24500a;
        } else {
            this.f24501b = new MutabilityOwnership();
            persistentHashSet = new PersistentHashSet(this.f24502c, size());
        }
        this.f24500a = persistentHashSet;
        return persistentHashSet;
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int size = size();
        this.f24502c = this.f24502c.t(obj != null ? obj.hashCode() : 0, obj, 0, this);
        return size != size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        PersistentHashSet persistentHashSetBuild = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSetBuild == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSetBuild = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSetBuild == null) {
            return super.addAll(collection);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        TrieNode trieNodeU = this.f24502c.u(persistentHashSetBuild.b(), 0, deltaCounter, this);
        int size2 = (collection.size() + size) - deltaCounter.a();
        if (size != size2) {
            this.f24502c = trieNodeU;
            f(size2);
        }
        return size != size();
    }

    public final int b() {
        return this.f24503d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        TrieNode trieNodeA = TrieNode.f24512d.a();
        Intrinsics.checkNotNull(trieNodeA, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.f24502c = trieNodeA;
        f(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f24502c.i(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        return collection instanceof PersistentHashSet ? this.f24502c.j(((PersistentHashSet) collection).b(), 0) : collection instanceof PersistentHashSetBuilder ? this.f24502c.j(((PersistentHashSetBuilder) collection).f24502c, 0) : super.containsAll(collection);
    }

    public final TrieNode d() {
        return this.f24502c;
    }

    public final MutabilityOwnership e() {
        return this.f24501b;
    }

    public void f(int i3) {
        this.f24504f = i3;
        this.f24503d++;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.f24504f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PersistentHashSetMutableIterator(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int size = size();
        this.f24502c = this.f24502c.D(obj != null ? obj.hashCode() : 0, obj, 0, this);
        return size != size();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        PersistentHashSet persistentHashSetBuild = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSetBuild == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSetBuild = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSetBuild == null) {
            return super.removeAll(collection);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        Object objE = this.f24502c.E(persistentHashSetBuild.b(), 0, deltaCounter, this);
        int iA = size - deltaCounter.a();
        if (iA == 0) {
            clear();
        } else if (iA != size) {
            Intrinsics.checkNotNull(objE, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            this.f24502c = (TrieNode) objE;
            f(iA);
        }
        return size != size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        PersistentHashSet persistentHashSetBuild = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSetBuild == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSetBuild = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSetBuild == null) {
            return super.retainAll(collection);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        Object objG = this.f24502c.G(persistentHashSetBuild.b(), 0, deltaCounter, this);
        int iA = deltaCounter.a();
        if (iA == 0) {
            clear();
        } else if (iA != size) {
            Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            this.f24502c = (TrieNode) objG;
            f(iA);
        }
        return size != size();
    }
}
