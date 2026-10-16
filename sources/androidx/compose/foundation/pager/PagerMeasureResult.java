package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f8809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Orientation f8813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f8816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f8817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MeasuredPage f8818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MeasuredPage f8819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f8820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f8821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f8822n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SnapPosition f8823o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MeasureResult f8824p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f8825q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final List f8826r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final List f8827s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final CoroutineScope f8828t;

    public PagerMeasureResult(List list, int i3, int i4, int i5, Orientation orientation, int i6, int i7, boolean z2, int i8, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f3, int i9, boolean z3, SnapPosition snapPosition, MeasureResult measureResult, boolean z4, List list2, List list3, CoroutineScope coroutineScope) {
        this.f8809a = list;
        this.f8810b = i3;
        this.f8811c = i4;
        this.f8812d = i5;
        this.f8813e = orientation;
        this.f8814f = i6;
        this.f8815g = i7;
        this.f8816h = z2;
        this.f8817i = i8;
        this.f8818j = measuredPage;
        this.f8819k = measuredPage2;
        this.f8820l = f3;
        this.f8821m = i9;
        this.f8822n = z3;
        this.f8823o = snapPosition;
        this.f8824p = measureResult;
        this.f8825q = z4;
        this.f8826r = list2;
        this.f8827s = list3;
        this.f8828t = coroutineScope;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void A() {
        this.f8824p.A();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1 B() {
        return this.f8824p.B();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int C() {
        return this.f8811c;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int D() {
        return this.f8817i;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition E() {
        return this.f8823o;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public long a() {
        return IntSize.c((((long) getHeight()) & 4294967295L) | (((long) getWidth()) << 32));
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int b() {
        return this.f8812d;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int c() {
        return -g();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int d() {
        return this.f8815g;
    }

    public final PagerMeasureResult e(int i3) {
        int i4;
        int iW = w() + C();
        if (!this.f8825q && !y().isEmpty() && this.f8818j != null && (i4 = this.f8821m - i3) >= 0 && i4 < iW) {
            float f3 = iW != 0 ? i3 / iW : 0.0f;
            float f4 = this.f8820l - f3;
            if (this.f8819k != null && f4 < 0.5f && f4 > -0.5f) {
                MeasuredPage measuredPage = (MeasuredPage) CollectionsKt.first(y());
                MeasuredPage measuredPage2 = (MeasuredPage) CollectionsKt.last(y());
                if (i3 >= 0 ? Math.min(g() - measuredPage.getOffset(), d() - measuredPage2.getOffset()) > i3 : Math.min((measuredPage.getOffset() + iW) - g(), (measuredPage2.getOffset() + iW) - d()) > (-i3)) {
                    List listY = y();
                    int size = listY.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((MeasuredPage) listY.get(i5)).a(i3);
                    }
                    List list = this.f8826r;
                    int size2 = list.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        ((MeasuredPage) list.get(i6)).a(i3);
                    }
                    List list2 = this.f8827s;
                    int size3 = list2.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        ((MeasuredPage) list2.get(i7)).a(i3);
                    }
                    return new PagerMeasureResult(y(), w(), C(), b(), getOrientation(), g(), d(), x(), D(), this.f8818j, this.f8819k, this.f8820l - f3, this.f8821m - i3, this.f8822n || i3 > 0, E(), this.f8824p, this.f8825q, this.f8826r, this.f8827s, this.f8828t);
                }
            }
        }
        return null;
    }

    public final boolean f() {
        MeasuredPage measuredPage = this.f8818j;
        return ((measuredPage != null ? measuredPage.getIndex() : 0) == 0 && this.f8821m == 0) ? false : true;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int g() {
        return this.f8814f;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.f8824p.getHeight();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.f8813e;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.f8824p.getWidth();
    }

    public final boolean h() {
        return this.f8822n;
    }

    public final CoroutineScope i() {
        return this.f8828t;
    }

    public final MeasuredPage j() {
        return this.f8819k;
    }

    public final float k() {
        return this.f8820l;
    }

    public final MeasuredPage l() {
        return this.f8818j;
    }

    public final int m() {
        return this.f8821m;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int w() {
        return this.f8810b;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean x() {
        return this.f8816h;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List y() {
        return this.f8809a;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map z() {
        return this.f8824p.z();
    }

    public /* synthetic */ PagerMeasureResult(List list, int i3, int i4, int i5, Orientation orientation, int i6, int i7, boolean z2, int i8, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f3, int i9, boolean z3, SnapPosition snapPosition, MeasureResult measureResult, boolean z4, List list2, List list3, CoroutineScope coroutineScope, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i3, i4, i5, orientation, i6, i7, z2, i8, measuredPage, measuredPage2, f3, i9, z3, snapPosition, measureResult, z4, (i10 & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i10 & 262144) != 0 ? CollectionsKt.emptyList() : list3, coroutineScope);
    }
}
