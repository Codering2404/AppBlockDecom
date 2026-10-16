package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.threeten.bp.DayOfWeek;

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
public interface TimeConditionHandler {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX INFO: Access modifiers changed from: private */
    default void W() {
        c(StrictModeTitleAlternatives.Companion.a());
    }

    private default boolean d(IntervalDTO intervalDTO, long j3, long j4) {
        Long lE = intervalDTO.e();
        if (lE != null) {
            long jLongValue = lE.longValue();
            Long lF = intervalDTO.f();
            if (lF != null) {
                long jLongValue2 = lF.longValue();
                boolean z2 = jLongValue > jLongValue2;
                boolean z3 = j3 > j4;
                if (z2 == z3) {
                    return j3 <= jLongValue && j4 >= jLongValue2;
                }
                if (z3) {
                    return j3 <= jLongValue || j4 >= jLongValue2;
                }
                return false;
            }
        }
        return true;
    }

    boolean O();

    boolean X();

    default void a0(IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        if (O() && !X() && interval.e() != null && interval.f() != null) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new TimeConditionHandler$onIntervalRemoveClicked$1(this, null), 3, null);
            return;
        }
        TimeConditionConfigurationViewState timeConditionConfigurationViewStateX0 = x0();
        ImmutableList immutableListH = ExtensionsKt.h(CollectionsKt.sortedWith(CollectionsKt.minus(timeConditionConfigurationViewStateX0.f().e(), interval), new Comparator() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler$onIntervalRemoveClicked$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Long.valueOf(((IntervalDTO) obj).b()), Long.valueOf(((IntervalDTO) obj2).b()));
            }
        }));
        n0(TimeConditionConfigurationViewState.d(timeConditionConfigurationViewStateX0, Configuration.b(timeConditionConfigurationViewStateX0.f(), null, null, immutableListH, immutableListH.isEmpty(), false, 19, null), false, false, false, false, null, false, 126, null));
    }

    void c(int i3);

    default void f(boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        int limitValue = Limit.TIME_SCHEDULE_DAY_LIMIT.getLimitValue();
        ImmutableSet immutableSetK = x0().f().k();
        int size = immutableSetK.size();
        boolean z3 = z2 && !isPremium() && !X() && size + 1 > limitValue;
        if (((!z2 && !X() && x0().f().i().contains(dayOfWeek)) || z3) && O()) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new TimeConditionHandler$onDayCheckedChanged$1(this, null), 3, null);
        } else if (!z2 || isPremium() || size + 1 <= limitValue) {
            n0(TimeConditionConfigurationViewState.d(x0(), Configuration.b(x0().f(), ExtensionsKt.j(z2 ? SetsKt.plus(immutableSetK, dayOfWeek) : SetsKt.minus(immutableSetK, dayOfWeek)), null, null, false, false, 30, null), false, false, false, false, null, false, 126, null));
        } else {
            n0(TimeConditionConfigurationViewState.d(x0(), Configuration.b(x0().f(), ExtensionsKt.d(dayOfWeek), null, null, false, false, 30, null), false, false, false, false, null, false, 126, null));
        }
    }

    default void g(IntervalDTO intervalDTO, long j3, long j4) {
        TimeConditionConfigurationViewState timeConditionConfigurationViewStateX0 = x0();
        if (O() && !X() && intervalDTO != null && !d(intervalDTO, j3, j4)) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new TimeConditionHandler$onIntervalSet$1(this, null), 3, null);
            return;
        }
        IntervalDTO intervalDTO2 = new IntervalDTO(j3, j4, intervalDTO != null ? intervalDTO.e() : null, intervalDTO != null ? intervalDTO.f() : null);
        Configuration configurationF = timeConditionConfigurationViewStateX0.f();
        List mutableList = CollectionsKt.toMutableList((Collection) timeConditionConfigurationViewStateX0.f().e());
        if (intervalDTO == null || ((IntervalDTO) mutableList.set(mutableList.indexOf(intervalDTO), intervalDTO2)) == null) {
            mutableList.add(intervalDTO2);
        }
        Unit unit = Unit.f139807a;
        n0(TimeConditionConfigurationViewState.d(timeConditionConfigurationViewStateX0, Configuration.b(configurationF, null, null, ExtensionsKt.h(mutableList), false, false, 27, null), false, false, false, false, null, false, 110, null));
    }

    CoroutineScope getScope();

    default void h0() {
        Configuration configurationF = x0().f();
        boolean zIsEmpty = configurationF.k().isEmpty();
        int value = 0;
        boolean z2 = configurationF.e().isEmpty() && !configurationF.l();
        Iterator<E> it = configurationF.k().iterator();
        while (it.hasNext()) {
            value |= DayFlags.Companion.b((DayOfWeek) it.next()).getValue();
        }
        if (zIsEmpty || z2) {
            AnswersHelper.f128199a.j5(value, configurationF.e().size(), configurationF.l(), X());
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new TimeConditionHandler$onTimeConditionError$1(zIsEmpty, this, z2, null), 3, null);
        }
    }

    boolean isPremium();

    default void m() {
        n0(TimeConditionConfigurationViewState.d(x0(), null, false, false, false, false, null, false, 79, null));
    }

    void n0(TimeConditionConfigurationViewState timeConditionConfigurationViewState);

    default void p(IntervalDTO intervalDTO) {
        n0(TimeConditionConfigurationViewState.d(x0(), null, false, false, false, true, intervalDTO, false, 79, null));
    }

    default void p0(IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        BuildersKt__Builders_commonKt.d(getScope(), null, null, new TimeConditionHandler$onIntervalClicked$1(this, interval, null), 3, null);
    }

    StrictModeRepository t0();

    Long w();

    default void x() {
        IntervalDTO intervalDTOH = x0().f().h();
        g(null, intervalDTOH.b(), intervalDTOH.a());
    }

    TimeConditionConfigurationViewState x0();

    default void y(boolean z2) {
        if (!z2 && !X() && x0().f().j()) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new TimeConditionHandler$onAllDayLongCheckedChanged$1(this, z2, null), 3, null);
        } else {
            AnswersHelper.f128199a.i5(z2, X());
            n0(TimeConditionConfigurationViewState.d(x0(), Configuration.b(x0().f(), null, null, null, z2, false, 23, null), false, false, false, false, null, false, 126, null));
        }
    }
}
