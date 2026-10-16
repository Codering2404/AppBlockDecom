package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f67092a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f67096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f67097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f67098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f67099i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f67104n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f67106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f67107q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f67111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Resources.Theme f67112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f67113w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f67114x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f67115y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f67093b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DiskCacheStrategy f67094c = DiskCacheStrategy.f66409e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Priority f67095d = Priority.NORMAL;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f67100j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f67101k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f67102l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Key f67103m = EmptySignature.c();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f67105o = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Options f67108r = new Options();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map f67109s = new CachedHashCodeArrayMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Class f67110t = Object.class;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f67116z = true;

    private boolean N(int i3) {
        return O(this.f67092a, i3);
    }

    private static boolean O(int i3, int i4) {
        return (i3 & i4) != 0;
    }

    private BaseRequestOptions Y(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        return f0(downsampleStrategy, transformation, false);
    }

    private BaseRequestOptions f0(DownsampleStrategy downsampleStrategy, Transformation transformation, boolean z2) {
        BaseRequestOptions baseRequestOptionsP0 = z2 ? p0(downsampleStrategy, transformation) : Z(downsampleStrategy, transformation);
        baseRequestOptionsP0.f67116z = true;
        return baseRequestOptionsP0;
    }

    public final Class A() {
        return this.f67110t;
    }

    public final Key B() {
        return this.f67103m;
    }

    public final float D() {
        return this.f67093b;
    }

    public final Resources.Theme E() {
        return this.f67112v;
    }

    public final Map F() {
        return this.f67109s;
    }

    public final boolean G() {
        return this.A;
    }

    public final boolean H() {
        return this.f67114x;
    }

    protected final boolean I() {
        return this.f67113w;
    }

    public final boolean J(BaseRequestOptions baseRequestOptions) {
        return Float.compare(baseRequestOptions.f67093b, this.f67093b) == 0 && this.f67097g == baseRequestOptions.f67097g && Util.e(this.f67096f, baseRequestOptions.f67096f) && this.f67099i == baseRequestOptions.f67099i && Util.e(this.f67098h, baseRequestOptions.f67098h) && this.f67107q == baseRequestOptions.f67107q && Util.e(this.f67106p, baseRequestOptions.f67106p) && this.f67100j == baseRequestOptions.f67100j && this.f67101k == baseRequestOptions.f67101k && this.f67102l == baseRequestOptions.f67102l && this.f67104n == baseRequestOptions.f67104n && this.f67105o == baseRequestOptions.f67105o && this.f67114x == baseRequestOptions.f67114x && this.f67115y == baseRequestOptions.f67115y && this.f67094c.equals(baseRequestOptions.f67094c) && this.f67095d == baseRequestOptions.f67095d && this.f67108r.equals(baseRequestOptions.f67108r) && this.f67109s.equals(baseRequestOptions.f67109s) && this.f67110t.equals(baseRequestOptions.f67110t) && Util.e(this.f67103m, baseRequestOptions.f67103m) && Util.e(this.f67112v, baseRequestOptions.f67112v);
    }

    public final boolean K() {
        return this.f67100j;
    }

    public final boolean L() {
        return N(8);
    }

    boolean M() {
        return this.f67116z;
    }

    public final boolean P() {
        return this.f67105o;
    }

    public final boolean Q() {
        return this.f67104n;
    }

    public final boolean R() {
        return N(2048);
    }

    public final boolean S() {
        return Util.v(this.f67102l, this.f67101k);
    }

    public BaseRequestOptions U() {
        this.f67111u = true;
        return g0();
    }

    public BaseRequestOptions V() {
        return Z(DownsampleStrategy.f66843e, new CenterCrop());
    }

    public BaseRequestOptions W() {
        return Y(DownsampleStrategy.f66842d, new CenterInside());
    }

    public BaseRequestOptions X() {
        return Y(DownsampleStrategy.f66841c, new FitCenter());
    }

    final BaseRequestOptions Z(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        if (this.f67113w) {
            return clone().Z(downsampleStrategy, transformation);
        }
        j(downsampleStrategy);
        return o0(transformation, false);
    }

    public BaseRequestOptions a(BaseRequestOptions baseRequestOptions) {
        if (this.f67113w) {
            return clone().a(baseRequestOptions);
        }
        if (O(baseRequestOptions.f67092a, 2)) {
            this.f67093b = baseRequestOptions.f67093b;
        }
        if (O(baseRequestOptions.f67092a, 262144)) {
            this.f67114x = baseRequestOptions.f67114x;
        }
        if (O(baseRequestOptions.f67092a, 1048576)) {
            this.A = baseRequestOptions.A;
        }
        if (O(baseRequestOptions.f67092a, 4)) {
            this.f67094c = baseRequestOptions.f67094c;
        }
        if (O(baseRequestOptions.f67092a, 8)) {
            this.f67095d = baseRequestOptions.f67095d;
        }
        if (O(baseRequestOptions.f67092a, 16)) {
            this.f67096f = baseRequestOptions.f67096f;
            this.f67097g = 0;
            this.f67092a &= -33;
        }
        if (O(baseRequestOptions.f67092a, 32)) {
            this.f67097g = baseRequestOptions.f67097g;
            this.f67096f = null;
            this.f67092a &= -17;
        }
        if (O(baseRequestOptions.f67092a, 64)) {
            this.f67098h = baseRequestOptions.f67098h;
            this.f67099i = 0;
            this.f67092a &= -129;
        }
        if (O(baseRequestOptions.f67092a, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) {
            this.f67099i = baseRequestOptions.f67099i;
            this.f67098h = null;
            this.f67092a &= -65;
        }
        if (O(baseRequestOptions.f67092a, Function.MAX_NARGS)) {
            this.f67100j = baseRequestOptions.f67100j;
        }
        if (O(baseRequestOptions.f67092a, 512)) {
            this.f67102l = baseRequestOptions.f67102l;
            this.f67101k = baseRequestOptions.f67101k;
        }
        if (O(baseRequestOptions.f67092a, 1024)) {
            this.f67103m = baseRequestOptions.f67103m;
        }
        if (O(baseRequestOptions.f67092a, 4096)) {
            this.f67110t = baseRequestOptions.f67110t;
        }
        if (O(baseRequestOptions.f67092a, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
            this.f67106p = baseRequestOptions.f67106p;
            this.f67107q = 0;
            this.f67092a &= -16385;
        }
        if (O(baseRequestOptions.f67092a, 16384)) {
            this.f67107q = baseRequestOptions.f67107q;
            this.f67106p = null;
            this.f67092a &= -8193;
        }
        if (O(baseRequestOptions.f67092a, 32768)) {
            this.f67112v = baseRequestOptions.f67112v;
        }
        if (O(baseRequestOptions.f67092a, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
            this.f67105o = baseRequestOptions.f67105o;
        }
        if (O(baseRequestOptions.f67092a, 131072)) {
            this.f67104n = baseRequestOptions.f67104n;
        }
        if (O(baseRequestOptions.f67092a, 2048)) {
            this.f67109s.putAll(baseRequestOptions.f67109s);
            this.f67116z = baseRequestOptions.f67116z;
        }
        if (O(baseRequestOptions.f67092a, 524288)) {
            this.f67115y = baseRequestOptions.f67115y;
        }
        if (!this.f67105o) {
            this.f67109s.clear();
            int i3 = this.f67092a;
            this.f67104n = false;
            this.f67092a = i3 & (-133121);
            this.f67116z = true;
        }
        this.f67092a |= baseRequestOptions.f67092a;
        this.f67108r.d(baseRequestOptions.f67108r);
        return h0();
    }

    public BaseRequestOptions a0(int i3, int i4) {
        if (this.f67113w) {
            return clone().a0(i3, i4);
        }
        this.f67102l = i3;
        this.f67101k = i4;
        this.f67092a |= 512;
        return h0();
    }

    public BaseRequestOptions b() {
        if (this.f67111u && !this.f67113w) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f67113w = true;
        return U();
    }

    public BaseRequestOptions b0(int i3) {
        if (this.f67113w) {
            return clone().b0(i3);
        }
        this.f67099i = i3;
        int i4 = this.f67092a | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.f67098h = null;
        this.f67092a = i4 & (-65);
        return h0();
    }

    public BaseRequestOptions c() {
        return p0(DownsampleStrategy.f66842d, new CircleCrop());
    }

    public BaseRequestOptions c0(Drawable drawable) {
        if (this.f67113w) {
            return clone().c0(drawable);
        }
        this.f67098h = drawable;
        int i3 = this.f67092a | 64;
        this.f67099i = 0;
        this.f67092a = i3 & (-129);
        return h0();
    }

    public BaseRequestOptions d0(Priority priority) {
        if (this.f67113w) {
            return clone().d0(priority);
        }
        this.f67095d = (Priority) Preconditions.e(priority);
        this.f67092a |= 8;
        return h0();
    }

    @Override // 
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BaseRequestOptions clone() {
        try {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) super.clone();
            Options options = new Options();
            baseRequestOptions.f67108r = options;
            options.d(this.f67108r);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            baseRequestOptions.f67109s = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f67109s);
            baseRequestOptions.f67111u = false;
            baseRequestOptions.f67113w = false;
            return baseRequestOptions;
        } catch (CloneNotSupportedException e3) {
            throw new RuntimeException(e3);
        }
    }

    BaseRequestOptions e0(Option option) {
        if (this.f67113w) {
            return clone().e0(option);
        }
        this.f67108r.e(option);
        return h0();
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseRequestOptions) {
            return J((BaseRequestOptions) obj);
        }
        return false;
    }

    public BaseRequestOptions g(Class cls) {
        if (this.f67113w) {
            return clone().g(cls);
        }
        this.f67110t = (Class) Preconditions.e(cls);
        this.f67092a |= 4096;
        return h0();
    }

    public BaseRequestOptions h(DiskCacheStrategy diskCacheStrategy) {
        if (this.f67113w) {
            return clone().h(diskCacheStrategy);
        }
        this.f67094c = (DiskCacheStrategy) Preconditions.e(diskCacheStrategy);
        this.f67092a |= 4;
        return h0();
    }

    protected final BaseRequestOptions h0() {
        if (this.f67111u) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return g0();
    }

    public int hashCode() {
        return Util.q(this.f67112v, Util.q(this.f67103m, Util.q(this.f67110t, Util.q(this.f67109s, Util.q(this.f67108r, Util.q(this.f67095d, Util.q(this.f67094c, Util.r(this.f67115y, Util.r(this.f67114x, Util.r(this.f67105o, Util.r(this.f67104n, Util.p(this.f67102l, Util.p(this.f67101k, Util.r(this.f67100j, Util.q(this.f67106p, Util.p(this.f67107q, Util.q(this.f67098h, Util.p(this.f67099i, Util.q(this.f67096f, Util.p(this.f67097g, Util.m(this.f67093b)))))))))))))))))))));
    }

    public BaseRequestOptions i() {
        return i0(GifOptions.f67006b, Boolean.TRUE);
    }

    public BaseRequestOptions i0(Option option, Object obj) {
        if (this.f67113w) {
            return clone().i0(option, obj);
        }
        Preconditions.e(option);
        Preconditions.e(obj);
        this.f67108r.f(option, obj);
        return h0();
    }

    public BaseRequestOptions j(DownsampleStrategy downsampleStrategy) {
        return i0(DownsampleStrategy.f66846h, (DownsampleStrategy) Preconditions.e(downsampleStrategy));
    }

    public BaseRequestOptions j0(Key key) {
        if (this.f67113w) {
            return clone().j0(key);
        }
        this.f67103m = (Key) Preconditions.e(key);
        this.f67092a |= 1024;
        return h0();
    }

    public BaseRequestOptions k(int i3) {
        if (this.f67113w) {
            return clone().k(i3);
        }
        this.f67097g = i3;
        int i4 = this.f67092a | 32;
        this.f67096f = null;
        this.f67092a = i4 & (-17);
        return h0();
    }

    public BaseRequestOptions k0(float f3) {
        if (this.f67113w) {
            return clone().k0(f3);
        }
        if (f3 < 0.0f || f3 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f67093b = f3;
        this.f67092a |= 2;
        return h0();
    }

    public BaseRequestOptions l0(boolean z2) {
        if (this.f67113w) {
            return clone().l0(true);
        }
        this.f67100j = !z2;
        this.f67092a |= Function.MAX_NARGS;
        return h0();
    }

    public BaseRequestOptions m(Drawable drawable) {
        if (this.f67113w) {
            return clone().m(drawable);
        }
        this.f67096f = drawable;
        int i3 = this.f67092a | 16;
        this.f67097g = 0;
        this.f67092a = i3 & (-33);
        return h0();
    }

    public BaseRequestOptions m0(Resources.Theme theme) {
        if (this.f67113w) {
            return clone().m0(theme);
        }
        this.f67112v = theme;
        if (theme != null) {
            this.f67092a |= 32768;
            return i0(ResourceDrawableDecoder.f66955b, theme);
        }
        this.f67092a &= -32769;
        return e0(ResourceDrawableDecoder.f66955b);
    }

    public BaseRequestOptions n0(Transformation transformation) {
        return o0(transformation, true);
    }

    public final DiskCacheStrategy o() {
        return this.f67094c;
    }

    BaseRequestOptions o0(Transformation transformation, boolean z2) {
        if (this.f67113w) {
            return clone().o0(transformation, z2);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z2);
        q0(Bitmap.class, transformation, z2);
        q0(Drawable.class, drawableTransformation, z2);
        q0(BitmapDrawable.class, drawableTransformation.c(), z2);
        q0(GifDrawable.class, new GifDrawableTransformation(transformation), z2);
        return h0();
    }

    public final int p() {
        return this.f67097g;
    }

    final BaseRequestOptions p0(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        if (this.f67113w) {
            return clone().p0(downsampleStrategy, transformation);
        }
        j(downsampleStrategy);
        return n0(transformation);
    }

    public final Drawable q() {
        return this.f67096f;
    }

    BaseRequestOptions q0(Class cls, Transformation transformation, boolean z2) {
        if (this.f67113w) {
            return clone().q0(cls, transformation, z2);
        }
        Preconditions.e(cls);
        Preconditions.e(transformation);
        this.f67109s.put(cls, transformation);
        int i3 = this.f67092a;
        this.f67105o = true;
        this.f67092a = 67584 | i3;
        this.f67116z = false;
        if (z2) {
            this.f67092a = i3 | 198656;
            this.f67104n = true;
        }
        return h0();
    }

    public final Drawable r() {
        return this.f67106p;
    }

    public BaseRequestOptions r0(boolean z2) {
        if (this.f67113w) {
            return clone().r0(z2);
        }
        this.A = z2;
        this.f67092a |= 1048576;
        return h0();
    }

    public final int s() {
        return this.f67107q;
    }

    public final boolean t() {
        return this.f67115y;
    }

    public final Options u() {
        return this.f67108r;
    }

    public final int v() {
        return this.f67101k;
    }

    public final int w() {
        return this.f67102l;
    }

    public final Drawable x() {
        return this.f67098h;
    }

    public final int y() {
        return this.f67099i;
    }

    public final Priority z() {
        return this.f67095d;
    }

    private BaseRequestOptions g0() {
        return this;
    }
}
