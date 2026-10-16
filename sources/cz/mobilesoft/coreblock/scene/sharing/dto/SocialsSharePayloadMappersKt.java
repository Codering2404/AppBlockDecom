package cz.mobilesoft.coreblock.scene.sharing.dto;

import cz.mobilesoft.coreblock.dto.InsightsBlockingSessions;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewState;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
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
public final class SocialsSharePayloadMappersKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f119397b;

        static {
            int[] iArr = new int[InsightsViewState.InsightsPeriodType.values().length];
            try {
                iArr[InsightsViewState.InsightsPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f119396a = iArr;
            int[] iArr2 = new int[SocialsSharePayload.PeriodType.values().length];
            try {
                iArr2[SocialsSharePayload.PeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            f119397b = iArr2;
        }
    }

    public static final SocialsSharePayload a(InsightsViewState insightsViewState) {
        SocialsSharePayload.PeriodType periodType;
        List listEmptyList;
        GraphData graphDataL;
        Float fA;
        List listB;
        float fE;
        Intrinsics.checkNotNullParameter(insightsViewState, "<this>");
        int i3 = WhenMappings.f119396a[insightsViewState.a0().ordinal()];
        if (i3 == 1) {
            periodType = SocialsSharePayload.PeriodType.Day;
        } else if (i3 == 2) {
            periodType = SocialsSharePayload.PeriodType.Week;
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            periodType = SocialsSharePayload.PeriodType.Trend;
        }
        SocialsSharePayload.PeriodType periodType2 = periodType;
        AppDistractionType appDistractionTypeF = insightsViewState.f();
        GraphData graphDataL2 = insightsViewState.l();
        String strG = null;
        if (graphDataL2 == null || (listB = graphDataL2.b()) == null) {
            listEmptyList = null;
        } else {
            List<GraphData.GraphValueData> list = listB;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (GraphData.GraphValueData graphValueData : list) {
                if (appDistractionTypeF == null) {
                    fE = graphValueData.e();
                } else {
                    List listF = graphValueData.f();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listF) {
                        if (((GraphData.GraphValueData.GraphValueSection) obj).a() == appDistractionTypeF) {
                            arrayList.add(obj);
                        }
                    }
                    int size = arrayList.size();
                    double dB = 0.0d;
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2 = arrayList.get(i4);
                        i4++;
                        dB += (double) ((GraphData.GraphValueData.GraphValueSection) obj2).b();
                    }
                    fE = (float) dB;
                }
                listEmptyList.add(Float.valueOf(fE));
            }
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        GraphData graphDataL3 = insightsViewState.l();
        int iC = graphDataL3 != null ? graphDataL3.c() : 3;
        String strD = insightsViewState.D();
        InsightsBlockingSessions insightsBlockingSessionsN = insightsViewState.n();
        int iB = insightsBlockingSessionsN != null ? insightsBlockingSessionsN.b() : 0;
        InsightsViewState.InsightsInterval insightsIntervalW = insightsViewState.w();
        long jB = insightsIntervalW != null ? insightsIntervalW.b() : 0L;
        InsightsViewState.InsightsInterval insightsIntervalW2 = insightsViewState.w();
        long jA = insightsIntervalW2 != null ? insightsIntervalW2.a() : 0L;
        Float fM0 = insightsViewState.m0();
        Long lA = WhenMappings.f119397b[periodType2.ordinal()] == 1 ? insightsViewState.A() : null;
        SocialsSharePayload.PeriodType periodType3 = SocialsSharePayload.PeriodType.Trend;
        Boolean boolI0 = periodType2 == periodType3 ? insightsViewState.i0() : null;
        String strD2 = periodType2 == periodType3 ? insightsViewState.D() : "";
        String strY = periodType2 == periodType3 ? insightsViewState.y() : null;
        if (periodType2 == periodType3 && (graphDataL = insightsViewState.l()) != null && (fA = graphDataL.a()) != null) {
            strG = insightsViewState.G((long) (fA.floatValue() * 60), true);
        }
        return new SocialsSharePayload(periodType2, listEmptyList, null, null, iC, strD, iB, jB, jA, fM0, lA, boolI0, strD2, strY, strG, appDistractionTypeF, 12, null);
    }

    public static final SocialsSharePayload b(WeeklyInsightsViewState weeklyInsightsViewState) {
        List listEmptyList;
        List listB;
        Intrinsics.checkNotNullParameter(weeklyInsightsViewState, "<this>");
        SocialsSharePayload.PeriodType periodType = SocialsSharePayload.PeriodType.Week;
        GraphData graphDataC = weeklyInsightsViewState.C();
        if (graphDataC == null || (listB = graphDataC.b()) == null) {
            listEmptyList = null;
        } else {
            List list = listB;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                listEmptyList.add(Float.valueOf(((GraphData.GraphValueData) it.next()).e()));
            }
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        GraphData graphDataC2 = weeklyInsightsViewState.C();
        int iC = graphDataC2 != null ? graphDataC2.c() : 3;
        String strM = weeklyInsightsViewState.m();
        InsightsViewState.InsightsInterval insightsIntervalJ = weeklyInsightsViewState.j();
        long jB = insightsIntervalJ != null ? insightsIntervalJ.b() : 0L;
        InsightsViewState.InsightsInterval insightsIntervalJ2 = weeklyInsightsViewState.j();
        return new SocialsSharePayload(periodType, listEmptyList, null, null, iC, strM, 0, jB, insightsIntervalJ2 != null ? insightsIntervalJ2.a() : 0L, weeklyInsightsViewState.B(), null, null, null, null, null, null, 47180, null);
    }

    public static final SocialsSharePayload c(WeeklyInsightsViewState weeklyInsightsViewState) {
        List listEmptyList;
        ArrayList arrayList;
        List listEmptyList2;
        List listB;
        List listB2;
        List listB3;
        Intrinsics.checkNotNullParameter(weeklyInsightsViewState, "<this>");
        SocialsSharePayload.PeriodType periodType = SocialsSharePayload.PeriodType.WeeklyReport;
        GraphData graphDataC = weeklyInsightsViewState.C();
        if (graphDataC == null || (listB3 = graphDataC.b()) == null) {
            listEmptyList = null;
        } else {
            List list = listB3;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                listEmptyList.add(Float.valueOf(((GraphData.GraphValueData) it.next()).e()));
            }
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        GraphData graphDataC2 = weeklyInsightsViewState.C();
        if (graphDataC2 == null || (listB2 = graphDataC2.b()) == null) {
            arrayList = null;
        } else {
            List list2 = listB2;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(((GraphData.GraphValueData) it2.next()).d());
            }
        }
        GraphData graphDataC3 = weeklyInsightsViewState.C();
        if (graphDataC3 == null || (listB = graphDataC3.b()) == null) {
            listEmptyList2 = null;
        } else {
            List list3 = listB;
            listEmptyList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                List<GraphData.GraphValueData.GraphValueSection> listF = ((GraphData.GraphValueData) it3.next()).f();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listF, 10));
                for (GraphData.GraphValueData.GraphValueSection graphValueSection : listF) {
                    arrayList2.add(new SocialsSharePayload.ColorfulBarSection(graphValueSection.b(), graphValueSection.a()));
                }
                listEmptyList2.add(new SocialsSharePayload.ColorfulBarValue(arrayList2));
            }
        }
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        GraphData graphDataC4 = weeklyInsightsViewState.C();
        int iC = graphDataC4 != null ? graphDataC4.c() : 3;
        List list4 = listEmptyList;
        List list5 = listEmptyList2;
        String strM = weeklyInsightsViewState.m();
        InsightsViewState.InsightsInterval insightsIntervalJ = weeklyInsightsViewState.j();
        long jB = insightsIntervalJ != null ? insightsIntervalJ.b() : 0L;
        InsightsViewState.InsightsInterval insightsIntervalJ2 = weeklyInsightsViewState.j();
        long jA = insightsIntervalJ2 != null ? insightsIntervalJ2.a() : 0L;
        Float fB = weeklyInsightsViewState.B();
        Long lA = weeklyInsightsViewState.A();
        return new SocialsSharePayload(periodType, list4, arrayList, list5, iC, strM, 0, jB, jA, fB, null, lA != null ? Boolean.valueOf(lA.longValue() > 0) : null, weeklyInsightsViewState.n(), weeklyInsightsViewState.D(), null, null, 32832, null);
    }

    public static final SocialsSharePayload d(WeeklyInsightsViewState weeklyInsightsViewState) {
        List listEmptyList;
        Boolean boolValueOf;
        List listB;
        Intrinsics.checkNotNullParameter(weeklyInsightsViewState, "<this>");
        SocialsSharePayload.PeriodType periodType = SocialsSharePayload.PeriodType.Trend;
        GraphData graphDataC = weeklyInsightsViewState.C();
        if (graphDataC == null || (listB = graphDataC.b()) == null) {
            listEmptyList = null;
        } else {
            List list = listB;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                listEmptyList.add(Float.valueOf(((GraphData.GraphValueData) it.next()).e()));
            }
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        GraphData graphDataC2 = weeklyInsightsViewState.C();
        int iC = graphDataC2 != null ? graphDataC2.c() : 3;
        String strM = weeklyInsightsViewState.m();
        InsightsViewState.InsightsInterval insightsIntervalJ = weeklyInsightsViewState.j();
        long jB = insightsIntervalJ != null ? insightsIntervalJ.b() : 0L;
        InsightsViewState.InsightsInterval insightsIntervalJ2 = weeklyInsightsViewState.j();
        long jA = insightsIntervalJ2 != null ? insightsIntervalJ2.a() : 0L;
        Float fB = weeklyInsightsViewState.B();
        Long lA = weeklyInsightsViewState.A();
        if (lA != null) {
            boolValueOf = Boolean.valueOf(lA.longValue() > 0);
        } else {
            boolValueOf = null;
        }
        String strN = weeklyInsightsViewState.n();
        String strD = weeklyInsightsViewState.D();
        Long lF = weeklyInsightsViewState.f();
        return new SocialsSharePayload(periodType, listEmptyList, null, null, iC, strM, 0, jB, jA, fB, null, boolValueOf, strN, strD, lF != null ? DateHelperExtKt.f(lF.longValue(), false, true, false, 10, null) : null, null, 32844, null);
    }
}
