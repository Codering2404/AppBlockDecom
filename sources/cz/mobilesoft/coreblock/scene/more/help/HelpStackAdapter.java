package cz.mobilesoft.coreblock.scene.more.help;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import cz.mobilesoft.coreblock.base.adapter.BindingListAdapter;
import cz.mobilesoft.coreblock.databinding.ItemListHelpCardViewBinding;
import cz.mobilesoft.coreblock.enums.HelpItem;
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
public final class HelpStackAdapter extends BindingListAdapter<HelpItem, ItemListHelpCardViewBinding> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function1 f107742l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelpStackAdapter(Function1 onItemClicked) {
        super(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.i
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HelpStackAdapter.p((HelpItem) obj, (HelpItem) obj2));
            }
        }, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HelpStackAdapter.q((HelpItem) obj, (HelpItem) obj2));
            }
        });
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.f107742l = onItemClicked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(HelpItem old, HelpItem helpItem) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(helpItem, "new");
        return old == helpItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(HelpItem old, HelpItem helpItem) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(helpItem, "new");
        return old == helpItem;
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void j(ItemListHelpCardViewBinding binding, HelpItem item, int i3) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        binding.f96730b.t(item, this.f107742l);
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ItemListHelpCardViewBinding k(LayoutInflater inflater, ViewGroup parent, boolean z2) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemListHelpCardViewBinding itemListHelpCardViewBindingC = ItemListHelpCardViewBinding.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemListHelpCardViewBindingC, "inflate(...)");
        return itemListHelpCardViewBindingC;
    }
}
