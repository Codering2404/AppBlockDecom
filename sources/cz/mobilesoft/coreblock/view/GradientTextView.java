package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.R;
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
public final class GradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f130043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f130044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f130045c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f130044b = ContextCompat.getColor(getContext(), R.color.f95446a);
        this.f130045c = ContextCompat.getColor(getContext(), R.color.f95447b);
        f(context, attributeSet);
    }

    private final void f(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.N0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.f130043a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.P0, false);
            this.f130044b = typedArrayObtainStyledAttributes.getColor(R.styleable.Q0, this.f130044b);
            this.f130045c = typedArrayObtainStyledAttributes.getColor(R.styleable.O0, this.f130045c);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (z2) {
            float f3 = i6 - i4;
            getPaint().setShader(this.f130043a ? new LinearGradient(0.0f, 0.0f, Math.abs(i3 - i5), f3, this.f130044b, this.f130045c, Shader.TileMode.CLAMP) : new LinearGradient(0.0f, 0.0f, 0.0f, f3, this.f130044b, this.f130045c, Shader.TileMode.CLAMP));
        }
    }
}
