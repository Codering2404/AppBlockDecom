package com.superwall.sdk.network;

import com.facebook.GraphRequest;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.models.events.EventsResponse;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.NetworkRequestData;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.serialization.json.Json;

/* JADX INFO: renamed from: com.superwall.sdk.network.CollectorService$events$$inlined$post-7Yrd8eY$default$1, reason: invalid class name */
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
@DebugMetadata(c = "com.superwall.sdk.network.CollectorService$events$$inlined$post-7Yrd8eY$default$1", f = "CollectorService.kt", l = {35}, m = "invokeSuspend")
public final class CollectorService$events$$inlined$post7Yrd8eY$default$1 extends SuspendLambda implements Function1<Continuation<? super Either<? extends EventsResponse, NetworkError>>, Object> {
    final /* synthetic */ byte[] $body$inlined;
    final /* synthetic */ boolean $isForDebugging$inlined;
    final /* synthetic */ String $path$inlined;
    final /* synthetic */ String $requestId$inlined;
    final /* synthetic */ Duration $timeout$inlined;
    Object L$0;
    int label;
    final /* synthetic */ NetworkService this$0;
    final /* synthetic */ CustomHttpUrlConnection this$0$inline_fun;

    /* JADX INFO: renamed from: com.superwall.sdk.network.CollectorService$events$$inlined$post-7Yrd8eY$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Boolean, String, Continuation<? super Map<String, ? extends String>>, Object>, SuspendFunction {
        public AnonymousClass1(Object obj) {
            super(3, obj, NetworkService.class, "makeHeaders", "makeHeaders(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Boolean) obj).booleanValue(), (String) obj2, (Continuation<? super Map<String, String>>) obj3);
        }

        public final Object invoke(boolean z2, String str, Continuation<? super Map<String, String>> continuation) {
            return ((NetworkService) this.receiver).makeHeaders(z2, str, continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectorService$events$$inlined$post7Yrd8eY$default$1(CustomHttpUrlConnection customHttpUrlConnection, Continuation continuation, NetworkService networkService, String str, byte[] bArr, String str2, boolean z2, Duration duration) {
        super(1, continuation);
        this.this$0 = networkService;
        this.$path$inlined = str;
        this.$body$inlined = bArr;
        this.$requestId$inlined = str2;
        this.$isForDebugging$inlined = z2;
        this.$timeout$inlined = duration;
        this.this$0$inline_fun = customHttpUrlConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CollectorService$events$$inlined$post7Yrd8eY$default$1(this.this$0$inline_fun, continuation, this.this$0, this.$path$inlined, this.$body$inlined, this.$requestId$inlined, this.$isForDebugging$inlined, this.$timeout$inlined);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final NetworkRequestData<?> networkRequestData;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            NetworkRequestData<?> networkRequestData2 = new NetworkRequestData<>(new NetworkRequestData.Components(null, this.this$0.getHost(), this.this$0.getVersion() + this.$path$inlined, null, this.$body$inlined, 9, null), null, NetworkRequestData.HttpMethod.POST, this.$requestId$inlined, this.$isForDebugging$inlined, new AnonymousClass1(this.this$0), this.$timeout$inlined, 2, null);
            RequestExecutor requestExecutor = this.this$0$inline_fun.getRequestExecutor();
            this.L$0 = networkRequestData2;
            this.label = 1;
            obj = requestExecutor.execute(networkRequestData2, this);
            if (obj == objF) {
                return objF;
            }
            networkRequestData = networkRequestData2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            networkRequestData = (NetworkRequestData) this.L$0;
            ResultKt.b(obj);
        }
        final CustomHttpUrlConnection customHttpUrlConnection = this.this$0$inline_fun;
        Either map = EitherKt.map((Either) obj, new Function1<RequestResult, RequestResult>() { // from class: com.superwall.sdk.network.CollectorService$events$$inlined$post-7Yrd8eY$default$1.2
            @Override // kotlin.jvm.functions.Function1
            public final RequestResult invoke(RequestResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!customHttpUrlConnection.getInterceptors().isEmpty()) {
                    Iterator<T> it2 = customHttpUrlConnection.getInterceptors().iterator();
                    while (it2.hasNext()) {
                        it = (RequestResult) ((Function1) it2.next()).invoke(it);
                    }
                }
                return it;
            }
        });
        final CustomHttpUrlConnection customHttpUrlConnection2 = this.this$0$inline_fun;
        return EitherKt.flatMap(map, new Function1<RequestResult, Either<? extends EventsResponse, NetworkError>>() { // from class: com.superwall.sdk.network.CollectorService$events$$inlined$post-7Yrd8eY$default$1.3
            @Override // kotlin.jvm.functions.Function1
            public final Either<EventsResponse, NetworkError> invoke(RequestResult it) {
                String string;
                Intrinsics.checkNotNullParameter(it, "it");
                try {
                    Json json = customHttpUrlConnection2.getJson();
                    String responseMessage = it.getResponseMessage();
                    json.a();
                    return new Either.Success(json.d(EventsResponse.Companion.serializer(), responseMessage));
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger logger = Logger.INSTANCE;
                    LogLevel logLevel = LogLevel.error;
                    LogScope logScope = LogScope.network;
                    Pair pairA = TuplesKt.a("request", it.toString());
                    Pair pairA2 = TuplesKt.a("api_key", RequestResultKt.authHeader(it));
                    URI url = networkRequestData.getUrl();
                    if (url == null || (string = url.toString()) == null) {
                        string = "unknown";
                    }
                    Logger.debug$default(logger, logLevel, logScope, "Request Error", MapsKt.mapOf(pairA, pairA2, TuplesKt.a("url", string), TuplesKt.a("message", "Unable to decode response to type " + Reflection.b(EventsResponse.class).m() + " - " + th.getMessage()), TuplesKt.a(GraphRequest.DEBUG_SEVERITY_INFO, it.getResponseMessage()), TuplesKt.a("request_duration", Double.valueOf(it.getDuration()))), (Throwable) null, 16, (Object) null);
                    return new Either.Failure(new NetworkError.Decoding(th));
                }
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Either<? extends EventsResponse, NetworkError>> continuation) {
        return ((CollectorService$events$$inlined$post7Yrd8eY$default$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
