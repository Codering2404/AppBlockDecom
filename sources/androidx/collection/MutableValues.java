package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterator;
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
final class MutableValues<K, V> implements Collection<V>, KMutableCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f3056a;

    /* JADX INFO: renamed from: androidx.collection.MutableValues$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<V>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f3057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3058b = -1;

        AnonymousClass1() {
            this.f3057a = SequencesKt.a(new MutableValues$iterator$1$iterator$1(MutableValues.this, null));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3057a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            this.f3058b = ((Number) this.f3057a.next()).intValue();
            return MutableValues.this.f3056a.f3110c[this.f3058b];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f3058b >= 0) {
                MutableValues.this.f3056a.v(this.f3058b);
                this.f3058b = -1;
            }
        }
    }

    public MutableValues(MutableScatterMap parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f3056a = parent;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    public int b() {
        return this.f3056a.f3112e;
    }

    @Override // java.util.Collection
    public void clear() {
        this.f3056a.k();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.f3056a.d(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f3056a.d(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f3056a.h();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r14) {
        /*
            r13 = this;
            androidx.collection.MutableScatterMap r0 = r13.f3056a
            long[] r0 = r0.f3108a
            int r1 = r0.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L51
            r3 = r2
        Lb:
            r4 = r0[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L4c
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L4a
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L46
            int r9 = r3 << 3
            int r9 = r9 + r8
            androidx.collection.MutableScatterMap r10 = r13.f3056a
            java.lang.Object[] r10 = r10.f3110c
            r10 = r10[r9]
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r14)
            if (r10 == 0) goto L46
            androidx.collection.MutableScatterMap r14 = r13.f3056a
            r14.v(r9)
            r14 = 1
            return r14
        L46:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L4a:
            if (r6 != r7) goto L51
        L4c:
            if (r3 == r1) goto L51
            int r3 = r3 + 1
            goto Lb
        L51:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableValues.remove(java.lang.Object):boolean");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        long[] jArr = this.f3056a.f3108a;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        if (CollectionsKt.contains(elements, this.f3056a.f3110c[i6])) {
                            this.f3056a.v(i6);
                            z2 = true;
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return z2;
                }
            }
            if (i3 == length) {
                return z2;
            }
            i3++;
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        long[] jArr = this.f3056a.f3108a;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        if (!CollectionsKt.contains(elements, this.f3056a.f3110c[i6])) {
                            this.f3056a.v(i6);
                            z2 = true;
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return z2;
                }
            }
            if (i3 == length) {
                return z2;
            }
            i3++;
        }
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
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
