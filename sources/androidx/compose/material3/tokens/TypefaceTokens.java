package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
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
public final class TypefaceTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypefaceTokens f23672a = new TypefaceTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final GenericFontFamily f23673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final GenericFontFamily f23674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FontWeight f23675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FontWeight f23676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final FontWeight f23677f;

    static {
        FontFamily.Companion companion = FontFamily.f29155b;
        f23673b = companion.d();
        f23674c = companion.d();
        FontWeight.Companion companion2 = FontWeight.f29233b;
        f23675d = companion2.b();
        f23676e = companion2.f();
        f23677f = companion2.g();
    }

    private TypefaceTokens() {
    }

    public final GenericFontFamily a() {
        return f23673b;
    }

    public final GenericFontFamily b() {
        return f23674c;
    }

    public final FontWeight c() {
        return f23676e;
    }

    public final FontWeight d() {
        return f23677f;
    }
}
