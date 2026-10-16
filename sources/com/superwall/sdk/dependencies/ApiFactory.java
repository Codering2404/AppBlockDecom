package com.superwall.sdk.dependencies;

import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.identity.IdentityManager;
import com.superwall.sdk.misc.AppLifecycleObserver;
import com.superwall.sdk.network.Api;
import com.superwall.sdk.network.JsonFactory;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.storage.LocalStorage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.serialization.json.Json;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface ApiFactory extends JsonFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static Json json(ApiFactory apiFactory) {
            return JsonFactory.DefaultImpls.json(apiFactory);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object track(com.superwall.sdk.dependencies.ApiFactory r3, com.superwall.sdk.analytics.internal.trackable.Trackable r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
            /*
                boolean r3 = r5 instanceof com.superwall.sdk.dependencies.ApiFactory.AnonymousClass1
                if (r3 == 0) goto L13
                r3 = r5
                com.superwall.sdk.dependencies.ApiFactory$track$1 r3 = (com.superwall.sdk.dependencies.ApiFactory.AnonymousClass1) r3
                int r0 = r3.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r3.label = r0
                goto L18
            L13:
                com.superwall.sdk.dependencies.ApiFactory$track$1 r3 = new com.superwall.sdk.dependencies.ApiFactory$track$1
                r3.<init>(r5)
            L18:
                java.lang.Object r5 = r3.result
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L36
                if (r1 != r2) goto L2e
                kotlin.ResultKt.b(r5)
                kotlin.Result r5 = (kotlin.Result) r5
                r5.j()
                goto L48
            L2e:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L36:
                kotlin.ResultKt.b(r5)
                com.superwall.sdk.Superwall$Companion r5 = com.superwall.sdk.Superwall.Companion
                com.superwall.sdk.Superwall r5 = r5.getInstance()
                r3.label = r2
                java.lang.Object r3 = com.superwall.sdk.analytics.internal.TrackingKt.track(r5, r4, r3)
                if (r3 != r0) goto L48
                return r0
            L48:
                kotlin.Unit r3 = kotlin.Unit.f139807a
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.dependencies.ApiFactory.DefaultImpls.track(com.superwall.sdk.dependencies.ApiFactory, com.superwall.sdk.analytics.internal.trackable.Trackable, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.dependencies.ApiFactory$track$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.dependencies.ApiFactory$DefaultImpls", f = "FactoryProtocols.kt", l = {66}, m = "track")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.track(null, null, this);
        }
    }

    Api getApi();

    AppLifecycleObserver getAppLifecycleObserver();

    ConfigManager getConfigManager();

    DeviceHelper getDeviceHelper();

    IdentityManager getIdentityManager();

    LocalStorage getStorage();

    Object makeHeaders(boolean z2, String str, Continuation<? super Map<String, String>> continuation);

    void setApi(Api api);

    void setAppLifecycleObserver(AppLifecycleObserver appLifecycleObserver);

    void setConfigManager(ConfigManager configManager);

    void setDeviceHelper(DeviceHelper deviceHelper);

    void setIdentityManager(IdentityManager identityManager);

    void setStorage(LocalStorage localStorage);

    Object track(Trackable trackable, Continuation<? super Unit> continuation);
}
