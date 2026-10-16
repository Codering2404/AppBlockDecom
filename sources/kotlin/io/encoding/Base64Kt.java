package kotlin.io.encoding;

import com.facebook.stetho.dumpapp.Framer;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

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
public final class Base64Kt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f140004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f140005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f140006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f140007d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f140004a = bArr;
        int[] iArr = new int[Function.MAX_NARGS];
        ArraysKt.fill$default(iArr, -1, 0, 0, 6, (Object) null);
        iArr[61] = -2;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            iArr[bArr[i4]] = i5;
            i4++;
            i5++;
        }
        f140005b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};
        f140006c = bArr2;
        int[] iArr2 = new int[Function.MAX_NARGS];
        ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i6 = 0;
        while (i3 < length2) {
            iArr2[bArr2[i3]] = i6;
            i3++;
            i6++;
        }
        f140007d = iArr2;
    }

    public static final boolean e(int i3) {
        if (i3 < 0) {
            return false;
        }
        int[] iArr = f140005b;
        return i3 < iArr.length && iArr[i3] != -1;
    }
}
