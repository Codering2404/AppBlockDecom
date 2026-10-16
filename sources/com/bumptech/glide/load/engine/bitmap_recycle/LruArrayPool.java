package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LruArrayPool implements ArrayPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GroupedLinkedMap f66547a = new GroupedLinkedMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KeyPool f66548b = new KeyPool();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f66549c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f66550d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f66551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f66552f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Key implements Poolable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KeyPool f66553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f66554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class f66555c;

        Key(KeyPool keyPool) {
            this.f66553a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void a() {
            this.f66553a.c(this);
        }

        void b(int i3, Class cls) {
            this.f66554b = i3;
            this.f66555c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (this.f66554b == key.f66554b && this.f66555c == key.f66555c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i3 = this.f66554b * 31;
            Class cls = this.f66555c;
            return i3 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f66554b + "array=" + this.f66555c + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Key a() {
            return new Key(this);
        }

        Key e(int i3, Class cls) {
            Key key = (Key) b();
            key.b(i3, cls);
            return key;
        }
    }

    public LruArrayPool(int i3) {
        this.f66551e = i3;
    }

    private void e(int i3, Class cls) {
        NavigableMap navigableMapL = l(cls);
        Integer num = (Integer) navigableMapL.get(Integer.valueOf(i3));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i3));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i3), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i3 + ", this: " + this);
    }

    private void f() {
        g(this.f66551e);
    }

    private void g(int i3) {
        while (this.f66552f > i3) {
            Object objF = this.f66547a.f();
            Preconditions.e(objF);
            ArrayAdapterInterface arrayAdapterInterfaceH = h(objF);
            this.f66552f -= arrayAdapterInterfaceH.b(objF) * arrayAdapterInterfaceH.a();
            e(arrayAdapterInterfaceH.b(objF), objF.getClass());
            if (Log.isLoggable(arrayAdapterInterfaceH.c(), 2)) {
                Log.v(arrayAdapterInterfaceH.c(), "evicted: " + arrayAdapterInterfaceH.b(objF));
            }
        }
    }

    private ArrayAdapterInterface h(Object obj) {
        return i(obj.getClass());
    }

    private ArrayAdapterInterface i(Class cls) {
        ArrayAdapterInterface byteArrayAdapter;
        ArrayAdapterInterface arrayAdapterInterface = (ArrayAdapterInterface) this.f66550d.get(cls);
        if (arrayAdapterInterface != null) {
            return arrayAdapterInterface;
        }
        if (cls.equals(int[].class)) {
            byteArrayAdapter = new IntegerArrayAdapter();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            byteArrayAdapter = new ByteArrayAdapter();
        }
        this.f66550d.put(cls, byteArrayAdapter);
        return byteArrayAdapter;
    }

    private Object j(Key key) {
        return this.f66547a.a(key);
    }

    private NavigableMap l(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.f66549c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f66549c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i3 = this.f66552f;
        return i3 == 0 || this.f66551e / i3 >= 2;
    }

    private boolean n(int i3) {
        return i3 <= this.f66551e / 2;
    }

    private boolean o(int i3, Integer num) {
        if (num != null) {
            return m() || num.intValue() <= i3 * 8;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void a(int i3) {
        try {
            if (i3 >= 40) {
                b();
            } else if (i3 >= 20 || i3 == 15) {
                g(this.f66551e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void b() {
        g(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized Object c(int i3, Class cls) {
        Integer num;
        try {
            num = (Integer) l(cls).ceilingKey(Integer.valueOf(i3));
        } catch (Throwable th) {
            throw th;
        }
        return k(o(i3, num) ? this.f66548b.e(num.intValue(), cls) : this.f66548b.e(i3, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized Object d(int i3, Class cls) {
        return k(this.f66548b.e(i3, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void put(Object obj) {
        Class<?> cls = obj.getClass();
        ArrayAdapterInterface arrayAdapterInterfaceI = i(cls);
        int iB = arrayAdapterInterfaceI.b(obj);
        int iA = arrayAdapterInterfaceI.a() * iB;
        if (n(iA)) {
            Key keyE = this.f66548b.e(iB, cls);
            this.f66547a.d(keyE, obj);
            NavigableMap navigableMapL = l(cls);
            Integer num = (Integer) navigableMapL.get(Integer.valueOf(keyE.f66554b));
            Integer numValueOf = Integer.valueOf(keyE.f66554b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f66552f += iA;
            f();
        }
    }

    private Object k(Key key, Class cls) {
        ArrayAdapterInterface arrayAdapterInterfaceI = i(cls);
        Object objJ = j(key);
        if (objJ != null) {
            this.f66552f -= arrayAdapterInterfaceI.b(objJ) * arrayAdapterInterfaceI.a();
            e(arrayAdapterInterfaceI.b(objJ), cls);
        }
        if (objJ == null) {
            if (Log.isLoggable(arrayAdapterInterfaceI.c(), 2)) {
                Log.v(arrayAdapterInterfaceI.c(), YgVrd.gHCBdZYSXW + key.f66554b + " bytes");
            }
            return arrayAdapterInterfaceI.newArray(key.f66554b);
        }
        return objJ;
    }
}
