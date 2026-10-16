package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import android.content.Context;
import android.text.format.DateFormat;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CollectionsExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.zone.ZoneRulesException;

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
public final class TimeConditionViewModelKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f115780a = EnumEntriesKt.a(DayOfWeek.values());
    }

    public static final IntervalDTO a(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        long j3 = (((long) calendar.get(11)) * 60) + ((long) calendar.get(12));
        return new IntervalDTO(j3, j3 + 120, null, null, 12, null);
    }

    public static final TimeConditionConfigurationViewState b(Context context, ConditionDTO.TimeDTO timeDTO, boolean z2, boolean z3, boolean z4) {
        ImmutableSet immutableSetD;
        ImmutableList immutableListB;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z7 = !DateFormat.is24HourFormat(context);
        Calendar calendarA = TimeHelperExt.A();
        calendarA.set(13, 0);
        calendarA.set(12, 0);
        calendarA.add(10, 1);
        IntervalDTO intervalDTOA = a(calendarA);
        if (timeDTO == null) {
            if (z2) {
                immutableSetD = ExtensionsKt.j(EntriesMappings.f115780a);
            } else {
                try {
                    immutableSetD = ExtensionsKt.d(Instant.A(calendarA.getTimeInMillis()).p(ZoneId.s()).w().S());
                } catch (ZoneRulesException e3) {
                    e3.printStackTrace();
                    CrashHelper.j(e3);
                    immutableSetD = ExtensionsKt.d(DayOfWeek.l(1));
                }
            }
            return new TimeConditionConfigurationViewState(new Configuration(immutableSetD, null, ExtensionsKt.b(intervalDTOA), z3, false, 18, null), z4, false, false, false, null, z7, 60, null);
        }
        ImmutableSet immutableSetF = timeDTO.f();
        ImmutableSet immutableSetE = timeDTO.e();
        ArrayList arrayListD = timeDTO.d();
        ArrayList arrayList = new ArrayList();
        int size = arrayListD.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListD.get(i3);
            i3++;
            if (!IntervalsHelperKt.k((IntervalDTO) obj)) {
                arrayList.add(obj);
            }
        }
        Collection collectionD = CollectionsExtKt.d(arrayList);
        if (collectionD == null || (immutableListB = ExtensionsKt.h(collectionD)) == null) {
            immutableListB = ExtensionsKt.b(intervalDTOA);
        }
        ImmutableList immutableList = immutableListB;
        ArrayList arrayListD2 = timeDTO.d();
        if (arrayListD2 == null || !arrayListD2.isEmpty()) {
            int size2 = arrayListD2.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayListD2.get(i4);
                i4++;
                if (IntervalsHelperKt.k((IntervalDTO) obj2)) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
        } else {
            z5 = false;
        }
        ArrayList arrayListD3 = timeDTO.d();
        if (arrayListD3 == null || !arrayListD3.isEmpty()) {
            int size3 = arrayListD3.size();
            int i5 = 0;
            while (i5 < size3) {
                Object obj3 = arrayListD3.get(i5);
                i5++;
                if (IntervalsHelperKt.k((IntervalDTO) obj3)) {
                    z6 = true;
                    break;
                }
            }
            z6 = false;
        } else {
            z6 = false;
        }
        return new TimeConditionConfigurationViewState(new Configuration(immutableSetF, immutableSetE, immutableList, z5, z6), z4, false, false, false, null, z7, 60, null);
    }

    public static /* synthetic */ TimeConditionConfigurationViewState c(Context context, ConditionDTO.TimeDTO timeDTO, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        return b(context, timeDTO, z2, z3, z4);
    }
}
