package androidx.compose.ui.graphics.vector;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class PathNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f26380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26381b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ArcTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f26385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f26386g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f26387h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float f26388i;

        /* JADX WARN: Illegal instructions before constructor call */
        public ArcTo(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7) {
            boolean z4 = false;
            super(z4, z4, 3, null);
            this.f26382c = f3;
            this.f26383d = f4;
            this.f26384e = f5;
            this.f26385f = z2;
            this.f26386g = z3;
            this.f26387h = f6;
            this.f26388i = f7;
        }

        public final float c() {
            return this.f26387h;
        }

        public final float d() {
            return this.f26388i;
        }

        public final float e() {
            return this.f26382c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) obj;
            return Float.compare(this.f26382c, arcTo.f26382c) == 0 && Float.compare(this.f26383d, arcTo.f26383d) == 0 && Float.compare(this.f26384e, arcTo.f26384e) == 0 && this.f26385f == arcTo.f26385f && this.f26386g == arcTo.f26386g && Float.compare(this.f26387h, arcTo.f26387h) == 0 && Float.compare(this.f26388i, arcTo.f26388i) == 0;
        }

        public final float f() {
            return this.f26384e;
        }

        public final float g() {
            return this.f26383d;
        }

        public final boolean h() {
            return this.f26385f;
        }

        public int hashCode() {
            return (((((((((((Float.hashCode(this.f26382c) * 31) + Float.hashCode(this.f26383d)) * 31) + Float.hashCode(this.f26384e)) * 31) + Boolean.hashCode(this.f26385f)) * 31) + Boolean.hashCode(this.f26386g)) * 31) + Float.hashCode(this.f26387h)) * 31) + Float.hashCode(this.f26388i);
        }

        public final boolean i() {
            return this.f26386g;
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.f26382c + ", verticalEllipseRadius=" + this.f26383d + ", theta=" + this.f26384e + ", isMoreThanHalf=" + this.f26385f + ", isPositiveArc=" + this.f26386g + ", arcStartX=" + this.f26387h + ", arcStartY=" + this.f26388i + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Close f26389c = new Close();

        /* JADX WARN: Illegal instructions before constructor call */
        private Close() {
            boolean z2 = false;
            super(z2, z2, 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CurveTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f26393f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final float f26394g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f26395h;

        public CurveTo(float f3, float f4, float f5, float f6, float f7, float f8) {
            super(true, false, 2, null);
            this.f26390c = f3;
            this.f26391d = f4;
            this.f26392e = f5;
            this.f26393f = f6;
            this.f26394g = f7;
            this.f26395h = f8;
        }

        public final float c() {
            return this.f26390c;
        }

        public final float d() {
            return this.f26392e;
        }

        public final float e() {
            return this.f26394g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) obj;
            return Float.compare(this.f26390c, curveTo.f26390c) == 0 && Float.compare(this.f26391d, curveTo.f26391d) == 0 && Float.compare(this.f26392e, curveTo.f26392e) == 0 && Float.compare(this.f26393f, curveTo.f26393f) == 0 && Float.compare(this.f26394g, curveTo.f26394g) == 0 && Float.compare(this.f26395h, curveTo.f26395h) == 0;
        }

        public final float f() {
            return this.f26391d;
        }

        public final float g() {
            return this.f26393f;
        }

        public final float h() {
            return this.f26395h;
        }

        public int hashCode() {
            return (((((((((Float.hashCode(this.f26390c) * 31) + Float.hashCode(this.f26391d)) * 31) + Float.hashCode(this.f26392e)) * 31) + Float.hashCode(this.f26393f)) * 31) + Float.hashCode(this.f26394g)) * 31) + Float.hashCode(this.f26395h);
        }

        public String toString() {
            return "CurveTo(x1=" + this.f26390c + ", y1=" + this.f26391d + ", x2=" + this.f26392e + ", y2=" + this.f26393f + ", x3=" + this.f26394g + ", y3=" + this.f26395h + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HorizontalTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26396c;

        /* JADX WARN: Illegal instructions before constructor call */
        public HorizontalTo(float f3) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26396c = f3;
        }

        public final float c() {
            return this.f26396c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalTo) && Float.compare(this.f26396c, ((HorizontalTo) obj).f26396c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f26396c);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.f26396c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LineTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26398d;

        /* JADX WARN: Illegal instructions before constructor call */
        public LineTo(float f3, float f4) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26397c = f3;
            this.f26398d = f4;
        }

        public final float c() {
            return this.f26397c;
        }

        public final float d() {
            return this.f26398d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) obj;
            return Float.compare(this.f26397c, lineTo.f26397c) == 0 && Float.compare(this.f26398d, lineTo.f26398d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f26397c) * 31) + Float.hashCode(this.f26398d);
        }

        public String toString() {
            return "LineTo(x=" + this.f26397c + ", y=" + this.f26398d + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MoveTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26400d;

        /* JADX WARN: Illegal instructions before constructor call */
        public MoveTo(float f3, float f4) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26399c = f3;
            this.f26400d = f4;
        }

        public final float c() {
            return this.f26399c;
        }

        public final float d() {
            return this.f26400d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) obj;
            return Float.compare(this.f26399c, moveTo.f26399c) == 0 && Float.compare(this.f26400d, moveTo.f26400d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f26399c) * 31) + Float.hashCode(this.f26400d);
        }

        public String toString() {
            return "MoveTo(x=" + this.f26399c + ", y=" + this.f26400d + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class QuadTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f26404f;

        public QuadTo(float f3, float f4, float f5, float f6) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f26401c = f3;
            this.f26402d = f4;
            this.f26403e = f5;
            this.f26404f = f6;
        }

        public final float c() {
            return this.f26401c;
        }

        public final float d() {
            return this.f26403e;
        }

        public final float e() {
            return this.f26402d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) obj;
            return Float.compare(this.f26401c, quadTo.f26401c) == 0 && Float.compare(this.f26402d, quadTo.f26402d) == 0 && Float.compare(this.f26403e, quadTo.f26403e) == 0 && Float.compare(this.f26404f, quadTo.f26404f) == 0;
        }

        public final float f() {
            return this.f26404f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f26401c) * 31) + Float.hashCode(this.f26402d)) * 31) + Float.hashCode(this.f26403e)) * 31) + Float.hashCode(this.f26404f);
        }

        public String toString() {
            return "QuadTo(x1=" + this.f26401c + ", y1=" + this.f26402d + ", x2=" + this.f26403e + ", y2=" + this.f26404f + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReflectiveCurveTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26407e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f26408f;

        public ReflectiveCurveTo(float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.f26405c = f3;
            this.f26406d = f4;
            this.f26407e = f5;
            this.f26408f = f6;
        }

        public final float c() {
            return this.f26405c;
        }

        public final float d() {
            return this.f26407e;
        }

        public final float e() {
            return this.f26406d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
            return Float.compare(this.f26405c, reflectiveCurveTo.f26405c) == 0 && Float.compare(this.f26406d, reflectiveCurveTo.f26406d) == 0 && Float.compare(this.f26407e, reflectiveCurveTo.f26407e) == 0 && Float.compare(this.f26408f, reflectiveCurveTo.f26408f) == 0;
        }

        public final float f() {
            return this.f26408f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f26405c) * 31) + Float.hashCode(this.f26406d)) * 31) + Float.hashCode(this.f26407e)) * 31) + Float.hashCode(this.f26408f);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f26405c + ", y1=" + this.f26406d + ", x2=" + this.f26407e + ", y2=" + this.f26408f + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReflectiveQuadTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26410d;

        public ReflectiveQuadTo(float f3, float f4) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f26409c = f3;
            this.f26410d = f4;
        }

        public final float c() {
            return this.f26409c;
        }

        public final float d() {
            return this.f26410d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) obj;
            return Float.compare(this.f26409c, reflectiveQuadTo.f26409c) == 0 && Float.compare(this.f26410d, reflectiveQuadTo.f26410d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f26409c) * 31) + Float.hashCode(this.f26410d);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f26409c + ", y=" + this.f26410d + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeArcTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f26414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f26415g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f26416h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float f26417i;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeArcTo(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7) {
            boolean z4 = false;
            super(z4, z4, 3, null);
            this.f26411c = f3;
            this.f26412d = f4;
            this.f26413e = f5;
            this.f26414f = z2;
            this.f26415g = z3;
            this.f26416h = f6;
            this.f26417i = f7;
        }

        public final float c() {
            return this.f26416h;
        }

        public final float d() {
            return this.f26417i;
        }

        public final float e() {
            return this.f26411c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) obj;
            return Float.compare(this.f26411c, relativeArcTo.f26411c) == 0 && Float.compare(this.f26412d, relativeArcTo.f26412d) == 0 && Float.compare(this.f26413e, relativeArcTo.f26413e) == 0 && this.f26414f == relativeArcTo.f26414f && this.f26415g == relativeArcTo.f26415g && Float.compare(this.f26416h, relativeArcTo.f26416h) == 0 && Float.compare(this.f26417i, relativeArcTo.f26417i) == 0;
        }

        public final float f() {
            return this.f26413e;
        }

        public final float g() {
            return this.f26412d;
        }

        public final boolean h() {
            return this.f26414f;
        }

        public int hashCode() {
            return (((((((((((Float.hashCode(this.f26411c) * 31) + Float.hashCode(this.f26412d)) * 31) + Float.hashCode(this.f26413e)) * 31) + Boolean.hashCode(this.f26414f)) * 31) + Boolean.hashCode(this.f26415g)) * 31) + Float.hashCode(this.f26416h)) * 31) + Float.hashCode(this.f26417i);
        }

        public final boolean i() {
            return this.f26415g;
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.f26411c + ", verticalEllipseRadius=" + this.f26412d + ", theta=" + this.f26413e + ", isMoreThanHalf=" + this.f26414f + ", isPositiveArc=" + this.f26415g + ", arcStartDx=" + this.f26416h + ", arcStartDy=" + this.f26417i + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeCurveTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f26421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final float f26422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f26423h;

        public RelativeCurveTo(float f3, float f4, float f5, float f6, float f7, float f8) {
            super(true, false, 2, null);
            this.f26418c = f3;
            this.f26419d = f4;
            this.f26420e = f5;
            this.f26421f = f6;
            this.f26422g = f7;
            this.f26423h = f8;
        }

        public final float c() {
            return this.f26418c;
        }

        public final float d() {
            return this.f26420e;
        }

        public final float e() {
            return this.f26422g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
            return Float.compare(this.f26418c, relativeCurveTo.f26418c) == 0 && Float.compare(this.f26419d, relativeCurveTo.f26419d) == 0 && Float.compare(this.f26420e, relativeCurveTo.f26420e) == 0 && Float.compare(this.f26421f, relativeCurveTo.f26421f) == 0 && Float.compare(this.f26422g, relativeCurveTo.f26422g) == 0 && Float.compare(this.f26423h, relativeCurveTo.f26423h) == 0;
        }

        public final float f() {
            return this.f26419d;
        }

        public final float g() {
            return this.f26421f;
        }

        public final float h() {
            return this.f26423h;
        }

        public int hashCode() {
            return (((((((((Float.hashCode(this.f26418c) * 31) + Float.hashCode(this.f26419d)) * 31) + Float.hashCode(this.f26420e)) * 31) + Float.hashCode(this.f26421f)) * 31) + Float.hashCode(this.f26422g)) * 31) + Float.hashCode(this.f26423h);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.f26418c + ", dy1=" + this.f26419d + ", dx2=" + this.f26420e + ", dy2=" + this.f26421f + ", dx3=" + this.f26422g + ", dy3=" + this.f26423h + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeHorizontalTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26424c;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeHorizontalTo(float f3) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26424c = f3;
        }

        public final float c() {
            return this.f26424c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeHorizontalTo) && Float.compare(this.f26424c, ((RelativeHorizontalTo) obj).f26424c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f26424c);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f26424c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeLineTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26426d;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeLineTo(float f3, float f4) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26425c = f3;
            this.f26426d = f4;
        }

        public final float c() {
            return this.f26425c;
        }

        public final float d() {
            return this.f26426d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
            return Float.compare(this.f26425c, relativeLineTo.f26425c) == 0 && Float.compare(this.f26426d, relativeLineTo.f26426d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f26425c) * 31) + Float.hashCode(this.f26426d);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.f26425c + ", dy=" + this.f26426d + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeMoveTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26428d;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeMoveTo(float f3, float f4) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26427c = f3;
            this.f26428d = f4;
        }

        public final float c() {
            return this.f26427c;
        }

        public final float d() {
            return this.f26428d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) obj;
            return Float.compare(this.f26427c, relativeMoveTo.f26427c) == 0 && Float.compare(this.f26428d, relativeMoveTo.f26428d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f26427c) * 31) + Float.hashCode(this.f26428d);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.f26427c + ", dy=" + this.f26428d + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeQuadTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26431e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f26432f;

        public RelativeQuadTo(float f3, float f4, float f5, float f6) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f26429c = f3;
            this.f26430d = f4;
            this.f26431e = f5;
            this.f26432f = f6;
        }

        public final float c() {
            return this.f26429c;
        }

        public final float d() {
            return this.f26431e;
        }

        public final float e() {
            return this.f26430d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) obj;
            return Float.compare(this.f26429c, relativeQuadTo.f26429c) == 0 && Float.compare(this.f26430d, relativeQuadTo.f26430d) == 0 && Float.compare(this.f26431e, relativeQuadTo.f26431e) == 0 && Float.compare(this.f26432f, relativeQuadTo.f26432f) == 0;
        }

        public final float f() {
            return this.f26432f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f26429c) * 31) + Float.hashCode(this.f26430d)) * 31) + Float.hashCode(this.f26431e)) * 31) + Float.hashCode(this.f26432f);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.f26429c + ", dy1=" + this.f26430d + ", dx2=" + this.f26431e + ", dy2=" + this.f26432f + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeReflectiveCurveTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f26435e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f26436f;

        public RelativeReflectiveCurveTo(float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.f26433c = f3;
            this.f26434d = f4;
            this.f26435e = f5;
            this.f26436f = f6;
        }

        public final float c() {
            return this.f26433c;
        }

        public final float d() {
            return this.f26435e;
        }

        public final float e() {
            return this.f26434d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
            return Float.compare(this.f26433c, relativeReflectiveCurveTo.f26433c) == 0 && Float.compare(this.f26434d, relativeReflectiveCurveTo.f26434d) == 0 && Float.compare(this.f26435e, relativeReflectiveCurveTo.f26435e) == 0 && Float.compare(this.f26436f, relativeReflectiveCurveTo.f26436f) == 0;
        }

        public final float f() {
            return this.f26436f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f26433c) * 31) + Float.hashCode(this.f26434d)) * 31) + Float.hashCode(this.f26435e)) * 31) + Float.hashCode(this.f26436f);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.f26433c + ", dy1=" + this.f26434d + ", dx2=" + this.f26435e + ", dy2=" + this.f26436f + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeReflectiveQuadTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f26438d;

        public RelativeReflectiveQuadTo(float f3, float f4) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f26437c = f3;
            this.f26438d = f4;
        }

        public final float c() {
            return this.f26437c;
        }

        public final float d() {
            return this.f26438d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) obj;
            return Float.compare(this.f26437c, relativeReflectiveQuadTo.f26437c) == 0 && Float.compare(this.f26438d, relativeReflectiveQuadTo.f26438d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f26437c) * 31) + Float.hashCode(this.f26438d);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f26437c + ", dy=" + this.f26438d + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RelativeVerticalTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26439c;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeVerticalTo(float f3) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26439c = f3;
        }

        public final float c() {
            return this.f26439c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeVerticalTo) && Float.compare(this.f26439c, ((RelativeVerticalTo) obj).f26439c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f26439c);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f26439c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class VerticalTo extends PathNode {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f26440c;

        /* JADX WARN: Illegal instructions before constructor call */
        public VerticalTo(float f3) {
            boolean z2 = false;
            super(z2, z2, 3, null);
            this.f26440c = f3;
        }

        public final float c() {
            return this.f26440c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalTo) && Float.compare(this.f26440c, ((VerticalTo) obj).f26440c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.f26440c);
        }

        public String toString() {
            return "VerticalTo(y=" + this.f26440c + ')';
        }
    }

    public /* synthetic */ PathNode(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3);
    }

    public final boolean a() {
        return this.f26380a;
    }

    public final boolean b() {
        return this.f26381b;
    }

    private PathNode(boolean z2, boolean z3) {
        this.f26380a = z2;
        this.f26381b = z3;
    }

    public /* synthetic */ PathNode(boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, null);
    }
}
