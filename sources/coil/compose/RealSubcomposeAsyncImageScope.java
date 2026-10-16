package coil.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
final class RealSubcomposeAsyncImageScope implements SubcomposeAsyncImageScope, BoxScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BoxScope f55583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AsyncImagePainter f55584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f55585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Alignment f55586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentScale f55587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f55588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ColorFilter f55589g;

    public RealSubcomposeAsyncImageScope(BoxScope boxScope, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter) {
        this.f55583a = boxScope;
        this.f55584b = asyncImagePainter;
        this.f55585c = str;
        this.f55586d = alignment;
        this.f55587e = contentScale;
        this.f55588f = f3;
        this.f55589g = colorFilter;
    }

    @Override // coil.compose.SubcomposeAsyncImageScope
    public float a() {
        return this.f55588f;
    }

    @Override // coil.compose.SubcomposeAsyncImageScope
    public ColorFilter b() {
        return this.f55589g;
    }

    @Override // coil.compose.SubcomposeAsyncImageScope
    public ContentScale e() {
        return this.f55587e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealSubcomposeAsyncImageScope)) {
            return false;
        }
        RealSubcomposeAsyncImageScope realSubcomposeAsyncImageScope = (RealSubcomposeAsyncImageScope) obj;
        return Intrinsics.areEqual(this.f55583a, realSubcomposeAsyncImageScope.f55583a) && Intrinsics.areEqual(this.f55584b, realSubcomposeAsyncImageScope.f55584b) && Intrinsics.areEqual(this.f55585c, realSubcomposeAsyncImageScope.f55585c) && Intrinsics.areEqual(this.f55586d, realSubcomposeAsyncImageScope.f55586d) && Intrinsics.areEqual(this.f55587e, realSubcomposeAsyncImageScope.f55587e) && Float.compare(this.f55588f, realSubcomposeAsyncImageScope.f55588f) == 0 && Intrinsics.areEqual(this.f55589g, realSubcomposeAsyncImageScope.f55589g);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier f(Modifier modifier, Alignment alignment) {
        return this.f55583a.f(modifier, alignment);
    }

    @Override // coil.compose.SubcomposeAsyncImageScope
    public Alignment getAlignment() {
        return this.f55586d;
    }

    @Override // coil.compose.SubcomposeAsyncImageScope
    public String getContentDescription() {
        return this.f55585c;
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier h(Modifier modifier) {
        return this.f55583a.h(modifier);
    }

    public int hashCode() {
        int iHashCode = ((this.f55583a.hashCode() * 31) + this.f55584b.hashCode()) * 31;
        String str = this.f55585c;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f55586d.hashCode()) * 31) + this.f55587e.hashCode()) * 31) + Float.hashCode(this.f55588f)) * 31;
        ColorFilter colorFilter = this.f55589g;
        return iHashCode2 + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    @Override // coil.compose.SubcomposeAsyncImageScope
    public AsyncImagePainter i() {
        return this.f55584b;
    }

    public String toString() {
        return "RealSubcomposeAsyncImageScope(parentScope=" + this.f55583a + ", painter=" + this.f55584b + ", contentDescription=" + this.f55585c + ", alignment=" + this.f55586d + ", contentScale=" + this.f55587e + ", alpha=" + this.f55588f + ", colorFilter=" + this.f55589g + ')';
    }
}
