package cz.mobilesoft.coreblock.scene.intro;

import java.util.List;
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
public final class OnboardingAnswersDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f104492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f104493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f104494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f104495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f104496e;

    public OnboardingAnswersDTO(List list, int i3, int i4, long j3, long j4) {
        this.f104492a = list;
        this.f104493b = i3;
        this.f104494c = i4;
        this.f104495d = j3;
        this.f104496e = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnboardingAnswersDTO)) {
            return false;
        }
        OnboardingAnswersDTO onboardingAnswersDTO = (OnboardingAnswersDTO) obj;
        return Intrinsics.areEqual(this.f104492a, onboardingAnswersDTO.f104492a) && this.f104493b == onboardingAnswersDTO.f104493b && this.f104494c == onboardingAnswersDTO.f104494c && this.f104495d == onboardingAnswersDTO.f104495d && this.f104496e == onboardingAnswersDTO.f104496e;
    }

    public int hashCode() {
        List list = this.f104492a;
        return ((((((((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.f104493b)) * 31) + Integer.hashCode(this.f104494c)) * 31) + Long.hashCode(this.f104495d)) * 31) + Long.hashCode(this.f104496e);
    }

    public String toString() {
        return "OnboardingAnswersDTO(selectedHelpItem=" + this.f104492a + ", dailyHoursGuess=" + this.f104493b + ", dailyUnlocksGuess=" + this.f104494c + ", dailySeconds=" + this.f104495d + ", dailyUnlocks=" + this.f104496e + ")";
    }

    public /* synthetic */ OnboardingAnswersDTO(List list, int i3, int i4, long j3, long j4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : list, (i5 & 2) != 0 ? -1 : i3, (i5 & 4) != 0 ? -1 : i4, (i5 & 8) != 0 ? -1L : j3, (i5 & 16) != 0 ? -1L : j4);
    }
}
