package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatCheckedTextViewHelper f1753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatBackgroundHelper f1754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppCompatTextHelper f1755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppCompatEmojiTextHelper f1756d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1762f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1763g;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(AppCompatCheckedTextView appCompatCheckedTextView, PropertyReader propertyReader) {
            if (!this.f1757a) {
                throw c.a();
            }
            propertyReader.readObject(this.f1758b, appCompatCheckedTextView.getBackgroundTintList());
            propertyReader.readObject(this.f1759c, appCompatCheckedTextView.getBackgroundTintMode());
            propertyReader.readObject(this.f1760d, appCompatCheckedTextView.getCheckMarkTintList());
            propertyReader.readObject(this.f1761e, appCompatCheckedTextView.getCheckMarkTintMode());
            propertyReader.readObject(this.f1762f, appCompatCheckedTextView.getCompoundDrawableTintList());
            propertyReader.readObject(this.f1763g, appCompatCheckedTextView.getCompoundDrawableTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f1758b = propertyMapper.mapObject("backgroundTint", R.attr.f673v);
            this.f1759c = propertyMapper.mapObject("backgroundTintMode", R.attr.f675w);
            this.f1760d = propertyMapper.mapObject("checkMarkTint", R.attr.A);
            this.f1761e = propertyMapper.mapObject("checkMarkTintMode", R.attr.B);
            this.f1762f = propertyMapper.mapObject("drawableTint", R.attr.V);
            this.f1763g = propertyMapper.mapObject("drawableTintMode", R.attr.W);
            this.f1757a = true;
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.D);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1756d == null) {
            this.f1756d = new AppCompatEmojiTextHelper(this);
        }
        return this.f1756d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.f1755c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1753a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1753a;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1753a;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1755c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1755c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i3);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1753a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1755c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1755c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1754b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1753a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1753a;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1755c.w(colorStateList);
        this.f1755c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1755c.x(mode);
        this.f1755c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        AppCompatTextHelper appCompatTextHelper = this.f1755c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i3);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i3) {
        super(TintContextWrapper.b(context), attributeSet, i3);
        ThemeUtils.a(this, getContext());
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1755c = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i3);
        appCompatTextHelper.b();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1754b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i3);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = new AppCompatCheckedTextViewHelper(this);
        this.f1753a = appCompatCheckedTextViewHelper;
        appCompatCheckedTextViewHelper.d(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i3) {
        setCheckMarkDrawable(AppCompatResources.b(getContext(), i3));
    }
}
