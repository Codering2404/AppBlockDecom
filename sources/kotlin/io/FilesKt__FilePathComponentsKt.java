package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
class FilesKt__FilePathComponentsKt {
    private static final int a(String str) {
        int iM0;
        char c3 = File.separatorChar;
        int iM02 = StringsKt.m0(str, c3, 0, false, 4, null);
        if (iM02 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c3 || (iM0 = StringsKt.m0(str, c3, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iM03 = StringsKt.m0(str, c3, iM0 + 1, false, 4, null);
            return iM03 >= 0 ? iM03 + 1 : str.length();
        }
        if (iM02 > 0 && str.charAt(iM02 - 1) == ':') {
            return iM02 + 1;
        }
        if (iM02 == -1 && StringsKt.e0(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean b(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return a(path) > 0;
    }
}
