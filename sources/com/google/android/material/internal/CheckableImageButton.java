package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f81128h = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f81129d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f81130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f81131g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.internal.CheckableImageButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f81133c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void d(Parcel parcel) {
            this.f81133c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f81133c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            d(parcel);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.f634b0);
    }

    public boolean a() {
        return this.f81130f;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f81129d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i3) {
        if (!this.f81129d) {
            return super.onCreateDrawableState(i3);
        }
        int[] iArr = f81128h;
        return View.mergeDrawableStates(super.onCreateDrawableState(i3 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        setChecked(savedState.f81133c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f81133c = this.f81129d;
        return savedState;
    }

    public void setCheckable(boolean z2) {
        if (this.f81130f != z2) {
            this.f81130f = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (!this.f81130f || this.f81129d == z2) {
            return;
        }
        this.f81129d = z2;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z2) {
        this.f81131g = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.f81131g) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f81129d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f81130f = true;
        this.f81131g = true;
        ViewCompat.m0(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.CheckableImageButton.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void f(View view, AccessibilityEvent accessibilityEvent) {
                super.f(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.g0(CheckableImageButton.this.a());
                accessibilityNodeInfoCompat.h0(CheckableImageButton.this.isChecked());
            }
        });
    }
}
