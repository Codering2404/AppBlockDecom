package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class AttributeStrategy implements LruPoolStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyPool f66534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GroupedLinkedMap f66535b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Key implements Poolable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KeyPool f66536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f66537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f66538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f66539d;

        public Key(KeyPool keyPool) {
            this.f66536a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f66536a.c(this);
        }

        public void b(int i3, int i4, Bitmap.Config config) {
            this.f66537b = i3;
            this.f66538c = i4;
            this.f66539d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.f66537b == key.f66537b && this.f66538c == key.f66538c && this.f66539d == key.f66539d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i3 = ((this.f66537b * 31) + this.f66538c) * 31;
            Bitmap.Config config = this.f66539d;
            return i3 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.f(this.f66537b, this.f66538c, this.f66539d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class KeyPool extends BaseKeyPool<Key> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Key a() {
            return new Key(this);
        }

        Key e(int i3, int i4, Bitmap.Config config) {
            Key key = (Key) b();
            key.b(i3, i4, config);
            return key;
        }
    }

    static String f(int i3, int i4, Bitmap.Config config) {
        return "[" + i3 + "x" + i4 + "], " + config;
    }

    private static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String a(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i3, int i4, Bitmap.Config config) {
        return f(i3, i4, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void c(Bitmap bitmap) {
        this.f66535b.d(this.f66534a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap d(int i3, int i4, Bitmap.Config config) {
        return (Bitmap) this.f66535b.a(this.f66534a.e(i3, i4, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int e(Bitmap bitmap) {
        return Util.i(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return (Bitmap) this.f66535b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f66535b;
    }
}
