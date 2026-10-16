package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MediaItem f40706i = new Builder().a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f40707j = Util.y0(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f40708k = Util.y0(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f40709l = Util.y0(2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f40710m = Util.y0(3);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f40711n = Util.y0(4);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f40712o = Util.y0(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocalConfiguration f40714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocalConfiguration f40715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveConfiguration f40716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MediaMetadata f40717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ClippingConfiguration f40718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ClippingProperties f40719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RequestMetadata f40720h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AdsConfiguration {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f40721c = Util.y0(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f40722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f40723b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            return this.f40722a.equals(adsConfiguration.f40722a) && Objects.equals(this.f40723b, adsConfiguration.f40723b);
        }

        public int hashCode() {
            int iHashCode = this.f40722a.hashCode() * 31;
            Object obj = this.f40723b;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f40724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f40725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f40726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ClippingConfiguration.Builder f40727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private DrmConfiguration.Builder f40728e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f40729f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f40730g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ImmutableList f40731h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private AdsConfiguration f40732i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Object f40733j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f40734k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private MediaMetadata f40735l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private LiveConfiguration.Builder f40736m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private RequestMetadata f40737n;

        public MediaItem a() {
            LocalConfiguration localConfiguration;
            Assertions.g(this.f40728e.f40779b == null || this.f40728e.f40778a != null);
            Uri uri = this.f40725b;
            if (uri != null) {
                localConfiguration = new LocalConfiguration(uri, this.f40726c, this.f40728e.f40778a != null ? this.f40728e.i() : null, this.f40732i, this.f40729f, this.f40730g, this.f40731h, this.f40733j, this.f40734k);
            } else {
                localConfiguration = null;
            }
            String str = this.f40724a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            ClippingProperties clippingPropertiesG = this.f40727d.g();
            LiveConfiguration liveConfigurationF = this.f40736m.f();
            MediaMetadata mediaMetadata = this.f40735l;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.K;
            }
            return new MediaItem(str2, clippingPropertiesG, localConfiguration, liveConfigurationF, mediaMetadata, this.f40737n);
        }

        public Builder b(ClippingConfiguration clippingConfiguration) {
            this.f40727d = clippingConfiguration.a();
            return this;
        }

        public Builder c(String str) {
            this.f40730g = str;
            return this;
        }

        public Builder d(DrmConfiguration drmConfiguration) {
            this.f40728e = drmConfiguration != null ? drmConfiguration.b() : new DrmConfiguration.Builder();
            return this;
        }

        public Builder e(LiveConfiguration liveConfiguration) {
            this.f40736m = liveConfiguration.a();
            return this;
        }

        public Builder f(String str) {
            this.f40724a = (String) Assertions.e(str);
            return this;
        }

        public Builder g(String str) {
            this.f40726c = str;
            return this;
        }

        public Builder h(List list) {
            this.f40729f = (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public Builder i(List list) {
            this.f40731h = ImmutableList.t(list);
            return this;
        }

        public Builder j(Object obj) {
            this.f40733j = obj;
            return this;
        }

        public Builder k(Uri uri) {
            this.f40725b = uri;
            return this;
        }

        public Builder l(String str) {
            return k(str == null ? null : Uri.parse(str));
        }

        public Builder() {
            this.f40727d = new ClippingConfiguration.Builder();
            this.f40728e = new DrmConfiguration.Builder();
            this.f40729f = Collections.EMPTY_LIST;
            this.f40731h = ImmutableList.y();
            this.f40736m = new LiveConfiguration.Builder();
            this.f40737n = RequestMetadata.f40820d;
            this.f40734k = -9223372036854775807L;
        }

        private Builder(MediaItem mediaItem) {
            DrmConfiguration.Builder builder;
            this();
            this.f40727d = mediaItem.f40718f.a();
            this.f40724a = mediaItem.f40713a;
            this.f40735l = mediaItem.f40717e;
            this.f40736m = mediaItem.f40716d.a();
            this.f40737n = mediaItem.f40720h;
            LocalConfiguration localConfiguration = mediaItem.f40714b;
            if (localConfiguration != null) {
                this.f40730g = localConfiguration.f40815f;
                this.f40726c = localConfiguration.f40811b;
                this.f40725b = localConfiguration.f40810a;
                this.f40729f = localConfiguration.f40814e;
                this.f40731h = localConfiguration.f40816g;
                this.f40733j = localConfiguration.f40818i;
                DrmConfiguration drmConfiguration = localConfiguration.f40812c;
                if (drmConfiguration != null) {
                    builder = drmConfiguration.b();
                } else {
                    builder = new DrmConfiguration.Builder();
                }
                this.f40728e = builder;
                this.f40732i = localConfiguration.f40813d;
                this.f40734k = localConfiguration.f40819j;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ClippingConfiguration {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final ClippingConfiguration f40738h = new Builder().f();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f40739i = Util.y0(0);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f40740j = Util.y0(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f40741k = Util.y0(2);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f40742l = Util.y0(3);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f40743m = Util.y0(4);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final String f40744n = Util.y0(5);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final String f40745o = Util.y0(6);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f40746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f40747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f40748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f40749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f40750e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f40751f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f40752g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f40753a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f40754b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f40755c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f40756d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f40757e;

            public ClippingConfiguration f() {
                return new ClippingConfiguration(this);
            }

            public ClippingProperties g() {
                return new ClippingProperties(this);
            }

            public Builder h(long j3) {
                return i(Util.P0(j3));
            }

            public Builder i(long j3) {
                Assertions.a(j3 == Long.MIN_VALUE || j3 >= 0);
                this.f40754b = j3;
                return this;
            }

            public Builder j(long j3) {
                return k(Util.P0(j3));
            }

            public Builder k(long j3) {
                Assertions.a(j3 >= 0);
                this.f40753a = j3;
                return this;
            }

            public Builder l(boolean z2) {
                this.f40757e = z2;
                return this;
            }

            public Builder() {
                this.f40754b = Long.MIN_VALUE;
            }

            private Builder(ClippingConfiguration clippingConfiguration) {
                this.f40753a = clippingConfiguration.f40747b;
                this.f40754b = clippingConfiguration.f40749d;
                this.f40755c = clippingConfiguration.f40750e;
                this.f40756d = clippingConfiguration.f40751f;
                this.f40757e = clippingConfiguration.f40752g;
            }
        }

        public Builder a() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            return this.f40747b == clippingConfiguration.f40747b && this.f40749d == clippingConfiguration.f40749d && this.f40750e == clippingConfiguration.f40750e && this.f40751f == clippingConfiguration.f40751f && this.f40752g == clippingConfiguration.f40752g;
        }

        public int hashCode() {
            long j3 = this.f40747b;
            int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
            long j4 = this.f40749d;
            return ((((((i3 + ((int) ((j4 >>> 32) ^ j4))) * 31) + (this.f40750e ? 1 : 0)) * 31) + (this.f40751f ? 1 : 0)) * 31) + (this.f40752g ? 1 : 0);
        }

        private ClippingConfiguration(Builder builder) {
            this.f40746a = Util.t1(builder.f40753a);
            this.f40748c = Util.t1(builder.f40754b);
            this.f40747b = builder.f40753a;
            this.f40749d = builder.f40754b;
            this.f40750e = builder.f40755c;
            this.f40751f = builder.f40756d;
            this.f40752g = builder.f40757e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final ClippingProperties f40758p = new ClippingConfiguration.Builder().g();

        private ClippingProperties(ClippingConfiguration.Builder builder) {
            super(builder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DrmConfiguration {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f40759l = Util.y0(0);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f40760m = Util.y0(1);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f40761n = Util.y0(2);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f40762o = Util.y0(3);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final String f40763p = Util.y0(4);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final String f40764q = Util.y0(5);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final String f40765r = Util.y0(6);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final String f40766s = Util.y0(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f40767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f40768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f40769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImmutableMap f40770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImmutableMap f40771e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f40772f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f40773g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f40774h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ImmutableList f40775i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ImmutableList f40776j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final byte[] f40777k;

        public Builder b() {
            return new Builder();
        }

        public byte[] c() {
            byte[] bArr = this.f40777k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.f40767a.equals(drmConfiguration.f40767a) && Objects.equals(this.f40769c, drmConfiguration.f40769c) && Objects.equals(this.f40771e, drmConfiguration.f40771e) && this.f40772f == drmConfiguration.f40772f && this.f40774h == drmConfiguration.f40774h && this.f40773g == drmConfiguration.f40773g && this.f40776j.equals(drmConfiguration.f40776j) && Arrays.equals(this.f40777k, drmConfiguration.f40777k);
        }

        public int hashCode() {
            int iHashCode = this.f40767a.hashCode() * 31;
            Uri uri = this.f40769c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f40771e.hashCode()) * 31) + (this.f40772f ? 1 : 0)) * 31) + (this.f40774h ? 1 : 0)) * 31) + (this.f40773g ? 1 : 0)) * 31) + this.f40776j.hashCode()) * 31) + Arrays.hashCode(this.f40777k);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private UUID f40778a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Uri f40779b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private ImmutableMap f40780c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f40781d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f40782e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f40783f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private ImmutableList f40784g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private byte[] f40785h;

            public DrmConfiguration i() {
                return new DrmConfiguration(this);
            }

            private Builder() {
                this.f40780c = ImmutableMap.n();
                this.f40782e = true;
                this.f40784g = ImmutableList.y();
            }

            private Builder(DrmConfiguration drmConfiguration) {
                this.f40778a = drmConfiguration.f40767a;
                this.f40779b = drmConfiguration.f40769c;
                this.f40780c = drmConfiguration.f40771e;
                this.f40781d = drmConfiguration.f40772f;
                this.f40782e = drmConfiguration.f40773g;
                this.f40783f = drmConfiguration.f40774h;
                this.f40784g = drmConfiguration.f40776j;
                this.f40785h = drmConfiguration.f40777k;
            }
        }

        private DrmConfiguration(Builder builder) {
            Assertions.g((builder.f40783f && builder.f40779b == null) ? false : true);
            UUID uuid = (UUID) Assertions.e(builder.f40778a);
            this.f40767a = uuid;
            this.f40768b = uuid;
            this.f40769c = builder.f40779b;
            this.f40770d = builder.f40780c;
            this.f40771e = builder.f40780c;
            this.f40772f = builder.f40781d;
            this.f40774h = builder.f40783f;
            this.f40773g = builder.f40782e;
            this.f40775i = builder.f40784g;
            this.f40776j = builder.f40784g;
            this.f40777k = builder.f40785h != null ? Arrays.copyOf(builder.f40785h, builder.f40785h.length) : null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LiveConfiguration {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final LiveConfiguration f40786f = new Builder().f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f40787g = Util.y0(0);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f40788h = Util.y0(1);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f40789i = Util.y0(2);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f40790j = Util.y0(3);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f40791k = Util.y0(4);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f40792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f40793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f40794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f40795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f40796e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f40797a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f40798b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private long f40799c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f40800d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private float f40801e;

            public LiveConfiguration f() {
                return new LiveConfiguration(this);
            }

            public Builder g(long j3) {
                this.f40799c = j3;
                return this;
            }

            public Builder h(float f3) {
                this.f40801e = f3;
                return this;
            }

            public Builder i(long j3) {
                this.f40798b = j3;
                return this;
            }

            public Builder j(float f3) {
                this.f40800d = f3;
                return this;
            }

            public Builder k(long j3) {
                this.f40797a = j3;
                return this;
            }

            public Builder() {
                this.f40797a = -9223372036854775807L;
                this.f40798b = -9223372036854775807L;
                this.f40799c = -9223372036854775807L;
                this.f40800d = -3.4028235E38f;
                this.f40801e = -3.4028235E38f;
            }

            private Builder(LiveConfiguration liveConfiguration) {
                this.f40797a = liveConfiguration.f40792a;
                this.f40798b = liveConfiguration.f40793b;
                this.f40799c = liveConfiguration.f40794c;
                this.f40800d = liveConfiguration.f40795d;
                this.f40801e = liveConfiguration.f40796e;
            }
        }

        public Builder a() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            return this.f40792a == liveConfiguration.f40792a && this.f40793b == liveConfiguration.f40793b && this.f40794c == liveConfiguration.f40794c && this.f40795d == liveConfiguration.f40795d && this.f40796e == liveConfiguration.f40796e;
        }

        public int hashCode() {
            long j3 = this.f40792a;
            long j4 = this.f40793b;
            int i3 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f40794c;
            int i4 = (i3 + ((int) ((j5 >>> 32) ^ j5))) * 31;
            float f3 = this.f40795d;
            int iFloatToIntBits = (i4 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f40796e;
            return iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
        }

        private LiveConfiguration(Builder builder) {
            this(builder.f40797a, builder.f40798b, builder.f40799c, builder.f40800d, builder.f40801e);
        }

        public LiveConfiguration(long j3, long j4, long j5, float f3, float f4) {
            this.f40792a = j3;
            this.f40793b = j4;
            this.f40794c = j5;
            this.f40795d = f3;
            this.f40796e = f4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LocalConfiguration {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f40802k = Util.y0(0);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f40803l = Util.y0(1);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f40804m = Util.y0(2);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f40805n = Util.y0(3);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f40806o = Util.y0(4);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final String f40807p = Util.y0(5);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final String f40808q = Util.y0(6);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final String f40809r = Util.y0(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f40810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DrmConfiguration f40812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AdsConfiguration f40813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f40814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f40815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ImmutableList f40816g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List f40817h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Object f40818i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f40819j;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            return this.f40810a.equals(localConfiguration.f40810a) && Objects.equals(this.f40811b, localConfiguration.f40811b) && Objects.equals(this.f40812c, localConfiguration.f40812c) && Objects.equals(this.f40813d, localConfiguration.f40813d) && this.f40814e.equals(localConfiguration.f40814e) && Objects.equals(this.f40815f, localConfiguration.f40815f) && this.f40816g.equals(localConfiguration.f40816g) && Objects.equals(this.f40818i, localConfiguration.f40818i) && this.f40819j == localConfiguration.f40819j;
        }

        public int hashCode() {
            int iHashCode = this.f40810a.hashCode() * 31;
            String str = this.f40811b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration = this.f40812c;
            int iHashCode3 = (iHashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31;
            AdsConfiguration adsConfiguration = this.f40813d;
            int iHashCode4 = (((iHashCode3 + (adsConfiguration == null ? 0 : adsConfiguration.hashCode())) * 31) + this.f40814e.hashCode()) * 31;
            String str2 = this.f40815f;
            int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f40816g.hashCode()) * 31;
            Object obj = this.f40818i;
            return (int) ((((long) (iHashCode5 + (obj != null ? obj.hashCode() : 0))) * 31) + this.f40819j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private LocalConfiguration(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List list, String str2, ImmutableList immutableList, Object obj, long j3) {
            this.f40810a = uri;
            this.f40811b = MimeTypes.r(str);
            this.f40812c = drmConfiguration;
            this.f40813d = adsConfiguration;
            this.f40814e = list;
            this.f40815f = str2;
            this.f40816g = immutableList;
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                builderO.a(((SubtitleConfiguration) immutableList.get(i3)).a().i());
            }
            this.f40817h = builderO.m();
            this.f40818i = obj;
            this.f40819j = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class RequestMetadata {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final RequestMetadata f40820d = new Builder().d();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f40821e = Util.y0(0);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f40822f = Util.y0(1);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f40823g = Util.y0(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f40824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f40826c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Uri f40827a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f40828b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Bundle f40829c;

            public RequestMetadata d() {
                return new RequestMetadata(this);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (Objects.equals(this.f40824a, requestMetadata.f40824a) && Objects.equals(this.f40825b, requestMetadata.f40825b)) {
                if ((this.f40826c == null) == (requestMetadata.f40826c == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.f40824a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f40825b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f40826c != null ? 1 : 0);
        }

        private RequestMetadata(Builder builder) {
            this.f40824a = builder.f40827a;
            this.f40825b = builder.f40828b;
            this.f40826c = builder.f40829c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
        private Subtitle(SubtitleConfiguration.Builder builder) {
            super(builder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SubtitleConfiguration {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f40830h = Util.y0(0);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f40831i = Util.y0(1);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f40832j = Util.y0(2);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f40833k = Util.y0(3);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f40834l = Util.y0(4);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f40835m = Util.y0(5);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f40836n = Util.y0(6);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f40837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f40839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f40840d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f40841e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f40842f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f40843g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Uri f40844a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f40845b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f40846c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f40847d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f40848e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private String f40849f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f40850g;

            /* JADX INFO: Access modifiers changed from: private */
            public Subtitle i() {
                return new Subtitle(this);
            }

            private Builder(SubtitleConfiguration subtitleConfiguration) {
                this.f40844a = subtitleConfiguration.f40837a;
                this.f40845b = subtitleConfiguration.f40838b;
                this.f40846c = subtitleConfiguration.f40839c;
                this.f40847d = subtitleConfiguration.f40840d;
                this.f40848e = subtitleConfiguration.f40841e;
                this.f40849f = subtitleConfiguration.f40842f;
                this.f40850g = subtitleConfiguration.f40843g;
            }
        }

        public Builder a() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            return this.f40837a.equals(subtitleConfiguration.f40837a) && Objects.equals(this.f40838b, subtitleConfiguration.f40838b) && Objects.equals(this.f40839c, subtitleConfiguration.f40839c) && this.f40840d == subtitleConfiguration.f40840d && this.f40841e == subtitleConfiguration.f40841e && Objects.equals(this.f40842f, subtitleConfiguration.f40842f) && Objects.equals(this.f40843g, subtitleConfiguration.f40843g);
        }

        public int hashCode() {
            int iHashCode = this.f40837a.hashCode() * 31;
            String str = this.f40838b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f40839c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f40840d) * 31) + this.f40841e) * 31;
            String str3 = this.f40842f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f40843g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        private SubtitleConfiguration(Builder builder) {
            this.f40837a = builder.f40844a;
            this.f40838b = builder.f40845b;
            this.f40839c = builder.f40846c;
            this.f40840d = builder.f40847d;
            this.f40841e = builder.f40848e;
            this.f40842f = builder.f40849f;
            this.f40843g = builder.f40850g;
        }
    }

    public static MediaItem b(Uri uri) {
        return new Builder().k(uri).a();
    }

    public static MediaItem c(String str) {
        return new Builder().l(str).a();
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Objects.equals(this.f40713a, mediaItem.f40713a) && this.f40718f.equals(mediaItem.f40718f) && Objects.equals(this.f40714b, mediaItem.f40714b) && Objects.equals(this.f40716d, mediaItem.f40716d) && Objects.equals(this.f40717e, mediaItem.f40717e) && Objects.equals(this.f40720h, mediaItem.f40720h);
    }

    public int hashCode() {
        int iHashCode = this.f40713a.hashCode() * 31;
        LocalConfiguration localConfiguration = this.f40714b;
        return ((((((((iHashCode + (localConfiguration != null ? localConfiguration.hashCode() : 0)) * 31) + this.f40716d.hashCode()) * 31) + this.f40718f.hashCode()) * 31) + this.f40717e.hashCode()) * 31) + this.f40720h.hashCode();
    }

    private MediaItem(String str, ClippingProperties clippingProperties, LocalConfiguration localConfiguration, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.f40713a = str;
        this.f40714b = localConfiguration;
        this.f40715c = localConfiguration;
        this.f40716d = liveConfiguration;
        this.f40717e = mediaMetadata;
        this.f40718f = clippingProperties;
        this.f40719g = clippingProperties;
        this.f40720h = requestMetadata;
    }
}
