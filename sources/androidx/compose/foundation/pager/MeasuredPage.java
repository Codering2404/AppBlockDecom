package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
public final class MeasuredPage implements PageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f8649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f8650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f8651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Alignment.Horizontal f8652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Alignment.Vertical f8653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LayoutDirection f8654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f8655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f8656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int[] f8658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8660n;

    public /* synthetic */ MeasuredPage(int i3, int i4, List list, long j3, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, list, j3, obj, orientation, horizontal, vertical, layoutDirection, z2);
    }

    private final int d(Placeable placeable) {
        return this.f8656j ? placeable.O0() : placeable.X0();
    }

    private final long e(int i3) {
        int[] iArr = this.f8658l;
        int i4 = i3 * 2;
        return IntOffset.f((((long) iArr[i4]) << 32) | (((long) iArr[i4 + 1]) & 4294967295L));
    }

    public final void a(int i3) {
        this.f8659m = getOffset() + i3;
        int length = this.f8658l.length;
        for (int i4 = 0; i4 < length; i4++) {
            boolean z2 = this.f8656j;
            if ((z2 && i4 % 2 == 1) || (!z2 && i4 % 2 == 0)) {
                int[] iArr = this.f8658l;
                iArr[i4] = iArr[i4] + i3;
            }
        }
    }

    public final int b() {
        return this.f8657k;
    }

    public Object c() {
        return this.f8651e;
    }

    public final int f() {
        return this.f8648b;
    }

    public final void g(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        int i3 = 0;
        if (!(this.f8660n != Integer.MIN_VALUE)) {
            InlineClassHelperKt.a("position() should be called first");
        }
        int size = this.f8649c.size();
        while (i3 < size) {
            Placeable placeable = (Placeable) this.f8649c.get(i3);
            long jE = e(i3);
            if (this.f8655i) {
                jE = IntOffset.f((((long) (this.f8656j ? IntOffset.k(jE) : (this.f8660n - IntOffset.k(jE)) - d(placeable))) << 32) | (((long) (this.f8656j ? (this.f8660n - IntOffset.l(jE)) - d(placeable) : IntOffset.l(jE))) & 4294967295L));
            }
            long jO = IntOffset.o(jE, this.f8650d);
            if (this.f8656j) {
                placementScope2 = placementScope;
                Placeable.PlacementScope.z(placementScope2, placeable, jO, 0.0f, null, 6, null);
            } else {
                placementScope2 = placementScope;
                Placeable.PlacementScope.t(placementScope2, placeable, jO, 0.0f, null, 6, null);
            }
            i3++;
            placementScope = placementScope2;
        }
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.f8647a;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.f8659m;
    }

    public final void h(int i3, int i4, int i5) {
        int iX0;
        this.f8659m = i3;
        this.f8660n = this.f8656j ? i5 : i4;
        List list = this.f8649c;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            int i7 = i6 * 2;
            if (this.f8656j) {
                int[] iArr = this.f8658l;
                Alignment.Horizontal horizontal = this.f8652f;
                if (horizontal == null) {
                    InlineClassHelperKt.b("null horizontalAlignment");
                    throw new KotlinNothingValueException();
                }
                iArr[i7] = horizontal.a(placeable.X0(), i4, this.f8654h);
                this.f8658l[i7 + 1] = i3;
                iX0 = placeable.O0();
            } else {
                int[] iArr2 = this.f8658l;
                iArr2[i7] = i3;
                int i8 = i7 + 1;
                Alignment.Vertical vertical = this.f8653g;
                if (vertical == null) {
                    InlineClassHelperKt.b("null verticalAlignment");
                    throw new KotlinNothingValueException();
                }
                iArr2[i8] = vertical.a(placeable.O0(), i5);
                iX0 = placeable.X0();
            }
            i3 += iX0;
        }
    }

    private MeasuredPage(int i3, int i4, List list, long j3, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2) {
        this.f8647a = i3;
        this.f8648b = i4;
        this.f8649c = list;
        this.f8650d = j3;
        this.f8651e = obj;
        this.f8652f = horizontal;
        this.f8653g = vertical;
        this.f8654h = layoutDirection;
        this.f8655i = z2;
        this.f8656j = orientation == Orientation.f6031a;
        int size = list.size();
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            iMax = Math.max(iMax, !this.f8656j ? placeable.O0() : placeable.X0());
        }
        this.f8657k = iMax;
        this.f8658l = new int[this.f8649c.size() * 2];
        this.f8660n = Integer.MIN_VALUE;
    }
}
