package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.libraries.places.R;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class RatingStarsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView[] f79137a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingStarsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.C, this);
        View viewFindViewById = findViewById(R.id.H1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.I1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = findViewById(R.id.J1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = findViewById(R.id.K1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        View viewFindViewById5 = findViewById(R.id.L1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f79137a = new ImageView[]{(ImageView) viewFindViewById, (ImageView) viewFindViewById2, (ImageView) viewFindViewById3, (ImageView) viewFindViewById4, (ImageView) viewFindViewById5};
    }

    public final void a(double d3) {
        zzbs zzbsVarA = zzbr.a(d3);
        ImageView[] imageViewArr = this.f79137a;
        int length = imageViewArr.length;
        for (int i3 = 0; i3 < 5; i3++) {
            imageViewArr[i3].setImageDrawable(getResources().getDrawable(zzbsVarA.a(i3), getContext().getTheme()));
        }
    }
}
