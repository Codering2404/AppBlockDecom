package androidx.graphics.path;

import android.graphics.PointF;
import java.util.Arrays;
import kotlin.Metadata;
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
public final class PathSegment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f39813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF[] f39814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f39815c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Type {
        Move,
        Line,
        Quadratic,
        Conic,
        Cubic,
        Close,
        Done
    }

    public PathSegment(Type type, PointF[] points, float f3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(points, "points");
        this.f39813a = type;
        this.f39814b = points;
        this.f39815c = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(PathSegment.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.graphics.path.PathSegment");
        PathSegment pathSegment = (PathSegment) obj;
        return this.f39813a == pathSegment.f39813a && Arrays.equals(this.f39814b, pathSegment.f39814b) && this.f39815c == pathSegment.f39815c;
    }

    public int hashCode() {
        return (((this.f39813a.hashCode() * 31) + Arrays.hashCode(this.f39814b)) * 31) + Float.hashCode(this.f39815c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PathSegment(type=");
        sb.append(this.f39813a);
        sb.append(", points=");
        String string = Arrays.toString(this.f39814b);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        sb.append(", weight=");
        sb.append(this.f39815c);
        sb.append(')');
        return sb.toString();
    }
}
