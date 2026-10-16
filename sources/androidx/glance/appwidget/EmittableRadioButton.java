package androidx.glance.appwidget;

import androidx.glance.Emittable;
import androidx.glance.GlanceModifier;
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
public final class EmittableRadioButton implements Emittable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RadioButtonColors f37900a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37902c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextStyle f37905f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GlanceModifier f37901b = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37903d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37904e = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37906g = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public EmittableRadioButton(RadioButtonColors radioButtonColors) {
        this.f37900a = radioButtonColors;
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37901b;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37901b = glanceModifier;
    }

    public final boolean c() {
        return this.f37902c;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableRadioButton emittableRadioButton = new EmittableRadioButton(this.f37900a);
        emittableRadioButton.b(a());
        emittableRadioButton.f37902c = this.f37902c;
        emittableRadioButton.f37903d = this.f37903d;
        emittableRadioButton.f37904e = this.f37904e;
        emittableRadioButton.f37905f = this.f37905f;
        emittableRadioButton.f37906g = this.f37906g;
        return emittableRadioButton;
    }

    public final RadioButtonColors d() {
        return this.f37900a;
    }

    public final boolean e() {
        return this.f37903d;
    }

    public final int f() {
        return this.f37906g;
    }

    public final TextStyle g() {
        return this.f37905f;
    }

    public final String h() {
        return this.f37904e;
    }

    public final void i(boolean z2) {
        this.f37902c = z2;
    }

    public final void j(RadioButtonColors radioButtonColors) {
        this.f37900a = radioButtonColors;
    }

    public final void k(boolean z2) {
        this.f37903d = z2;
    }

    public final void l(int i3) {
        this.f37906g = i3;
    }

    public final void m(TextStyle textStyle) {
        this.f37905f = textStyle;
    }

    public final void n(String str) {
        this.f37904e = str;
    }

    public String toString() {
        return "EmittableRadioButton(" + this.f37904e + ", modifier=" + a() + ", checked=" + this.f37902c + ", enabled=" + this.f37903d + ", text=" + this.f37904e + ", style=" + this.f37905f + ", colors=" + this.f37900a + ", maxLines=" + this.f37906g + ", )";
    }
}
