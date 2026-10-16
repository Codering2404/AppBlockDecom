package cz.mobilesoft.coreblock.scene.quickblock.tile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import com.facebook.share.internal.ShareConstants;
import com.github.appintro.SlidePolicy;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentWhatsNewBinding;
import cz.mobilesoft.coreblock.scene.quickblock.tile.WhatsNewFragment;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
public final class WhatsNewFragment extends BaseFragment<FragmentWhatsNewBinding> implements SlidePolicy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f114236c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f114237d = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WhatsNewFragmentListener f114238b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WhatsNewFragment a(SlideDTO slideDTO) {
            Intrinsics.checkNotNullParameter(slideDTO, "slideDTO");
            WhatsNewFragment whatsNewFragment = new WhatsNewFragment();
            whatsNewFragment.setArguments(BundleKt.b(TuplesKt.a(ShareConstants.TITLE, Integer.valueOf(slideDTO.d())), TuplesKt.a(ShareConstants.DESCRIPTION, Integer.valueOf(slideDTO.c())), TuplesKt.a(ShareConstants.IMAGE_URL, Integer.valueOf(slideDTO.b())), TuplesKt.a("ACTION_ID", slideDTO.a())));
            return whatsNewFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SlideDTO implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f114239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f114240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f114241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Integer f114242d;

        public SlideDTO(int i3, int i4, int i5, Integer num) {
            this.f114239a = i3;
            this.f114240b = i4;
            this.f114241c = i5;
            this.f114242d = num;
        }

        public final Integer a() {
            return this.f114242d;
        }

        public final int b() {
            return this.f114241c;
        }

        public final int c() {
            return this.f114240b;
        }

        public final int d() {
            return this.f114239a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface WhatsNewFragmentListener {
        void f(WhatsNewFragment whatsNewFragment);

        void h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(WhatsNewFragment whatsNewFragment, View view) {
        WhatsNewFragmentListener whatsNewFragmentListener = whatsNewFragment.f114238b;
        if (whatsNewFragmentListener != null) {
            whatsNewFragmentListener.h();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(FragmentWhatsNewBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            binding.f96708d.setImageResource(arguments.getInt(ShareConstants.IMAGE_URL));
            binding.f96711g.setText(arguments.getInt(ShareConstants.TITLE));
            TextView descriptionTextView = binding.f96707c;
            Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
            ViewHelperExtKt.l(descriptionTextView, arguments.getInt(ShareConstants.DESCRIPTION), false, 2, null);
            Integer numValueOf = Integer.valueOf(arguments.getInt("ACTION_ID", -1));
            Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
            if (num == null) {
                Button button = binding.f96706b;
                Intrinsics.checkNotNullExpressionValue(button, "button");
                button.setVisibility(8);
            } else {
                int iIntValue = num.intValue();
                Button button2 = binding.f96706b;
                Intrinsics.checkNotNullExpressionValue(button2, "button");
                button2.setVisibility(0);
                binding.f96706b.setText(iIntValue);
                binding.f96706b.setOnClickListener(new View.OnClickListener() { // from class: l1.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WhatsNewFragment.C(this.f143211a, view2);
                    }
                });
            }
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public FragmentWhatsNewBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentWhatsNewBinding fragmentWhatsNewBindingC = FragmentWhatsNewBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentWhatsNewBindingC, "inflate(...)");
        return fragmentWhatsNewBindingC;
    }

    @Override // com.github.appintro.SlidePolicy
    public boolean isPolicyRespected() {
        Button button = ((FragmentWhatsNewBinding) w()).f96706b;
        Intrinsics.checkNotNullExpressionValue(button, "button");
        return !(button.getVisibility() == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof WhatsNewFragmentListener) {
            this.f114238b = (WhatsNewFragmentListener) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f114238b = null;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WhatsNewFragmentListener whatsNewFragmentListener = this.f114238b;
        if (whatsNewFragmentListener != null) {
            whatsNewFragmentListener.f(this);
        }
    }

    @Override // com.github.appintro.SlidePolicy
    public void onUserIllegallyRequestedNextPage() {
    }
}
