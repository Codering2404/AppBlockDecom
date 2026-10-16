package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class InsetDialogOnTouchListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dialog f80928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f80929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f80930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f80931d;

    public InsetDialogOnTouchListener(Dialog dialog, Rect rect) {
        this.f80928a = dialog;
        this.f80929b = rect.left;
        this.f80930c = rect.top;
        this.f80931d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f80929b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f80930c + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f80928a.onTouchEvent(motionEventObtain);
    }
}
