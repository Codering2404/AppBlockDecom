package androidx.compose.ui.text.googlefonts;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

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
public final class FontProviderHelperKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f29287a = new Comparator() { // from class: androidx.compose.ui.text.googlefonts.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FontProviderHelperKt.b((byte[]) obj, (byte[]) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b3 = bArr[i3];
            byte b4 = bArr2[i3];
            if (b3 != b4) {
                return b3 - b4;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) ",", (CharSequence) "byteArrayOf(", (CharSequence) ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
