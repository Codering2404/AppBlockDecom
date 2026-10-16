package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class PointerInputChange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f26861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f26862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f26863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f26864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f26865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f26866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f26867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f26868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f26869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f26870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f26871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private PointerInputChange f26872o;

    public /* synthetic */ PointerInputChange(long j3, long j4, long j5, boolean z2, float f3, long j6, long j7, boolean z3, boolean z4, int i3, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, z2, f3, j6, j7, z3, z4, i3, j8);
    }

    public static /* synthetic */ PointerInputChange c(PointerInputChange pointerInputChange, long j3, long j4, long j5, boolean z2, long j6, long j7, boolean z3, int i3, List list, long j8, int i4, Object obj) {
        long j9;
        long j10 = (i4 & 1) != 0 ? pointerInputChange.f26858a : j3;
        long j11 = (i4 & 2) != 0 ? pointerInputChange.f26859b : j4;
        long j12 = (i4 & 4) != 0 ? pointerInputChange.f26860c : j5;
        boolean z4 = (i4 & 8) != 0 ? pointerInputChange.f26861d : z2;
        long j13 = (i4 & 16) != 0 ? pointerInputChange.f26863f : j6;
        long j14 = (i4 & 32) != 0 ? pointerInputChange.f26864g : j7;
        boolean z5 = (i4 & 64) != 0 ? pointerInputChange.f26865h : z3;
        int i5 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? pointerInputChange.f26866i : i3;
        if ((i4 & 512) != 0) {
            j9 = pointerInputChange.f26867j;
            j10 = j10;
        } else {
            j9 = j8;
        }
        return pointerInputChange.b(j10, j11, j12, z4, j13, j14, z5, i5, list, j9);
    }

    public final void a() {
        PointerInputChange pointerInputChange = this.f26872o;
        if (pointerInputChange == null) {
            this.f26870m = true;
            this.f26871n = true;
        } else if (pointerInputChange != null) {
            pointerInputChange.a();
        }
    }

    public final PointerInputChange b(long j3, long j4, long j5, boolean z2, long j6, long j7, boolean z3, int i3, List list, long j8) {
        PointerInputChange pointerInputChangeD = d(j3, j4, j5, z2, this.f26862e, j6, j7, z3, i3, list, j8);
        PointerInputChange pointerInputChange = this.f26872o;
        if (pointerInputChange == null) {
            pointerInputChange = this;
        }
        pointerInputChangeD.f26872o = pointerInputChange;
        return pointerInputChangeD;
    }

    public final PointerInputChange d(long j3, long j4, long j5, boolean z2, float f3, long j6, long j7, boolean z3, int i3, List list, long j8) {
        PointerInputChange pointerInputChange = new PointerInputChange(j3, j4, j5, z2, f3, j6, j7, z3, false, i3, list, j8, this.f26869l, null);
        PointerInputChange pointerInputChange2 = this.f26872o;
        if (pointerInputChange2 == null) {
            pointerInputChange2 = this;
        }
        pointerInputChange.f26872o = pointerInputChange2;
        return pointerInputChange;
    }

    public final List e() {
        List list = this.f26868k;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final long f() {
        return this.f26858a;
    }

    public final long g() {
        return this.f26869l;
    }

    public final long h() {
        return this.f26860c;
    }

    public final boolean i() {
        return this.f26861d;
    }

    public final float j() {
        return this.f26862e;
    }

    public final long k() {
        return this.f26864g;
    }

    public final boolean l() {
        return this.f26865h;
    }

    public final long m() {
        return this.f26867j;
    }

    public final int n() {
        return this.f26866i;
    }

    public final long o() {
        return this.f26859b;
    }

    public final boolean p() {
        PointerInputChange pointerInputChange = this.f26872o;
        return pointerInputChange != null ? pointerInputChange.p() : this.f26870m || this.f26871n;
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.e(this.f26858a)) + ", uptimeMillis=" + this.f26859b + ", position=" + ((Object) Offset.s(this.f26860c)) + ", pressed=" + this.f26861d + ", pressure=" + this.f26862e + ", previousUptimeMillis=" + this.f26863f + ", previousPosition=" + ((Object) Offset.s(this.f26864g)) + ", previousPressed=" + this.f26865h + ", isConsumed=" + p() + ", type=" + ((Object) PointerType.j(this.f26866i)) + ", historical=" + e() + ",scrollDelta=" + ((Object) Offset.s(this.f26867j)) + ')';
    }

    public /* synthetic */ PointerInputChange(long j3, long j4, long j5, boolean z2, float f3, long j6, long j7, boolean z3, boolean z4, int i3, List list, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, z2, f3, j6, j7, z3, z4, i3, list, j8, j9);
    }

    private PointerInputChange(long j3, long j4, long j5, boolean z2, float f3, long j6, long j7, boolean z3, boolean z4, int i3, long j8) {
        this.f26858a = j3;
        this.f26859b = j4;
        this.f26860c = j5;
        this.f26861d = z2;
        this.f26862e = f3;
        this.f26863f = j6;
        this.f26864g = j7;
        this.f26865h = z3;
        this.f26866i = i3;
        this.f26867j = j8;
        this.f26869l = Offset.f25596b.c();
        this.f26870m = z4;
        this.f26871n = z4;
    }

    public /* synthetic */ PointerInputChange(long j3, long j4, long j5, boolean z2, float f3, long j6, long j7, boolean z3, boolean z4, int i3, long j8, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, z2, f3, j6, j7, z3, z4, (i4 & 512) != 0 ? PointerType.f26922b.d() : i3, (i4 & 1024) != 0 ? Offset.f25596b.c() : j8, null);
    }

    private PointerInputChange(long j3, long j4, long j5, boolean z2, float f3, long j6, long j7, boolean z3, boolean z4, int i3, List list, long j8, long j9) {
        this(j3, j4, j5, z2, f3, j6, j7, z3, z4, i3, j8, null);
        this.f26868k = list;
        this.f26869l = j9;
    }
}
