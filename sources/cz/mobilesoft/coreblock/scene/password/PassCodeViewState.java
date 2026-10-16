package cz.mobilesoft.coreblock.scene.password;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PassCodeViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PassCodeStep f111691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f111692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f111693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f111694d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f111695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f111696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f111697h;

    public PassCodeViewState(PassCodeStep step, String passCode, String confirmationCode, boolean z2, int i3, long j3, List unlockTypes) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(passCode, "passCode");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(unlockTypes, "unlockTypes");
        this.f111691a = step;
        this.f111692b = passCode;
        this.f111693c = confirmationCode;
        this.f111694d = z2;
        this.f111695f = i3;
        this.f111696g = j3;
        this.f111697h = unlockTypes;
    }

    public static /* synthetic */ PassCodeViewState b(PassCodeViewState passCodeViewState, PassCodeStep passCodeStep, String str, String str2, boolean z2, int i3, long j3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            passCodeStep = passCodeViewState.f111691a;
        }
        if ((i4 & 2) != 0) {
            str = passCodeViewState.f111692b;
        }
        if ((i4 & 4) != 0) {
            str2 = passCodeViewState.f111693c;
        }
        if ((i4 & 8) != 0) {
            z2 = passCodeViewState.f111694d;
        }
        if ((i4 & 16) != 0) {
            i3 = passCodeViewState.f111695f;
        }
        if ((i4 & 32) != 0) {
            j3 = passCodeViewState.f111696g;
        }
        if ((i4 & 64) != 0) {
            list = passCodeViewState.f111697h;
        }
        List list2 = list;
        long j4 = j3;
        int i5 = i3;
        String str3 = str2;
        return passCodeViewState.a(passCodeStep, str, str3, z2, i5, j4, list2);
    }

    public final PassCodeViewState a(PassCodeStep step, String passCode, String confirmationCode, boolean z2, int i3, long j3, List unlockTypes) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(passCode, "passCode");
        Intrinsics.checkNotNullParameter(confirmationCode, "confirmationCode");
        Intrinsics.checkNotNullParameter(unlockTypes, "unlockTypes");
        return new PassCodeViewState(step, passCode, confirmationCode, z2, i3, j3, unlockTypes);
    }

    public final String c() {
        return this.f111693c;
    }

    public final int d() {
        return this.f111695f;
    }

    public final String e() {
        return this.f111692b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassCodeViewState)) {
            return false;
        }
        PassCodeViewState passCodeViewState = (PassCodeViewState) obj;
        return this.f111691a == passCodeViewState.f111691a && Intrinsics.areEqual(this.f111692b, passCodeViewState.f111692b) && Intrinsics.areEqual(this.f111693c, passCodeViewState.f111693c) && this.f111694d == passCodeViewState.f111694d && this.f111695f == passCodeViewState.f111695f && this.f111696g == passCodeViewState.f111696g && Intrinsics.areEqual(this.f111697h, passCodeViewState.f111697h);
    }

    public final long f() {
        return this.f111696g;
    }

    public final PassCodeStep g() {
        return this.f111691a;
    }

    public final List h() {
        return this.f111697h;
    }

    public int hashCode() {
        return (((((((((((this.f111691a.hashCode() * 31) + this.f111692b.hashCode()) * 31) + this.f111693c.hashCode()) * 31) + Boolean.hashCode(this.f111694d)) * 31) + Integer.hashCode(this.f111695f)) * 31) + Long.hashCode(this.f111696g)) * 31) + this.f111697h.hashCode();
    }

    public final boolean i() {
        int length = this.f111692b.length();
        return 4 <= length && length < 9;
    }

    public final boolean j() {
        return this.f111694d;
    }

    public String toString() {
        return "PassCodeViewState(step=" + this.f111691a + ", passCode=" + this.f111692b + ", confirmationCode=" + this.f111693c + ", isShaking=" + this.f111694d + ", failedAttempts=" + this.f111695f + ", remainingTime=" + this.f111696g + ", unlockTypes=" + this.f111697h + ")";
    }

    public /* synthetic */ PassCodeViewState(PassCodeStep passCodeStep, String str, String str2, boolean z2, int i3, long j3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(passCodeStep, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? false : z2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? 0L : j3, (i4 & 64) != 0 ? BackdoorUtils.UnlockType.getEntries() : list);
    }
}
