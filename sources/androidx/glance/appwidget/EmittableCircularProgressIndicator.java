package androidx.glance.appwidget;

import androidx.glance.Emittable;
import androidx.glance.GlanceModifier;
import androidx.glance.unit.ColorProvider;
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
public final class EmittableCircularProgressIndicator implements Emittable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlanceModifier f37892a = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorProvider f37893b = ProgressIndicatorDefaults.f38195a.b();

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37892a;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37892a = glanceModifier;
    }

    public final ColorProvider c() {
        return this.f37893b;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableCircularProgressIndicator emittableCircularProgressIndicator = new EmittableCircularProgressIndicator();
        emittableCircularProgressIndicator.b(a());
        emittableCircularProgressIndicator.f37893b = this.f37893b;
        return emittableCircularProgressIndicator;
    }

    public final void d(ColorProvider colorProvider) {
        this.f37893b = colorProvider;
    }

    public String toString() {
        return "EmittableCircularProgressIndicator(modifier=" + a() + ", color=" + this.f37893b + ')';
    }
}
