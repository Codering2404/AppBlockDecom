package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f80858c = R.style.f79732e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f80859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f80860b;

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f80859a);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.f80860b));
    }
}
