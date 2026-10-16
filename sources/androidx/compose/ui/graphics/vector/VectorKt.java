package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public final class VectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f26525a = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f26526b = StrokeCap.f25935b.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26527c = StrokeJoin.f25940b.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f26528d = BlendMode.f25667b.z();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f26529e = Color.f25715b.j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f26530f = PathFillType.f25834b.b();

    public static final List a(String str) {
        return str == null ? f26525a : new PathParser().a(str).d();
    }

    public static final int b() {
        return f26530f;
    }

    public static final int c() {
        return f26526b;
    }

    public static final int d() {
        return f26527c;
    }

    public static final List e() {
        return f26525a;
    }

    public static final boolean f(long j3, long j4) {
        return Color.y(j3) == Color.y(j4) && Color.x(j3) == Color.x(j4) && Color.v(j3) == Color.v(j4);
    }

    public static final boolean g(ColorFilter colorFilter) {
        if (!(colorFilter instanceof BlendModeColorFilter)) {
            return colorFilter == null;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) colorFilter;
        int iB = blendModeColorFilter.b();
        BlendMode.Companion companion = BlendMode.f25667b;
        return BlendMode.F(iB, companion.z()) || BlendMode.F(blendModeColorFilter.b(), companion.B());
    }
}
