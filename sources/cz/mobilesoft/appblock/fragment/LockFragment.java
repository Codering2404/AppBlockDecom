package cz.mobilesoft.appblock.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.facebook.share.internal.ShareConstants;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.appblock.fragment.LockFragment;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.appblock.view.LockScreenProvider;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LockFragment extends BaseFragment<FragmentLockBinding> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LockScreenProvider f94023b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(LockFragment lockFragment) {
        FragmentActivity fragmentActivityRequireActivity = lockFragment.requireActivity();
        ServiceHelper serviceHelper = ServiceHelper.f95139a;
        Intrinsics.checkNotNull(fragmentActivityRequireActivity);
        serviceHelper.c(fragmentActivityRequireActivity);
    }

    public final void B() {
        LockScreenProvider lockScreenProvider = this.f94023b;
        if (lockScreenProvider != null) {
            lockScreenProvider.M0();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public FragmentLockBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentLockBinding fragmentLockBindingC = FragmentLockBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentLockBindingC, "inflate(...)");
        return fragmentLockBindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LockScreenProvider lockScreenProvider = this.f94023b;
        if (lockScreenProvider == null || !lockScreenProvider.L0()) {
            return;
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        ServiceHelper serviceHelper = ServiceHelper.f95139a;
        Intrinsics.checkNotNull(fragmentActivityRequireActivity);
        serviceHelper.c(fragmentActivityRequireActivity);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Intent intent = requireActivity().getIntent();
        String stringExtra = intent.getStringExtra("PACKAGE_NAME");
        long longExtra = intent.getLongExtra("BLOCK_UNTIL", -1L);
        Long lValueOf = Long.valueOf(longExtra);
        if (longExtra == -1) {
            lValueOf = null;
        }
        Long l3 = lValueOf;
        Serializable serializableExtra = intent.getSerializableExtra("PROFILE_TYPE");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type cz.mobilesoft.coreblock.enums.ProfileType");
        ProfileType profileType = (ProfileType) serializableExtra;
        UsageLimit.PeriodType periodType = (UsageLimit.PeriodType) intent.getSerializableExtra("USAGE_PERIOD_TYPE");
        String stringExtra2 = intent.getStringExtra(ShareConstants.TITLE);
        Intrinsics.checkNotNull(stringExtra2, "null cannot be cast to non-null type kotlin.String");
        if (stringExtra != null && stringExtra.length() != 0) {
            LockScreenProvider lockScreenProvider = new LockScreenProvider((FragmentLockBinding) w(), new LockScreenProvider.OnCloseSelectedListener() { // from class: n0.a
                @Override // cz.mobilesoft.appblock.view.LockScreenProvider.OnCloseSelectedListener
                public final void a() {
                    LockFragment.C(this.f143428a);
                }
            });
            this.f94023b = lockScreenProvider;
            lockScreenProvider.k0(stringExtra, l3, profileType, stringExtra2, periodType);
        } else {
            CrashHelper.j(new IllegalStateException(stringExtra == null ? "Package name is null" : "Package name is empty"));
            try {
                requireActivity().finish();
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
        }
    }
}
