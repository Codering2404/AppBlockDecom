package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class SizeParameterProvider implements PreviewParameterProvider<Size> {
    private final List<SizeConstraint> allSizeConstraints;
    private final Sequence<Size> values;

    public SizeParameterProvider() {
        int i3 = 0;
        List<SizeConstraint> listListOf = CollectionsKt.listOf((Object[]) new SizeConstraint[]{SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(200, null)});
        this.allSizeConstraints = listListOf;
        ArrayList arrayList = new ArrayList();
        for (SizeConstraint sizeConstraint : listListOf) {
            List<SizeConstraint> list = this.allSizeConstraints;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(TuplesKt.a(sizeConstraint, (SizeConstraint) it.next()));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Pair pair = (Pair) obj;
            arrayList3.add(new Size((SizeConstraint) pair.a(), (SizeConstraint) pair.b()));
        }
        this.values = CollectionsKt.asSequence(arrayList3);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<Size> getValues() {
        return this.values;
    }
}
