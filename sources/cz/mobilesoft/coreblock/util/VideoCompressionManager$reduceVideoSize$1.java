package cz.mobilesoft.coreblock.util;

import android.net.Uri;
import androidx.media3.transformer.ProgressHolder;
import androidx.media3.transformer.Transformer;
import cz.mobilesoft.coreblock.util.CompressionState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.VideoCompressionManager$reduceVideoSize$1", f = "VideoCompressionManager.kt", l = {80, 94, 129}, m = "invokeSuspend", v = 1)
final class VideoCompressionManager$reduceVideoSize$1 extends SuspendLambda implements Function2<ProducerScope<? super CompressionState>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f128094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f128095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f128096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f128097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f128098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private /* synthetic */ Object f128099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ VideoCompressionManager f128100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Uri f128101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ long f128102k;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.VideoCompressionManager$reduceVideoSize$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.VideoCompressionManager$reduceVideoSize$1$1", f = "VideoCompressionManager.kt", l = {124}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f128103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f128104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f128105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Transformer f128106d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ProducerScope f128107f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Transformer transformer, ProducerScope producerScope, Continuation continuation) {
            super(2, continuation);
            this.f128106d = transformer;
            this.f128107f = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128106d, this.f128107f, continuation);
            anonymousClass1.f128105c = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f128105c;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f128104b;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.b(obj);
            while (CoroutineScopeKt.h(coroutineScope)) {
                ProgressHolder progressHolder = new ProgressHolder();
                if (this.f128106d.I(progressHolder) == 2) {
                    ChannelResult.b(this.f128107f.h(new CompressionState.Loading(progressHolder.f48349a)));
                }
                this.f128105c = coroutineScope;
                this.f128103a = SpillingKt.a(progressHolder);
                this.f128104b = 1;
                if (DelayKt.b(300L, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoCompressionManager$reduceVideoSize$1(VideoCompressionManager videoCompressionManager, Uri uri, long j3, Continuation continuation) {
        super(2, continuation);
        this.f128100i = videoCompressionManager;
        this.f128101j = uri;
        this.f128102k = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Transformer transformer) {
        transformer.G();
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        VideoCompressionManager$reduceVideoSize$1 videoCompressionManager$reduceVideoSize$1 = new VideoCompressionManager$reduceVideoSize$1(this.f128100i, this.f128101j, this.f128102k, continuation);
        videoCompressionManager$reduceVideoSize$1.f128099h = obj;
        return videoCompressionManager$reduceVideoSize$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0138, code lost:
    
        if (kotlinx.coroutines.channels.ProduceKt.a(r1, r2, r12) != r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.VideoCompressionManager$reduceVideoSize$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((VideoCompressionManager$reduceVideoSize$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
