package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MotionKey implements TypedValues {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f31627f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f31629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f31630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f31632e;

    public MotionKey() {
        int i3 = f31627f;
        this.f31628a = i3;
        this.f31629b = i3;
        this.f31630c = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 != 100) {
            return false;
        }
        this.f31628a = i4;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean d(int i3, boolean z2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 != 101) {
            return false;
        }
        this.f31630c = str;
        return true;
    }

    public abstract void f(HashMap map);

    @Override // 
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public abstract MotionKey clone();

    public MotionKey h(MotionKey motionKey) {
        this.f31628a = motionKey.f31628a;
        this.f31629b = motionKey.f31629b;
        this.f31630c = motionKey.f31630c;
        this.f31631d = motionKey.f31631d;
        return this;
    }

    public abstract void i(HashSet hashSet);

    float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public void j(HashMap map) {
    }
}
