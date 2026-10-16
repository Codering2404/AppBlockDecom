package cz.mobilesoft.coreblock.scene.more.backup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentBackupCreateBinding;
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
public final class BackupCreateFragment extends BaseBackupCreateFragment<FragmentBackupCreateBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f106353g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f106354h = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupCreateFragment a() {
            return new BackupCreateFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(BackupCreateFragment backupCreateFragment, View view) {
        backupCreateFragment.O();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public void y(FragmentBackupCreateBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        String string = getString(R.string.R2, getString(R.string.U2, getString(R.string.B2), getString(R.string.f95790f1)));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView descriptionTextView = binding.f96604c;
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        ViewHelperExtKt.m(descriptionTextView, string, false, 2, null);
        binding.f96603b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackupCreateFragment.T(this.f106430a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public FragmentBackupCreateBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentBackupCreateBinding fragmentBackupCreateBindingC = FragmentBackupCreateBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentBackupCreateBindingC, "inflate(...)");
        return fragmentBackupCreateBindingC;
    }
}
