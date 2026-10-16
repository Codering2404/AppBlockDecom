package cz.mobilesoft.coreblock.view.step;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.LayoutCustomStepBinding;
import cz.mobilesoft.coreblock.view.step.CustomStep;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

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
public final class CustomStep extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f132953g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f132954h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f132955i = R.attr.f95441h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f132956j = R.attr.f95443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f132957k = R.attr.f95442i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutCustomStepBinding f132958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f132959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f132960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f132961d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f132962f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void b() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: m2.a
            @Override // java.lang.Runnable
            public final void run() {
                CustomStep.c(this.f143420a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CustomStep customStep) {
        customStep.refreshDrawableState();
    }

    public final Drawable getErrorIcon() {
        return this.f132962f;
    }

    public final int getNumber() {
        Integer numU = StringsKt.u(this.f132958a.f96775e.getText().toString());
        if (numU != null) {
            return numU.intValue();
        }
        return 0;
    }

    public final CharSequence getSubtitleText() {
        CharSequence text = this.f132958a.f96776f.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return text;
    }

    public final CharSequence getTitleText() {
        CharSequence text = this.f132958a.f96777g.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return text;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.f132959b) {
            linkedHashSet.add(Integer.valueOf(f132955i));
        }
        if (this.f132960c) {
            linkedHashSet.add(Integer.valueOf(f132956j));
        }
        if (this.f132961d) {
            linkedHashSet.add(Integer.valueOf(f132957k));
        }
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + linkedHashSet.size());
        View.mergeDrawableStates(iArrOnCreateDrawableState, CollectionsKt.toIntArray(linkedHashSet));
        return iArrOnCreateDrawableState;
    }

    public final void setComplete(boolean z2) {
        this.f132959b = z2;
        TextView numberTextView = this.f132958a.f96775e;
        Intrinsics.checkNotNullExpressionValue(numberTextView, "numberTextView");
        numberTextView.setVisibility(!z2 && !this.f132960c ? 0 : 8);
        b();
    }

    public final void setCurrent(boolean z2) {
        this.f132961d = z2;
        ImageView chevronImageView = this.f132958a.f96772b;
        Intrinsics.checkNotNullExpressionValue(chevronImageView, "chevronImageView");
        chevronImageView.setVisibility(z2 ? 0 : 8);
        this.f132958a.f96773c.setCardBackgroundColor(ContextCompat.getColor(getContext(), z2 ? R.color.f95466u : R.color.f95460o));
        b();
    }

    public final void setError(boolean z2) {
        this.f132960c = z2;
        TextView numberTextView = this.f132958a.f96775e;
        Intrinsics.checkNotNullExpressionValue(numberTextView, "numberTextView");
        numberTextView.setVisibility(!z2 && !this.f132959b ? 0 : 8);
        this.f132958a.f96774d.setImageDrawable(z2 ? this.f132962f : null);
        b();
    }

    public final void setErrorIcon(Drawable drawable) {
        this.f132962f = drawable;
        if (this.f132960c) {
            this.f132958a.f96774d.setImageDrawable(drawable);
        }
    }

    public final void setNumber(int i3) {
        TextView textView = this.f132958a.f96775e;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.getDefault(), "%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        textView.setText(str);
    }

    public final void setSubtitleText(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f132958a.f96776f.setText(value);
    }

    public final void setTitleText(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f132958a.f96777g.setText(value);
    }
}
