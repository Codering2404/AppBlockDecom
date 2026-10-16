package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PomodoroSessionDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f106436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f106437b;

    @SerializedName("break")
    private final int pause;

    public PomodoroSessionDTO(int i3, int i4, int i5) {
        this.f106436a = i3;
        this.pause = i4;
        this.f106437b = i5;
    }

    public final int a() {
        return this.pause;
    }

    public final int b() {
        return this.f106436a;
    }

    public final int c() {
        return this.f106437b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PomodoroSessionDTO)) {
            return false;
        }
        PomodoroSessionDTO pomodoroSessionDTO = (PomodoroSessionDTO) obj;
        return this.f106436a == pomodoroSessionDTO.f106436a && this.pause == pomodoroSessionDTO.pause && this.f106437b == pomodoroSessionDTO.f106437b;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f106436a) * 31) + Integer.hashCode(this.pause)) * 31) + Integer.hashCode(this.f106437b);
    }

    public String toString() {
        return "PomodoroSessionDTO(session=" + this.f106436a + ", pause=" + this.pause + ", sessionCount=" + this.f106437b + ")";
    }
}
