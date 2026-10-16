package ru.noties.markwon.core.spans;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class ObjectsPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f147172a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RectF f147173b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f147174c = new Paint(1);

    static Paint a() {
        return f147174c;
    }

    static Rect b() {
        return f147172a;
    }

    static RectF c() {
        return f147173b;
    }
}
