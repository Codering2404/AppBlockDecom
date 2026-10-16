package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Response {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Request f93015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Protocol f93016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f93017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f93018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handshake f93019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Headers f93020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ResponseBody f93021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Response f93022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Response f93023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Response f93024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile CacheControl f93025k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Request f93026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Protocol f93027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f93028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f93029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handshake f93030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Headers.Builder f93031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ResponseBody f93032g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Response f93033h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Response f93034i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Response f93035j;

        private void o(Response response) {
            if (response.f93021g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void p(String str, Response response) {
            if (response.f93021g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (response.f93022h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.f93023i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.f93024j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public Builder k(String str, String str2) {
            this.f93031f.b(str, str2);
            return this;
        }

        public Builder l(ResponseBody responseBody) {
            this.f93032g = responseBody;
            return this;
        }

        public Response m() {
            if (this.f93026a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f93027b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f93028c >= 0) {
                return new Response(this);
            }
            throw new IllegalStateException("code < 0: " + this.f93028c);
        }

        public Builder n(Response response) {
            if (response != null) {
                p("cacheResponse", response);
            }
            this.f93034i = response;
            return this;
        }

        public Builder q(int i3) {
            this.f93028c = i3;
            return this;
        }

        public Builder r(Handshake handshake) {
            this.f93030e = handshake;
            return this;
        }

        public Builder s(String str, String str2) {
            this.f93031f.h(str, str2);
            return this;
        }

        public Builder t(Headers headers) {
            this.f93031f = headers.e();
            return this;
        }

        public Builder u(String str) {
            this.f93029d = str;
            return this;
        }

        public Builder v(Response response) {
            if (response != null) {
                p("networkResponse", response);
            }
            this.f93033h = response;
            return this;
        }

        public Builder w(Response response) {
            if (response != null) {
                o(response);
            }
            this.f93035j = response;
            return this;
        }

        public Builder x(Protocol protocol) {
            this.f93027b = protocol;
            return this;
        }

        public Builder y(Request request) {
            this.f93026a = request;
            return this;
        }

        public Builder() {
            this.f93028c = -1;
            this.f93031f = new Headers.Builder();
        }

        private Builder(Response response) {
            this.f93028c = -1;
            this.f93026a = response.f93015a;
            this.f93027b = response.f93016b;
            this.f93028c = response.f93017c;
            this.f93029d = response.f93018d;
            this.f93030e = response.f93019e;
            this.f93031f = response.f93020f.e();
            this.f93032g = response.f93021g;
            this.f93033h = response.f93022h;
            this.f93034i = response.f93023i;
            this.f93035j = response.f93024j;
        }
    }

    public ResponseBody k() {
        return this.f93021g;
    }

    public CacheControl l() {
        CacheControl cacheControl = this.f93025k;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlK = CacheControl.k(this.f93020f);
        this.f93025k = cacheControlK;
        return cacheControlK;
    }

    public List m() {
        String str;
        int i3 = this.f93017c;
        if (i3 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i3 != 407) {
                return Collections.EMPTY_LIST;
            }
            str = "Proxy-Authenticate";
        }
        return OkHeaders.i(r(), str);
    }

    public int n() {
        return this.f93017c;
    }

    public Handshake o() {
        return this.f93019e;
    }

    public String p(String str) {
        return q(str, null);
    }

    public String q(String str, String str2) {
        String strA = this.f93020f.a(str);
        return strA != null ? strA : str2;
    }

    public Headers r() {
        return this.f93020f;
    }

    public String s() {
        return this.f93018d;
    }

    public Response t() {
        return this.f93022h;
    }

    public String toString() {
        return "Response{protocol=" + this.f93016b + ", code=" + this.f93017c + ", message=" + this.f93018d + ", url=" + this.f93015a.p() + '}';
    }

    public Builder u() {
        return new Builder();
    }

    public Protocol v() {
        return this.f93016b;
    }

    public Request w() {
        return this.f93015a;
    }

    private Response(Builder builder) {
        this.f93015a = builder.f93026a;
        this.f93016b = builder.f93027b;
        this.f93017c = builder.f93028c;
        this.f93018d = builder.f93029d;
        this.f93019e = builder.f93030e;
        this.f93020f = builder.f93031f.e();
        this.f93021g = builder.f93032g;
        this.f93022h = builder.f93033h;
        this.f93023i = builder.f93034i;
        this.f93024j = builder.f93035j;
    }
}
