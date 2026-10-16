package coil.decode;

import coil.util.SvgUtils;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;

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
public final class SvgDecodeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f55741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f55742b;

    static {
        ByteString.Companion companion = ByteString.f144997d;
        f55741a = companion.d("<svg");
        f55742b = companion.d("<");
    }

    public static final boolean a(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.E0(0L, f55742b) && SvgUtils.a(bufferedSource, f55741a, 0L, 1024L) != -1;
    }
}
