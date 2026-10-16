package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.os.BundleKt;
import androidx.core.os.LocaleListCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class LanguagePickerDialogFragment extends AppCompatDialogFragment implements KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f109591b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f109592c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f109593a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LanguagePickerDialogFragment a(String str) {
            LanguagePickerDialogFragment languagePickerDialogFragment = new LanguagePickerDialogFragment();
            languagePickerDialogFragment.setArguments(BundleKt.b(TuplesKt.a("LANGUAGE_TAG", str)));
            return languagePickerDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LanguagePickerDialogFragment() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109593a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.LanguagePickerDialogFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore C() {
        return (CoreMultiProcessDataStore) this.f109593a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Ref.ObjectRef objectRef, List list, DialogInterface dialogInterface, int i3) {
        objectRef.f140144a = list.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Ref.ObjectRef objectRef, LanguagePickerDialogFragment languagePickerDialogFragment, DialogInterface dialogInterface, int i3) {
        LocaleListCompat localeListCompatF;
        Locale locale = (Locale) objectRef.f140144a;
        if (locale == null || (localeListCompatF = LocaleListCompat.c(locale.toLanguageTag())) == null) {
            localeListCompatF = LocaleListCompat.f();
            Intrinsics.checkNotNullExpressionValue(localeListCompatF, "getEmptyLocaleList(...)");
        }
        CoroutinesHelperExtKt.d(new LanguagePickerDialogFragment$onCreateDialog$3$1(languagePickerDialogFragment, objectRef, null));
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        Locale locale2 = (Locale) objectRef.f140144a;
        answersHelper.N5(locale2 != null ? locale2.toLanguageTag() : null);
        AppCompatDelegate.O(localeListCompatF);
        languagePickerDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(DialogInterface dialogInterface, int i3) {
        dialogInterface.cancel();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        AnswersHelper.f128199a.M5();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{null, "en", "ar", "cs", "de", "es", "fr", "id", "it", "ja", "ko", "nl", "pt", "ru", "sk", "tr", "pl"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(LanguagePickerDialogFragmentKt.d((String) it.next()));
        }
        final List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.LanguagePickerDialogFragment$onCreateDialog$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                String lowerCase;
                String strU;
                String strU2;
                String strB = LanguagePickerDialogFragmentKt.b((Locale) obj);
                String lowerCase2 = null;
                if (strB == null || (strU2 = StringHelperExtKt.u(strB)) == null) {
                    lowerCase = null;
                } else {
                    lowerCase = strU2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                }
                String strB2 = LanguagePickerDialogFragmentKt.b((Locale) obj2);
                if (strB2 != null && (strU = StringHelperExtKt.u(strB2)) != null) {
                    lowerCase2 = strU.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                }
                return ComparisonsKt.d(lowerCase, lowerCase2);
            }
        });
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("LANGUAGE_TAG")) == null) {
            string = null;
        } else if (Intrinsics.areEqual(string, "in")) {
            string = "id";
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = string != null ? Locale.forLanguageTag(string) : null;
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity(), R.style.f95874i);
        List list = listSortedWith;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String strB = LanguagePickerDialogFragmentKt.b((Locale) it2.next());
            if (strB == null) {
                strB = getString(R.string.Zj);
                Intrinsics.checkNotNullExpressionValue(strB, "getString(...)");
            }
            arrayList2.add(strB);
        }
        DialogHelperExtKt.O(materialAlertDialogBuilder, (String[]) arrayList2.toArray(new String[0]), listSortedWith.indexOf(objectRef.f140144a), null, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LanguagePickerDialogFragment.D(objectRef, listSortedWith, dialogInterface, i3);
            }
        }, 4, null);
        materialAlertDialogBuilder.P(R.string.wi).L(R.string.Lt, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.b0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LanguagePickerDialogFragment.E(objectRef, this, dialogInterface, i3);
            }
        }).G(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LanguagePickerDialogFragment.F(dialogInterface, i3);
            }
        });
        AnswersHelper.f128199a.O5();
        AlertDialog alertDialogA = materialAlertDialogBuilder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        return alertDialogA;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
