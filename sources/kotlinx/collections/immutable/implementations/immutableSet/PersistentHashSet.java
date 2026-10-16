package kotlinx.collections.immutable.implementations.immutableSet;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentSet;

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
public final class PersistentHashSet<E> extends AbstractSet<E> implements PersistentSet<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f140777c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PersistentHashSet f140778d = new PersistentHashSet(TrieNode.f140793d.a(), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrieNode f140779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140780b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PersistentHashSet(TrieNode node, int i3) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.f140779a = node;
        this.f140780b = i3;
    }

    @Override // java.util.Collection, java.util.Set, kotlinx.collections.immutable.PersistentSet
    public PersistentSet addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder builder = builder();
        builder.addAll(elements);
        return builder.build();
    }

    public final TrieNode b() {
        return this.f140779a;
    }

    @Override // kotlinx.collections.immutable.PersistentSet
    public PersistentSet.Builder builder() {
        return new PersistentHashSetBuilder(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f140779a.g(obj == null ? 0 : obj.hashCode(), obj, 0);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements instanceof PersistentHashSet ? this.f140779a.h(((PersistentHashSet) elements).f140779a, 0) : elements instanceof PersistentHashSetBuilder ? this.f140779a.h(((PersistentHashSetBuilder) elements).d(), 0) : super.containsAll(elements);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f140780b;
    }

    @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new PersistentHashSetIterator(this.f140779a);
    }
}
