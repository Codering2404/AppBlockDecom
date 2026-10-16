package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$1$1", f = "DefaultPaywallView.kt", l = {100, 104}, m = "invokeSuspend")
final class DefaultPaywallViewKt$DefaultPaywallView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Bitmap> $appIconBitmap$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<List<Color>> $prominentColors$delegate;
    final /* synthetic */ List<Color> $providedProminentColors;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultPaywallViewKt$DefaultPaywallView$1$1(List<Color> list, MutableState<Bitmap> mutableState, MutableState<List<Color>> mutableState2, Context context, Continuation<? super DefaultPaywallViewKt$DefaultPaywallView$1$1> continuation) {
        super(2, continuation);
        this.$providedProminentColors = list;
        this.$appIconBitmap$delegate = mutableState;
        this.$prominentColors$delegate = mutableState2;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultPaywallViewKt$DefaultPaywallView$1$1(this.$providedProminentColors, this.$appIconBitmap$delegate, this.$prominentColors$delegate, this.$context, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (r12 == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r12 == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L6b
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1b:
            java.lang.Object r1 = r11.L$0
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L45
        L24:
            kotlin.ResultKt.b(r12)
            java.util.List<androidx.compose.ui.graphics.Color> r12 = r11.$providedProminentColors
            if (r12 != 0) goto L4b
            androidx.compose.runtime.MutableState<java.util.List<androidx.compose.ui.graphics.Color>> r1 = r11.$prominentColors$delegate
            com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor r4 = com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor.INSTANCE
            androidx.compose.runtime.MutableState<android.graphics.Bitmap> r12 = r11.$appIconBitmap$delegate
            android.graphics.Bitmap r5 = com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.access$DefaultPaywallView$lambda$3(r12)
            r11.L$0 = r1
            r11.label = r3
            r6 = 2
            r7 = 0
            r9 = 4
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor.getProminentColorsFromBitmap$default(r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L45
            goto L6a
        L45:
            java.util.List r12 = (java.util.List) r12
            com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.access$DefaultPaywallView$lambda$7(r1, r12)
            goto L4c
        L4b:
            r8 = r11
        L4c:
            androidx.compose.runtime.MutableState<android.graphics.Bitmap> r12 = r8.$appIconBitmap$delegate
            android.graphics.Bitmap r12 = com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.access$DefaultPaywallView$lambda$3(r12)
            if (r12 != 0) goto L72
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.a()
            com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$1$1$bitmap$1 r1 = new com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$1$1$bitmap$1
            android.content.Context r3 = r8.$context
            r4 = 0
            r1.<init>(r3, r4)
            r8.L$0 = r4
            r8.label = r2
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.g(r12, r1, r11)
            if (r12 != r0) goto L6b
        L6a:
            return r0
        L6b:
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12
            androidx.compose.runtime.MutableState<android.graphics.Bitmap> r0 = r8.$appIconBitmap$delegate
            com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.access$DefaultPaywallView$lambda$4(r0, r12)
        L72:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultPaywallViewKt$DefaultPaywallView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
