package androidx.glance.appwidget;

import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
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
public final class RemoteViewsRoot extends EmittableWithChildren {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GlanceModifier f38426e;

    public RemoteViewsRoot(int i3) {
        super(i3, false, 2, null);
        this.f38425d = i3;
        this.f38426e = GlanceModifier.f37605a;
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f38426e;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f38426e = glanceModifier;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        RemoteViewsRoot remoteViewsRoot = new RemoteViewsRoot(this.f38425d);
        remoteViewsRoot.b(a());
        List listD = remoteViewsRoot.d();
        List listD2 = d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD2, 10));
        Iterator it = listD2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        listD.addAll(arrayList);
        return remoteViewsRoot;
    }

    public String toString() {
        return "RemoteViewsRoot(modifier=" + a() + ", children=[\n" + c() + "\n])";
    }
}
