package androidx.glance.layout;

import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
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
public final class EmittableRow extends EmittableWithChildren {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlanceModifier f39473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f39474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f39475f;

    public EmittableRow() {
        super(0, false, 3, null);
        this.f39473d = GlanceModifier.f37605a;
        Alignment.Companion companion = Alignment.f39415c;
        this.f39474e = companion.f();
        this.f39475f = companion.g();
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f39473d;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f39473d = glanceModifier;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableRow emittableRow = new EmittableRow();
        emittableRow.b(a());
        emittableRow.f39474e = this.f39474e;
        emittableRow.f39475f = this.f39475f;
        List listD = emittableRow.d();
        List listD2 = d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD2, 10));
        Iterator it = listD2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Emittable) it.next()).copy());
        }
        listD.addAll(arrayList);
        return emittableRow;
    }

    public final int h() {
        return this.f39474e;
    }

    public final int i() {
        return this.f39475f;
    }

    public final void j(int i3) {
        this.f39474e = i3;
    }

    public final void k(int i3) {
        this.f39475f = i3;
    }

    public String toString() {
        return "EmittableRow(modifier=" + a() + ", horizontalAlignment=" + ((Object) Alignment.Horizontal.i(this.f39474e)) + ", verticalAlignment=" + ((Object) Alignment.Vertical.i(this.f39475f)) + ", children=[\n" + c() + "\n])";
    }
}
