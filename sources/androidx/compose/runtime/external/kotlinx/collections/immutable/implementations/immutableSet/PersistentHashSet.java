package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PersistentHashSet<E> extends AbstractSet<E> implements PersistentSet<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f24495c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24496d = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PersistentHashSet f24497f = new PersistentHashSet(TrieNode.f24512d.a(), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrieNode f24498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24499b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PersistentHashSet(TrieNode trieNode, int i3) {
        this.f24498a = trieNode;
        this.f24499b = i3;
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet add(Object obj) {
        TrieNode trieNodeB = this.f24498a.b(obj != null ? obj.hashCode() : 0, obj, 0);
        return this.f24498a == trieNodeB ? this : new PersistentHashSet(trieNodeB, size() + 1);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet addAll(Collection collection) {
        PersistentSet.Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    public final TrieNode b() {
        return this.f24498a;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet.Builder builder() {
        return new PersistentHashSetBuilder(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f24498a.i(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection collection) {
        return collection instanceof PersistentHashSet ? this.f24498a.j(((PersistentHashSet) collection).f24498a, 0) : collection instanceof PersistentHashSetBuilder ? this.f24498a.j(((PersistentHashSetBuilder) collection).d(), 0) : super.containsAll(collection);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f24499b;
    }

    @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new PersistentHashSetIterator(this.f24498a);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet remove(Object obj) {
        TrieNode trieNodeJ = this.f24498a.J(obj != null ? obj.hashCode() : 0, obj, 0);
        return this.f24498a == trieNodeJ ? this : new PersistentHashSet(trieNodeJ, size() - 1);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet removeAll(Collection collection) {
        PersistentSet.Builder builder = builder();
        builder.removeAll(collection);
        return builder.build();
    }
}
