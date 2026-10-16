package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class StopLogic extends MotionInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StopLogicEngine f32554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SpringStopEngine f32555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StopEngine f32556c;

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float a() {
        return this.f32556c.a();
    }

    public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
        StopLogicEngine stopLogicEngine = this.f32554a;
        this.f32556c = stopLogicEngine;
        stopLogicEngine.d(f3, f4, f5, f6, f7, f8);
    }

    public boolean c() {
        return this.f32556c.b();
    }

    public void d(float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i3) {
        if (this.f32555b == null) {
            this.f32555b = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.f32555b;
        this.f32556c = springStopEngine;
        springStopEngine.d(f3, f4, f5, f6, f7, f8, f9, i3);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        return this.f32556c.getInterpolation(f3);
    }
}
