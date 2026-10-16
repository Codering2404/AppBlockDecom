package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SizeConfigStrategy implements LruPoolStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f66568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f66569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f66570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f66571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f66572h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyPool f66573a = new KeyPool();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GroupedLinkedMap f66574b = new GroupedLinkedMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f66575c = new HashMap();

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66576a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f66576a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66576a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66576a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66576a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Key implements Poolable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KeyPool f66577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f66578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f66579c;

        public Key(KeyPool keyPool) {
            this.f66577a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f66577a.c(this);
        }

        public void b(int i3, Bitmap.Config config) {
            this.f66578b = i3;
            this.f66579c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.f66578b == key.f66578b && Util.e(this.f66579c, key.f66579c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i3 = this.f66578b * 31;
            Bitmap.Config config = this.f66579c;
            return i3 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.h(this.f66578b, this.f66579c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i3, Bitmap.Config config) {
            Key key = (Key) b();
            key.b(i3, config);
            return key;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        f66568d = configArr;
        f66569e = configArr;
        f66570f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f66571g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f66572h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key g(int r9, android.graphics.Bitmap.Config r10) {
        /*
            r8 = this;
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$KeyPool r0 = r8.f66573a
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$Key r0 = r0.e(r9, r10)
            android.graphics.Bitmap$Config[] r1 = i(r10)
            int r2 = r1.length
            r3 = 0
        Lc:
            if (r3 >= r2) goto L4c
            r4 = r1[r3]
            java.util.NavigableMap r5 = r8.j(r4)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            java.lang.Object r5 = r5.ceilingKey(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L49
            int r6 = r5.intValue()
            int r7 = r9 * 8
            if (r6 > r7) goto L49
            int r1 = r5.intValue()
            if (r1 != r9) goto L39
            if (r4 != 0) goto L33
            if (r10 == 0) goto L4c
            goto L39
        L33:
            boolean r9 = r4.equals(r10)
            if (r9 != 0) goto L4c
        L39:
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$KeyPool r9 = r8.f66573a
            r9.c(r0)
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$KeyPool r9 = r8.f66573a
            int r10 = r5.intValue()
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$Key r9 = r9.e(r10, r4)
            return r9
        L49:
            int r3 = r3 + 1
            goto Lc
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.g(int, android.graphics.Bitmap$Config):com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$Key");
    }

    static String h(int i3, Bitmap.Config config) {
        return "[" + i3 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return f66569e;
        }
        int i3 = AnonymousClass1.f66576a[config.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? new Bitmap.Config[]{config} : f66572h : f66571g : f66570f : f66568d;
    }

    private NavigableMap j(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap) this.f66575c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f66575c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String a(Bitmap bitmap) {
        return h(Util.i(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String b(int i3, int i4, Bitmap.Config config) {
        return h(Util.h(i3, i4, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void c(Bitmap bitmap) {
        Key keyE = this.f66573a.e(Util.i(bitmap), bitmap.getConfig());
        this.f66574b.d(keyE, bitmap);
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(keyE.f66578b));
        navigableMapJ.put(Integer.valueOf(keyE.f66578b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap d(int i3, int i4, Bitmap.Config config) {
        Key keyG = g(Util.h(i3, i4, config), config);
        Bitmap bitmap = (Bitmap) this.f66574b.a(keyG);
        if (bitmap != null) {
            f(Integer.valueOf(keyG.f66578b), bitmap);
            bitmap.reconfigure(i3, i4, config);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int e(Bitmap bitmap) {
        return Util.i(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f66574b.f();
        if (bitmap != null) {
            f(Integer.valueOf(Util.i(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f66574b);
        sb.append(", sortedSizes=(");
        for (Map.Entry entry : this.f66575c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f66575c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
