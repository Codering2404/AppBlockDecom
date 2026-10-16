package cz.mobilesoft.coreblock.scene.more.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.ViewSettingsItemBinding;
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
public final class SettingsItemView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f108049c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f108050d = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f108051f = {R.attr.f95437d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewSettingsItemBinding f108052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f108053b;

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
    public SettingsItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewSettingsItemBinding viewSettingsItemBindingC = ViewSettingsItemBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewSettingsItemBindingC, "inflate(...)");
        this.f108052a = viewSettingsItemBindingC;
        this.f108053b = true;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.C2, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setBackgroundResource(R.drawable.Qa);
        try {
            setTitleText(typedArrayObtainStyledAttributes.getString(R.styleable.E2));
            setSubtitleText(typedArrayObtainStyledAttributes.getString(R.styleable.D2));
            setValueText(typedArrayObtainStyledAttributes.getString(R.styleable.F2));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final CharSequence getSubtitleText() {
        return this.f108052a.f96863b.getText();
    }

    public final CharSequence getTitleText() {
        return this.f108052a.f96864c.getText();
    }

    public final CharSequence getValueText() {
        return this.f108052a.f96865d.getText();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (!this.f108053b) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f108051f);
        }
        return iArrOnCreateDrawableState;
    }

    public final void setEnabledAppearance(boolean z2) {
        this.f108053b = z2;
        refreshDrawableState();
    }

    public final void setSubtitleText(CharSequence charSequence) {
        this.f108052a.f96863b.setText(charSequence);
        setSubtitleVisible(charSequence != null);
    }

    public final void setSubtitleVisible(boolean z2) {
        TextView subtitleTextView = this.f108052a.f96863b;
        Intrinsics.checkNotNullExpressionValue(subtitleTextView, "subtitleTextView");
        subtitleTextView.setVisibility(z2 ? 0 : 8);
    }

    public final void setTitleText(CharSequence charSequence) {
        this.f108052a.f96864c.setText(charSequence);
    }

    public final void setValueText(CharSequence charSequence) {
        this.f108052a.f96865d.setText(charSequence);
        setValueVisible(charSequence != null);
    }

    public final void setValueVisible(boolean z2) {
        TextView valueTextView = this.f108052a.f96865d;
        Intrinsics.checkNotNullExpressionValue(valueTextView, "valueTextView");
        valueTextView.setVisibility(z2 ? 0 : 8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SettingsItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f95439f);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
