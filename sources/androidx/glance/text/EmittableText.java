package androidx.glance.text;

import androidx.glance.Emittable;
import androidx.glance.GlanceModifier;
import com.google.android.gms.common.api.Api;
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
public final class EmittableText implements Emittable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextStyle f39734c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlanceModifier f39732a = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f39733b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39735d = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f39732a;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f39732a = glanceModifier;
    }

    public final int c() {
        return this.f39735d;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableText emittableText = new EmittableText();
        emittableText.b(a());
        emittableText.f39733b = this.f39733b;
        emittableText.f39734c = this.f39734c;
        emittableText.f39735d = this.f39735d;
        return emittableText;
    }

    public final TextStyle d() {
        return this.f39734c;
    }

    public final String e() {
        return this.f39733b;
    }

    public final void f(int i3) {
        this.f39735d = i3;
    }

    public final void g(TextStyle textStyle) {
        this.f39734c = textStyle;
    }

    public final void h(String str) {
        this.f39733b = str;
    }

    public String toString() {
        return "EmittableText(" + this.f39733b + ", style=" + this.f39734c + ", modifier=" + a() + ", maxLines=" + this.f39735d + ')';
    }
}
