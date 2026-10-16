package kotlin.uuid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;

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
class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    public static final void f(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.charAt(i3) == '-') {
            return;
        }
        throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i3 + ", but was '" + str.charAt(i3) + '\'').toString());
    }

    public static final void g(long j3, byte[] dst, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        int i6 = 7 - i4;
        int i7 = 8 - i5;
        if (i7 > i6) {
            return;
        }
        while (true) {
            int i8 = HexExtensionsKt.d()[(int) ((j3 >> (i6 << 3)) & 255)];
            int i9 = i3 + 1;
            dst[i3] = (byte) (i8 >> 8);
            i3 += 2;
            dst[i9] = (byte) i8;
            if (i6 == i7) {
                return;
            } else {
                i6--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(String str, int i3) {
        if (str.length() <= i3) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        sb.append("...");
        return sb.toString();
    }

    public static final Uuid i(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return Uuid.f140682c.a(HexExtensionsKt.f(hexString, 0, 16, null, 4, null), HexExtensionsKt.f(hexString, 16, 32, null, 4, null));
    }

    public static final Uuid j(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        long jF = HexExtensionsKt.f(hexDashString, 0, 8, null, 4, null);
        f(hexDashString, 8);
        long jF2 = HexExtensionsKt.f(hexDashString, 9, 13, null, 4, null);
        f(hexDashString, 13);
        long jF3 = HexExtensionsKt.f(hexDashString, 14, 18, null, 4, null);
        f(hexDashString, 18);
        long jF4 = HexExtensionsKt.f(hexDashString, 19, 23, null, 4, null);
        f(hexDashString, 23);
        return Uuid.f140682c.a((jF2 << 16) | (jF << 32) | jF3, (jF4 << 48) | HexExtensionsKt.f(hexDashString, 24, 36, null, 4, null));
    }
}
