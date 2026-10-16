package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.SequenceScope;
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
final class MutableEntries<K, V> implements Set<Map.Entry<K, V>>, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f2964a;

    /* JADX INFO: renamed from: androidx.collection.MutableEntries$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<Map.Entry<K, V>>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator f2965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2966b = -1;

        /* JADX INFO: renamed from: androidx.collection.MutableEntries$iterator$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.collection.MutableEntries$iterator$1$1", f = "ScatterMap.kt", l = {1538}, m = "invokeSuspend")
        static final class C00011 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<K, V>>, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f2968a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f2969b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f2970c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f2971d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f2972f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f2973g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int f2974h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            long f2975i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f2976j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f2977k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ MutableEntries f2978l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ AnonymousClass1 f2979m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00011(MutableEntries mutableEntries, AnonymousClass1 anonymousClass1, Continuation continuation) {
                super(2, continuation);
                this.f2978l = mutableEntries;
                this.f2979m = anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00011 c00011 = new C00011(this.f2978l, this.f2979m, continuation);
                c00011.f2977k = obj;
                return c00011;
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00c1  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005f -> B:14:0x0073). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007c -> B:20:0x00b7). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b4 -> B:21:0x00ba). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00cc -> B:26:0x00cd). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 215
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableEntries.AnonymousClass1.C00011.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
                return ((C00011) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1() {
            this.f2965a = SequencesKt.a(new C00011(MutableEntries.this, this, null));
        }

        public final int a() {
            return this.f2966b;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return (Map.Entry) this.f2965a.next();
        }

        public final void c(int i3) {
            this.f2966b = i3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2965a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f2966b != -1) {
                MutableEntries.this.f2964a.v(this.f2966b);
                this.f2966b = -1;
            }
        }
    }

    public MutableEntries(MutableScatterMap parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f2964a = parent;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f2964a.k();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (TypeIntrinsics.o(obj)) {
            return d((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<Map.Entry> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Map.Entry entry : collection) {
            if (!Intrinsics.areEqual(this.f2964a.e(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean d(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(this.f2964a.e(element.getKey()), element.getValue());
    }

    public int e() {
        return this.f2964a.f3112e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0082, code lost:
    
        if (((r4 & ((~r4) << 6)) & r11) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
    
        r13 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f(java.util.Map.Entry r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.String r1 = "element"
            r2 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            androidx.collection.MutableScatterMap r1 = r0.f2964a
            java.lang.Object r3 = r2.getKey()
            if (r3 == 0) goto L16
            int r5 = r3.hashCode()
            goto L17
        L16:
            r5 = 0
        L17:
            r6 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r5 = r5 * r6
            int r6 = r5 << 16
            r5 = r5 ^ r6
            r6 = r5 & 127(0x7f, float:1.78E-43)
            int r7 = r1.f3111d
            int r5 = r5 >>> 7
            r5 = r5 & r7
            r8 = 0
        L26:
            long[] r9 = r1.f3108a
            int r10 = r5 >> 3
            r11 = r5 & 7
            int r11 = r11 << 3
            r12 = r9[r10]
            long r12 = r12 >>> r11
            r14 = 1
            int r10 = r10 + r14
            r9 = r9[r10]
            int r15 = 64 - r11
            long r9 = r9 << r15
            r16 = r5
            r15 = 0
            long r4 = (long) r11
            long r4 = -r4
            r11 = 63
            long r4 = r4 >> r11
            long r4 = r4 & r9
            long r4 = r4 | r12
            long r9 = (long) r6
            r11 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r11
            long r9 = r9 ^ r4
            long r11 = r9 - r11
            long r9 = ~r9
            long r9 = r9 & r11
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
        L54:
            r17 = 0
            int r13 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r13 == 0) goto L78
            int r13 = java.lang.Long.numberOfTrailingZeros(r9)
            int r13 = r13 >> 3
            int r13 = r16 + r13
            r13 = r13 & r7
            r19 = r11
            java.lang.Object[] r11 = r1.f3109b
            r11 = r11[r13]
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r3)
            if (r11 == 0) goto L70
            goto L85
        L70:
            r11 = 1
            long r11 = r9 - r11
            long r9 = r9 & r11
            r11 = r19
            goto L54
        L78:
            r19 = r11
            long r9 = ~r4
            r11 = 6
            long r9 = r9 << r11
            long r4 = r4 & r9
            long r4 = r4 & r19
            int r4 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r4 == 0) goto L9e
            r13 = -1
        L85:
            if (r13 < 0) goto L9d
            androidx.collection.MutableScatterMap r1 = r0.f2964a
            java.lang.Object[] r1 = r1.f3110c
            r1 = r1[r13]
            java.lang.Object r2 = r2.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L9d
            androidx.collection.MutableScatterMap r1 = r0.f2964a
            r1.v(r13)
            return r14
        L9d:
            return r15
        L9e:
            int r8 = r8 + 8
            int r5 = r16 + r8
            r5 = r5 & r7
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableEntries.f(java.util.Map$Entry):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f2964a.h();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (TypeIntrinsics.o(obj)) {
            return f((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        long[] jArr = this.f2964a.f3108a;
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
                        Iterator it = elements.iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (Intrinsics.areEqual(entry.getKey(), this.f2964a.f3109b[i6]) && Intrinsics.areEqual(entry.getValue(), this.f2964a.f3110c[i6])) {
                                this.f2964a.v(i6);
                                z2 = true;
                                break;
                            }
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
        long[] jArr = this.f2964a.f3108a;
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
                        Iterator it = elements.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                this.f2964a.v(i6);
                                z2 = true;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (!Intrinsics.areEqual(entry.getKey(), this.f2964a.f3109b[i6]) || !Intrinsics.areEqual(entry.getValue(), this.f2964a.f3110c[i6])) {
                            }
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
        return e();
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
