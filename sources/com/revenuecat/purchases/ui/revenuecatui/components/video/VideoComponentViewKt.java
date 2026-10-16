package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Shape;
import com.revenuecat.purchases.paywalls.components.properties.VideoUrls;
import com.revenuecat.purchases.storage.FileRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class VideoComponentViewKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$cacheVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt", f = "VideoComponentView.kt", l = {183}, m = "cacheVideo")
    static final class C25371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C25371(Continuation<? super C25371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoComponentViewKt.cacheVideo(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void VideoComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle r40, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r41, androidx.compose.ui.Modifier r42, com.revenuecat.purchases.storage.FileRepository r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 1072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt.VideoComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, androidx.compose.ui.Modifier, com.revenuecat.purchases.storage.FileRepository, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape VideoComponentView$lambda$3(State<? extends Shape> state) {
        return (Shape) state.getValue();
    }

    private static final boolean VideoComponentView$lambda$5(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoComponentView$lambda$6(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean VideoComponentView$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoComponentView$lambda$9(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object cacheVideo(java.net.URL r4, com.revenuecat.purchases.models.Checksum r5, com.revenuecat.purchases.storage.FileRepository r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt.C25371
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$cacheVideo$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt.C25371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$cacheVideo$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$cacheVideo$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            java.net.URL r4 = (java.net.URL) r4
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Exception -> L2d
            goto L5b
        L2d:
            r5 = move-exception
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.b(r7)
            r0.L$0 = r4     // Catch: java.lang.Exception -> L2d
            r0.label = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r4 = r6.generateOrGetCachedFileURL(r4, r5, r0)     // Catch: java.lang.Exception -> L2d
            if (r4 != r1) goto L5b
            return r1
        L45:
            com.revenuecat.purchases.ui.revenuecatui.helpers.Logger r6 = com.revenuecat.purchases.ui.revenuecatui.helpers.Logger.INSTANCE
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Failed to cache video: "
            r7.append(r0)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r6.e(r4, r5)
        L5b:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt.cacheVideo(java.net.URL, com.revenuecat.purchases.models.Checksum, com.revenuecat.purchases.storage.FileRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ boolean isVisibleInViewport(Rect rect, int i3, int i4) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return rect.p() > 0.0f && rect.i() > 0.0f && rect.o() < ((float) i3) && rect.r() < ((float) i4);
    }

    private static final URI rememberVideoContentState(final VideoUrls videoUrls, final FileRepository fileRepository, Composer composer, int i3) {
        composer.a0(541496876);
        if (ComposerKt.M()) {
            ComposerKt.U(541496876, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.rememberVideoContentState (VideoComponentView.kt:140)");
        }
        Object[] objArr = {videoUrls.getUrl()};
        composer.a0(-494481958);
        int i4 = (i3 & 14) ^ 6;
        boolean z2 = true;
        boolean zI = ((i4 > 4 && composer.Z(videoUrls)) || (i3 & 6) == 4) | composer.I(fileRepository);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0<URI>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$videoUrl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final URI invoke() {
                    return VideoComponentViewKt.resolveVideoUrl(videoUrls, fileRepository);
                }
            };
            composer.w(objG);
        }
        composer.U();
        URI uri = (URI) RememberSaveableKt.e(objArr, null, null, (Function0) objG, composer, 0, 6);
        URL url = videoUrls.getUrl();
        composer.a0(-494476975);
        if ((i4 <= 4 || !composer.Z(videoUrls)) && (i3 & 6) != 4) {
            z2 = false;
        }
        boolean zI2 = composer.I(fileRepository) | z2;
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new VideoComponentViewKt$rememberVideoContentState$1$1(videoUrls, fileRepository, null);
            composer.w(objG2);
        }
        composer.U();
        EffectsKt.g(url, (Function2) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return uri;
    }

    public static final /* synthetic */ URI resolveVideoUrl(VideoUrls videoUrls, FileRepository repository) throws URISyntaxException {
        URI file;
        Intrinsics.checkNotNullParameter(videoUrls, "videoUrls");
        Intrinsics.checkNotNullParameter(repository, "repository");
        URI file2 = repository.getFile(videoUrls.getUrl(), videoUrls.getChecksum());
        if (file2 != null) {
            return file2;
        }
        URL urlLowRes = videoUrls.getUrlLowRes();
        if (urlLowRes != null) {
            if (Intrinsics.areEqual(urlLowRes, videoUrls.getUrl())) {
                urlLowRes = null;
            }
            if (urlLowRes != null && (file = repository.getFile(urlLowRes, videoUrls.getChecksumLowRes())) != null) {
                return file;
            }
        }
        URI uri = videoUrls.getUrl().toURI();
        Intrinsics.checkNotNullExpressionValue(uri, "videoUrls.url.toURI()");
        return uri;
    }
}
