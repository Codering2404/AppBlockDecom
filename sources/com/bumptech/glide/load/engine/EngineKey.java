package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class EngineKey implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f66468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f66469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f66470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class f66471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class f66472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Key f66473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f66474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Options f66475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f66476j;

    EngineKey(Object obj, Key key, int i3, int i4, Map map, Class cls, Class cls2, Options options) {
        this.f66468b = Preconditions.e(obj);
        this.f66473g = (Key) Preconditions.f(key, "Signature must not be null");
        this.f66469c = i3;
        this.f66470d = i4;
        this.f66474h = (Map) Preconditions.e(map);
        this.f66471e = (Class) Preconditions.f(cls, "Resource class must not be null");
        this.f66472f = (Class) Preconditions.f(cls2, "Transcode class must not be null");
        this.f66475i = (Options) Preconditions.e(options);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof EngineKey) {
            EngineKey engineKey = (EngineKey) obj;
            if (this.f66468b.equals(engineKey.f66468b) && this.f66473g.equals(engineKey.f66473g) && this.f66470d == engineKey.f66470d && this.f66469c == engineKey.f66469c && this.f66474h.equals(engineKey.f66474h) && this.f66471e.equals(engineKey.f66471e) && this.f66472f.equals(engineKey.f66472f) && this.f66475i.equals(engineKey.f66475i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f66476j == 0) {
            int iHashCode = this.f66468b.hashCode();
            this.f66476j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f66473g.hashCode()) * 31) + this.f66469c) * 31) + this.f66470d;
            this.f66476j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f66474h.hashCode();
            this.f66476j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f66471e.hashCode();
            this.f66476j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f66472f.hashCode();
            this.f66476j = iHashCode5;
            this.f66476j = (iHashCode5 * 31) + this.f66475i.hashCode();
        }
        return this.f66476j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f66468b + ", width=" + this.f66469c + ", height=" + this.f66470d + ", resourceClass=" + this.f66471e + ", transcodeClass=" + this.f66472f + ", signature=" + this.f66473g + ", hashCode=" + this.f66476j + ", transformations=" + this.f66474h + ", options=" + this.f66475i + '}';
    }
}
