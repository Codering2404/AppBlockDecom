package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.tokens.ShapeTokens;
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
public final class ShapeDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShapeDefaults f19830a = new ShapeDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CornerBasedShape f19831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CornerBasedShape f19832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CornerBasedShape f19833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CornerBasedShape f19834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CornerBasedShape f19835f;

    static {
        ShapeTokens shapeTokens = ShapeTokens.f23374a;
        f19831b = shapeTokens.b();
        f19832c = shapeTokens.e();
        f19833d = shapeTokens.d();
        f19834e = shapeTokens.c();
        f19835f = shapeTokens.a();
    }

    private ShapeDefaults() {
    }

    public final CornerBasedShape a() {
        return f19835f;
    }

    public final CornerBasedShape b() {
        return f19831b;
    }

    public final CornerBasedShape c() {
        return f19834e;
    }

    public final CornerBasedShape d() {
        return f19833d;
    }

    public final CornerBasedShape e() {
        return f19832c;
    }
}
