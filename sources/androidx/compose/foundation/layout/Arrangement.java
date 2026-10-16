package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class Arrangement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Arrangement f6574a = new Arrangement();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Horizontal f6575b = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.f30001a) {
                Arrangement.f6574a.j(iArr, iArr2, false);
            } else {
                Arrangement.f6574a.k(i3, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Horizontal f6576c = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.f30001a) {
                Arrangement.f6574a.k(i3, iArr, iArr2, false);
            } else {
                Arrangement.f6574a.j(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Vertical f6577d = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            Arrangement.f6574a.j(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Vertical f6578e = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            Arrangement.f6574a.k(i3, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HorizontalOrVertical f6579f = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6593a = Dp.g(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        public float a() {
            return this.f6593a;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            Arrangement.f6574a.i(i3, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.f30001a) {
                Arrangement.f6574a.i(i3, iArr, iArr2, false);
            } else {
                Arrangement.f6574a.i(i3, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Center";
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HorizontalOrVertical f6580g = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6596a = Dp.g(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        public float a() {
            return this.f6596a;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            Arrangement.f6574a.n(i3, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.f30001a) {
                Arrangement.f6574a.n(i3, iArr, iArr2, false);
            } else {
                Arrangement.f6574a.n(i3, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HorizontalOrVertical f6581h = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6595a = Dp.g(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        public float a() {
            return this.f6595a;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            Arrangement.f6574a.m(i3, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.f30001a) {
                Arrangement.f6574a.m(i3, iArr, iArr2, false);
            } else {
                Arrangement.f6574a.m(i3, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HorizontalOrVertical f6582i = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6594a = Dp.g(0);

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        public float a() {
            return this.f6594a;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            Arrangement.f6574a.l(i3, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.f30001a) {
                Arrangement.f6574a.l(i3, iArr, iArr2, false);
            } else {
                Arrangement.f6574a.l(i3, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Absolute {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Absolute f6583a = new Absolute();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Horizontal f6584b = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Left$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.f6574a.j(iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Horizontal f6585c = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.f6574a.i(i3, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Horizontal f6586d = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Right$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.f6574a.k(i3, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Horizontal f6587e = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceBetween$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.f6574a.m(i3, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Horizontal f6588f = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceEvenly$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.f6574a.n(i3, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        };

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Horizontal f6589g = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceAround$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.f6574a.l(i3, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        };

        private Absolute() {
        }

        public final Horizontal a() {
            return f6584b;
        }

        public final Horizontal b() {
            return f6586d;
        }

        public final Horizontal c() {
            return f6587e;
        }

        public final Horizontal d() {
            return f6588f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final HorizontalOrVertical e(float f3) {
            return new SpacedAligned(f3, false, null, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Horizontal {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        default float a() {
            return Dp.g(0);
        }

        void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        default float a() {
            return Dp.g(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SpacedAligned implements HorizontalOrVertical {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function2 f6599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f6600d;

        public /* synthetic */ SpacedAligned(float f3, boolean z2, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, z2, function2);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        public float a() {
            return this.f6600d;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void b(Density density, int i3, int[] iArr, int[] iArr2) {
            c(density, i3, iArr, LayoutDirection.f30001a, iArr2);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void c(Density density, int i3, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i4;
            int iMin;
            if (iArr.length == 0) {
                return;
            }
            int iZ0 = density.z0(this.f6597a);
            boolean z2 = this.f6598b && layoutDirection == LayoutDirection.f30002b;
            Arrangement arrangement = Arrangement.f6574a;
            if (z2) {
                i4 = 0;
                iMin = 0;
                for (int length = iArr.length - 1; -1 < length; length--) {
                    int i5 = iArr[length];
                    int iMin2 = Math.min(i4, i3 - i5);
                    iArr2[length] = iMin2;
                    iMin = Math.min(iZ0, (i3 - iMin2) - i5);
                    i4 = iArr2[length] + i5 + iMin;
                }
            } else {
                int length2 = iArr.length;
                int i6 = 0;
                i4 = 0;
                iMin = 0;
                int i7 = 0;
                while (i6 < length2) {
                    int i8 = iArr[i6];
                    int iMin3 = Math.min(i4, i3 - i8);
                    iArr2[i7] = iMin3;
                    int iMin4 = Math.min(iZ0, (i3 - iMin3) - i8);
                    int i9 = iArr2[i7] + i8 + iMin4;
                    i6++;
                    iMin = iMin4;
                    i4 = i9;
                    i7++;
                }
            }
            int i10 = i4 - iMin;
            Function2 function2 = this.f6599c;
            if (function2 == null || i10 >= i3) {
                return;
            }
            int iIntValue = ((Number) function2.invoke(Integer.valueOf(i3 - i10), layoutDirection)).intValue();
            int length3 = iArr2.length;
            for (int i11 = 0; i11 < length3; i11++) {
                iArr2[i11] = iArr2[i11] + iIntValue;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.i(this.f6597a, spacedAligned.f6597a) && this.f6598b == spacedAligned.f6598b && Intrinsics.areEqual(this.f6599c, spacedAligned.f6599c);
        }

        public int hashCode() {
            int iJ = ((Dp.j(this.f6597a) * 31) + Boolean.hashCode(this.f6598b)) * 31;
            Function2 function2 = this.f6599c;
            return iJ + (function2 == null ? 0 : function2.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6598b ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.k(this.f6597a));
            sb.append(", ");
            sb.append(this.f6599c);
            sb.append(')');
            return sb.toString();
        }

        private SpacedAligned(float f3, boolean z2, Function2 function2) {
            this.f6597a = f3;
            this.f6598b = z2;
            this.f6599c = function2;
            this.f6600d = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Vertical {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        default float a() {
            return Dp.g(0);
        }

        void b(Density density, int i3, int[] iArr, int[] iArr2);
    }

    private Arrangement() {
    }

    public final Vertical a() {
        return f6578e;
    }

    public final HorizontalOrVertical b() {
        return f6579f;
    }

    public final Horizontal c() {
        return f6576c;
    }

    public final HorizontalOrVertical d() {
        return f6582i;
    }

    public final HorizontalOrVertical e() {
        return f6581h;
    }

    public final HorizontalOrVertical f() {
        return f6580g;
    }

    public final Horizontal g() {
        return f6575b;
    }

    public final Vertical h() {
        return f6577d;
    }

    public final void i(int i3, int[] iArr, int[] iArr2, boolean z2) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        float f3 = (i3 - i5) / 2;
        if (!z2) {
            int length = iArr.length;
            int i7 = 0;
            while (i4 < length) {
                int i8 = iArr[i4];
                iArr2[i7] = Math.round(f3);
                f3 += i8;
                i4++;
                i7++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i9 = iArr[length2];
            iArr2[length2] = Math.round(f3);
            f3 += i9;
        }
    }

    public final void j(int[] iArr, int[] iArr2, boolean z2) {
        int i3 = 0;
        if (!z2) {
            int length = iArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                int i6 = iArr[i3];
                iArr2[i4] = i5;
                i5 += i6;
                i3++;
                i4++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = i3;
            i3 += i7;
        }
    }

    public final void k(int i3, int[] iArr, int[] iArr2, boolean z2) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        int i7 = i3 - i5;
        if (!z2) {
            int length = iArr.length;
            int i8 = 0;
            while (i4 < length) {
                int i9 = iArr[i4];
                iArr2[i8] = i7;
                i7 += i9;
                i4++;
                i8++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i10 = iArr[length2];
            iArr2[length2] = i7;
            i7 += i10;
        }
    }

    public final void l(int i3, int[] iArr, int[] iArr2, boolean z2) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        float length = !(iArr.length == 0) ? (i3 - i5) / iArr.length : 0.0f;
        float f3 = length / 2;
        if (z2) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i7 = iArr[length2];
                iArr2[length2] = Math.round(f3);
                f3 += i7 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i8 = 0;
        while (i4 < length3) {
            int i9 = iArr[i4];
            iArr2[i8] = Math.round(f3);
            f3 += i9 + length;
            i4++;
            i8++;
        }
    }

    public final void m(int i3, int[] iArr, int[] iArr2, boolean z2) {
        if (iArr.length == 0) {
            return;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        float fMax = (i3 - i5) / Math.max(ArraysKt.getLastIndex(iArr), 1);
        float f3 = (z2 && iArr.length == 1) ? fMax : 0.0f;
        if (z2) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i7 = iArr[length];
                iArr2[length] = Math.round(f3);
                f3 += i7 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i8 = 0;
        while (i4 < length2) {
            int i9 = iArr[i4];
            iArr2[i8] = Math.round(f3);
            f3 += i9 + fMax;
            i4++;
            i8++;
        }
    }

    public final void n(int i3, int[] iArr, int[] iArr2, boolean z2) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        float length = (i3 - i5) / (iArr.length + 1);
        if (z2) {
            float f3 = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i7 = iArr[length2];
                iArr2[length2] = Math.round(f3);
                f3 += i7 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f4 = length;
        int i8 = 0;
        while (i4 < length3) {
            int i9 = iArr[i4];
            iArr2[i8] = Math.round(f4);
            f4 += i9 + length;
            i4++;
            i8++;
        }
    }

    public final HorizontalOrVertical o(float f3) {
        return new SpacedAligned(f3, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$1
            public final Integer c(int i3, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.f25072a.k().a(0, i3, layoutDirection));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Number) obj).intValue(), (LayoutDirection) obj2);
            }
        }, null);
    }

    public final Horizontal p(float f3, final Alignment.Horizontal horizontal) {
        return new SpacedAligned(f3, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$2
            {
                super(2);
            }

            public final Integer c(int i3, LayoutDirection layoutDirection) {
                return Integer.valueOf(horizontal.a(0, i3, layoutDirection));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Number) obj).intValue(), (LayoutDirection) obj2);
            }
        }, null);
    }

    public final Vertical q(float f3, final Alignment.Vertical vertical) {
        return new SpacedAligned(f3, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$3
            {
                super(2);
            }

            public final Integer c(int i3, LayoutDirection layoutDirection) {
                return Integer.valueOf(vertical.a(0, i3));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Number) obj).intValue(), (LayoutDirection) obj2);
            }
        }, null);
    }
}
