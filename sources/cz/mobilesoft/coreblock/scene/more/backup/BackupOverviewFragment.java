package cz.mobilesoft.coreblock.scene.more.backup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentBackupOverviewBinding;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupInfoDTO;
import cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.text.DateFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public final class BackupOverviewFragment extends BaseBackupCreateFragment<FragmentBackupOverviewBinding> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f106416h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f106417i = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106418g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BackupOverviewFragment.f0();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupOverviewFragment a() {
            return new BackupOverviewFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        AnswersHelper.f128199a.Q0();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String string = getString(R.string.xF);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DialogHelperExtKt.K(activity, string, getString(R.string.Gs, getString(R.string.f95790f1)), true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateFormat f0() {
        return DateFormat.getDateTimeInstance(3, 3);
    }

    private final void g0() {
        AnswersHelper.f128199a.y0();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DialogHelperExtKt.A(activity, R.string.t9, Integer.valueOf(R.string.s9), R.string.q9, 0, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackupOverviewFragment.h0(this.f106444a);
                }
            }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackupOverviewFragment.i0();
                }
            }, false, 72, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(BackupOverviewFragment backupOverviewFragment) {
        AnswersHelper.f128199a.A0();
        BackupProgressActivity.Companion companion = BackupProgressActivity.f106450v;
        FragmentActivity fragmentActivityRequireActivity = backupOverviewFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ContextExtKt.g(backupOverviewFragment.L(), companion.a(fragmentActivityRequireActivity));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0() {
        AnswersHelper.f128199a.z0();
        return Unit.f139807a;
    }

    private final DateFormat j0() {
        return (DateFormat) this.f106418g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(FragmentBackupOverviewBinding fragmentBackupOverviewBinding, BackupOverviewFragment backupOverviewFragment, BackupInfoDTO backupInfoDTO) {
        StringBuilder sb;
        if (backupInfoDTO != null) {
            TextView textView = fragmentBackupOverviewBinding.f96616f;
            String strB = backupInfoDTO.b();
            if (strB != null) {
                sb = new StringBuilder(strB);
                sb.append("\n");
            } else {
                sb = new StringBuilder();
            }
            sb.append(backupOverviewFragment.j0().format(backupInfoDTO.a()));
            textView.setText(sb);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(BackupOverviewFragment backupOverviewFragment, View view) {
        backupOverviewFragment.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(final BackupOverviewFragment backupOverviewFragment, View view) {
        backupOverviewFragment.M().J0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.backup.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupOverviewFragment.p0(this.f106562a, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(BackupOverviewFragment backupOverviewFragment, boolean z2) {
        if (z2) {
            ViewHelperExtKt.u(backupOverviewFragment, StrictModeTitleAlternatives.Companion.a());
        } else {
            backupOverviewFragment.s0();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(BackupOverviewFragment backupOverviewFragment, View view) {
        backupOverviewFragment.g0();
    }

    private final void s0() {
        BackupInfoDTO backupInfoDTO = (BackupInfoDTO) M().L0().getValue();
        if (backupInfoDTO != null) {
            AnswersHelper.f128199a.L0();
            BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), null, null, new BackupOverviewFragment$restoreBackup$1$1(backupInfoDTO, this, null), 3, null);
        }
    }

    private final void u0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog alertDialogA = new MaterialAlertDialogBuilder(activity, R.style.f95867b).t(getString(R.string.Y8)).h(getString(R.string.X8)).L(R.string.f95831p0, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    BackupOverviewFragment.v0(this.f106563a, dialogInterface, i3);
                }
            }).G(R.string.O4, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.s
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    BackupOverviewFragment.w0(dialogInterface, i3);
                }
            }).d(true).a();
            alertDialogA.setCanceledOnTouchOutside(false);
            alertDialogA.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(BackupOverviewFragment backupOverviewFragment, DialogInterface dialogInterface, int i3) {
        backupOverviewFragment.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(final BackupInfoDTO backupInfoDTO) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DialogHelperExtKt.A(activity, R.string.Ds, Integer.valueOf(R.string.Cs), R.string.Bs, 0, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackupOverviewFragment.y0(this.f106442a, backupInfoDTO);
                }
            }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackupOverviewFragment.z0();
                }
            }, false, 72, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(BackupOverviewFragment backupOverviewFragment, BackupInfoDTO backupInfoDTO) {
        AnswersHelper.f128199a.N0();
        BackupProgressActivity.Companion companion = BackupProgressActivity.f106450v;
        FragmentActivity fragmentActivityRequireActivity = backupOverviewFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ContextExtKt.g(backupOverviewFragment.L(), companion.b(fragmentActivityRequireActivity, backupInfoDTO.c()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0() {
        AnswersHelper.f128199a.M0();
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentBackupOverviewBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        FlowsExtKt.c(this, M().L0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.backup.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupOverviewFragment.l0(binding, this, (BackupInfoDTO) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void y(FragmentBackupOverviewBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96612b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackupOverviewFragment.n0(this.f106447a, view2);
            }
        });
        binding.f96618h.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackupOverviewFragment.o0(this.f106448a, view2);
            }
        });
        binding.f96614d.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.backup.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackupOverviewFragment.q0(this.f106449a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public FragmentBackupOverviewBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentBackupOverviewBinding fragmentBackupOverviewBindingC = FragmentBackupOverviewBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentBackupOverviewBindingC, "inflate(...)");
        return fragmentBackupOverviewBindingC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(DialogInterface dialogInterface, int i3) {
    }
}
