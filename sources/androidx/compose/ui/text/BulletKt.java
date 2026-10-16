package androidx.compose.ui.text;

import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.unit.TextUnitKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BulletKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f28680a = TextUnitKt.f(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f28681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f28682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bullet f28683d;

    static {
        long jD = TextUnitKt.d(0.25d);
        f28681b = jD;
        long jD2 = TextUnitKt.d(0.25d);
        f28682c = jD2;
        f28683d = new Bullet(CircleShape.f28688a, jD, jD2, null, 1.0f, Fill.f26098a, null);
    }

    public static final Bullet a() {
        return f28683d;
    }

    public static final long b() {
        return f28680a;
    }
}
