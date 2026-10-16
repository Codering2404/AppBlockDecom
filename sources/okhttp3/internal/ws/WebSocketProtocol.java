package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

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
public final class WebSocketProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebSocketProtocol f144923a = new WebSocketProtocol();

    private WebSocketProtocol() {
    }

    public final String a(int i3) {
        if (i3 < 1000 || i3 >= 5000) {
            return Intrinsics.stringPlus("Code must be in range [1000,5000): ", Integer.valueOf(i3));
        }
        if ((1004 > i3 || i3 >= 1007) && (1015 > i3 || i3 >= 3000)) {
            return null;
        }
        return "Code " + i3 + " is reserved and may not be used.";
    }

    public final void b(Buffer.UnsafeCursor cursor, byte[] key) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(key, "key");
        int length = key.length;
        int i3 = 0;
        do {
            byte[] bArr = cursor.f144992f;
            int i4 = cursor.f144993g;
            int i5 = cursor.f144994h;
            if (bArr != null) {
                while (i4 < i5) {
                    int i6 = i3 % length;
                    bArr[i4] = (byte) (bArr[i4] ^ key[i6]);
                    i4++;
                    i3 = i6 + 1;
                }
            }
        } while (cursor.b() != -1);
    }

    public final void c(int i3) {
        String strA = a(i3);
        if (strA == null) {
            return;
        }
        Intrinsics.checkNotNull(strA);
        throw new IllegalArgumentException(strA.toString());
    }
}
