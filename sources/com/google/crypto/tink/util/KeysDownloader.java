package com.google.crypto.tink.util;

import com.facebook.stetho.common.Utf8Charset;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class KeysDownloader {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Charset f87560i = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final NetHttpTransport f87561j = new NetHttpTransport.Builder().build();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Executor f87562k = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f87563l = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpTransport f87564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f87565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f87566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f87567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f87568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f87569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f87570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f87571h;

    /* JADX INFO: renamed from: com.google.crypto.tink.util.KeysDownloader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ KeysDownloader f87572a;

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
        
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
        
            throw r1;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                com.google.crypto.tink.util.KeysDownloader r0 = r5.f87572a
                java.lang.Object r0 = com.google.crypto.tink.util.KeysDownloader.a(r0)
                monitor-enter(r0)
                r1 = 0
                com.google.crypto.tink.util.KeysDownloader r2 = r5.f87572a     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L46
                com.google.crypto.tink.util.KeysDownloader.b(r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L46
                com.google.crypto.tink.util.KeysDownloader r2 = r5.f87572a     // Catch: java.lang.Throwable -> L28
                java.lang.Object r2 = com.google.crypto.tink.util.KeysDownloader.c(r2)     // Catch: java.lang.Throwable -> L28
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L28
                com.google.crypto.tink.util.KeysDownloader r3 = r5.f87572a     // Catch: java.lang.Throwable -> L22
                java.lang.Runnable r3 = com.google.crypto.tink.util.KeysDownloader.d(r3)     // Catch: java.lang.Throwable -> L22
                if (r3 != r5) goto L24
                com.google.crypto.tink.util.KeysDownloader r3 = r5.f87572a     // Catch: java.lang.Throwable -> L22
                com.google.crypto.tink.util.KeysDownloader.e(r3, r1)     // Catch: java.lang.Throwable -> L22
                goto L24
            L22:
                r1 = move-exception
                goto L26
            L24:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L22
                goto L5e
            L26:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L22
                throw r1     // Catch: java.lang.Throwable -> L28
            L28:
                r1 = move-exception
                goto L62
            L2a:
                r2 = move-exception
                com.google.crypto.tink.util.KeysDownloader r3 = r5.f87572a     // Catch: java.lang.Throwable -> L28
                java.lang.Object r3 = com.google.crypto.tink.util.KeysDownloader.c(r3)     // Catch: java.lang.Throwable -> L28
                monitor-enter(r3)     // Catch: java.lang.Throwable -> L28
                com.google.crypto.tink.util.KeysDownloader r4 = r5.f87572a     // Catch: java.lang.Throwable -> L40
                java.lang.Runnable r4 = com.google.crypto.tink.util.KeysDownloader.d(r4)     // Catch: java.lang.Throwable -> L40
                if (r4 != r5) goto L42
                com.google.crypto.tink.util.KeysDownloader r4 = r5.f87572a     // Catch: java.lang.Throwable -> L40
                com.google.crypto.tink.util.KeysDownloader.e(r4, r1)     // Catch: java.lang.Throwable -> L40
                goto L42
            L40:
                r1 = move-exception
                goto L44
            L42:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
                throw r2     // Catch: java.lang.Throwable -> L28
            L44:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
                throw r1     // Catch: java.lang.Throwable -> L28
            L46:
                com.google.crypto.tink.util.KeysDownloader r2 = r5.f87572a     // Catch: java.lang.Throwable -> L28
                java.lang.Object r2 = com.google.crypto.tink.util.KeysDownloader.c(r2)     // Catch: java.lang.Throwable -> L28
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L28
                com.google.crypto.tink.util.KeysDownloader r3 = r5.f87572a     // Catch: java.lang.Throwable -> L5b
                java.lang.Runnable r3 = com.google.crypto.tink.util.KeysDownloader.d(r3)     // Catch: java.lang.Throwable -> L5b
                if (r3 != r5) goto L5d
                com.google.crypto.tink.util.KeysDownloader r3 = r5.f87572a     // Catch: java.lang.Throwable -> L5b
                com.google.crypto.tink.util.KeysDownloader.e(r3, r1)     // Catch: java.lang.Throwable -> L5b
                goto L5d
            L5b:
                r1 = move-exception
                goto L60
            L5d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L5b
            L5e:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
                return
            L60:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L5b
                throw r1     // Catch: java.lang.Throwable -> L28
            L62:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.util.KeysDownloader.AnonymousClass1.run():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() throws IOException {
        long jG = g();
        HttpResponse httpResponseExecute = this.f87564a.createRequestFactory().buildGetRequest(new GenericUrl(this.f87567d)).execute();
        if (httpResponseExecute.getStatusCode() != 200) {
            throw new IOException("Unexpected status code = " + httpResponseExecute.getStatusCode());
        }
        InputStream content = httpResponseExecute.getContent();
        try {
            String strI = i(new InputStreamReader(content, f87560i));
            content.close();
            synchronized (this.f87566c) {
                this.f87570g = jG;
                this.f87571h = h(httpResponseExecute.getHeaders()) * 1000;
                this.f87569f = strI;
            }
            return strI;
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    private static String i(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = bufferedReader.read();
            if (i3 == -1) {
                return sb.toString();
            }
            sb.append((char) i3);
        }
    }

    long g() {
        return Instant.now().getMillis();
    }

    long h(HttpHeaders httpHeaders) {
        long jLongValue;
        if (httpHeaders.getCacheControl() != null) {
            for (String str : httpHeaders.getCacheControl().split(",")) {
                Matcher matcher = f87563l.matcher(str);
                if (matcher.matches()) {
                    jLongValue = Long.valueOf(matcher.group(1)).longValue();
                    break;
                }
            }
            jLongValue = 0;
        } else {
            jLongValue = 0;
        }
        if (httpHeaders.getAge() != null) {
            jLongValue -= httpHeaders.getAge().longValue();
        }
        return Math.max(0L, jLongValue);
    }
}
