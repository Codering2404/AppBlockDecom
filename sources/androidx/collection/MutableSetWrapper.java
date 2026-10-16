package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.SequencesKt;

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
final class MutableSetWrapper<E> extends SetWrapper<E> implements Set<E>, KMutableSet {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableScatterSet f3040b;

    /* JADX INFO: renamed from: androidx.collection.MutableSetWrapper$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<E>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3041a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator f3042b;

        AnonymousClass1() {
            this.f3042b = SequencesKt.a(new MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper.this, this, null));
        }

        public final void a(int i3) {
            this.f3041a = i3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3042b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.f3042b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f3041a != -1) {
                MutableSetWrapper.this.f3040b.B(this.f3041a);
                this.f3041a = -1;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSetWrapper(MutableScatterSet parent) {
        super(parent);
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f3040b = parent;
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.f3040b.i(obj);
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f3040b.k(elements);
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection
    public void clear() {
        this.f3040b.n();
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f3040b.z(obj);
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f3040b.A(elements);
    }

    @Override // androidx.collection.SetWrapper, java.util.Set, java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.f3040b.D(elements);
    }
}
