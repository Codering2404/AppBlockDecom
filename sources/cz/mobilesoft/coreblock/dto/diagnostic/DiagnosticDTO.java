package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DiagnosticDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96966a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f96967b = 8;

    @SerializedName("apiErrorLogs")
    private final List<String> apiErrorLogs;

    @SerializedName("currentDateTime")
    private final String currentDateTime;

    @SerializedName("dayBeginningHour")
    private final int dayBeginningHour;

    @SerializedName("lastProfileUpdateTime")
    private final long lastProfileUpdateTime;

    @SerializedName("lastProfileUpdateTimeReadable")
    private final String lastProfileUpdateTimeReadable;

    @SerializedName("profiles")
    private final List<ProfileDTO> profiles;

    @SerializedName("recentNetworkCalls")
    private final List<String> recentNetworkCalls;

    @SerializedName("recentNetworkErrors")
    private final List<RecentNetworkErrorsDTO> recentNetworkErrors;

    @SerializedName("strictMode")
    private final StrictModeDTO strictMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiagnosticDTO a(List profiles, Map applicationNames, List strictModeOptions, StrictModeAccessMethod strictModeAccessMethod, int i3, boolean z2, List recentNetworkErrors, List recentNetworkCalls, List apiErrorLogs, long j3) {
            Intrinsics.checkNotNullParameter(profiles, "profiles");
            Intrinsics.checkNotNullParameter(applicationNames, "applicationNames");
            Intrinsics.checkNotNullParameter(strictModeOptions, "strictModeOptions");
            Intrinsics.checkNotNullParameter(recentNetworkErrors, "recentNetworkErrors");
            Intrinsics.checkNotNullParameter(recentNetworkCalls, "recentNetworkCalls");
            Intrinsics.checkNotNullParameter(apiErrorLogs, "apiErrorLogs");
            List list = profiles;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ProfileDTO.f96970a.a((ProfileWithConfiguration) it.next(), applicationNames));
            }
            return new DiagnosticDTO(arrayList, StrictModeDTO.f96975a.a(strictModeOptions, strictModeAccessMethod, z2), i3, DateHelperExtKt.o(TimeHelperExt.f128663a.f()), recentNetworkErrors, recentNetworkCalls, apiErrorLogs, j3, DateHelperExtKt.o(j3));
        }

        private Companion() {
        }
    }

    public DiagnosticDTO(List profiles, StrictModeDTO strictMode, int i3, String currentDateTime, List recentNetworkErrors, List list, List list2, long j3, String lastProfileUpdateTimeReadable) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        Intrinsics.checkNotNullParameter(strictMode, "strictMode");
        Intrinsics.checkNotNullParameter(currentDateTime, "currentDateTime");
        Intrinsics.checkNotNullParameter(recentNetworkErrors, "recentNetworkErrors");
        Intrinsics.checkNotNullParameter(lastProfileUpdateTimeReadable, "lastProfileUpdateTimeReadable");
        this.profiles = profiles;
        this.strictMode = strictMode;
        this.dayBeginningHour = i3;
        this.currentDateTime = currentDateTime;
        this.recentNetworkErrors = recentNetworkErrors;
        this.recentNetworkCalls = list;
        this.apiErrorLogs = list2;
        this.lastProfileUpdateTime = j3;
        this.lastProfileUpdateTimeReadable = lastProfileUpdateTimeReadable;
    }

    public final int a() {
        return this.dayBeginningHour;
    }

    public final List b() {
        return this.profiles;
    }

    public final StrictModeDTO c() {
        return this.strictMode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiagnosticDTO)) {
            return false;
        }
        DiagnosticDTO diagnosticDTO = (DiagnosticDTO) obj;
        return Intrinsics.areEqual(this.profiles, diagnosticDTO.profiles) && Intrinsics.areEqual(this.strictMode, diagnosticDTO.strictMode) && this.dayBeginningHour == diagnosticDTO.dayBeginningHour && Intrinsics.areEqual(this.currentDateTime, diagnosticDTO.currentDateTime) && Intrinsics.areEqual(this.recentNetworkErrors, diagnosticDTO.recentNetworkErrors) && Intrinsics.areEqual(this.recentNetworkCalls, diagnosticDTO.recentNetworkCalls) && Intrinsics.areEqual(this.apiErrorLogs, diagnosticDTO.apiErrorLogs) && this.lastProfileUpdateTime == diagnosticDTO.lastProfileUpdateTime && Intrinsics.areEqual(this.lastProfileUpdateTimeReadable, diagnosticDTO.lastProfileUpdateTimeReadable);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.profiles.hashCode() * 31) + this.strictMode.hashCode()) * 31) + Integer.hashCode(this.dayBeginningHour)) * 31) + this.currentDateTime.hashCode()) * 31) + this.recentNetworkErrors.hashCode()) * 31;
        List<String> list = this.recentNetworkCalls;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.apiErrorLogs;
        return ((((iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + Long.hashCode(this.lastProfileUpdateTime)) * 31) + this.lastProfileUpdateTimeReadable.hashCode();
    }

    public String toString() {
        return "DiagnosticDTO(profiles=" + this.profiles + ", strictMode=" + this.strictMode + ", dayBeginningHour=" + this.dayBeginningHour + ", currentDateTime=" + this.currentDateTime + ", recentNetworkErrors=" + this.recentNetworkErrors + ", recentNetworkCalls=" + this.recentNetworkCalls + ", apiErrorLogs=" + this.apiErrorLogs + ", lastProfileUpdateTime=" + this.lastProfileUpdateTime + ", lastProfileUpdateTimeReadable=" + this.lastProfileUpdateTimeReadable + ")";
    }
}
