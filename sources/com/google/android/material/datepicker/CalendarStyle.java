package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class CalendarStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CalendarItemStyle f80760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CalendarItemStyle f80761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final CalendarItemStyle f80762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final CalendarItemStyle f80763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final CalendarItemStyle f80764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final CalendarItemStyle f80765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final CalendarItemStyle f80766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Paint f80767h;

    CalendarStyle(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.d(context, R.attr.N, MaterialCalendar.class.getCanonicalName()), R.styleable.x4);
        this.f80760a = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.B4, 0));
        this.f80766g = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.z4, 0));
        this.f80761b = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.A4, 0));
        this.f80762c = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.C4, 0));
        ColorStateList colorStateListA = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.D4);
        this.f80763d = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.F4, 0));
        this.f80764e = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.E4, 0));
        this.f80765f = CalendarItemStyle.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.G4, 0));
        Paint paint = new Paint();
        this.f80767h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
