package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class DialogProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f30238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SecureFlagPolicy f30240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30242e;

    public DialogProperties(boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5) {
        this.f30238a = z2;
        this.f30239b = z3;
        this.f30240c = secureFlagPolicy;
        this.f30241d = z4;
        this.f30242e = z5;
    }

    public final boolean a() {
        return this.f30242e;
    }

    public final boolean b() {
        return this.f30238a;
    }

    public final boolean c() {
        return this.f30239b;
    }

    public final SecureFlagPolicy d() {
        return this.f30240c;
    }

    public final boolean e() {
        return this.f30241d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogProperties)) {
            return false;
        }
        DialogProperties dialogProperties = (DialogProperties) obj;
        return this.f30238a == dialogProperties.f30238a && this.f30239b == dialogProperties.f30239b && this.f30240c == dialogProperties.f30240c && this.f30241d == dialogProperties.f30241d && this.f30242e == dialogProperties.f30242e;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f30238a) * 31) + Boolean.hashCode(this.f30239b)) * 31) + this.f30240c.hashCode()) * 31) + Boolean.hashCode(this.f30241d)) * 31) + Boolean.hashCode(this.f30242e);
    }

    public /* synthetic */ DialogProperties(boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? true : z3, (i3 & 4) != 0 ? SecureFlagPolicy.f30288a : secureFlagPolicy, (i3 & 8) != 0 ? true : z4, (i3 & 16) != 0 ? true : z5);
    }

    public /* synthetic */ DialogProperties(boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? true : z3, (i3 & 4) != 0 ? true : z4);
    }

    public DialogProperties(boolean z2, boolean z3, boolean z4) {
        this(z2, z3, SecureFlagPolicy.f30288a, z4, true);
    }
}
