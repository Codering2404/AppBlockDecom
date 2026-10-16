package cz.mobilesoft.coreblock.scene.more;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.DialogLicensesBinding;
import cz.mobilesoft.coreblock.databinding.DialogLicensesRowBinding;
import cz.mobilesoft.coreblock.util.JSONHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class LicensesDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogLicensesBinding f106045a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Adapter extends RecyclerView.Adapter<ViewHolder> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final List f106046i;

        public Adapter(List list) {
            this.f106046i = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder viewHolder, int i3) {
            Library library;
            String strJoin;
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            List list = this.f106046i;
            if (list == null || (library = (Library) CollectionsKt.getOrNull(list, i3)) == null) {
                return;
            }
            DialogLicensesRowBinding dialogLicensesRowBindingB = viewHolder.b();
            dialogLicensesRowBindingB.f96523d.setText(TextUtils.join(", ", CollectionsKt.listOfNotNull((Object[]) new String[]{library.d(), library.f(), library.g()})));
            dialogLicensesRowBindingB.f96521b.setText(TextUtils.join("\n", CollectionsKt.listOfNotNull((Object[]) new String[]{library.a(), library.b(), library.e()})));
            TextView licenseTextView = dialogLicensesRowBindingB.f96522c;
            Intrinsics.checkNotNullExpressionValue(licenseTextView, "licenseTextView");
            licenseTextView.setVisibility(library.c() != null ? 0 : 8);
            TextView textView = dialogLicensesRowBindingB.f96522c;
            List listC = library.c();
            if (listC == null || (strJoin = TextUtils.join("\n", listC)) == null) {
                strJoin = "";
            }
            textView.setText(strJoin);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = this.f106046i;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            DialogLicensesRowBinding dialogLicensesRowBindingC = DialogLicensesRowBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(dialogLicensesRowBindingC, "inflate(...)");
            return new ViewHolder(dialogLicensesRowBindingC);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Library {

        @SerializedName("dependency")
        private String dependency;

        @SerializedName("description")
        private String description;

        @SerializedName("developers")
        private List<String> developers;

        @SerializedName("licenses")
        private List<License> licenses;

        @SerializedName("project")
        private String project;

        @SerializedName("url")
        private String url;

        @SerializedName("version")
        private String version;

        @SerializedName("year")
        private String year;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public final class License {

            @SerializedName("license")
            private String license;

            @SerializedName("license_url")
            private String licenseUrl;

            public String toString() {
                String strJoin = TextUtils.join("\n", CollectionsKt.arrayListOf(this.license, this.licenseUrl));
                Intrinsics.checkNotNullExpressionValue(strJoin, cJfnYMIyomoWf.bQzWQKkbYJ);
                return strJoin;
            }
        }

        public final String a() {
            return this.dependency;
        }

        public final String b() {
            return this.description;
        }

        public final List c() {
            return this.licenses;
        }

        public final String d() {
            return this.project;
        }

        public final String e() {
            return this.url;
        }

        public boolean equals(Object obj) {
            String str;
            if (this == obj) {
                return true;
            }
            if (obj != null && Intrinsics.areEqual(Library.class, obj.getClass())) {
                Library library = (Library) obj;
                String str2 = this.project;
                if (str2 != null && (str = library.project) != null && StringsKt.F(str2, str, true)) {
                    return true;
                }
            }
            return false;
        }

        public final String f() {
            return this.version;
        }

        public final String g() {
            return this.year;
        }

        public final void h(Library other) {
            Intrinsics.checkNotNullParameter(other, "other");
            String str = other.project;
            if (str != null) {
                this.project = str;
            }
            String str2 = other.version;
            if (str2 != null) {
                this.version = str2;
            }
            String str3 = other.description;
            if (str3 != null) {
                this.description = str3;
            }
            String str4 = other.url;
            if (str4 != null) {
                this.url = str4;
            }
            String str5 = other.year;
            if (str5 != null) {
                this.year = str5;
            }
            String str6 = other.dependency;
            if (str6 != null) {
                this.dependency = str6;
            }
            List<String> list = other.developers;
            if (list != null) {
                this.developers = list;
            }
            List<License> list2 = other.licenses;
            if (list2 != null) {
                this.licenses = list2;
            }
        }

        public int hashCode() {
            String str = this.project;
            if (str == null) {
                return Objects.hash(this.version, this.description, this.url, this.year, this.dependency, this.developers, this.licenses);
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return Objects.hash(lowerCase);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DialogLicensesRowBinding f106047b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DialogLicensesRowBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f106047b = binding;
        }

        public final DialogLicensesRowBinding b() {
            return this.f106047b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(LicensesDialog licensesDialog, DialogInterface dialogInterface) {
        RecyclerView root = licensesDialog.z().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        licensesDialog.C(root);
    }

    private final void C(RecyclerView recyclerView) {
        List listDistinct;
        List mutableList;
        JSONHelper jSONHelper = JSONHelper.f127888a;
        ArrayList arrayList = (ArrayList) jSONHelper.e().k(jSONHelper.g("open_source_licenses.json"), new TypeToken<ArrayList<Library>>() { // from class: cz.mobilesoft.coreblock.scene.more.LicensesDialog$setupRecycler$1
        }.d());
        if (arrayList == null || (listDistinct = CollectionsKt.distinct(arrayList)) == null || (mutableList = CollectionsKt.toMutableList((Collection) listDistinct)) == null) {
            return;
        }
        List<Library> list = (List) jSONHelper.e().k(jSONHelper.g("open_source_licenses_unrecognized.json"), new TypeToken<ArrayList<Library>>() { // from class: cz.mobilesoft.coreblock.scene.more.LicensesDialog$setupRecycler$2$1
        }.d());
        if (list != null) {
            for (Library library : list) {
                int iIndexOf = mutableList.indexOf(library);
                if (iIndexOf != -1) {
                    ((Library) mutableList.get(iIndexOf)).h(library);
                } else {
                    mutableList.add(library);
                }
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(mutableList));
    }

    public final void B(DialogLicensesBinding dialogLicensesBinding) {
        Intrinsics.checkNotNullParameter(dialogLicensesBinding, "<set-?>");
        this.f106045a = dialogLicensesBinding;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        DialogLicensesBinding dialogLicensesBindingC = DialogLicensesBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogLicensesBindingC, "inflate(...)");
        B(dialogLicensesBindingC);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
        materialAlertDialogBuilder.u(z().getRoot()).P(R.string.LF).L(R.string.N7, null);
        AlertDialog alertDialogA = materialAlertDialogBuilder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        alertDialogA.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.scene.more.d
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                LicensesDialog.A(this.f107413a, dialogInterface);
            }
        });
        return alertDialogA;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(getResources().getConfiguration().orientation == 2 ? -2 : -1, -2);
    }

    public final DialogLicensesBinding z() {
        DialogLicensesBinding dialogLicensesBinding = this.f106045a;
        if (dialogLicensesBinding != null) {
            return dialogLicensesBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }
}
