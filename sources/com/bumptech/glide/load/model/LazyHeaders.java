package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.facebook.GraphRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyHeaders implements Headers {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f66710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map f66711d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f66712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map f66713e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f66714a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f66715b = f66713e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f66716c = true;

        static {
            String strB = b();
            f66712d = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put(GraphRequest.USER_AGENT_HEADER, Collections.singletonList(new StringHeaderFactory(strB)));
            }
            f66713e = Collections.unmodifiableMap(map);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = property.charAt(i3);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public LazyHeaders a() {
            this.f66714a = true;
            return new LazyHeaders(this.f66715b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StringHeaderFactory implements LazyHeaderFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f66717a;

        StringHeaderFactory(String str) {
            this.f66717a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String a() {
            return this.f66717a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f66717a.equals(((StringHeaderFactory) obj).f66717a);
            }
            return false;
        }

        public int hashCode() {
            return this.f66717a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f66717a + "'}";
        }
    }

    LazyHeaders(Map map) {
        this.f66710c = Collections.unmodifiableMap(map);
    }

    private String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            String strA = ((LazyHeaderFactory) list.get(i3)).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i3 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map c() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f66710c.entrySet()) {
            String strB = b((List) entry.getValue());
            if (!TextUtils.isEmpty(strB)) {
                map.put((String) entry.getKey(), strB);
            }
        }
        return map;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map a() {
        if (this.f66711d == null) {
            synchronized (this) {
                try {
                    if (this.f66711d == null) {
                        this.f66711d = Collections.unmodifiableMap(c());
                    }
                } finally {
                }
            }
        }
        return this.f66711d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f66710c.equals(((LazyHeaders) obj).f66710c);
        }
        return false;
    }

    public int hashCode() {
        return this.f66710c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f66710c + '}';
    }
}
