package cz.mobilesoft.coreblock.view.stack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.view.stack.HelpCardView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class HelpCardView extends BaseStackCardView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelpCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, HelpItem helpItem, View view) {
        function1.invoke(helpItem);
    }

    public final void t(final HelpItem item, final Function1 onCardClicked) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onCardClicked, "onCardClicked");
        String string = getContext().getString(item.getTitleResId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BaseStackCardView.r(this, string, item.getDescription(context), R.color.f95446a, Integer.valueOf(item.getIconResId()), false, 16, null);
        setOnClickListener(new View.OnClickListener() { // from class: l2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpCardView.u(onCardClicked, item, view);
            }
        });
    }
}
