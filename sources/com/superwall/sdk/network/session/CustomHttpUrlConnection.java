package com.superwall.sdk.network.session;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.misc.Task_RetryingKt;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.NetworkRequestData;
import com.superwall.sdk.network.RequestExecutor;
import com.superwall.sdk.network.RequestResult;
import com.superwall.sdk.network.RequestResultKt;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

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
public final class CustomHttpUrlConnection {
    private final List<Function1<RequestResult, RequestResult>> interceptors;
    private final Json json;
    private final RequestExecutor requestExecutor;

    /* JADX INFO: Add missing generic type declarations: [Response] */
    /* JADX INFO: renamed from: com.superwall.sdk.network.session.CustomHttpUrlConnection$request$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.session.CustomHttpUrlConnection$request$2", f = "CustomURLSession.kt", l = {33, 35}, m = "invokeSuspend")
    public static final class AnonymousClass2<Response> extends SuspendLambda implements Function1<Continuation<? super Either<? extends Response, NetworkError>>, Object> {
        final /* synthetic */ Function1<Continuation<? super NetworkRequestData<Response>>, Object> $buildRequestData;
        Object L$0;
        int label;
        final /* synthetic */ CustomHttpUrlConnection this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.network.session.CustomHttpUrlConnection$request$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AnonymousClass1 implements Function1<RequestResult, RequestResult> {
            final /* synthetic */ CustomHttpUrlConnection this$0;

            public AnonymousClass1(CustomHttpUrlConnection customHttpUrlConnection) {
                this.this$0 = customHttpUrlConnection;
            }

            @Override // kotlin.jvm.functions.Function1
            public final RequestResult invoke(RequestResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!this.this$0.getInterceptors().isEmpty()) {
                    Iterator<T> it2 = this.this$0.getInterceptors().iterator();
                    while (it2.hasNext()) {
                        it = (RequestResult) ((Function1) it2.next()).invoke(it);
                    }
                }
                return it;
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.network.session.CustomHttpUrlConnection$request$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class C02392 implements Function1<RequestResult, Either<? extends Response, NetworkError>> {
            final /* synthetic */ NetworkRequestData<Response> $requestData;
            final /* synthetic */ CustomHttpUrlConnection this$0;

            public C02392(CustomHttpUrlConnection customHttpUrlConnection, NetworkRequestData<Response> networkRequestData) {
                this.this$0 = customHttpUrlConnection;
                this.$requestData = networkRequestData;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Either<Response, NetworkError> invoke(RequestResult it) {
                String string;
                Intrinsics.checkNotNullParameter(it, "it");
                try {
                    Json json = this.this$0.getJson();
                    String responseMessage = it.getResponseMessage();
                    SerializersModule serializersModuleA = json.a();
                    Intrinsics.reifiedOperationMarker(6, GraphResponse.RESPONSE_LOG_TAG);
                    MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                    return new Either.Success(json.d(SerializersKt.d(serializersModuleA, null), responseMessage));
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger logger = Logger.INSTANCE;
                    LogLevel logLevel = LogLevel.error;
                    LogScope logScope = LogScope.network;
                    Pair pairA = TuplesKt.a("request", it.toString());
                    Pair pairA2 = TuplesKt.a("api_key", RequestResultKt.authHeader(it));
                    URI url = this.$requestData.getUrl();
                    if (url == null || (string = url.toString()) == null) {
                        string = "unknown";
                    }
                    Pair pairA3 = TuplesKt.a("url", string);
                    Intrinsics.reifiedOperationMarker(4, GraphResponse.RESPONSE_LOG_TAG);
                    Logger.debug$default(logger, logLevel, logScope, "Request Error", MapsKt.mapOf(pairA, pairA2, pairA3, TuplesKt.a("message", "Unable to decode response to type " + Reflection.b(Object.class).m() + " - " + th.getMessage()), TuplesKt.a(GraphRequest.DEBUG_SEVERITY_INFO, it.getResponseMessage()), TuplesKt.a("request_duration", Double.valueOf(it.getDuration()))), (Throwable) null, 16, (Object) null);
                    return new Either.Failure(new NetworkError.Decoding(th));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super Continuation<? super NetworkRequestData<Response>>, ? extends Object> function1, CustomHttpUrlConnection customHttpUrlConnection, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$buildRequestData = function1;
            this.this$0 = customHttpUrlConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            Intrinsics.needClassReification();
            return new AnonymousClass2(this.$buildRequestData, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            NetworkRequestData<?> networkRequestData;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Continuation<? super NetworkRequestData<Response>>, Object> function1 = this.$buildRequestData;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj != objF) {
                }
                return objF;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkRequestData = (NetworkRequestData) this.L$0;
                ResultKt.b(obj);
                Either map = EitherKt.map((Either) obj, new AnonymousClass1(this.this$0));
                Intrinsics.needClassReification();
                return EitherKt.flatMap(map, new C02392(this.this$0, networkRequestData));
            }
            ResultKt.b(obj);
            NetworkRequestData<?> networkRequestData2 = (NetworkRequestData) obj;
            RequestExecutor requestExecutor = this.this$0.getRequestExecutor();
            this.L$0 = networkRequestData2;
            this.label = 2;
            Object objExecute = requestExecutor.execute(networkRequestData2, this);
            if (objExecute != objF) {
                networkRequestData = networkRequestData2;
                obj = objExecute;
                Either map2 = EitherKt.map((Either) obj, new AnonymousClass1(this.this$0));
                Intrinsics.needClassReification();
                return EitherKt.flatMap(map2, new C02392(this.this$0, networkRequestData));
            }
            return objF;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            NetworkRequestData<?> networkRequestData = (NetworkRequestData) this.$buildRequestData.invoke(this);
            RequestExecutor requestExecutor = this.this$0.getRequestExecutor();
            InlineMarker.c(0);
            Object objExecute = requestExecutor.execute(networkRequestData, this);
            InlineMarker.c(1);
            Either map = EitherKt.map((Either) objExecute, new AnonymousClass1(this.this$0));
            Intrinsics.needClassReification();
            return EitherKt.flatMap(map, new C02392(this.this$0, networkRequestData));
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Either<? extends Response, NetworkError>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomHttpUrlConnection(Json json, RequestExecutor requestExecutor, List<? extends Function1<? super RequestResult, RequestResult>> interceptors) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(requestExecutor, "requestExecutor");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.json = json;
        this.requestExecutor = requestExecutor;
        this.interceptors = interceptors;
    }

    public static /* synthetic */ Object request$default(CustomHttpUrlConnection customHttpUrlConnection, Function1 function1, int i3, Function1 function12, Continuation continuation, int i4, Object obj) throws Throwable {
        if ((i4 & 4) != 0) {
            function12 = null;
        }
        Intrinsics.needClassReification();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(function1, customHttpUrlConnection, null);
        InlineMarker.c(0);
        Object objRetrying = Task_RetryingKt.retrying(i3, function12, anonymousClass2, continuation);
        InlineMarker.c(1);
        return objRetrying;
    }

    public final List<Function1<RequestResult, RequestResult>> getInterceptors() {
        return this.interceptors;
    }

    public final Json getJson() {
        return this.json;
    }

    public final RequestExecutor getRequestExecutor() {
        return this.requestExecutor;
    }

    public final /* synthetic */ <Response> Object request(Function1<? super Continuation<? super NetworkRequestData<Response>>, ? extends Object> function1, int i3, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super Either<? extends Response, NetworkError>> continuation) throws Throwable {
        Intrinsics.needClassReification();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(function1, this, null);
        InlineMarker.c(0);
        Object objRetrying = Task_RetryingKt.retrying(i3, function12, anonymousClass2, continuation);
        InlineMarker.c(1);
        return objRetrying;
    }

    public /* synthetic */ CustomHttpUrlConnection(Json json, RequestExecutor requestExecutor, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, requestExecutor, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }
}
