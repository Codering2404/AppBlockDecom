package cz.mobilesoft.coreblock.scene.intro.strictmode;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InfoItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f104992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f104993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Color f104994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f104995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f104996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f104997f;

    public /* synthetic */ InfoItem(int i3, int i4, Color color, long j3, long j4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, color, j3, j4, z2);
    }

    public final long a() {
        return this.f104996e;
    }

    public final Color b() {
        return this.f104994c;
    }

    public final int c() {
        return this.f104992a;
    }

    public final long d() {
        return this.f104995d;
    }

    public final int e() {
        return this.f104993b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoItem)) {
            return false;
        }
        InfoItem infoItem = (InfoItem) obj;
        return this.f104992a == infoItem.f104992a && this.f104993b == infoItem.f104993b && Intrinsics.areEqual(this.f104994c, infoItem.f104994c) && Color.t(this.f104995d, infoItem.f104995d) && Color.t(this.f104996e, infoItem.f104996e) && this.f104997f == infoItem.f104997f;
    }

    public final boolean f() {
        return this.f104997f;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.f104992a) * 31) + Integer.hashCode(this.f104993b)) * 31;
        Color color = this.f104994c;
        return ((((((iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31) + Color.z(this.f104995d)) * 31) + Color.z(this.f104996e)) * 31) + Boolean.hashCode(this.f104997f);
    }

    public String toString() {
        return "InfoItem(iconRes=" + this.f104992a + ", textResId=" + this.f104993b + ", iconBackgroundColor=" + this.f104994c + ", iconTint=" + Color.A(this.f104995d) + ", highlightColor=" + Color.A(this.f104996e) + ", withBadge=" + this.f104997f + ")";
    }

    private InfoItem(int i3, int i4, Color color, long j3, long j4, boolean z2) {
        this.f104992a = i3;
        this.f104993b = i4;
        this.f104994c = color;
        this.f104995d = j3;
        this.f104996e = j4;
        this.f104997f = z2;
    }

    public /* synthetic */ InfoItem(int i3, int i4, Color color, long j3, long j4, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, color, j3, j4, (i5 & 32) != 0 ? false : z2, null);
    }
}
