package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyStaggeredGridMeasureContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyStaggeredGridState f8433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f8434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyStaggeredGridItemProvider f8435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyStaggeredGridSlots f8436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f8437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f8438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LazyLayoutMeasureScope f8439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f8441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f8444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f8445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CoroutineScope f8446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f8447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f8448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LazyStaggeredGridLayoutInfo f8449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final GraphicsContext f8450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final LazyStaggeredGridMeasureProvider f8451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LazyStaggeredGridLaneInfo f8452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f8453u;

    public /* synthetic */ LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j3, boolean z2, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i3, long j4, int i4, int i5, boolean z3, int i6, CoroutineScope coroutineScope, boolean z4, boolean z5, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j3, z2, lazyLayoutMeasureScope, i3, j4, i4, i5, z3, i6, coroutineScope, z4, z5, lazyStaggeredGridLayoutInfo, graphicsContext);
    }

    public final int a() {
        return this.f8443k;
    }

    public final LazyStaggeredGridLayoutInfo b() {
        return this.f8449q;
    }

    public final int c() {
        return this.f8442j;
    }

    public final long d() {
        return this.f8437e;
    }

    public final long e() {
        return this.f8441i;
    }

    public final CoroutineScope f() {
        return this.f8446n;
    }

    public final GraphicsContext g() {
        return this.f8450r;
    }

    public final LazyStaggeredGridItemProvider h() {
        return this.f8435c;
    }

    public final int i() {
        return this.f8453u;
    }

    public final LazyStaggeredGridLaneInfo j() {
        return this.f8452t;
    }

    public final int k() {
        return this.f8440h;
    }

    public final int l() {
        return this.f8445m;
    }

    public final LazyLayoutMeasureScope m() {
        return this.f8439g;
    }

    public final LazyStaggeredGridMeasureProvider n() {
        return this.f8451s;
    }

    public final List o() {
        return this.f8434b;
    }

    public final LazyStaggeredGridSlots p() {
        return this.f8436d;
    }

    public final boolean q() {
        return this.f8444l;
    }

    public final long r(LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, int i3, int i4) {
        boolean zA = lazyStaggeredGridItemProvider.h().a(i3);
        int i5 = zA ? this.f8453u : 1;
        if (zA) {
            i4 = 0;
        }
        return SpanRange.a(i4, i5);
    }

    public final LazyStaggeredGridState s() {
        return this.f8433a;
    }

    public final boolean t(LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, int i3) {
        return lazyStaggeredGridItemProvider.h().a(i3);
    }

    public final boolean u() {
        return this.f8447o;
    }

    public final boolean v() {
        return this.f8438f;
    }

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List list, final LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, final LazyStaggeredGridSlots lazyStaggeredGridSlots, long j3, final boolean z2, final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i3, long j4, int i4, int i5, boolean z3, int i6, CoroutineScope coroutineScope, boolean z4, boolean z5, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        this.f8433a = lazyStaggeredGridState;
        this.f8434b = list;
        this.f8435c = lazyStaggeredGridItemProvider;
        this.f8436d = lazyStaggeredGridSlots;
        this.f8437e = j3;
        this.f8438f = z2;
        this.f8439g = lazyLayoutMeasureScope;
        this.f8440h = i3;
        this.f8441i = j4;
        this.f8442j = i4;
        this.f8443k = i5;
        this.f8444l = z3;
        this.f8445m = i6;
        this.f8446n = coroutineScope;
        this.f8447o = z4;
        this.f8448p = z5;
        this.f8449q = lazyStaggeredGridLayoutInfo;
        this.f8450r = graphicsContext;
        this.f8451s = new LazyStaggeredGridMeasureProvider(z2, lazyStaggeredGridItemProvider, lazyLayoutMeasureScope, lazyStaggeredGridSlots) { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext$measuredItemProvider$1
            @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider
            public LazyStaggeredGridMeasuredItem c(int i7, int i8, int i9, Object obj, Object obj2, List list2, long j5) {
                return new LazyStaggeredGridMeasuredItem(i7, obj, list2, this.f8454e.v(), this.f8454e.l(), i8, i9, this.f8454e.c(), this.f8454e.a(), obj2, this.f8454e.s().v(), j5, null);
            }
        };
        this.f8452t = lazyStaggeredGridState.x();
        this.f8453u = lazyStaggeredGridSlots.b().length;
    }
}
