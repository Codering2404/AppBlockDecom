package kotlin.text;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Charsets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charsets f140509a = new Charsets();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f140510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f140511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f140512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f140513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f140514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f140515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile Charset f140516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile Charset f140517i;

    static {
        Charset charsetForName = Charset.forName(Utf8Charset.NAME);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        f140510b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(...)");
        f140511c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(charsetForName3, "forName(...)");
        f140512d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        Intrinsics.checkNotNullExpressionValue(charsetForName4, "forName(...)");
        f140513e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(charsetForName5, "forName(...)");
        f140514f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(charsetForName6, "forName(...)");
        f140515g = charsetForName6;
    }

    private Charsets() {
    }

    public final Charset a() {
        Charset charset = f140517i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        f140517i = charsetForName;
        return charsetForName;
    }

    public final Charset b() {
        Charset charset = f140516h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        f140516h = charsetForName;
        return charsetForName;
    }
}
