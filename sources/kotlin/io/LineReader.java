package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
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
public final class LineReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LineReader f139973a = new LineReader();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f139974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f139975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ByteBuffer f139976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CharBuffer f139977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final StringBuilder f139978f;

    static {
        byte[] bArr = new byte[32];
        f139974b = bArr;
        char[] cArr = new char[32];
        f139975c = cArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        f139976d = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        Intrinsics.checkNotNullExpressionValue(charBufferWrap, "wrap(...)");
        f139977e = charBufferWrap;
        f139978f = new StringBuilder();
    }

    private LineReader() {
    }
}
