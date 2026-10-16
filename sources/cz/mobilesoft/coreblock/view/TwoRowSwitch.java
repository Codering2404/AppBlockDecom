package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.ViewTwoRowSwitchBinding;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TwoRowSwitch extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f130062g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f130063h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f130064i = {R.attr.f95437d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewTwoRowSwitchBinding f130065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f130066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f130067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f130068d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f130069f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoRowSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z2 = true;
        final ViewTwoRowSwitchBinding viewTwoRowSwitchBindingC = ViewTwoRowSwitchBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewTwoRowSwitchBindingC, "inflate(...)");
        this.f130065a = viewTwoRowSwitchBindingC;
        this.f130068d = true;
        this.f130069f = -1;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.m3, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setBackgroundResource(R.drawable.Qa);
        try {
            setTitleText(typedArrayObtainStyledAttributes.getString(R.styleable.r3));
            setSubtitleText(typedArrayObtainStyledAttributes.getString(R.styleable.q3));
            setErrorImageResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.n3, -1));
            setIconPadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.p3, getIconPadding()));
            setActivated(true);
            Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.o3, -1));
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                viewTwoRowSwitchBindingC.f96872c.setImageResource(numValueOf.intValue());
            } else {
                z2 = false;
            }
            setImageVisible(z2);
            typedArrayObtainStyledAttributes.recycle();
            setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwoRowSwitch.a(viewTwoRowSwitchBindingC, view);
                }
            });
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static void a(ViewTwoRowSwitchBinding viewTwoRowSwitchBinding, View view) {
        viewTwoRowSwitchBinding.f96874e.setChecked(!r0.isChecked());
    }

    public final int getErrorImageResource() {
        return this.f130069f;
    }

    public final int getIconPadding() {
        ViewGroup.LayoutParams layoutParams = this.f130065a.f96872c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        return ((ConstraintLayout.LayoutParams) layoutParams).getMarginEnd();
    }

    public final CharSequence getSubtitleText() {
        return this.f130065a.f96873d.getText();
    }

    public final CharSequence getTitleText() {
        return this.f130065a.f96875f.getText();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (!this.f130068d) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f130064i);
        }
        return iArrOnCreateDrawableState;
    }

    public final void setChecked(boolean z2) {
        SwitchMaterial switchMaterial = this.f130065a.f96874e;
        switchMaterial.setOnCheckedChangeListener(null);
        switchMaterial.setChecked(z2);
        switchMaterial.setOnCheckedChangeListener(this.f130066b);
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.f130065a.f96874e.setClickable(false);
        super.setOnClickListener(onClickListener);
    }

    public final void setEnabledAppearance(boolean z2) {
        this.f130068d = z2;
        refreshDrawableState();
    }

    public final void setErrorImageResource(int i3) {
        if (i3 > 0) {
            this.f130065a.f96871b.setImageResource(i3);
        }
        this.f130069f = i3;
    }

    public final void setErrorShown(boolean z2) {
        if (z2 || this.f130069f != -1) {
            ImageView errorImageView = this.f130065a.f96871b;
            Intrinsics.checkNotNullExpressionValue(errorImageView, "errorImageView");
            errorImageView.setVisibility(z2 ? 0 : 8);
            this.f130067c = z2;
        }
    }

    public final void setIconPadding(int i3) {
        ImageView imageView = this.f130065a.f96872c;
        Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int marginStart = layoutParams2.getMarginStart();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
        layoutParams2.setMarginStart(marginStart);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i4;
        layoutParams2.setMarginEnd(i3);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i5;
        imageView.setLayoutParams(layoutParams);
    }

    public final void setImageDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.f130065a.f96872c.setImageDrawable(drawable);
    }

    public final void setImageResource(int i3) {
        this.f130065a.f96872c.setImageResource(i3);
    }

    public final void setImageVisible(boolean z2) {
        ImageView imageView = this.f130065a.f96872c;
        Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
        imageView.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f130066b = onCheckedChangeListener;
        this.f130065a.f96874e.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final void setSubtitleText(CharSequence charSequence) {
        this.f130065a.f96873d.setText(charSequence);
        setSubtitleVisible(charSequence != null);
    }

    public final void setSubtitleVisible(boolean z2) {
        AppCompatTextView subtitleTextView = this.f130065a.f96873d;
        Intrinsics.checkNotNullExpressionValue(subtitleTextView, "subtitleTextView");
        subtitleTextView.setVisibility(z2 ? 0 : 8);
    }

    public final void setTitleText(CharSequence charSequence) {
        this.f130065a.f96875f.setText(charSequence);
    }
}
