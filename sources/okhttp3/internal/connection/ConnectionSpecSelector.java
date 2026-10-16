package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;

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
public final class ConnectionSpecSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f144410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f144411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f144412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f144413d;

    public ConnectionSpecSelector(List connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.f144410a = connectionSpecs;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int i3 = this.f144411b;
        int size = this.f144410a.size();
        while (i3 < size) {
            int i4 = i3 + 1;
            if (((ConnectionSpec) this.f144410a.get(i3)).e(sSLSocket)) {
                return true;
            }
            i3 = i4;
        }
        return false;
    }

    public final ConnectionSpec a(SSLSocket sslSocket) throws UnknownServiceException {
        ConnectionSpec connectionSpec;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i3 = this.f144411b;
        int size = this.f144410a.size();
        while (true) {
            if (i3 >= size) {
                connectionSpec = null;
                break;
            }
            int i4 = i3 + 1;
            connectionSpec = (ConnectionSpec) this.f144410a.get(i3);
            if (connectionSpec.e(sslSocket)) {
                this.f144411b = i4;
                break;
            }
            i3 = i4;
        }
        if (connectionSpec != null) {
            this.f144412c = c(sslSocket);
            connectionSpec.c(sslSocket, this.f144413d);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f144413d);
        sb.append(", modes=");
        sb.append(this.f144410a);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean b(IOException e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        this.f144413d = true;
        if (!this.f144412c || (e3 instanceof ProtocolException) || (e3 instanceof InterruptedIOException)) {
            return false;
        }
        return (((e3 instanceof SSLHandshakeException) && (e3.getCause() instanceof CertificateException)) || (e3 instanceof SSLPeerUnverifiedException) || !(e3 instanceof SSLException)) ? false : true;
    }
}
