package okhttp3.internal.http;

import com.facebook.GraphRequest;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;

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
public final class BridgeInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CookieJar f144512a;

    public BridgeInterceptor(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.f144512a = cookieJar;
    }

    private final String b(List list) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Cookie cookie = (Cookie) obj;
            if (i3 > 0) {
                sb.append("; ");
            }
            sb.append(cookie.i());
            sb.append('=');
            sb.append(cookie.n());
            i3 = i4;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) {
        ResponseBody responseBodyA;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request requestL = chain.l();
        Request.Builder builderI = requestL.i();
        RequestBody requestBodyA = requestL.a();
        if (requestBodyA != null) {
            MediaType mediaTypeB = requestBodyA.b();
            if (mediaTypeB != null) {
                builderI.f("Content-Type", mediaTypeB.toString());
            }
            long jA = requestBodyA.a();
            if (jA != -1) {
                builderI.f(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH, String.valueOf(jA));
                builderI.i("Transfer-Encoding");
            } else {
                builderI.f("Transfer-Encoding", "chunked");
                builderI.i(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z2 = false;
        if (requestL.d("Host") == null) {
            builderI.f("Host", Util.U(requestL.k(), false, 1, null));
        }
        if (requestL.d("Connection") == null) {
            builderI.f("Connection", "Keep-Alive");
        }
        String strD = requestL.d("Accept-Encoding");
        String str = KrzujOtzIk.WQHsNZQAsRefGf;
        if (strD == null && requestL.d("Range") == null) {
            builderI.f("Accept-Encoding", str);
            z2 = true;
        }
        List listA = this.f144512a.a(requestL.k());
        if (!listA.isEmpty()) {
            builderI.f("Cookie", b(listA));
        }
        if (requestL.d(GraphRequest.USER_AGENT_HEADER) == null) {
            builderI.f(GraphRequest.USER_AGENT_HEADER, "okhttp/4.11.0");
        }
        Response responseA = chain.a(builderI.b());
        HttpHeaders.f(this.f144512a, requestL.k(), responseA.r());
        Response.Builder builderS = responseA.F().s(requestL);
        if (z2 && StringsKt.F(str, Response.n(responseA, GraphRequest.CONTENT_ENCODING_HEADER, null, 2, null), true) && HttpHeaders.b(responseA) && (responseBodyA = responseA.a()) != null) {
            GzipSource gzipSource = new GzipSource(responseBodyA.k());
            builderS.l(responseA.r().f().i(GraphRequest.CONTENT_ENCODING_HEADER).i(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH).f());
            builderS.b(new RealResponseBody(Response.n(responseA, "Content-Type", null, 2, null), -1L, Okio.d(gzipSource)));
        }
        return builderS.c();
    }
}
