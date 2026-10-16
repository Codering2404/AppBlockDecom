package cz.mobilesoft.coreblock.view.step;

import android.widget.FrameLayout;
import android.widget.TextView;
import cz.mobilesoft.coreblock.databinding.LayoutExplanationStepBinding;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ExplanationStep extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutExplanationStepBinding f132963a;

    public final CharSequence getDescription() {
        CharSequence text = this.f132963a.f96787b.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return text;
    }

    public final int getNumber() {
        Integer numU = StringsKt.u(this.f132963a.f96788c.getText().toString());
        if (numU != null) {
            return numU.intValue();
        }
        return 0;
    }

    public final void setDescription(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f132963a.f96787b.setText(value);
    }

    public final void setNumber(int i3) {
        TextView textView = this.f132963a.f96788c;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.getDefault(), "%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        textView.setText(str);
    }
}
