package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DifferentialMotionFlingController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f34397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DifferentialMotionFlingTarget f34398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FlingVelocityThresholdCalculator f34399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DifferentialVelocityProvider f34400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private VelocityTracker f34401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f34402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f34404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f34405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f34406j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface DifferentialVelocityProvider {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface FlingVelocityThresholdCalculator {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i3);
    }

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new FlingVelocityThresholdCalculator() { // from class: androidx.core.view.j
            @Override // androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i3) {
                DifferentialMotionFlingController.c(context2, iArr, motionEvent, i3);
            }
        }, new DifferentialVelocityProvider() { // from class: androidx.core.view.k
            @Override // androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i3) {
                return DifferentialMotionFlingController.f(velocityTracker, motionEvent, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = ViewConfigurationCompat.g(context, viewConfiguration, motionEvent.getDeviceId(), i3, motionEvent.getSource());
        iArr[1] = ViewConfigurationCompat.f(context, viewConfiguration, motionEvent.getDeviceId(), i3, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i3) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f34404h == source && this.f34405i == deviceId && this.f34403g == i3) {
            return false;
        }
        this.f34399c.a(this.f34397a, this.f34406j, motionEvent, i3);
        this.f34404h = source;
        this.f34405i = deviceId;
        this.f34403g = i3;
        return true;
    }

    private float e(MotionEvent motionEvent, int i3) {
        if (this.f34401e == null) {
            this.f34401e = VelocityTracker.obtain();
        }
        return this.f34400d.a(this.f34401e, motionEvent, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i3) {
        VelocityTrackerCompat.a(velocityTracker, motionEvent);
        VelocityTrackerCompat.b(velocityTracker, 1000);
        return VelocityTrackerCompat.d(velocityTracker, i3);
    }

    public void g(MotionEvent motionEvent, int i3) {
        boolean zD = d(motionEvent, i3);
        if (this.f34406j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f34401e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f34401e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i3) * this.f34398b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f34402f) && fSignum != 0.0f)) {
            this.f34398b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f34406j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f34402f = this.f34398b.a(fMax) ? fMax : 0.0f;
    }

    DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, FlingVelocityThresholdCalculator flingVelocityThresholdCalculator, DifferentialVelocityProvider differentialVelocityProvider) {
        this.f34403g = -1;
        this.f34404h = -1;
        this.f34405i = -1;
        this.f34406j = new int[]{Api.BaseClientBuilder.API_PRIORITY_OTHER, 0};
        this.f34397a = context;
        this.f34398b = differentialMotionFlingTarget;
        this.f34399c = flingVelocityThresholdCalculator;
        this.f34400d = differentialVelocityProvider;
    }
}
