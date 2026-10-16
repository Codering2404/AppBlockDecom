package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.ViewSwitchCardBinding;
import kotlin.Metadata;
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
public final class SwitchCardView extends MaterialCardView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ViewSwitchCardBinding f130056t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f130057u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f130058v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f130059w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f130060x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f130061y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        final ViewSwitchCardBinding viewSwitchCardBindingC = ViewSwitchCardBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewSwitchCardBindingC, "inflate(...)");
        this.f130056t = viewSwitchCardBindingC;
        this.f130058v = "ON";
        this.f130059w = "OFF";
        this.f130060x = ContextCompat.getColor(context, R.color.f95446a);
        this.f130061y = ContextCompat.getColor(context, R.color.f95456k);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.S2);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.W2);
            if (string != null) {
                this.f130058v = string;
            }
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.V2);
            if (string2 != null) {
                this.f130059w = string2;
            }
            this.f130060x = typedArrayObtainStyledAttributes.getColor(R.styleable.U2, this.f130060x);
            this.f130061y = typedArrayObtainStyledAttributes.getColor(R.styleable.T2, this.f130061y);
            s();
            typedArrayObtainStyledAttributes.recycle();
        }
        setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchCardView.n(viewSwitchCardBindingC, view);
            }
        });
        viewSwitchCardBindingC.f96869d.setOnCheckedChangeListener(this.f130057u);
    }

    public static void n(ViewSwitchCardBinding viewSwitchCardBinding, View view) {
        viewSwitchCardBinding.f96869d.setChecked(!r0.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(CompoundButton.OnCheckedChangeListener onCheckedChangeListener, SwitchCardView switchCardView, CompoundButton buttonView, boolean z2) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        onCheckedChangeListener.onCheckedChanged(buttonView, z2);
        switchCardView.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CompoundButton compoundButton, boolean z2) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
    }

    private final void s() {
        ViewSwitchCardBinding viewSwitchCardBinding = this.f130056t;
        if (viewSwitchCardBinding.f96869d.isChecked()) {
            viewSwitchCardBinding.f96867b.setText(this.f130058v);
            viewSwitchCardBinding.getRoot().setBackgroundColor(this.f130060x);
        } else {
            viewSwitchCardBinding.f96867b.setText(this.f130059w);
            viewSwitchCardBinding.getRoot().setBackgroundColor(this.f130061y);
        }
    }

    @Override // com.google.android.material.card.MaterialCardView, android.widget.Checkable
    public boolean isChecked() {
        try {
            return this.f130056t.f96869d.isChecked();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    @Override // com.google.android.material.card.MaterialCardView, android.widget.Checkable
    public void setChecked(boolean z2) {
        this.f130056t.f96869d.setChecked(z2);
    }

    public final void setCheckedListener(final CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f130057u = listener;
        this.f130056t.f96869d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.view.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                SwitchCardView.q(listener, this, compoundButton, z2);
            }
        });
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.f130056t.f96869d.setClickable(false);
        setCheckedListener(new CompoundButton.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.view.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                SwitchCardView.r(compoundButton, z2);
            }
        });
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        ViewSwitchCardBinding viewSwitchCardBinding = this.f130056t;
        viewSwitchCardBinding.getRoot().setEnabled(z2);
        viewSwitchCardBinding.f96869d.setEnabled(z2);
    }

    public final void setRemainingTimeText(String str) {
        TextView textView = this.f130056t.f96868c;
        textView.setText(str);
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(str == null || str.length() == 0 ? 8 : 0);
    }

    @Override // com.google.android.material.card.MaterialCardView, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f95435b);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
