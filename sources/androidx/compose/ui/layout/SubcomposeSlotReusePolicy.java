package androidx.compose.ui.layout;

import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.OrderedScatterSetKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public interface SubcomposeSlotReusePolicy {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SlotIdsSet implements Collection<Object>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MutableOrderedScatterSet f27237a;

        public SlotIdsSet(MutableOrderedScatterSet mutableOrderedScatterSet) {
            this.f27237a = mutableOrderedScatterSet;
        }

        @Override // java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean add(Object obj) {
            return this.f27237a.g(obj);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public int b() {
            return this.f27237a.c();
        }

        @Override // java.util.Collection
        public final void clear() {
            this.f27237a.k();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return this.f27237a.a(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!this.f27237a.a(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final void d(int i3) {
            this.f27237a.C(i3);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f27237a.d();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return this.f27237a.j().iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.f27237a.x(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            return this.f27237a.x(collection);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            return this.f27237a.B(collection);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return b();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }

        public /* synthetic */ SlotIdsSet(MutableOrderedScatterSet mutableOrderedScatterSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? OrderedScatterSetKt.a() : mutableOrderedScatterSet);
        }
    }

    void a(SlotIdsSet slotIdsSet);

    boolean b(Object obj, Object obj2);
}
