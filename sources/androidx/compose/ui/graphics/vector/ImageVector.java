package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public final class ImageVector {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f26323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f26324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f26325m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f26327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f26328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f26329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f26330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VectorGroup f26331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f26332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f26333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f26334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f26335j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f26337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f26341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f26342g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f26343h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ArrayList f26344i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private GroupParams f26345j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f26346k;

        public /* synthetic */ Builder(String str, float f3, float f4, float f5, float f6, long j3, int i3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f3, f4, f5, f6, j3, i3, z2);
        }

        public static /* synthetic */ Builder b(Builder builder, String str, float f3, float f4, float f5, float f6, float f7, float f8, float f9, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = "";
            }
            if ((i3 & 2) != 0) {
                f3 = 0.0f;
            }
            if ((i3 & 4) != 0) {
                f4 = 0.0f;
            }
            if ((i3 & 8) != 0) {
                f5 = 0.0f;
            }
            if ((i3 & 16) != 0) {
                f6 = 1.0f;
            }
            if ((i3 & 32) != 0) {
                f7 = 1.0f;
            }
            if ((i3 & 64) != 0) {
                f8 = 0.0f;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                f9 = 0.0f;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                list = VectorKt.e();
            }
            float f10 = f9;
            List list2 = list;
            float f11 = f8;
            float f12 = f6;
            return builder.a(str, f3, f4, f5, f12, f7, f11, f10, list2);
        }

        private final VectorGroup e(GroupParams groupParams) {
            return new VectorGroup(groupParams.c(), groupParams.f(), groupParams.d(), groupParams.e(), groupParams.g(), groupParams.h(), groupParams.i(), groupParams.j(), groupParams.b(), groupParams.a());
        }

        private final void h() {
            if (this.f26346k) {
                InlineClassHelperKt.c("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
        }

        private final GroupParams i() {
            return (GroupParams) ImageVectorKt.d(this.f26344i);
        }

        public final Builder a(String str, float f3, float f4, float f5, float f6, float f7, float f8, float f9, List list) {
            h();
            ImageVectorKt.f(this.f26344i, new GroupParams(str, f3, f4, f5, f6, f7, f8, f9, list, null, 512, null));
            return this;
        }

        public final Builder c(List list, int i3, String str, Brush brush, float f3, Brush brush2, float f4, float f5, int i4, int i5, float f6, float f7, float f8, float f9) {
            h();
            i().a().add(new VectorPath(str, list, i3, brush, f3, brush2, f4, f5, i4, i5, f6, f7, f8, f9, null));
            return this;
        }

        public final ImageVector f() {
            h();
            while (this.f26344i.size() > 1) {
                g();
            }
            ImageVector imageVector = new ImageVector(this.f26336a, this.f26337b, this.f26338c, this.f26339d, this.f26340e, e(this.f26345j), this.f26341f, this.f26342g, this.f26343h, 0, 512, null);
            this.f26346k = true;
            return imageVector;
        }

        public final Builder g() {
            h();
            i().a().add(e((GroupParams) ImageVectorKt.e(this.f26344i)));
            return this;
        }

        private Builder(String str, float f3, float f4, float f5, float f6, long j3, int i3, boolean z2) {
            this.f26336a = str;
            this.f26337b = f3;
            this.f26338c = f4;
            this.f26339d = f5;
            this.f26340e = f6;
            this.f26341f = j3;
            this.f26342g = i3;
            this.f26343h = z2;
            ArrayList arrayList = new ArrayList();
            this.f26344i = arrayList;
            GroupParams groupParams = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.f26345j = groupParams;
            ImageVectorKt.f(arrayList, groupParams);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class GroupParams {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f26347a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private float f26348b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private float f26349c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f26350d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private float f26351e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private float f26352f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private float f26353g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private float f26354h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private List f26355i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private List f26356j;

            public GroupParams(String str, float f3, float f4, float f5, float f6, float f7, float f8, float f9, List list, List list2) {
                this.f26347a = str;
                this.f26348b = f3;
                this.f26349c = f4;
                this.f26350d = f5;
                this.f26351e = f6;
                this.f26352f = f7;
                this.f26353g = f8;
                this.f26354h = f9;
                this.f26355i = list;
                this.f26356j = list2;
            }

            public final List a() {
                return this.f26356j;
            }

            public final List b() {
                return this.f26355i;
            }

            public final String c() {
                return this.f26347a;
            }

            public final float d() {
                return this.f26349c;
            }

            public final float e() {
                return this.f26350d;
            }

            public final float f() {
                return this.f26348b;
            }

            public final float g() {
                return this.f26351e;
            }

            public final float h() {
                return this.f26352f;
            }

            public final float i() {
                return this.f26353g;
            }

            public final float j() {
                return this.f26354h;
            }

            public /* synthetic */ GroupParams(String str, float f3, float f4, float f5, float f6, float f7, float f8, float f9, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0.0f : f3, (i3 & 4) != 0 ? 0.0f : f4, (i3 & 8) != 0 ? 0.0f : f5, (i3 & 16) != 0 ? 1.0f : f6, (i3 & 32) != 0 ? 1.0f : f7, (i3 & 64) != 0 ? 0.0f : f8, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : f9, (i3 & Function.MAX_NARGS) != 0 ? VectorKt.e() : list, (i3 & 512) != 0 ? new ArrayList() : list2);
            }
        }

        public /* synthetic */ Builder(String str, float f3, float f4, float f5, float f6, long j3, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? "" : str, f3, f4, f5, f6, (i4 & 32) != 0 ? Color.f25715b.k() : j3, (i4 & 64) != 0 ? BlendMode.f25667b.z() : i3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            int i3;
            synchronized (ImageVector.f26325m) {
                i3 = ImageVector.f26324l;
                ImageVector.f26324l = i3 + 1;
            }
            return i3;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        f26323k = companion;
        f26325m = companion;
    }

    public /* synthetic */ ImageVector(String str, float f3, float f4, float f5, float f6, VectorGroup vectorGroup, long j3, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f3, f4, f5, f6, vectorGroup, j3, i3, z2, i4);
    }

    public final boolean d() {
        return this.f26334i;
    }

    public final float e() {
        return this.f26328c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) obj;
        return Intrinsics.areEqual(this.f26326a, imageVector.f26326a) && Dp.i(this.f26327b, imageVector.f26327b) && Dp.i(this.f26328c, imageVector.f26328c) && this.f26329d == imageVector.f26329d && this.f26330e == imageVector.f26330e && Intrinsics.areEqual(this.f26331f, imageVector.f26331f) && Color.t(this.f26332g, imageVector.f26332g) && BlendMode.F(this.f26333h, imageVector.f26333h) && this.f26334i == imageVector.f26334i;
    }

    public final float f() {
        return this.f26327b;
    }

    public final int g() {
        return this.f26335j;
    }

    public final String h() {
        return this.f26326a;
    }

    public int hashCode() {
        return (((((((((((((((this.f26326a.hashCode() * 31) + Dp.j(this.f26327b)) * 31) + Dp.j(this.f26328c)) * 31) + Float.hashCode(this.f26329d)) * 31) + Float.hashCode(this.f26330e)) * 31) + this.f26331f.hashCode()) * 31) + Color.z(this.f26332g)) * 31) + BlendMode.G(this.f26333h)) * 31) + Boolean.hashCode(this.f26334i);
    }

    public final VectorGroup i() {
        return this.f26331f;
    }

    public final int j() {
        return this.f26333h;
    }

    public final long k() {
        return this.f26332g;
    }

    public final float l() {
        return this.f26330e;
    }

    public final float m() {
        return this.f26329d;
    }

    private ImageVector(String str, float f3, float f4, float f5, float f6, VectorGroup vectorGroup, long j3, int i3, boolean z2, int i4) {
        this.f26326a = str;
        this.f26327b = f3;
        this.f26328c = f4;
        this.f26329d = f5;
        this.f26330e = f6;
        this.f26331f = vectorGroup;
        this.f26332g = j3;
        this.f26333h = i3;
        this.f26334i = z2;
        this.f26335j = i4;
    }

    public /* synthetic */ ImageVector(String str, float f3, float f4, float f5, float f6, VectorGroup vectorGroup, long j3, int i3, boolean z2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f3, f4, f5, f6, vectorGroup, j3, i3, z2, (i5 & 512) != 0 ? f26323k.a() : i4, null);
    }
}
