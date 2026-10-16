package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.preferences.core.PreferencesKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TrialConversionDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124669d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124670f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrialConversionDataStore(Context context) {
        super(context, "TRIAL_CONVERSION", null, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124668c = m(DataStoreKeysKt.O4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.lc
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(TrialConversionDataStore.G());
            }
        });
        this.f124669d = m(DataStoreKeysKt.T4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.mc
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TrialConversionDataStore.H());
            }
        });
        this.f124670f = m(DataStoreKeysKt.S4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.nc
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TrialConversionDataStore.A());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long G() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H() {
        return false;
    }

    public final Object B(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.P4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object C(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.S4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object D(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.T4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object E(String str, long j3, Continuation continuation) {
        Object objA = PreferencesKt.a(l(), new TrialConversionDataStore$setWatchedTrial$2(str, j3, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore$state$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore$state$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore$state$1) r0
            int r1 = r0.f124679c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124679c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore$state$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore$state$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f124677a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124679c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r10)
            goto L45
        L29:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L31:
            kotlin.ResultKt.b(r10)
            androidx.datastore.core.DataStore r10 = r9.l()
            kotlinx.coroutines.flow.Flow r10 = r10.getData()
            r0.f124679c = r3
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r0)
            if (r10 != r1) goto L45
            return r1
        L45:
            androidx.datastore.preferences.core.Preferences r10 = (androidx.datastore.preferences.core.Preferences) r10
            cz.mobilesoft.coreblock.storage.datastore.TrialConversionState r0 = new cz.mobilesoft.coreblock.storage.datastore.TrialConversionState
            androidx.datastore.preferences.core.Preferences$Key r1 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.R4()
            java.lang.Object r1 = r10.c(r1)
            java.lang.String r1 = (java.lang.String) r1
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.O4()
            java.lang.Object r2 = r10.c(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L64
            long r2 = r2.longValue()
            goto L66
        L64:
            r2 = 0
        L66:
            androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.T4()
            java.lang.Object r4 = r10.c(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            r5 = 0
            if (r4 == 0) goto L78
            boolean r4 = r4.booleanValue()
            goto L79
        L78:
            r4 = r5
        L79:
            androidx.datastore.preferences.core.Preferences$Key r6 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.S4()
            java.lang.Object r6 = r10.c(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r6 == 0) goto L8a
            boolean r6 = r6.booleanValue()
            goto L8b
        L8a:
            r6 = r5
        L8b:
            androidx.datastore.preferences.core.Preferences$Key r7 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.P4()
            java.lang.Object r10 = r10.c(r7)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto L9b
            boolean r5 = r10.booleanValue()
        L9b:
            r8 = r6
            r6 = r5
            r5 = r8
            r0.<init>(r1, r2, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore.F(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object w(Continuation continuation) {
        return PreferencesKt.a(l(), new TrialConversionDataStore$clear$2(null), continuation);
    }

    public final Flow x() {
        return (Flow) this.f124670f.getValue();
    }

    public final Flow y() {
        return (Flow) this.f124668c.getValue();
    }

    public final Flow z() {
        return (Flow) this.f124669d.getValue();
    }
}
