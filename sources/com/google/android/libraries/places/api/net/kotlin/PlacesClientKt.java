package com.google.android.libraries.places.api.net.kotlin;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PlacesClientKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @kotlin.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFetchPhoto(com.google.android.libraries.places.api.net.PlacesClient r4, com.google.android.libraries.places.api.model.PhotoMetadata r5, kotlin.jvm.functions.Function1<? super com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.FetchPhotoResponse> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.google.android.libraries.places.api.net.kotlin.zzi
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.libraries.places.api.net.kotlin.zzi r0 = (com.google.android.libraries.places.api.net.kotlin.zzi) r0
            int r1 = r0.f75431b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75431b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzi r0 = new com.google.android.libraries.places.api.net.kotlin.zzi
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f75430a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75431b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L5f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r7)
            com.google.android.gms.tasks.CancellationTokenSource r7 = new com.google.android.gms.tasks.CancellationTokenSource
            r7.<init>()
            com.google.android.libraries.places.api.net.FetchPhotoRequest$Builder r5 = com.google.android.libraries.places.api.net.FetchPhotoRequest.b(r5)
            com.google.android.gms.tasks.CancellationToken r2 = r7.getToken()
            r5.d(r2)
            r6.invoke(r5)
            com.google.android.libraries.places.api.net.FetchPhotoRequest r5 = r5.a()
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.a(r5, r6)
            java.lang.String r5 = "fetchPhoto(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75431b = r3
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.a(r4, r7, r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitFetchPhoto(com.google.android.libraries.places.api.net.PlacesClient, com.google.android.libraries.places.api.model.PhotoMetadata, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFetchResolvedPhotoUri(com.google.android.libraries.places.api.net.PlacesClient r4, com.google.android.libraries.places.api.model.PhotoMetadata r5, kotlin.jvm.functions.Function1<? super com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.google.android.libraries.places.api.net.kotlin.zzk
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.libraries.places.api.net.kotlin.zzk r0 = (com.google.android.libraries.places.api.net.kotlin.zzk) r0
            int r1 = r0.f75435b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75435b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzk r0 = new com.google.android.libraries.places.api.net.kotlin.zzk
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f75434a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75435b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L5f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r7)
            com.google.android.gms.tasks.CancellationTokenSource r7 = new com.google.android.gms.tasks.CancellationTokenSource
            r7.<init>()
            com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest$Builder r5 = com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.b(r5)
            com.google.android.gms.tasks.CancellationToken r2 = r7.getToken()
            r5.d(r2)
            r6.invoke(r5)
            com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest r5 = r5.a()
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.f(r5, r6)
            java.lang.String r5 = "fetchResolvedPhotoUri(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75435b = r3
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.a(r4, r7, r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitFetchResolvedPhotoUri(com.google.android.libraries.places.api.net.PlacesClient, com.google.android.libraries.places.api.model.PhotoMetadata, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFindAutocompletePredictions(com.google.android.libraries.places.api.net.PlacesClient r5, kotlin.jvm.functions.Function1<? super com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.google.android.libraries.places.api.net.kotlin.zzl
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.libraries.places.api.net.kotlin.zzl r0 = (com.google.android.libraries.places.api.net.kotlin.zzl) r0
            int r1 = r0.f75437b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75437b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzl r0 = new com.google.android.libraries.places.api.net.kotlin.zzl
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f75436a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75437b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L5f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            com.google.android.gms.tasks.CancellationTokenSource r7 = new com.google.android.gms.tasks.CancellationTokenSource
            r7.<init>()
            com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest$Builder r2 = com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.b()
            com.google.android.gms.tasks.CancellationToken r4 = r7.getToken()
            r2.d(r4)
            r6.invoke(r2)
            com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest r6 = r2.a()
            com.google.android.libraries.places.internal.zzmy r2 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r5 = r5.b(r6, r2)
            java.lang.String r6 = "findAutocompletePredictions(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r0.f75437b = r3
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.a(r5, r7, r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r5 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitFindAutocompletePredictions(com.google.android.libraries.places.api.net.PlacesClient, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @kotlin.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFindCurrentPlace(com.google.android.libraries.places.api.net.PlacesClient r4, java.util.List<? extends com.google.android.libraries.places.api.model.Place.Field> r5, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.FindCurrentPlaceResponse> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.google.android.libraries.places.api.net.kotlin.zzm
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.libraries.places.api.net.kotlin.zzm r0 = (com.google.android.libraries.places.api.net.kotlin.zzm) r0
            int r1 = r0.f75439b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75439b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzm r0 = new com.google.android.libraries.places.api.net.kotlin.zzm
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f75438a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75439b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L56
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            com.google.android.gms.tasks.CancellationTokenSource r6 = new com.google.android.gms.tasks.CancellationTokenSource
            r6.<init>()
            com.google.android.libraries.places.api.net.kotlin.zzc r2 = new com.google.android.libraries.places.api.net.kotlin.zzc
            r2.<init>()
            com.google.android.libraries.places.api.net.FindCurrentPlaceRequest r5 = com.google.android.libraries.places.api.net.kotlin.FindCurrentPlaceRequestKt.a(r5, r2)
            com.google.android.libraries.places.internal.zzmy r2 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.h(r5, r2)
            java.lang.String r5 = "findCurrentPlace(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75439b = r3
            java.lang.Object r6 = kotlinx.coroutines.tasks.TasksKt.a(r4, r6, r0)
            if (r6 != r1) goto L56
            return r1
        L56:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitFindCurrentPlace(com.google.android.libraries.places.api.net.PlacesClient, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitIsOpen(com.google.android.libraries.places.api.net.PlacesClient r4, com.google.android.libraries.places.api.model.Place r5, java.lang.Long r6, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.IsOpenResponse> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.google.android.libraries.places.api.net.kotlin.zzo
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.libraries.places.api.net.kotlin.zzo r0 = (com.google.android.libraries.places.api.net.kotlin.zzo) r0
            int r1 = r0.f75443b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75443b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzo r0 = new com.google.android.libraries.places.api.net.kotlin.zzo
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f75442a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75443b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L56
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r7)
            com.google.android.gms.tasks.CancellationTokenSource r7 = new com.google.android.gms.tasks.CancellationTokenSource
            r7.<init>()
            com.google.android.libraries.places.api.net.kotlin.zze r2 = new com.google.android.libraries.places.api.net.kotlin.zze
            r2.<init>()
            com.google.android.libraries.places.api.net.IsOpenRequest r5 = com.google.android.libraries.places.api.net.kotlin.IsOpenRequestKt.a(r5, r6, r2)
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.e(r5, r6)
            java.lang.String r5 = "isOpen(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75443b = r3
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.a(r4, r7, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitIsOpen(com.google.android.libraries.places.api.net.PlacesClient, com.google.android.libraries.places.api.model.Place, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitSearchByText(com.google.android.libraries.places.api.net.PlacesClient r4, java.lang.String r5, java.util.List<? extends com.google.android.libraries.places.api.model.Place.Field> r6, kotlin.jvm.functions.Function1<? super com.google.android.libraries.places.api.net.SearchByTextRequest.Builder, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.SearchByTextResponse> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof com.google.android.libraries.places.api.net.kotlin.zzp
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.libraries.places.api.net.kotlin.zzp r0 = (com.google.android.libraries.places.api.net.kotlin.zzp) r0
            int r1 = r0.f75445b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75445b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzp r0 = new com.google.android.libraries.places.api.net.kotlin.zzp
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f75444a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75445b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L5f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r8)
            com.google.android.gms.tasks.CancellationTokenSource r8 = new com.google.android.gms.tasks.CancellationTokenSource
            r8.<init>()
            com.google.android.libraries.places.api.net.SearchByTextRequest$Builder r5 = com.google.android.libraries.places.api.net.SearchByTextRequest.b(r5, r6)
            com.google.android.gms.tasks.CancellationToken r6 = r8.getToken()
            r5.e(r6)
            r7.invoke(r5)
            com.google.android.libraries.places.api.net.SearchByTextRequest r5 = r5.a()
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.d(r5, r6)
            java.lang.String r5 = "searchByText(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75445b = r3
            java.lang.Object r8 = kotlinx.coroutines.tasks.TasksKt.a(r4, r8, r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitSearchByText(com.google.android.libraries.places.api.net.PlacesClient, java.lang.String, java.util.List, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitSearchNearby(com.google.android.libraries.places.api.net.PlacesClient r4, com.google.android.libraries.places.api.model.LocationRestriction r5, java.util.List<? extends com.google.android.libraries.places.api.model.Place.Field> r6, kotlin.jvm.functions.Function1<? super com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.SearchNearbyResponse> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof com.google.android.libraries.places.api.net.kotlin.zzq
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.libraries.places.api.net.kotlin.zzq r0 = (com.google.android.libraries.places.api.net.kotlin.zzq) r0
            int r1 = r0.f75447b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75447b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzq r0 = new com.google.android.libraries.places.api.net.kotlin.zzq
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f75446a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75447b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L5f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r8)
            com.google.android.gms.tasks.CancellationTokenSource r8 = new com.google.android.gms.tasks.CancellationTokenSource
            r8.<init>()
            com.google.android.libraries.places.api.net.SearchNearbyRequest$Builder r5 = com.google.android.libraries.places.api.net.SearchNearbyRequest.b(r5, r6)
            com.google.android.gms.tasks.CancellationToken r6 = r8.getToken()
            r5.h(r6)
            r7.invoke(r5)
            com.google.android.libraries.places.api.net.SearchNearbyRequest r5 = r5.a()
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.j(r5, r6)
            java.lang.String r5 = "searchNearby(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75447b = r3
            java.lang.Object r8 = kotlinx.coroutines.tasks.TasksKt.a(r4, r8, r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitSearchNearby(com.google.android.libraries.places.api.net.PlacesClient, com.google.android.libraries.places.api.model.LocationRestriction, java.util.List, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFetchPlace(com.google.android.libraries.places.api.net.PlacesClient r4, java.lang.String r5, java.util.List<? extends com.google.android.libraries.places.api.model.Place.Field> r6, kotlin.jvm.functions.Function1<? super com.google.android.libraries.places.api.net.FetchPlaceRequest.Builder, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.FetchPlaceResponse> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof com.google.android.libraries.places.api.net.kotlin.zzj
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.libraries.places.api.net.kotlin.zzj r0 = (com.google.android.libraries.places.api.net.kotlin.zzj) r0
            int r1 = r0.f75433b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75433b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzj r0 = new com.google.android.libraries.places.api.net.kotlin.zzj
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f75432a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75433b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L5f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r8)
            com.google.android.gms.tasks.CancellationTokenSource r8 = new com.google.android.gms.tasks.CancellationTokenSource
            r8.<init>()
            com.google.android.libraries.places.api.net.FetchPlaceRequest$Builder r5 = com.google.android.libraries.places.api.net.FetchPlaceRequest.b(r5, r6)
            com.google.android.gms.tasks.CancellationToken r6 = r8.getToken()
            r5.b(r6)
            r7.invoke(r5)
            com.google.android.libraries.places.api.net.FetchPlaceRequest r5 = r5.a()
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.g(r5, r6)
            java.lang.String r5 = "fetchPlace(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75433b = r3
            java.lang.Object r8 = kotlinx.coroutines.tasks.TasksKt.a(r4, r8, r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            r4 = 0
            java.lang.String r4 = com.google.common.cache.LSNn.vfptEEmYY.nAogJCf
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitFetchPlace(com.google.android.libraries.places.api.net.PlacesClient, java.lang.String, java.util.List, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitIsOpen(com.google.android.libraries.places.api.net.PlacesClient r4, java.lang.String r5, java.lang.Long r6, kotlin.coroutines.Continuation<? super com.google.android.libraries.places.api.net.IsOpenResponse> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.google.android.libraries.places.api.net.kotlin.zzn
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.libraries.places.api.net.kotlin.zzn r0 = (com.google.android.libraries.places.api.net.kotlin.zzn) r0
            int r1 = r0.f75441b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f75441b = r1
            goto L18
        L13:
            com.google.android.libraries.places.api.net.kotlin.zzn r0 = new com.google.android.libraries.places.api.net.kotlin.zzn
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f75440a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f75441b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L56
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r7)
            com.google.android.gms.tasks.CancellationTokenSource r7 = new com.google.android.gms.tasks.CancellationTokenSource
            r7.<init>()
            com.google.android.libraries.places.api.net.kotlin.zzd r2 = new com.google.android.libraries.places.api.net.kotlin.zzd
            r2.<init>()
            com.google.android.libraries.places.api.net.IsOpenRequest r5 = com.google.android.libraries.places.api.net.kotlin.IsOpenRequestKt.b(r5, r6, r2)
            com.google.android.libraries.places.internal.zzmy r6 = com.google.android.libraries.places.internal.zzmy.PROGRAMMATIC_KOTLIN_API
            com.google.android.gms.tasks.Task r4 = r4.e(r5, r6)
            java.lang.String r5 = "isOpen(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f75441b = r3
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.a(r4, r7, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.net.kotlin.PlacesClientKt.awaitIsOpen(com.google.android.libraries.places.api.net.PlacesClient, java.lang.String, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
