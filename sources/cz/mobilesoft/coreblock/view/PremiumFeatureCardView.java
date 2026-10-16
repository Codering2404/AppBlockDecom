package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.LayoutPremiumFeatureCardViewBinding;
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
public final class PremiumFeatureCardView extends MaterialCardView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LayoutPremiumFeatureCardViewBinding f130052t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PremiumFeatureCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutPremiumFeatureCardViewBinding layoutPremiumFeatureCardViewBindingC = LayoutPremiumFeatureCardViewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(layoutPremiumFeatureCardViewBindingC, "inflate(...)");
        this.f130052t = layoutPremiumFeatureCardViewBindingC;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f95939p2);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            setTitleText(typedArrayObtainStyledAttributes.getString(R.styleable.f95943q2));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final CharSequence getTitleText() {
        return this.f130052t.f96807c.getText();
    }

    public final void setTitleText(CharSequence charSequence) {
        this.f130052t.f96807c.setText(charSequence);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PremiumFeatureCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f95438e);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PremiumFeatureCardView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
