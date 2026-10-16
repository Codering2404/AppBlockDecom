package coil.intercept;

import coil.EventListener;
import coil.intercept.EngineInterceptor;
import coil.request.ImageRequest;
import coil.request.Options;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "coil.intercept.EngineInterceptor$transform$3", f = "EngineInterceptor.kt", l = {242}, m = "invokeSuspend")
final class EngineInterceptor$transform$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f55921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f55922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f55923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f55924d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f55925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f55926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ EngineInterceptor f55927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ EngineInterceptor.ExecuteResult f55928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Options f55929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ List f55930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ EventListener f55931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ImageRequest f55932m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EngineInterceptor$transform$3(EngineInterceptor engineInterceptor, EngineInterceptor.ExecuteResult executeResult, Options options, List list, EventListener eventListener, ImageRequest imageRequest, Continuation continuation) {
        super(2, continuation);
        this.f55927h = engineInterceptor;
        this.f55928i = executeResult;
        this.f55929j = options;
        this.f55930k = list;
        this.f55931l = eventListener;
        this.f55932m = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        EngineInterceptor$transform$3 engineInterceptor$transform$3 = new EngineInterceptor$transform$3(this.f55927h, this.f55928i, this.f55929j, this.f55930k, this.f55931l, this.f55932m, continuation);
        engineInterceptor$transform$3.f55926g = obj;
        return engineInterceptor$transform$3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0070 -> B:13:0x0073). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f55925f
            r2 = 1
            if (r1 == 0) goto L27
            if (r1 != r2) goto L1f
            int r1 = r10.f55924d
            int r3 = r10.f55923c
            java.lang.Object r4 = r10.f55922b
            coil.request.Options r4 = (coil.request.Options) r4
            java.lang.Object r5 = r10.f55921a
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r10.f55926g
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.b(r11)
            goto L73
        L1f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L27:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f55926g
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            coil.intercept.EngineInterceptor r1 = r10.f55927h
            coil.intercept.EngineInterceptor$ExecuteResult r3 = r10.f55928i
            android.graphics.drawable.Drawable r3 = r3.e()
            coil.request.Options r4 = r10.f55929j
            java.util.List r5 = r10.f55930k
            android.graphics.Bitmap r1 = coil.intercept.EngineInterceptor.a(r1, r3, r4, r5)
            coil.EventListener r3 = r10.f55931l
            coil.request.ImageRequest r4 = r10.f55932m
            r3.k(r4, r1)
            java.util.List r3 = r10.f55930k
            coil.request.Options r4 = r10.f55929j
            int r5 = r3.size()
            r6 = 0
            r9 = r6
            r6 = r11
            r11 = r1
            r1 = r5
            r5 = r3
            r3 = r9
        L54:
            if (r3 >= r1) goto L7a
            java.lang.Object r7 = r5.get(r3)
            coil.transform.Transformation r7 = (coil.transform.Transformation) r7
            coil.size.Size r8 = r4.o()
            r10.f55926g = r6
            r10.f55921a = r5
            r10.f55922b = r4
            r10.f55923c = r3
            r10.f55924d = r1
            r10.f55925f = r2
            java.lang.Object r11 = r7.b(r11, r8, r10)
            if (r11 != r0) goto L73
            return r0
        L73:
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            kotlinx.coroutines.CoroutineScopeKt.g(r6)
            int r3 = r3 + r2
            goto L54
        L7a:
            coil.EventListener r0 = r10.f55931l
            coil.request.ImageRequest r1 = r10.f55932m
            r0.o(r1, r11)
            coil.intercept.EngineInterceptor$ExecuteResult r2 = r10.f55928i
            coil.request.ImageRequest r0 = r10.f55932m
            android.content.Context r0 = r0.l()
            android.content.res.Resources r0 = r0.getResources()
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            r3.<init>(r0, r11)
            r7 = 14
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            coil.intercept.EngineInterceptor$ExecuteResult r11 = coil.intercept.EngineInterceptor.ExecuteResult.b(r2, r3, r4, r5, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor$transform$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((EngineInterceptor$transform$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
