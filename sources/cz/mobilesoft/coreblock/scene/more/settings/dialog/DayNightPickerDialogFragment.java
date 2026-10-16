package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class DayNightPickerDialogFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f109564b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f109565c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f109566a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DayNightPickerDialogFragment a() {
            return new DayNightPickerDialogFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(List list, DayNightPickerDialogFragment dayNightPickerDialogFragment, DialogInterface dialogInterface, int i3) {
        int iIntValue = ((Number) list.get(i3)).intValue();
        if (iIntValue == R.string.Yj) {
            AnswersHelper.f128199a.x6();
            dayNightPickerDialogFragment.f109566a = 2;
        } else if (iIntValue == R.string.ak) {
            AnswersHelper.f128199a.y6();
            dayNightPickerDialogFragment.f109566a = 1;
        } else if (iIntValue == R.string.Zj) {
            AnswersHelper.f128199a.A6();
            dayNightPickerDialogFragment.f109566a = -1;
        }
        AppCompatDelegate.T(dayNightPickerDialogFragment.f109566a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(DayNightPickerDialogFragment dayNightPickerDialogFragment, DialogInterface dialogInterface, int i3) {
        AnswersHelper.f128199a.z6();
        PrefManager.f126839a.a2(dayNightPickerDialogFragment.f109566a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(DayNightPickerDialogFragment dayNightPickerDialogFragment, DialogInterface dialogInterface, int i3) {
        dayNightPickerDialogFragment.dismiss();
        AppCompatDelegate.T(PrefManager.f126839a.w0());
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity(), R.style.f95874i);
        int i3 = R.string.ak;
        Integer numValueOf = Integer.valueOf(i3);
        int i4 = R.string.Yj;
        Integer numValueOf2 = Integer.valueOf(i4);
        int i5 = R.string.Zj;
        final List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{numValueOf, numValueOf2, Integer.valueOf(i5)});
        int iS = AppCompatDelegate.s();
        this.f109566a = iS;
        if (iS == -1) {
            i3 = i5;
        } else if (iS == 2) {
            i3 = i4;
        }
        int iIndexOf = listListOf.indexOf(Integer.valueOf(i3));
        List list = listListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getString(((Number) it.next()).intValue()));
        }
        DialogHelperExtKt.O(materialAlertDialogBuilder, (String[]) arrayList.toArray(new String[0]), iIndexOf, null, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                DayNightPickerDialogFragment.B(listListOf, this, dialogInterface, i6);
            }
        }, 4, null);
        materialAlertDialogBuilder.P(R.string.Fo).L(R.string.Lt, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                DayNightPickerDialogFragment.C(this.f109608a, dialogInterface, i6);
            }
        }).G(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                DayNightPickerDialogFragment.D(this.f109609a, dialogInterface, i6);
            }
        });
        AlertDialog alertDialogA = materialAlertDialogBuilder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        return alertDialogA;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AnswersHelper.f128199a.w6();
    }
}
