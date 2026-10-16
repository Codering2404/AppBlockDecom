package cz.mobilesoft.coreblock.scene.permission.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import cz.mobilesoft.coreblock.base.adapter.BindingListAdapter;
import cz.mobilesoft.coreblock.databinding.ItemListPermissionCardViewBinding;
import cz.mobilesoft.coreblock.scene.permission.adapter.PermissionStackAdapter;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class PermissionStackAdapter extends BindingListAdapter<PermissionDTO, ItemListPermissionCardViewBinding> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f111807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Function1 f111808m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionStackAdapter(int i3, Function1 onPermissionClicked) {
        super(new Function2() { // from class: g1.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PermissionStackAdapter.p((PermissionDTO) obj, (PermissionDTO) obj2));
            }
        }, new Function2() { // from class: g1.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PermissionStackAdapter.q((PermissionDTO) obj, (PermissionDTO) obj2));
            }
        });
        Intrinsics.checkNotNullParameter(onPermissionClicked, "onPermissionClicked");
        this.f111807l = i3;
        this.f111808m = onPermissionClicked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(PermissionDTO old, PermissionDTO permissionDTO) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(permissionDTO, "new");
        return old.e().getClass() == permissionDTO.e().getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(PermissionDTO old, PermissionDTO permissionDTO) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(permissionDTO, "new");
        return Intrinsics.areEqual(old, permissionDTO);
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void j(ItemListPermissionCardViewBinding binding, PermissionDTO item, int i3) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        binding.f96736b.t(item, this.f111807l, this.f111808m);
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ItemListPermissionCardViewBinding k(LayoutInflater inflater, ViewGroup parent, boolean z2) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemListPermissionCardViewBinding itemListPermissionCardViewBindingC = ItemListPermissionCardViewBinding.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemListPermissionCardViewBindingC, "inflate(...)");
        return itemListPermissionCardViewBindingC;
    }
}
