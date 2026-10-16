package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.entity.OnboardingPaywallVariant;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
public final class PaywallDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124442d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124443f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallDataStore(Context context) {
        super(context, "PAYWALL", null, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124441c = n(DataStoreKeysKt.U1(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.l8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallDataStore.B((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallDataStore.C();
            }
        });
        this.f124442d = m(DataStoreKeysKt.c2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallDataStore.D();
            }
        });
        this.f124443f = m(DataStoreKeysKt.L1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallDataStore.A();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String A() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingPaywallVariant B(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return OnboardingPaywallVariant.Companion.a(id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String C() {
        return OnboardingPaywallVariant.Companion.b().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String D() {
        return "";
    }

    public final Object E(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.L1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object F(OnboardingPaywallVariant onboardingPaywallVariant, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.U1(), onboardingPaywallVariant.getId(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object G(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow x() {
        return (Flow) this.f124443f.getValue();
    }

    public final Flow y() {
        return (Flow) this.f124441c.getValue();
    }

    public final Flow z() {
        return (Flow) this.f124442d.getValue();
    }
}
