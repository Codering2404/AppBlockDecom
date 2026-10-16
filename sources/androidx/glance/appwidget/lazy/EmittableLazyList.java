package androidx.glance.appwidget.lazy;

import android.os.Bundle;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
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
public abstract class EmittableLazyList extends EmittableWithChildren {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlanceModifier f38574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bundle f38576f;

    public EmittableLazyList() {
        super(0, true, 1 == true ? 1 : 0, null);
        this.f38574d = GlanceModifier.f37605a;
        this.f38575e = Alignment.f39415c.f();
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f38574d;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f38574d = glanceModifier;
    }

    public final Bundle h() {
        return this.f38576f;
    }

    public final int i() {
        return this.f38575e;
    }

    public final void j(Bundle bundle) {
        this.f38576f = bundle;
    }

    public final void k(int i3) {
        this.f38575e = i3;
    }

    public String toString() {
        return "EmittableLazyList(modifier=" + a() + ", horizontalAlignment=" + ((Object) Alignment.Horizontal.i(this.f38575e)) + ", activityOptions=" + this.f38576f + ", children=[\n" + c() + "\n])";
    }
}
