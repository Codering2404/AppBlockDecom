package androidx.glance.appwidget.lazy;

import androidx.glance.Emittable;
import androidx.glance.EmittableLazyItemWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.SizeModifiersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class EmittableLazyVerticalGridListItem extends EmittableLazyItemWithChildren {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GlanceModifier f38583e = SizeModifiersKt.c(SizeModifiersKt.g(GlanceModifier.f37605a));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f38584f;

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f38583e;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f38583e = glanceModifier;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableLazyVerticalGridListItem emittableLazyVerticalGridListItem = new EmittableLazyVerticalGridListItem();
        emittableLazyVerticalGridListItem.f38584f = this.f38584f;
        emittableLazyVerticalGridListItem.i(h());
        List listD = emittableLazyVerticalGridListItem.d();
        List listD2 = d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD2, 10));
        Iterator it = listD2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        listD.addAll(arrayList);
        return emittableLazyVerticalGridListItem;
    }

    public final long j() {
        return this.f38584f;
    }

    public final void k(long j3) {
        this.f38584f = j3;
    }

    public String toString() {
        return "EmittableLazyVerticalGridListItem(modifier=" + a() + ", alignment=" + h() + ", children=[\n" + c() + "\n])";
    }
}
