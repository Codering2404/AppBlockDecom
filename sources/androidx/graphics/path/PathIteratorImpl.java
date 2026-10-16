package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class PathIteratorImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Companion f39805e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f39806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathIterator.ConicEvaluation f39807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f39808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f39809d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39810a;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f39810a = iArr;
        }
    }

    static {
        System.loadLibrary("androidx.graphics.path");
    }

    public PathIteratorImpl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f3) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(conicEvaluation, "conicEvaluation");
        this.f39806a = path;
        this.f39807b = conicEvaluation;
        this.f39808c = f3;
        this.f39809d = new float[8];
    }

    private final PointF[] a(float[] fArr, PathSegment.Type type) {
        int i3 = WhenMappings.f39810a[type.ordinal()];
        return i3 != 1 ? i3 != 2 ? (i3 == 3 || i3 == 4) ? new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3]), new PointF(fArr[4], fArr[5])} : i3 != 5 ? new PointF[0] : new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3]), new PointF(fArr[4], fArr[5]), new PointF(fArr[6], fArr[7])} : new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3])} : new PointF[]{new PointF(fArr[0], fArr[1])};
    }

    public final PathIterator.ConicEvaluation b() {
        return this.f39807b;
    }

    public final float c() {
        return this.f39808c;
    }

    public abstract boolean d();

    public abstract PathSegment.Type e(float[] fArr, int i3);

    public final PathSegment f() {
        PathSegment.Type typeE = e(this.f39809d, 0);
        if (typeE == PathSegment.Type.Done) {
            return PathSegmentUtilities.b();
        }
        if (typeE == PathSegment.Type.Close) {
            return PathSegmentUtilities.a();
        }
        return new PathSegment(typeE, a(this.f39809d, typeE), typeE == PathSegment.Type.Conic ? this.f39809d[6] : 0.0f);
    }
}
