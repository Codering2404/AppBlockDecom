package com.revenuecat.purchases.ui.revenuecatui.components.video;

import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.paywalls.components.properties.VideoUrls;
import com.revenuecat.purchases.storage.FileRepository;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1", f = "VideoComponentView.kt", l = {}, m = "invokeSuspend")
final class VideoComponentViewKt$rememberVideoContentState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileRepository $repository;
    final /* synthetic */ VideoUrls $videoUrls;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1$1", f = "VideoComponentView.kt", l = {148}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileRepository $repository;
        final /* synthetic */ VideoUrls $videoUrls;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoUrls videoUrls, FileRepository fileRepository, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$videoUrls = videoUrls;
            this.$repository = fileRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$videoUrls, this.$repository, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                URL url = this.$videoUrls.getUrl();
                Checksum checksum = this.$videoUrls.getChecksum();
                FileRepository fileRepository = this.$repository;
                this.label = 1;
                if (VideoComponentViewKt.cacheVideo(url, checksum, fileRepository, this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoComponentViewKt$rememberVideoContentState$1$1(VideoUrls videoUrls, FileRepository fileRepository, Continuation<? super VideoComponentViewKt$rememberVideoContentState$1$1> continuation) {
        super(2, continuation);
        this.$videoUrls = videoUrls;
        this.$repository = fileRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoComponentViewKt$rememberVideoContentState$1$1 videoComponentViewKt$rememberVideoContentState$1$1 = new VideoComponentViewKt$rememberVideoContentState$1$1(this.$videoUrls, this.$repository, continuation);
        videoComponentViewKt$rememberVideoContentState$1$1.L$0 = obj;
        return videoComponentViewKt$rememberVideoContentState$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(this.$videoUrls, this.$repository, null), 3, null);
        URL urlLowRes = this.$videoUrls.getUrlLowRes();
        if (urlLowRes != null) {
            if (Intrinsics.areEqual(urlLowRes, this.$videoUrls.getUrl())) {
                urlLowRes = null;
            }
            if (urlLowRes != null) {
                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new VideoComponentViewKt$rememberVideoContentState$1$1$3$1(urlLowRes, this.$videoUrls, this.$repository, null), 3, null);
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoComponentViewKt$rememberVideoContentState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
