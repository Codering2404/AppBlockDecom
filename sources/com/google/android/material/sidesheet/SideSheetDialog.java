package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SideSheetDialog extends SheetDialog<SideSheetCallback> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f81962q = R.attr.f79501m0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f81963r = R.style.f79740m;

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog, android.content.DialogInterface
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    void k(Sheet sheet) {
        sheet.b(new SideSheetCallback() { // from class: com.google.android.material.sidesheet.SideSheetDialog.1
            @Override // com.google.android.material.sidesheet.SheetCallback
            public void a(View view, int i3) {
                if (i3 == 5) {
                    SideSheetDialog.this.cancel();
                }
            }

            @Override // com.google.android.material.sidesheet.SheetCallback
            public void b(View view, float f3) {
            }
        });
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    Sheet n(FrameLayout frameLayout) {
        return SideSheetBehavior.f0(frameLayout);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog, android.view.Window.Callback
    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog, android.view.Window.Callback
    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    int p() {
        return R.id.f79644m;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    int q() {
        return R.layout.f79682m;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    int s() {
        return 3;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setCancelable(boolean z2) {
        super.setCancelable(z2);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(int i3) {
        super.setContentView(i3);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public SideSheetBehavior m() {
        Sheet sheetM = super.m();
        if (sheetM instanceof SideSheetBehavior) {
            return (SideSheetBehavior) sheetM;
        }
        throw new IllegalStateException("The view is not associated with SideSheetBehavior");
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(View view) {
        super.setContentView(view);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }
}
