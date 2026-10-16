package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAcademyLessonUnavailableBinding;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AcademyLessonUnavailableFragment extends BaseFragment<FragmentAcademyLessonUnavailableBinding> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f106233b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f106234c = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AcademyLessonUnavailableFragment a() {
            return new AcademyLessonUnavailableFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AcademyLessonUnavailableFragment academyLessonUnavailableFragment, View view) {
        AnswersHelper.f128199a.F();
        FragmentActivity activity = academyLessonUnavailableFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AcademyLessonUnavailableFragment academyLessonUnavailableFragment, View view) {
        AnswersHelper.f128199a.E();
        FragmentActivity activity = academyLessonUnavailableFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(FragmentAcademyLessonUnavailableBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        TextView descriptionTextView = binding.f96586c;
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        ViewHelperExtKt.l(descriptionTextView, R.string.Qi, false, 2, null);
        binding.f96592i.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyLessonUnavailableFragment.D(this.f106344a, view2);
            }
        });
        binding.f96585b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcademyLessonUnavailableFragment.E(this.f106345a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public FragmentAcademyLessonUnavailableBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAcademyLessonUnavailableBinding fragmentAcademyLessonUnavailableBindingC = FragmentAcademyLessonUnavailableBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAcademyLessonUnavailableBindingC, "inflate(...)");
        return fragmentAcademyLessonUnavailableBindingC;
    }
}
