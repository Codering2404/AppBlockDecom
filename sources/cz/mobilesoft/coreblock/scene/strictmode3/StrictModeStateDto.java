package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import java.util.List;
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
public final class StrictModeStateDto {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f121484k = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrictModeState f121485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f121486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StrictModeAccessMethod f121487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f121488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AccessMethodConfiguration f121489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f121490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f121491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f121492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f121493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f121494j;

    public StrictModeStateDto(StrictModeState state, List profiles, StrictModeAccessMethod strictModeAccessMethod, List accessMethodsSplit, AccessMethodConfiguration accessMethodConfiguration, List options, long j3, String approvalEmail, long j4, long j5) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
        Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(approvalEmail, "approvalEmail");
        this.f121485a = state;
        this.f121486b = profiles;
        this.f121487c = strictModeAccessMethod;
        this.f121488d = accessMethodsSplit;
        this.f121489e = accessMethodConfiguration;
        this.f121490f = options;
        this.f121491g = j3;
        this.f121492h = approvalEmail;
        this.f121493i = j4;
        this.f121494j = j5;
    }

    public final StrictModeAccessMethod a() {
        return this.f121487c;
    }

    public final AccessMethodConfiguration b() {
        return this.f121489e;
    }

    public final List c() {
        return this.f121488d;
    }

    public final String d() {
        return this.f121492h;
    }

    public final long e() {
        return this.f121493i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeStateDto)) {
            return false;
        }
        StrictModeStateDto strictModeStateDto = (StrictModeStateDto) obj;
        return this.f121485a == strictModeStateDto.f121485a && Intrinsics.areEqual(this.f121486b, strictModeStateDto.f121486b) && this.f121487c == strictModeStateDto.f121487c && Intrinsics.areEqual(this.f121488d, strictModeStateDto.f121488d) && Intrinsics.areEqual(this.f121489e, strictModeStateDto.f121489e) && Intrinsics.areEqual(this.f121490f, strictModeStateDto.f121490f) && this.f121491g == strictModeStateDto.f121491g && Intrinsics.areEqual(this.f121492h, strictModeStateDto.f121492h) && this.f121493i == strictModeStateDto.f121493i && this.f121494j == strictModeStateDto.f121494j;
    }

    public final long f() {
        return this.f121494j;
    }

    public final List g() {
        return this.f121490f;
    }

    public final List h() {
        return this.f121486b;
    }

    public int hashCode() {
        int iHashCode = ((this.f121485a.hashCode() * 31) + this.f121486b.hashCode()) * 31;
        StrictModeAccessMethod strictModeAccessMethod = this.f121487c;
        return ((((((((((((((iHashCode + (strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode())) * 31) + this.f121488d.hashCode()) * 31) + this.f121489e.hashCode()) * 31) + this.f121490f.hashCode()) * 31) + Long.hashCode(this.f121491g)) * 31) + this.f121492h.hashCode()) * 31) + Long.hashCode(this.f121493i)) * 31) + Long.hashCode(this.f121494j);
    }

    public final StrictModeState i() {
        return this.f121485a;
    }

    public String toString() {
        return "StrictModeStateDto(state=" + this.f121485a + ", profiles=" + this.f121486b + ", accessMethod=" + this.f121487c + ", accessMethodsSplit=" + this.f121488d + ", accessMethodConfiguration=" + this.f121489e + ", options=" + this.f121490f + ", cooldownInMillis=" + this.f121491g + ", approvalEmail=" + this.f121492h + ", deactivationTimeMinutes=" + this.f121493i + ", lastPinUpdate=" + this.f121494j + ")";
    }
}
