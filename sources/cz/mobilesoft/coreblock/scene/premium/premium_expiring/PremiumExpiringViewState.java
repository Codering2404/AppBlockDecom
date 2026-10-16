package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.dto.TrialSummaryData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumExpiringViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f113596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScreenType f113597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TrialSummaryData f113598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f113599d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f113600f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScreenType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScreenType[] $VALUES;
        public static final Companion Companion;
        public static final ScreenType Flow = new ScreenType("Flow", 0, "A");
        public static final ScreenType SinglePage = new ScreenType("SinglePage", 1, "B");
        private final String value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ScreenType a(String value) {
                ScreenType next;
                Intrinsics.checkNotNullParameter(value, "value");
                Iterator<ScreenType> it = ScreenType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getValue(), value)) {
                        break;
                    }
                }
                ScreenType screenType = next;
                return screenType == null ? ScreenType.Flow : screenType;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ScreenType[] $values() {
            return new ScreenType[]{Flow, SinglePage};
        }

        static {
            ScreenType[] screenTypeArr$values = $values();
            $VALUES = screenTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(screenTypeArr$values);
            Companion = new Companion(null);
        }

        private ScreenType(String str, int i3, String str2) {
            this.value = str2;
        }

        public static EnumEntries<ScreenType> getEntries() {
            return $ENTRIES;
        }

        public static ScreenType valueOf(String str) {
            return (ScreenType) Enum.valueOf(ScreenType.class, str);
        }

        public static ScreenType[] values() {
            return (ScreenType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    public PremiumExpiringViewState(List profiles, ScreenType screenType, TrialSummaryData trialSummaryData, String str, Integer num) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        this.f113596a = profiles;
        this.f113597b = screenType;
        this.f113598c = trialSummaryData;
        this.f113599d = str;
        this.f113600f = num;
    }

    public static /* synthetic */ PremiumExpiringViewState b(PremiumExpiringViewState premiumExpiringViewState, List list, ScreenType screenType, TrialSummaryData trialSummaryData, String str, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = premiumExpiringViewState.f113596a;
        }
        if ((i3 & 2) != 0) {
            screenType = premiumExpiringViewState.f113597b;
        }
        if ((i3 & 4) != 0) {
            trialSummaryData = premiumExpiringViewState.f113598c;
        }
        if ((i3 & 8) != 0) {
            str = premiumExpiringViewState.f113599d;
        }
        if ((i3 & 16) != 0) {
            num = premiumExpiringViewState.f113600f;
        }
        Integer num2 = num;
        TrialSummaryData trialSummaryData2 = trialSummaryData;
        return premiumExpiringViewState.a(list, screenType, trialSummaryData2, str, num2);
    }

    public final PremiumExpiringViewState a(List profiles, ScreenType screenType, TrialSummaryData trialSummaryData, String str, Integer num) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        return new PremiumExpiringViewState(profiles, screenType, trialSummaryData, str, num);
    }

    public final Integer c() {
        return this.f113600f;
    }

    public final String d() {
        return this.f113599d;
    }

    public final List e() {
        return this.f113596a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PremiumExpiringViewState)) {
            return false;
        }
        PremiumExpiringViewState premiumExpiringViewState = (PremiumExpiringViewState) obj;
        return Intrinsics.areEqual(this.f113596a, premiumExpiringViewState.f113596a) && this.f113597b == premiumExpiringViewState.f113597b && Intrinsics.areEqual(this.f113598c, premiumExpiringViewState.f113598c) && Intrinsics.areEqual(this.f113599d, premiumExpiringViewState.f113599d) && Intrinsics.areEqual(this.f113600f, premiumExpiringViewState.f113600f);
    }

    public final ScreenType f() {
        return this.f113597b;
    }

    public final TrialSummaryData g() {
        return this.f113598c;
    }

    public int hashCode() {
        int iHashCode = this.f113596a.hashCode() * 31;
        ScreenType screenType = this.f113597b;
        int iHashCode2 = (iHashCode + (screenType == null ? 0 : screenType.hashCode())) * 31;
        TrialSummaryData trialSummaryData = this.f113598c;
        int iHashCode3 = (iHashCode2 + (trialSummaryData == null ? 0 : trialSummaryData.hashCode())) * 31;
        String str = this.f113599d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f113600f;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "PremiumExpiringViewState(profiles=" + this.f113596a + ", screenType=" + this.f113597b + ", trialSummaryData=" + this.f113598c + ", premiumExpiryDate=" + this.f113599d + ", daysLeftInPremium=" + this.f113600f + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PremiumExpiringViewState(java.util.List r2, cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewState.ScreenType r3, cz.mobilesoft.coreblock.dto.TrialSummaryData r4, java.lang.String r5, java.lang.Integer r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Le
            r3 = r0
        Le:
            r8 = r7 & 4
            if (r8 == 0) goto L13
            r4 = r0
        L13:
            r8 = r7 & 8
            if (r8 == 0) goto L18
            r5 = r0
        L18:
            r7 = r7 & 16
            if (r7 == 0) goto L23
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L29
        L23:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L29:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewState.<init>(java.util.List, cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewState$ScreenType, cz.mobilesoft.coreblock.dto.TrialSummaryData, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
