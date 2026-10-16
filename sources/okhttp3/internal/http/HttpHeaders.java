package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

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
public final class HttpHeaders {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f144518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f144519b;

    static {
        ByteString.Companion companion = ByteString.f144997d;
        f144518a = companion.d("\"\\");
        f144519b = companion.d("\t ,=");
    }

    public static final List a(Headers headers, String headerName) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            if (StringsKt.F(headerName, headers.d(i3), true)) {
                try {
                    c(new Buffer().C0(headers.h(i3)), arrayList);
                } catch (EOFException e3) {
                    Platform.f144818a.g().k("Unable to parse challenge", 5, e3);
                }
            }
            i3 = i4;
        }
        return arrayList;
    }

    public static final boolean b(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        if (Intrinsics.areEqual(response.N().h(), "HEAD")) {
            return false;
        }
        int i3 = response.i();
        return (((i3 >= 100 && i3 < 200) || i3 == 204 || i3 == 304) && Util.v(response) == -1 && !StringsKt.F("chunked", Response.n(response, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x007b, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007b, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void c(okio.Buffer r7, java.util.List r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Lf
            g(r7)
            java.lang.String r1 = e(r7)
            if (r1 != 0) goto Lf
            goto Lba
        Lf:
            boolean r2 = g(r7)
            java.lang.String r3 = e(r7)
            if (r3 != 0) goto L2e
            boolean r7 = r7.G1()
            if (r7 != 0) goto L21
            goto Lba
        L21:
            okhttp3.Challenge r7 = new okhttp3.Challenge
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2e:
            r4 = 61
            int r5 = okhttp3.internal.Util.L(r7, r4)
            boolean r6 = g(r7)
            if (r2 != 0) goto L5e
            if (r6 != 0) goto L42
            boolean r2 = r7.G1()
            if (r2 == 0) goto L5e
        L42:
            okhttp3.Challenge r2 = new okhttp3.Challenge
            java.lang.String r4 = "="
            java.lang.String r4 = kotlin.text.StringsKt.K(r4, r5)
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r4)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5e:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = okhttp3.internal.Util.L(r7, r4)
            int r5 = r5 + r6
        L68:
            if (r3 != 0) goto L79
            java.lang.String r3 = e(r7)
            boolean r5 = g(r7)
            if (r5 == 0) goto L75
            goto L7b
        L75:
            int r5 = okhttp3.internal.Util.L(r7, r4)
        L79:
            if (r5 != 0) goto L86
        L7b:
            okhttp3.Challenge r4 = new okhttp3.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L86:
            r6 = 1
            if (r5 <= r6) goto L8a
            goto Lba
        L8a:
            boolean r6 = g(r7)
            if (r6 == 0) goto L91
            goto Lba
        L91:
            r6 = 34
            boolean r6 = h(r7, r6)
            if (r6 == 0) goto L9e
            java.lang.String r6 = d(r7)
            goto La2
        L9e:
            java.lang.String r6 = e(r7)
        La2:
            if (r6 != 0) goto La5
            goto Lba
        La5:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lae
            goto Lba
        Lae:
            boolean r3 = g(r7)
            if (r3 != 0) goto Lbb
            boolean r3 = r7.G1()
            if (r3 != 0) goto Lbb
        Lba:
            return
        Lbb:
            r3 = r0
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.c(okio.Buffer, java.util.List):void");
    }

    private static final String d(Buffer buffer) throws EOFException {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jN0 = buffer.n0(f144518a);
            if (jN0 == -1) {
                return null;
            }
            if (buffer.r(jN0) == 34) {
                buffer2.H0(buffer, jN0);
                buffer.readByte();
                return buffer2.e0();
            }
            if (buffer.size() == jN0 + 1) {
                return null;
            }
            buffer2.H0(buffer, jN0);
            buffer.readByte();
            buffer2.H0(buffer, 1L);
        }
    }

    private static final String e(Buffer buffer) {
        long jN0 = buffer.n0(f144519b);
        if (jN0 == -1) {
            jN0 = buffer.size();
        }
        if (jN0 != 0) {
            return buffer.m1(jN0);
        }
        return null;
    }

    public static final void f(CookieJar cookieJar, HttpUrl url, Headers headers) {
        Intrinsics.checkNotNullParameter(cookieJar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (cookieJar == CookieJar.f144052b) {
            return;
        }
        List listE = Cookie.f144035j.e(url, headers);
        if (listE.isEmpty()) {
            return;
        }
        cookieJar.b(url, listE);
    }

    private static final boolean g(Buffer buffer) throws EOFException {
        boolean z2 = false;
        while (!buffer.G1()) {
            byte bR = buffer.r(0L);
            if (bR == 44) {
                buffer.readByte();
                z2 = true;
            } else {
                if (bR != 32 && bR != 9) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z2;
    }

    private static final boolean h(Buffer buffer, byte b3) {
        return !buffer.G1() && buffer.r(0L) == b3;
    }
}
