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
public final class EmittableSwitch implements Emittable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SwitchColors f37909a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37911c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextStyle f37913e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GlanceModifier f37910b = GlanceModifier.f37605a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37912d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37914f = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public EmittableSwitch(SwitchColors switchColors) {
        this.f37909a = switchColors;
    }

    @Override // androidx.glance.Emittable
    public GlanceModifier a() {
        return this.f37910b;
    }

    @Override // androidx.glance.Emittable
    public void b(GlanceModifier glanceModifier) {
        this.f37910b = glanceModifier;
    }

    public final boolean c() {
        return this.f37911c;
    }

    @Override // androidx.glance.Emittable
    public Emittable copy() {
        EmittableSwitch emittableSwitch = new EmittableSwitch(this.f37909a);
        emittableSwitch.b(a());
        emittableSwitch.f37911c = this.f37911c;
        emittableSwitch.f37912d = this.f37912d;
        emittableSwitch.f37913e = this.f37913e;
        emittableSwitch.f37914f = this.f37914f;
        return emittableSwitch;
    }

    public final SwitchColors d() {
        return this.f37909a;
    }

    public final int e() {
        return this.f37914f;
    }

    public final TextStyle f() {
        return this.f37913e;
    }

    public final String g() {
        return this.f37912d;
    }

    public final void h(boolean z2) {
        this.f37911c = z2;
    }

    public final void i(SwitchColors switchColors) {
        this.f37909a = switchColors;
    }

    public final void j(int i3) {
        this.f37914f = i3;
    }

    public final void k(TextStyle textStyle) {
        this.f37913e = textStyle;
    }

    public final void l(String str) {
        this.f37912d = str;
    }

    public String toString() {
        return "EmittableSwitch(" + this.f37912d + ", modifier=" + a() + ", checked=" + this.f37911c + ", style=" + this.f37913e + ", colors=" + this.f37909a + ", maxLines=" + this.f37914f + ')';
    }
}
