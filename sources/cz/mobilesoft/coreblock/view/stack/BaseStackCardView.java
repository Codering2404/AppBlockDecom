package cz.mobilesoft.coreblock.view.stack;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.PermissionCardViewBinding;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.stack.BaseStackCardView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public abstract class BaseStackCardView extends MaterialCardView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f132950u = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f132951t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseStackCardView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f132951t = LazyKt.b(new Function0() { // from class: l2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseStackCardView.p(context, this);
            }
        });
    }

    private final PermissionCardViewBinding getBinding() {
        return (PermissionCardViewBinding) this.f132951t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionCardViewBinding p(Context context, BaseStackCardView baseStackCardView) {
        return PermissionCardViewBinding.c(LayoutInflater.from(context), baseStackCardView, true);
    }

    public static /* synthetic */ void r(BaseStackCardView baseStackCardView, String str, String str2, int i3, Integer num, boolean z2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setup");
        }
        if ((i4 & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i4 & 16) != 0) {
            z2 = false;
        }
        baseStackCardView.q(str, str2, i3, num2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setup$lambda$0$1(PermissionCardViewBinding permissionCardViewBinding) {
        ImageView checkImageView = permissionCardViewBinding.f96840b;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        ViewHelperExtKt.b(checkImageView);
    }

    public final void q(String title, String description, int i3, Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        final PermissionCardViewBinding binding = getBinding();
        binding.f96844f.setText(title);
        binding.f96843e.setText(StringHelper.h(description));
        if (num != null) {
            binding.f96842d.setImageResource(num.intValue());
        }
        binding.f96842d.setColorFilter(ContextCompat.getColor(getContext(), i3), PorterDuff.Mode.SRC_IN);
        TextView textView = binding.f96844f;
        Context context = getContext();
        if (z2) {
            i3 = R.color.f95463r;
        }
        textView.setTextColor(ContextCompat.getColor(context, i3));
        ImageView checkImageView = binding.f96840b;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        checkImageView.setVisibility(!z2 ? 4 : 0);
        ImageView iconImageView = binding.f96842d;
        Intrinsics.checkNotNullExpressionValue(iconImageView, "iconImageView");
        iconImageView.setVisibility(z2 ? 4 : 0);
        ImageView chevronImageView = binding.f96841c;
        Intrinsics.checkNotNullExpressionValue(chevronImageView, "chevronImageView");
        chevronImageView.setVisibility(z2 ? 8 : 0);
        if (z2) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: l2.b
                @Override // java.lang.Runnable
                public final void run() {
                    BaseStackCardView.setup$lambda$0$1(binding);
                }
            }, 500L);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseStackCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f95440g);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
