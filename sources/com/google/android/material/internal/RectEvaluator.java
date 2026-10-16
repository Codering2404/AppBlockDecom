package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f81253a;

    public RectEvaluator(Rect rect) {
        this.f81253a = rect;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f3, Rect rect, Rect rect2) {
        this.f81253a.set(rect.left + ((int) ((rect2.left - r0) * f3)), rect.top + ((int) ((rect2.top - r1) * f3)), rect.right + ((int) ((rect2.right - r2) * f3)), rect.bottom + ((int) ((rect2.bottom - r6) * f3)));
        return this.f81253a;
    }
}
