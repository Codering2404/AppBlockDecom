package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
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
final class SocketAsyncTimeout extends AsyncTimeout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Socket f145118o;

    public SocketAsyncTimeout(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.f145118o = socket;
    }

    @Override // okio.AsyncTimeout
    protected void D() {
        try {
            this.f145118o.close();
        } catch (AssertionError e3) {
            if (!Okio.e(e3)) {
                throw e3;
            }
            Okio__JvmOkioKt.f145067a.log(Level.WARNING, "Failed to close timed out socket " + this.f145118o, (Throwable) e3);
        } catch (Exception e4) {
            Okio__JvmOkioKt.f145067a.log(Level.WARNING, "Failed to close timed out socket " + this.f145118o, (Throwable) e4);
        }
    }

    @Override // okio.AsyncTimeout
    protected IOException z(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
