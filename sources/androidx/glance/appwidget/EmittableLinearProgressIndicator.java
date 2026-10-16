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
public final class EmittableLinearProgressIndicator implements Emittable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlanceModifier f37895a = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f37896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorProvider f37898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorProvider f37899e;

    public EmittableLinearProgressIndicator() {
        ProgressIndicatorDefaults progressIndicatorDefaults = ProgressIndicatorDefaults.f38195a;
        this.f37898d = progressIndicatorDefaults.b();
        this.f37899e = progressIndicatorDefaults.a();
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37895a;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37895a = glanceModifier;
    }

    public final ColorProvider c() {
        return this.f37899e;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableLinearProgressIndicator emittableLinearProgressIndicator = new EmittableLinearProgressIndicator();
        emittableLinearProgressIndicator.b(a());
        emittableLinearProgressIndicator.f37896b = this.f37896b;
        emittableLinearProgressIndicator.f37897c = this.f37897c;
        emittableLinearProgressIndicator.f37898d = this.f37898d;
        emittableLinearProgressIndicator.f37899e = this.f37899e;
        return emittableLinearProgressIndicator;
    }

    public final ColorProvider d() {
        return this.f37898d;
    }

    public final boolean e() {
        return this.f37897c;
    }

    public final float f() {
        return this.f37896b;
    }

    public final void g(ColorProvider colorProvider) {
        this.f37899e = colorProvider;
    }

    public final void h(ColorProvider colorProvider) {
        this.f37898d = colorProvider;
    }

    public final void i(boolean z2) {
        this.f37897c = z2;
    }

    public final void j(float f3) {
        this.f37896b = f3;
    }

    public String toString() {
        return "EmittableLinearProgressIndicator(modifier=" + a() + ", progress=" + this.f37896b + ", indeterminate=" + this.f37897c + ", color=" + this.f37898d + ", backgroundColor=" + this.f37899e + ')';
    }
}
