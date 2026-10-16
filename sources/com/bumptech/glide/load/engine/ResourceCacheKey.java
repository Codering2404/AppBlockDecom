package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ResourceCacheKey implements Key {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final LruCache f66514j = new LruCache(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayPool f66515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Key f66516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Key f66517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f66518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f66519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class f66520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Options f66521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Transformation f66522i;

    ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i3, int i4, Transformation transformation, Class cls, Options options) {
        this.f66515b = arrayPool;
        this.f66516c = key;
        this.f66517d = key2;
        this.f66518e = i3;
        this.f66519f = i4;
        this.f66522i = transformation;
        this.f66520g = cls;
        this.f66521h = options;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private byte[] c() {
        LruCache lruCache = f66514j;
        byte[] bArr = (byte[]) lruCache.i(this.f66520g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f66520g.getName().getBytes(Key.f66253a);
        lruCache.l(this.f66520g, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f66515b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f66518e).putInt(this.f66519f).array();
        this.f66517d.b(messageDigest);
        this.f66516c.b(messageDigest);
        messageDigest.update(bArr);
        Transformation transformation = this.f66522i;
        if (transformation != null) {
            transformation.b(messageDigest);
        }
        this.f66521h.b(messageDigest);
        messageDigest.update(c());
        this.f66515b.put(bArr);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ResourceCacheKey) {
            ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
            if (this.f66519f == resourceCacheKey.f66519f && this.f66518e == resourceCacheKey.f66518e && Util.e(this.f66522i, resourceCacheKey.f66522i) && this.f66520g.equals(resourceCacheKey.f66520g) && this.f66516c.equals(resourceCacheKey.f66516c) && this.f66517d.equals(resourceCacheKey.f66517d) && this.f66521h.equals(resourceCacheKey.f66521h)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int iHashCode = (((((this.f66516c.hashCode() * 31) + this.f66517d.hashCode()) * 31) + this.f66518e) * 31) + this.f66519f;
        Transformation transformation = this.f66522i;
        if (transformation != null) {
            iHashCode = (iHashCode * 31) + transformation.hashCode();
        }
        return (((iHashCode * 31) + this.f66520g.hashCode()) * 31) + this.f66521h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f66516c + ", signature=" + this.f66517d + ", width=" + this.f66518e + ", height=" + this.f66519f + ", decodedResourceClass=" + this.f66520g + ", transformation='" + this.f66522i + "', options=" + this.f66521h + '}';
    }
}
