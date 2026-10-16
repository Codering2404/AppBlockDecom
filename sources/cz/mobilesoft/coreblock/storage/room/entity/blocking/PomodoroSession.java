package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class PomodoroSession implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f126438d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f126439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f126440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f126441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f126442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f126443j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class SessionMode implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f126444b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f126445c = "FOCUS";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f126446d = "BREAK";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f126447a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Break extends SessionMode {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final String f126448f;

            public Break(long j3) {
                super(j3, null);
                this.f126448f = SessionMode.f126444b.a();
            }

            @Override // cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession.SessionMode
            public String c() {
                return this.f126448f;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String a() {
                return SessionMode.f126446d;
            }

            public final String b() {
                return SessionMode.f126445c;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Focus extends SessionMode {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final String f126449f;

            public Focus(long j3) {
                super(j3, null);
                this.f126449f = SessionMode.f126444b.b();
            }

            @Override // cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession.SessionMode
            public String c() {
                return this.f126449f;
            }
        }

        public /* synthetic */ SessionMode(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        public abstract String c();

        public final long d() {
            return this.f126447a;
        }

        private SessionMode(long j3) {
            this.f126447a = j3;
        }
    }

    public PomodoroSession(long j3, long j4, long j5, long j6, long j7, int i3, boolean z2, long j8, long j9) {
        this.f126435a = j3;
        this.f126436b = j4;
        this.f126437c = j5;
        this.f126438d = j6;
        this.f126439f = j7;
        this.f126440g = i3;
        this.f126441h = z2;
        this.f126442i = j8;
        this.f126443j = j9;
    }

    public static /* synthetic */ PomodoroSession b(PomodoroSession pomodoroSession, long j3, long j4, long j5, long j6, long j7, int i3, boolean z2, long j8, long j9, int i4, Object obj) {
        long j10;
        long j11;
        long j12 = (i4 & 1) != 0 ? pomodoroSession.f126435a : j3;
        long j13 = (i4 & 2) != 0 ? pomodoroSession.f126436b : j4;
        long j14 = (i4 & 4) != 0 ? pomodoroSession.f126437c : j5;
        long j15 = (i4 & 8) != 0 ? pomodoroSession.f126438d : j6;
        long j16 = (i4 & 16) != 0 ? pomodoroSession.f126439f : j7;
        int i5 = (i4 & 32) != 0 ? pomodoroSession.f126440g : i3;
        boolean z3 = (i4 & 64) != 0 ? pomodoroSession.f126441h : z2;
        long j17 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? pomodoroSession.f126442i : j8;
        if ((i4 & Function.MAX_NARGS) != 0) {
            j10 = pomodoroSession.f126443j;
            j11 = j12;
        } else {
            j10 = j9;
            j11 = j12;
        }
        return pomodoroSession.a(j11, j13, j14, j15, j16, i5, z3, j17, j10);
    }

    private final Long i() {
        long j3 = this.f126443j;
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        if (j3 < timeHelperExt.f()) {
            return null;
        }
        long jF = timeHelperExt.f() - e();
        long j4 = this.f126438d + this.f126439f;
        long j5 = jF % j4;
        return Long.valueOf(j5 + (j4 & (((j5 ^ j4) & ((-j5) | j5)) >> 63)));
    }

    private final long s() {
        long j3 = this.f126438d;
        long j4 = this.f126439f;
        return ((j3 + j4) * ((long) this.f126440g)) - j4;
    }

    public final PomodoroSession a(long j3, long j4, long j5, long j6, long j7, int i3, boolean z2, long j8, long j9) {
        return new PomodoroSession(j3, j4, j5, j6, j7, i3, z2, j8, j9);
    }

    public final int c() {
        return (int) ((TimeHelperExt.f128663a.f() - e()) / (this.f126438d + this.f126439f));
    }

    public final long d() {
        return this.f126443j;
    }

    public final long e() {
        return this.f126443j - s();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PomodoroSession)) {
            return false;
        }
        PomodoroSession pomodoroSession = (PomodoroSession) obj;
        return this.f126435a == pomodoroSession.f126435a && this.f126436b == pomodoroSession.f126436b && this.f126437c == pomodoroSession.f126437c && this.f126438d == pomodoroSession.f126438d && this.f126439f == pomodoroSession.f126439f && this.f126440g == pomodoroSession.f126440g && this.f126441h == pomodoroSession.f126441h && this.f126442i == pomodoroSession.f126442i && this.f126443j == pomodoroSession.f126443j;
    }

    public final List f() {
        if (this.f126443j < TimeHelperExt.f128663a.f()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i3 = this.f126440g;
        for (int i4 = 0; i4 < i3; i4++) {
            long jE = e() + (((long) i4) * (this.f126438d + this.f126439f));
            arrayList.add(TuplesKt.a(new SessionMode.Focus(this.f126438d), Long.valueOf(jE)));
            if (i4 == this.f126440g - 1) {
                break;
            }
            arrayList.add(TuplesKt.a(new SessionMode.Break(this.f126439f), Long.valueOf(jE + this.f126438d)));
        }
        return arrayList;
    }

    public final long g() {
        return this.f126439f;
    }

    public final long h() {
        long jF = TimeHelperExt.f128663a.f() - e();
        long j3 = this.f126438d;
        long j4 = this.f126439f;
        long j5 = j3 + j4;
        long j6 = jF % j5;
        long j7 = jF / (j4 + j3);
        if (j6 + (j5 & (((j6 ^ j5) & ((-j6) | j6)) >> 63)) < j3) {
            long jE = e();
            long j8 = this.f126438d;
            return jE + (j7 * (this.f126439f + j8)) + j8;
        }
        long jE2 = e();
        long j9 = this.f126438d;
        long j10 = this.f126439f;
        return jE2 + (j7 * (j9 + j10)) + j9 + j10;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.f126435a) * 31) + Long.hashCode(this.f126436b)) * 31) + Long.hashCode(this.f126437c)) * 31) + Long.hashCode(this.f126438d)) * 31) + Long.hashCode(this.f126439f)) * 31) + Integer.hashCode(this.f126440g)) * 31) + Boolean.hashCode(this.f126441h)) * 31) + Long.hashCode(this.f126442i)) * 31) + Long.hashCode(this.f126443j);
    }

    public final SessionMode j() {
        long jR = r();
        return u() ? new SessionMode.Focus(jR) : new SessionMode.Break(jR);
    }

    public final long k() {
        return this.f126438d;
    }

    public final long l() {
        return this.f126435a;
    }

    public final long m() {
        return this.f126443j;
    }

    public final long n() {
        return this.f126442i;
    }

    public final long o() {
        return this.f126437c;
    }

    public final long p() {
        return this.f126436b;
    }

    public final int q() {
        return this.f126440g;
    }

    public final long r() {
        Long lI = i();
        if (lI == null) {
            return 0L;
        }
        long jLongValue = lI.longValue();
        long j3 = this.f126438d;
        return jLongValue < j3 ? j3 - jLongValue : (this.f126439f + j3) - jLongValue;
    }

    public final boolean t() {
        return !this.f126441h && this.f126443j > TimeHelperExt.f128663a.f();
    }

    public String toString() {
        return "PomodoroSession(id=" + this.f126435a + ", profileId=" + this.f126436b + ", originalStartTime=" + this.f126437c + ", focusTime=" + this.f126438d + ", breakTime=" + this.f126439f + ", sessionCount=" + this.f126440g + ", isStoppedManually=" + this.f126441h + ", originalEndTime=" + this.f126442i + ", adjustedEndTime=" + this.f126443j + ", isCurrentlyActive=" + t() + ", isCurrentlyBlocking=" + u() + ")";
    }

    public final boolean u() {
        Long lI;
        return (this.f126441h || (lI = i()) == null || lI.longValue() >= this.f126438d) ? false : true;
    }

    public final boolean v() {
        return this.f126441h;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PomodoroSession(long j3, long j4, long j5, long j6, long j7, int i3, boolean z2, long j8, long j9, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int i5;
        long j10;
        long j11 = (i4 & 1) != 0 ? 0L : j3;
        boolean z3 = (i4 & 64) != 0 ? false : z2;
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i5 = i3;
            j10 = (j5 + ((j6 + j7) * ((long) i5))) - j7;
        } else {
            i5 = i3;
            j10 = j8;
        }
        this(j11, j4, j5, j6, j7, i5, z3, j10, (i4 & Function.MAX_NARGS) != 0 ? j10 : j9);
    }
}
