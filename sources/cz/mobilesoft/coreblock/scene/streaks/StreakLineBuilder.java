package cz.mobilesoft.coreblock.scene.streaks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakLineBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreakLineBuilder f120365a = new StreakLineBuilder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class WorkingLine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f120366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f120367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f120368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f120369d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f120370e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f120371a;

            static {
                int[] iArr = new int[StreakDayStatus.values().length];
                try {
                    iArr[StreakDayStatus.OBTAINED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StreakDayStatus.REST.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[StreakDayStatus.INACTIVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[StreakDayStatus.LOST.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f120371a = iArr;
            }
        }

        public WorkingLine(StreakDay day) {
            Intrinsics.checkNotNullParameter(day, "day");
            this.f120366a = day.a();
            this.f120367b = day.a();
            this.f120368c = day.b() == StreakDayStatus.OBTAINED ? 1 : 0;
            this.f120369d = day.b() == StreakDayStatus.REST ? 1 : 0;
            this.f120370e = 1;
        }

        public final void a(StreakDay day) {
            Intrinsics.checkNotNullParameter(day, "day");
            this.f120367b = day.a();
            this.f120370e++;
            int i3 = WhenMappings.f120371a[day.b().ordinal()];
            if (i3 == 1) {
                this.f120368c++;
            } else if (i3 == 2) {
                this.f120369d++;
            } else if (i3 != 3 && i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }

        public final StreakLine b(boolean z2) {
            return new StreakLine(this.f120366a, this.f120367b, this.f120368c, this.f120369d, this.f120370e, z2);
        }
    }

    private StreakLineBuilder() {
    }

    public final List a(List days) {
        Intrinsics.checkNotNullParameter(days, "days");
        List listSortedWith = CollectionsKt.sortedWith(days, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.streaks.StreakLineBuilder$build$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(((StreakDay) obj).a(), ((StreakDay) obj2).a());
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = listSortedWith.iterator();
        WorkingLine workingLine = null;
        LocalDate localDate = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StreakDay streakDay = (StreakDay) it.next();
            LocalDate localDateH = StreakDates.f120261a.h(streakDay.a());
            if (localDateH != null) {
                boolean zAreEqual = Intrinsics.areEqual(localDate != null ? localDate.plusDays(1L) : null, localDateH);
                StreakDayStatus streakDayStatusB = streakDay.b();
                StreakDayStatus streakDayStatus = StreakDayStatus.OBTAINED;
                boolean z2 = streakDayStatusB == streakDayStatus || streakDay.b() == StreakDayStatus.REST;
                boolean z3 = streakDay.b() == streakDayStatus;
                if (workingLine != null && zAreEqual && z2) {
                    workingLine.a(streakDay);
                } else if (z3) {
                    if (workingLine != null) {
                        arrayList.add(workingLine.b(false));
                    }
                    workingLine = new WorkingLine(streakDay);
                } else if (workingLine != null) {
                    arrayList.add(workingLine.b(false));
                    workingLine = null;
                }
                localDate = localDateH;
            }
        }
        if (workingLine != null) {
            arrayList.add(workingLine.b(true));
        }
        return arrayList;
    }
}
