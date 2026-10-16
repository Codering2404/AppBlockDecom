package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f41829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f41830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f41832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f41833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f41834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f41835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f41836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f41837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f41838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f41839k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f41840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f41841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f41842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f41843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f41844e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f41845f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f41846g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f41847h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f41848i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Object f41849j;

        public DataSpec a() {
            Assertions.j(this.f41840a, "The uri must be set.");
            return new DataSpec(this.f41840a, this.f41841b, this.f41842c, this.f41843d, this.f41844e, this.f41845f, this.f41846g, this.f41847h, this.f41848i, this.f41849j);
        }

        public Builder b(int i3) {
            this.f41848i = i3;
            return this;
        }

        public Builder c(byte[] bArr) {
            this.f41843d = bArr;
            return this;
        }

        public Builder d(int i3) {
            this.f41842c = i3;
            return this;
        }

        public Builder e(Map map) {
            this.f41844e = map;
            return this;
        }

        public Builder f(String str) {
            this.f41847h = str;
            return this;
        }

        public Builder g(long j3) {
            this.f41846g = j3;
            return this;
        }

        public Builder h(long j3) {
            this.f41845f = j3;
            return this;
        }

        public Builder i(Uri uri) {
            this.f41840a = uri;
            return this;
        }

        public Builder j(String str) {
            this.f41840a = Uri.parse(str);
            return this;
        }

        public Builder k(long j3) {
            this.f41841b = j3;
            return this;
        }

        public Builder() {
            this.f41842c = 1;
            this.f41844e = Collections.EMPTY_MAP;
            this.f41846g = -1L;
        }

        private Builder(DataSpec dataSpec) {
            this.f41840a = dataSpec.f41829a;
            this.f41841b = dataSpec.f41830b;
            this.f41842c = dataSpec.f41831c;
            this.f41843d = dataSpec.f41832d;
            this.f41844e = dataSpec.f41833e;
            this.f41845f = dataSpec.f41835g;
            this.f41846g = dataSpec.f41836h;
            this.f41847h = dataSpec.f41837i;
            this.f41848i = dataSpec.f41838j;
            this.f41849j = dataSpec.f41839k;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    static {
        MediaLibraryInfo.a("media3.datasource");
    }

    public static String c(int i3) {
        if (i3 == 1) {
            return "GET";
        }
        if (i3 == 2) {
            return "POST";
        }
        if (i3 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public Builder a() {
        return new Builder();
    }

    public final String b() {
        return c(this.f41831c);
    }

    public boolean d(int i3) {
        return (this.f41838j & i3) == i3;
    }

    public DataSpec e(long j3) {
        long j4 = this.f41836h;
        return f(j3, j4 != -1 ? j4 - j3 : -1L);
    }

    public DataSpec f(long j3, long j4) {
        return (j3 == 0 && this.f41836h == j4) ? this : new DataSpec(this.f41829a, this.f41830b, this.f41831c, this.f41832d, this.f41833e, this.f41835g + j3, j4, this.f41837i, this.f41838j, this.f41839k);
    }

    public DataSpec g(Uri uri) {
        return new DataSpec(uri, this.f41830b, this.f41831c, this.f41832d, this.f41833e, this.f41835g, this.f41836h, this.f41837i, this.f41838j, this.f41839k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f41829a + ", " + this.f41835g + ", " + this.f41836h + ", " + this.f41837i + ", " + this.f41838j + "]";
    }

    public DataSpec(Uri uri) {
        this(uri, 0L, -1L);
    }

    public DataSpec(Uri uri, long j3, long j4) {
        this(uri, j3, j4, null);
    }

    public DataSpec(Uri uri, long j3, long j4, String str) {
        this(uri, 0L, 1, null, Collections.EMPTY_MAP, j3, j4, str, 0, null);
    }

    private DataSpec(Uri uri, long j3, int i3, byte[] bArr, Map map, long j4, long j5, String str, int i4, Object obj) {
        byte[] bArr2 = bArr;
        long j6 = j3 + j4;
        Assertions.a(j6 >= 0);
        Assertions.a(j4 >= 0);
        Assertions.a(j5 > 0 || j5 == -1);
        this.f41829a = (Uri) Assertions.e(uri);
        this.f41830b = j3;
        this.f41831c = i3;
        this.f41832d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f41833e = Collections.unmodifiableMap(new HashMap(map));
        this.f41835g = j4;
        this.f41834f = j6;
        this.f41836h = j5;
        this.f41837i = str;
        this.f41838j = i4;
        this.f41839k = obj;
    }
}
