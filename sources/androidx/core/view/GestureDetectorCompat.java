package androidx.core.view;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class GestureDetectorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GestureDetector f34409a;

    public boolean a(MotionEvent motionEvent) {
        return this.f34409a.onTouchEvent(motionEvent);
    }
}
