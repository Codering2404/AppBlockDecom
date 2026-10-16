package androidx.glance.appwidget;

import androidx.compose.ui.unit.DpSize;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.SizeMode;
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
public final class EmittableSizeBox extends EmittableWithChildren {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f37907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SizeMode f37908e;

    public EmittableSizeBox() {
        super(0, false, 3, null);
        this.f37907d = DpSize.f29984b.a();
        this.f37908e = SizeMode.Single.f38453a;
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        GlanceModifier glanceModifierA;
        Emittable emittable = (Emittable) CollectionsKt.singleOrNull(d());
        return (emittable == null || (glanceModifierA = emittable.a()) == null) ? SizeModifiersKt.b(GlanceModifier.f37605a) : glanceModifierA;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        throw new IllegalAccessError("You cannot set the modifier of an EmittableSizeBox");
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableSizeBox emittableSizeBox = new EmittableSizeBox();
        emittableSizeBox.f37907d = this.f37907d;
        emittableSizeBox.f37908e = this.f37908e;
        List listD = emittableSizeBox.d();
        List listD2 = d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD2, 10));
        Iterator it = listD2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        listD.addAll(arrayList);
        return emittableSizeBox;
    }

    public final long h() {
        return this.f37907d;
    }

    public final SizeMode i() {
        return this.f37908e;
    }

    public final void j(long j3) {
        this.f37907d = j3;
    }

    public final void k(SizeMode sizeMode) {
        this.f37908e = sizeMode;
    }

    public String toString() {
        return "EmittableSizeBox(size=" + ((Object) DpSize.l(this.f37907d)) + ", sizeMode=" + this.f37908e + ", children=[\n" + c() + "\n])";
    }
}
