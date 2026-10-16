package androidx.media3.exoplayer.video.spherical;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.media3.exoplayer.video.spherical.OrientationListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f45989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f45990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Listener f45991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f45992d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GestureDetector f45993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile float f45994g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void b(PointF pointF);

        default boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    @Override // androidx.media3.exoplayer.video.spherical.OrientationListener.Listener
    public void a(float[] fArr, float f3) {
        this.f45994g = -f3;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f45989a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        float x2 = (motionEvent2.getX() - this.f45989a.x) / this.f45992d;
        float y2 = motionEvent2.getY();
        PointF pointF = this.f45989a;
        float f5 = (y2 - pointF.y) / this.f45992d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d3 = this.f45994g;
        float fCos = (float) Math.cos(d3);
        float fSin = (float) Math.sin(d3);
        PointF pointF2 = this.f45990b;
        pointF2.x -= (fCos * x2) - (fSin * f5);
        float f6 = pointF2.y + (fSin * x2) + (fCos * f5);
        pointF2.y = f6;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f6));
        this.f45991c.b(this.f45990b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f45991c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f45993f.onTouchEvent(motionEvent);
    }
}
