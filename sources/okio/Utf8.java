package okio;

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
public final class Utf8 {
    public static final long a(String str, int i3, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i3).toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i4 + " < " + i3).toString());
        }
        if (i4 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i4 + " > " + str.length()).toString());
        }
        long j3 = 0;
        while (i3 < i4) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                j3++;
            } else {
                if (cCharAt < 2048) {
                    i5 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i5 = 3;
                } else {
                    int i6 = i3 + 1;
                    char cCharAt2 = i6 < i4 ? str.charAt(i6) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j3++;
                        i3 = i6;
                    } else {
                        j3 += (long) 4;
                        i3 += 2;
                    }
                }
                j3 += (long) i5;
            }
            i3++;
        }
        return j3;
    }

    public static /* synthetic */ long b(String str, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = str.length();
        }
        return a(str, i3, i4);
    }
}
