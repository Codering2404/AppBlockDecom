package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionKeyPosition extends MotionKey {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f31669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f31670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f31671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f31672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f31673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f31674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f31675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f31676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f31677o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f31678p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f31679q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31680r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31681s;

    public MotionKeyPosition() {
        int i3 = MotionKey.f31627f;
        this.f31669g = i3;
        this.f31670h = null;
        this.f31671i = i3;
        this.f31672j = 0;
        this.f31673k = Float.NaN;
        this.f31674l = Float.NaN;
        this.f31675m = Float.NaN;
        this.f31676n = Float.NaN;
        this.f31677o = Float.NaN;
        this.f31678p = Float.NaN;
        this.f31679q = 0;
        this.f31680r = Float.NaN;
        this.f31681s = Float.NaN;
        this.f31631d = 2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        return TypedValues.PositionType.a(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 == 100) {
            this.f31628a = i4;
            return true;
        }
        if (i3 == 508) {
            this.f31669g = i4;
            return true;
        }
        if (i3 != 510) {
            return super.b(i3, i4);
        }
        this.f31679q = i4;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        switch (i3) {
            case 503:
                this.f31673k = f3;
                return true;
            case 504:
                this.f31674l = f3;
                return true;
            case 505:
                this.f31673k = f3;
                this.f31674l = f3;
                return true;
            case 506:
                this.f31675m = f3;
                return true;
            case 507:
                this.f31676n = f3;
                return true;
            default:
                return super.c(i3, f3);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 != 501) {
            return super.e(i3, str);
        }
        this.f31670h = str.toString();
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: g */
    public MotionKey clone() {
        return new MotionKeyPosition().h(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey h(MotionKey motionKey) {
        super.h(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.f31670h = motionKeyPosition.f31670h;
        this.f31671i = motionKeyPosition.f31671i;
        this.f31672j = motionKeyPosition.f31672j;
        this.f31673k = motionKeyPosition.f31673k;
        this.f31674l = Float.NaN;
        this.f31675m = motionKeyPosition.f31675m;
        this.f31676n = motionKeyPosition.f31676n;
        this.f31677o = motionKeyPosition.f31677o;
        this.f31678p = motionKeyPosition.f31678p;
        this.f31680r = motionKeyPosition.f31680r;
        this.f31681s = motionKeyPosition.f31681s;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void f(HashMap map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void i(HashSet hashSet) {
    }
}
