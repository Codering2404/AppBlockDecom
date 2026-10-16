package cz.mobilesoft.coreblock.scene.schedule.condition.time;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Wifi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f115789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f115790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f115791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f115792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f115793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f115794f;

    public Wifi(String ssid, String trimmedSsid, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(trimmedSsid, "trimmedSsid");
        this.f115789a = ssid;
        this.f115790b = trimmedSsid;
        this.f115791c = z2;
        this.f115792d = z3;
        this.f115793e = z4;
        this.f115794f = z5;
    }

    public static /* synthetic */ Wifi b(Wifi wifi, String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = wifi.f115789a;
        }
        if ((i3 & 2) != 0) {
            str2 = wifi.f115790b;
        }
        if ((i3 & 4) != 0) {
            z2 = wifi.f115791c;
        }
        if ((i3 & 8) != 0) {
            z3 = wifi.f115792d;
        }
        if ((i3 & 16) != 0) {
            z4 = wifi.f115793e;
        }
        if ((i3 & 32) != 0) {
            z5 = wifi.f115794f;
        }
        boolean z6 = z4;
        boolean z7 = z5;
        return wifi.a(str, str2, z2, z3, z6, z7);
    }

    public final Wifi a(String ssid, String trimmedSsid, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(trimmedSsid, "trimmedSsid");
        return new Wifi(ssid, trimmedSsid, z2, z3, z4, z5);
    }

    public final String c() {
        return this.f115789a;
    }

    public final String d() {
        return this.f115790b;
    }

    public final boolean e() {
        return this.f115794f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Wifi)) {
            return false;
        }
        Wifi wifi = (Wifi) obj;
        return Intrinsics.areEqual(this.f115789a, wifi.f115789a) && Intrinsics.areEqual(this.f115790b, wifi.f115790b) && this.f115791c == wifi.f115791c && this.f115792d == wifi.f115792d && this.f115793e == wifi.f115793e && this.f115794f == wifi.f115794f;
    }

    public final boolean f() {
        return this.f115791c;
    }

    public final boolean g() {
        return this.f115793e;
    }

    public final boolean h() {
        return this.f115792d;
    }

    public int hashCode() {
        return (((((((((this.f115789a.hashCode() * 31) + this.f115790b.hashCode()) * 31) + Boolean.hashCode(this.f115791c)) * 31) + Boolean.hashCode(this.f115792d)) * 31) + Boolean.hashCode(this.f115793e)) * 31) + Boolean.hashCode(this.f115794f);
    }

    public String toString() {
        return "Wifi(ssid=" + this.f115789a + ", trimmedSsid=" + this.f115790b + ", isConnected=" + this.f115791c + ", isScanned=" + this.f115792d + ", isLocked=" + this.f115793e + ", isChecked=" + this.f115794f + ")";
    }

    public /* synthetic */ Wifi(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? false : z4, (i3 & 32) != 0 ? false : z5);
    }
}
