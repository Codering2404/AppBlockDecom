package com.google.accompanist.web;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WebViewNavigator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f68915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableSharedFlow f68916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f68917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f68918d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    enum NavigationEvent {
        BACK,
        FORWARD,
        RELOAD,
        STOP_LOADING
    }

    public WebViewNavigator(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f68915a = coroutineScope;
        this.f68916b = SharedFlowKt.b(0, 0, null, 7, null);
        Boolean bool = Boolean.FALSE;
        this.f68917c = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f68918d = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
    }

    public final boolean b() {
        return ((Boolean) this.f68917c.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(android.webkit.WebView r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$1
            if (r0 == 0) goto L13
            r0 = r7
            com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$1 r0 = (com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$1) r0
            int r1 = r0.f68926c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f68926c = r1
            goto L18
        L13:
            com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$1 r0 = new com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f68924a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f68926c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            kotlin.ResultKt.b(r7)
            goto L47
        L31:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.c()
            com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2 r2 = new com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f68926c = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.web.WebViewNavigator.c(android.webkit.WebView, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void d(boolean z2) {
        this.f68917c.setValue(Boolean.valueOf(z2));
    }

    public final void e(boolean z2) {
        this.f68918d.setValue(Boolean.valueOf(z2));
    }
}
