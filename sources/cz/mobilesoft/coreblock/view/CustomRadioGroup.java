package cz.mobilesoft.coreblock.view;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import cz.mobilesoft.coreblock.view.CustomRadioButton;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CustomRadioGroup extends LinearLayout implements CustomRadioButton.OnToggledListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f130040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f130041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnCheckedChangeListener f130042c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnCheckedChangeListener {
    }

    private final void a() {
        this.f130040a.clear();
        for (View view : ViewGroupKt.a(this)) {
            if (view instanceof CustomRadioButton) {
                ((CustomRadioButton) view).setListener(this);
                this.f130040a.add(view);
            }
        }
    }

    public final List<CustomRadioButton<?>> getButtons() {
        return this.f130040a;
    }

    public final int getCheckedItemId() {
        return this.f130041b;
    }

    public final OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.f130042c;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public final void setButtons(List<CustomRadioButton<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f130040a = list;
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f130042c = onCheckedChangeListener;
    }
}
