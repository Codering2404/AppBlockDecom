package androidx.glance.appwidget.lazy;

import android.os.Bundle;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.lazy.GridCells;
import androidx.glance.layout.Alignment;
import kotlin.Metadata;

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
public abstract class EmittableLazyVerticalGridList extends EmittableWithChildren {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlanceModifier f38579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GridCells f38581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bundle f38582g;

    public EmittableLazyVerticalGridList() {
        super(0, true, 1, null);
        this.f38579d = GlanceModifier.f37605a;
        this.f38580e = Alignment.f39415c.f();
        this.f38581f = new GridCells.Fixed(1);
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f38579d;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f38579d = glanceModifier;
    }

    public final Bundle h() {
        return this.f38582g;
    }

    public final GridCells i() {
        return this.f38581f;
    }

    public final int j() {
        return this.f38580e;
    }

    public final void k(Bundle bundle) {
        this.f38582g = bundle;
    }

    public final void l(GridCells gridCells) {
        this.f38581f = gridCells;
    }

    public final void m(int i3) {
        this.f38580e = i3;
    }

    public String toString() {
        return "EmittableLazyVerticalGridList(modifier=" + a() + ", horizontalAlignment=" + ((Object) Alignment.Horizontal.i(this.f38580e)) + ", numColumn=" + this.f38581f + ", activityOptions=" + this.f38582g + ", children=[\n" + c() + "\n])";
    }
}
