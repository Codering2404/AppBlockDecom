package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FloatPropertyCompat<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f36828a;

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.FloatPropertyCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass1 extends FloatPropertyCompat<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatProperty f36829b;

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float a(Object obj) {
            return ((Float) this.f36829b.get(obj)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void b(Object obj, float f3) {
            this.f36829b.setValue(obj, f3);
        }
    }

    public FloatPropertyCompat(String str) {
        this.f36828a = str;
    }

    public abstract float a(Object obj);

    public abstract void b(Object obj, float f3);
}
