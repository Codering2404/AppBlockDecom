package cz.mobilesoft.coreblock.util;

import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.DeeplinkResult;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class SingularCallbackHandler implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SingularCallbackHandler f127992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f127993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f127994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f127995d;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final SingularCallbackHandler singularCallbackHandler = new SingularCallbackHandler();
        f127992a = singularCallbackHandler;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f127993b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.util.SingularCallbackHandler$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = singularCallbackHandler;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f127994c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DeeplinkRouter>() { // from class: cz.mobilesoft.coreblock.util.SingularCallbackHandler$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = singularCallbackHandler;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DeeplinkRouter.class), objArr2, objArr3);
            }
        });
        f127995d = 8;
    }

    private SingularCallbackHandler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore b() {
        return (CoreDataStore) f127993b.getValue();
    }

    private final DeeplinkRouter c() {
        return (DeeplinkRouter) f127994c.getValue();
    }

    public final void d(Map attributionInfo) {
        Intrinsics.checkNotNullParameter(attributionInfo, "attributionInfo");
        Object obj = attributionInfo.get("network");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = attributionInfo.get("campaign_name");
        if (obj2 == null) {
            obj2 = attributionInfo.get("campaign");
        }
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = attributionInfo.get("source");
        CoroutinesHelperExtKt.d(new SingularCallbackHandler$onAttributionReceived$1(str, str2, obj3 instanceof String ? (String) obj3 : null, PrefManager.f126839a.r1(), null));
    }

    public final void e(String deeplink) {
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        if (c().j(deeplink) instanceof DeeplinkResult.Meta) {
            CoroutinesHelperExtKt.d(new SingularCallbackHandler$onDeeplinkReceived$1(PrefManager.f126839a.r1(), null));
        } else {
            CoroutinesHelperExtKt.d(new SingularCallbackHandler$onDeeplinkReceived$2(deeplink, null));
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
