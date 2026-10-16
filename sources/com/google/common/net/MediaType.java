package com.google.common.net;

import com.facebook.GraphRequest;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.Immutable;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class MediaType {
    public static final MediaType A;
    public static final MediaType A0;
    public static final MediaType B;
    public static final MediaType B0;
    public static final MediaType C;
    public static final MediaType C0;
    public static final MediaType D;
    public static final MediaType D0;
    public static final MediaType E;
    public static final MediaType E0;
    public static final MediaType F;
    public static final MediaType F0;
    public static final MediaType G;
    public static final MediaType G0;
    public static final MediaType H;
    public static final MediaType H0;
    public static final MediaType I;
    public static final MediaType I0;
    public static final MediaType J;
    public static final MediaType J0;
    public static final MediaType K;
    public static final MediaType K0;
    public static final MediaType L;
    public static final MediaType L0;
    public static final MediaType M;
    public static final MediaType M0;
    public static final MediaType N;
    public static final MediaType N0;
    public static final MediaType O;
    public static final MediaType O0;
    public static final MediaType P;
    public static final MediaType P0;
    public static final MediaType Q;
    public static final MediaType Q0;
    public static final MediaType R;
    public static final MediaType R0;
    public static final MediaType S;
    public static final MediaType S0;
    public static final MediaType T;
    public static final MediaType T0;
    public static final MediaType U;
    public static final MediaType U0;
    public static final MediaType V;
    public static final MediaType V0;
    public static final MediaType W;
    public static final MediaType W0;
    public static final MediaType X;
    public static final MediaType X0;
    public static final MediaType Y;
    public static final MediaType Y0;
    public static final MediaType Z;
    public static final MediaType Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final MediaType f85352a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final MediaType f85353a1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final MediaType f85354b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final MediaType f85355b1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final MediaType f85356c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final MediaType f85357c1;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final MediaType f85358d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final MediaType f85359d1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final MediaType f85360e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final MediaType f85361e1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final MediaType f85362f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final MediaType f85363f1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final MediaType f85365g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final MediaType f85366g1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final MediaType f85368h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final MediaType f85369h1;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final MediaType f85371i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final MediaType f85372i1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final MediaType f85374j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final MediaType f85375j1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final MediaType f85377k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final MediaType f85378k1;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final MediaType f85380l0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final MediaType f85381l1;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final MediaType f85383m0;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final MediaType f85384m1;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final MediaType f85386n0;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final MediaType f85387n1;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final MediaType f85389o0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final MediaType f85390o1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final MediaType f85392p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final MediaType f85393p1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final MediaType f85395q0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final MediaType f85396q1;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final MediaType f85398r0;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final MediaType f85399r1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final MediaType f85401s0;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final MediaType f85402s1;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final MediaType f85404t0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final MediaType f85405t1;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final MediaType f85407u0;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final MediaType f85408u1;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final MediaType f85410v0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final MediaType f85411v1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final MediaType f85413w0;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final MediaType f85414w1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final MediaType f85416x0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private static final Joiner.MapJoiner f85417x1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final MediaType f85419y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final MediaType f85420z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final MediaType f85421z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f85422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f85423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableListMultimap f85424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f85425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f85426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Optional f85427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ImmutableListMultimap f85364g = ImmutableListMultimap.B("charset", Ascii.e(StandardCharsets.UTF_8.name()));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final CharMatcher f85367h = CharMatcher.f().b(CharMatcher.n().r()).b(CharMatcher.m(' ')).b(CharMatcher.t("()<>@,;:\\\"/[]?="));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final CharMatcher f85370i = CharMatcher.f().b(CharMatcher.t("\"\\\r"));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final CharMatcher f85373j = CharMatcher.d(" \t\r\n");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map f85376k = Maps.A();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final MediaType f85379l = d("*", "*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final MediaType f85382m = d("text", "*");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final MediaType f85385n = d("image", "*");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final MediaType f85388o = d("audio", "*");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final MediaType f85391p = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "*");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final MediaType f85394q = d("application", "*");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final MediaType f85397r = d("font", "*");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final MediaType f85400s = e("text", "cache-manifest");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final MediaType f85403t = e("text", "css");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final MediaType f85406u = e("text", "csv");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final MediaType f85409v = e("text", "html");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final MediaType f85412w = e("text", "calendar");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final MediaType f85415x = e("text", "markdown");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final MediaType f85418y = e("text", "plain");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Tokenizer {
    }

    private MediaType(String str, String str2, ImmutableListMultimap immutableListMultimap) {
        this.f85422a = str;
        this.f85423b = str2;
        this.f85424c = immutableListMultimap;
    }

    public static /* synthetic */ String a(String str) {
        return (!f85367h.p(str) || str.isEmpty()) ? f(str) : str;
    }

    private static MediaType b(MediaType mediaType) {
        f85376k.put(mediaType, mediaType);
        return mediaType;
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f85422a);
        sb.append('/');
        sb.append(this.f85423b);
        if (!this.f85424c.isEmpty()) {
            sb.append("; ");
            f85417x1.b(sb, Multimaps.f(this.f85424c, new Function() { // from class: com.google.common.net.a
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return MediaType.a((String) obj);
                }
            }).b());
        }
        return sb.toString();
    }

    private static MediaType d(String str, String str2) {
        MediaType mediaTypeB = b(new MediaType(str, str2, ImmutableListMultimap.A()));
        mediaTypeB.f85427f = Optional.a();
        return mediaTypeB;
    }

    private static MediaType e(String str, String str2) {
        MediaType mediaTypeB = b(new MediaType(str, str2, f85364g));
        mediaTypeB.f85427f = Optional.d(StandardCharsets.UTF_8);
        return mediaTypeB;
    }

    private static String f(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '\r' || cCharAt == '\\' || cCharAt == '\"') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        sb.append('\"');
        return sb.toString();
    }

    private Map g() {
        return Maps.Q(this.f85424c.a1(), new Function() { // from class: com.google.common.net.b
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ImmutableMultiset.l((Collection) obj);
            }
        });
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaType) {
            MediaType mediaType = (MediaType) obj;
            if (this.f85422a.equals(mediaType.f85422a) && this.f85423b.equals(mediaType.f85423b) && g().equals(mediaType.g())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f85426e;
        if (i3 != 0) {
            return i3;
        }
        int iB = Objects.b(this.f85422a, this.f85423b, g());
        this.f85426e = iB;
        return iB;
    }

    public String toString() {
        String str = this.f85425d;
        if (str != null) {
            return str;
        }
        String strC = c();
        this.f85425d = strC;
        return strC;
    }

    static {
        String str = wgbAZXYjrv.fDzeO;
        f85420z = e("text", str);
        A = e("text", "tab-separated-values");
        B = e("text", "vcard");
        C = e("text", "vnd.wap.wml");
        D = e("text", "xml");
        E = e("text", "vtt");
        F = d("image", "bmp");
        G = d("image", "x-canon-crw");
        H = d("image", "gif");
        I = d("image", "vnd.microsoft.icon");
        J = d("image", "jpeg");
        K = d("image", "png");
        L = d("image", "vnd.adobe.photoshop");
        M = e("image", "svg+xml");
        N = d("image", "tiff");
        O = d("image", "webp");
        P = d("image", "heif");
        Q = d("image", "jp2");
        R = d("audio", "mp4");
        S = d("audio", "mpeg");
        T = d("audio", "ogg");
        U = d("audio", "webm");
        V = d("audio", "l16");
        W = d("audio", "l24");
        X = d("audio", "basic");
        Y = d("audio", "aac");
        Z = d("audio", "vorbis");
        f85352a0 = d("audio", "x-ms-wma");
        f85354b0 = d("audio", "x-ms-wax");
        f85356c0 = d("audio", "vnd.rn-realaudio");
        f85358d0 = d("audio", "vnd.wave");
        f85360e0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "mp4");
        f85362f0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "mpeg");
        f85365g0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "ogg");
        f85368h0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "quicktime");
        f85371i0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "webm");
        f85374j0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "x-ms-wmv");
        f85377k0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "x-flv");
        f85380l0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "3gpp");
        f85383m0 = d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "3gpp2");
        f85386n0 = e("application", "xml");
        f85389o0 = e("application", "atom+xml");
        f85392p0 = d("application", "x-bzip2");
        f85395q0 = e("application", "dart");
        f85398r0 = d("application", "vnd.apple.pkpass");
        f85401s0 = d("application", "vnd.ms-fontobject");
        f85404t0 = d("application", "epub+zip");
        f85407u0 = d("application", "x-www-form-urlencoded");
        f85410v0 = d("application", "pkcs12");
        f85413w0 = d("application", "binary");
        f85416x0 = d("application", "geo+json");
        f85419y0 = d("application", "x-gzip");
        f85421z0 = d("application", "hal+json");
        A0 = e("application", str);
        B0 = d("application", "jose");
        C0 = d("application", "jose+json");
        D0 = e("application", GraphRequest.FORMAT_JSON);
        E0 = d("application", "jwt");
        F0 = e("application", "manifest+json");
        G0 = d("application", "vnd.google-earth.kml+xml");
        H0 = d("application", "vnd.google-earth.kmz");
        I0 = d("application", "mbox");
        J0 = d("application", "x-apple-aspen-config");
        K0 = d("application", "vnd.ms-excel");
        L0 = d("application", "vnd.ms-outlook");
        M0 = d("application", "vnd.ms-powerpoint");
        N0 = d("application", "msword");
        O0 = d("application", "dash+xml");
        P0 = d("application", "wasm");
        Q0 = d("application", "x-nacl");
        R0 = d("application", "x-pnacl");
        S0 = d("application", "octet-stream");
        T0 = d("application", "ogg");
        U0 = d("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
        V0 = d("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
        W0 = d("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        X0 = d("application", "vnd.oasis.opendocument.graphics");
        Y0 = d("application", "vnd.oasis.opendocument.presentation");
        Z0 = d("application", "vnd.oasis.opendocument.spreadsheet");
        f85353a1 = d("application", "vnd.oasis.opendocument.text");
        f85355b1 = e("application", "opensearchdescription+xml");
        f85357c1 = d("application", "pdf");
        f85359d1 = d("application", "postscript");
        f85361e1 = d("application", "protobuf");
        f85363f1 = e("application", "rdf+xml");
        f85366g1 = e("application", "rtf");
        f85369h1 = d("application", "font-sfnt");
        f85372i1 = d("application", "x-shockwave-flash");
        f85375j1 = d("application", "vnd.sketchup.skp");
        f85378k1 = e("application", "soap+xml");
        f85381l1 = d("application", "x-tar");
        f85384m1 = d("application", "font-woff");
        f85387n1 = d("application", "font-woff2");
        f85390o1 = e("application", "xhtml+xml");
        f85393p1 = e("application", "xrd+xml");
        f85396q1 = d("application", "zip");
        f85399r1 = d("font", "collection");
        f85402s1 = d("font", "otf");
        f85405t1 = d("font", "sfnt");
        f85408u1 = d("font", "ttf");
        f85411v1 = d("font", "woff");
        f85414w1 = d("font", "woff2");
        f85417x1 = Joiner.i("; ").m("=");
    }
}
