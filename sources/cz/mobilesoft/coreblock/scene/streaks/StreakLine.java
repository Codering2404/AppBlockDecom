package cz.mobilesoft.coreblock.scene.streaks;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import kotlin.Metadata;
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
public final class StreakLine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f120359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f120360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f120361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f120362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f120363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f120364f;

    public final String a() {
        return this.f120360b;
    }

    public final int b() {
        return this.f120361c;
    }

    public final String c() {
        return this.f120359a;
    }

    public final boolean d() {
        return this.f120364f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakLine)) {
            return false;
        }
        StreakLine streakLine = (StreakLine) obj;
        return Intrinsics.areEqual(this.f120359a, streakLine.f120359a) && Intrinsics.areEqual(this.f120360b, streakLine.f120360b) && this.f120361c == streakLine.f120361c && this.f120362d == streakLine.f120362d && this.f120363e == streakLine.f120363e && this.f120364f == streakLine.f120364f;
    }

    public int hashCode() {
        return (((((((((this.f120359a.hashCode() * 31) + this.f120360b.hashCode()) * 31) + Integer.hashCode(this.f120361c)) * 31) + Integer.hashCode(this.f120362d)) * 31) + Integer.hashCode(this.f120363e)) * 31) + Boolean.hashCode(this.f120364f);
    }

    public String toString() {
        return "StreakLine(startDayKey=" + this.f120359a + ", endDayKey=" + this.f120360b + ", obtainedDaysCount=" + this.f120361c + ", restDaysCount=" + this.f120362d + ", totalDaysCount=" + this.f120363e + ", isActive=" + this.f120364f + ")";
    }

    public StreakLine(String startDayKey, String str, int i3, int i4, int i5, boolean z2) {
        Intrinsics.checkNotNullParameter(startDayKey, "startDayKey");
        Intrinsics.checkNotNullParameter(str, muQRKXGtpOhe.KMkuJfD);
        this.f120359a = startDayKey;
        this.f120360b = str;
        this.f120361c = i3;
        this.f120362d = i4;
        this.f120363e = i5;
        this.f120364f = z2;
    }
}
