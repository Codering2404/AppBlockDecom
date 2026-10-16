package com.google.android.material.canvas;

import android.graphics.Canvas;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CanvasCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CanvasOperation {
        void a(Canvas canvas);
    }

    public static int a(Canvas canvas, float f3, float f4, float f5, float f6, int i3) {
        return canvas.saveLayerAlpha(f3, f4, f5, f6, i3);
    }
}
