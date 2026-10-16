package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView, OnReceiveContentViewBehavior, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatBackgroundHelper f1785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatTextHelper f1786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppCompatTextClassifierHelper f1787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextViewOnReceiveContentListener f1788d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppCompatEmojiEditTextHelper f1789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SuperCaller f1790g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1795e;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(AppCompatEditText appCompatEditText, PropertyReader propertyReader) {
            if (!this.f1791a) {
                throw c.a();
            }
            propertyReader.readObject(this.f1792b, appCompatEditText.getBackgroundTintList());
            propertyReader.readObject(this.f1793c, appCompatEditText.getBackgroundTintMode());
            propertyReader.readObject(this.f1794d, appCompatEditText.getCompoundDrawableTintList());
            propertyReader.readObject(this.f1795e, appCompatEditText.getCompoundDrawableTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f1792b = propertyMapper.mapObject("backgroundTint", R.attr.f673v);
            this.f1793c = propertyMapper.mapObject("backgroundTintMode", R.attr.f675w);
            this.f1794d = propertyMapper.mapObject("drawableTint", R.attr.V);
            this.f1795e = propertyMapper.mapObject("drawableTintMode", R.attr.W);
            this.f1791a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class SuperCaller {
        SuperCaller() {
        }

        public TextClassifier a() {
            return AppCompatEditText.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            AppCompatEditText.super.setTextClassifier(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Z);
    }

    private SuperCaller getSuperCaller() {
        if (this.f1790g == null) {
            this.f1790g = new SuperCaller();
        }
        return this.f1790g;
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public ContentInfoCompat a(ContentInfoCompat contentInfoCompat) {
        return this.f1788d.a(this, contentInfoCompat);
    }

    void d(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
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
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1786b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1786b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1786b.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrB;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1786b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = AppCompatHintHelper.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrB = ViewCompat.B(this)) != null) {
            EditorInfoCompat.c(editorInfo, strArrB);
            inputConnectionA = InputConnectionCompat.c(this, inputConnectionA, editorInfo);
        }
        return this.f1789f.d(inputConnectionA, editorInfo);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30 || i3 >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AppCompatReceiveContentHelper.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (AppCompatReceiveContentHelper.b(this, i3)) {
            return true;
        }
        return super.onTextContextMenuItem(i3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1786b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1786b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f1789f.e(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1789f.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1785a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1786b.w(colorStateList);
        this.f1786b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1786b.x(mode);
        this.f1786b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        AppCompatTextHelper appCompatTextHelper = this.f1786b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().b(textClassifier);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i3) {
        super(TintContextWrapper.b(context), attributeSet, i3);
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1785a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i3);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1786b = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i3);
        appCompatTextHelper.b();
        this.f1787c = new AppCompatTextClassifierHelper(this);
        this.f1788d = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.f1789f = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.c(attributeSet, i3);
        d(appCompatEmojiEditTextHelper);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }
}
