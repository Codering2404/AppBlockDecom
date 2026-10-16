package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpUrl f92995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f92996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Headers f92997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RequestBody f92998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f92999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile URI f93000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile CacheControl f93001g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HttpUrl f93002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f93003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Headers.Builder f93004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RequestBody f93005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Object f93006e;

        public Builder f(String str, String str2) {
            this.f93004c.b(str, str2);
            return this;
        }

        public Request g() {
            if (this.f93002a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder h(String str, String str2) {
            this.f93004c.h(str, str2);
            return this;
        }

        public Builder i(Headers headers) {
            this.f93004c = headers.e();
            return this;
        }

        public Builder j(String str, RequestBody requestBody) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !HttpMethod.d(str)) {
                this.f93003b = str;
                this.f93005d = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public Builder k(String str) {
            this.f93004c.g(str);
            return this;
        }

        public Builder l(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f93002a = httpUrl;
            return this;
        }

        public Builder m(String str) {
            String str2;
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str2 = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str2 = "https:" + str.substring(4);
            } else {
                str2 = str;
            }
            HttpUrl httpUrlU = HttpUrl.u(str2);
            if (httpUrlU != null) {
                return l(httpUrlU);
            }
            throw new IllegalArgumentException("unexpected url: " + str2);
        }

        public Builder() {
            this.f93003b = "GET";
            this.f93004c = new Headers.Builder();
        }

        private Builder(Request request) {
            this.f93002a = request.f92995a;
            this.f93003b = request.f92996b;
            this.f93005d = request.f92998d;
            this.f93006e = request.f92999e;
            this.f93004c = request.f92997c.e();
        }
    }

    public RequestBody f() {
        return this.f92998d;
    }

    public CacheControl g() {
        CacheControl cacheControl = this.f93001g;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlK = CacheControl.k(this.f92997c);
        this.f93001g = cacheControlK;
        return cacheControlK;
    }

    public String h(String str) {
        return this.f92997c.a(str);
    }

    public Headers i() {
        return this.f92997c;
    }

    public List j(String str) {
        return this.f92997c.h(str);
    }

    public HttpUrl k() {
        return this.f92995a;
    }

    public boolean l() {
        return this.f92995a.r();
    }

    public String m() {
        return this.f92996b;
    }

    public Builder n() {
        return new Builder();
    }

    public URI o() throws IOException {
        try {
            URI uri = this.f93000f;
            if (uri != null) {
                return uri;
            }
            URI uriF = this.f92995a.F();
            this.f93000f = uriF;
            return uriF;
        } catch (IllegalStateException e3) {
            throw new IOException(e3.getMessage());
        }
    }

    public String p() {
        return this.f92995a.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f92996b);
        sb.append(", url=");
        sb.append(this.f92995a);
        sb.append(", tag=");
        Object obj = this.f92999e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    private Request(Builder builder) {
        this.f92995a = builder.f93002a;
        this.f92996b = builder.f93003b;
        this.f92997c = builder.f93004c.e();
        this.f92998d = builder.f93005d;
        this.f92999e = builder.f93006e != null ? builder.f93006e : this;
    }
}
