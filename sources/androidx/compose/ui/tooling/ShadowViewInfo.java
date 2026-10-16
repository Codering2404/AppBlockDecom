package androidx.compose.ui.tooling;

import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ShadowViewInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ShadowViewInfo f29764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewInfo f29765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f29766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Sequence f29767d;

    public ShadowViewInfo(ShadowViewInfo shadowViewInfo, ViewInfo viewInfo) {
        this.f29764a = shadowViewInfo;
        this.f29765b = viewInfo;
        List listC = viewInfo.c();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(new ShadowViewInfo(this, (ViewInfo) it.next()));
        }
        this.f29766c = CollectionsKt.toMutableList((Collection) arrayList);
        this.f29767d = SequencesKt.b(new ShadowViewInfo$allNodes$1(this, null));
    }

    public final ShadowViewInfo a() {
        ShadowViewInfo shadowViewInfo = this.f29764a;
        if (shadowViewInfo == null) {
            return this;
        }
        Intrinsics.checkNotNull(shadowViewInfo);
        return shadowViewInfo.a();
    }

    public final Sequence b() {
        return this.f29767d;
    }

    public final List c() {
        return this.f29766c;
    }

    public final LayoutInfo d() {
        Object objE = this.f29765b.e();
        if (objE instanceof LayoutInfo) {
            return (LayoutInfo) objE;
        }
        return null;
    }

    public final void e(ShadowViewInfo shadowViewInfo) {
        List list;
        ShadowViewInfo shadowViewInfo2 = this.f29764a;
        if (shadowViewInfo2 != null && (list = shadowViewInfo2.f29766c) != null) {
            list.remove(this);
        }
        shadowViewInfo.f29766c.add(this);
        this.f29764a = shadowViewInfo;
    }

    public final ViewInfo f() {
        String strD = this.f29765b.d();
        int iF = this.f29765b.f();
        IntRect intRectB = this.f29765b.b();
        SourceLocation sourceLocationG = this.f29765b.g();
        List list = this.f29766c;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ShadowViewInfo) it.next()).f());
        }
        return new ViewInfo(strD, iF, intRectB, sourceLocationG, arrayList, this.f29765b.e());
    }

    public ShadowViewInfo(ViewInfo viewInfo) {
        this(null, viewInfo);
    }
}
