package cz.mobilesoft.coreblock.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.databinding.LayoutBaseCardViewHolderBinding;
import cz.mobilesoft.coreblock.databinding.LayoutPermissionsCardSimpleBinding;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionsCardSimpleViewHolder extends BaseLayoutCardViewHolder<LayoutPermissionsCardSimpleBinding> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f133471e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f133472f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f133473g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f133474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f133475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f133476d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z2) {
            PermissionsCardSimpleViewHolder.f133473g = z2;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        LayoutBaseCardViewHolderBinding layoutBaseCardViewHolderBindingB = b();
        f133473g = true;
        ImageView checkImageView = layoutBaseCardViewHolderBindingB.f96759c;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        ViewHelperExtKt.b(checkImageView);
        h(true);
    }

    private final void h(boolean z2) {
        LayoutBaseCardViewHolderBinding layoutBaseCardViewHolderBindingB = b();
        MaterialCardView baseCardView = layoutBaseCardViewHolderBindingB.f96758b;
        Intrinsics.checkNotNullExpressionValue(baseCardView, "baseCardView");
        baseCardView.setVisibility(z2 ? 4 : 0);
        ImageView checkImageView = layoutBaseCardViewHolderBindingB.f96759c;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        checkImageView.setVisibility(z2 ? 0 : 8);
    }

    public final void f(boolean z2) {
        View viewA = a();
        int i3 = 0;
        if (this.f133475c && z2) {
            this.f133476d = true;
        } else {
            this.f133476d = false;
            i3 = 8;
        }
        viewA.setVisibility(i3);
    }
}
