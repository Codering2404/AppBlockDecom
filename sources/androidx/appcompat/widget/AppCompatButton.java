package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView, EmojiCompatConfigurationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatBackgroundHelper f1729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatTextHelper f1730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppCompatEmojiTextHelper f1731c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1735d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1736e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1737f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1738g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1739h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1740i;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(AppCompatButton appCompatButton, PropertyReader propertyReader) {
            if (!this.f1732a) {
                throw c.a();
            }
            propertyReader.readInt(this.f1733b, appCompatButton.getAutoSizeMaxTextSize());
            propertyReader.readInt(this.f1734c, appCompatButton.getAutoSizeMinTextSize());
            propertyReader.readInt(this.f1735d, appCompatButton.getAutoSizeStepGranularity());
            propertyReader.readIntEnum(this.f1736e, appCompatButton.getAutoSizeTextType());
            propertyReader.readObject(this.f1737f, appCompatButton.getBackgroundTintList());
            propertyReader.readObject(this.f1738g, appCompatButton.getBackgroundTintMode());
            propertyReader.readObject(this.f1739h, appCompatButton.getCompoundDrawableTintList());
            propertyReader.readObject(this.f1740i, appCompatButton.getCompoundDrawableTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f1733b = propertyMapper.mapInt("autoSizeMaxTextSize", R.attr.f665r);
            this.f1734c = propertyMapper.mapInt("autoSizeMinTextSize", R.attr.f667s);
            this.f1735d = propertyMapper.mapInt("autoSizeStepGranularity", R.attr.f669t);
            this.f1736e = propertyMapper.mapIntEnum("autoSizeTextType", R.attr.f671u, new IntFunction<String>() { // from class: androidx.appcompat.widget.AppCompatButton.InspectionCompanion.1
                @Override // java.util.function.IntFunction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String apply(int i3) {
                    return i3 != 0 ? i3 != 1 ? String.valueOf(i3) : "uniform" : IntegrityManager.INTEGRITY_TYPE_NONE;
                }
            });
            this.f1737f = propertyMapper.mapObject("backgroundTint", R.attr.f673v);
            this.f1738g = propertyMapper.mapObject("backgroundTintMode", R.attr.f675w);
            this.f1739h = propertyMapper.mapObject("drawableTint", R.attr.V);
            this.f1740i = propertyMapper.mapObject("drawableTintMode", R.attr.W);
            this.f1732a = true;
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f677x);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1731c == null) {
            this.f1731c = new AppCompatEmojiTextHelper(this);
        }
        return this.f1731c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f2355c) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f2355c) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f2355c) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f2355c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        return appCompatTextHelper != null ? appCompatTextHelper.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (ViewUtils.f2355c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1730b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1730b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.o(z2, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper == null || ViewUtils.f2355c || !appCompatTextHelper.l()) {
            return;
        }
        this.f1730b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) {
        if (ViewUtils.f2355c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.t(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        if (ViewUtils.f2355c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.u(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (ViewUtils.f2355c) {
            super.setAutoSizeTextTypeWithDefaults(i3);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.v(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z2) {
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.s(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1729a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1730b.w(colorStateList);
        this.f1730b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1730b.x(mode);
        this.f1730b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (ViewUtils.f2355c) {
            super.setTextSize(i3, f3);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1730b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.A(i3, f3);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i3) {
        super(TintContextWrapper.b(context), attributeSet, i3);
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1729a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i3);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1730b = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i3);
        appCompatTextHelper.b();
        getEmojiTextViewHelper().c(attributeSet, i3);
    }
}
