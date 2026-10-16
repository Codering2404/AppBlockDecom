package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionKeyTrigger extends MotionKey {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31700g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f31701h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f31703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f31704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f31705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f31706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f31707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f31708o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31709p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f31710q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31711r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31712s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f31713t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f31714u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f31715v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f31716w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    FloatRect f31717x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    FloatRect f31718y;

    public MotionKeyTrigger() {
        int i3 = MotionKey.f31627f;
        this.f31702i = i3;
        this.f31703j = null;
        this.f31704k = null;
        this.f31705l = i3;
        this.f31706m = i3;
        this.f31707n = 0.1f;
        this.f31708o = true;
        this.f31709p = true;
        this.f31710q = true;
        this.f31711r = Float.NaN;
        this.f31713t = false;
        this.f31714u = i3;
        this.f31715v = i3;
        this.f31716w = i3;
        this.f31717x = new FloatRect();
        this.f31718y = new FloatRect();
        this.f31631d = 5;
        this.f31632e = new HashMap();
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        str.getClass();
        switch (str) {
            case "positiveCross":
                return 309;
            case "viewTransitionOnPositiveCross":
                return 302;
            case "triggerCollisionId":
                return 307;
            case "triggerID":
                return 308;
            case "negativeCross":
                return 310;
            case "triggerCollisionView":
                return 306;
            case "viewTransitionOnNegativeCross":
                return 303;
            case "triggerSlack":
                return 305;
            case "viewTransitionOnCross":
                return 301;
            case "postLayout":
                return RCHTTPStatusCodes.NOT_MODIFIED;
            case "triggerReceiver":
                return 311;
            default:
                return -1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 == 307) {
            this.f31706m = i4;
            return true;
        }
        if (i3 == 308) {
            this.f31705l = l(Integer.valueOf(i4));
            return true;
        }
        if (i3 == 311) {
            this.f31702i = i4;
            return true;
        }
        switch (i3) {
            case 301:
                this.f31716w = i4;
                return true;
            case 302:
                this.f31715v = i4;
                return true;
            case 303:
                this.f31714u = i4;
                return true;
            default:
                return super.b(i3, i4);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (i3 != 305) {
            return super.c(i3, f3);
        }
        this.f31707n = f3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean d(int i3, boolean z2) {
        if (i3 != 304) {
            return super.d(i3, z2);
        }
        this.f31713t = z2;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 == 309) {
            this.f31704k = str;
            return true;
        }
        if (i3 == 310) {
            this.f31703j = str;
            return true;
        }
        if (i3 != 312) {
            return super.e(i3, str);
        }
        this.f31701h = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: g */
    public MotionKey clone() {
        return new MotionKeyTrigger().n(this);
    }

    public MotionKeyTrigger n(MotionKey motionKey) {
        super.h(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.f31700g = motionKeyTrigger.f31700g;
        this.f31701h = motionKeyTrigger.f31701h;
        this.f31702i = motionKeyTrigger.f31702i;
        this.f31703j = motionKeyTrigger.f31703j;
        this.f31704k = motionKeyTrigger.f31704k;
        this.f31705l = motionKeyTrigger.f31705l;
        this.f31706m = motionKeyTrigger.f31706m;
        this.f31707n = motionKeyTrigger.f31707n;
        this.f31708o = motionKeyTrigger.f31708o;
        this.f31709p = motionKeyTrigger.f31709p;
        this.f31710q = motionKeyTrigger.f31710q;
        this.f31711r = motionKeyTrigger.f31711r;
        this.f31712s = motionKeyTrigger.f31712s;
        this.f31713t = motionKeyTrigger.f31713t;
        this.f31717x = motionKeyTrigger.f31717x;
        this.f31718y = motionKeyTrigger.f31718y;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void f(HashMap map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void i(HashSet hashSet) {
    }

    public void m(float f3, MotionWidget motionWidget) {
    }
}
