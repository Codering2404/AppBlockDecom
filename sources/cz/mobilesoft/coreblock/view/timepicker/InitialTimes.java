package cz.mobilesoft.coreblock.view.timepicker;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class InitialTimes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f133005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f133006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f133007c;

    public InitialTimes(int i3, int i4, int i5) {
        this.f133005a = i3;
        this.f133006b = i4;
        this.f133007c = i5;
    }

    public final int a() {
        return this.f133005a;
    }

    public final int b() {
        return this.f133006b;
    }

    public final int c() {
        return this.f133007c;
    }

    public final void d(int i3) {
        this.f133005a = i3;
    }

    public final void e(int i3) {
        this.f133006b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitialTimes)) {
            return false;
        }
        InitialTimes initialTimes = (InitialTimes) obj;
        return this.f133005a == initialTimes.f133005a && this.f133006b == initialTimes.f133006b && this.f133007c == initialTimes.f133007c;
    }

    public final void f(int i3) {
        this.f133007c = i3;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f133005a) * 31) + Integer.hashCode(this.f133006b)) * 31) + Integer.hashCode(this.f133007c);
    }

    public String toString() {
        return "InitialTimes(daysIndex=" + this.f133005a + ", hoursIndex=" + this.f133006b + ", minutesIndex=" + this.f133007c + ")";
    }

    public /* synthetic */ InitialTimes(int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i3, (i6 & 2) != 0 ? 0 : i4, (i6 & 4) != 0 ? 0 : i5);
    }
}
