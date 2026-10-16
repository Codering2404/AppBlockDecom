package cz.mobilesoft.coreblock.util;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class UsageAccessEventParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UsageAccessEventParser f128021a = new UsageAccessEventParser();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f128022b = TimeUnit.HOURS.toMillis(12);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f128023c = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f128024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f128025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f128026c;

        public Event(String str, int i3, long j3) {
            this.f128024a = str;
            this.f128025b = i3;
            this.f128026c = j3;
        }

        public final int a() {
            return this.f128025b;
        }

        public final String b() {
            return this.f128024a;
        }

        public final long c() {
            return this.f128026c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Event)) {
                return false;
            }
            Event event = (Event) obj;
            return Intrinsics.areEqual(this.f128024a, event.f128024a) && this.f128025b == event.f128025b && this.f128026c == event.f128026c;
        }

        public int hashCode() {
            String str = this.f128024a;
            return ((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.f128025b)) * 31) + Long.hashCode(this.f128026c);
        }

        public String toString() {
            return "Event(packageName=" + this.f128024a + ", eventType=" + this.f128025b + ", timestamp=" + this.f128026c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenSession {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f128027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f128028b;

        public OpenSession(String packageName, long j3) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f128027a = packageName;
            this.f128028b = j3;
        }

        public final String a() {
            return this.f128027a;
        }

        public final double b(long j3, long j4) {
            return RangesKt.g(j4 - Math.max(this.f128028b, j3), 0L) / 1000.0d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenSession)) {
                return false;
            }
            OpenSession openSession = (OpenSession) obj;
            return Intrinsics.areEqual(this.f128027a, openSession.f128027a) && this.f128028b == openSession.f128028b;
        }

        public int hashCode() {
            return (this.f128027a.hashCode() * 31) + Long.hashCode(this.f128028b);
        }

        public String toString() {
            return "OpenSession(packageName=" + this.f128027a + ", beginTime=" + this.f128028b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ParseResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f128029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f128030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final OpenSession f128031c;

        public ParseResult(List usages, Long l3, OpenSession openSession) {
            Intrinsics.checkNotNullParameter(usages, "usages");
            this.f128029a = usages;
            this.f128030b = l3;
            this.f128031c = openSession;
        }

        public final OpenSession a() {
            return this.f128031c;
        }

        public final Long b() {
            return this.f128030b;
        }

        public final List c() {
            return this.f128029a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParseResult)) {
                return false;
            }
            ParseResult parseResult = (ParseResult) obj;
            return Intrinsics.areEqual(this.f128029a, parseResult.f128029a) && Intrinsics.areEqual(this.f128030b, parseResult.f128030b) && Intrinsics.areEqual(this.f128031c, parseResult.f128031c);
        }

        public int hashCode() {
            int iHashCode = this.f128029a.hashCode() * 31;
            Long l3 = this.f128030b;
            int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
            OpenSession openSession = this.f128031c;
            return iHashCode2 + (openSession != null ? openSession.hashCode() : 0);
        }

        public String toString() {
            return "ParseResult(usages=" + this.f128029a + ", safeSyncTime=" + this.f128030b + ", openSession=" + this.f128031c + ")";
        }
    }

    private UsageAccessEventParser() {
    }

    private final Long a(List list, String str, long j3, long j4, long j5) {
        if (str == null || j4 <= j3) {
            return null;
        }
        if (j3 < j5 && j4 >= j5) {
            return Long.valueOf(j4 - 1);
        }
        if (j4 - j3 > f128022b) {
            return Long.valueOf(j4 - 1);
        }
        list.add(new UsageAccess(UsageAccess.Type.APPLICATION, str, j3, j4, null, null, 48, null));
        return Long.valueOf(j4 - 1);
    }

    private final Long c(Long l3, Long l4) {
        if (l3 != null) {
            return l4 != null ? Long.valueOf(Math.max(l3.longValue(), l4.longValue())) : l3;
        }
        return l4;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.util.UsageAccessEventParser.ParseResult b(java.util.List r33, long r34, long r36) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.UsageAccessEventParser.b(java.util.List, long, long):cz.mobilesoft.coreblock.util.UsageAccessEventParser$ParseResult");
    }
}
