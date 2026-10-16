package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
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
public final class LazyStaggeredGridLaneInfo {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f8424d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8425e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f8427b = new int[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f8428c = new ArrayDeque();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class SpannedItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int[] f8430b;

        public SpannedItem(int i3, int[] iArr) {
            this.f8429a = i3;
            this.f8430b = iArr;
        }

        public final int[] a() {
            return this.f8430b;
        }

        public final int b() {
            return this.f8429a;
        }

        public final void c(int[] iArr) {
            this.f8430b = iArr;
        }
    }

    private final void b(int i3, int i4) {
        if (!(i3 <= 131072)) {
            InlineClassHelperKt.a("Requested item capacity " + i3 + " is larger than max supported: 131072!");
        }
        int[] iArr = this.f8427b;
        if (iArr.length < i3) {
            int length = iArr.length;
            while (length < i3) {
                length *= 2;
            }
            this.f8427b = ArraysKt.copyInto$default(this.f8427b, new int[length], i4, 0, 0, 12, (Object) null);
        }
    }

    static /* synthetic */ void c(LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        lazyStaggeredGridLaneInfo.b(i3, i4);
    }

    public final boolean a(int i3, int i4) {
        int iH = h(i3);
        return iH == i4 || iH == -1 || iH == -2;
    }

    public final void d(int i3) {
        int i4 = this.f8426a;
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= 131072) {
            int iMax = Math.max(i3 - (this.f8427b.length / 2), 0);
            this.f8426a = iMax;
            int i6 = iMax - i4;
            if (i6 >= 0) {
                int[] iArr = this.f8427b;
                if (i6 < iArr.length) {
                    ArraysKt.copyInto(iArr, iArr, 0, i6, iArr.length);
                }
                int[] iArr2 = this.f8427b;
                ArraysKt.fill(iArr2, 0, Math.max(0, iArr2.length - i6), this.f8427b.length);
            } else {
                int i7 = -i6;
                int[] iArr3 = this.f8427b;
                if (iArr3.length + i7 < 131072) {
                    b(iArr3.length + i7 + 1, i7);
                } else {
                    if (i7 < iArr3.length) {
                        ArraysKt.copyInto(iArr3, iArr3, i7, 0, iArr3.length - i7);
                    }
                    int[] iArr4 = this.f8427b;
                    ArraysKt.fill(iArr4, 0, 0, Math.min(iArr4.length, i7));
                }
            }
        } else {
            c(this, i5 + 1, 0, 2, null);
        }
        while (!this.f8428c.isEmpty() && ((SpannedItem) this.f8428c.first()).b() < i()) {
            this.f8428c.removeFirst();
        }
        while (!this.f8428c.isEmpty() && ((SpannedItem) this.f8428c.last()).b() > m()) {
            this.f8428c.removeLast();
        }
    }

    public final int e(int i3, int i4) {
        int iM = m();
        for (int i5 = i3 + 1; i5 < iM; i5++) {
            if (a(i5, i4)) {
                return i5;
            }
        }
        return m();
    }

    public final int f(int i3, int i4) {
        do {
            i3--;
            if (-1 >= i3) {
                return -1;
            }
        } while (!a(i3, i4));
        return i3;
    }

    public final int[] g(int i3) {
        ArrayDeque arrayDeque = this.f8428c;
        final Integer numValueOf = Integer.valueOf(i3);
        SpannedItem spannedItem = (SpannedItem) CollectionsKt.getOrNull(this.f8428c, CollectionsKt.binarySearch(arrayDeque, 0, arrayDeque.size(), new Function1<SpannedItem, Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(Object obj) {
                return Integer.valueOf(ComparisonsKt.d(Integer.valueOf(((LazyStaggeredGridLaneInfo.SpannedItem) obj).b()), numValueOf));
            }
        }));
        if (spannedItem != null) {
            return spannedItem.a();
        }
        return null;
    }

    public final int h(int i3) {
        if (i3 < i() || i3 >= m()) {
            return -1;
        }
        return this.f8427b[i3 - this.f8426a] - 1;
    }

    public final int i() {
        return this.f8426a;
    }

    public final void j() {
        ArraysKt.fill$default(this.f8427b, 0, 0, 0, 6, (Object) null);
        this.f8428c.clear();
    }

    public final void k(int i3, int[] iArr) {
        ArrayDeque arrayDeque = this.f8428c;
        final Integer numValueOf = Integer.valueOf(i3);
        int iBinarySearch = CollectionsKt.binarySearch(arrayDeque, 0, arrayDeque.size(), new Function1<SpannedItem, Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(Object obj) {
                return Integer.valueOf(ComparisonsKt.d(Integer.valueOf(((LazyStaggeredGridLaneInfo.SpannedItem) obj).b()), numValueOf));
            }
        });
        if (iBinarySearch < 0) {
            if (iArr == null) {
                return;
            }
            this.f8428c.add(-(iBinarySearch + 1), new SpannedItem(i3, iArr));
            return;
        }
        if (iArr == null) {
            this.f8428c.remove(iBinarySearch);
        } else {
            ((SpannedItem) this.f8428c.get(iBinarySearch)).c(iArr);
        }
    }

    public final void l(int i3, int i4) {
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("Negative lanes are not supported");
        }
        d(i3);
        this.f8427b[i3 - this.f8426a] = i4 + 1;
    }

    public final int m() {
        return this.f8426a + this.f8427b.length;
    }
}
