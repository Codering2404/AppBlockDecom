package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Key {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f32582f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f32583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f32584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f32585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f32586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    HashMap f32587e;

    public Key() {
        int i3 = f32582f;
        this.f32583a = i3;
        this.f32584b = i3;
        this.f32585c = null;
    }

    public abstract void a(HashMap map);

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract Key clone();

    public Key c(Key key) {
        this.f32583a = key.f32583a;
        this.f32584b = key.f32584b;
        this.f32585c = key.f32585c;
        this.f32586d = key.f32586d;
        this.f32587e = key.f32587e;
        return this;
    }

    abstract void d(HashSet hashSet);

    abstract void e(Context context, AttributeSet attributeSet);

    boolean f(String str) {
        String str2 = this.f32585c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i3) {
        this.f32583a = i3;
    }

    public Key i(int i3) {
        this.f32584b = i3;
        return this;
    }

    boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public void h(HashMap map) {
    }
}
