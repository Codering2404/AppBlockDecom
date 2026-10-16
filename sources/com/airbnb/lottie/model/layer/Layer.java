package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Layer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LottieComposition f56889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f56890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f56891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LayerType f56892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f56893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f56894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f56895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AnimatableTransform f56896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f56897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f56898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f56899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f56900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f56901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f56902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final float f56903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AnimatableTextFrame f56904q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AnimatableTextProperties f56905r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AnimatableFloatValue f56906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f56907t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MatteType f56908u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f56909v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final BlurEffect f56910w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final DropShadowEffect f56911x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List list, LottieComposition lottieComposition, String str, long j3, LayerType layerType, long j4, String str2, List list2, AnimatableTransform animatableTransform, int i3, int i4, int i5, float f3, float f4, float f5, float f6, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z2, BlurEffect blurEffect, DropShadowEffect dropShadowEffect) {
        this.f56888a = list;
        this.f56889b = lottieComposition;
        this.f56890c = str;
        this.f56891d = j3;
        this.f56892e = layerType;
        this.f56893f = j4;
        this.f56894g = str2;
        this.f56895h = list2;
        this.f56896i = animatableTransform;
        this.f56897j = i3;
        this.f56898k = i4;
        this.f56899l = i5;
        this.f56900m = f3;
        this.f56901n = f4;
        this.f56902o = f5;
        this.f56903p = f6;
        this.f56904q = animatableTextFrame;
        this.f56905r = animatableTextProperties;
        this.f56907t = list3;
        this.f56908u = matteType;
        this.f56906s = animatableFloatValue;
        this.f56909v = z2;
        this.f56910w = blurEffect;
        this.f56911x = dropShadowEffect;
    }

    public BlurEffect a() {
        return this.f56910w;
    }

    LottieComposition b() {
        return this.f56889b;
    }

    public DropShadowEffect c() {
        return this.f56911x;
    }

    public long d() {
        return this.f56891d;
    }

    List e() {
        return this.f56907t;
    }

    public LayerType f() {
        return this.f56892e;
    }

    List g() {
        return this.f56895h;
    }

    MatteType h() {
        return this.f56908u;
    }

    public String i() {
        return this.f56890c;
    }

    long j() {
        return this.f56893f;
    }

    float k() {
        return this.f56903p;
    }

    float l() {
        return this.f56902o;
    }

    public String m() {
        return this.f56894g;
    }

    List n() {
        return this.f56888a;
    }

    int o() {
        return this.f56899l;
    }

    int p() {
        return this.f56898k;
    }

    int q() {
        return this.f56897j;
    }

    float r() {
        return this.f56901n / this.f56889b.e();
    }

    AnimatableTextFrame s() {
        return this.f56904q;
    }

    AnimatableTextProperties t() {
        return this.f56905r;
    }

    public String toString() {
        return y("");
    }

    AnimatableFloatValue u() {
        return this.f56906s;
    }

    float v() {
        return this.f56900m;
    }

    AnimatableTransform w() {
        return this.f56896i;
    }

    public boolean x() {
        return this.f56909v;
    }

    public String y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        sb.append("\n");
        Layer layerT = this.f56889b.t(j());
        if (layerT != null) {
            sb.append("\t\tParents: ");
            sb.append(layerT.i());
            Layer layerT2 = this.f56889b.t(layerT.j());
            while (layerT2 != null) {
                sb.append("->");
                sb.append(layerT2.i());
                layerT2 = this.f56889b.t(layerT2.j());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!g().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(g().size());
            sb.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f56888a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.f56888a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
