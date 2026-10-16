package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.gson.Gson;
import cz.mobilesoft.coreblock.storage.datastore.entity.QuickBlockTimerUpsellState;
import cz.mobilesoft.coreblock.storage.datastore.migration.QuickBlockPreferencesMigrationKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class QuickBlockDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f124444i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f124445j = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124447d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124450h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickBlockDataStore(Context context) {
        super(context, "QUICK_BLOCK_PREFERENCES", QuickBlockPreferencesMigrationKt.b(context), false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124446c = m(DataStoreKeysKt.h1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickBlockDataStore.E());
            }
        });
        this.f124447d = m(DataStoreKeysKt.i1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickBlockDataStore.G());
            }
        });
        this.f124448f = m(DataStoreKeysKt.g1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickBlockDataStore.C());
            }
        });
        this.f124449g = n(DataStoreKeysKt.o2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.s8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockDataStore.O((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QuickBlockDataStore.P();
            }
        });
        this.f124450h = m(DataStoreKeysKt.C3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickBlockDataStore.N());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G() {
        return false;
    }

    public static /* synthetic */ Object K(QuickBlockDataStore quickBlockDataStore, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return quickBlockDataStore.J(z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimerUpsellState O(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (QuickBlockTimerUpsellState) new Gson().j(it, QuickBlockTimerUpsellState.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String P() {
        return JsonUtils.EMPTY_JSON;
    }

    public final Flow A() {
        return (Flow) this.f124449g.getValue();
    }

    public final Flow B() {
        return (Flow) this.f124448f.getValue();
    }

    public final Flow D() {
        return (Flow) this.f124446c.getValue();
    }

    public final Flow F() {
        return (Flow) this.f124447d.getValue();
    }

    public final Object H(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object I(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.h1(), Boxing.a(true), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object J(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object L(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.C3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object M(QuickBlockTimerUpsellState quickBlockTimerUpsellState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.o2(), new Gson().s(quickBlockTimerUpsellState), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow z() {
        return (Flow) this.f124450h.getValue();
    }
}
