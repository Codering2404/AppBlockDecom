package kotlinx.serialization.json.internal;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class AbstractJsonLexerKt {
    public static final byte a(char c3) {
        if (c3 < '~') {
            return CharMappings.f143066c[c3];
        }
        return (byte) 0;
    }

    public static final char b(int i3) {
        if (i3 < 117) {
            return CharMappings.f143065b[i3];
        }
        return (char) 0;
    }

    public static final String c(byte b3) {
        return b3 == 1 ? "quotation mark '\"'" : b3 == 2 ? "string escape sequence '\\'" : b3 == 4 ? "comma ','" : b3 == 5 ? "colon ':'" : b3 == 6 ? "start of the object '{'" : b3 == 7 ? "end of the object '}'" : b3 == 8 ? "start of the array '['" : b3 == 9 ? "end of the array ']'" : b3 == 10 ? "end of the input" : b3 == 127 ? "invalid token" : "valid token";
    }
}
