package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import com.google.gson.Gson;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesVersions;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class InAppUpdatesDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124402d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124407j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppUpdatesDataStore(Context context) {
        super(context, "IN_APP_UPDATES", null, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124401c = n(DataStoreKeysKt.W4(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.i7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InAppUpdatesDataStore.V((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InAppUpdatesDataStore.W();
            }
        });
        this.f124402d = m(DataStoreKeysKt.z0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(InAppUpdatesDataStore.M());
            }
        });
        this.f124403f = m(DataStoreKeysKt.O0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(InAppUpdatesDataStore.K());
            }
        });
        this.f124404g = m(DataStoreKeysKt.M0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(InAppUpdatesDataStore.I());
            }
        });
        this.f124405h = m(DataStoreKeysKt.N0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(InAppUpdatesDataStore.J());
            }
        });
        this.f124406i = m(DataStoreKeysKt.I0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(InAppUpdatesDataStore.B());
            }
        });
        this.f124407j = m(DataStoreKeysKt.O2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(InAppUpdatesDataStore.N());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long B() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long J() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long N() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdatesVersions V(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        InAppUpdatesVersions inAppUpdatesVersions = (InAppUpdatesVersions) new Gson().j(it, InAppUpdatesVersions.class);
        return inAppUpdatesVersions == null ? new InAppUpdatesVersions(CollectionsKt.emptyList()) : inAppUpdatesVersions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String W() {
        return "{\"versions\":[]}";
    }

    public final Flow C() {
        return (Flow) this.f124406i.getValue();
    }

    public final Flow D() {
        return (Flow) this.f124404g.getValue();
    }

    public final Flow E() {
        return (Flow) this.f124405h.getValue();
    }

    public final Flow F() {
        return (Flow) this.f124403f.getValue();
    }

    public final Flow G() {
        return (Flow) this.f124407j.getValue();
    }

    public final Flow H() {
        return (Flow) this.f124401c.getValue();
    }

    public final Flow L() {
        return (Flow) this.f124402d.getValue();
    }

    public final Object O(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.I0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object P(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.M0(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Q(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.N0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object R(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.O0(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object S(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.z0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object T(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.O2(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object U(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.W4(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }
}
