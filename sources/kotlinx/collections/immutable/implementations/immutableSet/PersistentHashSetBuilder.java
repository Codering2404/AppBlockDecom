package kotlinx.collections.immutable.implementations.immutableSet;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.collections.immutable.internal.DeltaCounter;
import kotlinx.collections.immutable.internal.MutabilityOwnership;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentHashSet f140781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutabilityOwnership f140782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TrieNode f140783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140784d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f140785f;

    public PersistentHashSetBuilder(PersistentHashSet set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.f140781a = set;
        this.f140782b = new MutabilityOwnership();
        this.f140783c = this.f140781a.b();
        this.f140785f = this.f140781a.size();
    }

    @Override // kotlinx.collections.immutable.PersistentSet.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersistentHashSet build() {
        PersistentHashSet persistentHashSet;
        if (this.f140783c == this.f140781a.b()) {
            persistentHashSet = this.f140781a;
        } else {
            this.f140782b = new MutabilityOwnership();
            persistentHashSet = new PersistentHashSet(this.f140783c, size());
        }
        this.f140781a = persistentHashSet;
        return persistentHashSet;
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int size = size();
        this.f140783c = this.f140783c.r(obj == null ? 0 : obj.hashCode(), obj, 0, this);
        return size != size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentHashSet persistentHashSetBuild = elements instanceof PersistentHashSet ? (PersistentHashSet) elements : null;
        if (persistentHashSetBuild == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = elements instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) elements : null;
            persistentHashSetBuild = persistentHashSetBuilder == null ? null : persistentHashSetBuilder.build();
        }
        if (persistentHashSetBuild == null) {
            return super.addAll(elements);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        TrieNode trieNodeS = this.f140783c.s(persistentHashSetBuild.b(), 0, deltaCounter, this);
        int size2 = (elements.size() + size) - deltaCounter.a();
        if (size != size2) {
            this.f140783c = trieNodeS;
            f(size2);
        }
        return size != size();
    }

    public final int b() {
        return this.f140784d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f140783c = TrieNode.f140793d.a();
        f(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f140783c.g(obj == null ? 0 : obj.hashCode(), obj, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements instanceof PersistentHashSet ? this.f140783c.h(((PersistentHashSet) elements).b(), 0) : elements instanceof PersistentHashSetBuilder ? this.f140783c.h(((PersistentHashSetBuilder) elements).f140783c, 0) : super.containsAll(elements);
    }

    public final TrieNode d() {
        return this.f140783c;
    }

    public final MutabilityOwnership e() {
        return this.f140782b;
    }

    public void f(int i3) {
        this.f140785f = i3;
        this.f140784d++;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.f140785f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PersistentHashSetMutableIterator(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int size = size();
        this.f140783c = this.f140783c.y(obj == null ? 0 : obj.hashCode(), obj, 0, this);
        return size != size();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentHashSet persistentHashSetBuild = elements instanceof PersistentHashSet ? (PersistentHashSet) elements : null;
        if (persistentHashSetBuild == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = elements instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) elements : null;
            persistentHashSetBuild = persistentHashSetBuilder == null ? null : persistentHashSetBuilder.build();
        }
        if (persistentHashSetBuild == null) {
            return super.removeAll(elements);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        Object objZ = this.f140783c.z(persistentHashSetBuild.b(), 0, deltaCounter, this);
        int iA = size - deltaCounter.a();
        if (iA == 0) {
            clear();
        } else if (iA != size) {
            if (objZ == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            }
            this.f140783c = (TrieNode) objZ;
            f(iA);
        }
        return size != size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentHashSet persistentHashSetBuild = elements instanceof PersistentHashSet ? (PersistentHashSet) elements : null;
        if (persistentHashSetBuild == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = elements instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) elements : null;
            persistentHashSetBuild = persistentHashSetBuilder == null ? null : persistentHashSetBuilder.build();
        }
        if (persistentHashSetBuild == null) {
            return super.retainAll(elements);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        Object objA = this.f140783c.A(persistentHashSetBuild.b(), 0, deltaCounter, this);
        int iA = deltaCounter.a();
        if (iA == 0) {
            clear();
        } else if (iA != size) {
            if (objA == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            }
            this.f140783c = (TrieNode) objA;
            f(iA);
        }
        return size != size();
    }
}
