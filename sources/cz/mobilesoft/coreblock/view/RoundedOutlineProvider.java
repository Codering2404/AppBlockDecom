package cz.mobilesoft.coreblock.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
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
public final class RoundedOutlineProvider extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f130053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f130054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f130055c;

    public RoundedOutlineProvider(int i3, Integer num, Integer num2) {
        this.f130053a = i3;
        this.f130054b = num;
        this.f130055c = num2;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Integer num = this.f130054b;
        int iIntValue = num != null ? num.intValue() : view.getWidth();
        Integer num2 = this.f130055c;
        int iIntValue2 = num2 != null ? num2.intValue() : view.getHeight();
        int width = iIntValue < view.getWidth() ? (view.getWidth() - iIntValue) / 2 : 0;
        int height = iIntValue2 < view.getHeight() ? (view.getHeight() - iIntValue2) / 2 : 0;
        if (iIntValue != iIntValue2) {
            outline.setRoundRect(width, height, width + iIntValue, height + iIntValue2, this.f130053a);
        } else {
            int i3 = this.f130053a;
            outline.setOval(width, height, (i3 * 2) + width, (i3 * 2) + height);
        }
    }

    public /* synthetic */ RoundedOutlineProvider(int i3, Integer num, Integer num2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? null : num2);
    }
}
