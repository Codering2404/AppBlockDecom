package com.github.appintro.internal.viewpager;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        this.fragments = fragments;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i3) {
        return this.fragments.get(i3);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i3) {
        Intrinsics.checkNotNullParameter(container, "container");
        Object objInstantiateItem = super.instantiateItem(container, i3);
        Intrinsics.checkNotNullExpressionValue(objInstantiateItem, "super.instantiateItem(container, position)");
        List<Fragment> list = this.fragments;
        if (objInstantiateItem == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }
        list.set(i3, (Fragment) objInstantiateItem);
        return objInstantiateItem;
    }
}
