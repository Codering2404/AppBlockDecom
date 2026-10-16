package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class SizeStrategy implements LruPoolStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyPool f66580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GroupedLinkedMap f66581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NavigableMap f66582c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Key implements Poolable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KeyPool f66583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f66584b;

        Key(KeyPool keyPool) {
            this.f66583a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f66583a.c(this);
        }

        public void b(int i3) {
            this.f66584b = i3;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Key) && this.f66584b == ((Key) obj).f66584b;
        }

        public int hashCode() {
            return this.f66584b;
        }

        public String toString() {
            return SizeStrategy.g(this.f66584b);
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

        public Key e(int i3) {
            Key key = (Key) super.b();
            key.b(i3);
            return key;
        }
    }

    private void f(Integer num) {
        Integer num2 = (Integer) this.f66582c.get(num);
        if (num2.intValue() == 1) {
            this.f66582c.remove(num);
        } else {
            this.f66582c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String g(int i3) {
        return "[" + i3 + "]";
    }

    private static String h(Bitmap bitmap) {
        return g(Util.i(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String a(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i3, int i4, Bitmap.Config config) {
        return g(Util.h(i3, i4, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void c(Bitmap bitmap) {
        Key keyE = this.f66580a.e(Util.i(bitmap));
        this.f66581b.d(keyE, bitmap);
        Integer num = (Integer) this.f66582c.get(Integer.valueOf(keyE.f66584b));
        this.f66582c.put(Integer.valueOf(keyE.f66584b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap d(int i3, int i4, Bitmap.Config config) {
        int iH = Util.h(i3, i4, config);
        Key keyE = this.f66580a.e(iH);
        Integer num = (Integer) this.f66582c.ceilingKey(Integer.valueOf(iH));
        if (num != null && num.intValue() != iH && num.intValue() <= iH * 8) {
            this.f66580a.c(keyE);
            keyE = this.f66580a.e(num.intValue());
        }
        Bitmap bitmap = (Bitmap) this.f66581b.a(keyE);
        if (bitmap != null) {
            bitmap.reconfigure(i3, i4, config);
            f(num);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int e(Bitmap bitmap) {
        return Util.i(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f66581b.f();
        if (bitmap != null) {
            f(Integer.valueOf(Util.i(bitmap)));
        }
        return bitmap;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f66581b + "\n  SortedSizes" + this.f66582c;
    }
}
