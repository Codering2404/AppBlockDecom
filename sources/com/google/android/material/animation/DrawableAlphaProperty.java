package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property f79856b = new DrawableAlphaProperty();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f79857a;

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.f79857a = new WeakHashMap();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
