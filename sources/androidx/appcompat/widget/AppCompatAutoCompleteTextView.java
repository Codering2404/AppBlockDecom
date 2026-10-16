package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f1714d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatBackgroundHelper f1715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatTextHelper f1716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppCompatEmojiEditTextHelper f1717c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1722e;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(AppCompatAutoCompleteTextView appCompatAutoCompleteTextView, PropertyReader propertyReader) {
            if (!this.f1718a) {
                throw c.a();
            }
            propertyReader.readObject(this.f1719b, appCompatAutoCompleteTextView.getBackgroundTintList());
            propertyReader.readObject(this.f1720c, appCompatAutoCompleteTextView.getBackgroundTintMode());
            propertyReader.readObject(this.f1721d, appCompatAutoCompleteTextView.getCompoundDrawableTintList());
            propertyReader.readObject(this.f1722e, appCompatAutoCompleteTextView.getCompoundDrawableTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f1719b = propertyMapper.mapObject("backgroundTint", androidx.appcompat.R.attr.f673v);
            this.f1720c = propertyMapper.mapObject("backgroundTintMode", androidx.appcompat.R.attr.f675w);
            this.f1721d = propertyMapper.mapObject("drawableTint", androidx.appcompat.R.attr.V);
            this.f1722e = propertyMapper.mapObject("drawableTintMode", androidx.appcompat.R.attr.W);
            this.f1718a = true;
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.f663q);
    }

    void a(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
        KeyListener keyListener = getKeyListener();
        if (appCompatEmojiEditTextHelper.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = appCompatEmojiEditTextHelper.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1716b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1716b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1716b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f1717c.d(AppCompatHintHelper.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1716b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1716b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i3) {
        setDropDownBackgroundDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f1717c.e(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1717c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1715a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1716b.w(colorStateList);
        this.f1716b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1716b.x(mode);
        this.f1716b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        AppCompatTextHelper appCompatTextHelper = this.f1716b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i3);
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i3) {
        super(TintContextWrapper.b(context), attributeSet, i3);
        ThemeUtils.a(this, getContext());
        TintTypedArray tintTypedArrayV = TintTypedArray.v(getContext(), attributeSet, f1714d, i3, 0);
        if (tintTypedArrayV.s(0)) {
            setDropDownBackgroundDrawable(tintTypedArrayV.g(0));
        }
        tintTypedArrayV.x();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1715a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i3);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1716b = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i3);
        appCompatTextHelper.b();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.f1717c = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.c(attributeSet, i3);
        a(appCompatEmojiEditTextHelper);
    }
}
