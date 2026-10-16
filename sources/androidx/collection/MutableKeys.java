package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
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
final class MutableKeys<K, V> implements Set<K>, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f2990a;

    /* JADX INFO: renamed from: androidx.collection.MutableKeys$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<K>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f2991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2992b = -1;

        AnonymousClass1() {
            this.f2991a = SequencesKt.a(new MutableKeys$iterator$1$iterator$1(MutableKeys.this, null));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2991a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            this.f2992b = ((Number) this.f2991a.next()).intValue();
            return MutableKeys.this.f2990a.f3109b[this.f2992b];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f2992b >= 0) {
                MutableKeys.this.f2990a.v(this.f2992b);
                this.f2992b = -1;
            }
        }
    }

    public MutableKeys(MutableScatterMap parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f2990a = parent;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    public int b() {
        return this.f2990a.f3112e;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f2990a.k();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f2990a.c(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f2990a.c(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f2990a.h();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        r18 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
    
        if (((r8 & ((~r8) << 6)) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
    
        r12 = -1;
     */
    @Override // java.util.Set, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            androidx.collection.MutableScatterMap r2 = r0.f2990a
            if (r1 == 0) goto Ld
            int r4 = r1.hashCode()
            goto Le
        Ld:
            r4 = 0
        Le:
            r5 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r4 = r4 * r5
            int r5 = r4 << 16
            r4 = r4 ^ r5
            r5 = r4 & 127(0x7f, float:1.78E-43)
            int r6 = r2.f3111d
            int r4 = r4 >>> 7
            r4 = r4 & r6
            r7 = 0
        L1d:
            long[] r8 = r2.f3108a
            int r9 = r4 >> 3
            r10 = r4 & 7
            int r10 = r10 << 3
            r11 = r8[r9]
            long r11 = r11 >>> r10
            r13 = 1
            int r9 = r9 + r13
            r8 = r8[r9]
            int r14 = 64 - r10
            long r8 = r8 << r14
            long r14 = (long) r10
            long r14 = -r14
            r10 = 63
            long r14 = r14 >> r10
            long r8 = r8 & r14
            long r8 = r8 | r11
            long r10 = (long) r5
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r10 = r10 * r14
            long r10 = r10 ^ r8
            long r14 = r10 - r14
            long r10 = ~r10
            long r10 = r10 & r14
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r14
        L48:
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 == 0) goto L6a
            int r12 = java.lang.Long.numberOfTrailingZeros(r10)
            int r12 = r12 >> 3
            int r12 = r12 + r4
            r12 = r12 & r6
            r18 = 0
            java.lang.Object[] r3 = r2.f3109b
            r3 = r3[r12]
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r3 == 0) goto L63
            goto L76
        L63:
            r16 = 1
            long r16 = r10 - r16
            long r10 = r10 & r16
            goto L48
        L6a:
            r18 = 0
            long r10 = ~r8
            r3 = 6
            long r10 = r10 << r3
            long r8 = r8 & r10
            long r8 = r8 & r14
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 == 0) goto L7f
            r12 = -1
        L76:
            if (r12 < 0) goto L7e
            androidx.collection.MutableScatterMap r1 = r0.f2990a
            r1.v(r12)
            return r13
        L7e:
            return r18
        L7f:
            int r7 = r7 + 8
            int r4 = r4 + r7
            r4 = r4 & r6
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableKeys.remove(java.lang.Object):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        long[] jArr = this.f2990a.f3108a;
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
                        if (CollectionsKt.contains(elements, this.f2990a.f3109b[i6])) {
                            this.f2990a.v(i6);
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

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        long[] jArr = this.f2990a.f3108a;
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
                        if (!CollectionsKt.contains(elements, this.f2990a.f3109b[i6])) {
                            this.f2990a.v(i6);
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

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.b(this, array);
    }
}
