package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ScheduleSelectViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f122118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f122119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f122120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AccessMethodConfiguration.Schedules.SchedulesBlockingMode f122121d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AccessMethodConfiguration.Schedules.SchedulesBlockingMode f122122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f122123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f122124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f122125i;

    public ScheduleSelectViewState(boolean z2, ImmutableList schedules, ImmutableList selectedSchedules, AccessMethodConfiguration.Schedules.SchedulesBlockingMode selectedBlockingMode, AccessMethodConfiguration.Schedules.SchedulesBlockingMode originalBlockingMode, boolean z3, boolean z4, int i3) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Intrinsics.checkNotNullParameter(selectedSchedules, "selectedSchedules");
        Intrinsics.checkNotNullParameter(selectedBlockingMode, "selectedBlockingMode");
        Intrinsics.checkNotNullParameter(originalBlockingMode, "originalBlockingMode");
        this.f122118a = z2;
        this.f122119b = schedules;
        this.f122120c = selectedSchedules;
        this.f122121d = selectedBlockingMode;
        this.f122122f = originalBlockingMode;
        this.f122123g = z3;
        this.f122124h = z4;
        this.f122125i = i3;
    }

    public static /* synthetic */ ScheduleSelectViewState b(ScheduleSelectViewState scheduleSelectViewState, boolean z2, ImmutableList immutableList, ImmutableList immutableList2, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode2, boolean z3, boolean z4, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z2 = scheduleSelectViewState.f122118a;
        }
        if ((i4 & 2) != 0) {
            immutableList = scheduleSelectViewState.f122119b;
        }
        if ((i4 & 4) != 0) {
            immutableList2 = scheduleSelectViewState.f122120c;
        }
        if ((i4 & 8) != 0) {
            schedulesBlockingMode = scheduleSelectViewState.f122121d;
        }
        if ((i4 & 16) != 0) {
            schedulesBlockingMode2 = scheduleSelectViewState.f122122f;
        }
        if ((i4 & 32) != 0) {
            z3 = scheduleSelectViewState.f122123g;
        }
        if ((i4 & 64) != 0) {
            z4 = scheduleSelectViewState.f122124h;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i3 = scheduleSelectViewState.f122125i;
        }
        boolean z5 = z4;
        int i5 = i3;
        AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode3 = schedulesBlockingMode2;
        boolean z6 = z3;
        return scheduleSelectViewState.a(z2, immutableList, immutableList2, schedulesBlockingMode, schedulesBlockingMode3, z6, z5, i5);
    }

    private final boolean f() {
        ImmutableList<ScheduleDto> immutableList = this.f122119b;
        if (immutableList == null || !immutableList.isEmpty()) {
            for (ScheduleDto scheduleDto : immutableList) {
                if (scheduleDto.j() != scheduleDto.i()) {
                    return true;
                }
            }
        }
        return this.f122121d != this.f122122f;
    }

    public final ScheduleSelectViewState a(boolean z2, ImmutableList schedules, ImmutableList selectedSchedules, AccessMethodConfiguration.Schedules.SchedulesBlockingMode selectedBlockingMode, AccessMethodConfiguration.Schedules.SchedulesBlockingMode originalBlockingMode, boolean z3, boolean z4, int i3) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Intrinsics.checkNotNullParameter(selectedSchedules, "selectedSchedules");
        Intrinsics.checkNotNullParameter(selectedBlockingMode, "selectedBlockingMode");
        Intrinsics.checkNotNullParameter(originalBlockingMode, "originalBlockingMode");
        return new ScheduleSelectViewState(z2, schedules, selectedSchedules, selectedBlockingMode, originalBlockingMode, z3, z4, i3);
    }

    public final boolean c() {
        return this.f122123g;
    }

    public final boolean d() {
        if (this.f122119b.isEmpty()) {
            return true;
        }
        ImmutableList immutableList = this.f122119b;
        if (immutableList != null && immutableList.isEmpty()) {
            return false;
        }
        Iterator<E> it = immutableList.iterator();
        while (it.hasNext()) {
            if (((ScheduleDto) it.next()).j()) {
                return f();
            }
        }
        return false;
    }

    public final int e() {
        return this.f122125i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleSelectViewState)) {
            return false;
        }
        ScheduleSelectViewState scheduleSelectViewState = (ScheduleSelectViewState) obj;
        return this.f122118a == scheduleSelectViewState.f122118a && Intrinsics.areEqual(this.f122119b, scheduleSelectViewState.f122119b) && Intrinsics.areEqual(this.f122120c, scheduleSelectViewState.f122120c) && this.f122121d == scheduleSelectViewState.f122121d && this.f122122f == scheduleSelectViewState.f122122f && this.f122123g == scheduleSelectViewState.f122123g && this.f122124h == scheduleSelectViewState.f122124h && this.f122125i == scheduleSelectViewState.f122125i;
    }

    public final boolean g() {
        return this.f122124h;
    }

    public final ImmutableList h() {
        return this.f122119b;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.f122118a) * 31) + this.f122119b.hashCode()) * 31) + this.f122120c.hashCode()) * 31) + this.f122121d.hashCode()) * 31) + this.f122122f.hashCode()) * 31) + Boolean.hashCode(this.f122123g)) * 31) + Boolean.hashCode(this.f122124h)) * 31) + Integer.hashCode(this.f122125i);
    }

    public final AccessMethodConfiguration.Schedules.SchedulesBlockingMode i() {
        return this.f122121d;
    }

    public final ImmutableList j() {
        return this.f122120c;
    }

    public String toString() {
        return "ScheduleSelectViewState(isEditingEnabled=" + this.f122118a + ", schedules=" + this.f122119b + ", selectedSchedules=" + this.f122120c + ", selectedBlockingMode=" + this.f122121d + ", originalBlockingMode=" + this.f122122f + ", blockingModeEnabled=" + this.f122123g + ", saveButtonVisible=" + this.f122124h + ", firstUnselectedIndex=" + this.f122125i + ")";
    }

    public /* synthetic */ ScheduleSelectViewState(boolean z2, ImmutableList immutableList, ImmutableList immutableList2, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode2, boolean z3, boolean z4, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? true : z2, (i4 & 2) != 0 ? ExtensionsKt.a() : immutableList, (i4 & 4) != 0 ? ExtensionsKt.a() : immutableList2, (i4 & 8) != 0 ? AccessMethodConfiguration.Schedules.SchedulesBlockingMode.AllBlockings : schedulesBlockingMode, (i4 & 16) != 0 ? AccessMethodConfiguration.Schedules.SchedulesBlockingMode.AllBlockings : schedulesBlockingMode2, (i4 & 32) != 0 ? true : z3, (i4 & 64) != 0 ? true : z4, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? -1 : i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleDto {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f122126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f122127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f122128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f122129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f122130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ScheduleEmoji f122131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f122132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f122133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f122134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f122135j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f122136k;

        public ScheduleDto(long j3, int i3, int i4, String title, boolean z2, ScheduleEmoji scheduleEmoji, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.f122126a = j3;
            this.f122127b = i3;
            this.f122128c = i4;
            this.f122129d = title;
            this.f122130e = z2;
            this.f122131f = scheduleEmoji;
            this.f122132g = z3;
            this.f122133h = z4;
            this.f122134i = z5;
            this.f122135j = z6;
            this.f122136k = z7;
        }

        public static /* synthetic */ ScheduleDto b(ScheduleDto scheduleDto, long j3, int i3, int i4, String str, boolean z2, ScheduleEmoji scheduleEmoji, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j3 = scheduleDto.f122126a;
            }
            return scheduleDto.a(j3, (i5 & 2) != 0 ? scheduleDto.f122127b : i3, (i5 & 4) != 0 ? scheduleDto.f122128c : i4, (i5 & 8) != 0 ? scheduleDto.f122129d : str, (i5 & 16) != 0 ? scheduleDto.f122130e : z2, (i5 & 32) != 0 ? scheduleDto.f122131f : scheduleEmoji, (i5 & 64) != 0 ? scheduleDto.f122132g : z3, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? scheduleDto.f122133h : z4, (i5 & Function.MAX_NARGS) != 0 ? scheduleDto.f122134i : z5, (i5 & 512) != 0 ? scheduleDto.f122135j : z6, (i5 & 1024) != 0 ? scheduleDto.f122136k : z7);
        }

        public final ScheduleDto a(long j3, int i3, int i4, String title, boolean z2, ScheduleEmoji scheduleEmoji, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new ScheduleDto(j3, i3, i4, title, z2, scheduleEmoji, z3, z4, z5, z6, z7);
        }

        public final boolean c() {
            return this.f122130e;
        }

        public final boolean d() {
            return this.f122133h;
        }

        public final boolean e() {
            return this.f122134i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScheduleDto)) {
                return false;
            }
            ScheduleDto scheduleDto = (ScheduleDto) obj;
            return this.f122126a == scheduleDto.f122126a && this.f122127b == scheduleDto.f122127b && this.f122128c == scheduleDto.f122128c && Intrinsics.areEqual(this.f122129d, scheduleDto.f122129d) && this.f122130e == scheduleDto.f122130e && this.f122131f == scheduleDto.f122131f && this.f122132g == scheduleDto.f122132g && this.f122133h == scheduleDto.f122133h && this.f122134i == scheduleDto.f122134i && this.f122135j == scheduleDto.f122135j && this.f122136k == scheduleDto.f122136k;
        }

        public final int f() {
            return this.f122128c;
        }

        public final ScheduleEmoji g() {
            return this.f122131f;
        }

        public final long h() {
            return this.f122126a;
        }

        public int hashCode() {
            int iHashCode = ((((((((Long.hashCode(this.f122126a) * 31) + Integer.hashCode(this.f122127b)) * 31) + Integer.hashCode(this.f122128c)) * 31) + this.f122129d.hashCode()) * 31) + Boolean.hashCode(this.f122130e)) * 31;
            ScheduleEmoji scheduleEmoji = this.f122131f;
            return ((((((((((iHashCode + (scheduleEmoji == null ? 0 : scheduleEmoji.hashCode())) * 31) + Boolean.hashCode(this.f122132g)) * 31) + Boolean.hashCode(this.f122133h)) * 31) + Boolean.hashCode(this.f122134i)) * 31) + Boolean.hashCode(this.f122135j)) * 31) + Boolean.hashCode(this.f122136k);
        }

        public final boolean i() {
            return this.f122136k;
        }

        public final boolean j() {
            return this.f122132g;
        }

        public final String k() {
            return this.f122129d;
        }

        public final int l() {
            return this.f122127b;
        }

        public final boolean m() {
            return this.f122135j;
        }

        public String toString() {
            return "ScheduleDto(id=" + this.f122126a + ", typeCombinations=" + this.f122127b + ", dayFlags=" + this.f122128c + ", title=" + this.f122129d + ", active=" + this.f122130e + ", emoji=" + this.f122131f + ", selected=" + this.f122132g + ", canAddApps=" + this.f122133h + ", canRemoveApps=" + this.f122134i + ", isQuickBlockProfile=" + this.f122135j + ", originallySelected=" + this.f122136k + ")";
        }

        public /* synthetic */ ScheduleDto(long j3, int i3, int i4, String str, boolean z2, ScheduleEmoji scheduleEmoji, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? -1L : j3, (i5 & 2) != 0 ? 0 : i3, (i5 & 4) != 0 ? 0 : i4, (i5 & 8) != 0 ? "" : str, (i5 & 16) != 0 ? false : z2, (i5 & 32) != 0 ? null : scheduleEmoji, (i5 & 64) != 0 ? false : z3, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? true : z4, (i5 & Function.MAX_NARGS) != 0 ? true : z5, (i5 & 512) == 0 ? z6 : true, (i5 & 1024) != 0 ? false : z7);
        }
    }
}
