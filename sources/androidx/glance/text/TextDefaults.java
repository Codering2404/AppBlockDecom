package androidx.glance.text;

import androidx.compose.ui.graphics.Color;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
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
public final class TextDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextDefaults f39763a = new TextDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorProvider f39764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TextStyle f39765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39766d;

    static {
        ColorProvider colorProviderB = ColorProviderKt.b(Color.f25715b.a());
        f39764b = colorProviderB;
        f39765c = new TextStyle(colorProviderB, null, null, null, null, null, null, 126, null);
        f39766d = 8;
    }

    private TextDefaults() {
    }

    public final ColorProvider a() {
        return f39764b;
    }

    public final TextStyle b() {
        return f39765c;
    }
}
