package com.superwall.sdk.web;

import android.content.Context;
import android.net.Uri;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.stetho.common.Utf8Charset;
import com.superwall.sdk.deeplinks.DeepLinkRouterKt;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.IOScope;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

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
public final class DeepLinkReferrer implements CheckForReferral {
    private InstallReferrerClient referrerClient;
    private final IOScope scope;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ConnectionListener implements InstallReferrerStateListener {
        private final Function0<Unit> disconnected;
        private final Function1<Integer, Unit> finished;

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectionListener(Function1<? super Integer, Unit> finished, Function0<Unit> disconnected) {
            Intrinsics.checkNotNullParameter(finished, "finished");
            Intrinsics.checkNotNullParameter(disconnected, "disconnected");
            this.finished = finished;
            this.disconnected = disconnected;
        }

        public final Function0<Unit> getDisconnected() {
            return this.disconnected;
        }

        public final Function1<Integer, Unit> getFinished() {
            return this.finished;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
            this.disconnected.invoke();
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i3) {
            this.finished.invoke(Integer.valueOf(i3));
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.web.DeepLinkReferrer$tryConnecting$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.web.DeepLinkReferrer$tryConnecting$1", f = "DeepLinkReferrer.kt", l = {84}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $connect;
        final /* synthetic */ int $timeout;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.web.DeepLinkReferrer$tryConnecting$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.web.DeepLinkReferrer$tryConnecting$1$1", f = "DeepLinkReferrer.kt", l = {}, m = "invokeSuspend")
        static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $connect;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02551(Function0<Unit> function0, Continuation<? super C02551> continuation) {
                super(2, continuation);
                this.$connect = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02551(this.$connect, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$connect.invoke();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02551) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i3, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$timeout = i3;
            this.$connect = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$timeout, this.$connect, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Duration.Companion companion = Duration.f140631b;
                long jS = DurationKt.s(this.$timeout, DurationUnit.f140640d);
                C02551 c02551 = new C02551(this.$connect, null);
                this.label = 1;
                if (TimeoutKt.d(jS, c02551, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public DeepLinkReferrer(Function0<? extends Context> context, IOScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.referrerClient = InstallReferrerClient.newBuilder((Context) context.invoke()).build();
        tryConnecting$default(this, 0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InstallReferrerClient getReferrerClient() {
        InstallReferrerClient installReferrerClient = this.referrerClient;
        if (installReferrerClient == null || !installReferrerClient.isReady()) {
            return null;
        }
        return this.referrerClient;
    }

    private final Map<String, List<String>> getUrlParams(String str) {
        List listM = new Regex("\\?").m(str, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() < 2) {
            return MapsKt.emptyMap();
        }
        String str2 = (String) arrayList.get(1);
        List listListOf = CollectionsKt.listOf("item");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj2 : listListOf) {
            List listM2 = new Regex("&?" + ((String) obj2) + "=").m(str2, 0);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : listM2) {
                if (((String) obj3).length() > 0) {
                    arrayList2.add(obj3);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj4 = arrayList2.get(i3);
                i3++;
                arrayList3.add(URLDecoder.decode((String) obj4, Utf8Charset.NAME));
            }
            linkedHashMap.put(obj2, arrayList3);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ void tryConnecting$default(DeepLinkReferrer deepLinkReferrer, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        deepLinkReferrer.tryConnecting(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryConnecting$lambda$2(final DeepLinkReferrer deepLinkReferrer, final int i3) {
        InstallReferrerClient referrerClient = deepLinkReferrer.getReferrerClient();
        if (referrerClient == null) {
            return null;
        }
        referrerClient.startConnection(new ConnectionListener(new Function1() { // from class: com.superwall.sdk.web.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeepLinkReferrer.tryConnecting$lambda$2$lambda$0(this.f93780a, ((Integer) obj).intValue());
            }
        }, new Function0() { // from class: com.superwall.sdk.web.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeepLinkReferrer.tryConnecting$lambda$2$lambda$1(this.f93781a, i3);
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryConnecting$lambda$2$lambda$0(DeepLinkReferrer deepLinkReferrer, int i3) {
        ReferrerDetails installReferrer;
        if (i3 == 0) {
            InstallReferrerClient referrerClient = deepLinkReferrer.getReferrerClient();
            if (referrerClient != null && (installReferrer = referrerClient.getInstallReferrer()) != null) {
                installReferrer.getInstallReferrer();
            }
        } else {
            InstallReferrerClient referrerClient2 = deepLinkReferrer.getReferrerClient();
            if (referrerClient2 != null) {
                referrerClient2.endConnection();
            }
            deepLinkReferrer.referrerClient = null;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryConnecting$lambda$2$lambda$1(DeepLinkReferrer deepLinkReferrer, int i3) {
        deepLinkReferrer.tryConnecting(i3 + 1000);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.web.CheckForReferral
    /* JADX INFO: renamed from: checkForReferral-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1345checkForReferralIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$1 r0 = (com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$1 r0 = new com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            com.superwall.sdk.web.DeepLinkReferrer r0 = (com.superwall.sdk.web.DeepLinkReferrer) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2e
            goto L56
        L2e:
            r8 = move-exception
            goto L9a
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            kotlin.ResultKt.b(r8)
            kotlin.time.Duration$Companion r8 = kotlin.time.Duration.f140631b     // Catch: java.lang.Throwable -> L2e
            kotlin.time.DurationUnit r8 = kotlin.time.DurationUnit.f140641f     // Catch: java.lang.Throwable -> L2e
            r2 = 30
            long r5 = kotlin.time.DurationKt.s(r2, r8)     // Catch: java.lang.Throwable -> L2e
            com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$2 r8 = new com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$2     // Catch: java.lang.Throwable -> L2e
            r8.<init>(r7, r4)     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L2e
            r0.label = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.f(r5, r8, r0)     // Catch: java.lang.Throwable -> L2e
            if (r8 != r1) goto L55
            return r1
        L55:
            r0 = r7
        L56:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L60
            java.util.Map r8 = r0.getUrlParams(r8)     // Catch: java.lang.Throwable -> L2e
            if (r8 != 0) goto L64
        L60:
            java.util.Map r8 = kotlin.collections.MapsKt.emptyMap()     // Catch: java.lang.Throwable -> L2e
        L64:
            java.lang.String r1 = "code"
            java.lang.Object r8 = r8.get(r1)     // Catch: java.lang.Throwable -> L2e
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L75
            java.lang.Object r8 = kotlin.collections.CollectionsKt.firstOrNull(r8)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L2e
            goto L76
        L75:
            r8 = r4
        L76:
            com.android.installreferrer.api.InstallReferrerClient r1 = r0.getReferrerClient()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L7f
            r1.endConnection()     // Catch: java.lang.Throwable -> L2e
        L7f:
            r0.referrerClient = r4     // Catch: java.lang.Throwable -> L2e
            if (r8 != 0) goto L95
            kotlin.Result$Companion r8 = kotlin.Result.f139772b     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            java.lang.String r0 = "Play store cannot connect"
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r8 = kotlin.ResultKt.a(r8)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L2e
            return r8
        L95:
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L2e
            return r8
        L9a:
            kotlin.Result$Companion r0 = kotlin.Result.f139772b
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.web.DeepLinkReferrer.mo1345checkForReferralIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.web.CheckForReferral
    /* JADX INFO: renamed from: handleDeepLink-IoAF18A */
    public Object mo1346handleDeepLinkIoAF18A(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Object redeemableCode = DeepLinkRouterKt.getRedeemableCode(url);
        if (Result.h(redeemableCode)) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.info, LogScope.webEntitlements, "Successfully extracted code from deep link", (Map) null, (Throwable) null, 24, (Object) null);
        }
        Throwable thE = Result.e(redeemableCode);
        if (thE != null) {
            Logger logger = Logger.INSTANCE;
            LogLevel logLevel = LogLevel.error;
            LogScope logScope = LogScope.webEntitlements;
            Pair pairA = TuplesKt.a("URL", url.toString());
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            Logger.debug$default(logger, logLevel, logScope, "Failed to extract code from deep link", MapsKt.mapOf(pairA, TuplesKt.a("Error", message)), (Throwable) null, 16, (Object) null);
        }
        return redeemableCode;
    }

    public final void tryConnecting(final int i3) {
        try {
            try {
                Function0 function0 = new Function0() { // from class: com.superwall.sdk.web.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeepLinkReferrer.tryConnecting$lambda$2(this.f93778a, i3);
                    }
                };
                if (i3 == 0) {
                    function0.invoke();
                } else {
                    BuildersKt__Builders_commonKt.d(this.scope, null, null, new AnonymousClass1(i3, function0, null), 3, null);
                }
            } catch (Throwable th) {
                Result.Companion companion = Result.f139772b;
                Result.b(ResultKt.a(th));
            }
        } catch (Throwable unused) {
            Result.Companion companion2 = Result.f139772b;
            InstallReferrerClient referrerClient = getReferrerClient();
            if (referrerClient != null) {
                referrerClient.endConnection();
            }
            this.referrerClient = null;
            Result.b(Unit.f139807a);
        }
    }
}
