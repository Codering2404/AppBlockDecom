package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaddingValuesKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.UnsignedKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class SizeKt {
    public static final /* synthetic */ Size addMargin(Size size, PaddingValues margin, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return new Size(m739addMarginQn1smSk(size.getWidth(), UnsignedKt.a(PaddingValuesKt.calculateHorizontalPadding(margin, layoutDirection))), m739addMarginQn1smSk(size.getHeight(), UnsignedKt.a(PaddingValuesKt.calculateVerticalPadding(margin))));
    }

    /* JADX INFO: renamed from: addMargin-Qn1smSk, reason: not valid java name */
    private static final SizeConstraint m739addMarginQn1smSk(SizeConstraint sizeConstraint, int i3) {
        if (sizeConstraint instanceof SizeConstraint.Fixed) {
            return new SizeConstraint.Fixed(UInt.b(((SizeConstraint.Fixed) sizeConstraint).m662getValuepVg5ArA() + i3), null);
        }
        if (sizeConstraint instanceof SizeConstraint.Fill ? true : sizeConstraint instanceof SizeConstraint.Fit) {
            return sizeConstraint;
        }
        throw new NoWhenBranchMatchedException();
    }
}
