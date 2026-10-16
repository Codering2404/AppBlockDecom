package cz.mobilesoft.coreblock.scene.more.help;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cz.mobilesoft.coreblock.base.adapter.BindingListAdapter;
import cz.mobilesoft.coreblock.databinding.LayoutPermissionsHelpHeaderBinding;
import cz.mobilesoft.coreblock.util.permissions.PermissionHeader;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
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
public final class PermissionHelpHeaderAdapter extends BindingListAdapter<PermissionHeader, LayoutPermissionsHelpHeaderBinding> {
    public PermissionHelpHeaderAdapter() {
        super(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.r
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PermissionHelpHeaderAdapter.p((PermissionHeader) obj, (PermissionHeader) obj2));
            }
        }, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.s
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PermissionHelpHeaderAdapter.q((PermissionHeader) obj, (PermissionHeader) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(PermissionHeader permissionHeader, PermissionHeader permissionHeader2) {
        Intrinsics.checkNotNullParameter(permissionHeader, "<unused var>");
        Intrinsics.checkNotNullParameter(permissionHeader2, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(PermissionHeader old, PermissionHeader permissionHeader) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(permissionHeader, "new");
        return Intrinsics.areEqual(old, permissionHeader);
    }

    public static /* synthetic */ void v(PermissionHelpHeaderAdapter permissionHelpHeaderAdapter, String str, String str2, int i3, Object obj) {
        PermissionHeader permissionHeader;
        PermissionHeader permissionHeader2;
        if ((i3 & 1) != 0 && ((permissionHeader2 = (PermissionHeader) permissionHelpHeaderAdapter.g(0)) == null || (str = permissionHeader2.e()) == null)) {
            str = "";
        }
        if ((i3 & 2) != 0 && ((permissionHeader = (PermissionHeader) permissionHelpHeaderAdapter.g(0)) == null || (str2 = permissionHeader.c()) == null)) {
            str2 = "";
        }
        permissionHelpHeaderAdapter.u(str, str2);
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void j(LayoutPermissionsHelpHeaderBinding binding, PermissionHeader item, int i3) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        binding.f96803e.setText(item.e());
        binding.f96801c.setText(item.c());
        LinearLayout textsContainer = binding.f96802d;
        Intrinsics.checkNotNullExpressionValue(textsContainer, "textsContainer");
        textsContainer.setVisibility(item.d() ? 4 : 0);
        ImageView checkImageView = binding.f96800b;
        Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
        checkImageView.setVisibility(item.d() ? 0 : 8);
        if (item.d()) {
            ImageView checkImageView2 = binding.f96800b;
            Intrinsics.checkNotNullExpressionValue(checkImageView2, "checkImageView");
            ViewHelperExtKt.b(checkImageView2);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public LayoutPermissionsHelpHeaderBinding k(LayoutInflater inflater, ViewGroup parent, boolean z2) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutPermissionsHelpHeaderBinding layoutPermissionsHelpHeaderBindingC = LayoutPermissionsHelpHeaderBinding.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutPermissionsHelpHeaderBindingC, "inflate(...)");
        return layoutPermissionsHelpHeaderBindingC;
    }

    public final void t() {
        PermissionHeader permissionHeader = (PermissionHeader) g(0);
        i(CollectionsKt.listOf(permissionHeader != null ? PermissionHeader.b(permissionHeader, null, null, true, 3, null) : null));
    }

    public final void u(String title, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        i(CollectionsKt.listOf(new PermissionHeader(title, description, false, 4, null)));
    }
}
