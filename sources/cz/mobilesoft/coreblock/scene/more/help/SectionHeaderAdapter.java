package cz.mobilesoft.coreblock.scene.more.help;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import cz.mobilesoft.coreblock.base.adapter.BindingListAdapter;
import cz.mobilesoft.coreblock.databinding.ItemListSectionHeaderBinding;
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
public final class SectionHeaderAdapter extends BindingListAdapter<String, ItemListSectionHeaderBinding> {
    public SectionHeaderAdapter() {
        super(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.t
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(SectionHeaderAdapter.p((String) obj, (String) obj2));
            }
        }, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.u
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(SectionHeaderAdapter.q((String) obj, (String) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(str2, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(String old, String str) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(str, "new");
        return Intrinsics.areEqual(old, str);
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void j(ItemListSectionHeaderBinding binding, String item, int i3) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        binding.f96742b.setText(item);
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ItemListSectionHeaderBinding k(LayoutInflater inflater, ViewGroup parent, boolean z2) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemListSectionHeaderBinding itemListSectionHeaderBindingC = ItemListSectionHeaderBinding.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemListSectionHeaderBindingC, "inflate(...)");
        return itemListSectionHeaderBindingC;
    }

    public final void t(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        i(CollectionsKt.listOf(title));
    }
}
