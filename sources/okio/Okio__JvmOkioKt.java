package okio;

import com.google.common.cache.LSNn.vfptEEmYY;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
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
final /* synthetic */ class Okio__JvmOkioKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f145067a = Logger.getLogger("okio.Okio");

    public static final Sink b(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return Okio.h(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? StringsKt.a0(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final Sink e(File file, boolean z2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return Okio.h(new FileOutputStream(file, z2));
    }

    public static final Sink f(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Sink g(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return socketAsyncTimeout.B(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static /* synthetic */ Sink h(File file, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return Okio.g(file, z2);
    }

    public static final Source i(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.f145128e);
    }

    public static final Source j(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Source k(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return socketAsyncTimeout.C(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink d(File file) {
        Intrinsics.checkNotNullParameter(file, vfptEEmYY.XmqHkIUYqbWOv);
        return h(file, false, 1, null);
    }
}
