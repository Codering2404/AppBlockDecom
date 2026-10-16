package androidx.glance;

import androidx.glance.text.TextStyle;
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
public final class EmittableButton implements Emittable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextStyle f37593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ButtonColors f37594d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlanceModifier f37591a = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37592b = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37595e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37596f = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37591a;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37591a = glanceModifier;
    }

    public final boolean c() {
        return this.f37595e;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableButton emittableButton = new EmittableButton();
        emittableButton.b(a());
        emittableButton.f37592b = this.f37592b;
        emittableButton.f37593c = this.f37593c;
        emittableButton.f37594d = this.f37594d;
        emittableButton.f37595e = this.f37595e;
        emittableButton.f37596f = this.f37596f;
        return emittableButton;
    }

    public final int d() {
        return this.f37596f;
    }

    public final TextStyle e() {
        return this.f37593c;
    }

    public final String f() {
        return this.f37592b;
    }

    public final void g(ButtonColors buttonColors) {
        this.f37594d = buttonColors;
    }

    public final void h(boolean z2) {
        this.f37595e = z2;
    }

    public final void i(int i3) {
        this.f37596f = i3;
    }

    public final void j(TextStyle textStyle) {
        this.f37593c = textStyle;
    }

    public final void k(String str) {
        this.f37592b = str;
    }

    public String toString() {
        return "EmittableButton('" + this.f37592b + "', enabled=" + this.f37595e + ", style=" + this.f37593c + ", colors=" + this.f37594d + " modifier=" + a() + ", maxLines=" + this.f37596f + ')';
    }
}
