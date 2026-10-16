package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

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
public final class PathBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f26357a = new ArrayList(32);

    public final PathBuilder a(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7) {
        this.f26357a.add(new PathNode.RelativeArcTo(f3, f4, f5, z2, z3, f6, f7));
        return this;
    }

    public final PathBuilder b() {
        this.f26357a.add(PathNode.Close.f26389c);
        return this;
    }

    public final PathBuilder c(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f26357a.add(new PathNode.CurveTo(f3, f4, f5, f6, f7, f8));
        return this;
    }

    public final PathBuilder d(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f26357a.add(new PathNode.RelativeCurveTo(f3, f4, f5, f6, f7, f8));
        return this;
    }

    public final List e() {
        return this.f26357a;
    }

    public final PathBuilder f(float f3) {
        this.f26357a.add(new PathNode.HorizontalTo(f3));
        return this;
    }

    public final PathBuilder g(float f3) {
        this.f26357a.add(new PathNode.RelativeHorizontalTo(f3));
        return this;
    }

    public final PathBuilder h(float f3, float f4) {
        this.f26357a.add(new PathNode.LineTo(f3, f4));
        return this;
    }

    public final PathBuilder i(float f3, float f4) {
        this.f26357a.add(new PathNode.RelativeLineTo(f3, f4));
        return this;
    }

    public final PathBuilder j(float f3, float f4) {
        this.f26357a.add(new PathNode.MoveTo(f3, f4));
        return this;
    }

    public final PathBuilder k(float f3, float f4) {
        this.f26357a.add(new PathNode.RelativeMoveTo(f3, f4));
        return this;
    }

    public final PathBuilder l(float f3, float f4, float f5, float f6) {
        this.f26357a.add(new PathNode.RelativeQuadTo(f3, f4, f5, f6));
        return this;
    }

    public final PathBuilder m(float f3, float f4, float f5, float f6) {
        this.f26357a.add(new PathNode.ReflectiveCurveTo(f3, f4, f5, f6));
        return this;
    }

    public final PathBuilder n(float f3, float f4, float f5, float f6) {
        this.f26357a.add(new PathNode.RelativeReflectiveCurveTo(f3, f4, f5, f6));
        return this;
    }

    public final PathBuilder o(float f3, float f4) {
        this.f26357a.add(new PathNode.ReflectiveQuadTo(f3, f4));
        return this;
    }

    public final PathBuilder p(float f3, float f4) {
        this.f26357a.add(new PathNode.RelativeReflectiveQuadTo(f3, f4));
        return this;
    }

    public final PathBuilder q(float f3) {
        this.f26357a.add(new PathNode.VerticalTo(f3));
        return this;
    }

    public final PathBuilder r(float f3) {
        this.f26357a.add(new PathNode.RelativeVerticalTo(f3));
        return this;
    }
}
