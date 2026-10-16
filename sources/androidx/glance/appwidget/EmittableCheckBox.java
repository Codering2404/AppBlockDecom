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
public final class EmittableCheckBox implements Emittable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CheckBoxColors f37886a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37888c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextStyle f37890e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GlanceModifier f37887b = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37889d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37891f = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public EmittableCheckBox(CheckBoxColors checkBoxColors) {
        this.f37886a = checkBoxColors;
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37887b;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37887b = glanceModifier;
    }

    public final boolean c() {
        return this.f37888c;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableCheckBox emittableCheckBox = new EmittableCheckBox(this.f37886a);
        emittableCheckBox.b(a());
        emittableCheckBox.f37888c = this.f37888c;
        emittableCheckBox.f37889d = this.f37889d;
        emittableCheckBox.f37890e = this.f37890e;
        emittableCheckBox.f37891f = this.f37891f;
        return emittableCheckBox;
    }

    public final CheckBoxColors d() {
        return this.f37886a;
    }

    public final int e() {
        return this.f37891f;
    }

    public final TextStyle f() {
        return this.f37890e;
    }

    public final String g() {
        return this.f37889d;
    }

    public final void h(boolean z2) {
        this.f37888c = z2;
    }

    public final void i(CheckBoxColors checkBoxColors) {
        this.f37886a = checkBoxColors;
    }

    public final void j(int i3) {
        this.f37891f = i3;
    }

    public final void k(TextStyle textStyle) {
        this.f37890e = textStyle;
    }

    public final void l(String str) {
        this.f37889d = str;
    }

    public String toString() {
        return "EmittableCheckBox(modifier=" + a() + ", checked=" + this.f37888c + ", text=" + this.f37889d + ", style=" + this.f37890e + ", colors=" + this.f37886a + ", maxLines=" + this.f37891f + ')';
    }
}
