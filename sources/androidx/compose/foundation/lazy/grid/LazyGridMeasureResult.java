package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyGridMeasuredLine f7817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f7820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MeasureResult f7821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f7822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineScope f7824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Density f7825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f7826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1 f7827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f7828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f7829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f7830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f7831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f7832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Orientation f7833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f7834r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f7835s;

    public LazyGridMeasureResult(LazyGridMeasuredLine lazyGridMeasuredLine, int i3, boolean z2, float f3, MeasureResult measureResult, float f4, boolean z3, CoroutineScope coroutineScope, Density density, int i4, Function1 function1, List list, int i5, int i6, int i7, boolean z4, Orientation orientation, int i8, int i9) {
        this.f7817a = lazyGridMeasuredLine;
        this.f7818b = i3;
        this.f7819c = z2;
        this.f7820d = f3;
        this.f7821e = measureResult;
        this.f7822f = f4;
        this.f7823g = z3;
        this.f7824h = coroutineScope;
        this.f7825i = density;
        this.f7826j = i4;
        this.f7827k = function1;
        this.f7828l = list;
        this.f7829m = i5;
        this.f7830n = i6;
        this.f7831o = i7;
        this.f7832p = z4;
        this.f7833q = orientation;
        this.f7834r = i8;
        this.f7835s = i9;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void A() {
        this.f7821e.A();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1 B() {
        return this.f7821e.B();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public long a() {
        return IntSize.c((((long) getHeight()) & 4294967295L) | (((long) getWidth()) << 32));
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int b() {
        return this.f7834r;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int c() {
        return -g();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int d() {
        return this.f7830n;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int e() {
        return this.f7831o;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int f() {
        return this.f7835s;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int g() {
        return this.f7829m;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.f7821e.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.f7833q;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.f7821e.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public List h() {
        return this.f7828l;
    }

    public final LazyGridMeasureResult i(int i3, boolean z2) {
        LazyGridMeasuredLine lazyGridMeasuredLine;
        if (!this.f7823g && !h().isEmpty() && (lazyGridMeasuredLine = this.f7817a) != null) {
            int iD = lazyGridMeasuredLine.d();
            int i4 = this.f7818b - i3;
            if (i4 >= 0 && i4 < iD) {
                LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.first(h());
                LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) CollectionsKt.last(h());
                if (!lazyGridMeasuredItem.h() && !lazyGridMeasuredItem2.h() && (i3 >= 0 ? Math.min(g() - LazyGridSnapLayoutInfoProviderKt.b(lazyGridMeasuredItem, getOrientation()), d() - LazyGridSnapLayoutInfoProviderKt.b(lazyGridMeasuredItem2, getOrientation())) > i3 : Math.min((LazyGridSnapLayoutInfoProviderKt.b(lazyGridMeasuredItem, getOrientation()) + lazyGridMeasuredItem.m()) - g(), (LazyGridSnapLayoutInfoProviderKt.b(lazyGridMeasuredItem2, getOrientation()) + lazyGridMeasuredItem2.m()) - d()) > (-i3))) {
                    List listH = h();
                    int size = listH.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((LazyGridMeasuredItem) listH.get(i5)).p(i3, z2);
                    }
                    return new LazyGridMeasureResult(this.f7817a, this.f7818b - i3, this.f7819c || i3 > 0, i3, this.f7821e, this.f7822f, this.f7823g, this.f7824h, this.f7825i, this.f7826j, this.f7827k, h(), g(), d(), e(), r(), getOrientation(), b(), f());
                }
            }
        }
        return null;
    }

    public final boolean j() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.f7817a;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.a() : 0) == 0 && this.f7818b == 0) ? false : true;
    }

    public final boolean k() {
        return this.f7819c;
    }

    public final float l() {
        return this.f7820d;
    }

    public final CoroutineScope m() {
        return this.f7824h;
    }

    public final Density n() {
        return this.f7825i;
    }

    public final LazyGridMeasuredLine o() {
        return this.f7817a;
    }

    public final int p() {
        return this.f7818b;
    }

    public final Function1 q() {
        return this.f7827k;
    }

    public boolean r() {
        return this.f7832p;
    }

    public final float s() {
        return this.f7822f;
    }

    public final int t() {
        return this.f7826j;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map z() {
        return this.f7821e.z();
    }
}
