package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class LazyGridSpanLayoutProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyGridIntervalContent f7888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f7889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f7894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f7895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7896i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LazyGridItemSpanScopeImpl f7899a = new LazyGridItemSpanScopeImpl();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static int f7900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static int f7901c;

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int a() {
            return f7901c;
        }

        public void b(int i3) {
            f7900b = i3;
        }

        public void c(int i3) {
            f7901c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LineConfiguration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f7903b;

        public LineConfiguration(int i3, List list) {
            this.f7902a = i3;
            this.f7903b = list;
        }

        public final int a() {
            return this.f7902a;
        }

        public final List b() {
            return this.f7903b;
        }
    }

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent lazyGridIntervalContent) {
        this.f7888a = lazyGridIntervalContent;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        arrayList.add(new Bucket(i3, i3, 2, null));
        this.f7889b = arrayList;
        this.f7893f = -1;
        this.f7894g = new ArrayList();
        this.f7895h = CollectionsKt.emptyList();
    }

    private final int a() {
        return ((int) Math.sqrt((((double) f()) * 1.0d) / ((double) this.f7896i))) + 1;
    }

    private final List b(int i3) {
        if (i3 == this.f7895h.size()) {
            return this.f7895h;
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(GridItemSpan.a(LazyGridSpanKt.a(1)));
        }
        this.f7895h = arrayList;
        return arrayList;
    }

    private final void g() {
        this.f7889b.clear();
        int i3 = 0;
        this.f7889b.add(new Bucket(i3, i3, 2, null));
        this.f7890c = 0;
        this.f7891d = 0;
        this.f7892e = 0;
        this.f7893f = -1;
        this.f7894g.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration c(int r11) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.c(int):androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration");
    }

    public final int d(final int i3) {
        int i4 = 0;
        if (f() <= 0) {
            return 0;
        }
        if (!(i3 < f())) {
            InlineClassHelperKt.a("ItemIndex > total count");
        }
        if (!this.f7888a.m()) {
            return i3 / this.f7896i;
        }
        int iBinarySearch$default = CollectionsKt.binarySearch$default(this.f7889b, 0, 0, new Function1<Bucket, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(LazyGridSpanLayoutProvider.Bucket bucket) {
                return Integer.valueOf(bucket.a() - i3);
            }
        }, 3, (Object) null);
        int i5 = 2;
        if (iBinarySearch$default < 0) {
            iBinarySearch$default = (-iBinarySearch$default) - 2;
        }
        int iA = a() * iBinarySearch$default;
        int iA2 = ((Bucket) this.f7889b.get(iBinarySearch$default)).a();
        if (!(iA2 <= i3)) {
            InlineClassHelperKt.a("currentItemIndex > itemIndex");
        }
        int i6 = 0;
        while (iA2 < i3) {
            int i7 = iA2 + 1;
            int i8 = i(iA2, this.f7896i - i6);
            i6 += i8;
            int i9 = this.f7896i;
            if (i6 >= i9) {
                if (i6 == i9) {
                    iA++;
                    i6 = 0;
                } else {
                    iA++;
                    i6 = i8;
                }
            }
            if (iA % a() == 0 && iA / a() >= this.f7889b.size()) {
                this.f7889b.add(new Bucket(i7 - (i6 > 0 ? 1 : 0), i4, i5, null));
            }
            iA2 = i7;
        }
        return i6 + i(i3, this.f7896i - i6) > this.f7896i ? iA + 1 : iA;
    }

    public final int e() {
        return this.f7896i;
    }

    public final int f() {
        return this.f7888a.j().getSize();
    }

    public final void h(int i3) {
        if (i3 != this.f7896i) {
            this.f7896i = i3;
            g();
        }
    }

    public final int i(int i3, int i4) {
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.f7899a;
        lazyGridItemSpanScopeImpl.b(i4);
        lazyGridItemSpanScopeImpl.c(this.f7896i);
        IntervalList.Interval interval = this.f7888a.j().get(i3);
        return GridItemSpan.d(((GridItemSpan) ((LazyGridInterval) interval.c()).b().invoke(lazyGridItemSpanScopeImpl, Integer.valueOf(i3 - interval.b()))).g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Bucket {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f7898b;

        public Bucket(int i3, int i4) {
            this.f7897a = i3;
            this.f7898b = i4;
        }

        public final int a() {
            return this.f7897a;
        }

        public final int b() {
            return this.f7898b;
        }

        public /* synthetic */ Bucket(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i5 & 2) != 0 ? 0 : i4);
        }
    }
}
