package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final HttpUrlConnectionFactory f66279h = new DefaultHttpUrlConnectionFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GlideUrl f66280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f66281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpUrlConnectionFactory f66282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpURLConnection f66283d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InputStream f66284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f66285g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface HttpUrlConnectionFactory {
        HttpURLConnection a(URL url);
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i3) {
        this(glideUrl, i3, f66279h);
    }

    private HttpURLConnection c(URL url, Map map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionA = this.f66282c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.f66281b);
            httpURLConnectionA.setReadTimeout(this.f66281b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e3) {
            throw new HttpException("URL.openConnection threw", 0, e3);
        }
    }

    private static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e3) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e3);
            return -1;
        }
    }

    private InputStream g(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f66284f = ContentLengthInputStream.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f66284f = httpURLConnection.getInputStream();
            }
            return this.f66284f;
        } catch (IOException e3) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), e3);
        }
    }

    private static boolean h(int i3) {
        return i3 / 100 == 2;
    }

    private static boolean i(int i3) {
        return i3 / 100 == 3;
    }

    private InputStream j(URL url, int i3, URL url2, Map map) throws HttpException {
        if (i3 >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.f66283d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.f66284f = this.f66283d.getInputStream();
            if (this.f66285g) {
                return null;
            }
            int iF = f(this.f66283d);
            if (h(iF)) {
                return g(this.f66283d);
            }
            if (!i(iF)) {
                if (iF == -1) {
                    throw new HttpException(iF);
                }
                try {
                    throw new HttpException(this.f66283d.getResponseMessage(), iF);
                } catch (IOException e3) {
                    throw new HttpException("Failed to get a response message", iF, e3);
                }
            }
            String headerField = this.f66283d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url", iF);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i3 + 1, url, map);
            } catch (MalformedURLException e4) {
                throw new HttpException("Bad redirect url: " + headerField, iF, e4);
            }
        } catch (IOException e5) {
            throw new HttpException("Failed to connect or obtain data", f(this.f66283d), e5);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        InputStream inputStream = this.f66284f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f66283d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f66283d = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f66285g = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
        long jB = LogTime.b();
        try {
            try {
                dataCallback.f(j(this.f66280a.h(), 0, null, this.f66280a.e()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(jB));
                }
            } catch (IOException e3) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e3);
                }
                dataCallback.c(e3);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(jB));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(jB));
            }
            throw th;
        }
    }

    HttpUrlFetcher(GlideUrl glideUrl, int i3, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.f66280a = glideUrl;
        this.f66281b = i3;
        this.f66282c = httpUrlConnectionFactory;
    }
}
