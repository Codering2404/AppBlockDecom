package androidx.glance;

import androidx.glance.layout.ContentScale;
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
public final class EmittableImage implements Emittable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageProvider f37598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorFilterParams f37599c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlanceModifier f37597a = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37600d = ContentScale.f39463b.c();

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37597a;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37597a = glanceModifier;
    }

    public final ColorFilterParams c() {
        return this.f37599c;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableImage emittableImage = new EmittableImage();
        emittableImage.b(a());
        emittableImage.f37598b = this.f37598b;
        emittableImage.f37599c = this.f37599c;
        emittableImage.f37600d = this.f37600d;
        return emittableImage;
    }

    public final int d() {
        return this.f37600d;
    }

    public final ImageProvider e() {
        return this.f37598b;
    }

    public final void f(ColorFilterParams colorFilterParams) {
        this.f37599c = colorFilterParams;
    }

    public final void g(int i3) {
        this.f37600d = i3;
    }

    public final void h(ImageProvider imageProvider) {
        this.f37598b = imageProvider;
    }

    public String toString() {
        return "EmittableImage(modifier=" + a() + ", provider=" + this.f37598b + ", colorFilterParams=" + this.f37599c + ", contentScale=" + ((Object) ContentScale.i(this.f37600d)) + ')';
    }
}
