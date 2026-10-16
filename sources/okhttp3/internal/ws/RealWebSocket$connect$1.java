package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.ws.RealWebSocket;

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
public final class RealWebSocket$connect$1 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RealWebSocket f144908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Request f144909b;

    @Override // okhttp3.Callback
    public void c(Call call, IOException e3) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e3, "e");
        this.f144908a.n(e3, null);
    }

    @Override // okhttp3.Callback
    public void d(Call call, Response response) throws Throwable {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Exchange exchangeJ = response.j();
        try {
            this.f144908a.k(response, exchangeJ);
            Intrinsics.checkNotNull(exchangeJ);
            RealWebSocket.Streams streamsN = exchangeJ.n();
            WebSocketExtensions webSocketExtensionsA = WebSocketExtensions.f144916g.a(response.r());
            this.f144908a.f144878d = webSocketExtensionsA;
            if (!this.f144908a.q(webSocketExtensionsA)) {
                RealWebSocket realWebSocket = this.f144908a;
                synchronized (realWebSocket) {
                    realWebSocket.f144889o.clear();
                    realWebSocket.l(1010, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.f144908a.p(Util.f144282i + " WebSocket " + this.f144909b.k().p(), streamsN);
                this.f144908a.o().f(this.f144908a, response);
                this.f144908a.r();
            } catch (Exception e3) {
                this.f144908a.n(e3, null);
            }
        } catch (IOException e4) {
            if (exchangeJ != null) {
                exchangeJ.v();
            }
            this.f144908a.n(e4, response);
            Util.m(response);
        }
    }
}
