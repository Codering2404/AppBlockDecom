package dev.doubledot.doki.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import dev.doubledot.doki.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BaselineGridTextView extends AppCompatTextView {
    private final float FOUR_DIP;
    private int extraBottomPadding;
    private int extraTopPadding;
    private int fontResId;
    private float lineHeightHint;
    private float lineHeightMultiplierHint;
    private boolean maxLinesByHeight;

    public BaselineGridTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void checkMaxLines(int i3, int i4) {
        if (this.maxLinesByHeight && i4 == 1073741824) {
            setMaxLines((int) Math.floor(((i3 - getCompoundPaddingTop()) - getCompoundPaddingBottom()) / getLineHeight()));
        }
    }

    private final void computeLineHeight() {
        TextPaint paint = getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float fAbs = Math.abs(fontMetrics.ascent - fontMetrics.descent) + fontMetrics.leading;
        float f3 = this.lineHeightHint;
        if (f3 <= 0) {
            f3 = this.lineHeightMultiplierHint * fAbs;
        }
        float f4 = this.FOUR_DIP;
        setLineSpacing(((int) ((f4 * ((float) Math.ceil(f3 / f4))) + 0.5f)) - fAbs, 1.0f);
    }

    private final int ensureBaselineOnGrid() {
        float baseline = getBaseline();
        float f3 = this.FOUR_DIP;
        float f4 = baseline % f3;
        if (f4 != 0.0f) {
            this.extraTopPadding = (int) (((double) f3) - Math.ceil(f4));
        }
        return this.extraTopPadding;
    }

    private final int ensureHeightGridAligned(int i3) {
        float f3 = this.FOUR_DIP;
        float f4 = i3 % f3;
        if (f4 != 0.0f) {
            this.extraBottomPadding = (int) (((double) f3) - Math.ceil(f4));
        }
        return this.extraBottomPadding;
    }

    private final void parseTextAttrs(TypedArray typedArray) {
        int i3 = R.styleable.BaselineGridTextView_lineHeightMultiplierHint;
        if (typedArray.hasValue(i3)) {
            this.lineHeightMultiplierHint = typedArray.getFloat(i3, 1.0f);
        }
        if (typedArray.hasValue(R.styleable.BaselineGridTextView_lineHeightHint)) {
            this.lineHeightHint = typedArray.getDimensionPixelSize(r0, 0);
        }
        int i4 = R.styleable.BaselineGridTextView_android_fontFamily;
        if (typedArray.hasValue(i4)) {
            this.fontResId = typedArray.getResourceId(i4, 0);
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingBottom() {
        return super.getCompoundPaddingBottom() + this.extraBottomPadding;
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop() + this.extraTopPadding;
    }

    public final int getFontResId() {
        return this.fontResId;
    }

    public final float getLineHeightHint() {
        return this.lineHeightHint;
    }

    public final float getLineHeightMultiplierHint() {
        return this.lineHeightMultiplierHint;
    }

    public final boolean getMaxLinesByHeight() {
        return this.maxLinesByHeight;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        this.extraTopPadding = 0;
        this.extraBottomPadding = 0;
        super.onMeasure(i3, i4);
        int measuredHeight = getMeasuredHeight() + ensureBaselineOnGrid();
        int iEnsureHeightGridAligned = measuredHeight + ensureHeightGridAligned(measuredHeight);
        setMeasuredDimension(getMeasuredWidth(), iEnsureHeightGridAligned);
        checkMaxLines(iEnsureHeightGridAligned, View.MeasureSpec.getMode(i4));
    }

    public final void setLineHeightHint(float f3) {
        this.lineHeightHint = f3;
        computeLineHeight();
    }

    public final void setLineHeightMultiplierHint(float f3) {
        this.lineHeightMultiplierHint = f3;
        computeLineHeight();
    }

    public final void setMaxLinesByHeight(boolean z2) {
        this.maxLinesByHeight = z2;
        requestLayout();
    }

    public BaselineGridTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BaselineGridTextView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? android.R.attr.textViewStyle : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaselineGridTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.lineHeightMultiplierHint = 1.0f;
        int[] iArr = R.styleable.BaselineGridTextView;
        TypedArray a3 = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        int i4 = R.styleable.BaselineGridTextView_android_textAppearance;
        if (a3.hasValue(i4)) {
            TypedArray ta = context.obtainStyledAttributes(a3.getResourceId(i4, android.R.style.TextAppearance), iArr);
            Intrinsics.checkExpressionValueIsNotNull(ta, "ta");
            parseTextAttrs(ta);
            ta.recycle();
        }
        Intrinsics.checkExpressionValueIsNotNull(a3, "a");
        parseTextAttrs(a3);
        this.maxLinesByHeight = a3.getBoolean(R.styleable.BaselineGridTextView_maxLinesByHeight, false);
        a3.recycle();
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        this.FOUR_DIP = TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics());
        computeLineHeight();
    }
}
