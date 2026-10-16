package cz.mobilesoft.coreblock.scene.more;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentAboutBinding;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
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
public final class AboutFragment extends BaseFragment<FragmentAboutBinding> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f106043b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f106044c = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String D() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getConfiguration().getLocales().get(0).getCountry();
    }

    private final void E(FragmentAboutBinding fragmentAboutBinding) {
        if (PrefManager.f126839a.i0().contains(D())) {
            fragmentAboutBinding.f96543g.setVisibility(0);
            fragmentAboutBinding.f96542f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(View view) {
        try {
            ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Uri uri = Uri.parse("http://www.mobilesoft.eu/en");
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            externalLinksHelper.c(context, uri);
        } catch (ActivityNotFoundException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AboutFragment aboutFragment, View view) {
        try {
            aboutFragment.startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "info@mobilesoft.eu", null)), aboutFragment.getString(R.string.k8)));
        } catch (ActivityNotFoundException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AboutFragment aboutFragment, View view) {
        try {
            Context contextRequireContext = aboutFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            RunnabilityHelper.V(contextRequireContext, 0, null, false, null, false, "about", 62, null);
        } catch (ActivityNotFoundException e3) {
            e3.printStackTrace();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void y(FragmentAboutBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        setHasOptionsMenu(true);
        Button button = binding.f96538b;
        button.setPaintFlags(button.getPaintFlags() | 8);
        binding.f96538b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.G(view2);
            }
        });
        E(binding);
        binding.f96542f.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.H(this.f106352a, view2);
            }
        });
        binding.f96539c.setText(PrefManager.f126839a.k1());
        Button button2 = binding.f96539c;
        button2.setPaintFlags(button2.getPaintFlags() | 8);
        binding.f96539c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.I(this.f106917a, view2);
            }
        });
        try {
            PackageInfo packageInfo = requireActivity().getPackageManager().getPackageInfo(requireActivity().getPackageName(), 0);
            binding.f96547k.setText("v " + packageInfo.versionName);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public FragmentAboutBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAboutBinding fragmentAboutBindingC = FragmentAboutBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentAboutBindingC, "inflate(...)");
        return fragmentAboutBindingC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.f95733a, menu);
    }
}
