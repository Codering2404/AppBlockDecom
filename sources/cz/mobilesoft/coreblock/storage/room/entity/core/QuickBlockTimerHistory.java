package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.io.Serializable;
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
public final class QuickBlockTimerHistory implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f126602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f126604c;

    public QuickBlockTimerHistory(int i3, long j3, int i4) {
        this.f126602a = i3;
        this.f126603b = j3;
        this.f126604c = i4;
    }

    public static /* synthetic */ QuickBlockTimerHistory b(QuickBlockTimerHistory quickBlockTimerHistory, int i3, long j3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = quickBlockTimerHistory.f126602a;
        }
        if ((i5 & 2) != 0) {
            j3 = quickBlockTimerHistory.f126603b;
        }
        if ((i5 & 4) != 0) {
            i4 = quickBlockTimerHistory.f126604c;
        }
        return quickBlockTimerHistory.a(i3, j3, i4);
    }

    public final QuickBlockTimerHistory a(int i3, long j3, int i4) {
        return new QuickBlockTimerHistory(i3, j3, i4);
    }

    public final int c() {
        return this.f126602a;
    }

    public final long d() {
        return this.f126603b;
    }

    public final int e() {
        return this.f126604c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockTimerHistory)) {
            return false;
        }
        QuickBlockTimerHistory quickBlockTimerHistory = (QuickBlockTimerHistory) obj;
        return this.f126602a == quickBlockTimerHistory.f126602a && this.f126603b == quickBlockTimerHistory.f126603b && this.f126604c == quickBlockTimerHistory.f126604c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f126602a) * 31) + Long.hashCode(this.f126603b)) * 31) + Integer.hashCode(this.f126604c);
    }

    public String toString() {
        return "QuickBlockTimerHistory(id=" + this.f126602a + ", timeMillis=" + this.f126603b + ", updatedAt=" + this.f126604c + ")";
    }

    public /* synthetic */ QuickBlockTimerHistory(int i3, long j3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i3, j3, (i5 & 4) != 0 ? TimeHelperExt.f128663a.g() : i4);
    }
}
