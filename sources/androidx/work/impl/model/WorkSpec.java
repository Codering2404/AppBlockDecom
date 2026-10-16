package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkInfo;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.billing.BillingClientUseCaseKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WorkSpec {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f55010x = new Companion(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f55011y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Function f55012z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WorkInfo.State f55014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f55015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f55016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Data f55017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Data f55018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f55019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f55020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f55021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Constraints f55022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f55023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BackoffPolicy f55024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f55026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f55027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f55028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f55029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OutOfQuotaPolicy f55030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f55031s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f55032t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f55033u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f55034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f55035w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(boolean z2, int i3, BackoffPolicy backoffPolicy, long j3, long j4, int i4, boolean z3, long j5, long j6, long j7, long j8) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            if (j8 != Long.MAX_VALUE && z3) {
                return i4 == 0 ? j8 : RangesKt.g(j8, BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS + j4);
            }
            if (z2) {
                return RangesKt.l(backoffPolicy == BackoffPolicy.LINEAR ? j3 * ((long) i3) : (long) Math.scalb(j3, i3 - 1), 18000000L) + j4;
            }
            if (z3) {
                long j9 = i4 == 0 ? j4 + j5 : j4 + j7;
                return (j6 == j7 || i4 != 0) ? j9 : j9 + (j7 - j6);
            }
            if (j4 == -1) {
                return Long.MAX_VALUE;
            }
            return j4 + j5;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IdAndState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f55036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WorkInfo.State f55037b;

        public IdAndState(String id, WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            this.f55036a = id;
            this.f55037b = state;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return Intrinsics.areEqual(this.f55036a, idAndState.f55036a) && this.f55037b == idAndState.f55037b;
        }

        public int hashCode() {
            return (this.f55036a.hashCode() * 31) + this.f55037b.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.f55036a + ", state=" + this.f55037b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WorkInfoPojo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f55038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WorkInfo.State f55039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Data f55040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f55041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f55042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f55043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Constraints f55044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f55045h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private BackoffPolicy f55046i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f55047j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f55048k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f55049l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f55050m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final long f55051n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f55052o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final List f55053p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final List f55054q;

        public WorkInfoPojo(String id, WorkInfo.State state, Data output, long j3, long j4, long j5, Constraints constraints, int i3, BackoffPolicy backoffPolicy, long j6, long j7, int i4, int i5, long j8, int i6, List tags, List progress) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.f55038a = id;
            this.f55039b = state;
            this.f55040c = output;
            this.f55041d = j3;
            this.f55042e = j4;
            this.f55043f = j5;
            this.f55044g = constraints;
            this.f55045h = i3;
            this.f55046i = backoffPolicy;
            this.f55047j = j6;
            this.f55048k = j7;
            this.f55049l = i4;
            this.f55050m = i5;
            this.f55051n = j8;
            this.f55052o = i6;
            this.f55053p = tags;
            this.f55054q = progress;
        }

        private final long a() {
            if (this.f55039b == WorkInfo.State.ENQUEUED) {
                return WorkSpec.f55010x.a(c(), this.f55045h, this.f55046i, this.f55047j, this.f55048k, this.f55049l, d(), this.f55041d, this.f55043f, this.f55042e, this.f55051n);
            }
            return Long.MAX_VALUE;
        }

        private final WorkInfo.PeriodicityInfo b() {
            long j3 = this.f55042e;
            if (j3 != 0) {
                return new WorkInfo.PeriodicityInfo(j3, this.f55043f);
            }
            return null;
        }

        public final boolean c() {
            return this.f55039b == WorkInfo.State.ENQUEUED && this.f55045h > 0;
        }

        public final boolean d() {
            return this.f55042e != 0;
        }

        public final WorkInfo e() {
            Data progress = !this.f55054q.isEmpty() ? (Data) this.f55054q.get(0) : Data.f54509c;
            UUID uuidFromString = UUID.fromString(this.f55038a);
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(id)");
            WorkInfo.State state = this.f55039b;
            HashSet hashSet = new HashSet(this.f55053p);
            Data data = this.f55040c;
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            return new WorkInfo(uuidFromString, state, hashSet, data, progress, this.f55045h, this.f55050m, this.f55044g, this.f55041d, b(), a(), this.f55052o);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return Intrinsics.areEqual(this.f55038a, workInfoPojo.f55038a) && this.f55039b == workInfoPojo.f55039b && Intrinsics.areEqual(this.f55040c, workInfoPojo.f55040c) && this.f55041d == workInfoPojo.f55041d && this.f55042e == workInfoPojo.f55042e && this.f55043f == workInfoPojo.f55043f && Intrinsics.areEqual(this.f55044g, workInfoPojo.f55044g) && this.f55045h == workInfoPojo.f55045h && this.f55046i == workInfoPojo.f55046i && this.f55047j == workInfoPojo.f55047j && this.f55048k == workInfoPojo.f55048k && this.f55049l == workInfoPojo.f55049l && this.f55050m == workInfoPojo.f55050m && this.f55051n == workInfoPojo.f55051n && this.f55052o == workInfoPojo.f55052o && Intrinsics.areEqual(this.f55053p, workInfoPojo.f55053p) && Intrinsics.areEqual(this.f55054q, workInfoPojo.f55054q);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.f55038a.hashCode() * 31) + this.f55039b.hashCode()) * 31) + this.f55040c.hashCode()) * 31) + Long.hashCode(this.f55041d)) * 31) + Long.hashCode(this.f55042e)) * 31) + Long.hashCode(this.f55043f)) * 31) + this.f55044g.hashCode()) * 31) + Integer.hashCode(this.f55045h)) * 31) + this.f55046i.hashCode()) * 31) + Long.hashCode(this.f55047j)) * 31) + Long.hashCode(this.f55048k)) * 31) + Integer.hashCode(this.f55049l)) * 31) + Integer.hashCode(this.f55050m)) * 31) + Long.hashCode(this.f55051n)) * 31) + Integer.hashCode(this.f55052o)) * 31) + this.f55053p.hashCode()) * 31) + this.f55054q.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.f55038a + ", state=" + this.f55039b + ", output=" + this.f55040c + ", initialDelay=" + this.f55041d + ", intervalDuration=" + this.f55042e + ", flexDuration=" + this.f55043f + ", constraints=" + this.f55044g + ", runAttemptCount=" + this.f55045h + ", backoffPolicy=" + this.f55046i + ", backoffDelayDuration=" + this.f55047j + ", lastEnqueueTime=" + this.f55048k + ", periodCount=" + this.f55049l + ", generation=" + this.f55050m + ", nextScheduleTimeOverride=" + this.f55051n + ", stopReason=" + this.f55052o + ", tags=" + this.f55053p + ", progress=" + this.f55054q + ')';
        }
    }

    static {
        String strI = Logger.i("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(strI, "tagWithPrefix(\"WorkSpec\")");
        f55011y = strI;
        f55012z = new Function() { // from class: androidx.work.impl.model.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return WorkSpec.b((List) obj);
            }
        };
    }

    public WorkSpec(String id, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long j3, long j4, long j5, Constraints constraints, int i3, BackoffPolicy backoffPolicy, long j6, long j7, long j8, long j9, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i4, int i5, long j10, int i6, int i7) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f55013a = id;
        this.f55014b = state;
        this.f55015c = workerClassName;
        this.f55016d = inputMergerClassName;
        this.f55017e = input;
        this.f55018f = output;
        this.f55019g = j3;
        this.f55020h = j4;
        this.f55021i = j5;
        this.f55022j = constraints;
        this.f55023k = i3;
        this.f55024l = backoffPolicy;
        this.f55025m = j6;
        this.f55026n = j7;
        this.f55027o = j8;
        this.f55028p = j9;
        this.f55029q = z2;
        this.f55030r = outOfQuotaPolicy;
        this.f55031s = i4;
        this.f55032t = i5;
        this.f55033u = j10;
        this.f55034v = i6;
        this.f55035w = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List b(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).e());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec e(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j3, long j4, long j5, Constraints constraints, int i3, BackoffPolicy backoffPolicy, long j6, long j7, long j8, long j9, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i4, int i5, long j10, int i6, int i7, int i8, Object obj) {
        String str4 = (i8 & 1) != 0 ? workSpec.f55013a : str;
        WorkInfo.State state2 = (i8 & 2) != 0 ? workSpec.f55014b : state;
        String str5 = (i8 & 4) != 0 ? workSpec.f55015c : str2;
        String str6 = (i8 & 8) != 0 ? workSpec.f55016d : str3;
        Data data3 = (i8 & 16) != 0 ? workSpec.f55017e : data;
        Data data4 = (i8 & 32) != 0 ? workSpec.f55018f : data2;
        long j11 = (i8 & 64) != 0 ? workSpec.f55019g : j3;
        long j12 = (i8 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? workSpec.f55020h : j4;
        long j13 = (i8 & com.sun.jna.Function.MAX_NARGS) != 0 ? workSpec.f55021i : j5;
        Constraints constraints2 = (i8 & 512) != 0 ? workSpec.f55022j : constraints;
        int i9 = (i8 & 1024) != 0 ? workSpec.f55023k : i3;
        String str7 = str4;
        BackoffPolicy backoffPolicy2 = (i8 & 2048) != 0 ? workSpec.f55024l : backoffPolicy;
        WorkInfo.State state3 = state2;
        long j14 = (i8 & 4096) != 0 ? workSpec.f55025m : j6;
        long j15 = (i8 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? workSpec.f55026n : j7;
        long j16 = (i8 & 16384) != 0 ? workSpec.f55027o : j8;
        long j17 = (i8 & 32768) != 0 ? workSpec.f55028p : j9;
        return workSpec.d(str7, state3, str5, str6, data3, data4, j11, j12, j13, constraints2, i9, backoffPolicy2, j14, j15, j16, j17, (i8 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? workSpec.f55029q : z2, (i8 & 131072) != 0 ? workSpec.f55030r : outOfQuotaPolicy, (i8 & 262144) != 0 ? workSpec.f55031s : i4, (i8 & 524288) != 0 ? workSpec.f55032t : i5, (i8 & 1048576) != 0 ? workSpec.f55033u : j10, (i8 & 2097152) != 0 ? workSpec.f55034v : i6, (i8 & 4194304) != 0 ? workSpec.f55035w : i7);
    }

    public final long c() {
        return f55010x.a(l(), this.f55023k, this.f55024l, this.f55025m, this.f55026n, this.f55031s, m(), this.f55019g, this.f55021i, this.f55020h, this.f55033u);
    }

    public final WorkSpec d(String str, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long j3, long j4, long j5, Constraints constraints, int i3, BackoffPolicy backoffPolicy, long j6, long j7, long j8, long j9, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i4, int i5, long j10, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, qRMDmh.ZsjVCBAf);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(str, state, workerClassName, inputMergerClassName, input, output, j3, j4, j5, constraints, i3, backoffPolicy, j6, j7, j8, j9, z2, outOfQuotaPolicy, i4, i5, j10, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return Intrinsics.areEqual(this.f55013a, workSpec.f55013a) && this.f55014b == workSpec.f55014b && Intrinsics.areEqual(this.f55015c, workSpec.f55015c) && Intrinsics.areEqual(this.f55016d, workSpec.f55016d) && Intrinsics.areEqual(this.f55017e, workSpec.f55017e) && Intrinsics.areEqual(this.f55018f, workSpec.f55018f) && this.f55019g == workSpec.f55019g && this.f55020h == workSpec.f55020h && this.f55021i == workSpec.f55021i && Intrinsics.areEqual(this.f55022j, workSpec.f55022j) && this.f55023k == workSpec.f55023k && this.f55024l == workSpec.f55024l && this.f55025m == workSpec.f55025m && this.f55026n == workSpec.f55026n && this.f55027o == workSpec.f55027o && this.f55028p == workSpec.f55028p && this.f55029q == workSpec.f55029q && this.f55030r == workSpec.f55030r && this.f55031s == workSpec.f55031s && this.f55032t == workSpec.f55032t && this.f55033u == workSpec.f55033u && this.f55034v == workSpec.f55034v && this.f55035w == workSpec.f55035w;
    }

    public final int f() {
        return this.f55032t;
    }

    public final long g() {
        return this.f55033u;
    }

    public final int h() {
        return this.f55034v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((this.f55013a.hashCode() * 31) + this.f55014b.hashCode()) * 31) + this.f55015c.hashCode()) * 31) + this.f55016d.hashCode()) * 31) + this.f55017e.hashCode()) * 31) + this.f55018f.hashCode()) * 31) + Long.hashCode(this.f55019g)) * 31) + Long.hashCode(this.f55020h)) * 31) + Long.hashCode(this.f55021i)) * 31) + this.f55022j.hashCode()) * 31) + Integer.hashCode(this.f55023k)) * 31) + this.f55024l.hashCode()) * 31) + Long.hashCode(this.f55025m)) * 31) + Long.hashCode(this.f55026n)) * 31) + Long.hashCode(this.f55027o)) * 31) + Long.hashCode(this.f55028p)) * 31;
        boolean z2 = this.f55029q;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        return ((((((((((((iHashCode + r12) * 31) + this.f55030r.hashCode()) * 31) + Integer.hashCode(this.f55031s)) * 31) + Integer.hashCode(this.f55032t)) * 31) + Long.hashCode(this.f55033u)) * 31) + Integer.hashCode(this.f55034v)) * 31) + Integer.hashCode(this.f55035w);
    }

    public final int i() {
        return this.f55031s;
    }

    public final int j() {
        return this.f55035w;
    }

    public final boolean k() {
        return !Intrinsics.areEqual(Constraints.f54480j, this.f55022j);
    }

    public final boolean l() {
        return this.f55014b == WorkInfo.State.ENQUEUED && this.f55023k > 0;
    }

    public final boolean m() {
        return this.f55020h != 0;
    }

    public final void n(long j3) {
        this.f55033u = j3;
    }

    public final void o(int i3) {
        this.f55034v = i3;
    }

    public final void p(long j3) {
        if (j3 < BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS) {
            Logger.e().k(f55011y, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        q(RangesKt.g(j3, BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS), RangesKt.g(j3, BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS));
    }

    public final void q(long j3, long j4) {
        if (j3 < BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS) {
            Logger.e().k(f55011y, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.f55020h = RangesKt.g(j3, BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS);
        if (j4 < 300000) {
            Logger.e().k(f55011y, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j4 > this.f55020h) {
            Logger.e().k(f55011y, "Flex duration greater than interval duration; Changed to " + j3);
        }
        this.f55021i = RangesKt.r(j4, 300000L, this.f55020h);
    }

    public String toString() {
        return "{WorkSpec: " + this.f55013a + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j3, long j4, long j5, Constraints constraints, int i3, BackoffPolicy backoffPolicy, long j6, long j7, long j8, long j9, boolean z2, OutOfQuotaPolicy outOfQuotaPolicy, int i4, int i5, long j10, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i8 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        if ((i8 & 8) != 0) {
            String name = OverwritingInputMerger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "OverwritingInputMerger::class.java.name");
            str4 = name;
        } else {
            str4 = str3;
        }
        if ((i8 & 16) != 0) {
            Data EMPTY = Data.f54509c;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i8 & 32) != 0) {
            Data EMPTY2 = Data.f54509c;
            Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, str4, data3, data4, (i8 & 64) != 0 ? 0L : j3, (i8 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0L : j4, (i8 & com.sun.jna.Function.MAX_NARGS) != 0 ? 0L : j5, (i8 & 512) != 0 ? Constraints.f54480j : constraints, (i8 & 1024) != 0 ? 0 : i3, (i8 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i8 & 4096) != 0 ? 30000L : j6, (i8 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? -1L : j7, (i8 & 16384) == 0 ? j8 : 0L, (32768 & i8) != 0 ? -1L : j9, (65536 & i8) != 0 ? false : z2, (131072 & i8) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i8) != 0 ? 0 : i4, (524288 & i8) != 0 ? 0 : i5, (1048576 & i8) != 0 ? Long.MAX_VALUE : j10, (2097152 & i8) != 0 ? 0 : i6, (i8 & 4194304) != 0 ? -256 : i7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String id, String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388602, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String newId, WorkSpec other) {
        this(newId, other.f55014b, other.f55015c, other.f55016d, new Data(other.f55017e), new Data(other.f55018f), other.f55019g, other.f55020h, other.f55021i, new Constraints(other.f55022j), other.f55023k, other.f55024l, other.f55025m, other.f55026n, other.f55027o, other.f55028p, other.f55029q, other.f55030r, other.f55031s, 0, other.f55033u, other.f55034v, other.f55035w, 524288, null);
        Intrinsics.checkNotNullParameter(newId, "newId");
        Intrinsics.checkNotNullParameter(other, "other");
    }
}
