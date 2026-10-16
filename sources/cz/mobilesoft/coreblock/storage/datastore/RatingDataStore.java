package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import android.text.TextUtils;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKt;
import cz.mobilesoft.coreblock.activity.rating.LovedItRetryDecision;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.storage.datastore.migration.RatingDialogPreferencesMigrationKt;
import cz.mobilesoft.coreblock.util.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;

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
public final class RatingDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124468u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f124469a;

        static {
            int[] iArr = new int[LovedItRetryDecision.values().length];
            try {
                iArr[LovedItRetryDecision.Wait.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LovedItRetryDecision.Retry.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LovedItRetryDecision.NotPending.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f124469a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingDataStore(Context context) {
        super(context, "RATING_DIALOG_PREFERENCES", CollectionsKt.listOf(RatingDialogPreferencesMigrationKt.a(context)), false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124451c = m(DataStoreKeysKt.x2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(RatingDataStore.V0());
            }
        });
        this.f124452d = m(DataStoreKeysKt.w2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.U0());
            }
        });
        this.f124453f = n(DataStoreKeysKt.v2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.y8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RatingDataStore.M0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RatingDataStore.N0();
            }
        });
        this.f124454g = m(DataStoreKeysKt.m3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RatingDataStore.O0());
            }
        });
        this.f124455h = m(DataStoreKeysKt.E3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RatingDataStore.R0());
            }
        });
        this.f124456i = m(DataStoreKeysKt.D3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RatingDataStore.Q0());
            }
        });
        this.f124457j = m(DataStoreKeysKt.F3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RatingDataStore.S0());
            }
        });
        this.f124458k = m(DataStoreKeysKt.j5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.X0());
            }
        });
        this.f124459l = m(DataStoreKeysKt.i5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.n0());
            }
        });
        this.f124460m = m(DataStoreKeysKt.r2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(RatingDataStore.i0());
            }
        });
        this.f124461n = m(DataStoreKeysKt.u2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.l0());
            }
        });
        this.f124462o = m(DataStoreKeysKt.t2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.k0());
            }
        });
        this.f124463p = m(DataStoreKeysKt.s2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.j0());
            }
        });
        this.f124464q = m(DataStoreKeysKt.p2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RatingDataStore.p0());
            }
        });
        this.f124465r = m(DataStoreKeysKt.r1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(RatingDataStore.h0());
            }
        });
        this.f124466s = m(DataStoreKeysKt.G3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RatingDataStore.T0());
            }
        });
        this.f124467t = m(DataStoreKeysKt.w3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RatingDataStore.P0());
            }
        });
        this.f124468u = n(DataStoreKeysKt.q2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.o9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RatingDataStore.q0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RatingDataStore.s0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (s(r8, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I0(long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$setShownDate$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$setShownDate$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$setShownDate$1) r0
            int r1 = r0.f124497d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124497d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$setShownDate$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$setShownDate$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f124495b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124497d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            long r6 = r0.f124494a
            kotlin.ResultKt.b(r8)
            goto L48
        L3a:
            kotlin.ResultKt.b(r8)
            r0.f124494a = r6
            r0.f124497d = r4
            java.lang.Object r8 = r5.f0(r0)
            if (r8 != r1) goto L48
            goto L5a
        L48:
            androidx.datastore.preferences.core.Preferences$Key r8 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.x2()
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.e(r6)
            r0.f124494a = r6
            r0.f124497d = r3
            java.lang.Object r6 = r5.s(r8, r2, r0)
            if (r6 != r1) goto L5b
        L5a:
            return r1
        L5b:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.I0(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List M0(String daysString) {
        Intrinsics.checkNotNullParameter(daysString, "daysString");
        List listV0 = StringsKt.V0(daysString, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listV0, 10));
        Iterator it = listV0.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((String) it.next()));
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList == null ? Constants.f128443a : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q0() {
        return false;
    }

    private final Flow R() {
        return (Flow) this.f124460m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int U0() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long V0() {
        return 0L;
    }

    private final Flow X() {
        return (Flow) this.f124453f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X0() {
        return 0;
    }

    private final Flow c0() {
        return (Flow) this.f124452d.getValue();
    }

    private final Flow e0() {
        return (Flow) this.f124458k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r11 == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        if (s(r2, r4, r0) != r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f0(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementShownCount$1
            if (r0 == 0) goto L13
            r0 = r11
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementShownCount$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementShownCount$1) r0
            int r1 = r0.f124473d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124473d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementShownCount$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementShownCount$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f124471b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124473d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r11)
            goto L8b
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L37:
            kotlin.ResultKt.b(r11)
            goto L67
        L3b:
            kotlin.ResultKt.b(r11)
            goto L4f
        L3f:
            kotlin.ResultKt.b(r11)
            kotlinx.coroutines.flow.Flow r11 = r10.c0()
            r0.f124473d = r5
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.D(r11, r0)
            if (r11 != r1) goto L4f
            goto L8a
        L4f:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r2 = -1
            if (r11 != r2) goto L76
            kotlinx.coroutines.flow.Flow r2 = r10.d0()
            r0.f124470a = r11
            r0.f124473d = r4
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r11 != r1) goto L67
            goto L8a
        L67:
            java.lang.Number r11 = (java.lang.Number) r11
            long r6 = r11.longValue()
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 == 0) goto L74
            goto L75
        L74:
            r5 = 0
        L75:
            r11 = r5
        L76:
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.w2()
            int r4 = r11 + 1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r4)
            r0.f124470a = r11
            r0.f124473d = r3
            java.lang.Object r11 = r10.s(r2, r4, r0)
            if (r11 != r1) goto L8b
        L8a:
            return r1
        L8b:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.f0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j0() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k0() {
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n0() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(MutablePreferences mutablePreferences) {
        mutablePreferences.k(DataStoreKeysKt.x2(), -1L);
        mutablePreferences.j(DataStoreKeysKt.r2());
        mutablePreferences.j(DataStoreKeysKt.u2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p0() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogType q0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return RatingDialogType.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s0() {
        return RatingDialogType.Native.getRemoteConfigValue();
    }

    public final Object A0(List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.v2(), TextUtils.join(",", list), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object B0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.m3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object C0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.w3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object D0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.D3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object E0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.E3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object F0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.F3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object G0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.G3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object H0(long j3, RatingTriggerSource ratingTriggerSource, Continuation continuation) throws Throwable {
        if (j3 == -1) {
            Object objA = PreferencesKt.a(l(), new RatingDataStore$setShownDate$3(this, null), continuation);
            return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
        }
        if (ratingTriggerSource == RatingTriggerSource.WeeklyReport) {
            return Unit.f139807a;
        }
        Object objI0 = I0(j3, continuation);
        return objI0 == IntrinsicsKt.f() ? objI0 : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J0(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.J0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object K0(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.K0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L0(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$shouldShowRatingAfterCrash$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$shouldShowRatingAfterCrash$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$shouldShowRatingAfterCrash$1) r0
            int r1 = r0.f124516c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124516c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$shouldShowRatingAfterCrash$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$shouldShowRatingAfterCrash$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f124514a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124516c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.Flow r6 = r5.Q()
            r0.f124516c = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            java.lang.Number r6 = (java.lang.Number) r6
            long r0 = r6.longValue()
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r6 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            java.lang.Boolean r2 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L5a
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES
            r3 = 2
            long r2 = r2.toMillis(r3)
            goto L62
        L5a:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.DAYS
            r3 = 14
            long r2 = r2.toMillis(r3)
        L62:
            boolean r6 = r6.w(r0, r2)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.L0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow Q() {
        return (Flow) this.f124465r.getValue();
    }

    public final Flow S() {
        return (Flow) this.f124463p.getValue();
    }

    public final Flow T() {
        return (Flow) this.f124462o.getValue();
    }

    public final Flow U() {
        return (Flow) this.f124459l.getValue();
    }

    public final Flow V() {
        return (Flow) this.f124464q.getValue();
    }

    public final Flow W() {
        return (Flow) this.f124468u.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (androidx.datastore.preferences.core.PreferencesKt.a(r2, r4, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object W0(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$1) r0
            int r1 = r0.f124520d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124520d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124518b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124520d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L63
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            kotlin.ResultKt.b(r7)
            goto L48
        L38:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.Flow r7 = r6.S()
            r0.f124520d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L48
            goto L62
        L48:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            androidx.datastore.core.DataStore r2 = r6.l()
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$2 r4 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$startLovedItRetry$2
            r5 = 0
            r4.<init>(r7, r6, r5)
            r0.f124517a = r7
            r0.f124520d = r3
            java.lang.Object r7 = androidx.datastore.preferences.core.PreferencesKt.a(r2, r4, r0)
            if (r7 != r1) goto L63
        L62:
            return r1
        L63:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.W0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow Y() {
        return (Flow) this.f124456i.getValue();
    }

    public final Flow Z() {
        return (Flow) this.f124455h.getValue();
    }

    public final Flow a0() {
        return (Flow) this.f124457j.getValue();
    }

    public final Flow b0() {
        return (Flow) this.f124466s.getValue();
    }

    public final Flow d0() {
        return (Flow) this.f124451c.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r5.s(r2, r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g0(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementWeeklyReportShownCount$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementWeeklyReportShownCount$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementWeeklyReportShownCount$1) r0
            int r1 = r0.f124478f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124478f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementWeeklyReportShownCount$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$incrementWeeklyReportShownCount$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124476c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124478f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L72
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.f124475b
            androidx.datastore.preferences.core.Preferences$Key r2 = (androidx.datastore.preferences.core.Preferences.Key) r2
            java.lang.Object r5 = r0.f124474a
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore r5 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore) r5
            kotlin.ResultKt.b(r7)
            goto L59
        L40:
            kotlin.ResultKt.b(r7)
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.j5()
            kotlinx.coroutines.flow.Flow r7 = r6.e0()
            r0.f124474a = r6
            r0.f124475b = r2
            r0.f124478f = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L58
            goto L71
        L58:
            r5 = r6
        L59:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            int r7 = r7 + r4
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r7)
            r4 = 0
            r0.f124474a = r4
            r0.f124475b = r4
            r0.f124478f = r3
            java.lang.Object r7 = r5.s(r2, r7, r0)
            if (r7 != r1) goto L72
        L71:
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.g0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m0(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$lovedItRetryDecision$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$lovedItRetryDecision$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$lovedItRetryDecision$1) r0
            int r1 = r0.f124485h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124485h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$lovedItRetryDecision$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$lovedItRetryDecision$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f124483f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124485h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            long r1 = r0.f124480b
            java.lang.Object r3 = r0.f124482d
            java.util.concurrent.TimeUnit r3 = (java.util.concurrent.TimeUnit) r3
            java.lang.Object r0 = r0.f124481c
            java.util.concurrent.TimeUnit r0 = (java.util.concurrent.TimeUnit) r0
            kotlin.ResultKt.b(r9)
            r0 = r1
            goto L8b
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3f:
            kotlin.ResultKt.b(r9)
            goto L53
        L43:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.flow.Flow r9 = r8.R()
            r0.f124485h = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r0)
            if (r9 != r1) goto L53
            goto L87
        L53:
            java.lang.Number r9 = (java.lang.Number) r9
            long r4 = r9.longValue()
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L62
            cz.mobilesoft.coreblock.activity.rating.LovedItRetryDecision r9 = cz.mobilesoft.coreblock.activity.rating.LovedItRetryDecision.NotPending
            return r9
        L62:
            java.lang.Boolean r9 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L6d
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MINUTES
            goto L6f
        L6d:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.DAYS
        L6f:
            kotlinx.coroutines.flow.Flow r2 = r8.T()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f124481c = r6
            r0.f124482d = r9
            r0.f124479a = r4
            r0.f124480b = r4
            r0.f124485h = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L88
        L87:
            return r1
        L88:
            r3 = r9
            r9 = r0
            r0 = r4
        L8b:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            long r4 = (long) r9
            long r2 = r3.toMillis(r4)
            long r4 = java.lang.System.currentTimeMillis()
            cz.mobilesoft.coreblock.activity.rating.LovedItRetryDecision r9 = cz.mobilesoft.coreblock.activity.rating.LovedItRetryKt.a(r0, r2, r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.m0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (androidx.datastore.preferences.core.PreferencesKt.a(r2, r4, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t0(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$1) r0
            int r1 = r0.f124489d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124489d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124487b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124489d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L63
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            kotlin.ResultKt.b(r7)
            goto L48
        L38:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.Flow r7 = r6.S()
            r0.f124489d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L48
            goto L62
        L48:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            androidx.datastore.core.DataStore r2 = r6.l()
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$2 r4 = new cz.mobilesoft.coreblock.storage.datastore.RatingDataStore$recordLovedIt$2
            r5 = 0
            r4.<init>(r7, r6, r5)
            r0.f124486a = r7
            r0.f124489d = r3
            java.lang.Object r7 = androidx.datastore.preferences.core.PreferencesKt.a(r2, r4, r0)
            if (r7 != r1) goto L63
        L62:
            return r1
        L63:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.RatingDataStore.t0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object u0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.r1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object v0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.s2(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object w0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.t2(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object x0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i5(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object y0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.p2(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object z0(RatingDialogType ratingDialogType, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.q2(), ratingDialogType.getRemoteConfigValue(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String N0() {
        String strJoin = TextUtils.join(",", Constants.f128443a);
        Intrinsics.checkNotNullExpressionValue(strJoin, YvFRmou.sne);
        return strJoin;
    }
}
