package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CheckBox;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatCompoundButtonHelper f1742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatBackgroundHelper f1743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppCompatTextHelper f1744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppCompatEmojiTextHelper f1745d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1750e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1751f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1752g;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(AppCompatCheckBox appCompatCheckBox, PropertyReader propertyReader) {
            if (!this.f1746a) {
                throw c.a();
            }
            propertyReader.readObject(this.f1747b, appCompatCheckBox.getBackgroundTintList());
            propertyReader.readObject(this.f1748c, appCompatCheckBox.getBackgroundTintMode());
            propertyReader.readObject(this.f1749d, appCompatCheckBox.getButtonTintList());
            propertyReader.readObject(this.f1750e, appCompatCheckBox.getButtonTintMode());
            propertyReader.readObject(this.f1751f, appCompatCheckBox.getCompoundDrawableTintList());
            propertyReader.readObject(this.f1752g, appCompatCheckBox.getCompoundDrawableTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f1747b = propertyMapper.mapObject("backgroundTint", R.attr.f673v);
            this.f1748c = propertyMapper.mapObject("backgroundTintMode", R.attr.f675w);
            this.f1749d = propertyMapper.mapObject("buttonTint", R.attr.f679y);
            this.f1750e = propertyMapper.mapObject("buttonTintMode", R.attr.f681z);
            this.f1751f = propertyMapper.mapObject("drawableTint", R.attr.V);
            this.f1752g = propertyMapper.mapObject("drawableTintMode", R.attr.W);
            this.f1746a = true;
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.C);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1745d == null) {
            this.f1745d = new AppCompatEmojiTextHelper(this);
        }
        return this.f1745d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1744c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1742a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1742a;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1744c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1744c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i3);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1742a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1744c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1744c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1743b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1742a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1742a;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1744c.w(colorStateList);
        this.f1744c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1744c.x(mode);
        this.f1744c.b();
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i3) {
        super(TintContextWrapper.b(context), attributeSet, i3);
        ThemeUtils.a(this, getContext());
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.f1742a = appCompatCompoundButtonHelper;
        appCompatCompoundButtonHelper.d(attributeSet, i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1743b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i3);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1744c = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(AppCompatResources.b(getContext(), i3));
    }
}
