package cz.mobilesoft.coreblock.view;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class CheckableConstraintLayout extends ConstraintLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f130028b = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f130029a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: cz.mobilesoft.coreblock.view.CheckableConstraintLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f130030a;

        public String toString() {
            return "CheckableConstraintLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.f130030a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f130030a));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f130030a = ((Boolean) parcel.readValue(getClass().getClassLoader())).booleanValue();
        }
    }

    public CheckableConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void h(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(z2);
            }
            if (childAt instanceof ViewGroup) {
                h((ViewGroup) childAt, z2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable background = getBackground();
        if (background != null) {
            background.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f130029a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f130028b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f130030a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f130030a = isChecked();
        return savedState;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f130029a != z2) {
            this.f130029a = z2;
            refreshDrawableState();
            h(this, z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f130029a);
    }
}
