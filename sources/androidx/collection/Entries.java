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
import kotlin.jvm.internal.markers.KMappedMarker;
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
final class Entries<K, V> implements Set<Map.Entry<? extends K, ? extends V>>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScatterMap f2815a;

    /* JADX INFO: renamed from: androidx.collection.Entries$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.collection.Entries$iterator$1", f = "ScatterMap.kt", l = {1414}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<? extends K, ? extends V>>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f2817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2819d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2821g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f2822h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f2823i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private /* synthetic */ Object f2824j;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f2824j = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0059 -> B:14:0x006a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0073 -> B:20:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a5 -> B:21:0x00aa). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b8 -> B:26:0x00b9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                r20 = this;
                r0 = r20
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f2823i
                r4 = 8
                r5 = 1
                if (r2 == 0) goto L32
                if (r2 != r5) goto L2a
                int r2 = r0.f2821g
                int r6 = r0.f2820f
                long r7 = r0.f2822h
                int r9 = r0.f2819d
                int r10 = r0.f2818c
                java.lang.Object r11 = r0.f2817b
                long[] r11 = (long[]) r11
                java.lang.Object r12 = r0.f2816a
                androidx.collection.Entries r12 = (androidx.collection.Entries) r12
                java.lang.Object r13 = r0.f2824j
                kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
                kotlin.ResultKt.b(r21)
                goto La8
            L2a:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L32:
                kotlin.ResultKt.b(r21)
                java.lang.Object r2 = r0.f2824j
                kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
                androidx.collection.Entries r6 = androidx.collection.Entries.this
                androidx.collection.ScatterMap r6 = androidx.collection.Entries.a(r6)
                androidx.collection.Entries r7 = androidx.collection.Entries.this
                long[] r6 = r6.f3108a
                int r8 = r6.length
                int r8 = r8 + (-2)
                if (r8 < 0) goto Lbf
                r9 = 0
            L49:
                r10 = r6[r9]
                long r12 = ~r10
                r14 = 7
                long r12 = r12 << r14
                long r12 = r12 & r10
                r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r12 = r12 & r14
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 == 0) goto Lb8
                int r12 = r9 - r8
                int r12 = ~r12
                int r12 = r12 >>> 31
                int r12 = 8 - r12
                r13 = r2
                r2 = 0
                r18 = r10
                r11 = r6
                r10 = r8
                r6 = r12
                r12 = r7
                r7 = r18
            L6a:
                if (r2 >= r6) goto Lb0
                r14 = 255(0xff, double:1.26E-321)
                long r14 = r14 & r7
                r16 = 128(0x80, double:6.3E-322)
                int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r14 >= 0) goto La8
                int r14 = r9 << 3
                int r14 = r14 + r2
                androidx.collection.MapEntry r15 = new androidx.collection.MapEntry
                androidx.collection.ScatterMap r3 = androidx.collection.Entries.a(r12)
                java.lang.Object[] r3 = r3.f3109b
                r3 = r3[r14]
                r17 = r4
                androidx.collection.ScatterMap r4 = androidx.collection.Entries.a(r12)
                java.lang.Object[] r4 = r4.f3110c
                r4 = r4[r14]
                r15.<init>(r3, r4)
                r0.f2824j = r13
                r0.f2816a = r12
                r0.f2817b = r11
                r0.f2818c = r10
                r0.f2819d = r9
                r0.f2822h = r7
                r0.f2820f = r6
                r0.f2821g = r2
                r0.f2823i = r5
                java.lang.Object r3 = r13.a(r15, r0)
                if (r3 != r1) goto Laa
                return r1
            La8:
                r17 = r4
            Laa:
                long r7 = r7 >> r17
                int r2 = r2 + r5
                r4 = r17
                goto L6a
            Lb0:
                r3 = r4
                if (r6 != r3) goto Lbf
                r8 = r10
                r6 = r11
                r7 = r12
                r2 = r13
                goto Lb9
            Lb8:
                r3 = r4
            Lb9:
                if (r9 == r8) goto Lbf
                int r9 = r9 + 1
                r4 = r3
                goto L49
            Lbf:
                kotlin.Unit r1 = kotlin.Unit.f139807a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.Entries.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public Entries(ScatterMap parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f2815a = parent;
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(this.f2815a.e(element.getKey()), element.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return b((Map.Entry) obj);
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
            if (!Intrinsics.areEqual(this.f2815a.e(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int d() {
        return this.f2815a.f3112e;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f2815a.h();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return SequencesKt.a(new AnonymousClass1(null));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return d();
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
