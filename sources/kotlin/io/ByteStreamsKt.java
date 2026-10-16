package kotlin.io;

import com.facebook.internal.Utility;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public final class ByteStreamsKt {
    public static final long a(InputStream inputStream, OutputStream out, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        byte[] bArr = new byte[i3];
        int i4 = inputStream.read(bArr);
        long j3 = 0;
        while (i4 >= 0) {
            out.write(bArr, 0, i4);
            j3 += (long) i4;
            i4 = inputStream.read(bArr);
        }
        return j3;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        return a(inputStream, outputStream, i3);
    }

    public static final byte[] c(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(Utility.DEFAULT_STREAM_BUFFER_SIZE, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, sKeKFMqmvNzY.uFbSJ);
        return byteArray;
    }
}
